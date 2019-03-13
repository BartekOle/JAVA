import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collections;

public class Main {
        static int  dimension;
        static int numberOfItems;
        static int capacityOfKnapsack;
        static double minSpeed;
        static double maxSpeed;
        static double rentingRatio;
        static Miasto [] spisMiast;
        static Przedmiot [] spisPrzedmiotow;
    public static void main(String[] args) throws IOException {

            wczytanieDanych();
        for(int i = 0; i < dimension; i++)
        {
            System.out.println(spisMiast[i+1].toString());
        }
        for(int i = 0; i < numberOfItems; i++)
        {
            System.out.println(spisPrzedmiotow[i+1].toString());
        }
        Osobnik zlodziej = new Osobnik(capacityOfKnapsack, maxSpeed, minSpeed);
        zlodziej.chromoson(dimension);
        for(int i = 0; i < zlodziej.trasa.length; i++) {
            System.out.print(zlodziej.trasa[i] + " ");
        }
        System.out.println();
        System.out.println("Czas podrozy: " + czasPodrozy(zlodziej));
        wypelnienieMiast();
        double CzasPodroży = algorytmZachlanny(zlodziej);
        System.out.println("Czas podróży: " + CzasPodroży);
        double ProfitPodróży = profit();
        System.out.println("Łaczna wartość przedmiotów: " + ProfitPodróży);
        System.out.println("Wynik G(x, y) algortymu zachłannego " + (ProfitPodróży - CzasPodroży));
        for(int i = 0; i < numberOfItems; i++)
        {
            if(spisPrzedmiotow[i+1].wziety == true) {
                System.out.println(spisPrzedmiotow[i + 1].toString());
            }
        }
        }


    public static void wczytanieDanych() throws IOException
    {
        String fileName = "C:\\Users\\dios1\\IdeaProjects\\SI1\\src\\easy_0.ttp";
        File file = new File(fileName);
        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);
        String line;
        br.readLine();
        br.readLine();
        line = br.readLine();
        String[] split = line.split("(\\s)+");
        dimension = Integer.parseInt(split[1]);
        line = br.readLine();
        split = line.split("(\\s)+");
        numberOfItems = Integer.parseInt(split[3]);
        line = br.readLine();
        split = line.split("(\\s)+");
        capacityOfKnapsack = Integer.parseInt(split[3]);
        line = br.readLine();
        split = line.split("(\\s)+");
        minSpeed = Double.parseDouble(split[2]);
        line = br.readLine();
        split = line.split("(\\s)+");
        maxSpeed = Double.parseDouble(split[2]);
        line = br.readLine();
        split = line.split("(\\s)+");
        rentingRatio = Double.parseDouble(split[2]);
        spisMiast = new Miasto[dimension + 1];
        spisPrzedmiotow = new Przedmiot[numberOfItems + 1];
        br.readLine();
        br.readLine();
        for(int i = 0; i < dimension; i++)
        {
            line = br.readLine();
            split = line.split("(\\s)+");
            spisMiast[i+1] = new Miasto(Integer.parseInt(split[0]), Double.parseDouble(split[1]), Double.parseDouble(split[2]));
        }
        br.readLine();
        for(int i = 0; i < numberOfItems; i++)
        {
            line = br.readLine();
            split = line.split("(\\s)+");
            spisPrzedmiotow[i+1] = new Przedmiot(Integer.parseInt(split[0]), Integer.parseInt(split[1]), Integer.parseInt(split[2]), Integer.parseInt(split[3]));
        }
        br.close();
    }

    public static double czasPodrozy(Osobnik z)
    {
        double suma = 0;
        for(int i = 0; i < dimension; i++)
        {
            double d = spisMiast[z.trasa[i]].odleglosc(spisMiast[z.trasa[i+1]]);
            double Vc = z.obecnapredkosc();
            double t = z.czas(Vc, d);
            System.out.println(t);
            suma += t;
        }

        return suma;
    }
    public static void wypelnienieMiast()
    {
        for(int i = 0; i < dimension; i++)
        {
            spisMiast[i+1].przedmioty(spisPrzedmiotow);
            Collections.sort(spisMiast[i+1].listaPrzedmiotow);
        }
    }
    public static double algorytmZachlanny(Osobnik z)
    {
        double suma = 0;
        for(int i = 1; i < dimension+1; i++)
        {
            if(spisMiast[z.trasa[i]].listaPrzedmiotow.size() != 0) {
                if (z.Wc < z.W) {
                    int j = 0;
                    while (spisMiast[z.trasa[i]].listaPrzedmiotow.size()  > j+1 && z.Wc + spisMiast[z.trasa[i]].listaPrzedmiotow.get(j).waga > z.W) {
                        j++;
                    }
                    if (z.Wc + spisMiast[z.trasa[i]].listaPrzedmiotow.get(j).waga <= z.W) {
                        spisMiast[z.trasa[i]].listaPrzedmiotow.get(j).wziety = true;
                        z.Wc += spisMiast[z.trasa[i]].listaPrzedmiotow.get(j).waga;
                    }
                }
            }
            double d = spisMiast[z.trasa[i-1]].odleglosc(spisMiast[z.trasa[i]]);
            double Vc = z.obecnapredkosc();
            double t = z.czas(Vc, d);
            System.out.println(t);
            suma += t;
        }
        return suma;
    }

    public static double profit()
    {
        double prof = 0;
        for(int i = 0; i < numberOfItems; i++)
        {
            if(spisPrzedmiotow[i+1].wziety == true) {
                prof += spisPrzedmiotow[i + 1].wartosc;
            }
        }
        return prof;
    }

    }





