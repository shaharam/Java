package question1;
public class BillRow {
	private Product _prdct;
	private int _quantity;
	private double _sum;
	
	public BillRow(Product prdct, int quantity) {
		super();
		this._prdct = prdct;
		this._quantity = quantity;
		this._sum = prdct.get_price() * quantity;
	}

	/**
	 * @return quantity of product in the bill
	 */
	public int get_quantity() {
		return _quantity;
	}

	/**
	 * @return sum of the quantity * price
	 */
	public double get_sum() {
		return _sum;
	}

	/**
	 * @return the product object
	 */
	public Product get_prdct() {
		return _prdct;
	}
}
