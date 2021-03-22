import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import oracle.jdbc.OracleDriver;

public class MemberDAOImple implements MemberDAO, OracleQuery {

	// Singleton ���� ����
	// 1. private static �ڱ��ڽ� Ÿ�� ��� ���� ����
	private static MemberDAOImple instance = null;

	// 2. private ������
	private MemberDAOImple() {
		// DB ����̹� ���
		try {
			DriverManager.registerDriver(new OracleDriver());
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	// 3. public static �ڱ��ڽ��� �����ϴ� �޼ҵ�
	public static MemberDAOImple getInstace() {
		if (instance == null) {
			instance = new MemberDAOImple();
		}
		return instance;
	}

	// ���
	@Override
	public int insert_mem(MemberVO vo) {
		// vo�� DB�� ����
		int result = 0;

		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			System.out.println("DB���� ����");
			pstmt = conn.prepareStatement(SQL_INSERT_MEM);

			pstmt.setString(1, vo.getMem_id());
			pstmt.setString(2, vo.getMem_pw());
			pstmt.setString(3, vo.getMem_name());
			pstmt.setString(4, vo.getMem_phone());
			pstmt.setString(5, vo.getMem_gender());
			pstmt.setString(6, vo.getMem_year());
			pstmt.setString(7, vo.getMem_month());
			pstmt.setString(8, vo.getMem_day());
			pstmt.setInt(9, 1000);


			result = pstmt.executeUpdate();
			System.out.println(result + "���� ������ �߰���");
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			try {
				conn.close();
				pstmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return result;
	}

	// ��ü ������ ����
	@Override
	public ArrayList<MemberVO> selectAll_mem() {
		// DB���� ��ü ������(list)�� ����
		ArrayList<MemberVO> list = new ArrayList<MemberVO>();

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			System.out.println("DB ���� ����");

			pstmt = conn.prepareStatement(SQL_SELECTALL_MEM);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				int mem_num = rs.getInt(COL_MEM_NUM);
				String mem_id = rs.getString(COL_MEM_ID);
				String mem_pw = rs.getString(COL_MEM_PW);
				String mem_name = rs.getString(COL_MEM_NAME);
				String mem_phone = rs.getString(COL_MEM_PHONE);
				String mem_gender = rs.getString(COL_MEM_GENDER);
				String mem_year = rs.getString(COL_MEM_YEAR);
				String mem_month = rs.getString(COL_MEM_MONTH);
				String mem_day = rs.getString(COL_MEM_DAY);
				int mem_point = rs.getInt(COL_MEM_POINT);

				MemberVO vo = new MemberVO(mem_num, mem_id, mem_pw, mem_name, mem_phone, mem_gender, mem_year, mem_month, mem_day,
						mem_point);
				list.add(vo);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				conn.close();
				pstmt.close();
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return list;
	}

	// �ϳ� ����
	@Override
	public MemberVO select_mem(int index) {
		// DB���� �ε��� ������(vo)�� ����
		MemberVO vo = null;

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			System.out.println("DB ���� ����");

			pstmt = conn.prepareStatement(SQL_SELECT_MEM);
			pstmt.setInt(1, index);

			rs = pstmt.executeQuery();

			if (rs.next()) {
				int mem_num = rs.getInt(COL_MEM_NUM);
				String mem_id = rs.getString(COL_MEM_ID);
				String mem_pw = rs.getString(COL_MEM_PW);
				String mem_name = rs.getString(COL_MEM_NAME);
				String mem_phone = rs.getString(COL_MEM_PHONE);
				String mem_gender = rs.getString(COL_MEM_GENDER);
				String mem_year = rs.getString(COL_MEM_YEAR);
				String mem_month = rs.getString(COL_MEM_MONTH);
				String mem_day = rs.getString(COL_MEM_DAY);
				int mem_point = rs.getInt(COL_MEM_POINT);

				vo = new MemberVO(mem_num, mem_id, mem_pw, mem_name, mem_phone, mem_gender, mem_year, mem_month, mem_day,
						mem_point);
				;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				conn.close();
				pstmt.close();
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return vo;
	}

	// ����
	@Override
	public int update_mem(int index, MemberVO vo) {
		// Ư�� �ε����� �����͸� DB���� ����
		int result = 0;

		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			System.out.println("DB���� ����");
			pstmt = conn.prepareStatement(SQL_UPDATE_MEM);

			pstmt.setString(1, vo.getMem_id());
			pstmt.setString(2, vo.getMem_pw());
			pstmt.setString(3, vo.getMem_name());
			pstmt.setString(4, vo.getMem_phone());
			pstmt.setString(5, vo.getMem_gender());
			pstmt.setString(6, vo.getMem_year());
			pstmt.setString(7, vo.getMem_month());
			pstmt.setString(8, vo.getMem_day());
			pstmt.setInt(9, vo.getMem_point());
			pstmt.setInt(10, index);

			result = pstmt.executeUpdate();
			System.out.println(result + "���� ������ �����.");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				conn.close();
				pstmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return result;
	}

	// ����
	@Override
	public int delete_mem(int index) {
		// Ư�� �ε��� �����͸� DB���� ����
		int result = 0;

		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			System.out.println("DB���� ����");
			pstmt = conn.prepareStatement(SQL_DELETE_MEM);

			pstmt.setInt(1, index);

			result = pstmt.executeUpdate();
			System.out.println(result + "���� ������ ������.");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				conn.close();
				pstmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return result;
	}

	// �α��� -- ���̵�, ��й�ȣ, ����Ʈ ����
	@Override
	public MemberVO select_login(String mem_id, String mem_pw) {
		MemberVO vo = new MemberVO();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			System.out.println("DB ���� ����");

			pstmt = conn.prepareStatement(SQL_SELECT_LOGIN);
			pstmt.setString(1, mem_id);
			pstmt.setString(2, mem_pw);

			rs = pstmt.executeQuery();
//			System.out.println("����?");
			if (rs.next()) {

				vo = new MemberVO(0, rs.getString(COL_MEM_ID), rs.getString(COL_MEM_PW), null, null, null, null, 
						rs.getString(COL_MEM_MONTH), rs.getString(COL_MEM_DAY), 0);

			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
				pstmt.close();
				rs.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}

		return vo;
	}

	// ȸ������ ���̵� üũ -- ���̵�
	@Override
	public MemberVO select_idcheck(String mem_id) {
		MemberVO vo = new MemberVO();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			System.out.println("DB ���� ����");

			pstmt = conn.prepareStatement(SQL_IDCHECK);
			pstmt.setString(1, mem_id);

			rs = pstmt.executeQuery();
			System.out.println("Ʋ��?");
			if (rs.next()) {

				vo = new MemberVO(0, rs.getString(COL_MEM_ID), null, null , null, null, null, null, null, 0);
//				System.out.println("����?");
			}
		} catch (Exception e) {
			e.printStackTrace();
//	        System.out.println("???");
		} finally {
			try {
				conn.close();
				pstmt.close();
				rs.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}

		return vo;
	}

	// ����Ʈ�� ���� update
	@Override
	public int update_mempoint(MemberVO vo) {
		// Ư�� �ε����� �����͸� DB���� ����
		int result = 0;

		Connection conn = null;
		PreparedStatement pstmt = null;

		System.out.println("����?");

		try {
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			System.out.println("DB���� �����ΰ�?");
			pstmt = conn.prepareStatement(SQL_UPDATE_POINT);
			System.out.println("����?");

//			pstmt.setString(1, vo.getMem_id());
//			pstmt.setString(2, vo.getMem_pw());
//			pstmt.setString(3, vo.getMem_name());
//			pstmt.setString(4, vo.getMem_phone());
//			pstmt.setString(5, vo.getMem_gender());
//			pstmt.setString(6, vo.getMem_year());
			pstmt.setString(1, vo.getMem_month());
			pstmt.setString(2, vo.getMem_day());

			System.out.println("����?");
			result = pstmt.executeUpdate();
			System.out.println("????");
		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			try {
				conn.close();
				pstmt.close();
			} catch (SQLException e) {

				e.printStackTrace();
			}
		}
		return result;
	}
	
	@Override
	public int update_pay(MemberVO vo) {
		int result = 0;

		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			System.out.println("DB���� �����ΰ�?");
			pstmt = conn.prepareStatement(SQL_UPDATE_POINT);
			System.out.println("����?");

//			pstmt.setString(1, vo.getMem_id());
//			pstmt.setString(2, vo.getMem_pw());
//			pstmt.setString(3, vo.getMem_name());
			pstmt.setString(1, vo.getMem_phone());
//			pstmt.setString(5, vo.getMem_gender());
//			pstmt.setString(6, vo.getMem_year());
//			pstmt.setString(1, vo.getMem_month());
//			pstmt.setString(2, vo.getMem_day());
			pstmt.setInt(2, vo.getMem_point());

			result = pstmt.executeUpdate();

		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			try {
				conn.close();
				pstmt.close();
			} catch (SQLException e) {

				e.printStackTrace();
			}
		}
		return result;
	}
	
} // end MemberDAOlmple


