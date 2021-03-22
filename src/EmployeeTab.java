

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class EmployeeTab extends JPanel{

	private JFrame f;
	private JTextField textName, textPhone, textAddress, textIndex;
	public static EmployeeDAO dao;
	private JTextArea textArea;

	/* 스윙 테이블을 사용하기 위한 멤버 변수 선언 */
	private JTable table;
	private String[] colNames = { "No", "이름", "전화번호", "주소", "직책", "업무", "근무요일", "근무시간", "비고" }; // 테이블 헤더에 들어갈 이름들
	private Object[] records = new Object[colNames.length]; // 테이블 데이터를 저장할 배열 객체
	private String rank[] = { "점장", "매니저", "직원", "아르바이트" };
	private String job[] = { "매장관리", "캐셔", "바리스타", "파티쉐", "청소", "기타" };
	private DefaultTableModel tableModel; // 테이블 형태를 만들 모델 변수
	private JTextField textDate;
	private JTextField textTime;
	private JTextField textNote;
	private JComboBox cbBoxRank;
	private JComboBox cbBoxJob;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EmployeeTab window = new EmployeeTab();
					window.f.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public EmployeeTab() {
		dao = EmployeeDAOImple.getInstance(); // 싱글톤 객체 불러오기
		initialize();
	}

	private void initialize() {
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		frame = new JFrame();
		setBounds(100, 100, 786, 662);
//		frame.getContentPane().setLayout(null);

		Font lblFont = new Font("굴림", Font.PLAIN, 44);
		int lblWidth = 176;
		int lblHeight = 55;
		setLayout(null);
		JLabel lblNewLabel = new JLabel("직원관리");
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 44));
		lblNewLabel.setBounds(12, 10, 223, 51);
		add(lblNewLabel);

		JLabel lblName = new JLabel("이름");
		lblName.setFont(new Font("Dialog", Font.BOLD, 12));
		lblName.setBounds(12, 90, 69, 32);
		add(lblName);

		JLabel lblPhone = new JLabel("전화번호");
		lblPhone.setFont(new Font("Dialog", Font.BOLD, 12));
		lblPhone.setBounds(12, 137, 69, 32);
		add(lblPhone);

		JLabel lblAddress = new JLabel("주소");
		lblAddress.setFont(new Font("Dialog", Font.BOLD, 12));
		lblAddress.setBounds(12, 190, 69, 32);
		add(lblAddress);

		JLabel lblRank = new JLabel("직급");
		lblRank.setFont(new Font("Dialog", Font.BOLD, 12));
		lblRank.setBounds(12, 232, 69, 32);
		add(lblRank);

		JLabel lblJob = new JLabel("업무");
		lblJob.setFont(new Font("Dialog", Font.BOLD, 12));
		lblJob.setBounds(12, 284, 69, 32);
		add(lblJob);

		JLabel lblDate = new JLabel("근무요일");
		lblDate.setFont(new Font("Dialog", Font.BOLD, 12));
		lblDate.setBounds(12, 326, 69, 32);
		add(lblDate);

		JLabel lblTime = new JLabel("근무시간");
		lblTime.setFont(new Font("Dialog", Font.BOLD, 12));
		lblTime.setBounds(12, 378, 69, 32);
		add(lblTime);

		JLabel lblNote = new JLabel("비고");
		lblNote.setFont(new Font("Dialog", Font.BOLD, 12));
		lblNote.setBounds(12, 420, 57, 32);
		add(lblNote);

		textName = new JTextField();
		textName.setFont(new Font("굴림", Font.PLAIN, 12));
		textName.setBounds(92, 96, 116, 32);
		add(textName);
		textName.setColumns(10);

		textPhone = new JTextField();
		textPhone.setFont(new Font("굴림", Font.PLAIN, 12));
		textPhone.setBounds(92, 142, 116, 32);
		add(textPhone);
		textPhone.setColumns(10);

		textAddress = new JTextField();
		textAddress.setFont(new Font("굴림", Font.PLAIN, 12));
		textAddress.setBounds(92, 191, 116, 32);
		add(textAddress);
		textAddress.setColumns(10);

		textDate = new JTextField();
		textDate.setFont(new Font("굴림", Font.PLAIN, 12));
		textDate.setColumns(10);
		textDate.setBounds(92, 327, 116, 32);
		add(textDate);

		textTime = new JTextField();
		textTime.setFont(new Font("굴림", Font.PLAIN, 12));
		textTime.setColumns(10);
		textTime.setBounds(93, 372, 116, 32);
		add(textTime);

		textNote = new JTextField();
		textNote.setFont(new Font("굴림", Font.PLAIN, 12));
		textNote.setColumns(10);
		textNote.setBounds(92, 421, 116, 32);
		add(textNote);


		cbBoxRank = new JComboBox(rank); // 콤보박스 생성
		cbBoxRank.setBounds(93, 235, 115, 32);
		add(cbBoxRank);

