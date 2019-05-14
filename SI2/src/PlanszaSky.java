import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class PlanszaSky {
    int rozmiar;
    PoleSky plansza[][];
    int GoraDol[][];
    int LewaPrawa[][];

    public void wczytanieDanychSky() throws IOException {
        String fileName = "C:\\Users\\dios1\\IdeaProjects\\SI2\\src\\test_sky_6_4.txt";
        File file = new File(fileName);
        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);
        String line;
        line = br.readLine();
        this.rozmiar = Integer.parseInt(line);
        this.plansza = new PoleSky[rozmiar + 1][rozmiar + 1];
        this.GoraDol = new int[2][rozmiar + 1];
        this.LewaPrawa = new int[rozmiar + 1][2];
        String[] split;
        for (int i = 0; i < 2; i++) {
            line = br.readLine();
            split = line.split(";");
            for (int j = 1; j < rozmiar + 1; j++) {
                this.GoraDol[i][j] = Integer.parseInt(split[j]);
            }
        }
        for (int i = 0; i < 2; i++) {
            line = br.readLine();
            split = line.split(";");
            for (int j = 1; j < rozmiar + 1; j++) {
                this.LewaPrawa[j][i] = Integer.parseInt(split[j]);
            }
        }
        int numerKolejnosc = 0;
        for(int i = 1; i < rozmiar + 1; i++)
        {
            for(int j = 1; j < rozmiar + 1; j++)
            {
                numerKolejnosc++;
                String tekst = Integer.toString(i) + Integer.toString(j);
                int pole = Integer.parseInt(tekst);
                this.plansza[i][j] = new PoleSky(pole, numerKolejnosc, this.rozmiar);
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


    }

    public boolean SprawdzGora(int i, int j) {

        if (this.GoraDol[0][j] == 0) {
            return true;
        } else {
            int ileWidac = 1;
            for (int k = 1; k < j; k++) {
                if (this.plansza[i][k].wartosc < this.plansza[i][k + 1].wartosc) {
                    ileWidac++;
                }
            }
            if (ileWidac > this.GoraDol[0][j]) {
                return false;
            }
            else if(ileWidac == this.GoraDol[0][j])
            {
                return true;
            }
            else
            {
                if(ileWidac + (j - this.rozmiar) >= this.GoraDol[0][j])
                {
                    return true;
                }
                else
                {
                    return false;
                }
            }
        }
    }

    public boolean SprawdzDol(int i, int j) {

        if (this.GoraDol[1][j] == 0) {
            return true;
        } else {
            int ileWidac = 1;
            for (int k = j; k > 1; k++) {
                if (this.plansza[i][k].wartosc < this.plansza[i][k - 1].wartosc) {
                    ileWidac++;
                }
            }
            if (ileWidac > this.GoraDol[1][j]) {
                return false;
            }
            else if(ileWidac == this.GoraDol[1][j])
            {
                return true;
            }
            else
            {
                if(ileWidac + (j - this.rozmiar) >= this.GoraDol[1][j])
                {
                    return true;
                }
                else
                {
                    return false;
                }
            }
        }
    }

    public boolean SprawdzLewa(int i, int j) {

        if (this.LewaPrawa[0][j] == 0) {
            return true;
        } else {
            int ileWidac = 1;
            for (int k = 1; k < i; k++) {
                if (this.plansza[k][j].wartosc < this.plansza[k + 1][j].wartosc) {
                    ileWidac++;
                }
            }
            if (ileWidac > this.LewaPrawa[0][j]) {
                return false;
            }
            else if(ileWidac == this.LewaPrawa[0][j])
            {
                return true;
            }
            else
            {
                if(ileWidac + (j - this.rozmiar) >= this.LewaPrawa[0][j])
                {
                    return true;
                }
                else
                {
                    return false;
                }
            }
        }
    }

    public boolean SprawdzPrawa(int i, int j) {

        if (this.LewaPrawa[1][j] == 0) {
            return true;
        } else {
            int ileWidac = 1;
            for (int k = i; k > 1; k--) {
                if (this.plansza[k][j].wartosc < this.plansza[k - 1][j].wartosc) {
                    ileWidac++;
                }
            }
            if (ileWidac > this.LewaPrawa[1][j]) {
                return false;
            }
            else if(ileWidac == this.LewaPrawa[1][j])
            {
                return true;
            }
            else
            {
                if(ileWidac + (j - this.rozmiar) >= this.LewaPrawa[1][j])
                {
                    return true;
                }
                else
                {
                    return false;
                }
            }
        }
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
        return true;
    }
}
