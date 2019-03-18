import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collections;
import java.util.Random;

public class Main  {
        static private int dimension;
        static private int numberOfItems;
        static private int capacityOfKnapsack;
        static private int pop_size;
        static private int gen;
        static private int tour;
        static private double Px;
        static private double Pm;
        static private double minSpeed;
        static private double maxSpeed;
        static private double rentingRatio;
        static private Miasto [] spisMiast;
        static private Przedmiot [] spisPrzedmiotow;
        static private Osobnik [] populacja;
        static private Osobnik [] nowaPopulacja;
    public static void main(String[] args) throws IOException  {

        pop_size = 100;
        gen = 100;
        tour = 5;
        Px = 0.7;
        Pm = 0.01;
        populacja = new Osobnik[pop_size];
        nowaPopulacja = new Osobnik[pop_size];
        wczytanieDanych();
        for(int i = 0; i < dimension; i++)
        {
            System.out.println(spisMiast[i+1].toString());
        }
        for(int i = 0; i < numberOfItems; i++)
        {
            System.out.println(spisPrzedmiotow[i+1].toString());
        }
        for(int i = 0; i < pop_size; i++)
        {
            populacja[i] = new Osobnik(capacityOfKnapsack, maxSpeed, minSpeed);
            populacja[i].chromoson(dimension);
        }
        /*Osobnik zlodziej = new Osobnik(capacityOfKnapsack, maxSpeed, minSpeed);
        zlodziej.chromoson(dimension);
        for(int i = 0; i < zlodziej.trasa.length; i++) {
            System.out.print(zlodziej.trasa[i] + " ");
        }*/
        System.out.println();
        sortowanie();
        wypelnieniePrzedmioty();
        wypelnienieMiast();
        for(int i = 0; i < numberOfItems; i++)
        {
            System.out.println(spisPrzedmiotow[i+1].toString());
        }
        int sumWag = 0;
        for(int i = 0; i < numberOfItems; i++)
        {
            if(spisPrzedmiotow[i+1].wziety) {
                sumWag += spisPrzedmiotow[i+1].waga;
            }
        }
        /*System.out.println(sumWag);
        System.out.println("Czas podrozy: " + czasPodrozy(zlodziej));
        double CzasPodroży = czas(zlodziej);
        System.out.println("Czas podróży: " + CzasPodroży);
        double ProfitPodróży = profit();
        System.out.println("Łaczna wartość przedmiotów: " + ProfitPodróży);
        System.out.println("Wynik G(x, y) algortymu zachłannego " + (ProfitPodróży - CzasPodroży));
        for(int i = 0; i < numberOfItems; i++)
        {
            if(spisPrzedmiotow[i+1].wziety) {
                System.out.println(spisPrzedmiotow[i + 1].toString());
            }
        }
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
        */
        algorytmGenetyczny();
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

    public static void sortowanie() {
        for (int i = 1; i < spisPrzedmiotow.length-1; i++) {
            for (int j = 1; j < spisPrzedmiotow.length-1; j++) {
                if (spisPrzedmiotow[j].getProfit() > spisPrzedmiotow[j + 1].getProfit()) {
                    Przedmiot temp = spisPrzedmiotow[j];
                    spisPrzedmiotow[j] = spisPrzedmiotow[j + 1];
                    spisPrzedmiotow[j + 1] = temp;
                }
            }
        }
    }

    public static void wypelnieniePrzedmioty() {
            int dopuszczalnaWaga = 0;
            int index = 1;
            while(dopuszczalnaWaga != capacityOfKnapsack && spisPrzedmiotow.length > index)
            {
                if (dopuszczalnaWaga + spisPrzedmiotow[index].waga <= capacityOfKnapsack) {
                    spisPrzedmiotow[index].wziety = true;
                    dopuszczalnaWaga +=  spisPrzedmiotow[index].waga;
                }
                index++;
            }
    }

    public static void wypelnienieMiast()
    {
        for(int i = 0; i < dimension; i++)
        {
            spisMiast[i+1].przedmioty(spisPrzedmiotow);
            Collections.sort(spisMiast[i+1].listaPrzedmiotow);
        }
    }
    public static double czas(Osobnik z)
    {
        double suma = 0;
        for(int i = 1; i < dimension+1; i++)
        {
            if(spisMiast[z.trasa[i]].listaPrzedmiotow.size() != 0) {
                if (z.Wc < z.W) {
                    int j = 0;
                    while (spisMiast[z.trasa[i]].listaPrzedmiotow.size()  > j+1) {
                    if (spisMiast[z.trasa[i]].listaPrzedmiotow.get(j).wziety) {
                        z.Wc += spisMiast[z.trasa[i]].listaPrzedmiotow.get(j).waga;
                    }
                    j++;
                    }
                }
            }
            double d = spisMiast[z.trasa[i-1]].odleglosc(spisMiast[z.trasa[i]]);
            double Vc = z.obecnapredkosc();
            double t = z.czas(Vc, d);
            suma += t;
        }
        return suma;
    }

    public static double profit()
    {
        double prof = 0;
        for(int i = 0; i < numberOfItems; i++)
        {
            if(spisPrzedmiotow[i+1].wziety) {
                prof += spisPrzedmiotow[i + 1].wartosc;
            }
        }
        return prof;
    }

    public static void mutacja()
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
                int pom = nowaPopulacja[i].trasa[cyfra1];
                nowaPopulacja[i].trasa[cyfra1] = nowaPopulacja[i].trasa[cyfra2];
                nowaPopulacja[i].trasa[cyfra2] = pom;
                if(cyfra1 == 0)
                {
                    nowaPopulacja[i].trasa[dimension] = nowaPopulacja[i].trasa[0];
                }
            }
        }
    }

    public static void krzyzowanie()
    {
        Osobnik child1 = new Osobnik(capacityOfKnapsack, maxSpeed, minSpeed);
        Osobnik child2 = new Osobnik(capacityOfKnapsack, maxSpeed, minSpeed);
        child1.chromoson(dimension);
        child2.chromoson(dimension);
        Random rand = new Random();
        for(int j = 0; j < pop_size; j+=2) {
            Osobnik o1 = nowaPopulacja[j];
            Osobnik o2 = nowaPopulacja[j+1];
            double liczba = rand.nextDouble();
            if (liczba <= Px) {
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
                    while (pom[o2.trasa[index2]] != 0) {
                        index2++;
                        if (index2 == dimension) {
                            index2 = 0;
                        }
                    }
                    while (pom2[o1.trasa[index3]] != 0) {
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
            } else {
                child1.trasa = o1.trasa;
                child2.trasa = o2.trasa;
            }

            nowaPopulacja[j] = new Osobnik(capacityOfKnapsack, maxSpeed, minSpeed, child1.trasa);
            nowaPopulacja[j+1] = new Osobnik(capacityOfKnapsack, maxSpeed, minSpeed, child2.trasa);
        }
    }

    public static int turniej()
    {
        double profit = profit();
        Osobnik [] zawodnicy = new Osobnik[tour];
        int [] zawodnicyIndex = new int[tour];
        boolean [] pom = new boolean[pop_size];
        for(int i = 0; i < pop_size; i++)
        {
            pom[i] = false;
        }
        for(int i = 0; i < tour; i++)
        {
            Random rand = new Random();
            int liczba = rand.nextInt(pop_size);

            while(pom[liczba])
            {
                liczba = rand.nextInt(pop_size);
            }
            zawodnicy[i] = populacja[liczba];
            zawodnicyIndex[i] = liczba;
            pom[liczba] = true;
        }
        for (int i = 0; i < zawodnicy.length-1; i++) {
            for (int j = 0; j < zawodnicy.length-1; j++) {
                if (czas(zawodnicy[j]) < czas(zawodnicy[j + 1])) {
                    Osobnik temp = zawodnicy[j];
                    int temp2 = zawodnicyIndex[j];
                    zawodnicy[j] = zawodnicy[j + 1];
                    zawodnicyIndex[j] = zawodnicyIndex[j + 1];
                    zawodnicy[j + 1] = temp;
                    zawodnicyIndex[j + 1] = temp2;
                }
            }
        }
        return zawodnicyIndex[0];
    }

    public static void selekcja()
    {
        for(int i = 0; i < pop_size; i++)
        {
            nowaPopulacja[i] = new Osobnik(capacityOfKnapsack, maxSpeed, minSpeed, populacja[turniej()].trasa);
        }
    }

    public static void sortowaniePopulacji() {
        for (int i = 0; i < populacja.length - 1; i++) {
            for (int j = 0; j < populacja.length - 1; j++) {
                if (czas(populacja[j]) < czas(populacja[j + 1])) {
                    Osobnik temp = populacja[j];
                    populacja[j] = populacja[j + 1];
                    populacja[j + 1] = temp;
                }
            }
        }
    }

    public static double najlepszy() {
        double naj = czas(populacja[0]);
        for (int i = 1; i < populacja.length; i++) {

                if (naj > czas(populacja[i])) {
                    naj = czas(populacja[i]);
                }
            }
        return naj;
    }

    public static double najgorszy() {
        double naj = czas(populacja[0]);
        for (int i = 1; i < populacja.length; i++) {

            if (naj < czas(populacja[i])) {
                naj = czas(populacja[i]);
            }
        }
        return naj;
    }

    public static double sredniaPopulacji() {
            double profit = profit();
            double suma = 0;
            for (int i = 0; i < populacja.length; i++) {
               suma += profit - czas(populacja[i]);
                }
            return suma/pop_size;
    }

    public static void algorytmGenetyczny()
    {

        int numerGeneracji = 1;
        while(numerGeneracji < gen)
        {
            System.out.println();
            for(int i = 0; i < 10; i++) {
                for(int j = 0; j < dimension+1; j++) {
                    System.out.print(populacja[i].trasa[j] + " ");
                }
                System.out.println();
            }
            System.out.println();
            selekcja();
            krzyzowanie();
            mutacja();
            System.out.println("W generacji numer: " + numerGeneracji + " Najlepszy wynik: " + (profit() - najlepszy()) + " średni wynik: " + sredniaPopulacji() + " najgorszy wynik: " + (profit() - najgorszy()));
            for(int i = 0; i < pop_size; i++)
            {
                populacja[i] = new Osobnik(capacityOfKnapsack, maxSpeed, minSpeed, nowaPopulacja[i].trasa);
            }

            numerGeneracji++;
            /*
             for(int i = 0; i < 10; i++) {
                for(int j = 0; j < dimension+1; j++) {
                    System.out.print(nowaPopulacja[i].trasa[j] + " ");
                }
                System.out.println();
            }
            System.out.println();
             */
        }
        System.out.println("W generacji numer: " + numerGeneracji + " Najlepszy wynik: " + (profit() - czas(populacja[pop_size-1])) + " średni wynik: " + sredniaPopulacji() + " najgorszy wynik: " + (profit() - czas(populacja[0])));
    }

    }





