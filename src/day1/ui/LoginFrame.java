package day1.ui;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

/**
 * @author yi xian
 * @description 登录界面
 * @date 2023/6/5 13:33
 */
public class LoginFrame extends JFrame {

    // 界面初始化
    public void init() {
        setProperty();
        // 布局设置
        JPanel mainPan = new JPanel(new BorderLayout());
        mainPan.setBorder(new EmptyBorder(8, 8, 8, 8));

        //北边 -> 标题
        JLabel title = new JLabel("登录考试系统", JLabel.CENTER);
        mainPan.add(title, BorderLayout.NORTH);

        //中间
        JPanel centerPanel = createCenterPanel();
        mainPan.add(centerPanel, BorderLayout.CENTER);

        //南边
        JPanel southPan = createSouthPanel();
        mainPan.add(southPan, BorderLayout.SOUTH);

        this.add(mainPan);
        this.setVisible(true);
    }

    private JPanel createCenterPanel() {
        //中间 -> 4个组件
        JPanel centerpan = new JPanel();
        //中间部分第一行
        JPanel row1 = new JPanel();
        JLabel numLabel = new JLabel("编号：", JLabel.CENTER);
        JTextField numFiedl = new JTextField(20);
        row1.add(numLabel);
        row1.add(numFiedl);
        //中间部分第二行
        JPanel row2 = new JPanel();
        JLabel passLabel = new JLabel("密码：", JLabel.CENTER);
        JTextField passField = new JTextField(20);
        row2.add(passLabel);
        row2.add(passField);

        centerpan.add(row1);
        centerpan.add(row2);

        return centerpan;
    }

    private JPanel createSouthPanel() {
        //南边 -> 2个组件 ->JPanel
        JPanel southPan = new JPanel();
        JButton loginBth = new JButton("Login");
        JButton cancelBth = new JButton("Cancel");
        southPan.add(loginBth);
        southPan.add(cancelBth);
        return southPan;
    }

    private void setProperty() {
        // 设置属性
        this.setTitle("我是狗嘿嘿");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(300, 220);
        this.setLocationRelativeTo(null);
    }
}
