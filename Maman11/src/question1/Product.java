package question1;
public class Product {
	private String _name;
	private double _price;
	
	public Product(String _name, double _price) {
		super();
		this._name = _name;
		this._price = _price;
	}

	public String get_name() {
		return _name;
	}

	public double get_price() {
		return _price;
	}
}
