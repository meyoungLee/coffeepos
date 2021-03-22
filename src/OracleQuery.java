public interface OracleQuery {

	public static final String URL = "jdbc:oracle:thin:@localhost:1521:xe"; // 접속할 오라클 DB 경로
	public static final String USER = "Cof";
	public static final String PASSWORD = "1234";

	// COFFEE 테이블
	public static final String TABLE_COFFEE = "coffee";
	public static final String COL_COFF_NAME = "coff_name";
	public static final String COL_COFF_SIZE = "coff_size";
	public static final String COL_COFF_SHOT = "coff_shot";
	public static final String COL_COFF_TEMP = "coff_temp";
	public static final String COL_COFF_PRICE = "coff_price";
	public static final String COL_COFF_CREAM = "coff_cream";
	public static final String COL_COFF_TAKEOUT = "coff_takeout";
	public static final String COL_COFF_ICE = "coff_ice";


	// STOCK 테이블
	public static final String TABLE_STOCK = "stock";
	public static final String COL_WONDU = "wondu";
	public static final String COL_MILK = "milk";
	public static final String COL_SIRUP = "sirup";
	public static final String COL_BERRY = "berry";
	public static final String COL_MANGO = "mango";
	public static final String COL_GREEN = "green";
	public static final String COL_BLACK = "black";
	public static final String COL_CHOCO = "choco";

	// Employee 테이블
	public static final String TABLE_EMPLOYEE = "employee";
	public static final String COL_EMP_NUM = "emp_num";
	public static final String COL_EMP_NAME = "emp_name";
	public static final String COL_EMP_PHONE = "emp_phone";
	public static final String COL_EMP_ADDRESS = "emp_address";
	public static final String COL_EMP_RANK = "emp_rank";
	public static final String COL_EMP_JOB = "emp_job";
	public static final String COL_EMP_DATE = "emp_date";
	public static final String COL_EMP_TIME = "emp_time";
	public static final String COL_EMP_NOTE = "emp_note";


	// Member 테이블
	public static final String TABLE_MEMBER = "member";
	public static final String COL_MEM_NUM = "mem_num";
	public static final String COL_MEM_ID = "mem_id";
	public static final String COL_MEM_PW = "mem_pw";
	public static final String COL_MEM_NAME = "mem_name";
	public static final String COL_MEM_PHONE = "mem_phone";
	public static final String COL_MEM_GENDER = "mem_gender";
	public static final String COL_MEM_YEAR = "mem_year";
	public static final String COL_MEM_MONTH = "mem_month";
	public static final String COL_MEM_DAY = "mem_day";
	public static final String COL_MEM_POINT = "mem_point";


	// SQL 구문

	//카페 정보 저장
	// insert into coffee values (?, ?, ?, ?, ?, ?, ?, ?);
	public static final String SQL_COFFEEADE = "insert into " + TABLE_COFFEE + " values (?, ?, ?, ?,?,?,?,?)";

//	주문한 재고 저장
//	 update stock set wondu=?, milk=?, sirup=?,
//	berry=?, mango=?, green=?, black=?, choco=?;
	public static final String SQL_STOCKORDER = " update " + TABLE_STOCK + " set " + COL_WONDU + " = ?," + COL_MILK
			+ " = ? , " + COL_SIRUP + " = ? , " + COL_BERRY + " = ? , " + COL_MANGO + " = ? , " + COL_GREEN + " = ? , "
			+ COL_BLACK + " = ? , " + COL_CHOCO + " = ? ";
	
//	public static final String SQL_STOCKORDER = " update " + TABLE_STOCK + " set " + COL_WONDU +" = "+COL_WONDU + " + ?," 
//	+ COL_MILK +" = "+ COL_MILK + " + ?,"
//	+ COL_SIRUP +" = "+ COL_SIRUP + " + ?,"
//	+ COL_BERRY + " = "+ COL_BERRY + " + ?," 
//	+ COL_MANGO +" = "+ COL_MANGO + " + ?,"
//	+ COL_GREEN +" = "+ COL_GREEN + " + ?,"
//	+ COL_BLACK +" = "+ COL_BLACK + " + ?,"
//	+ COL_CHOCO +" = "+ COL_CHOCO + " + ?";

	//많이 주문한 커피의 종류별 순위 저장
	// select coffeename,count(coffeeprice)
	// from coffee
	// group by coffeename
	// order by COUNT(*) desc;;
	public static final String SQL_GETSELLCOUNT = "select " +  COL_COFF_NAME + " , " + " count ( " + COL_COFF_PRICE
			+ " ) as cnt from " + TABLE_COFFEE + " group by " +  COL_COFF_NAME + " order by cnt desc";

	//재고 전체 검색
    //select * from stock;
	public static final String SQL_GETSTOCK = "select * from " + TABLE_STOCK;
	
	//커피 전체 검색
	// select * from coffee;
	public static final String SQL_GETALLSELLLIST = "select * from " + TABLE_COFFEE;
	

	// select * from employee where emp_num =?
	public static final String SQL_SELECT_EMP = "select * from " + TABLE_EMPLOYEE + " where " + COL_EMP_NUM + " = ?";

	// insert into employee
	// values (SEQ_EMP.nextval, ?, ?, ?, ?, ?, ?, ?, ?);
	public static final String SQL_INSERT_EMP = "insert into " + TABLE_EMPLOYEE
			+ " values(SEQ_EMP.nextval, ?, ?, ?, ?, ?, ?, ?, ?) ";

	// delete from ex_contact where emp_num =?
	public static final String SQL_DELETE_EMP = "delete from " + TABLE_EMPLOYEE + " where " + COL_EMP_NUM + " = ?";

//		update employee
//		 SET emp_name = ?, emp_phone = ?, emp_address = ?, emp_rank = ?, emp_job = ?, emp_date = ?, emp_time = ?, emp_note = ?
//		 where emp_num = ?
	public static final String SQL_UPDATE_EMP = "update " + TABLE_EMPLOYEE + " set " + COL_EMP_NAME + " = ?, "
			+ COL_EMP_PHONE + " = ?, " + COL_EMP_ADDRESS + " = ?, " + COL_EMP_RANK + " = ?, " + COL_EMP_JOB + " = ?, "
			+ COL_EMP_DATE + " = ?, " + COL_EMP_TIME + " = ?, " + COL_EMP_NOTE + " = ?" + " where " + COL_EMP_NUM
			+ " = ?";

	// 전체 검색
	public static final String SQL_SELECTALL_EMP = "select * from " + TABLE_EMPLOYEE + " order by " + COL_EMP_NUM;

	// select * from member where mem_num = ?
		public static final String SQL_SELECT_MEM = "select * from " + TABLE_MEMBER + " where " + COL_MEM_NUM + " = ?";

		// insert into member values(SEQ_MEM.nextval, ?, ?, ?, ?, ?, ?, ?, ?, ?);
		public static final String SQL_INSERT_MEM = "insert into " + TABLE_MEMBER
				+ " values(SEQ_MEM.nextval, ?, ?, ?, ?, ?, ?, ?, ?, ?) ";

		// delete from member where mem_num = ?
		public static final String SQL_DELETE_MEM = "delete from " + TABLE_MEMBER + " where " + COL_MEM_NUM + " = ?";

		// update member
		// set mem_id = ?, mem_pw = ?, mem_name = ?, mem_phone = ?, mem_gender = ?, 
		// mem_year = ?, mem_month = ?, mem_day = ?, mem_point = ? , mem_sum = ? 
		// where mem_num = ?;

		public static final String SQL_UPDATE_MEM = "update " + TABLE_MEMBER + " set " + COL_MEM_ID + " = ?, " + COL_MEM_PW
				+ " = ?, " + COL_MEM_NAME + " = ?, " + COL_MEM_PHONE + " = ?, " + COL_MEM_GENDER + " = ?, " + COL_MEM_YEAR + " = ?, " + COL_MEM_MONTH
				+ " = ?, " + COL_MEM_DAY + " = ?, " + COL_MEM_POINT + " = ? " + " where " + COL_MEM_NUM + " = ?";

		// 전체 검색
		public static final String SQL_SELECTALL_MEM = "select * from " + TABLE_MEMBER + " order by " + COL_MEM_NUM;

		// 로그인 화면 아이디, 비밀번호, 월, 일
		// select mem_id, mem_pw, mem_month, mem_day from member where mem_id = ? and
		// mem_pw = ?;
		public static final String SQL_SELECT_LOGIN = "select " + COL_MEM_ID + ", " + COL_MEM_PW + ", " + COL_MEM_MONTH
				+ ", " + COL_MEM_DAY + " from " + TABLE_MEMBER + " where " + COL_MEM_ID + " = ? and " + COL_MEM_PW + " = ?";

		// 회원가입 아이디 중복체크
		// 아이디
		// select mem_id from member where mem_id = ?;
		public static final String SQL_IDCHECK = "select " + COL_MEM_ID + " from " + TABLE_MEMBER + " where " + COL_MEM_ID
				+ " = ?";

		// 로그인 생일인 사람 포인트 추가
		// update member set mem_point = mem_point + 3000 where mem_month = ? and
		// mem_day = ?;
		public static final String SQL_UPDATE_POINT = "update " + TABLE_MEMBER + " set " + COL_MEM_POINT + " = "
				+ COL_MEM_POINT + " + " + 3000 + " where " + COL_MEM_MONTH + " = ? and " + COL_MEM_DAY + " = ?";
		
		//폰번호에 따린 포인트 적립
		//update member set mem_point =? 
		//where mem_phone =?;
		
		public static final String SQL_PAY =  "update " + TABLE_MEMBER + " set " + COL_MEM_POINT  + " = "
				+ COL_MEM_POINT  + " + ? " + " where " + COL_MEM_PHONE + " = ?";
		
}