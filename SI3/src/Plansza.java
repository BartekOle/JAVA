import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

public class Plansza {
    Pole plansza[][];
    int zbicie[][];
    int iloscBiale;
    int iloscCzarne;
    int punkty;
    int ostatniMlynekBiale;
    int ostatniMlynekCzarne;

    public Plansza() {
        ostatniMlynekBiale = -1;
        ostatniMlynekCzarne = -1;
        iloscBiale = 0;
        iloscCzarne = 0;
        punkty = 0;
        this.plansza = new Pole[8][8];
        this.zbicie = new int[16][3];

        for (int i = 1; i < 8; i = i + 6) {
            for (int j = 1; j < 8; j = j + 3) {
                String tekst = Integer.toString(i) + Integer.toString(j);
                int pole = Integer.parseInt(tekst);
                this.plansza[i][j] = new Pole(pole);
            }
        }

        for (int i = 2; i < 7; i = i + 4) {
            for (int j = 2; j < 7; j = j + 2) {
                String tekst = Integer.toString(i) + Integer.toString(j);
                int pole = Integer.parseInt(tekst);
                this.plansza[i][j] = new Pole(pole);
            }
        }

        for (int i = 3; i < 6; i = i + 2) {
            for (int j = 3; j < 6; j++) {
                String tekst = Integer.toString(i) + Integer.toString(j);
                int pole = Integer.parseInt(tekst);
                this.plansza[i][j] = new Pole(pole);
            }
        }

        for (int i = 1; i < 8; i++) {
            if (i != 4) {
                String tekst = Integer.toString(4) + Integer.toString(i);
                int pole = Integer.parseInt(tekst);
                this.plansza[4][i] = new Pole(pole);
            }

        }

        this.zbicie[0][0] = 11;
        this.zbicie[0][1] = 14;
        this.zbicie[0][2] = 17;
        this.zbicie[1][0] = 22;
        this.zbicie[1][1] = 24;
        this.zbicie[1][2] = 26;
        this.zbicie[2][0] = 33;
        this.zbicie[2][1] = 34;
        this.zbicie[2][2] = 35;
        this.zbicie[3][0] = 53;
        this.zbicie[3][1] = 54;
        this.zbicie[3][2] = 55;
        this.zbicie[4][0] = 62;
        this.zbicie[4][1] = 64;
        this.zbicie[4][2] = 66;
        this.zbicie[5][0] = 71;
        this.zbicie[5][1] = 74;
        this.zbicie[5][2] = 77;
        this.zbicie[6][0] = 11;
        this.zbicie[6][1] = 41;
        this.zbicie[6][2] = 71;
        this.zbicie[7][0] = 22;
        this.zbicie[7][1] = 42;
        this.zbicie[7][2] = 62;
        this.zbicie[8][0] = 33;
        this.zbicie[8][1] = 43;
        this.zbicie[8][2] = 53;
        this.zbicie[9][0] = 35;
        this.zbicie[9][1] = 45;
        this.zbicie[9][2] = 55;
        this.zbicie[10][0] = 26;
        this.zbicie[10][1] = 46;
        this.zbicie[10][2] = 66;
        this.zbicie[11][0] = 17;
        this.zbicie[11][1] = 47;
        this.zbicie[11][2] = 77;
        this.zbicie[12][0] = 14;
        this.zbicie[12][1] = 24;
        this.zbicie[12][2] = 34;
        this.zbicie[13][0] = 54;
        this.zbicie[13][1] = 64;
        this.zbicie[13][2] = 74;
        this.zbicie[14][0] = 41;
        this.zbicie[14][1] = 42;
        this.zbicie[14][2] = 43;
        this.zbicie[15][0] = 45;
        this.zbicie[15][1] = 46;
        this.zbicie[15][2] = 47;
        this.plansza[1][1].sasiedzi.add(14);
        this.plansza[1][1].sasiedzi.add(41);
        this.plansza[4][1].sasiedzi.add(11);
        this.plansza[4][1].sasiedzi.add(71);
        this.plansza[4][1].sasiedzi.add(42);
        this.plansza[7][1].sasiedzi.add(41);
        this.plansza[7][1].sasiedzi.add(74);
        this.plansza[2][2].sasiedzi.add(42);
        this.plansza[2][2].sasiedzi.add(24);
        this.plansza[4][2].sasiedzi.add(41);
        this.plansza[4][2].sasiedzi.add(43);
        this.plansza[4][2].sasiedzi.add(22);
        this.plansza[4][2].sasiedzi.add(62);
        this.plansza[6][2].sasiedzi.add(42);
        this.plansza[6][2].sasiedzi.add(64);
        this.plansza[3][3].sasiedzi.add(43);
        this.plansza[3][3].sasiedzi.add(34);
        this.plansza[4][3].sasiedzi.add(53);
        this.plansza[4][3].sasiedzi.add(33);
        this.plansza[4][3].sasiedzi.add(42);
        this.plansza[5][3].sasiedzi.add(43);
        this.plansza[5][3].sasiedzi.add(54);
        this.plansza[1][4].sasiedzi.add(24);
        this.plansza[1][4].sasiedzi.add(11);
        this.plansza[1][4].sasiedzi.add(17);
        this.plansza[2][4].sasiedzi.add(22);
        this.plansza[2][4].sasiedzi.add(26);
        this.plansza[2][4].sasiedzi.add(14);
        this.plansza[2][4].sasiedzi.add(34);
        this.plansza[3][4].sasiedzi.add(24);
        this.plansza[3][4].sasiedzi.add(35);
        this.plansza[3][4].sasiedzi.add(33);
        this.plansza[5][4].sasiedzi.add(55);
        this.plansza[5][4].sasiedzi.add(53);
        this.plansza[5][4].sasiedzi.add(64);
        this.plansza[6][4].sasiedzi.add(54);
        this.plansza[6][4].sasiedzi.add(74);
        this.plansza[6][4].sasiedzi.add(66);
        this.plansza[6][4].sasiedzi.add(62);
        this.plansza[7][4].sasiedzi.add(77);
        this.plansza[7][4].sasiedzi.add(71);
        this.plansza[7][4].sasiedzi.add(64);
        this.plansza[3][5].sasiedzi.add(45);
        this.plansza[3][5].sasiedzi.add(34);
        this.plansza[4][5].sasiedzi.add(55);
        this.plansza[4][5].sasiedzi.add(46);
        this.plansza[4][5].sasiedzi.add(35);
        this.plansza[5][5].sasiedzi.add(45);
        this.plansza[5][5].sasiedzi.add(54);
        this.plansza[2][6].sasiedzi.add(24);
        this.plansza[2][6].sasiedzi.add(46);
        this.plansza[4][6].sasiedzi.add(47);
        this.plansza[4][6].sasiedzi.add(45);
        this.plansza[4][6].sasiedzi.add(26);
        this.plansza[4][6].sasiedzi.add(66);
        this.plansza[6][6].sasiedzi.add(46);
        this.plansza[6][6].sasiedzi.add(64);
        this.plansza[1][7].sasiedzi.add(47);
        this.plansza[1][7].sasiedzi.add(14);
        this.plansza[4][7].sasiedzi.add(17);
        this.plansza[4][7].sasiedzi.add(77);
        this.plansza[4][7].sasiedzi.add(46);
        this.plansza[7][7].sasiedzi.add(47);
        this.plansza[7][7].sasiedzi.add(71);
    }

