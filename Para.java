package java2lista1;

public class Para {
    
    public final String klucz;
    
    private double wartosc;
    
    public Para(String klucz) {
        this.klucz = klucz;
    }
    
    public void setWartosc(double wartosc) {
        this.wartosc = wartosc;
    }
    
    public double getWartosc() {
        return this.wartosc;
    }
    
    @Override
    public String toString() {
        return this.klucz + " = " + Double.toString(this.wartosc);
    }
    
    public boolean equals(Para para) {
        return this.klucz.equals(para.klucz);
    }
}
