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
		textId.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		textId.setBounds(172, 71, 116, 23);
		getContentPane().add(textId);
		textId.setColumns(10);

		textPw = new JTextField();
		textPw.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		textPw.setBounds(172, 111, 116, 23);
		getContentPane().add(textPw);
		textPw.setColumns(10);

		// 로그인
		JButton btnlogin = new JButton("로그인");
		btnlogin.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Login();

			}
		});
		btnlogin.setFont(new Font("맑은 고딕", Font.PLAIN, 12));

		btnlogin.setBounds(172, 159, 116, 23);
		getContentPane().add(btnlogin);

		// 회원가입
		JButton btnsignup = new JButton("회원가입");
		btnsignup.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Join joinframe = new Join();
				joinframe.setVisible(true);
				joinframe.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			}
		});

		btnsignup.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		btnsignup.setBounds(266, 192, 97, 23);
		getContentPane().add(btnsignup);

	} // end initialize()

	// 로그인

	public void Login() {

		// 로그인할때 데이터가 있으면 로그인이 한줄로됨

		// 아이디 비번이 없으면 로그인이 되지않음

		// ---> 로그인 안된다고 표현하기

 

		// 로그인

		// 관리자로그인

		// select mem_id와 mem_pw가 있을때

		// 사용자 로그인

 

		// update mem_id을 사용해

		// 생일인 사용자에게 3000포인트 줌

 

		String mem_id = textId.getText();

		String mem_pw = textPw.getText();

 

		MemberVO vo = dao.select_login(mem_id, mem_pw);

 

		if ((textId.getText().equals("")) && (textPw.getText().equals(""))) {

			JOptionPane.showMessageDialog(null, "아이디와 비밀번호를 입력해주세요.");

		} else if (textId.getText().equals("")) {

			JOptionPane.showMessageDialog(null, "아이디를 입력해주세요.");

		} else if (textPw.getText().equals("")) {

			JOptionPane.showMessageDialog(null, "비밀번호를 입력해주세요.");

		} else if ((textId.getText().equals((vo.getMem_id()))) && (textPw.getText().equals(vo.getMem_pw()))) {

			JOptionPane.showMessageDialog(null, mem_id + "님 환영합니다.");

			checkBirth(vo);
			
			setVisible(false);
		} else {

			JOptionPane.showMessageDialog(null, "존재하지 않는 정보입니다.");

		}

 

	} // end Login()

 

	public void checkBirth(MemberVO vo) {

		// 생일인 사람 로그인

 

		SimpleDateFormat sdfM = new SimpleDateFormat("MM", Locale.KOREA);

		SimpleDateFormat sdfD = new SimpleDateFormat("dd", Locale.KOREA);

		Date current = new Date();

		String month = sdfM.format(current);

		String day = sdfD.format(current);

 

		System.out.println(month + "월");

		System.out.println(day + "일");

 

		System.out.println(vo.getMem_month());

		System.out.println(vo.getMem_day());

		if (vo.getMem_month().equals(month) && vo.getMem_day().equals(day)) {

			System.out.println("통과");

 

			vo = new MemberVO(0, null, null, null, null, null, null, vo.getMem_month(), vo.getMem_day(), 0);

			int result = dao.update_mempoint(vo);
			JOptionPane.showMessageDialog(null, "생일 축하 기념 3000포인트를 드립니다.");
			System.out.println("포인트 3000 추가");

			if (result == 1) {

				JOptionPane.showMessageDialog(null, "생일 축하 기념 3000포인트를 드립니다.");

				System.out.println("포인트 3000 추가");

			}

		}

	} // end checkBirth()
	} // end Coffee