    public void wyswietl() {

        for (int i = 7; i > 0; i--) {
            for (int j = 1; j < 8; j++) {
                if (j == 1) {
                    System.out.print(i + "    ");
                }
                if (this.plansza[i][j] == null) {
                    System.out.print("     ");
                } else {
                    System.out.print(plansza[i][j].pionek + " ");
                }
            }
            System.out.println();
        }
        System.out.print("  ");
        for (int i = 0; i < 7; i++) {
            int znakLiczba = 97 + i;
            char znak = (char) znakLiczba;
            System.out.print("    " + znak);
        }
        System.out.println();

    }

    public int zamiana(char znak) {
        int liczba = 0;
        if (znak == 'a') {
            liczba = 1;
        } else if (znak == 'b') {
            liczba = 2;
        } else if (znak == 'c') {
            liczba = 3;
        } else if (znak == 'd') {
            liczba = 4;
        } else if (znak == 'e') {
            liczba = 5;
        } else if (znak == 'f') {
            liczba = 6;
        } else if (znak == 'g') {
            liczba = 7;
        }

        return liczba;
    }

    public void postaw(String pole, int kolejnosc) {
        Scanner scan = new Scanner(System.in);
        boolean sprawdz = false;
        while (sprawdz == false) {

            int druga = zamiana(pole.charAt(0));
            int pierwsza = Character.getNumericValue(pole.charAt(1));
            if (druga == 0 || pierwsza > 7 || this.plansza[pierwsza][druga] == null) {
                System.out.println("Nie ma takiego pola na planszy podaj inne");
                sprawdz = false;
            } else if (!this.plansza[pierwsza][druga].pionek.equals("Brak")) {
                System.out.println("Pole zajete wybierz inne");
                sprawdz = false;
            } else {
                if (kolejnosc == 1) {
                    this.plansza[pierwsza][druga].pionek = "Bial";
                    iloscBiale++;
                } else {
                    this.plansza[pierwsza][druga].pionek = "Czar";
                    iloscCzarne++;
                }
                sprawdz = true;
            }
            if (sprawdz == false) {
                pole = "fsfs";
                while (pole.length() != 2) {
                    pole = scan.nextLine();
                    if (pole.length() != 2) {
                        System.out.println("Nie ma takiego pola na planszy podaj inne");
                    }
                }
            }
        }
    }

    public void zbicie(String pole, int kolejnosc) {
        Scanner scan = new Scanner(System.in);

        int drugaWspolrzedna = zamiana(pole.charAt(0));
        int pierwszaWspolrzedna = Character.getNumericValue(pole.charAt(1));
        String tekst = Integer.toString(pierwszaWspolrzedna) + Integer.toString(drugaWspolrzedna);
        int poleLiczba = Integer.parseInt(tekst);
        for (int i = 0; i < 16; i++) {
            for (int j = 0; j < 3; j++) {
                if (this.zbicie[i][j] == poleLiczba) {
                    int pierwsza = this.zbicie[i][0];
                    int druga = this.zbicie[i][1];
                    int trzecia = this.zbicie[i][2];
                    int pierwszaA = pierwsza / 10;
                    int pierwszaB = pierwsza % 10;
                    int drugaA = druga / 10;
                    int drugaB = druga % 10;
                    int trzeciaA = trzecia / 10;
                    int trzeciaB = trzecia % 10;
                    if (kolejnosc == 1 && ostatniMlynekBiale != i && this.plansza[pierwszaA][pierwszaB].pionek.equals("Bial") && this.plansza[drugaA][drugaB].pionek.equals("Bial") && this.plansza[trzeciaA][trzeciaB].pionek.equals("Bial")) {
                        boolean sprawdz = false;
                        System.out.println("Wybierz pionek przeciwnika, ktory chcesz usunac");
                        String poleDoZbicia = scan.nextLine();
                        while (!sprawdz) {
                            int drugaDoZbicia = zamiana(poleDoZbicia.charAt(0));
                            int pierwszaDoZbicia = Character.getNumericValue(poleDoZbicia.charAt(1));
                            if (drugaDoZbicia == 0 || pierwszaDoZbicia > 7 || this.plansza[pierwszaDoZbicia][drugaDoZbicia] == null) {
                                System.out.println("Nie ma takiego pola na planszy podaj inne");
                                sprawdz = false;
                            } else if (!this.plansza[pierwszaDoZbicia][drugaDoZbicia].pionek.equals("Czar")) {
                                System.out.println("Pole nie nalezy do gracza z czarnymi pionkami, podaj innej.");
                                sprawdz = false;
                            } else {
                                this.plansza[pierwszaDoZbicia][drugaDoZbicia].pionek = "Brak";
                                sprawdz = true;
                                iloscCzarne--;
                                ostatniMlynekBiale = i;
                            }
                            if (sprawdz == false) {
                                poleDoZbicia = "fsfs";
                                while (poleDoZbicia.length() != 2) {
                                    poleDoZbicia = scan.nextLine();
                                    if (poleDoZbicia.length() != 2) {
                                        System.out.println("Nie ma takiego pola na planszy podaj inne");
                                    }
                                }
                            }
                        }
                        this.wyswietl();
                    } else if (kolejnosc == 2 && ostatniMlynekCzarne != i && this.plansza[pierwszaA][pierwszaB].pionek.equals("Czar") && this.plansza[drugaA][drugaB].pionek.equals("Czar") && this.plansza[trzeciaA][trzeciaB].pionek.equals("Czar")) {
                        boolean sprawdz = false;
                        System.out.println("Wybierz pionek przeciwnika, ktory chcesz usunac");
                        String poleDoZbicia = scan.nextLine();
                        int drugaDoZbicia = zamiana(poleDoZbicia.charAt(0));
                        int pierwszaDoZbicia = Character.getNumericValue(poleDoZbicia.charAt(1));
                        while (sprawdz == false) {
                            if (drugaDoZbicia == 0 || pierwszaDoZbicia > 7 || this.plansza[pierwszaDoZbicia][drugaDoZbicia] == null) {
                                System.out.println("Nie ma takiego pola na planszy podaj inne");
                                sprawdz = false;
                            } else if (!this.plansza[pierwszaDoZbicia][drugaDoZbicia].pionek.equals("Bial")) {
                                System.out.println("Pole nie nalezy do gracza z bialymi pionkami, podaj innej.");
                                sprawdz = false;
                            } else {
                                this.plansza[pierwszaDoZbicia][drugaDoZbicia].pionek = "Brak";
                                sprawdz = true;
                                iloscBiale--;
                                ostatniMlynekCzarne = i;
                            }
                            if (sprawdz == false) {
                                poleDoZbicia = "fsfs";
                                while (poleDoZbicia.length() != 2) {
                                    poleDoZbicia = scan.nextLine();
                                    if (poleDoZbicia.length() != 2) {
                                        System.out.println("Nie ma takiego pola na planszy podaj inne");
                                    }
                                }
                            }
                        }
                        this.wyswietl();
                    }
                }
            }
        }
    }

