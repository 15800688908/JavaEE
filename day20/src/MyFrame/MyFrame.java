package MyFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class MyFrame extends JFrame {
	private JButton but = new JButton("按钮");

	// 当but点击时就是事件
	public MyFrame() {
		this.getContentPane().add(but);// 事件源
		// 注册监听
		but.addActionListener(new ButListener());

		this.setDefaultCloseOperation(3);
		this.setBounds(100, 100, 300, 300);
		this.setVisible(true);
	}

	public static void main(String[] args) {
		new MyFrame();
	}
}

// 监听器
class ButListener implements ActionListener {
	public void actionPerformed(ActionEvent e) {
		
		e.getSource();//获取事件源
		System.out.println("hello world");
	}
}