package java2lista1;

public class Java2Lista1 {
    
    public static void testWstawTrzyParyWyswietlZbior() throws Exception
    {
       Para para1 = new Para("klucz1");
       Para para2 = new Para("klucz2");
       Para para3 = new Para("klucz3");
       para1.setWartosc(0.01);
       para2.setWartosc(1.02);
       para3.setWartosc(2.03);
       Zbior zbior = new Zbior(10);
       System.out.println("--testWstawTrzyParyWyswietlZbior--");
       zbior.wstaw(para1).wstaw(para2).wstaw(para3).wypiszKluczeUstawionychPar();
       System.out.println("----------------------------------");
    }
    
    public static void testProbaWstawieniaTakiejSamejParyDoZbioruZwracaWyjatek()
    {
        try {
            Para para1 = new Para("klucz");
            Para para2 = new Para("klucz");
            para1.setWartosc(2);
            para2.setWartosc(2);
            Zbior zbior = new Zbior();
            zbior.wstaw(para1).wstaw(para2);
        } catch (Exception e) {
            System.out.println("--testProbaWstawieniaTakiejSamejParyDoZbioruZwracaWyjatek--");
            System.out.println(e.getMessage());
            System.out.println("----------------------------------");
        }
    }
    
    public static void testDodanieJedynastegoElementuDlaDomyslnegoZbioruZwracaWyjatek()
    {
        System.out.println("--testDodanieJedynastegoElementuDlaDomyslnegoZbioruZwracaWyjatek--");
        Para para;
        Zbior zbior = new Zbior();
        for(int i = 0; i < 11; i++) {
            para = new Para("klucz" + i);
            try {
                zbior.wstaw(para);
            } catch (Exception e) {
                System.out.println(e.getMessage());
                System.out.println("Poprawnie zgloszono wyjatek na indeksie " + (i+1));
            }
        }
        System.out.println("----------------------------------");
    }
    
    public static void testProbaWstawieniaNullDoZbioruZwracaWyjatek()
    {
        Zbior zbior = new Zbior();
        try {
            zbior.wstaw(null);
        } catch (Exception e ) {
            System.out.println("--testProbaWstawieniaNullDoZbioruZwracaWyjatek--");
            System.out.println(e.getMessage());
            System.out.println("Poprawnie zablokowano mozliwosc dodania nulla do Zbioru");
            System.out.println("----------------------------------");
        }
    }
    
    public static void testDodatnieCzwartegoElementyDlaZbioruUstawionegoDlaTrzechParZwracaWyjatek()
    {
        System.out.println("--testProbaWstawieniaNullDoZbioruZwracaWyjatek--");
        int maksymalnaIloscPar = 3;
        Para para;
        Zbior zbior = new Zbior(maksymalnaIloscPar);
        for(int i = 0; i < maksymalnaIloscPar+1; i++) {
            para = new Para("klucz" + (i+1));
            try {
                zbior.wstaw(para);
            } catch (Exception e) {
                System.out.println(e.getMessage());
                System.out.println("Poprawnie zgloszono wyjatek na indeksie " + (i+1));
            }
        }
        System.out.println("----------------------------------");
    }

    public static void main(String[] args) throws Exception {
        Java2Lista1.testWstawTrzyParyWyswietlZbior();
        Java2Lista1.testProbaWstawieniaTakiejSamejParyDoZbioruZwracaWyjatek();
        Java2Lista1.testDodanieJedynastegoElementuDlaDomyslnegoZbioruZwracaWyjatek();
        Java2Lista1.testProbaWstawieniaNullDoZbioruZwracaWyjatek();
        Java2Lista1.testDodatnieCzwartegoElementyDlaZbioruUstawionegoDlaTrzechParZwracaWyjatek();
    }
    
}
