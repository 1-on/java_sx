package day2.ui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author yi xian
 * @description
 * @date 2023/6/6 8:17
 */
public class GUIProperty {
    public static void main(String[] args) {
        JFrame window = new JFrame("我是狗嘿嘿");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setSize(700, 600);

        JPanel P = new JPanel();
        // 调用方法，得到一个带图标的按钮
        JButton start = new JButton("开始");
        JButton exam = new JButton("考试");
        JButton pre = new JButton("上一题");
        JButton next = new JButton("下一题");
        JTextField JT = new JTextField(20);
        JPasswordField JP = new JPasswordField(20);
        JCheckBox JC = new JCheckBox("A");

        P.add(start);
        P.add(exam);
        P.add(pre);
        P.add(next);
        P.add(JT);
        P.add(JP);
        P.add(JC);
        window.add(P);

        // 添加鼠标对按钮的事件 -> 动作监听器
        start.addActionListener(e -> {
            System.out.println("开始");
        });

        exam.addActionListener(e -> System.out.println("阿一古"));

        ActionListener listener = e -> {
            String command = e.getActionCommand(); // 按钮上的文字
            System.out.println(command);
        };

        pre.addActionListener(listener);
        next.addActionListener(listener);

        start.addActionListener(e -> {
            String num = JT.getText();
            System.out.println("num" + num);
        });
        exam.addActionListener(e -> {
            boolean b = JC.isSelected();
            System.out.println(b);
            JC.setSelected(!b);

        });

        window.setVisible(true);
    }
}
