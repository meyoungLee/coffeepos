import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
//import javax.swing.table.DefaultTableModel;

import java.awt.Color;
import java.awt.Dimension;

public class StockManageTab extends JPanel {

	public static CoffeeDAO dao;


	private String[] stockNames = { "원두", "우유", "시럽", "딸기", "망고", "녹차", "홍차", "초코" };
	private JTable table;
	// private Object[] records3 = new Object[stockNames.length]; // 테이블 데이터를 저장할 배열
	// private DefaultTableModel tableModel_3; // 테이블 형태를 만들 모델 변수

	StockVO stock = new StockVO();
	JLabel lblNewLabel;
	int num;
	String stockname;
	private JTextField txtIndex;
	

	/**
	 * Create the application.
	 */
	public StockManageTab() {
		dao = CoffeeDAOImple.getInstance();
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {

		
		num = 0;// 초기화
		stock = dao.getstock();// 서버에서 데이터 받기
		
		
		setBounds(0, 0, 780, 711);
		setVisible(true);
		setLayout(null);

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 0, 784, 188);
		add(panel_1);
		panel_1.setLayout(null);

		JLabel lblStock_1 = new JLabel("\uC7AC\uACE0\uD604\uD669");
		lblStock_1.setBounds(34, 22, 65, 20);
		panel_1.add(lblStock_1);
		lblStock_1.setFont(new Font("굴림", Font.BOLD, 12));

		table = new JTable(dao.makestocklistArr(stock), stockNames);
		panel_1.add(table);

		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(81, 170, 572, -104);
		panel_1.add(scrollPane);

		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.LIGHT_GRAY);
		panel_2.setBounds(0, 187, 784, 496);
		add(panel_2);
		panel_2.setLayout(null);

		JLabel lblPrOrder = new JLabel("\uBB3C\uD488\uC8FC\uBB38");
		lblPrOrder.setBounds(23, 10, 100, 20);
		lblPrOrder.setFont(new Font("굴림", Font.BOLD, 12));
		panel_2.add(lblPrOrder);

		JButton btnStock_1 = new JButton("원두");
		btnStock_1.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				stockname = "원두";
				lblNewLabel.setText(stockname + "를 주문하실건가요? 수량을 입력하세요.");
			}
		});
		btnStock_1.setBounds(100, 61, 100, 60);
		panel_2.add(btnStock_1);

		JButton btnStock_2 = new JButton("\uC6B0\uC720");
		btnStock_2.setBounds(260, 61, 100, 60);
		panel_2.add(btnStock_2);
		btnStock_2.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				stockname = "우유";
				lblNewLabel.setText(stockname + "를 주문하실건가요? 수량을 입력하세요.");
			}
		});

		JButton btnStock_3 = new JButton("\uC2DC\uB7FD");
		btnStock_3.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				stockname = "시럽";
				lblNewLabel.setText(stockname + "을 주문하실건가요? 수량을 입력하세요.");
			}
		});
		btnStock_3.setBounds(420, 61, 100, 60);
		panel_2.add(btnStock_3);

		JButton btnStock_4 = new JButton("\uB538\uAE30");
		btnStock_4.setBounds(580, 61, 100, 60);
		panel_2.add(btnStock_4);
		btnStock_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				stockname = "딸기";
				lblNewLabel.setText(stockname + "를 주문하실건가요? 수량을 입력하세요.");
			}
		});

		JButton btnStock_5 = new JButton("\uB9DD\uACE0");
		panel_2.add(btnStock_5);
		btnStock_5.setBounds(100, 149, 100, 60);
		btnStock_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				stockname = "망고";
				lblNewLabel.setText(stockname + "를 주문하실건가요? 수량을 입력하세요.");
			}
		});

		JButton btnStock_6 = new JButton("\uB179\uCC28");
		btnStock_6.setBounds(260, 149, 100, 60);
		panel_2.add(btnStock_6);
		btnStock_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				stockname = "녹차";
				lblNewLabel.setText(stockname + "를 주문하실건가요? 수량을 입력하세요.");
			}
		});

		JButton btnStock_7 = new JButton("\uD64D\uCC28");
		btnStock_7.setBounds(420, 149, 100, 60);
		panel_2.add(btnStock_7);
		btnStock_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				stockname = "홍차";
				lblNewLabel.setText(stockname + "를 주문하실건가요? 수량을 입력하세요.");

			}
		});
		btnStock_7.setPreferredSize(new Dimension(100, 28));

		JButton btnStock_8 = new JButton("\uCD08\uCF54");
		panel_2.add(btnStock_8);
		btnStock_8.setBounds(580, 149, 100, 60);
		btnStock_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				stockname = "초코";
				lblNewLabel.setText(stockname + "를 주문하실건가요? 수량을 입력하세요.");
			}
		});

		JLabel lblOrderAmount = new JLabel("\uC8FC\uBB38\uC218\uB7C9\uC785\uB825");
		lblOrderAmount.setFont(new Font("굴림", Font.BOLD, 12));
		lblOrderAmount.setBounds(23, 278, 100, 20);
		panel_2.add(lblOrderAmount);

		txtIndex = new JTextField();
		txtIndex.setBounds(135, 278, 116, 21);
		panel_2.add(txtIndex);
		txtIndex.setColumns(10);

		lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(147, 339, 450, 30);
		panel_2.add(lblNewLabel);
		lblNewLabel.setFont(new Font("굴림", Font.BOLD, 17));

		JButton btnStockRefresh = new JButton("\uCD08\uAE30\uD654");// 초기화
		btnStockRefresh.setBounds(442, 412, 157, 52);
		panel_2.add(btnStockRefresh);

		btnStockRefresh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				stock = dao.getstock();

				JPanel panel_1 = new JPanel();
				panel_1.setBounds(0, 0, 534, 198);
				add(panel_1);
				panel_1.setLayout(null);

				table = new JTable(dao.makestocklistArr(stock), stockNames);
				table.setBounds(39, 25, 450, 150);
				panel_1.add(table);

				JScrollPane scrollPane = new JScrollPane(table);
				scrollPane.setBounds(39, 57, 450, 120);
				panel_1.add(scrollPane);

			}
		});
