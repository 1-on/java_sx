import javax.swing.*;

/**
 * @author yi xian
 * @description
 * @date 2023/6/5 8:34
 */
public class SimpleGUI extends JFrame {
    private JButton button;
    private JTextField textField;

    public SimpleGUI() {
        super("Simple GUI");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // 创建按钮和文本框
        button = new JButton("Click me!");
        textField = new JTextField(20);

        // 添加按钮和文本框到窗口中
        JPanel panel = new JPanel();
        panel.add(button);
        panel.add(textField);
        add(panel);

        // 设置窗口大小并显示
        setSize(300, 100);
        setVisible(true);
    }

    public static void main(String[] args) {
        SimpleGUI gui = new SimpleGUI();
    }
}
