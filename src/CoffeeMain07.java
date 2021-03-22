import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;

import javax.swing.JPanel;
import javax.swing.JTabbedPane;

public class CoffeeMain07 {

	private JFrame frame;
	public static CoffeeDAO dao;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		dao = CoffeeDAOImple.getInstance();// �̱��� ��ü ��������
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CoffeeMain07 window = new CoffeeMain07();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */

	public CoffeeMain07() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		// frame.setBounds(400, 150, 796, 750);
		frame.setBounds(400, 150, 790, 750);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JTabbedPane screen = new JTabbedPane();
		screen.setBounds(0, 0, 780, 711);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(screen);

		JPanel OrderTab = new JPanel();
		OrderTab.setBackground(Color.WHITE);
		screen.addTab("�ֹ�", new OrderTab());

		JPanel SalesTab = new JPanel();
		SalesTab.setBackground(Color.WHITE);
		screen.addTab("����", new SalesTab());

		JPanel StockManage = new JPanel();
		StockManage.setBackground(Color.WHITE);
		screen.addTab("������", new StockManageTab());

		JPanel EmployeeManage = new JPanel();
		EmployeeManage.setBackground(Color.WHITE);
		screen.addTab("��������", new EmployeeTab());

		JPanel MemManage = new JPanel();
		MemManage.setBackground(Color.WHITE);
		screen.addTab("ȸ������", new MemberTab());

	}

}// end CoffeeMain07
