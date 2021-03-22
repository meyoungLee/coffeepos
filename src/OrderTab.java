
import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

import javax.swing.JTextField;
import javax.swing.UIManager;



public class OrderTab extends JPanel {

	public static CoffeeDAO dao;
//	CoffeeDAO dao = null;

	ArrayList<CoffeeVO> list = new ArrayList<CoffeeVO>();
	CoffeeVO coffee = null;
	StockVO stock = null;

	JLabel lblTotalAmount;
	String menu = "";
	int count = 0;

	boolean flag_size = false;// �ѹ��̶� Ŭ���ϸ� true
	boolean flag_shot = false;// �ѹ��̶� Ŭ���ϸ� true
	private final ButtonGroup buttonGroup = new ButtonGroup(); //  HOT/ICE
	private final ButtonGroup buttonGroup_1 = new ButtonGroup(); // ���� SIZE
	private final ButtonGroup buttonGroup_2 = new ButtonGroup(); // ���߰�
	private final ButtonGroup buttonGroup_3 = new ButtonGroup(); // ������
	private final ButtonGroup buttonGroup_4 = new ButtonGroup(); // ����ũ�� 
	private final ButtonGroup buttonGroup_5 = new ButtonGroup(); // TAKE OUT

	private JTextField textField;


	public OrderTab() {

		dao = CoffeeDAOImple.getInstance();
		initialize();
	}

