package day3.controller;

import day1.ui.ExamFrame;
import day1.ui.RuleFrame;
import day1.ui.ScoreFrame;
import day3.entity.Course;
import day3.entity.Questioninfo;
import day3.entity.Score;
import day3.entity.User;
import day3.ui.LoginFrame;
import day1.ui.MainFrame;
import day3.service.ExamService;

import java.util.List;

/**
 * @author yi xian
 * @description
 * @date 2023/6/7 8:37
 */
public class ClientContext {
    private LoginFrame loginFrame;
    private ExamService service;
    private MainFrame mainFrame;
    private ExamFrame examFrame;
    private Course course;
    private RuleFrame ruleFrame;
    private ScoreFrame scoreFrame;
    private Score score;
    /*
    登录工作：view界面中得到账号密码
        将数据传递给业务模型
        将登录后的结果体现到界面中
     */
    private User login;

    public void login() {
        // 从界面中获得用户输入的账号
        String num = loginFrame.getInputNum();
        // 从界面中获得用户输入的密码
        String password = loginFrame.getInputPassword();
        // 调用业务模型的登录方法，把数据 传递过去
        try { //界面跳转
            login = service.login(num, password);
            loginFrame.setVisible(false);
            // 主界面显示
            mainFrame.setVisible(true);
            mainFrame.updateUI(login);
        } catch (Exception e) {
            loginFrame.showError(e.getMessage());
        }
    }

    public void exam() {
        // 第一个数据：登录的用户
        // 第二个数据：科目信息，调用业务模型获得
        course = service.start();
        // 第三个数据：试卷中的第一题
        Questioninfo firstQuestion = service.getQuestionInfo(1);
        // 数据都有了，可以更新界面了

        // -- 界面切换 --
        mainFrame.setVisible(false);
        examFrame.setVisible(true);
        // --数据的更新：将数据交给界面去设置 --
        examFrame.updateUI(login, course, firstQuestion);
    }

    public void score() {
        // 成绩数据
        score = service.score();
        course = service.start();
        // 界面切换
        mainFrame.setVisible(false);
        scoreFrame.setVisible(true);
        scoreFrame.updateUI(login,score,course);
    }

    public void rule() {
        mainFrame.setVisible(false);
        ruleFrame.setVisible(true);
    }

    public void backFromRule() {
        ruleFrame.setVisible(false);
        mainFrame.setVisible(true);
    }

    public void backFromScore() {
        scoreFrame.setVisible(false);
        mainFrame.setVisible(true);
    }

    public void quit() {
        System.exit(0);
    }

    /*
     * 题目的切换
     *
     */
    private int currentIndex = 1;   // 记录当前题目的题号

    public void next() {
        // 这道题的选项保存
        List<Integer> userAnswers = examFrame.getOptionValue(); // 从界面中获得选项
        service.saveAnswer(userAnswers, currentIndex);  //交给业务逻辑保存答案

        if (currentIndex < service.getNumQuestion()) {
            currentIndex++;
        }

        Questioninfo firstQuestion = service.getQuestionInfo(currentIndex);
        // ----题目的更新：将数据交给界面去设置 ----、// 还原下一道题的选项
        examFrame.updateQuestion(firstQuestion, currentIndex);
    }

    public void pre() {
        // 这道题的选项保存
        List<Integer> userAnswers = examFrame.getOptionValue(); // 从界面中获得选项
        service.saveAnswer(userAnswers, currentIndex);  //交给业务逻辑保存答案

        if (currentIndex > 1) {
            currentIndex--;
        }

        Questioninfo firstQuestion = service.getQuestionInfo(currentIndex);
        // ----题目的更新：将数据交给界面去设置 ----、// 还原下一道题的选项
        examFrame.updateQuestion(firstQuestion, currentIndex);
    }

    public void submit(int leftTime) {
        // 保存正在做的这道题的答案
        List<Integer> userAnswers = examFrame.getOptionValue(); // 从界面中获得选项
        service.saveAnswer(userAnswers, currentIndex);  //交给业务逻辑保存答案
        // 保存答案
        service.submit(login.getId(), course.getExamDuration(), leftTime);
        // 切换页面
        examFrame.setVisible(false);
        mainFrame.setVisible(true);

    }

    public void setLoginFrame(LoginFrame loginFrame) {
        this.loginFrame = loginFrame;
    }

    public void setService(ExamService service) {
        this.service = service;
    }

    public void setMainFrame(MainFrame mainFrame) {
        this.mainFrame = mainFrame;
    }

    public void setExamFrame(ExamFrame examFrame) {
        this.examFrame = examFrame;
    }

    public void setRuleFrame(RuleFrame ruleFrame) {
        this.ruleFrame = ruleFrame;
    }

    public void setScoreFrame(ScoreFrame scoreFrame) {
        this.scoreFrame = scoreFrame;
    }

    public void setScore(Score score) {
        this.score = score;
    }
}
