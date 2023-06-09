package day1.ui;

import javax.swing.*;

/**
 * @author yi xian
 * @description
 * @date 2023/6/5 8:33
 */
public class FrameQuickStart {
    public static void main(String[] args) {
        JFrame window = new JFrame("我是狗嘿嘿");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setSize(700,600);
        window.setLocationRelativeTo(null);
        window.setVisible(true);

    }
}
