import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Login extends JFrame{
	private JTextField textId;
	private JTextField textPw;

	private static MemberDAO dao;
	
	public Login() {
		dao = MemberDAOImple.getInstace();
		initialize();
		
	}

	private void initialize() {
//		frame = new JFrame("CAFE");
//		frame.setBounds(100, 100, 450, 300);
//		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		frame.getContentPane().setLayout(null);
		
		setBounds(500, 300, 450, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);

		JLabel lblid = new JLabel("ID");
		lblid.setBounds(55, 62, 57, 30);
		lblid.setFont(new Font("Dialog", Font.BOLD, 24));
		getContentPane().add(lblid);

		JLabel lblpw = new JLabel("Password");
		lblpw.setFont(new Font("Dialog", Font.BOLD, 24));
		lblpw.setBounds(55, 105, 116, 30);
		getContentPane().add(lblpw);

		textId = new JTextField();
		textId.setFont(new Font("���� ���", Font.PLAIN, 12));
		textId.setBounds(172, 71, 116, 23);
		getContentPane().add(textId);
		textId.setColumns(10);

		textPw = new JTextField();
		textPw.setFont(new Font("���� ���", Font.PLAIN, 12));
		textPw.setBounds(172, 111, 116, 23);
		getContentPane().add(textPw);
		textPw.setColumns(10);

		// �α���
		JButton btnlogin = new JButton("�α���");
		btnlogin.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Login();

			}
		});
		btnlogin.setFont(new Font("���� ���", Font.PLAIN, 12));

		btnlogin.setBounds(172, 159, 116, 23);
		getContentPane().add(btnlogin);

		// ȸ������
		JButton btnsignup = new JButton("ȸ������");
		btnsignup.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Join joinframe = new Join();
				joinframe.setVisible(true);
				joinframe.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			}
		});

		btnsignup.setFont(new Font("���� ���", Font.PLAIN, 12));
		btnsignup.setBounds(266, 192, 97, 23);
		getContentPane().add(btnsignup);

	} // end initialize()

	// �α���

	public void Login() {

		// �α����Ҷ� �����Ͱ� ������ �α����� ���ٷε�

		// ���̵� ����� ������ �α����� ��������

		// ---> �α��� �ȵȴٰ� ǥ���ϱ�

 

		// �α���

		// �����ڷα���

		// select mem_id�� mem_pw�� ������

		// ����� �α���

 

		// update mem_id�� �����

		// ������ ����ڿ��� 3000����Ʈ ��

 

		String mem_id = textId.getText();

		String mem_pw = textPw.getText();

 

		MemberVO vo = dao.select_login(mem_id, mem_pw);

 

		if ((textId.getText().equals("")) && (textPw.getText().equals(""))) {

			JOptionPane.showMessageDialog(null, "���̵�� ��й�ȣ�� �Է����ּ���.");

		} else if (textId.getText().equals("")) {

			JOptionPane.showMessageDialog(null, "���̵� �Է����ּ���.");

		} else if (textPw.getText().equals("")) {

			JOptionPane.showMessageDialog(null, "��й�ȣ�� �Է����ּ���.");

		} else if ((textId.getText().equals((vo.getMem_id()))) && (textPw.getText().equals(vo.getMem_pw()))) {

			JOptionPane.showMessageDialog(null, mem_id + "�� ȯ���մϴ�.");

			checkBirth(vo);
			
			setVisible(false);
		} else {

			JOptionPane.showMessageDialog(null, "�������� �ʴ� �����Դϴ�.");

		}

 

	} // end Login()

 

	public void checkBirth(MemberVO vo) {

		// ������ ��� �α���

 

		SimpleDateFormat sdfM = new SimpleDateFormat("MM", Locale.KOREA);

		SimpleDateFormat sdfD = new SimpleDateFormat("dd", Locale.KOREA);

		Date current = new Date();

		String month = sdfM.format(current);

		String day = sdfD.format(current);

 

		System.out.println(month + "��");

		System.out.println(day + "��");

 

		System.out.println(vo.getMem_month());

		System.out.println(vo.getMem_day());

		if (vo.getMem_month().equals(month) && vo.getMem_day().equals(day)) {

			System.out.println("���");

 

			vo = new MemberVO(0, null, null, null, null, null, null, vo.getMem_month(), vo.getMem_day(), 0);

			int result = dao.update_mempoint(vo);
			JOptionPane.showMessageDialog(null, "���� ���� ��� 3000����Ʈ�� �帳�ϴ�.");
			System.out.println("����Ʈ 3000 �߰�");

			if (result == 1) {

				JOptionPane.showMessageDialog(null, "���� ���� ��� 3000����Ʈ�� �帳�ϴ�.");

				System.out.println("����Ʈ 3000 �߰�");

			}

		}

	} // end checkBirth()
	} // end Coffee