    public void ruch(String pole, String nowePole, int kolejnosc) {
        Scanner scan = new Scanner(System.in);
        boolean sprawdz = false;
        while (sprawdz == false) {

            int druga = zamiana(nowePole.charAt(0));
            int pierwsza = Character.getNumericValue(nowePole.charAt(1));
            String numerPolaTekst = Integer.toString(pierwsza) + Integer.toString(druga);
            int numerPola = Integer.parseInt(numerPolaTekst);
            int drugaStara = zamiana(pole.charAt(0));
            int pierwszaStara = Character.getNumericValue(pole.charAt(1));
            if (druga == 0 || pierwsza > 7 || this.plansza[pierwsza][druga] == null) {
                System.out.println("Nie ma takiego pola na planszy podaj inne");
                sprawdz = false;
            } else if (!this.plansza[pierwsza][druga].pionek.equals("Brak")) {
                System.out.println("Pole zajete wybierz inne");
                sprawdz = false;
            } else if (this.plansza[pierwszaStara][drugaStara].sasiedzi.indexOf(numerPola) < 0) {
                System.out.println("Pole nie sasiaduje z wybranym wczesniej pionkiem");
                sprawdz = false;
            } else {
                if (kolejnosc == 1) {
                    this.plansza[pierwsza][druga].pionek = "Bial";
                    this.plansza[pierwszaStara][drugaStara].pionek = "Brak";
                    zbicie(nowePole, kolejnosc);
                } else {
                    this.plansza[pierwsza][druga].pionek = "Czar";
                    this.plansza[pierwszaStara][drugaStara].pionek = "Brak";
                    zbicie(nowePole, kolejnosc);
                }
                sprawdz = true;
            }
            if (sprawdz == false) {
                nowePole = "fsfs";
                while (nowePole.length() != 2) {
                    nowePole = scan.nextLine();
                    if (nowePole.length() != 2) {
                        System.out.println("Nie ma takiego pola na planszy podaj inne");
                    }
                }
            }
        }
    }

    public void ruchPoCalejPlanszy(String pole, String nowePole, int kolejnosc) {
        Scanner scan = new Scanner(System.in);
        boolean sprawdz = false;
        while (sprawdz == false) {

            int druga = zamiana(nowePole.charAt(0));
            int pierwsza = Character.getNumericValue(nowePole.charAt(1));
            int drugaStara = zamiana(pole.charAt(0));
            int pierwszaStara = Character.getNumericValue(pole.charAt(1));
            if (druga == 0 || pierwsza > 7 || this.plansza[pierwsza][druga] == null) {
                System.out.println("Nie ma takiego pola na planszy podaj inne");
                sprawdz = false;
            } else if (!this.plansza[pierwsza][druga].pionek.equals("Brak")) {
                System.out.println("Pole zajete wybierz inne");
                sprawdz = false;
            } else {
                if (kolejnosc == 1) {
                    this.plansza[pierwsza][druga].pionek = "Bial";
                    this.plansza[pierwszaStara][drugaStara].pionek = "Brak";
                    zbicie(nowePole, kolejnosc);
                } else {
                    this.plansza[pierwsza][druga].pionek = "Czar";
                    this.plansza[pierwszaStara][drugaStara].pionek = "Brak";
                    zbicie(nowePole, kolejnosc);
                }
                sprawdz = true;
            }
            if (sprawdz == false) {
                nowePole = "fsfs";
                while (nowePole.length() != 2) {
                    nowePole = scan.nextLine();
                    if (nowePole.length() != 2) {
                        System.out.println("Nie ma takiego pola na planszy podaj inne");
                    }
                }
            }
        }
    }

