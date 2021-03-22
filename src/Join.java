

import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import javax.swing.JComboBox;
import javax.swing.JScrollPane;

public class Join extends JFrame{

	public static MemberDAO dao;

	private JPanel contentPane;
	private JLabel lbljoin;
	private JLabel lblpw;
	private JLabel lblname;
	private JLabel lblphone;
	private JLabel lblbirth;
	private JLabel lblpoint;
	private JTextField textId;
	private JTextField textPw;
	private JTextField textName;
	private JTextField textPhone;
	private JButton completebtn;
	private JRadioButton rdbtnman;
	private JRadioButton rdbtnwoman;
	
	
	
	private JTextField textYear;
	private JTextField textMonth;
	private JTextField textDay;


	public Join() {
		dao = MemberDAOImple.getInstace();
		initialize();
	}

	private void initialize() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(450, 490);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		lbljoin = new JLabel("ȸ������");
		Font f1 = new Font("����", Font.BOLD, 20);
		lbljoin.setFont(new Font("Dialog", Font.BOLD, 20));
		lbljoin.setBounds(155, 42, 84, 20);
		contentPane.add(lbljoin);

		JLabel lblid = new JLabel("���̵�");
		lblid.setFont(new Font("Dialog", Font.BOLD, 12));
		lblid.setBounds(45, 96, 69, 20);
		contentPane.add(lblid);

		lblpw = new JLabel("��й�ȣ");
		lblpw.setFont(new Font("Dialog", Font.BOLD, 12));
		lblpw.setBounds(45, 140, 69, 20);
		contentPane.add(lblpw);

		JLabel lblname = new JLabel("�̸�");
		lblname.setFont(new Font("Dialog", Font.BOLD, 12));
		lblname.setBounds(45, 184, 69, 20);
		contentPane.add(lblname);

		JLabel lblphone = new JLabel("��ȭ��ȣ");
		lblphone.setFont(new Font("Dialog", Font.BOLD, 12));
		lblphone.setBounds(45, 222, 57, 20);
		contentPane.add(lblphone);

		JLabel lblgender = new JLabel("����");
		lblgender.setFont(new Font("Dialog", Font.BOLD, 12));
		lblgender.setBounds(45, 266, 57, 15);
		contentPane.add(lblgender);
		
		
		JLabel lblbirth = new JLabel("����");
		lblbirth.setFont(new Font("Dialog", Font.BOLD, 12));
		lblbirth.setBounds(45, 304, 69, 20);
		contentPane.add(lblbirth);

		
		rdbtnman = new JRadioButton("����");
		rdbtnman.setBounds(131, 262, 73, 23);
		contentPane.add(rdbtnman);
		
		rdbtnwoman = new JRadioButton("����");
		rdbtnwoman.setBounds(213, 262, 73, 23);
		contentPane.add(rdbtnwoman);
		
		
		textId = new JTextField();
		textId.setColumns(10);
		textId.setBounds(110, 89, 186, 35);
		contentPane.add(textId);

		textPw = new JTextField();
		textPw.setColumns(10);
		textPw.setBounds(110, 135, 186, 32);
		contentPane.add(textPw);

		textName = new JTextField();
		textName.setColumns(10);
		textName.setBounds(110, 175, 186, 35);
		contentPane.add(textName);

		textPhone = new JTextField();
		textPhone.setColumns(10);
		textPhone.setBounds(110, 215, 186, 35);
		contentPane.add(textPhone);

		// ����
		JLabel lblyear = new JLabel("��");
		lblyear.setBounds(178, 307, 13, 15);
		contentPane.add(lblyear);

		JLabel lblmonth = new JLabel("��");
		lblmonth.setBounds(220, 307, 21, 15);
		contentPane.add(lblmonth);

		JLabel lblday = new JLabel("��");
		lblday.setBounds(271, 307, 21, 15);
		contentPane.add(lblday);

		textYear = new JTextField();
		textYear.setBounds(110, 304, 61, 21);
		contentPane.add(textYear);
		textYear.setColumns(10);

		textMonth = new JTextField();
		textMonth.setColumns(10);
		textMonth.setBounds(193, 304, 21, 20);
		contentPane.add(textMonth);

		textDay = new JTextField();
		textDay.setColumns(10);
		textDay.setBounds(238, 304, 21, 20);
		contentPane.add(textDay);

		JLabel lblexbirth = new JLabel("ex) 1990 01 20");
		lblexbirth.setBounds(308, 307, 90, 15);
		contentPane.add(lblexbirth);

