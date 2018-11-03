package question2;
import java.util.ArrayList;
import java.util.Scanner;

public class Polynom {
	private ArrayList<Monomial> _polynom = new ArrayList<Monomial>();

	public Polynom(double[] coeff, int[] power) {
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
	
	public static Polynom polynomCreation(String str) {
		Scanner scan = new Scanner (System.in);
		System.out.println("Enter the number of monomials in the " + str + " polynom: ");
		int number = scan.nextInt();
		double[] coefficients = Monomial.coefficientArray(number);
		int[] powers = Monomial.powerArray(number);
		Polynom pol = new Polynom(coefficients, powers);
		System.out.println("----------------------------------------------");
		return pol;
	}
	
	public Polynom plus(Polynom other) {
		int size = this._polynom.size() + other._polynom.size();
		double[] coefficients = new double[size];
		int[] powers = new int[size];
		int i = 0;
		int j = 0;
		int k = 0;
		while (i < this._polynom.size() && j < other._polynom.size()) {
			if (this._polynom.get(i).get_power() > other._polynom.get(j).get_power()) {
				coefficients[k] = this._polynom.get(i).get_coefficient();
				powers[k] = this._polynom.get(i).get_power();
				i++;
				k++;
			}
			else if (this._polynom.get(i).get_power() < other._polynom.get(j).get_power()) {
				coefficients[k] = other._polynom.get(j).get_coefficient();
				powers[k] = other._polynom.get(j).get_power();
				j++;
				k++;
			}
			else {
				coefficients[k] = this._polynom.get(i).get_coefficient() + other._polynom.get(j).get_coefficient();
				powers[k] = other._polynom.get(i).get_power();
				i++;
				j++;
				k++;
			}
		}
		while (this._polynom.get(i) != null) {
			coefficients[k] = this._polynom.get(i).get_coefficient();
			powers[k] = this._polynom.get(i).get_power();
			i++;
			k++;
		}
		while (this._polynom.get(j) != null) {
			coefficients[k] = this._polynom.get(j).get_coefficient();
			powers[k] = this._polynom.get(j).get_power();
			j++;
			k++;
		}
		Polynom plus = new Polynom(coefficients, powers);
		return plus;
	}
	
	private int greaterPolynom(Polynom other) {
		if (this._polynom.size() > other._polynom.size()) return this._polynom.size();
		return other._polynom.size();
	}
	
	@Override
	public String toString() {
		System.out.println("-------------------------------");
		String pol = "" + _polynom.get(0).get_coefficient() + "x^" + _polynom.get(0).get_power();
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
				pol += "x^" + _polynom.get(i).get_power();
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
