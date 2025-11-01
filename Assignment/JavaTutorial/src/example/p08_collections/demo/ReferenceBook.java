package example.p08_collections.demo;

public class ReferenceBook extends Book{

	public ReferenceBook(String code, String name, double price, int quantity) {
		super(code, name, price, quantity);
		// TODO Auto-generated constructor stub
	}

	@Override
	public double salePrice() {
		return quantity * price * 1.1;
	}

}