//		JComboBox cbBoxJob = new JComboBox(job);
//		cbBoxJob.addActionListener(new ActionListener() {
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				String job = cbBoxJob.getSelectedItem().toString();
//			}
//		});
//		cbBoxJob.setBounds(110, 257, 123, 29);
//		frame.getContentPane().add(cbBoxJob);

		cbBoxJob = new JComboBox(job);
		cbBoxJob.setBounds(93, 284, 115, 32);
		add(cbBoxJob);
		
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(233, 90, 529, 562);
		add(scrollPane_2);

		textIndex = new JTextField();
		textIndex.setText("번호입력");
		textIndex.setFont(new Font("굴림", Font.PLAIN, 12));
		textIndex.setBounds(121, 463, 86, 42);
		add(textIndex);
		textIndex.setColumns(10); // TODO: index오류

		JButton btnInsert = new JButton("등록");
		btnInsert.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				insertEmp();
			}
		});
		btnInsert.setFont(new Font("굴림", Font.PLAIN, 12));
		btnInsert.setBounds(12, 462, 97, 42);
		add(btnInsert);

		JButton btnSearch = new JButton("검색");
		btnSearch.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				selectEmp();
			}
		});

		btnSearch.setFont(new Font("굴림", Font.PLAIN, 12));
		btnSearch.setBounds(12, 566, 97, 42);
		add(btnSearch);

		JButton btnUpdate = new JButton("수정");
		btnUpdate.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				updateEmp();
			}
		});

		btnUpdate.setFont(new Font("굴림", Font.PLAIN, 12));
		btnUpdate.setBounds(12, 514, 97, 42);
		add(btnUpdate);

		JButton btnDelete = new JButton("삭제");
		btnDelete.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				deleteEmp();
			}
		});

		btnDelete.setFont(new Font("굴림", Font.PLAIN, 12));
		btnDelete.setBounds(121, 566, 87, 42);
		add(btnDelete);

		JButton btnAllSearch = new JButton("전체검색");
		btnAllSearch.addActionListener((e) -> {
			selectAllEmp();
		});
		btnAllSearch.setFont(new Font("굴림", Font.PLAIN, 9));
		btnAllSearch.setBounds(121, 517, 87, 42);
		add(btnAllSearch);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 620, 200, 32);
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

	// 직원 등록 함수
	public void insertEmp() {
		String emp_name = textName.getText();
		String emp_phone = textPhone.getText();
		String emp_address = textAddress.getText();
		
//		String emp_rank = (String) cbBoxRank.getSelectedItem();
//		String emp_job = (String) cbBoxJob.getSelectedItem();
		
		
//		String emp_rank = cbBoxRank.getSelectedItem().toString();
//		String emp_job = cbBoxJob.getSelectedItem().toString();
		
		
		String emp_rank = (String) cbBoxRank.getSelectedItem();
		String emp_job = (String) cbBoxJob.getSelectedItem();
		
		
//		String emp_rank = (String) valueOf(cbBoxRank.getSelectedItem());
//		String emp_job = (String) cbBoxJob.getSelectedItem();
		
		String emp_date = textDate.getText();
		String emp_time = textTime.getText();
		String emp_note = textNote.getText();

		if (emp_name.equals("") || emp_phone.equals("") || emp_address.equals("") || emp_date.equals("")
				|| emp_time.equals("") || emp_note.equals("")) {
			JOptionPane.showMessageDialog(null, "입력하지 않은 정보를 입력하세요.");
			return;
		}

		EmployeeVO vo = new EmployeeVO(0, emp_name, emp_phone, emp_address, emp_rank, emp_job, emp_date, emp_time,
				emp_note);
		int result = dao.insert_emp(vo);

		if (result == 1) {
			JOptionPane.showMessageDialog(null, "직원이 등록되었습니다.");

		} else {
			JOptionPane.showMessageDialog(null, "직원이 정상으로 등록되지 않았습니다.");

		}

	} // end insertEmp()


	// 직원 전체검색 함수
	public void selectAllEmp() {
		tableModel.setRowCount(0);
		ArrayList<EmployeeVO> list = dao.selectAll_emp();
		int size = list.size();

		for (int i = 0; i < size; i++) {
			records[0] = list.get(i).getEmp_num();
			records[1] = list.get(i).getEmp_name();
			records[2] = list.get(i).getEmp_phone();
			records[3] = list.get(i).getEmp_address();
			records[4] = list.get(i).getEmp_rank();
			records[5] = list.get(i).getEmp_job();
			records[6] = list.get(i).getEmp_date();
			records[7] = list.get(i).getEmp_time();
			records[8] = list.get(i).getEmp_note();
			tableModel.addRow(records);
		}
	} // end selectAllEmp()

	
	// 직원 상세 검색
	public void selectEmp() {
		try {
			int index = Integer.parseInt(textIndex.getText());
			System.out.println(index);
			System.out.println("테스트");
			EmployeeVO vo = dao.select_emp(index);
			System.out.println(vo.getEmp_name());
			textArea.setText(vo.getEmp_name());
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
	} // end selectEmp()

	// 직원 정보 수정
	public void updateEmp() {
		String emp_name = textName.getText();
		String emp_phone = textPhone.getText();
		String emp_address = textAddress.getText();
		String emp_rank = (String) cbBoxRank.getSelectedItem();
		String emp_job = (String) cbBoxJob.getSelectedItem();
		String emp_date = textDate.getText();
		String emp_time = textTime.getText();
		String emp_note = textNote.getText();

		if (emp_name.equals("") || emp_phone.equals("") || emp_address.equals("") || emp_date.equals("")
				|| emp_time.equals("") || emp_note.equals("")) {
			JOptionPane.showMessageDialog(null, "저장할 정보를 입력하세요.");
			return;
		}

		try {
			int index = Integer.parseInt(textIndex.getText());
			EmployeeVO vo = new EmployeeVO(0, emp_name, emp_phone, emp_address, emp_rank, emp_job, emp_date, emp_time,
					emp_note);
			int result = dao.update_emp(index, vo);
			if (result == 1) {
				JOptionPane.showMessageDialog(null, "직원 정보 수정 성공");
			} else {
				JOptionPane.showMessageDialog(null, index + "번 직원 정보가 존재하지 않습니다.");
			}
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "0 이상의 정수를 입력하세요.");
		} catch (IndexOutOfBoundsException e) {
			JOptionPane.showMessageDialog(null, "0 이상의 정수를 입력하세요.");
		}

	} // end updateEmp()
	
	// 직원 정보 삭제
	public void deleteEmp() {
		int index = 0;
		try {
			index = Integer.parseInt(textIndex.getText());
			
		}   catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "0 이상의 정수를 입력하세요.");
		} catch (IndexOutOfBoundsException e) {
			JOptionPane.showMessageDialog(null, "0 이상의 정수를 입력하세요.");
		}
		
		int result = dao.delete_emp(index);
		if (result == 1) {
			JOptionPane.showMessageDialog(null, "직원 정보 삭제 성공");
		} else {
			JOptionPane.showMessageDialog(null, index + "번 직원 정보가 존재하지 않습니다.");
		}
	}// end deleteEmp()
	

} // end ContactMain05
