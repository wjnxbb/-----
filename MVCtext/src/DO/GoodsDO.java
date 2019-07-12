package DO;

public class GoodsDO {
	private int Gid;
	private String Gname;
	private int Gstore;
	private double price;
	public GoodsDO(int id,String name,int store,double price) {
		this.Gid = id;
		this.Gname = name;
		this.Gstore = store;
		this.price = price;
	}
	public GoodsDO() {
		
	}
	public int getGid() {
		return Gid;
	}
	public void setGid(int gid) {
		Gid = gid;
	}
	public String getGname() {
		return Gname;
	}
	public void setGname(String gname) {
		Gname = gname;
	}
	public int getGstore() {
		return Gstore;
	}
	public void setGstore(int gstore) {
		Gstore = gstore;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
}
