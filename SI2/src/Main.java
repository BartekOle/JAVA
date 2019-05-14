import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
   /* private static int plansza [][];
    private static int rozmiar;
    private static List<String> wiezy1 = new ArrayList<String>();
    private static List<String> wiezy2 = new ArrayList<String>();*/
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
        PlanszaSky rozwiazanie2 = new PlanszaSky();
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
        }
       /* wczytanieDanychFuto();
        for(int i =1; i < rozmiar+1; i++)
        {
            for(int j = 1; j < rozmiar+1; j++)
            {
                System.out.print(plansza[j][i]);
            }
            System.out.println();
        }
        wczytanieDanychSky();
        for(int i =0; i < 4; i++)
        {
            for(int j = 1; j < rozmiar+1; j++)
            {
                System.out.print(plansza[j][i]);
            }
            System.out.println();
        }
    }

    public static void wczytanieDanychFuto() throws IOException
    {
        String fileName = "C:\\Users\\dios1\\IdeaProjects\\SI2\\src\\test_futo_4_0.txt";
        File file = new File(fileName);
        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);
        String line;
        line = br.readLine();
        rozmiar = Integer.parseInt(line);
        plansza = new int[rozmiar+1][rozmiar+1];
        String[] split;
        br.readLine();
        for(int i = 1; i < rozmiar+1; i++)
        {
            line = br.readLine();
            split = line.split(";");
            for(int j =1; j < rozmiar+1; j++)
            {
                plansza[j][i] = Integer.parseInt(split[j-1]);
            }
        }
        br.readLine();
        line = br.readLine();
        do {
            split = line.split(";");
            wiezy1.add(split[1]);
            wiezy2.add(split[1]);

            line = br.readLine();
        } while(line != null);
        br.close();
    }

    public static void wczytanieDanychSky() throws IOException
    {
        String fileName = "C:\\Users\\dios1\\IdeaProjects\\SI2\\src\\test_sky_4_0.txt";
        File file = new File(fileName);
        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);
        String line;
        line = br.readLine();
        rozmiar = Integer.parseInt(line);
        plansza = new int[rozmiar+1][4];
        String[] split;
        for(int i = 0; i < 4; i++)
        {
            line = br.readLine();
            split = line.split(";");
            for(int j =1; j < rozmiar+1; j++)
            {
                plansza[j][i] = Integer.parseInt(split[j]);
            }
        }*/
    }
    }
