package question1;
public class Product {
	private String _name;
	private double _price;
	
	/**
	 * @param _name - name of the product
	 * @param _price - price of the product
	 */
	public Product(String _name, double _price) {
		super();
		this._name = _name;
		this._price = _price;
	}

	/**
	 * @return name of the product
	 */
	public String get_name() {
		return _name;
	}

	/**
	 * @return price of the product
	 */
	public double get_price() {
		return _price;
	}
}
