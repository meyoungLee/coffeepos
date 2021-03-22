import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTable;
import javax.swing.JRadioButton;


public class MemberTab extends JPanel {

	public static MemberDAO dao;
	private JFrame frame;
	private JTextField textId, textPw, textIndex;
	private JTextArea textArea;

	/* 스윙 테이블을 사용하기 위한 멤버 변수 선언 */
	private JTable table;
	private String[] colNames = { "No", "아이디", "비밀번호", "이름", "전화번호", "성별", "년", "월", "일", "포인트"}; // 테이블 헤더에 들어갈 이름들
	private Object[] records = new Object[colNames.length]; // 테이블 데이터를 저장할 배열 객체
	private DefaultTableModel tableModel; // 테이블 형태를 만들 모델 변수
	private JTextField textName;
	private JTextField textPhone;
	private JTextField textYear;
	private JTextField textMonth;
	private JTextField textDay;
	private JTextField textPoint;
	
	private JRadioButton rdbtnman;
	private JRadioButton rdbtnwoman;



	/**
	 * Launch the application.
	 */


	public MemberTab() {
		dao = MemberDAOImple.getInstace();
		initialize();
	}

	private void initialize() {

		setBounds(100, 100, 900, 700);

		Font lblFont = new Font("굴림", Font.PLAIN, 44);
		int lblWidth = 176;
		int lblHeight = 55;
		setLayout(null);
		JLabel lblNewLabel = new JLabel("회원관리");
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 44));
		lblNewLabel.setBounds(12, 27, 210, 51);
		add(lblNewLabel);

		JLabel lblId = new JLabel("아이디");
		lblId.setFont(new Font("Dialog", Font.BOLD, 12));
		lblId.setBounds(12, 88, 73, 35);
		add(lblId);

		JLabel lblPw = new JLabel("비밀번호");
		lblPw.setFont(new Font("Dialog", Font.BOLD, 12));
		lblPw.setBounds(12, 179, 73, 35);
		add(lblPw);

		JLabel lblName = new JLabel("이름");
		lblName.setFont(new Font("Dialog", Font.BOLD, 12));
		lblName.setBounds(12, 224, 48, 35);
		add(lblName);

		JLabel lblPhone = new JLabel("전화번호");
		lblPhone.setFont(new Font("Dialog", Font.BOLD, 12));
		lblPhone.setBounds(12, 269, 73, 35);
		add(lblPhone);
		
		JLabel lblGender = new JLabel("성별");
		lblGender.setFont(new Font("Dialog", Font.BOLD, 12));
		lblGender.setBounds(12, 304, 57, 23);
		add(lblGender);


		JLabel lblYear = new JLabel("년");
		lblYear.setFont(new Font("Dialog", Font.BOLD, 12));
		lblYear.setBounds(12, 330, 36, 35);
		add(lblYear);

		JLabel lblMonth = new JLabel("월");
		lblMonth.setFont(new Font("Dialog", Font.BOLD, 12));
		lblMonth.setBounds(12, 375, 48, 35);
		add(lblMonth);

		JLabel lblDay = new JLabel("일");
		lblDay.setFont(new Font("Dialog", Font.BOLD, 12));
		lblDay.setBounds(12, 420, 48, 35);
		add(lblDay);

		JLabel lblPoint = new JLabel("포인트");
		lblPoint.setFont(new Font("Dialog", Font.BOLD, 12));
		lblPoint.setBounds(12, 465, 59, 35);
		add(lblPoint);

		textId = new JTextField();
		textId.setFont(new Font("굴림", Font.PLAIN, 12));
		textId.setBounds(97, 88, 125, 35);
		add(textId);
		textId.setColumns(10);

		textPw = new JTextField();
		textPw.setFont(new Font("굴림", Font.PLAIN, 12));
		textPw.setBounds(97, 179, 125, 35);
		add(textPw);
		textPw.setColumns(10);

		textName = new JTextField();
		textName.setFont(new Font("굴림", Font.PLAIN, 12));
		textName.setColumns(10);
		textName.setBounds(97, 224, 125, 35);
		add(textName);

		textPhone = new JTextField();
		textPhone.setFont(new Font("굴림", Font.PLAIN, 12));
		textPhone.setColumns(10);
		textPhone.setBounds(97, 269, 125, 35);
		add(textPhone);
		
		rdbtnman = new JRadioButton("남자");
		rdbtnman.setBounds(93, 303, 65, 23);
		add(rdbtnman);
		
		rdbtnwoman = new JRadioButton("여자");
		rdbtnwoman.setBounds(160, 303, 62, 23);
		add(rdbtnwoman);


		textYear = new JTextField();
		textYear.setFont(new Font("굴림", Font.PLAIN, 12));
		textYear.setColumns(10);
		textYear.setBounds(97, 330, 125, 35);
		add(textYear);

		textMonth = new JTextField();
		textMonth.setFont(new Font("굴림", Font.PLAIN, 12));
		textMonth.setColumns(10);
		textMonth.setBounds(97, 375, 125, 35);
		add(textMonth);

		textDay = new JTextField();
		textDay.setFont(new Font("굴림", Font.PLAIN, 12));
		textDay.setColumns(10);
		textDay.setBounds(97, 420, 125, 35);
		add(textDay);

		textPoint = new JTextField();
		textPoint.setFont(new Font("굴림", Font.PLAIN, 12));
		textPoint.setColumns(10);
		textPoint.setBounds(97, 465, 125, 35);
		add(textPoint);

		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(234, 97, 521, 576);
		add(scrollPane_2);

		textIndex = new JTextField();
		textIndex.setText("번호입력");
		textIndex.setFont(new Font("굴림", Font.PLAIN, 12));
		textIndex.setBounds(122, 505, 88, 35);
		add(textIndex);
		textIndex.setColumns(10);

		// 아이디 중복확인
		JButton btnIdCheck = new JButton("아이디 중복 확인");
		btnIdCheck.setBounds(46, 134, 176, 35);
		btnIdCheck.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				idcheck();

			}
		});
		add(btnIdCheck);

		// 등록
		JButton btnInsert = new JButton("등록");
		btnInsert.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				insertMem();
			}
		});
		btnInsert.setFont(new Font("굴림", Font.PLAIN, 12));
		btnInsert.setBounds(12, 505, 88, 35);
		add(btnInsert);

		// 하나검색
		JButton btnSearch = new JButton("검색");
		btnSearch.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				selectMem();
			}
		});

		btnSearch.setFont(new Font("굴림", Font.PLAIN, 12));
		btnSearch.setBounds(12, 595, 88, 35);
		add(btnSearch);

		// 수정
		JButton btnUpdate = new JButton("수정");
		btnUpdate.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				updateMem();
			}
		});

		btnUpdate.setFont(new Font("굴림", Font.PLAIN, 12));
		btnUpdate.setBounds(12, 550, 88, 35);
		add(btnUpdate);

		// 삭제
		JButton btnDelete = new JButton("삭제");
		btnDelete.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				deleteMem();
			}
		});

		btnDelete.setFont(new Font("굴림", Font.PLAIN, 12));
		btnDelete.setBounds(122, 595, 88, 35);
		add(btnDelete);

		// 전체 검색
		JButton btnAllSearch = new JButton("전체검색");
		btnAllSearch.addActionListener((e) -> {
			selectAllMem();
		});
		btnAllSearch.setFont(new Font("굴림", Font.PLAIN, 9));
		btnAllSearch.setBounds(122, 551, 88, 35);
		add(btnAllSearch);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 640, 200, 35);
		add(scrollPane);

		textArea = new JTextArea();
		textArea.setBounds(0, 0, 4, 24);
		scrollPane.setViewportView(textArea);

		// 테이블 기본형태 초기화
		tableModel = new DefaultTableModel(colNames, 0); // 모델 이름과 행 개수 설정
		table = new JTable(tableModel); // 테이블 모델을 테이블에 적용
		table.setFont(new Font("굴림", Font.PLAIN, 15));
		scrollPane_2.setViewportView(table);

	} // end initialize()

	// 회원 등록 함수
		public void insertMem() {
			String mem_id = textId.getText();
			String mem_pw = textPw.getText();
			String mem_name = textName.getText();
			String mem_phone = textPhone.getText();
			String mem_gender = "";
			if(rdbtnman.isSelected()) {
				mem_gender = "남자";
			} else if(rdbtnwoman.isSelected()) {
				mem_gender = "여자";
			}
			String mem_year = textYear.getText();
			String mem_month = textMonth.getText();
			String mem_day = textDay.getText();
			final int mem_point = 1000;


			if (mem_id.equals("") || mem_pw.equals("") || mem_name.equals("") || mem_phone.equals("") || mem_year.equals("")
					|| mem_month.equals("") || mem_day.equals("")) {
				JOptionPane.showMessageDialog(null, "입력하지 않은 정보를 입력하세요.");
				return;
			}

			// 전화번호 숫자만 인식
			if (mem_phone.equals(textPhone.getText())) {
				for (char c : mem_phone.toCharArray()) {
					if (!Character.isDigit(c)) {
						JOptionPane.showMessageDialog(null, "전화번호에 문자가 포함되었습니다.");
						return;
					}
				}
			}

			// 년, 월, 일 숫자만 인식할수 있게
			if (mem_year.equals(textYear.getText())) {
				for (char c : mem_year.toCharArray()) {
					if (!Character.isDigit(c)) {
						JOptionPane.showMessageDialog(null, "년에 문자가 포함되었습니다.");
						return;
					}
				}
			}

			if (mem_month.equals(textMonth.getText())) {
				for (char c : mem_month.toCharArray()) {
					if (!Character.isDigit(c)) {
						JOptionPane.showMessageDialog(null, "월에 문자가 포함되었습니다.");
						return;
					}
				}
			}

			if (mem_day.equals(textDay.getText())) {
				for (char c : mem_day.toCharArray()) {
					if (!Character.isDigit(c)) {
						JOptionPane.showMessageDialog(null, "일에 문자가 포함되었습니다.");
						return;
					}
				}
			}

			MemberVO vo = new MemberVO(0, mem_id, mem_pw, mem_name, mem_phone, mem_gender, mem_year, mem_month, mem_day, 1000);
			int result = dao.insert_mem(vo);

			if (result == 1) {
				JOptionPane.showMessageDialog(null, "회원가입이 완료되었습니다.");

			} else {
				JOptionPane.showMessageDialog(this, "가입이 정상적으로 처리되지 않았습니다.");

			}

		} // end insertMem()

		// 회원 전체검색 함수
		public void selectAllMem() {
			tableModel.setRowCount(0);
			ArrayList<MemberVO> list = dao.selectAll_mem();
			int size = list.size();

			for (int i = 0; i < size; i++) {
				records[0] = list.get(i).getMem_num();
				records[1] = list.get(i).getMem_id();
				records[2] = list.get(i).getMem_pw();
				records[3] = list.get(i).getMem_name();
				records[4] = list.get(i).getMem_phone();
				records[5] = list.get(i).getMem_gender();
				records[6] = list.get(i).getMem_year();
				records[7] = list.get(i).getMem_month();
				records[8] = list.get(i).getMem_day();
				records[9] = list.get(i).getMem_point();

				tableModel.addRow(records);
			}

		} // end selectAllMem()

		// 회원 상세 검색
		public void selectMem() {
			try {
				int index = Integer.parseInt(textIndex.getText());
				MemberVO vo = dao.select_mem(index);
				textArea.setText(vo.getMem_name());
			} catch (NumberFormatException e) {
				e.printStackTrace();
				JOptionPane.showMessageDialog(null, "0 이상의 정수를 입력하세요.");
			} catch (IndexOutOfBoundsException e) {
				e.printStackTrace();
				JOptionPane.showMessageDialog(null, "0 이상의 정수를 입력하세요.");
			} catch (NullPointerException e) {
				e.printStackTrace();
				JOptionPane.showMessageDialog(null, "없는 번호입니다");
			}

		} // end selectMem()

		// 회원 정보 수정
		public void updateMem() {
			String mem_id = textId.getText();
			String mem_pw = textPw.getText();
			String mem_name = textName.getText();
			String mem_phone = textPhone.getText();
			String mem_gender = "";
			if(rdbtnman.isSelected()) {
				mem_gender = "남자";
			} else if(rdbtnwoman.isSelected()) {
				mem_gender = "여자";
			}
			String mem_year = textYear.getText();
			String mem_month = textMonth.getText();
			String mem_day = textDay.getText();
			int mem_point = Integer.parseInt(textPoint.getText());


			// 전화번호 숫자만 인식
			if (mem_phone.equals(textPhone.getText())) {
				for (char c : mem_phone.toCharArray()) {
					if (!Character.isDigit(c)) {
						JOptionPane.showMessageDialog(null, "전화번호에 문자가 포함되었습니다.");
						return;
					}
				}
			}

			// 년, 월, 일 숫자만 인식할수 있게
			if (mem_year.equals(textYear.getText())) {
				for (char c : mem_year.toCharArray()) {
					if (!Character.isDigit(c)) {
						JOptionPane.showMessageDialog(null, "년에 문자가 포함되었습니다.");
						return;
					}
				}
			}

			if (mem_month.equals(textMonth.getText())) {
				for (char c : mem_month.toCharArray()) {
					if (!Character.isDigit(c)) {
						JOptionPane.showMessageDialog(null, "월에 문자가 포함되었습니다.");
						return;
					}
				}
			}

			if (mem_day.equals(textDay.getText())) {
				for (char c : mem_day.toCharArray()) {
					if (!Character.isDigit(c)) {
						JOptionPane.showMessageDialog(null, "일에 문자가 포함되었습니다.");
						return;
					}
				}
			}

			try {
				int index = Integer.parseInt(textIndex.getText());
				MemberVO vo = new MemberVO(0, mem_id, mem_pw, mem_name, mem_phone, mem_gender, mem_year, mem_month, mem_day, mem_point);
				int result = dao.update_mem(index, vo);
				if (result == 1) {
					JOptionPane.showMessageDialog(null, "회원 정보 수정 성공");
				} else {
					JOptionPane.showMessageDialog(null, index + "번 회원 정보가 존재하지 않습니다.");
				}
			} catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(null, "0 이상의 정수를 입력하세요.");
			} catch (IndexOutOfBoundsException e) {
				JOptionPane.showMessageDialog(null, "0 이상의 정수를 입력하세요.");
			}

		} // end updateMem()

		// 회원 정보 삭제
		public void deleteMem() {
			int index = 0;
			try {
				index = Integer.parseInt(textIndex.getText());

			} catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(null, "0 이상의 정수를 입력하세요.");
			} catch (IndexOutOfBoundsException e) {
				JOptionPane.showMessageDialog(null, "0 이상의 정수를 입력하세요.");
			}

			int result = dao.delete_mem(index);
			if (result == 1) {
				JOptionPane.showMessageDialog(null, "회원 정보 삭제 성공");
			} else {
				JOptionPane.showMessageDialog(null, index + "번 회원 정보가 존재하지 않습니다.");
			}
		}// end deleteEmp()

		public void idcheck() {
			String mem_id = textId.getText();
			try {
				MemberVO vo = dao.select_idcheck(mem_id);

				if ((textId.getText().equals(""))) {
					JOptionPane.showMessageDialog(null, "아이디를 입력해주세요.");
				} else if ((textId.getText().equals((vo.getMem_id())))) {
					JOptionPane.showMessageDialog(null, "사용중인 아이디 입니다.");
				} else {
					JOptionPane.showMessageDialog(null, "사용가능한 아이디 입니다.");
				}
			} catch (NullPointerException e) {
				JOptionPane.showMessageDialog(null, "존재하지 않는 회원 정보 입니다.");
			}
		} // end idcheck()
	} // end
