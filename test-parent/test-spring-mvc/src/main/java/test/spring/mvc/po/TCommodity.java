package test.spring.mvc.po;

public class TCommodity {
	
	private String Id;
	private String c_goods_code;
	private long c_user_qq;
	private String c_orders_code;
	private String c_create_date;
	public String getId() {
		return Id;
	}
	public void setId(String id) {
		Id = id;
	}
	public String getC_goods_code() {
		return c_goods_code;
	}
	public void setC_goods_code(String c_goods_code) {
		this.c_goods_code = c_goods_code;
	}
	public long getC_user_qq() {
		return c_user_qq;
	}
	public void setC_user_qq(long c_user_qq) {
		this.c_user_qq = c_user_qq;
	}
	public String getC_orders_code() {
		return c_orders_code;
	}
	public void setC_orders_code(String c_orders_code) {
		this.c_orders_code = c_orders_code;
	}
	public String getC_create_date() {
		return c_create_date;
	}
	public void setC_create_date(String c_create_date) {
		this.c_create_date = c_create_date;
	}
	
	

}
