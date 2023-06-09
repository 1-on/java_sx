package day1.ui;

import javax.swing.*;

/**
 * @author yi xian
 * @description
 * @date 2023/6/5 14:36
 */
public class imagePanel {
    public static void main(String[] args) {
        JFrame window = new JFrame("我是狗");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setSize(700, 600);
        window.setLocationRelativeTo(null);

        JPanel Pan = new JPanel();

        JButton but = createImageButton("fox.jpg","开始");

        Pan.add(but);

        window.add(Pan);

        window.setVisible(true);
    }

    public static JButton createImageButton(String imageName, String text) {
        ImageIcon icon = new ImageIcon(imageName);

        //ImageIcon icon = new ImageIcon(imagePanel.class.getResource(imageName));
        // 图片按钮
        JButton but = new JButton(text,icon);

        // 设置文字水平居中
        but.setHorizontalTextPosition(JButton.CENTER);
        // 设置文字垂直位置居下方
        but.setVerticalTextPosition(JButton.BOTTOM);
        return but;
    }


}
