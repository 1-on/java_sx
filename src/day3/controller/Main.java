package day3.controller;

import day1.ui.ExamFrame;
import day1.ui.RuleFrame;
import day1.ui.MainFrame;
import day1.ui.ScoreFrame;
import day3.dao.CourseDao;
import day3.dao.QuestionDao;
import day3.dao.ScoreDao;
import day3.dao.UserDao;
import day3.service.ExamService;
import day3.ui.LoginFrame;

/**
 * @author yi xian
 * @description
 * @date 2023/6/7 14:45
 */
public class Main {
    public static void main(String[] args) {
        // 界面
        LoginFrame loginFrame = new LoginFrame();
        MainFrame mainFrame = new MainFrame();
        ExamFrame examFrame = new ExamFrame();
        RuleFrame ruleFrame = new RuleFrame();
        ScoreFrame scoreFrame = new ScoreFrame();
        //控制器
        ClientContext context = new ClientContext();
        //业务模型
        ExamService service = new ExamService();
        //Dao
        UserDao userDao = new UserDao();
        CourseDao courseDao = new CourseDao();
        QuestionDao questionDao = new QuestionDao();
        ScoreDao scoreDao = new ScoreDao();

        // set方法的注入关系
        loginFrame.setContext(context);
        context.setLoginFrame(loginFrame);
        context.setMainFrame(mainFrame);
        context.setService(service);
        service.setDao(userDao);

        mainFrame.setContext(context);
        context.setExamFrame(examFrame);
        service.setCourseDao(courseDao);
        service.setQuestionDao(questionDao);
        examFrame.setContext(context);

        ruleFrame.setContext(context);
        context.setRuleFrame(ruleFrame);

        scoreFrame.setContext(context);
        context.setScoreFrame(scoreFrame);
        service.setScoreDao(scoreDao);


        loginFrame.setVisible(true);
    }
}
