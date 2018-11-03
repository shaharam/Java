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

	public int get_quantity() {
		return _quantity;
	}

	public double get_sum() {
		return _sum;
	}

	public Product get_prdct() {
		return _prdct;
	}
}
