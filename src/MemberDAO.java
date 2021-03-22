

import java.util.ArrayList;

//ȸ�� ���� ���, ��ü �˻�, �˻�, ���� �Լ� ����
public interface MemberDAO {
	// ȸ�� ���� ���
	public abstract int insert_mem(MemberVO vo);

	// ȸ�� ��ü ����Ʈ �˻� ���
	public abstract ArrayList<MemberVO> selectAll_mem();

	// ȸ�� �Ѹ� ���� �� ���� �˻� ���
	public abstract MemberVO select_mem(int index);

	// ȸ�� ���� ���� - �̸�, ��ȭ��ȣ, ����, ����, ��, ��, ��������Ʈ ����
	public abstract int update_mem(int index, MemberVO vo);

	// ȸ�� ���� ����
	public abstract int delete_mem(int index);
	
	// �α��� -- ���̵�, ��й�ȣ
	public abstract MemberVO select_login(String mem_id, String mem_pw);
	
	// ȸ������ ���̵� üũ -- ���̵�
	public abstract MemberVO select_idcheck(String mem_id);
	
	// �α��� -- ������ ������� ����Ʈ 3000�߰�
	public abstract int update_mempoint(MemberVO vo);
	
	// ������ ���� �ݾ��� 0.1���� ����� ����
	public abstract int update_pay(MemberVO vo);
	
	
	
}
