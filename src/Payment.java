
import java.util.ArrayList;


import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class Payment extends JFrame {

//	public static CoffeeDAO dao;
	CoffeeDAO dao = null;

	ArrayList<CoffeeVO> list = new ArrayList<CoffeeVO>();
	CoffeeVO Coffee = null;
	StockVO Stock = null;

	JLabel lblTotalAmount;
	String menu = "";
	int count = 0;

	boolean flag_size = false;// �ѹ��̶� Ŭ���ϸ� true
	boolean flag_shot = false;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the application.
	 */
	public Payment() {

		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		

		setBounds(500, 300, 552, 478);
	//	setSize(617, 478);

		JButton btnNewButton = new JButton("\uD604\uAE08 \uACB0\uC81C");// ���� ����
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				payment1();
			}
		});
		getContentPane().setLayout(null);
		btnNewButton.setBounds(0, 0, 536, 150);
		getContentPane().add(btnNewButton);

		JButton btnNewButton_1 = new JButton("\uCE74\uB4DC\uACB0\uC81C");// ī�� ����
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				payment2();
			}
		});
		btnNewButton_1.setBounds(0, 148, 536, 150);
		getContentPane().add(btnNewButton_1);

		JButton btnNewButton_2 = new JButton("\uB9C8\uC77C\uB9AC\uC9C0 \uACB0\uC81C"); // ���ϸ��� ����
		btnNewButton_2.setForeground(new Color(0, 0, 0));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pointpay();
			}
		});
		btnNewButton_2.setBounds(0, 297, 536, 142);
		getContentPane().add(btnNewButton_2);
		

	}

	public void payment1() {//���� ����
		JOptionPane.showMessageDialog(null, "���� ���� �Ǿ����ϴ�");
		dispose();
	}// payment1
	
	public void payment2() {//ī�� ����

		JOptionPane.showMessageDialog(null, "ī�� ���� �Ǿ����ϴ�");
		dispose();
	}// payment2
	
	
public void pointpay() {//���ϸ��� ����
	
	
	JOptionPane.showMessageDialog(null, "���ϸ��� ���� �Ǿ����ϴ�");
	dispose();
		
	}
	
}
