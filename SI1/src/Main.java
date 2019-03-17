import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collections;
import java.util.Random;

public class Main {
        static int  dimension;
        static int numberOfItems;
        static int capacityOfKnapsack;
        static int pop_size;
        static int gen;
        static int tour;
        static double Px;
        static double Pm;
        static double minSpeed;
        static double maxSpeed;
        static double rentingRatio;
        static Miasto [] spisMiast;
        static Przedmiot [] spisPrzedmiotow;
        static Osobnik child1;
        static Osobnik child2;
    public static void main(String[] args) throws IOException {

        pop_size = 100;
        gen = 100;
        tour = 5;
        Px = 0.7;
        Pm = 0.01;
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
        /*(System.out.println("Czas podrozy: " + czasPodrozy(zlodziej));
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
        }*/
        Osobnik zlodziej2 = new Osobnik(capacityOfKnapsack, maxSpeed, minSpeed);
        zlodziej2.chromoson(dimension);
        for(int i = 0; i < zlodziej2.trasa.length; i++) {
            System.out.print(zlodziej2.trasa[i] + " ");
        }
        System.out.println();
        krzyzowanie(zlodziej, zlodziej2);
        for(int i = 0; i < zlodziej.trasa.length; i++) {
            System.out.print(child1.trasa[i] + " ");
        }
        System.out.println();
        for(int i = 0; i < zlodziej2.trasa.length; i++) {
            System.out.print(child2.trasa[i] + " ");
        }
        System.out.println();
        }


    public static void wczytanieDanych() throws IOException
    {
        String fileName = "C:\\Users\\dios1\\IdeaProjects\\SI1\\src\\easy_1.ttp";
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

    public static void mutacja(Osobnik pop[])
    {
        for(int i = 0; i < pop_size; i++)
        {
            Random rand = new Random();
            double liczba = rand.nextDouble();
            if(liczba <= Pm)
            {
                int cyfra1 = rand.nextInt(dimension);
                int cyfra2 = rand.nextInt(dimension);
                while(cyfra1 == cyfra2)
                {
                    cyfra2 = rand.nextInt(dimension);
                }
                int pom = pop[i].trasa[cyfra1];
                pop[1].trasa[cyfra1] = pop[i].trasa[cyfra2];
                pop[i].trasa[cyfra2] = pom;
                if(cyfra1 == 0)
                {
                    pop[i].trasa[dimension] = cyfra1;
                }
            }
        }
    }

    public static void krzyzowanie(Osobnik o1, Osobnik o2)
    {
        child1 = new Osobnik(capacityOfKnapsack, maxSpeed, minSpeed);
        child2 = new Osobnik(capacityOfKnapsack, maxSpeed, minSpeed);
        child1.chromoson(dimension);
        child2.chromoson(dimension);
        Random rand = new Random();
        double liczba = rand.nextDouble();
        if(liczba <= Px) {
            int range = dimension / 2;
            if (range % 2 != 0) {
                range++;
            }
            int range1 = range / 2;
            int range2 = range1 + range;
            int pom[] = new int[dimension + 1];
            for (int i = 0; i < pom.length; i++) {
                pom[i] = 0;
            }
            int pom2[] = new int[dimension + 1];
            for (int i = 0; i < pom2.length; i++) {
                pom2[i] = 0;
            }
            for (int i = range1; i <= range2; i++) {
                child1.trasa[i] = o1.trasa[i];
                child2.trasa[i] = o2.trasa[i];
                pom[o1.trasa[i]] = 1;
                pom2[o2.trasa[i]] = 1;
            }

            int index = range2 + 1;
            int index2 = range2 + 1;
            int index3 = range2 + 1;
            while (index != range1) {
                if (index == dimension) {
                    index = 0;
                }
                if (index2 == dimension) {
                    index2 = 0;
                }
                if (index3 == dimension) {
                    index3 = 0;
                }
            while(pom[o2.trasa[index2]] != 0)
            {
                index2++;
                if (index2 == dimension) {
                    index2 = 0;
                }
            }
            while(pom2[o1.trasa[index3]] != 0)
                {
                    index3++;
                    if (index3 == dimension) {
                        index3 = 0;
                    }
                }
            child1.trasa[index] = o2.trasa[index2];
            child2.trasa[index] = o1.trasa[index3];
            pom[o2.trasa[index2]] = 1;
            pom2[o1.trasa[index3]] = 1;
            index++;
            }
            child1.trasa[dimension] = child1.trasa[0];
            child2.trasa[dimension] = child2.trasa[0];
        }
        else
        {
            child1.trasa = o1.trasa;
            child2.trasa = o2.trasa;
        }

    }

    }





