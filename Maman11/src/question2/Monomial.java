package question2;
import java.util.Scanner;

public class Monomial {
	private double _coefficient;
	private double _power;
	
	public Monomial(double _coefficient, double _power) {
		super();
		this._coefficient = _coefficient;
		this._power = _power;
	}

	public static double[] initializeArrays(int num, String str) {
		double[] array = new double[num];
		Scanner scan = new Scanner (System.in);
		for (int i=0; i<num; i++) {
			System.out.printf("Enter the %s of monomial number %d: ", str, i+1);
			array[i] = scan.nextDouble();
		}
		return array;
	}

	/**
	 * @return the _coefficient
	 */
	public double get_coefficient() {
		return _coefficient;
	}

	/**
	 * @return the _power
	 */
	public double get_power() {
		return _power;
	}
}
