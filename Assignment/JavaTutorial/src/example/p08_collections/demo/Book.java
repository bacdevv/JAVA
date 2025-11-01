package example.p08_collections.demo;

public abstract class Book implements Comparable<Book>{
	protected String code;
	protected String name;
	protected double price;
	protected int quantity;
	
	public abstract double salePrice();
	
	

	@Override
	public int compareTo(Book o) {
		return this.code.compareTo(o.code);
	}



	public Book(String code, String name, double price, int quantity) {
		this.code = code;
		this.name = name;
		this.price = price;
		this.quantity = quantity;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	
	
}
