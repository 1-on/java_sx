package day1.ui;

import javax.swing.*;

/**
 * @author yi xian
 * @description
 * @date 2023/6/5 9:24
 */
public class PanelQuickStart {
    public static void main(String[] args) {
        JFrame window = new JFrame("我是狗嘿嘿");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setSize(700,600);
        window.setLocationRelativeTo(null);


        JPanel P = new JPanel();
        window.add(P);

        JTextField tf = new JTextField(10);
        P.add(tf);
        JTextArea ta = new JTextArea(20,50);
        P.add(ta);
        window.setVisible(true);
    }
}
