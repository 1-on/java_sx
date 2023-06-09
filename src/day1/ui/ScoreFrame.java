package day1.ui;

import day3.controller.ClientContext;
import day3.entity.Course;
import day3.entity.Score;
import day3.entity.User;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

/**
 * @author yi xian
 * @description
 * @date 2023/6/8 20:01
 */
public class ScoreFrame extends JFrame {
    private ClientContext context;
    private JLabel infoLabel;
    public ScoreFrame() throws HeadlessException {
        init();
    }
    public void init() {
        setProperty();
        // 布局设置
        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBorder(new EmptyBorder(8, 8, 8, 8));

        //北边
        JLabel title = new JLabel("查看分数", JLabel.CENTER);
        Font font = new Font("宋体", Font.PLAIN, 50);
        title.setFont(font);
        title.setForeground(Color.PINK);
        mainPanel.add(title, BorderLayout.NORTH);

        //中间
        infoLabel = new JLabel("",JLabel.CENTER);
        Font font2 = new Font("宋体", Font.PLAIN, 20);
        infoLabel.setFont(font2);
        mainPanel.add(infoLabel, BorderLayout.CENTER);

        //南边
        JPanel panel = new JPanel();

        JButton back = new JButton("返回");
        back.addActionListener(e -> context.backFromScore());
        panel.add(back);
        mainPanel.add(panel, BorderLayout.SOUTH);

        this.add(mainPanel);
    }
    private void setProperty() {
        // 设置属性
        this.setTitle("考试须知");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(600, 500);
        this.setLocationRelativeTo(null);
        ImageIcon icon = new ImageIcon("新一.jpg");
        this.setIconImage(icon.getImage());
    }

    public void setContext(ClientContext context) {
        this.context = context;
    }
    public void updateUI(User login,Score score,Course course){
        String info ="姓名："+login.getName()+"   科目："+course.getName()+"  成绩："+score.getScore()+"分";
        infoLabel.setText(info);
    }
}

//https://peisong.meituan.com/app/riderRecruitmentFusion/index 上这个解决了网站