//		btnStockRefresh.addActionListener((e) -> {
//
//			StockRefresh();
//		});

		JButton btnStockPlus = new JButton("\uC8FC\uBB38");// 주문

		btnStockPlus.setBounds(114, 412, 157, 52);
		panel_2.add(btnStockPlus);

		btnStockPlus.addActionListener((e) -> {
			StockOrderbtn();
		});

	}

	public void StockOrderbtn() { // 재고 주문(이전 재고 업데이트 + 주문)

//		try {
//
//			StockVO stock = new StockVO(0, 0, 0, 0, 0, 0, 0, 0);
	//		StockVO Stock = new StockVO();
	//		String txtindex;
			int index = Integer.parseInt(txtIndex.getText());

			if (stockname.equals("원두")) {
				stock.setWondu(stock.getWondu() + index);
			} else if (stockname.equals("우유")) {
				stock.setMilk(stock.getMilk() + index);
			} else if (stockname.equals("시럽")) {
				stock.setSirup(stock.getSirup() + index);
			} else if (stockname.equals("딸기")) {
				stock.setBerry(stock.getBerry() + index);
			} else if (stockname.equals("망고")) {
				stock.setMango(stock.getMango() + index);
			} else if (stockname.equals("녹차")) {
				stock.setGreen(stock.getGreen() + index);
			} else if (stockname.equals("홍차")) {
				stock.setBlack(stock.getBlack() + index);
			} else if (stockname.equals("초코")) {
				stock.setChoco(stock.getChoco() + index);
			}

			System.out.println(stock);
			dao.stockorder(stock);
			stockname = "";
			txtIndex.setText("");
			lblNewLabel.setText("");
			JOptionPane.showMessageDialog(null, "주문이 성공하였습니다.");
//
//		} catch (Exception e) {
//			// TODO: handle exception
//		}

	}// end StockOrder

//	public void StockRefresh() {
//	tableModel_3.setRowCount(0);// 테이블 데이터 초기화
//
//	ArrayList<StockVO> list = dao.getstock();
//	int size = list.size();
//
//	for (int i = 0; i < size; i++) {
//
//		records3[0] = list.get(i).getWondu();
//		records3[1] = list.get(i).getMilk();
//		records3[2] = list.get(i).getSirup();
//		records3[3] = list.get(i).getBerry();
//		records3[4] = list.get(i).getMango();
//		records3[5] = list.get(i).getGreen();
//		records3[6] = list.get(i).getBlack();
//		records3[7] = list.get(i).getChoco();
//
//		tableModel_3.addRow(records3);
//
//	}	
//}// end StockRefresh

}// end Stock_Manage