    public void zbicieKomputer(String pole, int kolejnosc) {
        Random generator = new Random();
        String doUsunieciaPole = "fdf";
        if(this.iloscBiale > 2 && kolejnosc == 2 ) {
            int doUsunieciaIndeks = generator.nextInt(this.iloscBiale - 1) + 1;
            for (int i = 7; i > 0; i--) {
                for (int j = 1; j < 8; j++) {
                    if (this.plansza[i][j] != null && this.plansza[i][j].pionek == "Bial") {
                        doUsunieciaIndeks--;
                        if (doUsunieciaIndeks == 0) {
                            doUsunieciaPole = Integer.toString(i) + Integer.toString(j);
                        }
                    }
                }
            }
        }
        if(this.iloscCzarne > 2 && kolejnosc == 1 ) {
            int doUsunieciaIndeks = generator.nextInt(this.iloscCzarne - 1) + 1;
            for (int i = 7; i > 0; i--) {
                for (int j = 1; j < 8; j++) {
                    if (this.plansza[i][j] != null && this.plansza[i][j].pionek == "Czar") {
                        doUsunieciaIndeks--;
                        if (doUsunieciaIndeks == 0) {
                            doUsunieciaPole = Integer.toString(i) + Integer.toString(j);
                        }
                    }
                }
            }
        }
        int poleZbicia = Integer.parseInt(doUsunieciaPole);
        int poleLiczba = Integer.parseInt(pole);
        for (int i = 0; i < 16; i++) {
            for (int j = 0; j < 3; j++) {
                if (this.zbicie[i][j] == poleLiczba) {
                    int pierwsza = this.zbicie[i][0];
                    int druga = this.zbicie[i][1];
                    int trzecia = this.zbicie[i][2];
                    int pierwszaA = pierwsza / 10;
                    int pierwszaB = pierwsza % 10;
                    int drugaA = druga / 10;
                    int drugaB = druga % 10;
                    int trzeciaA = trzecia / 10;
                    int trzeciaB = trzecia % 10;
                    if (kolejnosc == 2 && ostatniMlynekCzarne != i && plansza[pierwszaA][pierwszaB].pionek.equals("Czar") && plansza[drugaA][drugaB].pionek.equals("Czar") && plansza[trzeciaA][trzeciaB].pionek.equals("Czar")) {
                        punkty++;
                        plansza[poleZbicia/10][poleZbicia%10].pionek = "Brak";
                        iloscBiale--;
                        ostatniMlynekCzarne = i;
                    }
                    if (kolejnosc == 1 && ostatniMlynekBiale != i && plansza[pierwszaA][pierwszaB].pionek.equals("Bial") && plansza[drugaA][drugaB].pionek.equals("Bial") && plansza[trzeciaA][trzeciaB].pionek.equals("Bial")) {
                        punkty++;
                        plansza[poleZbicia/10][poleZbicia%10].pionek = "Brak";
                        iloscCzarne--;
                        ostatniMlynekBiale = 1;
                    }
                }
            }
        }
    }

    public void zbicieSprawdz(String pole, int kolejnosc) {
        int poleLiczba = Integer.parseInt(pole);
        for (int i = 0; i < 16; i++) {
            for (int j = 0; j < 3; j++) {
                if (this.zbicie[i][j] == poleLiczba) {
                    int pierwsza = this.zbicie[i][0];
                    int druga = this.zbicie[i][1];
                    int trzecia = this.zbicie[i][2];
                    int pierwszaA = pierwsza / 10;
                    int pierwszaB = pierwsza % 10;
                    int drugaA = druga / 10;
                    int drugaB = druga % 10;
                    int trzeciaA = trzecia / 10;
                    int trzeciaB = trzecia % 10;
                    if (kolejnosc == 2 && ostatniMlynekBiale != i && plansza[pierwszaA][pierwszaB].pionek.equals("Bial") && plansza[drugaA][drugaB].pionek.equals("Bial") && plansza[trzeciaA][trzeciaB].pionek.equals("Bial")) {
                        punkty--;
                    }
                    if (kolejnosc == 1 && ostatniMlynekCzarne != i && plansza[pierwszaA][pierwszaB].pionek.equals("Czar") && plansza[drugaA][drugaB].pionek.equals("Czar") && plansza[trzeciaA][trzeciaB].pionek.equals("Czar")) {
                        punkty--;
                    }
                }
            }
        }
    }

