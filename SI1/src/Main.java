import java.io.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Collections;
import java.util.Random;

public class Main  {
    static private int wymiar;
    static private int liczbaPrzedmiotow;
    static private int pojemnoscPlecaka;
    static private int pop_size;
    static private int gen;
    static private int tour;
    static private double Px;
    static private double Pm;
    static private double minPredkosc;
    static private double maxPredkosc;
    static private double wspolczynnikWynajmu;
    static private Miasto [] spisMiast;
    static private Przedmiot [] spisPrzedmiotow;
    static private Osobnik [] populacja;
    static private Osobnik [] nowaPopulacja;
    static private double [][] odleglosci;
    public static void main(String[] args) throws IOException  {

        pop_size = 500;
        gen = 200;
        tour = 50;
        Px = 0.7;
        Pm = 0.2;
        populacja = new Osobnik[pop_size];
        nowaPopulacja = new Osobnik[pop_size];
        wczytanieDanych();
        for(int i = 0; i < pop_size; i++)
        {
            populacja[i] = new Osobnik(pojemnoscPlecaka, maxPredkosc, minPredkosc);
            populacja[i].chromoson(wymiar);
        }
        odleglosci = new double [wymiar+1][wymiar+1];
        System.out.println();
        sortowanie();
        wypelnieniePrzedmioty();
        wypelnienieMiast();
        wypelnienieOdleglosci();


        algorytmGenetyczny();
        System.out.println("Wynik dla algorytmu zachłannego: " + metodaZachlanna());
    }


    public static void wczytanieDanych() throws IOException
    {
        String fileName = "C:\\Users\\dios1\\IdeaProjects\\SI1\\src\\medium_1.ttp";
        File file = new File(fileName);
        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);
        String line;
        br.readLine();
        br.readLine();
        line = br.readLine();
        String[] split = line.split("(\\s)+");
        wymiar = Integer.parseInt(split[1]);
        line = br.readLine();
        split = line.split("(\\s)+");
        liczbaPrzedmiotow = Integer.parseInt(split[3]);
        line = br.readLine();
        split = line.split("(\\s)+");
        pojemnoscPlecaka = Integer.parseInt(split[3]);
        line = br.readLine();
        split = line.split("(\\s)+");
        minPredkosc = Double.parseDouble(split[2]);
        line = br.readLine();
        split = line.split("(\\s)+");
        maxPredkosc = Double.parseDouble(split[2]);
        line = br.readLine();
        split = line.split("(\\s)+");
        wspolczynnikWynajmu = Double.parseDouble(split[2]);
        spisMiast = new Miasto[wymiar + 1];
        spisPrzedmiotow = new Przedmiot[liczbaPrzedmiotow + 1];
        br.readLine();
        br.readLine();
        for(int i = 0; i < wymiar; i++)
        {
            line = br.readLine();
            split = line.split("(\\s)+");
            spisMiast[i+1] = new Miasto(Integer.parseInt(split[0]), Double.parseDouble(split[1]), Double.parseDouble(split[2]));
        }
        br.readLine();
        for(int i = 0; i < liczbaPrzedmiotow; i++)
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
        for(int i = 0; i < wymiar; i++)
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
                if (spisPrzedmiotow[j].dostanProfit() > spisPrzedmiotow[j + 1].dostanProfit()) {
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
        while(dopuszczalnaWaga != pojemnoscPlecaka && spisPrzedmiotow.length > index)
        {
            if (dopuszczalnaWaga + spisPrzedmiotow[index].waga <= pojemnoscPlecaka) {
                spisPrzedmiotow[index].wziety = true;
                dopuszczalnaWaga +=  spisPrzedmiotow[index].waga;
            }
            index++;
        }
    }

    public static void wypelnienieOdleglosci()
    {
        for(int i = 1; i < wymiar+1; i++)
        {
            for(int j = 1; j < wymiar+1; j++) {
                odleglosci[i][j] = spisMiast[i].odleglosc(spisMiast[j]);
            }
        }
    }

