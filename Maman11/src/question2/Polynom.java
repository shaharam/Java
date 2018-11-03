package question2;
import java.util.ArrayList;

public class Polynom {
	private ArrayList<Monomial> _polynom = new ArrayList<Monomial>();

	public Polynom(double[] coeff, double[] power) {
		super();
		for (int i=0; i<coeff.length; i++) {
			Monomial temp = new Monomial(coeff[i], power[i]);
			insertToArray(temp);
		}
	}
	
	private void insertToArray(Monomial temp) {
		for (int i=0; i<_polynom.size(); i++) {
			if (temp.get_power() < _polynom.get(i).get_power()) continue;
			_polynom.add(i, temp);
			return;
		}
		_polynom.add(temp);
	}
	
	@Override
	public String toString() {
		System.out.println("-------------------------------");
		String pol = "" + _polynom.get(0).get_coefficient() + "x^" + (int)_polynom.get(0).get_power();
		for(int i=1; i<_polynom.size(); i++) {
			if (_polynom.get(i).get_coefficient() > 1) {
				pol += "+" + _polynom.get(i).get_coefficient();
			}
			else if (_polynom.get(i).get_coefficient() < -1) {
				pol += _polynom.get(i).get_coefficient();
			}
			else if (_polynom.get(i).get_coefficient() == 1)	{
				if (_polynom.get(i).get_power() == 0) {
					pol += "+" + _polynom.get(i).get_coefficient();
				}
				else {
					pol += "+";
				}
			}
			else {
				if (_polynom.get(i).get_power() == 0) {
					pol += _polynom.get(i).get_coefficient();
				}
				else {
					pol += "-";
				}
			}
			if (_polynom.get(i).get_power() > 1) {
				pol += "x^" + (int)_polynom.get(i).get_power();
			}
			else if (_polynom.get(i).get_power() == 1) {
				pol += "x";
			}
		}
		System.out.println(pol);
		System.out.println("-------------------------------");
		return pol;
	}
}
