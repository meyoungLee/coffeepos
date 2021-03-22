

import java.util.ArrayList;


//���� ���� ���, ��ü �˻�, �˻�, ���� �Լ� ����
public interface EmployeeDAO {
	
	// ���� ���� ���
	public abstract int insert_emp(EmployeeVO vo);
	
	// ���� ��ü ����Ʈ �˻� ���
	public abstract ArrayList<EmployeeVO> selectAll_emp();
	
	// ���� �Ѹ� ���� �� ���� �˻� ���
	public abstract EmployeeVO select_emp(int index);
	
	// ���� ���� ���� - �̸�, ��ȭ��ȣ, �̸���, �ּ�, ����, ����, �ٹ�����, �ٹ��ð�, ��� ����
	public abstract int update_emp(int index, EmployeeVO vo); 
	
	// ���� ���� ����
	public abstract int delete_emp(int index);
}