	private void initialize() {

		
		coffee = new CoffeeVO();
		stock = dao.getstock();
		System.out.println(stock);

		setBackground(Color.BLACK);
		setBounds(0, 0, 780, 711);
		setLayout(null);

		JButton btnCoffee = new JButton("����������"); //���������� ��ư
		btnCoffee.setForeground(Color.BLACK);
		btnCoffee.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				count++;
				stock.setWondu(stock.getWondu() - 1); // ������� ����
				showlabel("����������", 3000);

			}
		});
		btnCoffee.setBounds(50, 37, 100, 70);
		add(btnCoffee);

		JButton btnCoffee_1 = new JButton("�Ƹ޸�ī��"); //�Ƹ޸�ī�� ��ư
		btnCoffee_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				count++;
				stock.setWondu(stock.getWondu() - 1);
				showlabel("�Ƹ޸�ī��", 4000);
			}
		});
		btnCoffee_1.setBounds(200, 37, 100, 70);
		add(btnCoffee_1);

		JButton btnCoffee_2 = new JButton("ī���"); //ī��� ��ư
		btnCoffee_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				count++;
				stock.setWondu(stock.getWondu() - 1);
				stock.setMilk(stock.getMilk() - 1);
				showlabel("ī���", 4500);
			}
		});
		btnCoffee_2.setBounds(350, 37, 100, 70);
		add(btnCoffee_2);

		JButton btnCoffee_3 = new JButton("\uBC14\uB2D0\uB77C\uB77C\uB5BC"); //�ٴҶ� �� ��ư
		btnCoffee_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				count++;
				stock.setWondu(stock.getWondu() - 1);
				stock.setMilk(stock.getMilk() - 1);
				stock.setSirup(stock.getSirup() - 1);
				showlabel("�ٴҶ��", 4600);
			}
		});
		btnCoffee_3.setBounds(500, 37, 100, 70);
		add(btnCoffee_3);

		JButton btnCoffee_4 = new JButton("\uADF8\uB9B0\uD2F0\uB77C\uB5BC"); //�׸�Ƽ �� ��ư
		btnCoffee_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				count++;
				stock.setWondu(stock.getWondu() - 1);
				stock.setMilk(stock.getMilk() - 1);
				stock.setSirup(stock.getSirup() - 1);
				showlabel("�׸�Ƽ��", 4800);
			}
		});
		btnCoffee_4.setBounds(650, 37, 100, 70);
		add(btnCoffee_4);

		JButton btnCoffee_5 = new JButton("\uCE74\uD478\uCE58\uB178"); // īǪġ�� ��ư
		btnCoffee_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				count++;
				stock.setWondu(stock.getWondu() - 1);
				stock.setMilk(stock.getMilk() - 1);
				stock.setSirup(stock.getSirup() - 1);
				showlabel("īǪġ��", 4900);
			}
		});
		btnCoffee_5.setBounds(50, 148, 100, 70);
		add(btnCoffee_5);

		JButton btnCoffee_6 = new JButton("\uB3CC\uCCB4\uB77C\uB5BC"); // ������ ��ư
		btnCoffee_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				count++;
				stock.setWondu(stock.getWondu() - 1);
				stock.setMilk(stock.getMilk() - 1);
				stock.setSirup(stock.getSirup() - 1);
				showlabel("��ü��", 5100);
			}
		});
		btnCoffee_6.setBounds(200, 148, 100, 70);
		add(btnCoffee_6);

		JButton btnCoffee_7 = new JButton("\uCE74\uD398\uBAA8\uCE74"); // ī���ī ��ư
		btnCoffee_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				count++;
				stock.setWondu(stock.getWondu() - 1);
				stock.setMilk(stock.getMilk() - 1);
				stock.setChoco(stock.getChoco() - 1);
				stock.setSirup(stock.getSirup() - 1);
				showlabel("ī���ī", 4300);
			}
		});
		btnCoffee_7.setBounds(350, 148, 100, 70);
		add(btnCoffee_7);

		JButton btnCoffee_8 = new JButton("\uD504\uB77C\uD504\uCE58\uB178");// ������ġ�� ��ư
		btnCoffee_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				count++;
				stock.setWondu(stock.getWondu() - 1);
				stock.setMilk(stock.getMilk() - 1);
				stock.setChoco(stock.getChoco() - 1);
				stock.setSirup(stock.getSirup() - 1);
				showlabel("������ġ��", 4700);
			}
		});
		btnCoffee_8.setBounds(500, 148, 100, 70);
		add(btnCoffee_8);

		JButton btnCoffee_9 = new JButton("\uB538\uAE30\uC2A4\uBB34\uB514"); //���� ������ ��ư
		btnCoffee_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				count++;
				stock.setBerry(stock.getBerry() - 1);
				stock.setMilk(stock.getMilk() - 1);
				stock.setSirup(stock.getSirup() - 1);
				showlabel("���⽺����", 5000);
			}
		});
		btnCoffee_9.setBounds(650, 148, 100, 70);
		add(btnCoffee_9);

		JButton btnCoffee_10 = new JButton("\uB9DD\uACE0\uC2A4\uBB34\uB514");//���� ������ ��ư
		btnCoffee_10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				count++;
				stock.setMilk(stock.getMilk() - 1);
				stock.setMango(stock.getMango() - 1);
				stock.setSirup(stock.getSirup() - 1);
				showlabel("��������", 5000);
			}
		});
		btnCoffee_10.setBounds(50, 266, 100, 70);
		add(btnCoffee_10);

		JButton btnCoffee_11 = new JButton("\uD56B\uCD08\uCF54");//������ ��ư
		btnCoffee_11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				count++;

				stock.setChoco(stock.getChoco() - 1);
				stock.setMilk(stock.getMilk() - 1);
				stock.setSirup(stock.getSirup() - 1);
				showlabel("������", 3000);
			}
		});
		btnCoffee_11.setBounds(200, 266, 100, 70);
		add(btnCoffee_11);

		JButton btnCoffee_12 = new JButton("\uBE14\uB799\uD2F0");//��Ƽ ��ư
		btnCoffee_12.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				count++;

				stock.setBlack(stock.getBlack() - 1);
				showlabel("��Ƽ", 4000);
			}
		});
		btnCoffee_12.setBounds(350, 266, 100, 70);
		add(btnCoffee_12);

		JButton btnCoffee_13 = new JButton("\uBC84\uBE14\uD2F0");//����Ƽ ��ư
		btnCoffee_13.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				count++;

				stock.setMilk(stock.getMilk() - 1);
				stock.setBlack(stock.getBlack() - 1);
				stock.setSirup(stock.getSirup() - 1);
				showlabel("����Ƽ", 4000);
			}
		});
		btnCoffee_13.setBounds(500, 266, 100, 70);
		add(btnCoffee_13);

		JButton btnCoffee_14 = new JButton("\uADF8\uB9B0\uD2F0"); //�׸�Ƽ ��ư
		btnCoffee_14.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				count++;
				stock.setGreen(stock.getGreen() - 1);
				showlabel("�׸�Ƽ", 4000);
			}
		});

		btnCoffee_14.setBounds(650, 266, 100, 70);
		add(btnCoffee_14);
		// ��ư

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 396, 784, 158);
		panel_1.setLayout(null);
		add(panel_1);

		JRadioButton rdbtnNewRadioButton = new JRadioButton("  ICE"); //Ŀ�� �µ� ICE ��ư
		buttonGroup.add(rdbtnNewRadioButton);
		rdbtnNewRadioButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				coffee.setCoff_temp("ICE");
				showlabel(coffee.getCoff_name(), coffee.getCoff_price());

			}
		});
		rdbtnNewRadioButton.setBounds(145, 29, 60, 26);
		panel_1.add(rdbtnNewRadioButton);

		JRadioButton rdbtnHot = new JRadioButton("  HOT"); //Ŀ�� �µ� HOT ��ư
		buttonGroup.add(rdbtnHot);
		rdbtnHot.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				coffee.setCoff_temp("HOT");
				showlabel(coffee.getCoff_name(), coffee.getCoff_price());

			}
		});
		rdbtnHot.setBounds(209, 29, 121, 26);
		panel_1.add(rdbtnHot);

		JRadioButton rdbtnSmall = new JRadioButton("  SMALL");//Ŀ�� ������ SMALL ��ư
		buttonGroup_1.add(rdbtnSmall);
		rdbtnSmall.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				clicksize(coffee.getCoff_size(), "SMALL", flag_size);
				coffee.setCoff_size("SMALL");
				showlabel(coffee.getCoff_name(), coffee.getCoff_price());
				flag_size = true;

			}
		});
		rdbtnSmall.setBounds(469, 29, 80, 26);
		panel_1.add(rdbtnSmall);

		JRadioButton rdbtnTall = new JRadioButton("  TALL");//Ŀ�� ������ TALL ��ư
		buttonGroup_1.add(rdbtnTall);
		rdbtnTall.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				clicksize(coffee.getCoff_size(), "TALL", flag_size);
				coffee.setCoff_size("TALL");
				showlabel(coffee.getCoff_name(), coffee.getCoff_price());
				flag_size = true;

			}
		});
		rdbtnTall.setBounds(560, 29, 80, 26);
		panel_1.add(rdbtnTall);

		JRadioButton rdbtnLarge = new JRadioButton("  LARGE");//Ŀ�� ������ LARGE ��ư
		buttonGroup_1.add(rdbtnLarge);
		rdbtnLarge.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				clicksize(coffee.getCoff_size(), "LARGE", flag_size);
				coffee.setCoff_size("LARGE");
				showlabel(coffee.getCoff_name(), coffee.getCoff_price());
				flag_size = true;

			}
		});
		rdbtnLarge.setBounds(655, 29, 121, 26);
		panel_1.add(rdbtnLarge);

		JLabel label = new JLabel("HOT / ICE");
		label.setFont(new Font("Dialog", Font.BOLD, 15));
		label.setBounds(59, 32, 99, 18);
		panel_1.add(label);

		JLabel label_1 = new JLabel("\uC74C\uB8CC \uC0AC\uC774\uC988");
		label_1.setFont(new Font("Dialog", Font.BOLD, 15));
		label_1.setBounds(373, 32, 99, 18);
		panel_1.add(label_1);

		JLabel label_2 = new JLabel("\uC0F7\uCD94\uAC00");
		label_2.setFont(new Font("Dialog", Font.BOLD, 15));
		label_2.setBounds(59, 70, 99, 18);
		panel_1.add(label_2);

		JRadioButton rdbtnYes = new JRadioButton("  YES");//Ŀ�� ���߰�  YES ��ư
		buttonGroup_2.add(rdbtnYes);
		rdbtnYes.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				clickshot(coffee.getCoff_shot(), "���߰�", flag_shot);
				coffee.setCoff_shot("���߰�");
				showlabel(coffee.getCoff_name(), coffee.getCoff_price());
				flag_shot = true;

				/*
				 * count_shot++; if(count_shot > 1){ coffee.setPrice(coffee.getPrice()-500);
				 * stock.setWondu(stock.getWondu()+1); }
				 * 
				 * coffee.setPrice(coffee.getPrice()+500); coffee.setShot("���߰�");
				 * stock.setWondu(stock.getWondu()-1);
				 */

			}
		});
		rdbtnYes.setBounds(145, 67, 60, 26);
		panel_1.add(rdbtnYes);

		JRadioButton rdbtnNo = new JRadioButton("  NO");//Ŀ�� ���߰� NO ��ư
		buttonGroup_2.add(rdbtnNo);
		rdbtnNo.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				if (coffee.getCoff_shot() == ("���߰�")) {
					coffee.setCoff_price(coffee.getCoff_price() - 500);
				}

				coffee.setCoff_shot("NO��");
				showlabel(coffee.getCoff_name(), coffee.getCoff_price());
			}
		});
		rdbtnNo.setBounds(209, 67, 121, 26);
		panel_1.add(rdbtnNo);

		JLabel label_3 = new JLabel("\uC5BC\uC74C\uC591");
		label_3.setFont(new Font("Dialog", Font.BOLD, 15));
		label_3.setBounds(373, 70, 99, 18);
		panel_1.add(label_3);

		JRadioButton rdbtnFull = new JRadioButton("  FULL");//Ŀ�� ������ FULL ��ư

		rdbtnFull.setBounds(469, 67, 80, 26);
		buttonGroup_3.add(rdbtnFull);
		rdbtnFull.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				coffee.setCoff_ice("ICE FULL");
				showlabel(coffee.getCoff_name(), coffee.getCoff_price());
			}
		});

		panel_1.add(rdbtnFull);

		JRadioButton rdbtnRegular = new JRadioButton("  REGULAR");//Ŀ�� ������ REGULAR ��ư
		rdbtnRegular.setBounds(560, 67, 90, 26);
		buttonGroup_3.add(rdbtnRegular);
		rdbtnRegular.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				coffee.setCoff_ice("ICE REGULAR");
				showlabel(coffee.getCoff_name(), coffee.getCoff_price());
			}
		});

		panel_1.add(rdbtnRegular);

		JRadioButton rdbtnLess = new JRadioButton("  LESS"); //Ŀ�� ������ LESS ��ư
		rdbtnLess.setBounds(655, 67, 121, 26);
		buttonGroup_3.add(rdbtnLess);
		rdbtnLess.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				coffee.setCoff_ice("ICE LESS");
				showlabel(coffee.getCoff_name(), coffee.getCoff_price());
			}
		});

		panel_1.add(rdbtnLess);
		
		
		
		
		JLabel label_4 = new JLabel("\uD718\uD551\uD06C\uB9BC");
		label_4.setFont(new Font("Dialog", Font.BOLD, 15));
		label_4.setBounds(59, 113, 74, 18);
		panel_1.add(label_4);
		
		JRadioButton rdbtnYes_1 = new JRadioButton("  YES");//Ŀ�� ũ�� YES ��ư
		rdbtnYes_1.setBounds(145, 110, 60, 26);
		buttonGroup_4.add(rdbtnYes_1);
		rdbtnYes_1.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				coffee.setCoff_cream("CREAM YES");
				showlabel(coffee.getCoff_name(), coffee.getCoff_price());
			}
		});
		
		
		panel_1.add(rdbtnYes_1);
		
		JRadioButton rdbtnNo_1 = new JRadioButton("  NO");//Ŀ�� ũ�� NO ��ư
		rdbtnNo_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				coffee.setCoff_cream("CREAM NO");
				showlabel(coffee.getCoff_name(), coffee.getCoff_price());
			}
		});
		rdbtnNo_1.setBounds(209, 110, 121, 26);
		buttonGroup_4.add(rdbtnNo_1);
		panel_1.add(rdbtnNo_1);
		
		JLabel lblTakeout = new JLabel("TAKE");
		lblTakeout.setFont(new Font("Dialog", Font.BOLD, 15));
		lblTakeout.setBounds(373, 113, 88, 18);
		panel_1.add(lblTakeout);
		
		JRadioButton rdbtnYes_2 = new JRadioButton("  OUT");//Ŀ�� TAKE_OUT ��ư
		rdbtnYes_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				coffee.setCoff_takeout("TAKE_OUT");
				showlabel(coffee.getCoff_name(), coffee.getCoff_price());
			}
		});
		rdbtnYes_2.setBounds(469, 110, 60, 26);
		buttonGroup_5.add(rdbtnYes_2);
		panel_1.add(rdbtnYes_2);
		
		JRadioButton rdbtnNo_2 = new JRadioButton("  IN");//Ŀ�� TAKE_IN ��ư
		rdbtnNo_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				coffee.setCoff_takeout("TAKE_IN");
				showlabel(coffee.getCoff_name(), coffee.getCoff_price());
			}
		});
		rdbtnNo_2.setBounds(560, 110, 121, 26);
		panel_1.add(rdbtnNo_2);
		buttonGroup_5.add(rdbtnNo_2);
		

		JPanel panel_2 = new JPanel();
		panel_2.setBounds(0, 551, 784, 150);
		// frame.getContentPane().add(panel_2);
		panel_2.setLayout(null);
		add(panel_2);

		lblTotalAmount = new JLabel();
		lblTotalAmount.setBounds(45, 10, 665, 54);
		panel_2.add(lblTotalAmount);
		lblTotalAmount.setBackground(UIManager.getColor("CheckBox.interiorBackground"));
		lblTotalAmount.setFont(new Font("����", Font.BOLD, 15));
		lblTotalAmount.setText("\uCD1D\uAE08\uC561");
		// ��Ʈ���� ���ڿ��� �ְ� �׼��� ���Ë����� ��Ʈ���� ���� �־��ְ� ���������� ���� �־��ش�.
		lblTotalAmount.setText(menu);

		JButton button_10 = new JButton("\uC120\uD0DD\uCDE8\uC18C");// ���� ��� ��ư
		button_10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				count=0;
				buttonGroup.clearSelection();
				buttonGroup_1.clearSelection();
				buttonGroup_2.clearSelection();
				buttonGroup_3.clearSelection();
				buttonGroup_4.clearSelection();
				buttonGroup_5.clearSelection();
				lblTotalAmount.setText("");
				// ��� �ڵ����� �޼ҵ�
				coffee.setCoff_name(null);
				coffee.setCoff_shot(null);
				coffee.setCoff_size(null);
				coffee.setCoff_temp(null);
				coffee.setCoff_ice(null);
				coffee.setCoff_price(0);
				coffee.setCoff_cream(null);
				coffee.setCoff_takeout(null);
				flag_size = false;
				flag_shot = false;
				JOptionPane.showMessageDialog(null, "������ҵǾ����ϴ�.");
			}
		});
		button_10.setBounds(415, 74, 132, 38);
		panel_2.add(button_10);

		JButton btnSale_5 = new JButton("\uACB0\uC81C");
		btnSale_5.setBounds(246, 74, 138, 38);
		panel_2.add(btnSale_5);
		btnSale_5.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				insert_Menu_order();
			}
		});

		textField = new JTextField();
		textField.setBounds(24, 74, 184, 35);
		panel_2.add(textField);
		textField.setColumns(10);

		JButton Log_in = new JButton("\uB85C\uADF8\uC778"); //�α��� ��ư
		Log_in.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Login loginframe = new Login();
				loginframe.setVisible(true);
				
