package src.Fraction;


import java.util.Objects;

public final class Fraction extends Number{
	private final int numerator,denominator;

	public Fraction(int numerator, int denominator) throws Exception {
		if(denominator<=0) throw new Exception("Знаменатель не может быть отрицательным или равен 0");
		this.numerator = numerator;
		this.denominator = denominator;
	}
	public Fraction multiplay(Fraction d2) throws Exception {
		return new Fraction(
				this.numerator*d2.numerator,this.denominator*d2.denominator);
	}
	public Fraction multiplay(int d2) throws Exception {

		return this.multiplay(new Fraction(d2,1));
	}
	public Fraction sum(Fraction d2) throws Exception {
		return new Fraction(
				this.numerator*d2.denominator+d2.numerator*this.denominator,this.denominator*d2.denominator);
	}
	public Fraction sum(int d2) throws Exception {

		return this.sum( new Fraction(d2,1));
	}
	public Fraction minus(Fraction d2) throws Exception {
		return new Fraction(
				this.numerator*d2.denominator-d2.numerator*this.denominator,this.denominator*d2.denominator);
	}
	public Fraction minus(int d2) throws Exception {
		return this.sum(new Fraction(d2,1));
	}
	public Fraction div(Fraction d2) throws Exception {

		return new Fraction(this.numerator*d2.denominator,this.denominator*d2.numerator);
	}
	public Fraction div(int d2) throws Exception {

		return this.multiplay(new Fraction(d2,1));
	}

	@Override
	public int intValue() {
		return (int) (numerator/denominator);
	}

	@Override
	public long longValue() {
		return (long) (numerator/denominator);
	}

	@Override
	public float floatValue() {
		return (float) (numerator/denominator);
	}

	@Override
	public double doubleValue() {
		return  (numerator/(denominator*1.0));
	}

	@Override
	public String toString() {

		return numerator + " / " + denominator;
	}

	public int getNumerator() {
		return numerator;
	}
	public int getDenominator() {
		return denominator;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Fraction fraction = (Fraction) o;
		return numerator == fraction.numerator && denominator == fraction.denominator;
	}

	@Override
	public int hashCode() {
		return Objects.hash(numerator, denominator);
	}
}
