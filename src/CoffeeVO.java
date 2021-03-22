

public class CoffeeVO {

	private String coff_name;
	private String coff_size;
	private String coff_shot;
	private String coff_temp;
	private int coff_price;
	private String coff_cream;
	private String coff_takeout;
	private String coff_ice;

	
	public CoffeeVO() {

	}

	public CoffeeVO(String coff_name, String coff_size, String coff_shot, String coff_temp, int coff_price,
			String coff_cream, String coff_takeout,String coff_ice) {
		super();
		this.coff_name = coff_name;
		this.coff_size = coff_size;
		this.coff_shot = coff_shot;
		this.coff_temp = coff_temp;
		this.coff_price = coff_price;
		this.coff_cream = coff_cream;
		this.coff_takeout = coff_takeout;
		this.coff_ice = coff_ice;

	}

	public String getCoff_name() {
		return coff_name;
	}

	public void setCoff_name(String coff_name) {
		this.coff_name = coff_name;
	}

	public String getCoff_size() {
		return coff_size;
	}

	public void setCoff_size(String coff_size) {
		this.coff_size = coff_size;
	}

	public String getCoff_shot() {
		return coff_shot;
	}

	public void setCoff_shot(String coff_shot) {
		this.coff_shot = coff_shot;
	}

	public String getCoff_temp() {
		return coff_temp;
	}

	public void setCoff_temp(String coff_temp) {
		this.coff_temp = coff_temp;
	}

	public int getCoff_price() {
		return coff_price;
	}

	public void setCoff_price(int coff_price) {
		this.coff_price = coff_price;
	}

	public String getCoff_cream() {
		return coff_cream;
	}

	public void setCoff_cream(String coff_cream) {
		this.coff_cream = coff_cream;
	}

	public String getCoff_takeout() {
		return coff_takeout;
	}

	public void setCoff_takeout(String coff_takeout) {
		this.coff_takeout = coff_takeout;
	}

	public String getCoff_ice() {
		return coff_ice;
	}

	public void setCoff_ice(String coff_ice) {
		this.coff_ice = coff_ice;
	}

	@Override
	public String toString() {
		return "CoffeeVO [coff_name=" + coff_name + ", coff_size=" + coff_size + ", coff_shot=" + coff_shot
				+ ", coff_temp=" + coff_temp + ", coff_price=" + coff_price + ", coff_cream=" + coff_cream
				+ ", coff_takeout=" + coff_takeout + ", coff_ice=" + coff_ice + "]";
	}

	

	
}