    public void minMaxEtap1(int kolejnosc, String rodzaj) {
        Random generator = new Random();
        AtomicInteger ciecieAlfa = new  AtomicInteger(-10);
        Plansza pomocnicza = new Plansza();
        pomocnicza.iloscBiale = this.iloscBiale;
        pomocnicza.iloscCzarne = this.iloscCzarne;
        pomocnicza.ostatniMlynekCzarne = this.ostatniMlynekCzarne;
        pomocnicza.ostatniMlynekBiale = this.ostatniMlynekBiale;
        for (int i = 7; i > 0; i--) {
            for (int j = 1; j < 8; j++) {
                if (this.plansza[i][j] != null) {
                    pomocnicza.plansza[i][j].pionek = this.plansza[i][j].pionek;
                }
            }
        }
        Node<Plansza> korzen = new Node<Plansza>(null, pomocnicza);
        for (int i = 7; i > 0; i--) {
            for (int j = 1; j < 8; j++) {
                if (this.plansza[i][j] != null && this.plansza[i][j].pionek.equals("Brak")) {
                    Plansza dziecko = new Plansza();
                    if(kolejnosc == 2) {
                        dziecko.iloscBiale = this.iloscBiale;
                        dziecko.iloscCzarne = this.iloscCzarne + 1;
                    }
                    else
                    {
                        dziecko.iloscBiale = this.iloscBiale + 1;
                        dziecko.iloscCzarne = this.iloscCzarne;
                    }
                    dziecko.ostatniMlynekCzarne = this.ostatniMlynekCzarne;
                    dziecko.ostatniMlynekBiale = this.ostatniMlynekBiale;
                    for (int m = 7; m > 0; m--) {
                        for (int n = 1; n < 8; n++) {
                            if (this.plansza[m][n] != null) {
                                dziecko.plansza[m][n].pionek = this.plansza[m][n].pionek;
                            }
                        }
                    }
                    if(kolejnosc == 2) {
                        dziecko.plansza[i][j].pionek = "Czar";
                    }
                    else
                    {
                            dziecko.plansza[i][j].pionek = "Bial";
                    }
                    String nowePole = Integer.toString(i) + Integer.toString(j);
                    if(iloscBiale > 2 && kolejnosc == 2) {
                        dziecko.zbicieKomputer(nowePole, 2);
                    }
                    if(iloscCzarne> 2 && kolejnosc == 1) {
                        dziecko.zbicieKomputer( nowePole, 1);
                    }
                    Node<Plansza> dzieckoKorzenia = new Node<Plansza>(korzen, dziecko);
                    korzen.dodajDziecko(dzieckoKorzenia);
                }
            }
        }

        korzen.zwrocDzieci().forEach((potomek) -> {
            int i = 7;
            boolean sprawdzCiecie = true;
            while(i > 0 && sprawdzCiecie)
            {
                int j = 1;
                while(j < 8 && sprawdzCiecie)
                {
                    if (potomek.zwrocDane().plansza[i][j] != null && potomek.zwrocDane().plansza[i][j].pionek.equals("Brak")) {
                        Plansza dziecko = new Plansza();
                        if(kolejnosc == 2) {
                            dziecko.iloscBiale = potomek.zwrocDane().iloscBiale + 1;
                            dziecko.iloscCzarne = potomek.zwrocDane().iloscCzarne;
                        }
                        else
                        {
                            dziecko.iloscBiale = potomek.zwrocDane().iloscBiale;
                            dziecko.iloscCzarne = potomek.zwrocDane().iloscCzarne + 1;
                        }
                        dziecko.ostatniMlynekBiale = potomek.zwrocDane().ostatniMlynekBiale;
                        dziecko.ostatniMlynekCzarne = potomek.zwrocDane().ostatniMlynekCzarne;
                        dziecko.punkty = potomek.zwrocDane().punkty;
                        for (int m = 7; m > 0; m--) {
                            for (int n = 1; n < 8; n++) {
                                if (potomek.zwrocDane().plansza[m][n] != null) {
                                    dziecko.plansza[m][n].pionek = potomek.zwrocDane().plansza[m][n].pionek;
                                }
                            }
                        }
                        if(kolejnosc == 2) {
                            dziecko.plansza[i][j].pionek = "Bial";
                            String nowePole = Integer.toString(i) + Integer.toString(j);
                            dziecko.zbicieSprawdz(nowePole, 2);
                        }
                        else
                        {
                            dziecko.plansza[i][j].pionek = "Czar";
                            String nowePole = Integer.toString(i) + Integer.toString(j);
                            dziecko.zbicieSprawdz(nowePole, 1);
                        }
                        Node<Plansza> dzieckoMaksa = new Node<Plansza>(potomek, dziecko);
                        potomek.dodajDziecko(dzieckoMaksa);
                        if(rodzaj.equals("alphabeta") && dziecko.punkty < ciecieAlfa.get())
                        {
                            sprawdzCiecie = false;
                        }
                    }
                    j++;
                }
                i--;
            }
            int min = 10;
            for(int m = 0; m < potomek.zwrocDzieci().size(); m++)
            {
                if(min > potomek.zwrocDzieci().get(m).zwrocDane().punkty)
                {
                    min = potomek.zwrocDzieci().get(m).zwrocDane().punkty;
                }
            }
            potomek.zwrocDane().punkty = min;
            if(rodzaj.equals("alphabeta") && min > ciecieAlfa.get())
            {
                ciecieAlfa.set(min);
            }
        });

        /*korzen.zwrocDzieci().forEach((potomekMax) -> {
            AtomicInteger min = new AtomicInteger(10);
            potomekMax.zwrocDzieci().forEach((potemMin) -> {
                if(min.get() > potemMin.zwrocDane().punkty)
                {
                    min.set(potemMin.zwrocDane().punkty);
                }
            });
            potomekMax.zwrocDane().punkty = min.get();
        });*/
        int max = -10;
        Plansza ostatecznePole = new Plansza();
        for(int i = 0; i < korzen.zwrocDzieci().size(); i++)
        {
            if(max < korzen.zwrocDziecko(i).zwrocDane().punkty)
            {
                max = korzen.zwrocDziecko(i).zwrocDane().punkty;
            }
        }
        ArrayList<Plansza> maksymalnePunkty = new ArrayList<Plansza>();
        for(int i = 0; i < korzen.zwrocDzieci().size(); i++)
        {
            if(max == korzen.zwrocDziecko(i).zwrocDane().punkty)
            {
                maksymalnePunkty.add(korzen.zwrocDziecko(i).zwrocDane());
            }
        }
        int indeksOstatecznegoPola = generator.nextInt(maksymalnePunkty.size());
        ostatecznePole = maksymalnePunkty.get(indeksOstatecznegoPola);

        this.plansza = ostatecznePole.plansza;
        this.iloscCzarne = ostatecznePole.iloscCzarne;
        this.iloscBiale = ostatecznePole.iloscBiale;
        this.ostatniMlynekCzarne = ostatecznePole.ostatniMlynekCzarne;
        this.ostatniMlynekBiale = ostatecznePole.ostatniMlynekCzarne;
    }

