

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import oracle.jdbc.OracleDriver;

public class EmployeeDAOImple implements EmployeeDAO, OracleQuery {

	// Singleton ���� ����
	// 1. private static �ڱ��ڽ� Ÿ�� ��� ���� ����
	private static EmployeeDAOImple instance = null;

	// 2. private ������
	private EmployeeDAOImple() {
		// DB ����̹� ���
		try {
			DriverManager.registerDriver(new OracleDriver());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// 3. public static �ڱ��ڽ��� �����ϴ� �޼ҵ�
	public static EmployeeDAOImple getInstance() {
		if (instance == null) {
			instance = new EmployeeDAOImple();
		}
		return instance;
	}

	@Override
	public int insert_emp(EmployeeVO vo) {
		// vo�� DB�� ����
		int result = 0;

		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			System.out.println("DB ���� ����");
			pstmt = conn.prepareStatement(SQL_INSERT_EMP);

			pstmt.setString(1, vo.getEmp_name());
			pstmt.setString(2, vo.getEmp_phone());
			pstmt.setString(3, vo.getEmp_address());
			pstmt.setString(4, vo.getEmp_rank());
			pstmt.setString(5, vo.getEmp_job());
			pstmt.setString(6, vo.getEmp_date());
			pstmt.setString(7, vo.getEmp_time());
			pstmt.setString(8, vo.getEmp_note());

			result = pstmt.executeUpdate();
			System.out.println(result + "���� ������ �߰���.");

		} catch (SQLException e) {
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

	@Override
	public ArrayList<EmployeeVO> selectAll_emp() {
		// DB���� ��ü ������(list)�� ����
		ArrayList<EmployeeVO> list = new ArrayList<EmployeeVO>();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			System.out.println("DB ���� ����");
			
			pstmt = conn.prepareStatement(SQL_SELECTALL_EMP);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				int emp_num = rs.getInt(COL_EMP_NUM);
				String emp_name = rs.getString(COL_EMP_NAME);
				String emp_phone = rs.getString(COL_EMP_PHONE);
				String emp_address = rs.getString(COL_EMP_ADDRESS);
				String emp_rank = rs.getString(COL_EMP_RANK);
				String emp_job = rs.getString(COL_EMP_JOB);
				String emp_date = rs.getString(COL_EMP_DATE);
				String emp_time = rs.getString(COL_EMP_TIME);
				String emp_note = rs.getString(COL_EMP_NOTE);
				EmployeeVO vo = new EmployeeVO(emp_num, emp_name, emp_phone, emp_address, emp_rank, emp_job, emp_date, emp_time, emp_note);
				list.add(vo);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
				pstmt.close();
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return list;
	}

	@Override
	public EmployeeVO select_emp(int index) {
		// DB ���� �ε��� ������(vo)�� ����
		EmployeeVO vo = new EmployeeVO();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			System.out.println("DB �ϳ� ���� ����");
			
			pstmt = conn.prepareStatement(SQL_SELECT_EMP);
			pstmt.setInt(1, index);
			
			rs = pstmt.executeQuery();
			System.out.println("test");
			if(rs.next()) {
				int emp_num = rs.getInt(COL_EMP_NUM);
				String emp_name = rs.getString(COL_EMP_NAME);
				String emp_phone = rs.getString(COL_EMP_PHONE);
				String emp_address = rs.getString(COL_EMP_ADDRESS);
				String emp_rank = rs.getString(COL_EMP_RANK);
				String emp_job = rs.getString(COL_EMP_JOB);
				String emp_date = rs.getString(COL_EMP_DATE);
				String emp_time = rs.getString(COL_EMP_TIME);
				String emp_note = rs.getString(COL_EMP_NOTE);
				vo = new EmployeeVO(emp_num, emp_name, emp_phone, emp_address, emp_rank, emp_job, emp_date, emp_time, emp_note);
			}
			System.out.println(vo.getEmp_name());
		} catch (SQLException e) {
			System.out.println("����?");
			e.printStackTrace();
		} finally {
			try {
				conn.close();
				pstmt.close();
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		System.out.println(vo.getEmp_name());
		return vo;
	}

	@Override
	public int update_emp(int index, EmployeeVO vo) {
		// Ư�� �ε����� �����͸� DB���� ����
		int result = 0;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			System.out.println("DB���� ����");
			pstmt = conn.prepareStatement(SQL_UPDATE_EMP);

			pstmt.setString(1, vo.getEmp_name());
			pstmt.setString(2, vo.getEmp_phone());
			pstmt.setString(3, vo.getEmp_address());
			pstmt.setString(4, vo.getEmp_rank());
			pstmt.setString(5, vo.getEmp_job());
			pstmt.setString(6, vo.getEmp_date());
			pstmt.setString(7, vo.getEmp_time());
			pstmt.setString(8, vo.getEmp_note());
			pstmt.setInt(9, index);
			
			result = pstmt.executeUpdate();
			System.out.println(result + "���� ������ �����.");
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
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
	public int delete_emp(int index) {
		// Ư�� �ε��� �����͸� DB���� ����
		int result = 0;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			System.out.println("DB���� ����");
			pstmt = conn.prepareStatement(SQL_DELETE_EMP);
			
			pstmt.setInt(1, index);
			
			result = pstmt.executeUpdate();
			System.out.println(result + "���� ������ ������.");
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

} // end ManagementDAOlmple
