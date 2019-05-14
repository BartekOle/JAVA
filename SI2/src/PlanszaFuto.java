import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class PlanszaFuto {
    int rozmiar;
    PoleFuto plansza[][];

    public int zamiana(char znak) {
        int liczba = 0;
        if (znak == 'A') {
            liczba = 1;
        } else if (znak == 'B') {
            liczba = 2;
        } else if (znak == 'C') {
            liczba = 3;
        } else if (znak == 'D') {
            liczba = 4;
        } else if (znak == 'E') {
            liczba = 5;
        } else if (znak == 'F') {
            liczba = 6;
        } else if (znak == 'G') {
            liczba = 7;
        } else if (znak == 'H') {
            liczba = 8;
        } else if (znak == 'I') {
            liczba = 9;
        }

        return liczba;
    }

    public  void wczytanieDanychFuto() throws IOException
    {
        String fileName = "C:\\Users\\dios1\\IdeaProjects\\SI2\\src\\test_futo_9_2.txt";
        File file = new File(fileName);
        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);
        String line;
        line = br.readLine();
        this.rozmiar = Integer.parseInt(line);
        this.plansza = new PoleFuto[this.rozmiar+1][this.rozmiar+1];
        String[] split;
        br.readLine();
        int numerKolejnosc = 0;
        for(int i = 1; i < rozmiar+1; i++)
        {
            line = br.readLine();
            split = line.split(";");
            for(int j =1; j < rozmiar+1; j++)
            {
                numerKolejnosc++;
                String tekst = Integer.toString(i) + Integer.toString(j);
                int pole = Integer.parseInt(tekst);
                this.plansza[i][j] = new PoleFuto(Integer.parseInt(split[j-1]), pole, numerKolejnosc,this.rozmiar);
            }
        }
        for(int i = 1; i < rozmiar+1; i++)
        {

            for(int j =1; j < rozmiar+1; j++)
            {
                if(i != rozmiar && j != rozmiar )
                {
                    if(j == rozmiar)
                    {
                        this.plansza[i][j].nastepnePole = this.plansza[i+1][0];
                    }
                    else {
                        this.plansza[i][j].nastepnePole = this.plansza[i][j + 1];
                    }
                }
                if(i != 1 && j != 1)
                {
                    if(j == 1)
                    {
                        this.plansza[i][j].poprzedniePole = this.plansza[i-1][rozmiar];
                    }
                    this.plansza[i][j].poprzedniePole = this.plansza[i][j-1];
                }
            }
        }
        br.readLine();
        line = br.readLine();
        do {
            split = line.split(";");
            String mniejsza = split[0];
            String wieksza = split[1];
            int pierwszaM = zamiana(mniejsza.charAt(0));
            int drugaM = Character.getNumericValue(mniejsza.charAt(1));
            int pierwszaW = zamiana(wieksza.charAt(0));
            int drugaW = Character.getNumericValue(wieksza.charAt(1));
            this.plansza[pierwszaM][drugaM].mniejsze.add(this.plansza[pierwszaW][drugaW]);
            this.plansza[pierwszaW][drugaW].wieksze.add(this.plansza[pierwszaM][drugaM]);
            line = br.readLine();
        } while(line != null);
        br.close();
    }

    public boolean sprawdzWieksze(int i, int j)
    {
            for(PoleFuto F: this.plansza[i][j].wieksze) {
                if (this.plansza[i][j].wartosc <= F.wartosc) {
                    return false;
                }
            }
        return true;
    }

    public boolean sprawdzMniejsze(int i, int j)
    {
        for(PoleFuto F: this.plansza[i][j].mniejsze) {
            if (this.plansza[i][j].wartosc >= F.wartosc) {
                return false;
            }
        }
        return true;
    }

    public boolean sprawdzRzad(int i, int j)
    {
        for(int k = j-1; k >= 1; k--)
        {
            if(this.plansza[i][j].wartosc == this.plansza[i][k].wartosc)
            {
                return false;
            }
        }
        for(int k = j+1; k < this.rozmiar + 1; k++)
        {
            if(this.plansza[i][j].wartosc == this.plansza[i][k].wartosc)
            {
                return false;
            }
        }
        return true;
    }

    public boolean sprawdzKolumne(int i, int j)
    {
        for(int k = i-1; k >= 1; k--)
        {
            if(this.plansza[i][j].wartosc == this.plansza[k][j].wartosc)
            {
                return false;
            }
        }
        for(int k = i+1; k < this.rozmiar + 1; k++)
        {
            if(this.plansza[i][j].wartosc == this.plansza[k][j].wartosc)
            {
                return false;
            }
        }
        return true;
    }
}