    public void minMaxEtap2(int kolejnosc, String rodzaj) {
        Random generator = new Random();
        AtomicInteger ciecieAlfa = new  AtomicInteger(-10);
        Plansza pomocnicza = new Plansza();
        pomocnicza.iloscBiale = this.iloscBiale;
        pomocnicza.iloscCzarne = this.iloscCzarne;
        pomocnicza.ostatniMlynekCzarne = this.ostatniMlynekCzarne;
        pomocnicza.ostatniMlynekBiale = this.ostatniMlynekBiale;
        for (int i = 7; i > 0; i--) {
            for (int j = 1; j < 8; j++) {
                if (this.plansza[i][j] != null) {
                    pomocnicza.plansza[i][j].pionek = this.plansza[i][j].pionek;
                }
            }
        }
        Node<Plansza> korzen = new Node<Plansza>(null, pomocnicza);
        for (int i = 7; i > 0; i--) {
            for (int j = 1; j < 8; j++) {
                if (this.plansza[i][j] != null && this.plansza[i][j].pionek.equals("Czar") && kolejnosc == 2) {
                    for(int k = 0; k < this.plansza[i][j].sasiedzi.size(); k++)
                    {
                        if(this.plansza[this.plansza[i][j].sasiedzi.get(k)/10][this.plansza[i][j].sasiedzi.get(k)%10].pionek.equals("Brak"))
                        {
                            Plansza dziecko = new Plansza();
                            dziecko.iloscBiale = this.iloscBiale;
                            dziecko.iloscCzarne = this.iloscCzarne ;
                            dziecko.ostatniMlynekCzarne = this.ostatniMlynekCzarne;
                            dziecko.ostatniMlynekBiale = this.ostatniMlynekBiale;
                            for (int m = 7; m > 0; m--) {
                                for (int n = 1; n < 8; n++) {
                                    if (this.plansza[m][n] != null) {
                                        dziecko.plansza[m][n].pionek = this.plansza[m][n].pionek;
                                    }
                                }
                            }
                            dziecko.plansza[i][j].pionek = "Brak";
                            dziecko.plansza[(this.plansza[i][j].sasiedzi.get(k))/10][(this.plansza[i][j].sasiedzi.get(k))%10].pionek = "Czar";
                            String nowePole = Integer.toString(this.plansza[i][j].sasiedzi.get(k)/10) + Integer.toString(this.plansza[i][j].sasiedzi.get(k)%10);
                            if(iloscBiale > 2) {
                                dziecko.zbicieKomputer(nowePole, 2);
                            }
                            Node<Plansza> dzieckoKorzenia = new Node<Plansza>(korzen, dziecko);
                            korzen.dodajDziecko(dzieckoKorzenia);
                        }
                    }

                }

                if (this.plansza[i][j] != null && this.plansza[i][j].pionek.equals("Bial") && kolejnosc == 1) {
                    for(int k = 0; k < this.plansza[i][j].sasiedzi.size(); k++)
                    {
                        if(this.plansza[this.plansza[i][j].sasiedzi.get(k)/10][this.plansza[i][j].sasiedzi.get(k)%10].pionek.equals("Brak"))
                        {
                            Plansza dziecko = new Plansza();
                            dziecko.iloscBiale = this.iloscBiale;
                            dziecko.iloscCzarne = this.iloscCzarne ;
                            dziecko.ostatniMlynekCzarne = this.ostatniMlynekCzarne;
                            dziecko.ostatniMlynekBiale = this.ostatniMlynekBiale;
                            for (int m = 7; m > 0; m--) {
                                for (int n = 1; n < 8; n++) {
                                    if (this.plansza[m][n] != null) {
                                        dziecko.plansza[m][n].pionek = this.plansza[m][n].pionek;
                                    }
                                }
                            }
                            dziecko.plansza[i][j].pionek = "Brak";
                            dziecko.plansza[this.plansza[i][j].sasiedzi.get(k)/10][this.plansza[i][j].sasiedzi.get(k)%10].pionek = "Bial";
                            String nowePole = Integer.toString(this.plansza[i][j].sasiedzi.get(k)/10) + Integer.toString(this.plansza[i][j].sasiedzi.get(k)%10);
                            if(iloscCzarne > 2) {
                                dziecko.zbicieKomputer(nowePole, 1);
                            }
                            Node<Plansza> dzieckoKorzenia = new Node<Plansza>(korzen, dziecko);
                            korzen.dodajDziecko(dzieckoKorzenia);
                        }
                    }

                }
            }
        }
        korzen.zwrocDzieci().forEach((potomek) -> {
            int i = 7;
            boolean sprawdzCiecie = true;
            while(i > 0 && sprawdzCiecie)
            {
                int j = 1;
                while(j < 8 && sprawdzCiecie)
                {
                    if (potomek.zwrocDane().plansza[i][j] != null && potomek.zwrocDane().plansza[i][j].pionek.equals("Bial") && kolejnosc == 2) {
                        int k = 0;
                        while(k < potomek.zwrocDane().plansza[i][j].sasiedzi.size() && sprawdzCiecie)
                        {
                            if(potomek.zwrocDane().plansza[potomek.zwrocDane().plansza[i][j].sasiedzi.get(k)/10][potomek.zwrocDane().plansza[i][j].sasiedzi.get(k)%10].pionek.equals("Brak"))
                            {
                                Plansza dziecko = new Plansza();
                                dziecko.iloscBiale = potomek.zwrocDane().iloscBiale;
                                dziecko.iloscCzarne = potomek.zwrocDane().iloscCzarne ;
                                dziecko.ostatniMlynekCzarne = potomek.zwrocDane().ostatniMlynekCzarne;
                                dziecko.ostatniMlynekBiale = potomek.zwrocDane().ostatniMlynekBiale;
                                dziecko.punkty = potomek.zwrocDane().punkty;
                                for (int m = 7; m > 0; m--) {
                                    for (int n = 1; n < 8; n++) {
                                        if (potomek.zwrocDane().plansza[m][n] != null) {
                                            dziecko.plansza[m][n].pionek = potomek.zwrocDane().plansza[m][n].pionek;
                                        }
                                    }
                                }
                                dziecko.plansza[i][j].pionek = "Brak";
                                dziecko.plansza[potomek.zwrocDane().plansza[i][j].sasiedzi.get(k)/10][potomek.zwrocDane().plansza[i][j].sasiedzi.get(k)%10].pionek = "Bial";
                                String nowePole = Integer.toString(this.plansza[i][j].sasiedzi.get(k)/10) + Integer.toString(this.plansza[i][j].sasiedzi.get(k)%10);
                                dziecko.zbicieSprawdz(nowePole, 2);
                                Node<Plansza> dzieckoMaksa = new Node<Plansza>(potomek, dziecko);
                                potomek.dodajDziecko(dzieckoMaksa);
                                if(rodzaj.equals("alphabeta") && dziecko.punkty < ciecieAlfa.get())
                                {
                                    sprawdzCiecie = false;
                                }
                            }
                            k++;
                        }


                    }

                    if (potomek.zwrocDane().plansza[i][j] != null && potomek.zwrocDane().plansza[i][j].pionek.equals("Czar") && kolejnosc == 1) {
                        int k = 0;
                        while(k < potomek.zwrocDane().plansza[i][j].sasiedzi.size() && sprawdzCiecie)
                        {
                            if(potomek.zwrocDane().plansza[potomek.zwrocDane().plansza[i][j].sasiedzi.get(k)/10][potomek.zwrocDane().plansza[i][j].sasiedzi.get(k)%10].pionek.equals("Brak"))
                            {
                                Plansza dziecko = new Plansza();
                                dziecko.iloscBiale = potomek.zwrocDane().iloscBiale;
                                dziecko.iloscCzarne = potomek.zwrocDane().iloscCzarne ;
                                dziecko.ostatniMlynekCzarne = potomek.zwrocDane().ostatniMlynekCzarne;
                                dziecko.ostatniMlynekBiale = potomek.zwrocDane().ostatniMlynekBiale;
                                dziecko.punkty = potomek.zwrocDane().punkty;
                                for (int m = 7; m > 0; m--) {
                                    for (int n = 1; n < 8; n++) {
                                        if (potomek.zwrocDane().plansza[m][n] != null) {
                                            dziecko.plansza[m][n].pionek = potomek.zwrocDane().plansza[m][n].pionek;
                                        }
                                    }
                                }
                                dziecko.plansza[i][j].pionek = "Brak";
                                dziecko.plansza[potomek.zwrocDane().plansza[i][j].sasiedzi.get(k)/10][potomek.zwrocDane().plansza[i][j].sasiedzi.get(k)%10].pionek = "Czar";
                                String nowePole = Integer.toString(this.plansza[i][j].sasiedzi.get(k)/10) + Integer.toString(this.plansza[i][j].sasiedzi.get(k)%10);
                                dziecko.zbicieSprawdz(nowePole, 1);
                                Node<Plansza> dzieckoMaksa = new Node<Plansza>(potomek, dziecko);
                                potomek.dodajDziecko(dzieckoMaksa);
                                if(rodzaj.equals("alphabeta") && dziecko.punkty < ciecieAlfa.get())
                                {
                                    sprawdzCiecie = false;
                                }
                            }
                            k++;
                        }


                    }
                    j++;
                }
                i--;
            }
            int min = 10;
            for(int m = 0; m < potomek.zwrocDzieci().size(); m++)
            {
                if(min > potomek.zwrocDzieci().get(m).zwrocDane().punkty)
                {
                    min = potomek.zwrocDzieci().get(m).zwrocDane().punkty;
                }
            }
            potomek.zwrocDane().punkty = min;
            if(rodzaj.equals("alphabeta") && min > ciecieAlfa.get())
            {
                ciecieAlfa.set(min);
            }
        });
        ArrayList<Plansza> maksymalnePunkty = new ArrayList<Plansza>();
        /*korzen.zwrocDzieci().forEach((potomekMax) -> {
            AtomicInteger min = new AtomicInteger(10);
            potomekMax.zwrocDzieci().forEach((potemMin) -> {
                if(min.get() > potemMin.zwrocDane().punkty)
                {
                    min.set(potemMin.zwrocDane().punkty);
                }
            });
            potomekMax.zwrocDane().punkty = min.get();
        });*/
        int max = -10;
        Plansza ostatecznePole = new Plansza();
        for(int i = 0; i < korzen.zwrocDzieci().size(); i++)
        {
            if(max < korzen.zwrocDziecko(i).zwrocDane().punkty)
            {
                max = korzen.zwrocDziecko(i).zwrocDane().punkty;
            }
        }
        for(int i = 0; i < korzen.zwrocDzieci().size(); i++)
        {
            if(max == korzen.zwrocDziecko(i).zwrocDane().punkty)
            {
                maksymalnePunkty.add(korzen.zwrocDziecko(i).zwrocDane());
            }
        }
        int indeksOstatecznegoPola = generator.nextInt(maksymalnePunkty.size());
        ostatecznePole = maksymalnePunkty.get(indeksOstatecznegoPola);
        this.plansza = ostatecznePole.plansza;
        this.iloscCzarne = ostatecznePole.iloscCzarne;
        this.iloscBiale = ostatecznePole.iloscBiale;
        this.ostatniMlynekCzarne = ostatecznePole.ostatniMlynekCzarne;
        this.ostatniMlynekBiale = ostatecznePole.ostatniMlynekCzarne;
    }

