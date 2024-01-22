
public class Fraction {
    private int numer, demon;

    public Fraction() {
        numer = 0;
        demon = 1;
    }

    public Fraction(int x, int y) {
        numer = x;
        demon = y;
    }

    public Fraction(Fraction f) {
        numer = f.numer;
        demon = f.demon;
    }

    private int gcd(int numer, int demon) {
        if (numer == 0)
            return demon;
        return gcd(demon % numer, numer);
    }

    private Fraction gcd(Fraction f) {
        int tmp = gcd(f.numer, f.demon);
        return new Fraction(f.numer/tmp, f.demon/tmp);
    }

    @Override
    public String toString() {
        return numer + "/" + demon; 
    }

    @Override
    public boolean equals(Object f) {
        if (f instanceof Fraction) {
            Fraction f0 = new Fraction(this.numer, this.demon);
            Fraction f1 = (Fraction)f;
            f0 = f0.gcd(f0);
            f1 = f1.gcd(f1);
            return f0.numer == f1.numer && f0.demon == f1.demon;
        }
        return false;
    }
}
