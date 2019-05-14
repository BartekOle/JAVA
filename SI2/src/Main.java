import java.io.*;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;


public class Main {
    public static void main(String[] args) throws IOException {
        PlanszaFuto rozwiazanie = new PlanszaFuto();
        rozwiazanie.wczytanieDanychFuto();
        for (int i = 1; i < rozwiazanie.rozmiar + 1; i++) {
            for (int j = 1; j < rozwiazanie.rozmiar + 1; j++) {
                System.out.print(rozwiazanie.plansza[i][j].wartosc);
            }
            System.out.println();
        }
        for (int i = 1; i < rozwiazanie.rozmiar + 1; i++) {
            for (int j = 1; j < rozwiazanie.rozmiar + 1; j++) {
                if (!rozwiazanie.plansza[i][j].mniejsze.isEmpty()) {
                    for (PoleFuto F : rozwiazanie.plansza[i][j].mniejsze) {
                        System.out.println("Pole: " + rozwiazanie.plansza[i][j].nrPola + " Musi byc mniejsze od pola: " + F.nrPola);
                    }
                }
                if (!rozwiazanie.plansza[i][j].wieksze.isEmpty()) {
                    for (PoleFuto F : rozwiazanie.plansza[i][j].wieksze) {
                        System.out.println("Pole: " + rozwiazanie.plansza[i][j].nrPola + " Musi byc wieksze od pola: " + F.nrPola);
                    }
                }
            }
            System.out.println();
        }
        System.out.println("Czas rozpoczecia: algorytmu: " + LocalDateTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss.SSS")));
        System.out.println(rozwiazanie.sprawdzanieWprzod());
        System.out.println("Czas zakonczzenia algorytmu: " + LocalDateTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss.SSS")));
        String wynik = "<div id=\"board\" style=\"margin:0px auto;text-align:center\" class=\"no-text-selection\"><table border=\"0\" cellpadding=\"3\" style=\"margin:15px auto;text-align:center\" id=\"boardTable\"><tbody>";
        PrintWriter zapis = new PrintWriter("rozwiazanieFuto.html");
        for (int i = 1; i < rozwiazanie.rozmiar + 1; i++) {
            wynik += "<tr>";
            for (int j = 1; j < rozwiazanie.rozmiar + 1; j++) {
                wynik += "<td style=\"border: 1px solid rgb(128, 128, 128); font-size: 32px; background-color: rgb(255, 255, 255); color: black;\">" + rozwiazanie.plansza[i][j].wartosc + "</td>";
                if (j != rozwiazanie.rozmiar) {
                    String strzalka = "nic";

                    for (PoleFuto F : rozwiazanie.plansza[i][j].wieksze) {
                        if (rozwiazanie.plansza[i][j].numerWKolejnosci + 1 == F.numerWKolejnosci) {
                            strzalka = "prawo";
                        }
                    }
                    for (PoleFuto F : rozwiazanie.plansza[i][j].mniejsze) {
                        if (rozwiazanie.plansza[i][j].numerWKolejnosci + 1 == F.numerWKolejnosci) {
                            strzalka = "lewo";
                        }
                    }
                    wynik += "<td><img src=\"" + strzalka + ".gif\"></td>";

                }
                System.out.print(rozwiazanie.plansza[i][j].wartosc);
            }
            wynik += "</tr>";
            if (i != rozwiazanie.rozmiar) {
                wynik += "<tr>";
                for (int j = 1; j < rozwiazanie.rozmiar + 1; j++) {
                    String strzalka = "nic";
                    for (PoleFuto F : rozwiazanie.plansza[i][j].wieksze) {
                        if (rozwiazanie.plansza[i][j].nrPola + 10 == F.nrPola) {
                            strzalka = "dol";
                        }
                    }
                    for (PoleFuto F : rozwiazanie.plansza[i][j].mniejsze) {
                        if (rozwiazanie.plansza[i][j].nrPola + 10 == F.nrPola) {
                            strzalka = "gora";
                        }
                    }

                    wynik += "<td><img src=\"" + strzalka + ".gif\"></td><td></td>";
                }
                wynik += "</tr>";
            }
            System.out.println();
        }
        wynik += "</tbody></table></div>";
        System.out.println("Liczba iteracji w glownej petli: " + rozwiazanie.liczbaIteracji);
        zapis.println(wynik);
        zapis.close();

        PlanszaSky rozwiazanie2 = new PlanszaSky();
        rozwiazanie2.wczytanieDanychSky();
        for (int i = 1; i < rozwiazanie2.rozmiar + 1; i++) {
            for (int j = 1; j < rozwiazanie2.rozmiar + 1; j++) {
                System.out.print(rozwiazanie2.plansza[i][j].wartosc);
            }
            System.out.println();
        }
        for (int i = 0; i < 2; i++) {
            for (int j = 1; j < rozwiazanie2.rozmiar + 1; j++) {
                System.out.print(rozwiazanie2.goraDol[i][j]);
            }
            System.out.println();
        }
        for (int i = 1; i < rozwiazanie2.rozmiar + 1; i++) {
            for (int j = 0; j < 2; j++) {
                System.out.print(rozwiazanie2.lewaPrawa[i][j]);
            }
            System.out.println();
        }

        System.out.println("Czas rozpoczecia: algorytmu: " + LocalDateTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss.SSS")));
        System.out.println(rozwiazanie2.sprawdzanieWprzod());
        System.out.println("Czas zakonczzenia algorytmu: " + LocalDateTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss.SSS")));
        String wynik2 = "<div id=\"board\" style=\"margin:0px auto;text-align:center\" class=\"no-text-selection\"><table border=\"0\" cellpadding=\"3\" style=\"margin:15px auto;text-align:center\" id=\"boardTable\"><tbody>";
        PrintWriter zapis2 = new PrintWriter("rozwiazanieSky.html");
        wynik2 += "<tr>";
        for(int i = 1; i < rozwiazanie2.rozmiar + 1; i++)
        {
            if(i == 1)
            {
                wynik2 += "<td></td><td><img src=\"nic.gif\"></td>";
            }
            wynik2 += "<td style=\"border: 1px solid rgb(128, 128, 128); font-size: 32px; background-color: rgb(255, 255, 255); color: red;\">" + rozwiazanie2.goraDol[0][i] + "</td>";
            if (i != rozwiazanie2.rozmiar) {
                wynik2 += "<td><img src=\"nic.gif\"></td>";
            }
        }
        wynik2 += "</tr>";
        wynik2 += "<tr>";
        for(int i = 1; i < rozwiazanie2.rozmiar + 1; i++)
        {
            if(i == 1)
            {
                wynik2 += "<td></td><td><img src=\"nic.gif\"></td>";
            }
            wynik2 += "<td><img src=\"dol.gif\"></td><td></td>";
        }
        wynik2 += "</tr>";
        for (int i = 1; i < rozwiazanie2.rozmiar + 1; i++) {
            wynik2 += "<tr>";
            for (int j = 1; j < rozwiazanie2.rozmiar + 1; j++) {
                if(j == 1)
                {
                    wynik2 += "<td style=\"border: 1px solid rgb(128, 128, 128); font-size: 32px; background-color: rgb(255, 255, 255); color: red;\">" + rozwiazanie2.lewaPrawa[i][0] + "</td>" + "<td><img src=\"prawo.gif\"></td>";
                }
                wynik2 += "<td style=\"border: 1px solid rgb(128, 128, 128); font-size: 32px; background-color: rgb(255, 255, 255); color: black;\">" + rozwiazanie2.plansza[i][j].wartosc + "</td>";
                System.out.print(rozwiazanie2.plansza[i][j].wartosc);
                if (j != rozwiazanie2.rozmiar) {
                    wynik2 += "<td><img src=\"nic.gif\"></td>";
                }
                else
                {
                    wynik2 += "<td><img src=\"lewo.gif\"></td>" + "<td style=\"border: 1px solid rgb(128, 128, 128); font-size: 32px; background-color: rgb(255, 255, 255); color: red;\">" + rozwiazanie2.lewaPrawa[i][1] + "</td>";
                }
            }
            wynik2 += "</tr>";
            if (i != rozwiazanie2.rozmiar) {
                wynik += "<tr>";
                for (int j = 1; j < rozwiazanie.rozmiar + 1; j++) {

                    wynik2 += "<td><img src=\"nic.gif\"></td><td></td>";
                }
                wynik2 += "</tr>";
            }

            System.out.println();
        }
        wynik2 += "<tr>";
        for(int i = 1; i < rozwiazanie2.rozmiar + 1; i++)
        {
            if(i == 1)
            {
                wynik2 += "<td></td><td><img src=\"nic.gif\"></td>";
            }
            wynik2 += "<td><img src=\"gora.gif\"></td><td></td>";
        }
        wynik2 += "</tr>";
        wynik2 += "<tr>";
        for(int i = 1; i < rozwiazanie2.rozmiar + 1; i++)
        {
            if(i == 1)
            {
                wynik2 += "<td></td><td><img src=\"nic.gif\"></td>";
            }
            wynik2 += "<td style=\"border: 1px solid rgb(128, 128, 128); font-size: 32px; background-color: rgb(255, 255, 255); color: red;\">" + rozwiazanie2.goraDol[1][i] + "</td>";
            if (i != rozwiazanie2.rozmiar) {
                wynik2 += "<td><img src=\"nic.gif\"></td>";
            }
        }
        wynik2 += "</tr>";

        System.out.println("Liczba iteracji w glownej petli: " + rozwiazanie2.liczbaIteracji);
        wynik2 += "</tbody></table></div>";
        zapis2.println(wynik2);
        zapis2.close();
    }

}
