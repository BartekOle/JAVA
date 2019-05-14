import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        PlanszaFuto rozwiazanie = new PlanszaFuto();
        rozwiazanie.wczytanieDanychFuto();
        for(int i =1; i < rozwiazanie.rozmiar+1; i++)
        {
            for(int j = 1; j < rozwiazanie.rozmiar+1; j++)
            {
                System.out.print(rozwiazanie.plansza[i][j].wartosc);
            }
            System.out.println();
        }
        for(int i =1; i < rozwiazanie.rozmiar+1; i++)
        {
            for(int j = 1; j < rozwiazanie.rozmiar+1; j++)
            {
                if(!rozwiazanie.plansza[i][j].mniejsze.isEmpty())
                {
                    for(PoleFuto F: rozwiazanie.plansza[i][j].mniejsze)
                    {
                        System.out.println("Pole: " + rozwiazanie.plansza[i][j].nrPola + " Musi byc mniejsze od pola: " + F.nrPola);
                    }
                }
                if(!rozwiazanie.plansza[i][j].wieksze.isEmpty())
                {
                    for(PoleFuto F: rozwiazanie.plansza[i][j].wieksze)
                    {
                        System.out.println("Pole: " + rozwiazanie.plansza[i][j].nrPola + " Musi byc wieksze od pola: " + F.nrPola);
                    }
                }
            }
            System.out.println();
        }
        System.out.println(rozwiazanie.sprawdzanieWprzod());
        for(int i =1; i < rozwiazanie.rozmiar+1; i++)
        {
            for(int j = 1; j < rozwiazanie.rozmiar+1; j++)
            {
                System.out.print(rozwiazanie.plansza[i][j].wartosc);
            }
            System.out.println();
        }
        /*PlanszaSky rozwiazanie2 = new PlanszaSky();
        rozwiazanie2.wczytanieDanychSky();
        for(int i =1; i < rozwiazanie2.rozmiar+1; i++)
        {
            for(int j = 1; j < rozwiazanie2.rozmiar+1; j++)
            {
                System.out.print(rozwiazanie2.plansza[i][j].wartosc);
            }
            System.out.println();
        }
        for (int i = 0; i < 2; i++) {
            for (int j = 1; j < rozwiazanie2.rozmiar + 1; j++) {
                System.out.print(rozwiazanie2.GoraDol[i][j]);
            }
            System.out.println();
        }
        for (int i = 1; i < rozwiazanie2.rozmiar + 1; i++) {
            for (int j = 0; j < 2; j++) {
                System.out.print(rozwiazanie2.LewaPrawa[i][j]);
            }
            System.out.println();
        }*/

    }
}
