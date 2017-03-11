package java2lista1;

public class Zbior {
    
    public static final int DEFAULT_SIZE = 10;
    
    private final int rozmiar;
    
    private Para[] pary;
    
    public Zbior(int iloscPar) {
        if (iloscPar < 1) {
            this.rozmiar = Zbior.DEFAULT_SIZE;
            this.pary = new Para[Zbior.DEFAULT_SIZE];
        } else {
            this.rozmiar = iloscPar;
            this.pary = new Para[iloscPar];
        }
    }
    
    public Zbior() {
            this.pary = new Para[Zbior.DEFAULT_SIZE];
            this.rozmiar = Zbior.DEFAULT_SIZE;
    }
    
    private int ostatniUstawionyIndeks() {
        int indeks = -1;
        for(Para para: this.pary) {
            if (para == null) {
                return indeks;
            }
            indeks++;
        }
        System.out.println("Ostatni ustawiony indeks: " + indeks);
        return indeks;
    }
    
    private int ile() {
        return this.ostatniUstawionyIndeks() + 1;
    }
    
    public void wyczysc() {
        this.pary = new Para[this.rozmiar];
    }
    
    public Para szukaj(String klucz) {
        for (Para para: this.pary) {
            if (klucz.equals(para.klucz)) {
                return para; 
            }
        }
        return null;
    }
    
    public int znajdzIndeksPary(Para szukanaPara) {
        int indeks = -1;
        int licznik = 0;
        for (Para para: this.pary) {
            if (para != null && szukanaPara.equals(para)) {
                indeks = licznik;
                break;
            }
            licznik++;
        }
        
        return indeks;
    }
    
    public boolean paraIstnieje(Para szukanaPara) {
        return this.znajdzIndeksPary(szukanaPara) > -1;
    }
    
    public boolean jestWolneMiejsce() {
        return this.ile() < this.rozmiar;
    }
    
    public Zbior wstaw(Para para) throws Exception {
        if (this.paraIstnieje(para)) {
            throw new Exception("Para istnieje.");
        } else if (!this.jestWolneMiejsce()) {
            throw new Exception("Nie ma miejsca. Maksymalna ilość par " + (this.rozmiar));
        } else if (para == null) {
            throw new Exception("Para nie moze byc nullem.");
        } else {
            System.out.println("Wstawiam na indeksie " + (this.ile()));
            this.pary[(this.ile())] = para;
        }
        return this;
    }
    
    public void wstawAlboAktualizuj(Para para) throws Exception {
        boolean jestWolneMiejsce = this.jestWolneMiejsce();
        boolean paraIstnieje = this.paraIstnieje(para);
        if (!jestWolneMiejsce && !paraIstnieje) {
            throw new Exception("Nie ma miejsca na nową parę.");
        } else if (paraIstnieje) {
            this.pary[this.znajdzIndeksPary(para)] = para;
        } else {
            this.pary[this.ile()] = para;
        }
    }
    
    public void wypiszKluczeUstawionychPar() {
        for (Para para: this.pary) {
            if (para != null) {
                System.out.println(para);
            }
        }
    }
}
