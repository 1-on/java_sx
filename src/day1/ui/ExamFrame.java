package day1.ui;

import day3.controller.ClientContext;
import day3.entity.Course;
import day3.entity.Question;
import day3.entity.Questioninfo;
import day3.entity.User;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

/**
 * @author yi xian
 * @description 考试界面
 * @date 2023/6/6 18:21
 */
public class ExamFrame extends JFrame {
    private int timeLeft = 10;
    private Timer timer;
    JLabel examInfoLabel;
    JLabel questCountLabel;
    JTextArea questArea;
    private ClientContext context;
    JLabel timerLabel;

    JCheckBox[] options = new JCheckBox[4];


    public ExamFrame() throws HeadlessException {
        init();
    }


    public void init() {
        setProperty();
        // 布局设置
        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBorder(new EmptyBorder(8, 8, 8, 8));

        //北边
        JLabel title = new JLabel("在线测评系统", JLabel.CENTER);
        mainPanel.add(title, BorderLayout.NORTH);

        //中间
        JPanel centerPanel = createCenterPanel();
        mainPanel.add(centerPanel, BorderLayout.CENTER);

        //南边
        JPanel southPanel = createSouthPanel();
        mainPanel.add(southPanel, BorderLayout.SOUTH);

        this.add(mainPanel);
    }

    private void setProperty() {
        // 设置属性
        this.setTitle("在线考试系统");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(600, 500);
        this.setLocationRelativeTo(null);
        ImageIcon icon = new ImageIcon("新一.jpg");
        this.setIconImage(icon.getImage());
    }

    private JPanel createCenterPanel() {
        JPanel centerPanel = new JPanel(new BorderLayout());
        // 考试信息
        examInfoLabel = new JLabel("考生：狗 时间120分钟", JLabel.LEFT);
        centerPanel.add(examInfoLabel, BorderLayout.NORTH);

        // 题目信息
        questArea = new JTextArea(10, 10);
        questArea.setEditable(false);
        questArea.append("我是狗？\nA：是\nB：不是\nC:不好说");
        centerPanel.add(questArea, BorderLayout.CENTER);

        // 选项
        JPanel panel = new JPanel();
        options[0] = new JCheckBox("A");
        options[1] = new JCheckBox("B");
        options[2] = new JCheckBox("C");
        options[3] = new JCheckBox("D");

        for (JCheckBox option : options) {
            panel.add(option);
        }


        centerPanel.add(panel, BorderLayout.SOUTH);
        return centerPanel;
    }

    private JPanel createSouthPanel() {
        JPanel panel = new JPanel(new BorderLayout());
        // 左侧信息
        questCountLabel = new JLabel("题目:10的1题", JLabel.LEFT);
        panel.add(questCountLabel, BorderLayout.WEST);

        // 中间按钮
        JPanel panel1 = new JPanel();
        JButton pre = new JButton("上一题");
        JButton next = new JButton("下一题");
        JButton submit = new JButton("交卷");

        ActionListener listener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String command = e.getActionCommand();
                switch (command) {
                    case "上一题" -> context.pre();
                    case "下一题" -> context.next();
                    case "交卷" -> context.submit(timeLeft);
                }
            }
        };
        pre.addActionListener(listener);
        next.addActionListener(listener);
        submit.addActionListener(listener);


        panel1.add(pre);
        panel1.add(next);
        panel1.add(submit);
        panel.add(panel1, BorderLayout.CENTER);
        // 右侧信息
        // 创建计时器并设置ActionListener
        timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                timeLeft--;
                if (timeLeft >= 0) {
                    timerLabel.setText("剩余时间：" + formatTime(timeLeft));

                } else {
                    timer.stop();
                    context.submit(timeLeft);
                    showMessageDialog();
                }
            }
        });
        timerLabel = new JLabel();
        panel.add(timerLabel, BorderLayout.EAST);

        return panel;
    }
    private void showMessageDialog() {
        JOptionPane.showMessageDialog(this, "时间到了，自动交卷！");
    }


    public void updateUI(User login, Course course, Questioninfo firstQuestion) {
        // 更新基础数据
        timeLeft = course.getExamDuration()*60;
        timer.start();
        String examInfo = "姓名：" + login.getName() + "  编号：" + login.getNum()
                + "  考试时间：" + course.getExamDuration() + "分钟  考试科目：" + course.getName() + "  题目数量:10";
        examInfoLabel.setText(examInfo);

        // 更新题目信息 firstQuestion试卷上的题目 Question
        Question q = firstQuestion.getQuestion();
        String ques = q.getTitle() + "\nA." + q.getOptionA() + "\nB." + q.getOptionB()
                + "\nC." + q.getOptionC() + "\nD." + q.getOptionD();
        questArea.setText(ques);
    }

    public void updateQuestion(Questioninfo firstQuestion, int currentIndex) {
        // 更新题目信息 firstQuestion试卷上的题目 Question
        Question q = firstQuestion.getQuestion();

        String ques = q.getTitle() + "\nA." + q.getOptionA() + "\nB." + q.getOptionB()
                + "\nC." + q.getOptionC() + "\nD." + q.getOptionD();
        questArea.setText(ques);

        //先让所有的选项都变成没选中的状态
        for (JCheckBox option : options) {
            option.setSelected(false);
        }

        // 更新用户答案对应的选项信息；
        List<Integer> answers = firstQuestion.getUserAnswers();  // 0 1 2 3
        for (int answer : answers) {
            options[answer].setSelected(true);
        }
        // 题号更新
        questCountLabel.setText("10题中的第" + currentIndex + "题");
    }

    public java.util.List<Integer> getOptionValue() {
        List<Integer> userAnswers = new ArrayList<>();
        for (int i = 0; i < options.length; i++) {
            if (options[i].isSelected()) {
                userAnswers.add(i);
            }
        }
        return userAnswers;
    }
    // 格式化时间
    private String formatTime(int time) {
        int hour = time / 3600;
        int minute = (time % 3600) / 60;
        int second = time % 60;
        return String.format("%02d:%02d:%02d", hour, minute, second);
    }

    public void setContext(ClientContext context) {
        this.context = context;
    }
}
