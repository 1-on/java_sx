package day1.ui;

import day3.controller.ClientContext;
import day3.entity.User;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

/**
 * @author yi xian
 * @description 主界面
 * @date 2023/6/6 17:56
 */
public class MainFrame extends JFrame {
    private JLabel nameLabel;
    private ClientContext context;

    public MainFrame() throws HeadlessException {
        init();
    }

    public void init() {
        setProperty();
        // 布局设置
        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBorder(new EmptyBorder(8, 8, 8, 8));

        //北边
        JLabel title = new JLabel("在线测评系统", JLabel.CENTER);
        Font font = new Font("宋体",Font.PLAIN,50);
        title.setFont(font);
        title.setForeground(Color.blue);
        mainPanel.add(title, BorderLayout.NORTH);

        //中间
        JPanel centerPanel = createCenterPanel();
        mainPanel.add(centerPanel, BorderLayout.CENTER);

        //南边
        JLabel label = new JLabel("版权信息--202105015114蒋飞", JLabel.RIGHT);
        mainPanel.add(label, BorderLayout.SOUTH);

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
        // xxx同学你好
        nameLabel = new JLabel("xxx同学你好", JLabel.CENTER);
        centerPanel.add(nameLabel, BorderLayout.NORTH);
        // 四个按钮
        JPanel Panel = new JPanel();
        JButton start = createImageButton("1.gif","开始");
        start.addActionListener(e -> context.exam());
        JButton score = createImageButton("2.gif","分数");
        score.addActionListener(e -> context.score());
        JButton regular = createImageButton("3.gif","考试规则");
        regular.addActionListener(e -> context.rule());
        JButton exit = createImageButton("4.gif","离开");
        exit.addActionListener(e -> context.quit());

        Panel.add(start);
        Panel.add(score);
        Panel.add(regular);
        Panel.add(exit);

//        centerPanel.add(start,BorderLayout.CENTER);
//        centerPanel.add(score,BorderLayout.CENTER);
//        centerPanel.add(regular,BorderLayout.CENTER);
//        centerPanel.add(exit,BorderLayout.CENTER);
        centerPanel.add(Panel);
        return centerPanel;
    }

    public JButton createImageButton(String imageName, String text) {
        // 图片路径在工程文件夹下
        ImageIcon icon = new ImageIcon(imageName);

        //图片路径在同一路径下
        //ImageIcon icon = new ImageIcon(imagePanel.class.getResource(imageName));
        // 图片按钮
        JButton but = new JButton(text,icon);
        //but.setPreferredSize(new Dimension(100,100));
        // 设置文字水平居中
        but.setHorizontalTextPosition(JButton.CENTER);
        // 设置文字垂直位置居下方
        but.setVerticalTextPosition(JButton.BOTTOM);
        return but;
    }

    public void setContext(ClientContext context) {
        this.context = context;
    }
    public void updateUI(User login){
        String nameInfo = login.getName()+"同学你好！";
        nameLabel.setText(nameInfo);
    }
}