		JLabel lblpoint = new JLabel("����Ʈ");
		lblpoint.setFont(new Font("Dialog", Font.BOLD, 12));
		lblpoint.setBounds(45, 356, 57, 15);
		contentPane.add(lblpoint);

		JLabel lblpointscore = new JLabel("1000");
		lblpointscore.setBounds(213, 356, 41, 15);
		contentPane.add(lblpointscore);

		JLabel lblexphone = new JLabel("ex) 01011111111");
		lblexphone.setBounds(311, 218, 97, 15);
		contentPane.add(lblexphone);

		JButton btnIdCheck = new JButton("���̵� �ߺ� üũ");
		btnIdCheck.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				idcheck();

			}
		});
		btnIdCheck.setBounds(306, 89, 124, 35);
		contentPane.add(btnIdCheck);

		completebtn = new JButton("ȸ�����ԿϷ�");
		completebtn.setBounds(165, 389, 139, 29);
		contentPane.add(completebtn);
		// ȸ�����ԿϷ� �׼�
		completebtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				insertCoffee();
			}
		});
		setVisible(true);

	} // end initialize

	public void insertCoffee() {

		String mem_id = textId.getText();
		String mem_pw = textPw.getText();
		String mem_name = textName.getText();
		String mem_phone = textPhone.getText();
		String mem_gender = "";
		if(rdbtnman.isSelected()) {
			mem_gender = "����";
		} else if(rdbtnwoman.isSelected()) {
			mem_gender = "����";
		}
		String mem_year = textYear.getText();
		String mem_month = textMonth.getText();
		String mem_day = textDay.getText();
		final int mem_point = 1000;


		if (mem_id.equals("") || mem_pw.equals("") || mem_name.equals("") || mem_phone.equals("") || mem_year.equals("")
				|| mem_month.equals("") || mem_day.equals("")) {
			JOptionPane.showMessageDialog(null, "�Է����� ���� ������ �Է��ϼ���.");
			return;
		}

		// ��ȭ��ȣ ���ڸ� �ν�
		if (mem_phone.equals(textPhone.getText())) {
			for (char c : mem_phone.toCharArray()) {
				if (!Character.isDigit(c)) {
					JOptionPane.showMessageDialog(null, "��ȭ��ȣ�� ���ڰ� ���ԵǾ����ϴ�.");
					return;
				}
			}
		}

		// ��, ��, �� ���ڸ� �ν��Ҽ� �ְ�
		if (mem_year.equals(textYear.getText())) {
			for (char c : mem_year.toCharArray()) {
				if (!Character.isDigit(c)) {
					JOptionPane.showMessageDialog(null, "�⿡ ���ڰ� ���ԵǾ����ϴ�.");
					return;
				}
			}
		}

		if (mem_month.equals(textMonth.getText())) {
			for (char c : mem_month.toCharArray()) {
				if (!Character.isDigit(c)) {
					JOptionPane.showMessageDialog(null, "���� ���ڰ� ���ԵǾ����ϴ�.");
					return;
				}
			}
		}

		if (mem_day.equals(textDay.getText())) {
			for (char c : mem_day.toCharArray()) {
				if (!Character.isDigit(c)) {
					JOptionPane.showMessageDialog(null, "�Ͽ� ���ڰ� ���ԵǾ����ϴ�.");
					return;
				}
			}
		}

		MemberVO vo = new MemberVO(0, mem_id, mem_pw, mem_name, mem_phone, mem_gender, mem_year, mem_month, mem_day, 1000);
		int result = dao.insert_mem(vo);

		if (result == 1) {
			JOptionPane.showMessageDialog(null, "ȸ�������� �Ϸ�Ǿ����ϴ�.");
			dispose();
		} else {
			JOptionPane.showMessageDialog(this, "������ ���������� ó������ �ʾҽ��ϴ�.");
			dispose();
		}

	} // end insertCoffee()

	public void idcheck() {
		String mem_id = textId.getText();
		try {
			MemberVO vo = dao.select_idcheck(mem_id);

			if ((textId.getText().equals(""))) {
				JOptionPane.showMessageDialog(null, "���̵� �Է����ּ���.");
			} else if ((textId.getText().equals((vo.getMem_id())))) {
				JOptionPane.showMessageDialog(null, "������� ���̵� �Դϴ�.");
			} else {
				JOptionPane.showMessageDialog(null, "��밡���� ���̵� �Դϴ�.");
			}
		} catch (NullPointerException e) {
			JOptionPane.showMessageDialog(null, "�������� �ʴ� ȸ�� ���� �Դϴ�.");
		}
	} // end Idcheck()

	
} // end Join
