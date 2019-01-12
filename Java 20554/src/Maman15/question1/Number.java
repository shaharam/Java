package Maman15.question1;

public class Number {
	private boolean checked;
	private boolean prime;
	
	public Number() {
		this.checked = false;
	}

	public boolean isChecked() {
		return checked;
	}

	public boolean isPrime() {
		return prime;
	}

	public void setChecked(boolean checked) {
		this.checked = checked;
	}

	public void setPrime(boolean prime) {
		this.prime = prime;
	}
}
