

import java.util.ArrayList;

//회원 정보 등록, 전체 검색, 검색, 수정 함수 생성
public interface MemberDAO {
	// 회원 정보 등록
	public abstract int insert_mem(MemberVO vo);

	// 회원 전체 리스트 검색 기능
	public abstract ArrayList<MemberVO> selectAll_mem();

	// 회원 한명에 대한 상세 정보 검색 기능
	public abstract MemberVO select_mem(int index);

	// 회원 정보 수정 - 이름, 전화번호, 성별, 연도, 월, 일, 누적포인트 수정
	public abstract int update_mem(int index, MemberVO vo);

	// 회원 정보 삭제
	public abstract int delete_mem(int index);
	
	// 로그인 -- 아이디, 비밀번호
	public abstract MemberVO select_login(String mem_id, String mem_pw);
	
	// 회원가입 아이디 체크 -- 아이디
	public abstract MemberVO select_idcheck(String mem_id);
	
	// 로그인 -- 생일인 사람에게 포인트 3000추가
	public abstract int update_mempoint(MemberVO vo);
	
	// 결제시 구매 금액의 0.1프로 멤버쉽 적립
	public abstract int update_pay(MemberVO vo);
	
	
	
}
