package javaapplication2;

public final class Fraction extends Number{

    final int numerator, denominator;

    public Fraction(int numerator , int denominator)
    {
        if (denominator <= 0) throw new IllegalArgumentException("denominator > 0");

        this.numerator = numerator;
        this.denominator = denominator;
    }

    public Fraction sum(Fraction f)
    {
        return new Fraction(this.numerator * f.denominator + f.numerator * this.denominator , this.denominator * f.denominator);
    }

    public Fraction sum(int f)
    {
        return new Fraction(this.numerator + f * this.denominator , this.denominator);
    }

    public Fraction minus(Fraction f)
    {
        return new Fraction(this.numerator * f.denominator - f.numerator * this.denominator , this.denominator * f.denominator);
    }

    public Fraction minus(int f)
    {
        return new Fraction(this.numerator - f * this.denominator , this.denominator);
    }

    public Fraction multiply(Fraction f)
    {
        return new Fraction(this.numerator * f.numerator,   this.denominator  * f.denominator);
    }

    public Fraction multiply(int f)
    {
        return new Fraction(this.numerator * f , this.denominator);
    }

    public Fraction division(Fraction f)
    {
        return new Fraction(this.numerator * f.denominator,this.denominator * f.numerator);
    }

    public Fraction division(int f)
    {
        return new Fraction(this.numerator  , this.denominator * f);
    }

//    @Override
//    public boolean equals(Object obj) {
//        if (obj == null) {
//            return false;
//        }
//        if (getClass() != obj.getClass()) {
//            return false;
//        }
//        Fraction other = (Fraction) obj;
//        if (this.numerator != other.numerator) {
//            return false;
//        }
//        return this.denominator == other.denominator;
//    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Fraction other = (Fraction) obj;
        if (this.numerator != other.numerator) {
            return false;
        }
        return this.denominator == other.denominator;
    }

    
    

    @Override
    public int intValue() {
        return numerator / denominator;
    }

    @Override
    public long longValue()
    {
        return  (long)numerator / denominator;
    }

    @Override
    public float floatValue()
    {
        return (float)numerator / denominator;
    }

    @Override
    public double doubleValue()
    {
        return (double) numerator / denominator;
    }



    @Override
    public String toString() {
        return numerator + "/" + denominator;
    }
}