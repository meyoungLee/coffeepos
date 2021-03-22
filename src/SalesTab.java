import java.awt.Color;
import java.awt.Font;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class SalesTab extends JPanel {

	public static CoffeeDAO dao;
	JLabel lblNewLabel;
	ArrayList<CoffeeVO> rowData = null;

	// 매출
	/* 스윙 테이블을 사용하기 위한 멤버 변수 선언 */
	private String[] colNames = { "이름", "사이즈", "샷", "온도", "가격", "휘핑크림", "Take_out","ICE" }; // 테이블 헤더에 들어갈 이름들
	private Object[] records1 = new Object[colNames.length]; // 테이블 데이터를 저장할 배열 객체
	private DefaultTableModel tableModel_1; // 테이블 형태를 만들 모델 변수

	private String[] sellNames = { "이름", "판매잔수" }; // 테이블 헤더에 들어갈 이름들
	private Object[] records2 = new Object[sellNames.length]; // 테이블 데이터를 저장할 배열 객체
	private DefaultTableModel tableModel_2; // 테이블 형태를 만들 모델 변수

	private JTable table;
	private JTable table_1;

	/**
	 * Create the application.
	 */
	public SalesTab() {

		dao = CoffeeDAOImple.getInstance();
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {

		rowData = dao.GetAllSellList();

		setBackground(Color.WHITE);
		setBounds(0, 0, 784, 683);
		setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(Color.LIGHT_GRAY);
		panel.setBounds(25, 24, 704, 272);
		add(panel);
		panel.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 57, 680, 210);
		panel.add(scrollPane);

		tableModel_1 = new DefaultTableModel(colNames, 0); // 모델 이름과 행 개수 설정
		table = new JTable(tableModel_1); // 테이블 모델을 테이블에 적용;
		table.setFont(new Font("굴림", Font.PLAIN, 15));
		scrollPane.setViewportView(table);
		
		JLabel lblNewLabel_1 = new JLabel("\uC624\uB298 \uD310\uB9E4\uB41C \uC74C\uB8CC");
		lblNewLabel_1.setFont(new Font("Dialog", Font.BOLD, 14));
		lblNewLabel_1.setBounds(12, 10, 125, 37);
		panel.add(lblNewLabel_1);

		Panel panel_1 = new Panel();
		panel_1.setBackground(Color.LIGHT_GRAY);
		panel_1.setBounds(25, 331, 704, 224);
		add(panel_1);
		panel_1.setLayout(null);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(12, 49, 680, 165);
		panel_1.add(scrollPane_1);

		tableModel_2 = new DefaultTableModel(sellNames, 0); // 모델 이름과 행 개수 설정
		table_1 = new JTable(tableModel_2);
		table_1.setFont(new Font("굴림", Font.PLAIN, 15));
		scrollPane_1.setViewportView(table_1);
		
		JLabel lblNewLabel_2 = new JLabel("\uC74C\uB8CC\uBCC4 \uD310\uB9E4\uC794\uC218");
		lblNewLabel_2.setFont(new Font("Dialog", Font.BOLD, 14));
		lblNewLabel_2.setBounds(12, 10, 125, 26);
		panel_1.add(lblNewLabel_2);

		JButton btnRefresh = new JButton("\uC624\uB298\uC758 \uB9E4\uCD9C");
		btnRefresh.setFont(new Font("굴림", Font.PLAIN, 16));
		btnRefresh.addActionListener((e) -> {
			SellList();
			SellNameList();

		});
		btnRefresh.setBounds(86, 602, 127, 40);
		add(btnRefresh);


//		JButton btnNewButton = new JButton("\uC624\uB298\uC758 \uB9E4\uCD9C"); //오늘 총매출
//		btnNewButton.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {// 테이블에 전체 매출 리스트 출력
//				rowData = dao.GetAllSellList();
//				int sum = 0;
//				for (int i = 0; i < rowData.size(); i++) {
//					sum += rowData.get(i).getCoff_price();
//				}
//
//				lblNewLabel.setText("오늘의 매출은 " + Integer.toString(sum) + " 입니다.");
//
//			}
//		});
		
		
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 14));
		lblNewLabel.setBounds(259, 561, 233, 31);
		add(lblNewLabel);
		
		JButton btnNewButton = new JButton("\uCD1D \uB9E4\uCD9C");
		btnNewButton.setFont(new Font("굴림", Font.PLAIN, 16));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rowData = dao.GetAllSellList();
				int sum = 0;
				for (int i = 0; i < rowData.size(); i++) {
					sum += rowData.get(i).getCoff_price();
				}
				lblNewLabel.setText("오늘의 매출은 " + Integer.toString(sum) + " 입니다.");
				
			}
		});
		btnNewButton.setBounds(520, 602, 127, 40);
		add(btnNewButton);


	}// end initialize

	public void SellList() {

		tableModel_1.setRowCount(0);// 테이블 데이터 초기화
		ArrayList<CoffeeVO> list = dao.GetAllSellList();
		int size = list.size();

		for (int i = 0; i < size; i++) {

			records1[0] = list.get(i).getCoff_name();
			records1[1] = list.get(i).getCoff_size();
			records1[2] = list.get(i).getCoff_shot();
			records1[3] = list.get(i).getCoff_temp();
			records1[4] = list.get(i).getCoff_price();
			records1[5] = list.get(i).getCoff_cream();
			records1[6] = list.get(i).getCoff_takeout();
			records1[7] = list.get(i).getCoff_ice();
			tableModel_1.addRow(records1);
		}

	}// end SellList

	public void SellNameList() {

		tableModel_2.setRowCount(0);// 테이블 데이터 초기화

		ArrayList<CoffeeVO> lists = dao.Getsellcount();
		int size = lists.size();

		for (int i = 0; i < size; i++) {

			records2[0] = lists.get(i).getCoff_name();
			records2[1] = lists.get(i).getCoff_price();

			tableModel_2.addRow(records2);
		}

	}// end SellNameList
}// end Sales_Tab
