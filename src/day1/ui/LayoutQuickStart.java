package day1.ui;

import javax.swing.*;
import java.awt.*;

/**
 * @author yi xian
 * @description
 * @date 2023/6/5 10:23
 */
public class LayoutQuickStart {
    public static void main(String[] args) {
        JFrame window = new JFrame("我是狗嘿嘿");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setSize(700, 600);
        window.setLocationRelativeTo(null);
        window.setVisible(true);

        JPanel flowp = new JPanel(new FlowLayout());

        JPanel boarderP = new JPanel(new BorderLayout());

        JPanel gridP = new JPanel(new GridLayout(2,3));



        for (int i = 0; i < 10; i++) {
            JButton but = new JButton("按钮" + i);
            flowp.add(but);
        }
        JButton but = new JButton("按钮南");
        boarderP.add(but, BorderLayout.SOUTH);

        for (int i = 0; i < 5; i++) {
            JButton but1 = new JButton("按钮" + i);
            gridP.add(but1);
        }
        JPanel JP = new JPanel();
        JP.setLayout(null);
        JButton btn1 = new JButton("哈哈哈");
        btn1.setSize(100,50);
        btn1.setLocation(100,200);
        JP.add(btn1);
        window.add(JP);
    }
}
