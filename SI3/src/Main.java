import java.util.Scanner;

public class Main {

    public static void main(String[] args)  {

        Scanner scan = new Scanner(System.in);
    Plansza test = new Plansza();
        System.out.println(test.plansza[2][6].sasiedzi.indexOf(46));
    System.out.println("Start gry w młynek");

        for(int i = 0; i < 9; i++)
        {
            /*System.out.println("Gracz białymi pionkami ustawia swoj pionek");
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
            System.out.println("Gracz czarnymi pionkami ustawia swoj pionek");
            test.wyswietl();*/
            test.minMaxEtap1(1, "alphabeta");
            test.wyswietl();
            test.minMaxEtap1(2, "alphabeta");
            test.wyswietl();
        }
        while(test.iloscBiale > 2 && test.iloscCzarne > 2)
        {
            /*System.out.println("Gracz bialymi podaje pole na ktorym znajduje sie pionek, ktorym chce wykonac ruch");
            test.wyswietl();
            String pole = "gdgfd";
            boolean sprawdz = false;
            while (sprawdz == false) {
                pole = "fsfs";
                while(pole.length() != 2) {
                    pole = scan.nextLine();
                    if(pole.length() != 2)
                    {
                        System.out.println("Nie ma takiego pola na planszy podaj inne");
                    }
                }
                int druga = test.zamiana(pole.charAt(0));
                int pierwsza = Character.getNumericValue(pole.charAt(1));
                if (druga == 0 || pierwsza > 7 || test.plansza[pierwsza][druga] == null) {
                    System.out.println("Nie ma takiego pola na planszy podaj inne");
                } else if (test.plansza[pierwsza][druga].pionek.equals("Bial")) {
                    sprawdz = true;
                }
                else
                {
                    System.out.println("Pole nie nalezy do ciebie. Podaj inne.");
                }
            }
            System.out.println("Gracz bialymi podaje pole na ktore chce przesunac wybrany pionek");
            String nowePole = "fsfs";
            while(nowePole.length() != 2) {
                nowePole = scan.nextLine();
                if(nowePole.length() != 2)
                {
                    System.out.println("Nie ma takiego pola na planszy podaj inne");
                }
            }
            if(test.iloscBiale > 3) {
                test.ruch(pole, nowePole, 1);
            }
            else
            {
                test.ruchPoCalejPlanszy(pole, nowePole, 1);
            }*/
            if(test.iloscBiale > 3) {
                test.minMaxEtap2(1, "alphabeta");
                test.wyswietl();
            }
            else
            {
                test.minMaxEtap3(1, "alphabeta");
                test.wyswietl();
            }
            if(test.iloscCzarne > 2) {
                if(test.iloscCzarne > 3) {
                    test.minMaxEtap2(2, "alphabeta");
                    test.wyswietl();
                }
                else
                {
                    test.minMaxEtap3(2, "alphabeta");
                    test.wyswietl();
                }
            }
        }

   /*for(int i = 0; i < 4; i++)
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
        System.out.println("Gracz czarnymi pionkami ustawia swoj pionek");
        test.wyswietl();
        pole = "fsfs";
        while(pole.length() != 2) {
            pole = scan.nextLine();
            if(pole.length() != 2)
            {
                System.out.println("Nie ma takiego pola na planszy podaj inne");
            }
        }
        test.postaw(pole, 2);
        test.zbicie(pole, 2);
    }
    while(test.iloscBiale > 2 && test.iloscCzarne > 2)
    {
        System.out.println("Gracz bialymi podaje pole na ktorym znajduje sie pionek, ktorym chce wykonac ruch");
        test.wyswietl();
        String pole = "gdgfd";
        boolean sprawdz = false;
        while (sprawdz == false) {
            pole = "fsfs";
            while(pole.length() != 2) {
                pole = scan.nextLine();
                if(pole.length() != 2)
                {
                    System.out.println("Nie ma takiego pola na planszy podaj inne");
                }
            }
            int druga = test.zamiana(pole.charAt(0));
            int pierwsza = Character.getNumericValue(pole.charAt(1));
            if (druga == 0 || pierwsza > 7 || test.plansza[pierwsza][druga] == null) {
                System.out.println("Nie ma takiego pola na planszy podaj inne");
            } else if (test.plansza[pierwsza][druga].pionek.equals("Bial")) {
                sprawdz = true;
            }
            else
            {
                System.out.println("Pole nie nalezy do ciebie. Podaj inne.");
            }
        }
        System.out.println("Gracz bialymi podaje pole na ktore chce przesunac wybrany pionek");
        String nowePole = "fsfs";
        while(nowePole.length() != 2) {
            nowePole = scan.nextLine();
            if(nowePole.length() != 2)
            {
                System.out.println("Nie ma takiego pola na planszy podaj inne");
            }
        }
        if(test.iloscBiale > 3) {
            test.ruch(pole, nowePole, 1);
        }
        else
        {
            test.ruchPoCalejPlanszy(pole, nowePole, 1);
        }
        if(test.iloscCzarne > 2) {
            System.out.println("Gracz czarnymi podaje pole na ktorym znajduje sie pionek, ktorym chce wykonac ruch");
            test.wyswietl();
            pole = "gdgfd";
            sprawdz = false;
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
                } else if (test.plansza[pierwsza][druga].pionek.equals("Czar")) {
                    sprawdz = true;
                } else {
                    System.out.println("Pole nie nalezy do ciebie. Podaj inne.");
                }
            }
            System.out.println("Gracz czarnymi podaje pole na ktore chce przesunac wybrany pionek");
            nowePole = "fsfs";
            while (nowePole.length() != 2) {
                nowePole = scan.nextLine();
                if (nowePole.length() != 2) {
                    System.out.println("Nie ma takiego pola na planszy podaj inne");
                }
            }
            if(test.iloscCzarne > 3) {
                test.ruch(pole, nowePole, 2);
            }
            else
            {
                test.ruchPoCalejPlanszy(pole, nowePole, 2);
            }
        }
    }*/
        if(test.iloscBiale == 2)
        {
            System.out.println("Wygrywa gracz czarnymi pionkami");
        }
        else
        {
            System.out.println("Wygrywa gracz bialymi pionkami");
        }
    }
}
