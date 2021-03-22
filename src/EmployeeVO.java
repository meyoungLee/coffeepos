

public class EmployeeVO {
	private int emp_num;
	private String emp_name;
	private String emp_phone;
	private String emp_address;
	private String emp_rank;
	private String emp_job;
	private String emp_date;
	private String emp_time;
	private String emp_note;
	
	public EmployeeVO() {};
	public EmployeeVO(int emp_num, String emp_name, String emp_phone, String emp_address, String emp_rank,
			String emp_job, String emp_date, String emp_time, String emp_note) {
		this.emp_num = emp_num;
		this.emp_name = emp_name;
		this.emp_phone = emp_phone;
		this.emp_address = emp_address;
		this.emp_rank = emp_rank;
		this.emp_job = emp_job;
		this.emp_date = emp_date;
		this.emp_time = emp_time;
		this.emp_note = emp_note;
	}
	public int getEmp_num() {
		return emp_num;
	}
	public void setEmp_num(int emp_num) {
		this.emp_num = emp_num;
	}
	public String getEmp_name() {
		return emp_name;
	}
	public void setEmp_name(String emp_name) {
		this.emp_name = emp_name;
	}
	public String getEmp_phone() {
		return emp_phone;
	}
	public void setEmp_phone(String emp_phone) {
		this.emp_phone = emp_phone;
	}
	public String getEmp_address() {
		return emp_address;
	}
	public void setEmp_address(String emp_address) {
		this.emp_address = emp_address;
	}
	public String getEmp_rank() {
		return emp_rank;
	}
	public void setEmp_rank(String emp_rank) {
		this.emp_rank = emp_rank;
	}
	public String getEmp_job() {
		return emp_job;
	}
	public void setEmp_job(String emp_job) {
		this.emp_job = emp_job;
	}
	public String getEmp_date() {
		return emp_date;
	}
	public void setEmp_date(String emp_date) {
		this.emp_date = emp_date;
	}
	public String getEmp_time() {
		return emp_time;
	}
	public void setEmp_time(String emp_time) {
		this.emp_time = emp_time;
	}
	public String getEmp_note() {
		return emp_note;
	}
	public void setEmp_note(String emp_note) {
		this.emp_note = emp_note;
	}	
	

} // end EmployeeVO
