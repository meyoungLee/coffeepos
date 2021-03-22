

public class MemberVO {
	private int mem_num;
	private String mem_id;
	private String mem_pw;
	private String mem_name;
	private String mem_phone;
	private String mem_gender;
	private String mem_year;
	private String mem_month;
	private String mem_day;
	private int mem_point;
	
	public MemberVO() {}
	public MemberVO(int mem_num, String mem_id, String mem_pw, String mem_name, String mem_phone, String mem_gender,
			String mem_year, String mem_month, String mem_day, int mem_point) {
		super();
		this.mem_num = mem_num;
		this.mem_id = mem_id;
		this.mem_pw = mem_pw;
		this.mem_name = mem_name;
		this.mem_phone = mem_phone;
		this.mem_gender = mem_gender;
		this.mem_year = mem_year;
		this.mem_month = mem_month;
		this.mem_day = mem_day;
		this.mem_point = mem_point;

	}
	
	
	public int getMem_num() {
		return mem_num;
	}
	public void setMem_num(int mem_num) {
		this.mem_num = mem_num;
	}
	public String getMem_id() {
		return mem_id;
	}
	public void setMem_id(String mem_id) {
		this.mem_id = mem_id;
	}
	public String getMem_pw() {
		return mem_pw;
	}
	public void setMem_pw(String mem_pw) {
		this.mem_pw = mem_pw;
	}
	public String getMem_name() {
		return mem_name;
	}
	public void setMem_name(String mem_name) {
		this.mem_name = mem_name;
	}
	public String getMem_phone() {
		return mem_phone;
	}
	public void setMem_phone(String mem_phone) {
		this.mem_phone = mem_phone;
	}
	public String getMem_gender() {
		return mem_gender;
	}
	public void setMem_gender(String mem_gender) {
		this.mem_gender = mem_gender;
	}
	public String getMem_year() {
		return mem_year;
	}
	public void setMem_year(String mem_year) {
		this.mem_year = mem_year;
	}
	public String getMem_month() {
		return mem_month;
	}
	public void setMem_month(String mem_month) {
		this.mem_month = mem_month;
	}
	public String getMem_day() {
		return mem_day;
	}
	public void setMem_day(String mem_day) {
		this.mem_day = mem_day;
	}
	public int getMem_point() {
		return mem_point;
	}
	public void setMem_point(int mem_point) {
		this.mem_point = mem_point;
	}
	
	
	
	
	

	
	

} // end MemberVO
