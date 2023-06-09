package day1.ui;

import day3.controller.ClientContext;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

/**
 * @author yi xian
 * @description
 * @date 2023/6/8 19:38
 */
public class RuleFrame extends JFrame {
    private ClientContext context;
    public RuleFrame() throws HeadlessException {
        init();
    }

    public void init() {
        setProperty();

        // 布局设置
        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBorder(new EmptyBorder(8, 8, 8, 8));

        //北边
        JLabel title = new JLabel("考试须知", JLabel.CENTER);
        Font font = new Font("宋体", Font.PLAIN, 50);
        title.setFont(font);
        title.setForeground(Color.red);
        mainPanel.add(title, BorderLayout.NORTH);

        //中间
        JScrollPane centerPanel = createCenterPanel();
        mainPanel.add(centerPanel, BorderLayout.CENTER);

        //南边
        JPanel panel = new JPanel();

        JButton back = new JButton("返回");
        back.addActionListener(e -> context.backFromRule());
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

    private JScrollPane createCenterPanel() {
        JTextArea jTextArea = new JTextArea(8,10);
        String info = "各位同学：\n" +
                "请仔细阅读在线考试操作流程及重要提示，提前做好考试准备，谢谢！\n" +
                "\n" +
                "\n" +
                "\n" +
                "一、上机考操作流程：\n" +
                "\n" +
                "1、考试预约成功学生凭身份证或学生证进入机房，由监考人员查验证件。\n" +
                "\n" +
                "2、按监考指定机位就坐。\n" +
                "\n" +
                "3、监考老师分发考试账号和密码。\n" +
                "\n" +
                "4、打开电脑桌面浏览器“复旦继续教育学院考试系统”页面。\n" +
                "\n" +
                "5、登录考试账号、密码。\n" +
                "\n" +
                "6、点击首页预约过的对应英语段位进入考试。\n" +
                "\n" +
                "7、点击“考试说明”，仔细阅读“考试说明”后，点击“我已知晓”-“提交测验”。\n" +
                "\n" +
                "8、提交“考试说明”后，点击“进入测验”。\n" +
                "\n" +
                "9、等待监考开考指令。\n" +
                "\n" +
                "10、开考指令发出后，点击“测试开始”，开始答题。\n" +
                "\n" +
                "11、在规定的时间内，无论答题是否完成，都必须点击“提交测试”进行交卷，否则考试无效。\n" +
                "\n" +
                "\n" +
                "\n" +
                "二、上机考重要提示\n" +
                "\n" +
                " 1、考试时间为90分钟，试卷满分为100分。\n" +
                "\n" +
                " 2、点击“测试开始”后，电脑自动开始计时并保存填写的内容，无需手动保存。\n" +
                "\n" +
                " 3、试卷只能提交一次，点击“提交测试”后，考试自动终止，无法继续答题。\n" +
                "\n" +
                " 4、试卷中，“阅读理解”题为计算机自动评分，仅识别单独的abcd（含大写），请勿输入其他字符。\n" +
                "\n" +
                " 5、使用通讯设备或其他器材作弊，给予开除学籍处分。\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "浙江树人大学信息科技学院\n" +
                "\n" +
                "2023年6月8日  \n" +
                "\n";
        jTextArea.append(info);
        JScrollPane scrollPane = new JScrollPane(jTextArea);
        return scrollPane;
    }

    public void setContext(ClientContext context) {
        this.context = context;
    }
}
