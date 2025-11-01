package example.p08_collections.demo;

public class TextBook extends Book{

	

	public TextBook(String code, String name, double price, int quantity) {
		super(code, name, price, quantity);
	}

	@Override
	public double salePrice() {
		return quantity * price;
	}

}
