

import java.util.ArrayList;


//직원 정보 등록, 전체 검색, 검색, 수정 함수 생성
public interface EmployeeDAO {
	
	// 직원 정보 등록
	public abstract int insert_emp(EmployeeVO vo);
	
	// 직원 전체 리스트 검색 기능
	public abstract ArrayList<EmployeeVO> selectAll_emp();
	
	// 직원 한명에 대한 상세 정보 검색 기능
	public abstract EmployeeVO select_emp(int index);
	
	// 직원 정보 수정 - 이름, 전화번호, 이메일, 주소, 직급, 업무, 근무요일, 근무시간, 비고 수정
	public abstract int update_emp(int index, EmployeeVO vo); 
	
	// 직원 정보 삭제
	public abstract int delete_emp(int index);
}

