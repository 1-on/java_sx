package day3.service;

import day3.dao.CourseDao;
import day3.dao.QuestionDao;
import day3.dao.ScoreDao;
import day3.dao.UserDao;
import day3.entity.*;

import java.util.*;

/**
 * @author yi xian
 * @description
 * @date 2023/6/7 8:36
 */
public class ExamService {
    private UserDao dao;
    private CourseDao courseDao;
    private QuestionDao questionDao;
    private ScoreDao scoreDao;
    /*
    // 登录业务：得到控制器传递过来的数据（用户名，密码）
       将登陆成功的用户返回给控制器
       如果登录失败，将抛出异常
    */
    private User loginUser;

    public User login(String num, String password) throws Exception {

        dao = new UserDao();
        // 调用DAO方法
        User user = dao.selectByNumAndPwd(num, password);
        // 处理返回值
        if (user == null) {
            throw new Exception("账号/密码错误!");
        } else {
            return user;
        }
    }

    /*
     * 1.登录后的用户
     * 2.课程信息，科目信息
     * 3.试卷，里面包含虽有的题目（正确答案，用户的答案）
     *   集合（QuestionInfo）
     *       paper Map<Integer, QuestionInfo>
                key:Integer,表示在试卷中的题号
                value:QuestionInfo 表示试卷中的题目
     *  返回数据：用户信息（不需要返回），课程信息（正常返回）,第一题（获得某一题的功能）
     * 后续：上一题，下一题
     *
     * */
    //试卷
    private Map<Integer, Questioninfo> paper = new HashMap<>();

    public Course start() {
        // 1,登录后的用户 - 本身就存在 loginUser
        // 2.课程信息是从数据库查询出来的
        Course course = courseDao.selectById(1);
        // 3.生成试卷：
        // 3.1 把试卷从数据库中拿出来  Question
        List<Question> questions = questionDao.selectAll();
        // 3.2 把试卷变成QuestionInfo
        int index = 1;
        for (Question q : questions) {
            Questioninfo info = new Questioninfo(q);
            // 3,3 把QuestionInfo存到paper中
            paper.put(index++, info);
        }
        return course;
    }
    public Score score(){
        // 获取用户成绩信息
        return scoreDao.selectByUserid(1);
    }


    public void submit(int userid, int examDuration, int leftTime) {
        // 比较答案 得出分数
        int totalScore = 0;  //得分
        for (Questioninfo questioninfo : paper.values()) {
            Question question = questioninfo.getQuestion();
            List<Integer> userAnswers = questioninfo.getUserAnswers(); // 用户答案
            List<Integer> correctAnswers = new ArrayList<>();
            String answer = question.getAnswers();
            for (int i = 0; i < answer.length(); i++) {
                char c = answer.charAt(i);
                if (Character.isDigit(c)) {
                    int num = Character.getNumericValue(c);
                    correctAnswers.add(num);
                }
            }
            if (correctAnswers.equals(userAnswers)) {
                totalScore += question.getScore();
            }
        }
        System.out.println("分数：" + totalScore);

        // 保存到数据库
        scoreDao = new ScoreDao();
        // 考试时长 ：总时长-剩余时长
        int min = (examDuration * 60 - leftTime) / 60;
        int sec = (examDuration * 60 - leftTime) % 60;
        String examtime = Integer.toString(min) + '分' + Integer.toString(sec)+'秒';
        scoreDao.savaAnswers(1, userid, 1, examtime, totalScore);
    }

    // 提供一个获得试卷中某一题的功能 index:题号
    public Questioninfo getQuestionInfo(int index) {
        return paper.get(index);
    }

    public int getNumQuestion() {
        return paper.size();
    }

    /*
     * 保存答案
     *
     *
     */
    public void saveAnswer(List<Integer> userAnswers, int currentIndex) {
        paper.get(currentIndex).setUserAnswers(userAnswers);
    }

    public void setCourseDao(CourseDao courseDao) {
        this.courseDao = courseDao;
    }

    public void setQuestionDao(QuestionDao questionDao) {
        this.questionDao = questionDao;
    }

    public void setLoginUser(User loginUser) {
        this.loginUser = loginUser;
    }

    public void setDao(UserDao dao) {
        this.dao = dao;
    }

    public void setScoreDao(ScoreDao scoreDao) {
        this.scoreDao = scoreDao;
    }
}