    public void minMaxEtap3(int kolejnosc, String rodzaj) {
        Random generator = new Random();
        AtomicInteger ciecieAlfa = new  AtomicInteger(-10);
        Plansza pomocnicza = new Plansza();
        pomocnicza.iloscBiale = this.iloscBiale;
        pomocnicza.iloscCzarne = this.iloscCzarne;
        pomocnicza.ostatniMlynekCzarne = this.ostatniMlynekCzarne;
        pomocnicza.ostatniMlynekBiale = this.ostatniMlynekBiale;
        for (int i = 7; i > 0; i--) {
            for (int j = 1; j < 8; j++) {
                if (this.plansza[i][j] != null) {
                    pomocnicza.plansza[i][j].pionek = this.plansza[i][j].pionek;
                }
            }
        }
        Node<Plansza> korzen = new Node<Plansza>(null, pomocnicza);
        for (int i = 7; i > 0; i--) {
            for (int j = 1; j < 8; j++) {
                if (this.plansza[i][j] != null && this.plansza[i][j].pionek.equals("Czar") && kolejnosc == 2) {
                    for (int k = 7; k > 0; k--) {
                        for (int l = 1; l < 8; l++) {
                            if (this.plansza[k][l] != null && this.plansza[k][l].pionek.equals("Brak")) {
                                Plansza dziecko = new Plansza();
                                dziecko.iloscBiale = this.iloscBiale;
                                dziecko.iloscCzarne = this.iloscCzarne;
                                dziecko.ostatniMlynekCzarne = this.ostatniMlynekCzarne;
                                dziecko.ostatniMlynekBiale = this.ostatniMlynekBiale;
                                for (int m = 7; m > 0; m--) {
                                    for (int n = 1; n < 8; n++) {
                                        if (this.plansza[m][n] != null) {
                                            dziecko.plansza[m][n].pionek = this.plansza[m][n].pionek;
                                        }
                                    }
                                }
                                dziecko.plansza[i][j].pionek = "Brak";
                                dziecko.plansza[k][l].pionek = "Czar";
                                String nowePole = Integer.toString(k) + Integer.toString(l);
                                if (iloscBiale > 2) {
                                    dziecko.zbicieKomputer(nowePole, 2);
                                }
                                Node<Plansza> dzieckoKorzenia = new Node<Plansza>(korzen, dziecko);
                                korzen.dodajDziecko(dzieckoKorzenia);
                            }
                        }
                    }

                }

                if (this.plansza[i][j] != null && this.plansza[i][j].pionek.equals("Bial") && kolejnosc == 1) {
                    for (int k = 7; k > 0; k--) {
                        for (int l = 1; l < 8; l++) {
                            if (this.plansza[k][l] != null && this.plansza[k][l].pionek.equals("Brak")) {
                                Plansza dziecko = new Plansza();
                                dziecko.iloscBiale = this.iloscBiale;
                                dziecko.iloscCzarne = this.iloscCzarne;
                                dziecko.ostatniMlynekCzarne = this.ostatniMlynekCzarne;
                                dziecko.ostatniMlynekBiale = this.ostatniMlynekBiale;
                                for (int m = 7; m > 0; m--) {
                                    for (int n = 1; n < 8; n++) {
                                        if (this.plansza[m][n] != null) {
                                            dziecko.plansza[m][n].pionek = this.plansza[m][n].pionek;
                                        }
                                    }
                                }
                                dziecko.plansza[i][j].pionek = "Brak";
                                dziecko.plansza[k][l].pionek = "Bial";
                                String nowePole = Integer.toString(k) + Integer.toString(l);
                                if (iloscBiale > 2) {
                                    dziecko.zbicieKomputer(nowePole, 1);
                                }
                                Node<Plansza> dzieckoKorzenia = new Node<Plansza>(korzen, dziecko);
                                korzen.dodajDziecko(dzieckoKorzenia);
                            }
                        }
                    }
                }
            }
        }

        korzen.zwrocDzieci().forEach((potomek) -> {
            int i = 7;
            boolean sprawdzCiecie = true;
            while(i > 0 && sprawdzCiecie)
            {
                int j = 1;
                while(j < 8 && sprawdzCiecie)
                {
                    if (potomek.zwrocDane().plansza[i][j] != null && potomek.zwrocDane().plansza[i][j].pionek.equals("Bial") && kolejnosc == 2) {
                        int k = 7;
                        while(k > 0 && sprawdzCiecie)
                        {
                            int l = 1;
                            while(l < 8 && sprawdzCiecie)
                            {
                                if (potomek.zwrocDane().plansza[k][l] != null && potomek.zwrocDane().plansza[k][l].pionek.equals("Brak")) {
                                    Plansza dziecko = new Plansza();
                                    dziecko.iloscBiale = potomek.zwrocDane().iloscBiale;
                                    dziecko.iloscCzarne = potomek.zwrocDane().iloscCzarne;
                                    dziecko.ostatniMlynekCzarne = potomek.zwrocDane().ostatniMlynekCzarne;
                                    dziecko.ostatniMlynekBiale = potomek.zwrocDane().ostatniMlynekBiale;
                                    dziecko.punkty = potomek.zwrocDane().punkty;
                                    for (int m = 7; m > 0; m--) {
                                        for (int n = 1; n < 8; n++) {
                                            if (potomek.zwrocDane().plansza[m][n] != null) {
                                                dziecko.plansza[m][n].pionek = potomek.zwrocDane().plansza[m][n].pionek;
                                            }
                                        }
                                    }
                                    dziecko.plansza[i][j].pionek = "Brak";
                                    dziecko.plansza[k][l].pionek = "Bial";
                                    String nowePole = Integer.toString(k) + Integer.toString(l);
                                    dziecko.zbicieSprawdz(nowePole, 2);
                                    Node<Plansza> dzieckoMaksa = new Node<Plansza>(potomek, dziecko);
                                    potomek.dodajDziecko(dzieckoMaksa);
                                    if(rodzaj.equals("alphabeta") && dziecko.punkty < ciecieAlfa.get())
                                    {
                                        sprawdzCiecie = false;
                                    }
                                }
                                l++;
                            }
                            k--;
                        }

                    }

                    if (potomek.zwrocDane().plansza[i][j] != null && potomek.zwrocDane().plansza[i][j].pionek.equals("Czar") && kolejnosc == 1) {
                        int k = 7;
                        while(k > 0 && sprawdzCiecie)
                        {
                            int l = 1;
                            while(l < 8 && sprawdzCiecie)
                            {
                                if (potomek.zwrocDane().plansza[k][l] != null && potomek.zwrocDane().plansza[k][l].pionek.equals("Brak")) {
                                    Plansza dziecko = new Plansza();
                                    dziecko.iloscBiale = potomek.zwrocDane().iloscBiale;
                                    dziecko.iloscCzarne = potomek.zwrocDane().iloscCzarne;
                                    dziecko.ostatniMlynekCzarne = potomek.zwrocDane().ostatniMlynekCzarne;
                                    dziecko.ostatniMlynekBiale = potomek.zwrocDane().ostatniMlynekBiale;
                                    dziecko.punkty = potomek.zwrocDane().punkty;
                                    for (int m = 7; m > 0; m--) {
                                        for (int n = 1; n < 8; n++) {
                                            if (potomek.zwrocDane().plansza[m][n] != null) {
                                                dziecko.plansza[m][n].pionek = potomek.zwrocDane().plansza[m][n].pionek;
                                            }
                                        }
                                    }
                                    dziecko.plansza[i][j].pionek = "Brak";
                                    dziecko.plansza[k][l].pionek = "Czar";
                                    String nowePole = Integer.toString(k) + Integer.toString(l);
                                    dziecko.zbicieSprawdz(nowePole, 1);
                                    Node<Plansza> dzieckoMaksa = new Node<Plansza>(potomek, dziecko);
                                    potomek.dodajDziecko(dzieckoMaksa);
                                    if(rodzaj.equals("alphabeta") && dziecko.punkty < ciecieAlfa.get())
                                    {
                                        sprawdzCiecie = false;
                                    }
                                }
                                l++;
                            }
                            k--;
                        }
                    }
                    j++;
                }
                i--;
            }
            int min = 10;
            for(int m = 0; m < potomek.zwrocDzieci().size(); m++)
            {
                if(min > potomek.zwrocDzieci().get(m).zwrocDane().punkty)
                {
                    min = potomek.zwrocDzieci().get(m).zwrocDane().punkty;
                }
            }
            potomek.zwrocDane().punkty = min;
            if(rodzaj.equals("alphabeta") && min > ciecieAlfa.get())
            {
                ciecieAlfa.set(min);
            }
        });
        ArrayList<Plansza> maksymalnePunkty = new ArrayList<Plansza>();
        /*korzen.zwrocDzieci().forEach((potomekMax) -> {
            AtomicInteger min = new AtomicInteger(10);
            potomekMax.zwrocDzieci().forEach((potemMin) -> {
                if(min.get() > potemMin.zwrocDane().punkty)
                {
                    min.set(potemMin.zwrocDane().punkty);
                }
            });
            potomekMax.zwrocDane().punkty = min.get();
        });*/
        int max = -10;
        Plansza ostatecznePole = new Plansza();
        for(int i = 0; i < korzen.zwrocDzieci().size(); i++)
        {
            if(max < korzen.zwrocDziecko(i).zwrocDane().punkty)
            {
                max = korzen.zwrocDziecko(i).zwrocDane().punkty;
            }
        }
        for(int i = 0; i < korzen.zwrocDzieci().size(); i++)
        {
            if(max == korzen.zwrocDziecko(i).zwrocDane().punkty)
            {
                maksymalnePunkty.add(korzen.zwrocDziecko(i).zwrocDane());
            }
        }
        int indeksOstatecznegoPola = generator.nextInt(maksymalnePunkty.size());
        ostatecznePole = maksymalnePunkty.get(indeksOstatecznegoPola);
        this.plansza = ostatecznePole.plansza;
        this.iloscCzarne = ostatecznePole.iloscCzarne;
        this.iloscBiale = ostatecznePole.iloscBiale;
        this.ostatniMlynekCzarne = ostatecznePole.ostatniMlynekCzarne;
        this.ostatniMlynekBiale = ostatecznePole.ostatniMlynekCzarne;
    }
}
