package day3.ui;

import day3.controller.ClientContext;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

/**
 * @author yi xian
 * @description 登录界面
 * @date 2023/6/5 13:33
 */
public class LoginFrame extends JFrame {
    private JTextField numField;
    private JPasswordField passField;
    private JLabel errorLabel;
    private ClientContext context;  //在程序开始时创建

    public LoginFrame() throws HeadlessException {
        init();
    }

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
    }

    private JPanel createCenterPanel() {
        //中间 -> 4个组件
        JPanel centerpan = new JPanel();
        //中间部分第一行
        JPanel row1 = new JPanel();
        JLabel numLabel = new JLabel("编号：", JLabel.CENTER);
        numField = new JTextField(20);
        row1.add(numLabel);
        row1.add(numField);
        //中间部分第二行
        JPanel row2 = new JPanel();
        JLabel passLabel = new JLabel("密码：", JLabel.CENTER);
        passField = new JPasswordField(20);
        row2.add(passLabel);
        row2.add(passField);

        //中间部分第三行
        errorLabel = new JLabel();
        centerpan.add(row1);
        centerpan.add(row2);
        centerpan.add(errorLabel);

        return centerpan;
    }

    private JPanel createSouthPanel() {
        //南边 -> 2个组件 ->JPanel
        JPanel southPan = new JPanel();
        JButton loginBth = new JButton("Login");
        JButton cancelBth = new JButton("Cancel");
        southPan.add(loginBth);
        // 按钮事件
        loginBth.addActionListener(e -> context.login());
        southPan.add(cancelBth);
        cancelBth.addActionListener(e -> System.exit(0));
        return southPan;
    }

    private void setProperty() {
        // 设置属性
        this.setTitle("在线考试系统");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(300, 220);
        this.setLocationRelativeTo(null);
        ImageIcon icon = new ImageIcon("新一.jpg");
        this.setIconImage(icon.getImage());
    }

    public String getInputNum() {
        return numField.getText();
    }

    public String getInputPassword() {
        return new String(passField.getPassword());
    }

    public void showError(String message) {
        errorLabel.setForeground(Color.red);
        errorLabel.setText(message);
    }

    public void setContext(ClientContext context) {
        this.context = context;
    }
}