//				dispose();
				//TODO
			}
		});
		Log_in.setBounds(587, 74, 142, 38);
		panel_2.add(Log_in);
			
	}

	public void insert_Menu_order() { //�޴� �ֹ� ��ư
	
		count = 0;

		if (checkOrder() == 0) {
			checkOrder();
			dao.coffeeadd(coffee);
			System.out.println(coffee);

			dao.stockorder(stock);
			dao.getstock();
			System.out.println(stock);

			buttonGroup.clearSelection();
			buttonGroup_1.clearSelection();
			buttonGroup_2.clearSelection();
			buttonGroup_3.clearSelection();
			buttonGroup_4.clearSelection();
			buttonGroup_5.clearSelection();
			lblTotalAmount.setText("");
			// ��� �ڵ����� �޼ҵ�
			coffee.setCoff_name(null);
			coffee.setCoff_shot(null);
			coffee.setCoff_size(null);
			coffee.setCoff_temp(null);
			coffee.setCoff_ice(null);
			coffee.setCoff_price(0);
			coffee.setCoff_cream(null);
			coffee.setCoff_takeout(null);
			flag_size = false;
			flag_shot = false;
			
			Payment Payframe = new Payment();
			Payframe.setVisible(true);
			Payframe.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);

		} else {
			buttonGroup.clearSelection();
			buttonGroup_1.clearSelection();
			buttonGroup_2.clearSelection();
			buttonGroup_3.clearSelection();
			buttonGroup_4.clearSelection();
			buttonGroup_5.clearSelection();
			lblTotalAmount.setText("");
			coffee.setCoff_name(null);
			coffee.setCoff_shot(null);
			coffee.setCoff_size(null);
			coffee.setCoff_temp(null);
			coffee.setCoff_ice(null);
			coffee.setCoff_price(0);
			coffee.setCoff_cream(null);
			coffee.setCoff_takeout(null);
			JOptionPane.showMessageDialog(null, "��ᰡ ���������ϴ�.��Ḧ �ֹ��ϼ���.");
			flag_size = false;
			flag_shot = false;
		}

	}// end insert_Menu_order()
	
	

	
	
	
	

	public void showlabel(String name, int price) {// �Ǹ� ������ �Է�

		coffee.setCoff_name(name);
		coffee.setCoff_price(price);

		if (coffee.getCoff_name() != null && coffee.getCoff_price() != 0) {
			menu = coffee.getCoff_name() + " / " + coffee.getCoff_price();
			
			if (coffee.getCoff_shot() != null) {
				menu = menu + " / " + coffee.getCoff_shot();
			}
			if (coffee.getCoff_size() != null) {
				menu = menu + " / " + coffee.getCoff_size();
			}
			if (coffee.getCoff_temp() != null) {
				menu = menu + " / " + coffee.getCoff_temp();
			}
			if (coffee.getCoff_ice() != null) {
				menu = menu + " / " + coffee.getCoff_ice();
			}
			if (coffee.getCoff_cream() != null) {
				menu = menu + " / " + coffee.getCoff_cream();
			}
			if (coffee.getCoff_takeout() != null) {
				menu = menu + " / " + coffee.getCoff_takeout();
			}
		}
		lblTotalAmount.setText(menu);

	}// showlabel

	public void clicksize(String befor_size, String size, boolean flag_size) {// ��������õ� Ŭ���������� �޼ҵ�

		if (flag_size) {
			// �ι�° �̻�
			switch (size) {

			case "SMALL":
				switch (befor_size) {
				case "SMALL":

					break;
				case "TALL":
					coffee.setCoff_price(coffee.getCoff_price() - 500);
					break;
				case "LARGE":
					coffee.setCoff_price(coffee.getCoff_price() - 1000);
					break;
				default:
					break;
				}
				break;

			case "TALL":
				switch (befor_size) {
				case "SMALL":
					coffee.setCoff_price(coffee.getCoff_price() + 500);
					break;
				case "TALL":

					break;
				case "LARGE":
					coffee.setCoff_price(coffee.getCoff_price() - 500);
					break;
				default:
					break;
				}
				break;

			case "LARGE":
				switch (befor_size) {
				case "SMALL":
					coffee.setCoff_price(coffee.getCoff_price() + 1000);
					break;
				case "TALL":
					coffee.setCoff_price(coffee.getCoff_price() + 500);
					break;
				case "LARGE":
					break;
				default:
					break;
				}
				break;

			default:
				break;
			}

		} else {
			// ó��������
			switch (size) {

			case "SMALL":

				break;
			case "TALL":
				coffee.setCoff_price(coffee.getCoff_price() + 500);
				break;
			case "LARGE":
				coffee.setCoff_price(coffee.getCoff_price() + 1000);
				break;

			default:
				break;
			}

		}

	}// end clicksize

	public void clickshot(String befor_shot, String shot, boolean flag_shot) {// �����õ� ��ư����
		if (flag_shot) {
			// �ι��̻�
			switch (shot) {
			case "���߰�":
				switch (befor_shot) {
				case "���߰�":

					break;
				case "NO��":
					coffee.setCoff_price(coffee.getCoff_price() + 500);
					break;
				default:
					break;
				}
				break;

			case "NO��":
				switch (befor_shot) {
				case "���߰�":
					coffee.setCoff_price(coffee.getCoff_price() - 500);
					break;
				case "NO��":
					break;
				default:
					break;
				}
				break;
			default:
				break;
			}
		} else {
			// �ѹ�������
			switch (shot) {
			case "���߰�":
				coffee.setCoff_price(coffee.getCoff_price() + 500);
				break;
			case "NO��":
				break;
			default:
				break;
			}
		}
	}// end clickshot

	
	public int checkOrder() {
		int result = 0;
		if (stock.getWondu() <= -1 || stock.getMilk() <= -1 || stock.getSirup() <= -1 || stock.getBerry() <= -1
				|| stock.getMango() <= -1 || stock.getGreen() <= -1 || stock.getBlack() <= -1
				|| stock.getChoco() <= -1) {
			result = -1;
		}
		return result;
	}// checkOrder
}// end checkOrder