    public static void wypelnienieMiast()
    {
        for(int i = 0; i < wymiar; i++)
        {
            spisMiast[i+1].przedmioty(spisPrzedmiotow);
            Collections.sort(spisMiast[i+1].listaPrzedmiotow);
        }
    }
    public static double czas(Osobnik z)
    {
        z.Wc = 0;
        double suma = 0;
        for(int i = 0; i < wymiar; i++)
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
            double d =  odleglosci[z.trasa[i]][z.trasa[i+1]];
            double Vc = z.obecnapredkosc();
            double t = z.czas(Vc, d);
            suma += t;
        }
        return suma;
    }

    public static double profit()
    {
        double prof = 0;
        for(int i = 0; i < liczbaPrzedmiotow; i++)
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
                int cyfra1 = rand.nextInt(wymiar);
                int cyfra2 = rand.nextInt(wymiar);
                while(cyfra1 == cyfra2)
                {
                    cyfra2 = rand.nextInt(wymiar);
                }
                int pom = nowaPopulacja[i].trasa[cyfra1];
                nowaPopulacja[i].trasa[cyfra1] = nowaPopulacja[i].trasa[cyfra2];
                nowaPopulacja[i].trasa[cyfra2] = pom;
                if(cyfra1 == 0)
                {
                    nowaPopulacja[i].trasa[wymiar] = nowaPopulacja[i].trasa[0];
                }
            }
        }
    }

    public static void krzyzowanie()
    {
        Osobnik child1 = new Osobnik(pojemnoscPlecaka, maxPredkosc, minPredkosc);
        Osobnik child2 = new Osobnik(pojemnoscPlecaka, maxPredkosc, minPredkosc);
        child1.trasa = new int[wymiar+1]; ///child1.chromoson(wymiar);
        child2.trasa = new int[wymiar+1];///child2.chromoson(wymiar);
        Random rand = new Random();
        for(int j = 0; j < pop_size; j+=2) {
            Osobnik o1 = nowaPopulacja[j];
            Osobnik o2 = nowaPopulacja[j+1];
            double liczba = rand.nextDouble();
            if (liczba <= Px) {
                int range = wymiar / 2;
                if (range % 2 != 0) {
                    range++;
                }
                int range1 = range / 2;
                int range2 = range1 + range;
                int pom[] = new int[wymiar + 1];
                for (int i = 0; i < pom.length; i++) {
                    pom[i] = 0;
                }
                int pom2[] = new int[wymiar + 1];
                for (int i = 0; i < pom2.length; i++) {
                    pom2[i] = 0;
                }
                for (int i = range1; i < range2; i++) {
                    child1.trasa[i] = o1.trasa[i];
                    child2.trasa[i] = o2.trasa[i];
                    pom[o1.trasa[i]] = 1;
                    pom2[o2.trasa[i]] = 1;
                }

                int index = range2;
                int index2 = range2;
                int index3 = range2;
                while (index != range1) {
                    if (index == wymiar) {
                        index = 0;
                    }
                    if (index2 == wymiar) {
                        index2 = 0;
                    }
                    if (index3 == wymiar) {
                        index3 = 0;
                    }
                    while (pom[o2.trasa[index2]] != 0) {
                        index2++;
                        if (index2 == wymiar) {
                            index2 = 0;
                        }
                    }
                    while (pom2[o1.trasa[index3]] != 0) {
                        index3++;
                        if (index3 == wymiar) {
                            index3 = 0;
                        }
                    }
                    child1.trasa[index] = o2.trasa[index2];
                    child2.trasa[index] = o1.trasa[index3];
                    pom[o2.trasa[index2]] = 1;
                    pom2[o1.trasa[index3]] = 1;
                    index++;
                }
                child1.trasa[wymiar] = child1.trasa[0];
                child2.trasa[wymiar] = child2.trasa[0];
            } else {
                child1.trasa = o1.trasa;
                child2.trasa = o2.trasa;
            }

            nowaPopulacja[j] = new Osobnik(pojemnoscPlecaka, maxPredkosc, minPredkosc, child1.trasa);
            nowaPopulacja[j+1] = new Osobnik(pojemnoscPlecaka, maxPredkosc, minPredkosc, child2.trasa);
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
            zawodnicy[i] = new Osobnik(pojemnoscPlecaka, maxPredkosc, minPredkosc, populacja[liczba].trasa);
            zawodnicyIndex[i] = liczba;
            pom[liczba] = true;
        }
        /*for (int i = 0; i < zawodnicy.length-1; i++) {
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
        }*/
        double naj = czas(zawodnicy[0]);
        int najIndex = zawodnicyIndex[0];
        for (int i = 1; i < zawodnicy.length; i++) {

            if (naj > czas(zawodnicy[i])) {
                naj = czas(zawodnicy[i]);
                najIndex = zawodnicyIndex[i];
            }
        }
        return najIndex;
    }

    public static void ruletka()
    {
        Random rand = new Random();
        double [] procenty = new double[pop_size];
        double suma = 0;
        double sumaProcent = 0;
        double profit = profit();
        for(int i = 0; i < pop_size; i++)
        {
            double wynik = profit - czas(populacja[i]);
            if(wynik < 0)
            {
                suma += 1/Math.abs(wynik);
            }
            else
            {
                suma += wynik;
            }
        }
        for(int i = 0; i < pop_size; i++)
        {
            double wynik = profit - czas(populacja[i]);
            if(wynik < 0)
            {
                procenty[i] =  sumaProcent + ((1/Math.abs(wynik))/suma);
                sumaProcent += (1/Math.abs(wynik))/suma;
            }
            else
            {
                procenty[i] =  sumaProcent + (wynik/suma);
                sumaProcent += wynik/suma;
            }

        }
        for(int i = 0; i < pop_size; i++)
        {
            int index = 0;
            double liczba = rand.nextDouble();
            if(liczba <= procenty[index])
            {
                nowaPopulacja[i] = new Osobnik(pojemnoscPlecaka, maxPredkosc, minPredkosc, populacja[index].trasa);
            }
            else
            {
                index++;
                while(liczba > procenty[index] || liczba <= procenty[index-1])
                {
                    index++;
                }
                nowaPopulacja[i] = new Osobnik(pojemnoscPlecaka, maxPredkosc, minPredkosc, populacja[index].trasa);
            }
        }
    }

    public static void selekcja()
    {
        for(int i = 0; i < pop_size; i++)
        {
            nowaPopulacja[i] = new Osobnik(pojemnoscPlecaka, maxPredkosc, minPredkosc, populacja[turniej()].trasa);
        }
    }

    public static void sortowaniePopulacji() {
        for (int i = 0; i < populacja.length - 1; i++) {
            for (int j = 0; j < populacja.length - i; j++) {
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

    public static double metodaZachlanna() {
        Osobnik zlodziej = new Osobnik(pojemnoscPlecaka, maxPredkosc, minPredkosc);
        zlodziej.trasa = new int[wymiar + 1];
        int pom[] = new int[wymiar+1];
        double [] naj = new double[wymiar];
        int [] najIndex = new int[wymiar];
        zlodziej.trasa[0] = 1;
        zlodziej.trasa[zlodziej.trasa.length-1] = 1;
        for(int i = 1; i < zlodziej.trasa.length; i++)
        {
            pom[i] = 0;
        }
        pom[1] = 1;
        for(int k = 0; k < zlodziej.trasa.length-2; k++) {
            for(int l = 0; l < naj.length; l++)
            {
                naj[l] = odleglosci[zlodziej.trasa[k]][l+1];
                najIndex[l] = l+1;
            }
            for (int i = 0; i < naj.length - 1; i++) {
                for (int j = 0; j < naj.length - 1; j++) {
                    if (naj[j] > naj[j + 1]) {
                        double temp = naj[j];
                        naj[j] = naj[j + 1];
                        naj[j + 1] = temp;
                        int temp2 = najIndex[j];
                        najIndex[j] = najIndex[j + 1];
                        najIndex[j + 1] = temp2;
                    }
                }
            }
            int index = 1;
            while(pom[najIndex[index]] != 0)
            {
                index++;
            }
            zlodziej.trasa[k+1] = najIndex[index];
            pom[najIndex[index]] = najIndex[index];
        }

        for(int i = 0; i < zlodziej.trasa.length; i++)
        {
            System.out.print(zlodziej.trasa[i] + " ");
        }

        return (profit() - czas(zlodziej));

    }

    public static void algorytmGenetyczny() throws IOException {
        LocalTime dzisiaj = LocalTime.now();
        LocalDate dzisiaj2 = LocalDate.now();

        String nazwaPliku = dzisiaj.getHour() + "-" + dzisiaj.getMinute()+ "-" +dzisiaj.getSecond() + "-" + dzisiaj2.getYear() + "-" + dzisiaj2.getMonth()+ "-" +dzisiaj2.getDayOfMonth() + ".txt";
        try (PrintWriter writer = new PrintWriter(new File(nazwaPliku))) {

            StringBuilder sb = new StringBuilder();
            sb.append("Najlepsze,");
            sb.append("Srednie,");
            sb.append("Najgorsze");
            sb.append('\n');


            int numerGeneracji = 1;
            while(numerGeneracji < gen)
            {
                System.out.println();
               /* for(int i = 0; i < 10; i++) {
                    for(int j = 0; j < wymiar+1; j++) {
                        System.out.print(populacja[i].trasa[j] + " ");
                    }
                    System.out.println();
                }*/
                System.out.println();
                System.out.println("W generacji numer: " + numerGeneracji + " Najlepszy wynik: " + (profit() - najlepszy()) + " średni wynik: " + sredniaPopulacji() + " najgorszy wynik: " + (profit() - najgorszy()));
                sb.append((profit() - najlepszy()));
                sb.append(',');
                sb.append(sredniaPopulacji());
                sb.append(',');
                sb.append((profit() - najgorszy()));
                sb.append('\n');

                ruletka();
                krzyzowanie();
                mutacja();

                for(int i = 0; i < pop_size; i++)
                {
                    populacja[i] = new Osobnik(pojemnoscPlecaka, maxPredkosc, minPredkosc, nowaPopulacja[i].trasa);
                }

                numerGeneracji++;

            }
            System.out.println("W generacji numer: " + numerGeneracji + " Najlepszy wynik: " + (profit() - najlepszy()) + " średni wynik: " + sredniaPopulacji() + " najgorszy wynik: " + (profit() - najgorszy()));
            sb.append((profit() - najlepszy()));
            sb.append(',');
            sb.append(sredniaPopulacji());
            sb.append(',');
            sb.append((profit() - najgorszy()));
            sb.append('\n');
            writer.write(sb.toString());
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }


}





