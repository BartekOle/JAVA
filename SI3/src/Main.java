import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Main {

    public static void main(String[] args)  {

        int ruchy = 0;
        Scanner scan = new Scanner(System.in);
    Plansza test = new Plansza();
        System.out.println("Wpisz 1 jesli chcesz grac z komputerem, wpisz 2 jesli ma byc Ai vs Ai");
        int rodzajGry = scan.nextInt();
        String CzasRozpoczecia = LocalDateTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss.SSS"));
        System.out.println("Czas rozpoczecia gry: " + CzasRozpoczecia);
    System.out.println("Start gry w młynek");

        for(int i = 0; i < 9; i++)
        {
            if(rodzajGry == 1)
        {
            System.out.println("Gracz białymi pionkami ustawia swoj pionek");
            test.wyswietl();
            String pole = "fsfs";
            while(pole.length() != 2) {
                pole = scan.nextLine();
                if(pole.length() != 2)
                {
                    System.out.println("Nie ma takiego pola na planszy podaj inne");
                }
            }
            test.postaw(pole, 1);
            test.zbicie(pole, 1);
        }
            if(rodzajGry == 2) {
                test.minMaxEtap1(1, "minmax", "dodatkowePunkty", 2);
                test.wyswietl();
            }
            test.minMaxEtap1(2, "minmax", "brak", 1);
            test.wyswietl();
            ruchy++;
        }
        while(test.iloscBiale > 2 && test.iloscCzarne > 2)
        {
            if(rodzajGry == 1) {
                System.out.println("Gracz bialymi podaje pole na ktorym znajduje sie pionek, ktorym chce wykonac ruch");
                test.wyswietl();
                String pole = "gdgfd";
                boolean sprawdz = false;
                while (sprawdz == false) {
                    pole = "fsfs";
                    while (pole.length() != 2) {
                        pole = scan.nextLine();
                        if (pole.length() != 2) {
                            System.out.println("Nie ma takiego pola na planszy podaj inne");
                        }
                    }
                    int druga = test.zamiana(pole.charAt(0));
                    int pierwsza = Character.getNumericValue(pole.charAt(1));
                    if (druga == 0 || pierwsza > 7 || test.plansza[pierwsza][druga] == null) {
                        System.out.println("Nie ma takiego pola na planszy podaj inne");
                    } else if (test.plansza[pierwsza][druga].pionek.equals("Bial")) {
                        sprawdz = true;
                    } else {
                        System.out.println("Pole nie nalezy do ciebie. Podaj inne.");
                    }
                }
                System.out.println("Gracz bialymi podaje pole na ktore chce przesunac wybrany pionek");
                String nowePole = "fsfs";
                while (nowePole.length() != 2) {
                    nowePole = scan.nextLine();
                    if (nowePole.length() != 2) {
                        System.out.println("Nie ma takiego pola na planszy podaj inne");
                    }
                }
                if (test.iloscBiale > 3) {
                    test.ruch(pole, nowePole, 1);
                } else {
                    test.ruchPoCalejPlanszy(pole, nowePole, 1);
                }
            }
            if(rodzajGry == 2) {
                if (test.iloscBiale > 3) {
                    test.minMaxEtap2(1, "minmax", "dodatkowePunkty", 2);
                    test.wyswietl();
                } else {
                    test.minMaxEtap3(1, "minmax", "dodatkowePunkty", 1);
                    test.wyswietl();
                }
            }
            if(test.iloscCzarne > 2) {
                if(test.iloscCzarne > 3) {
                    test.minMaxEtap2(2, "minmax", "brak", 1);
                    test.wyswietl();
                }
                else
                {
                    test.minMaxEtap3(2, "minmax", "brak", 1);
                    test.wyswietl();
                }
            }
            ruchy++;
        }

        String CzasZakonczenia = LocalDateTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss.SSS"));
        System.out.println("Czas zakonczzenia gry: " + CzasZakonczenia);
        if(test.iloscBiale == 2)
        {
            System.out.println("Wygrywa gracz czarnymi pionkami, wykonanych iteracji: " + test.iteracje + " ilosc ruchow wynosila " + ruchy);
        }
        else
        {
            System.out.println("Wygrywa gracz bialymi pionkami, wykonanych iteracji: " + test.iteracje + " ilosc ruchow wynosila " + ruchy);
        }
    }
}
