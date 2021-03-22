
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import oracle.jdbc.driver.OracleDriver;

public class CoffeeDAOImple implements CoffeeDAO, OracleQuery {

	// Singleton 패턴 적용
	// 1. private static 자기 자신 타입 멤버 변수 선언
	private static CoffeeDAOImple instance = null;

	// 2. private 생성자
	private CoffeeDAOImple() {
		// DB 드라이버 등록
		try {
			DriverManager.registerDriver(new OracleDriver());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// 3. public static 자기 자신을 리턴하는 케소드
	public static CoffeeDAOImple getInstance() {
		if (instance == null) {
			instance = new CoffeeDAOImple();
		}

		return instance;

	}

	@Override

	public int coffeeadd(CoffeeVO vo) {
		// DB에 판매정보 저장
		int result = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {

			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			pstmt = conn.prepareStatement(SQL_COFFEEADE);
			pstmt.setString(1, vo.getCoff_name());
			pstmt.setString(2, vo.getCoff_size());
			pstmt.setString(3, vo.getCoff_shot());
			pstmt.setString(4, vo.getCoff_temp());
			pstmt.setInt(5, vo.getCoff_price());
			pstmt.setString(6, vo.getCoff_cream());
			pstmt.setString(7, vo.getCoff_takeout());
			pstmt.setString(8, vo.getCoff_ice());


			result = pstmt.executeUpdate();
			System.out.println(result + "행의 데이터가 추가됨.");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {

				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

		return result;
	}// end coffeeadd

	@Override

	public int stockorder(StockVO vos) {

		// DB에서 이전 재고 업데이트
		int result = 0;

		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			System.out.println("DB연결 성공");
			pstmt = conn.prepareStatement(SQL_STOCKORDER);

			pstmt.setInt(1, vos.getWondu());
			pstmt.setInt(2, vos.getMilk());
			pstmt.setInt(3, vos.getSirup());
			pstmt.setInt(4, vos.getBerry());
			pstmt.setInt(5, vos.getMango());
			pstmt.setInt(6, vos.getGreen());
			pstmt.setInt(7, vos.getBlack());
			pstmt.setInt(8, vos.getChoco());

			result = pstmt.executeUpdate();
			System.out.println(result + "행의 데이터가 추가됨.");

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				conn.close();
			} catch (SQLException e) {

				e.printStackTrace();
			}

		}

		return result;

	}// end stockorder

	@Override

	public ArrayList<CoffeeVO> Getsellcount() {
		// DB에서 오늘 많이 판매된 음료순으로 음료와 잔수 정의
		ArrayList<CoffeeVO> list = new ArrayList<CoffeeVO>();

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			System.out.println("DB 연결 성공");

			pstmt = conn.prepareStatement(SQL_GETSELLCOUNT);

			rs = pstmt.executeQuery();

			while (rs.next()) {

				String coff_name = rs.getString(COL_COFF_NAME);
				int coff_price = rs.getInt("cnt");

			

				CoffeeVO vo = new CoffeeVO(coff_name, null, null, null, coff_price,null,null,null);
				list.add(vo);

			}

		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (pstmt != null) {
					pstmt.close();
				}
				conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return list;
	}// end Getsellcount

	@Override
	public StockVO getstock() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		StockVO stock = null;

		try {
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			System.out.println("DB연결 성공");
			pstmt = conn.prepareStatement(SQL_GETSTOCK);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				stock = new StockVO();
				stock.setWondu(rs.getInt("wondu"));
				stock.setMilk(rs.getInt("milk"));
				stock.setSirup(rs.getInt("sirup"));
				stock.setBerry(rs.getInt("berry"));
				stock.setMango(rs.getInt("mango"));
				stock.setGreen(rs.getInt("green"));
				stock.setBlack(rs.getInt("black"));
				stock.setChoco(rs.getInt("choco"));

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		return stock;
	}// getstock

	@Override

	public ArrayList<CoffeeVO> GetAllSellList() {
		// DB에서 전체 판매리스트 가져온다

		ArrayList<CoffeeVO> list = new ArrayList<CoffeeVO>();

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			System.out.println("DB연결 성공");
			pstmt = conn.prepareStatement(SQL_GETALLSELLLIST);

			rs = pstmt.executeQuery();
			while (rs.next()) {

				String coff_name = rs.getString(COL_COFF_NAME);
				String coff_size = rs.getString(COL_COFF_SIZE);
				String coff_shot = rs.getString(COL_COFF_SHOT);
				String coff_temp = rs.getString(COL_COFF_TEMP);
				int  coff_price = rs.getInt(COL_COFF_PRICE);
				String  coff_cream = rs.getString(COL_COFF_CREAM);
				String  coff_takeout = rs.getString(COL_COFF_TAKEOUT);
				String  coff_ice = rs.getString(COL_COFF_ICE);

				CoffeeVO vo = new CoffeeVO(coff_name, coff_size, coff_shot, coff_temp, coff_price,coff_cream,coff_takeout,coff_ice);

				list.add(vo);
			}

		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			try {
				rs.close();
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		return list;
	}// GetAllSellList

	@Override
	public Object[][] makestocklistArr(StockVO lists) {
		Object[][] coffeearr = new Object[1][8];

		coffeearr[0][0] = lists.getWondu();
		coffeearr[0][1] = lists.getMilk();
		coffeearr[0][2] = lists.getSirup();
		coffeearr[0][3] = lists.getBerry();
		coffeearr[0][4] = lists.getMango();
		coffeearr[0][5] = lists.getGreen();
		coffeearr[0][6] = lists.getBlack();
		coffeearr[0][7] = lists.getChoco();

		return coffeearr;

	}// makestocklistArr
	
	
}







//@Override
//
//public ArrayList<StockVO> getstock() {
//	// DB에서 재고데이터 가져오기
//	ArrayList<StockVO> list = new ArrayList<StockVO>();
//	Connection conn = null;
//	PreparedStatement pstmt = null;
//	ResultSet rs = null;
//
//	try {
//		conn = DriverManager.getConnection(URL, USER, PASSWORD);
//		System.out.println("DB연결 성공");
//		pstmt = conn.prepareStatement(SQL_GETSTOCK);
//
//		rs = pstmt.executeQuery();
//
//		while (rs.next()) {
//
//			int wondu = rs.getInt(COL_WONDU);
//			int milk = rs.getInt(COL_MILK);
//			int sirup = rs.getInt(COL_SIRUP);
//			int berry = rs.getInt(COL_BERRY);
//			int mango = rs.getInt(COL_MANGO);
//			int green = rs.getInt(COL_GREEN);
//			int black = rs.getInt(COL_BLACK);
//			int choco = rs.getInt(COL_CHOCO);
//
//			StockVO vo = new StockVO(wondu, milk, sirup, berry, mango, green, black, choco);
//			list.add(vo);
//			
////			if(wondu ==1) {
////				JOptionPane.showMessageDialog(null, "재료가 떨어졌습니다.재료를 주문하세요.");
////			}
//
//		}
//
//	} catch (SQLException e) {
//		// TODO Auto-generated catch block
//		e.printStackTrace();
//	} finally {
//		try {
//			rs.close();
//			pstmt.close();
//			conn.close();
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//	}
//	return list;
//}// getstock
