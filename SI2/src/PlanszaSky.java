import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class PlanszaSky {
    protected int rozmiar;
    protected PoleSky plansza[][];
    protected int goraDol[][];
    protected int lewaPrawa[][];
    protected int liczbaIteracji;

    public void wczytanieDanychSky() throws IOException {
        liczbaIteracji = 0;
        String fileName = "C:\\Users\\dios1\\IdeaProjects\\SI2\\src\\test_sky_5_0.txt";
        File file = new File(fileName);
        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);
        String line;
        line = br.readLine();
        rozmiar = Integer.parseInt(line);
        plansza = new PoleSky[rozmiar + 1][rozmiar + 1];
        goraDol = new int[2][rozmiar + 1];
        lewaPrawa = new int[rozmiar + 1][2];
        String[] split;
        for (int i = 0; i < 2; i++) {
            line = br.readLine();
            split = line.split(";");
            for (int j = 1; j < rozmiar + 1; j++) {
                goraDol[i][j] = Integer.parseInt(split[j]);
            }
        }
        for (int i = 0; i < 2; i++) {
            line = br.readLine();
            split = line.split(";");
            for (int j = 1; j < rozmiar + 1; j++) {
                lewaPrawa[j][i] = Integer.parseInt(split[j]);
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
                plansza[i][j] = new PoleSky(pole, numerKolejnosc, rozmiar);
            }
        }
        for(int i = 1; i < rozmiar+1; i++)
        {

            for(int j =1; j < rozmiar+1; j++)
            {
                if(i != rozmiar || j != rozmiar )
                {
                    if(j == rozmiar)
                    {
                        plansza[i][j].nastepnePole = plansza[i+1][1];
                    }
                    else {
                        plansza[i][j].nastepnePole = plansza[i][j + 1];
                    }
                }
                if(i != 1 || j != 1) {
                    if (j == 1) {
                        plansza[i][j].poprzedniePole = plansza[i - 1][rozmiar];
                    } else {
                        plansza[i][j].poprzedniePole = plansza[i][j - 1];
                    }
                }
            }
        }


    }

    public boolean sprawdzGora(int i, int j) {
        if (goraDol[0][j] == 0) {
            return true;
        } else {
            int najwiekszaWatosc = plansza[1][j].wartosc;
            int ileWidac = 1;
            for (int k = 2; k <= i; k++) {
                if (najwiekszaWatosc < plansza[k][j].wartosc) {
                    ileWidac++;
                    najwiekszaWatosc = plansza[k][j].wartosc;
                }
            }
            if (ileWidac > goraDol[0][j] && i == rozmiar) {
                return false;
            }
            else if(ileWidac == goraDol[0][j])
            {
                return true;
            }
            else
            {
                if(ileWidac + (rozmiar - i) >= goraDol[0][j])
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

    public boolean sprawdzDol(int i, int j) {

        if (goraDol[1][j] == 0) {
            return true;
        } else {
            int najwiekszaWartosc = plansza[i][j].wartosc;
            int ileWidac = 1;
            for (int k = i-1; k >= 1; k--) {
                if (najwiekszaWartosc < plansza[k][j].wartosc) {
                    ileWidac++;
                    najwiekszaWartosc = plansza[k][j].wartosc;
                }
            }
            if (ileWidac > goraDol[1][j] && i == rozmiar) {
                return false;
            }
            else if(ileWidac == goraDol[1][j])
            {
                return true;
            }
            else
            {
                if(ileWidac + (rozmiar - i) >= goraDol[1][j])
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

    public boolean sprawdzLewa(int i, int j) {

        if (lewaPrawa[i][0] == 0) {
            return true;
        } else {
            int najwiekszaWartosc = plansza[i][1].wartosc;
            int ileWidac = 1;
            for (int k = 2; k <= j; k++) {
                if (najwiekszaWartosc < plansza[i][k].wartosc) {
                    ileWidac++;
                    najwiekszaWartosc = plansza[i][k].wartosc;
                }
            }
            if (ileWidac > lewaPrawa[i][0] && j == rozmiar) {
                return false;
            }
            else if(ileWidac == lewaPrawa[i][0])
            {
                return true;
            }
            else
            {
                if(ileWidac + (rozmiar - j) >= lewaPrawa[i][0])
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

    public boolean sprawdzPrawa(int i, int j) {

        if (lewaPrawa[i][1] == 0) {
            return true;
        } else {
            int najwiekszaWartosc = plansza[i][j].wartosc;
            int ileWidac = 1;
            for (int k = j-1; k >= 1; k--) {
                if (najwiekszaWartosc < plansza[i][k].wartosc) {
                    ileWidac++;
                    najwiekszaWartosc = plansza[i][k].wartosc;
                }
            }
            if (ileWidac > lewaPrawa[i][1] && j == rozmiar) {
                return false;
            }
            else if(ileWidac == lewaPrawa[i][1])
            {
                return true;
            }
            else
            {
                if(ileWidac + (rozmiar - j) >= lewaPrawa[i][1])
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
            if(plansza[i][j].wartosc == plansza[i][k].wartosc)
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
            if(plansza[i][j].wartosc == plansza[k][j].wartosc)
            {
                return false;
            }
        }
        return true;
    }

    public boolean przeszukiwaniePrzyrostoweZPowrotem()
    {
        int obecnyNumerPola = 1;
        PoleSky obecnePole = plansza[1][1];
        int obecnieSprawdzaWartosc = 1;
        while(obecnyNumerPola <= rozmiar*rozmiar) {

            boolean sprawdzWartoscPola = false;
                while (!sprawdzWartoscPola) {
                    while (!sprawdzWartoscPola && obecnePole.sprawdzoneCyfry < rozmiar) {
                        liczbaIteracji++;
                        obecnePole.wartosc = obecnieSprawdzaWartosc;
                        obecnePole.sprawdzoneCyfry++;
                        int indeksI = obecnePole.nrPola / 10;
                        int indeksJ = obecnePole.nrPola % 10;
                        if (sprawdzKolumne(indeksI, indeksJ) && sprawdzRzad(indeksI, indeksJ) && sprawdzDol(indeksI, indeksJ) && sprawdzGora(indeksI, indeksJ) && sprawdzLewa(indeksI, indeksJ) && sprawdzPrawa(indeksI, indeksJ)) {
                            sprawdzWartoscPola = true;
                        } else {
                            if (obecnieSprawdzaWartosc == rozmiar) {
                                obecnieSprawdzaWartosc = 1;
                            } else {
                                obecnieSprawdzaWartosc++;
                            }
                        }
                    }
                    if (!sprawdzWartoscPola) {
                        if (obecnePole.numerWKolejnosci == 1 && obecnePole.sprawdzoneCyfry == rozmiar) {
                            return false;
                        } else {
                            obecnePole.wartosc = 0;
                            obecnePole.sprawdzoneCyfry = 0;
                            obecnePole = obecnePole.poprzedniePole;
                            obecnyNumerPola = obecnePole.numerWKolejnosci;
                            if (obecnePole.wartosc == rozmiar) {
                                obecnieSprawdzaWartosc = 1;
                            } else {
                                obecnieSprawdzaWartosc = obecnePole.wartosc + 1;
                            }
                        }
                    }
                }
                if (obecnePole.wartosc == rozmiar) {
                    obecnieSprawdzaWartosc = 1;
                } else {
                    obecnieSprawdzaWartosc = obecnePole.wartosc + 1;
                }

            obecnePole = obecnePole.nastepnePole;
            obecnyNumerPola++;
        }
        return true;
    }

    public void usunDostepneCyfry(int i, int j) {
        for (int k = j + 1; k < rozmiar + 1; k++) {
            plansza[i][k].dostepneNumeryRzad[plansza[i][j].wartosc] = false;
        }
        for (int k = i + 1; k < rozmiar + 1; k++) {
            plansza[k][j].dostepneNumeryKolumna[plansza[i][j].wartosc] = false;
        }
        if (goraDol[0][j] != 0) {
            int najwiekszaWatosc = plansza[1][j].wartosc;
            int ileWidac = 1;
            for (int k = 2; k <= i; k++) {
                if (najwiekszaWatosc < plansza[k][j].wartosc) {
                    ileWidac++;
                    najwiekszaWatosc = plansza[k][j].wartosc;
                }
            }
            if (ileWidac == goraDol[0][j]) {
                for (int k = i + 1; k < rozmiar + 1; k++) {
                    for (int m = najwiekszaWatosc; m < rozmiar + 1; m++)
                        plansza[k][j].dostepneNumeryGora[m] = false;
                }
            }
        }
        if (lewaPrawa[i][0] != 0) {
            int najwiekszaWartosc = plansza[i][1].wartosc;
            int ileWidac = 1;
            for (int k = 2; k <= j; k++) {
                if (najwiekszaWartosc < plansza[i][k].wartosc) {
                    ileWidac++;
                    najwiekszaWartosc = plansza[i][k].wartosc;
                }
            }
            if (ileWidac == lewaPrawa[i][0]) {
                for (int k = j + 1; k < rozmiar + 1; k++) {
                    for (int m = najwiekszaWartosc; m < rozmiar + 1; m++)
                        plansza[i][k].dostepneNumeryLewo[m] = false;
                }

            }
        }
    }

    public void przywrocDostepneCyfry(int i, int j) {
        for (int k = j + 1; k < rozmiar + 1; k++) {
            plansza[i][k].dostepneNumeryRzad[plansza[i][j].wartosc] = true;
        }
        for (int k = i + 1; k < rozmiar + 1; k++) {
            plansza[k][j].dostepneNumeryKolumna[plansza[i][j].wartosc] = true;
        }
        if (goraDol[0][j] != 0) {
            int najwiekszaWatosc = plansza[1][j].wartosc;
            int ileWidac = 1;
            for (int k = 2; k <= i; k++) {
                if (najwiekszaWatosc < plansza[k][j].wartosc) {
                    ileWidac++;
                    najwiekszaWatosc = plansza[k][j].wartosc;
                }
            }
            if (ileWidac == goraDol[0][j]) {
                for (int k = i + 1; k < rozmiar + 1; k++) {
                    for (int m = najwiekszaWatosc; m < rozmiar + 1; m++)
                        plansza[k][j].dostepneNumeryGora[m] = true;
                }
            }
        }
        if (lewaPrawa[i][0] != 0) {
            int najwiekszaWartosc = plansza[i][1].wartosc;
            int ileWidac = 1;
            for (int k = 2; k <= j; k++) {
                if (najwiekszaWartosc < plansza[i][k].wartosc) {
                    ileWidac++;
                    najwiekszaWartosc = plansza[i][k].wartosc;
                }
            }
            if (ileWidac == lewaPrawa[i][0]) {
                for (int k = j + 1; k < rozmiar + 1; k++) {
                    for (int m = najwiekszaWartosc; m < rozmiar + 1; m++)
                        plansza[i][k].dostepneNumeryLewo[m] = true;
                }

            }
        }
    }

    public boolean sprawdzCzyJakiesDostepne(int i, int j)
    {
        for (int k = j + 1; k < rozmiar + 1; k++) {
                int indeksSprawdzaniaDostepnosci = 1;
                while (indeksSprawdzaniaDostepnosci < rozmiar + 1 && (!plansza[i][k].dostepneNumeryRzad[indeksSprawdzaniaDostepnosci] || !plansza[i][k].dostepneNumeryKolumna[indeksSprawdzaniaDostepnosci] || !plansza[i][k].dostepneNumeryGora[indeksSprawdzaniaDostepnosci] || !plansza[i][k].dostepneNumeryLewo[indeksSprawdzaniaDostepnosci])) {
                    indeksSprawdzaniaDostepnosci++;
                }
                if (indeksSprawdzaniaDostepnosci > rozmiar) {
                    return false;
                }
            }
        
        for (int k = i + 1; k < rozmiar + 1; k++) {
                int indeksSprawdzaniaDostepnosci = 1;
                while (indeksSprawdzaniaDostepnosci < rozmiar + 1 && (!plansza[k][j].dostepneNumeryRzad[indeksSprawdzaniaDostepnosci] || !plansza[k][j].dostepneNumeryKolumna[indeksSprawdzaniaDostepnosci] || !plansza[k][j].dostepneNumeryGora[indeksSprawdzaniaDostepnosci] || !plansza[k][j].dostepneNumeryLewo[indeksSprawdzaniaDostepnosci])) {
                    indeksSprawdzaniaDostepnosci++;
                }
                if (indeksSprawdzaniaDostepnosci > rozmiar) {
                    return false;
                }
            }
        return true;
    }

    public boolean sprawdzanieWprzod()
    {
        int obecnyNumerPola = 1;
        PoleSky obecnePole = plansza[1][1];
        int obecnieSprawdzaWartosc = 0;
        int dostepneSprawdzenia = rozmiar;
        while(obecnyNumerPola <= rozmiar*rozmiar) {
            boolean sprawdzWartoscPola = false;
                while (!sprawdzWartoscPola) {
                    while (!sprawdzWartoscPola && obecnePole.sprawdzoneCyfry < dostepneSprawdzenia) {
                        liczbaIteracji++;
                        int indeksDostepnosci = obecnieSprawdzaWartosc + 1;
                        if(indeksDostepnosci == rozmiar + 1)
                        {
                            indeksDostepnosci = 1;
                        }
                        while(!obecnePole.dostepneNumeryRzad[indeksDostepnosci] || !obecnePole.dostepneNumeryKolumna[indeksDostepnosci] || !obecnePole.dostepneNumeryGora[indeksDostepnosci] || !obecnePole.dostepneNumeryLewo[indeksDostepnosci])
                        {
                            indeksDostepnosci++;
                            if(indeksDostepnosci == rozmiar + 1)
                            {
                                indeksDostepnosci = 1;
                            }
                        }
                        obecnieSprawdzaWartosc = indeksDostepnosci;
                        obecnePole.wartosc = obecnieSprawdzaWartosc;
                        obecnePole.sprawdzoneCyfry++;
                        int indeksI = obecnePole.nrPola / 10;
                        int indeksJ = obecnePole.nrPola % 10;
                        usunDostepneCyfry(indeksI, indeksJ);
                        if (sprawdzCzyJakiesDostepne(indeksI, indeksJ) && sprawdzPrawa(indeksI, indeksJ) && sprawdzDol(indeksI, indeksJ)) {
                            sprawdzWartoscPola = true;
                        }
                        else
                        {
                            indeksI = obecnePole.nrPola / 10;
                            indeksJ = obecnePole.nrPola % 10;
                            przywrocDostepneCyfry(indeksI, indeksJ);
                        }
                    }
                    if (!sprawdzWartoscPola) {
                        if (obecnePole.numerWKolejnosci == 1 && obecnePole.sprawdzoneCyfry == rozmiar) {
                            return false;
                        } else {
                            int indeksI = obecnePole.nrPola / 10;
                            int indeksJ = obecnePole.nrPola % 10;
                            przywrocDostepneCyfry(indeksI, indeksJ);
                            obecnePole.wartosc = 0;
                            obecnePole.sprawdzoneCyfry = 0;
                            obecnePole = obecnePole.poprzedniePole;
                            dostepneSprawdzenia = 0;
                            for(int i = 1; i < rozmiar + 1; i++)
                            {
                                if(obecnePole.dostepneNumeryRzad[i] && obecnePole.dostepneNumeryKolumna[i] && obecnePole.dostepneNumeryGora[i] && obecnePole.dostepneNumeryLewo[i])
                                {
                                    dostepneSprawdzenia++;
                                }
                            }
                            indeksI = obecnePole.nrPola / 10;
                            indeksJ = obecnePole.nrPola % 10;
                            przywrocDostepneCyfry(indeksI, indeksJ);
                            obecnyNumerPola = obecnePole.numerWKolejnosci;
                            obecnieSprawdzaWartosc = obecnePole.wartosc;

                        }
                    }
                }
                obecnieSprawdzaWartosc = obecnePole.wartosc;

            if(obecnePole.numerWKolejnosci != rozmiar * rozmiar) {
                obecnePole = obecnePole.nastepnePole;
                dostepneSprawdzenia = 0;
                for(int i = 1; i < rozmiar + 1; i++)
                {
                    if(obecnePole.dostepneNumeryRzad[i] && obecnePole.dostepneNumeryKolumna[i] && obecnePole.dostepneNumeryGora[i] && obecnePole.dostepneNumeryLewo[i])
                    {
                        dostepneSprawdzenia++;
                    }
                }
            }

            obecnyNumerPola++;
        }
        return true;
    }

    public boolean sprawdzanieWprzodNajbardziejOgraniczona()
    {
        int obecnyNumerPola = 1;
        PoleSky obecnePole = plansza[1][1];
        obecnePole.uzyto = true;
        int obecnieSprawdzaWartosc = 0;
        int dostepneSprawdzenia = rozmiar;
        while(obecnyNumerPola <= rozmiar*rozmiar) {
            boolean sprawdzWartoscPola = false;
            while (!sprawdzWartoscPola) {
                while (!sprawdzWartoscPola && obecnePole.sprawdzoneCyfry < dostepneSprawdzenia) {
                    liczbaIteracji++;
                    int indeksDostepnosci = obecnieSprawdzaWartosc + 1;
                    if(indeksDostepnosci == rozmiar + 1)
                    {
                        indeksDostepnosci = 1;
                    }
                    while(!obecnePole.dostepneNumeryRzad[indeksDostepnosci] || !obecnePole.dostepneNumeryKolumna[indeksDostepnosci] || !obecnePole.dostepneNumeryGora[indeksDostepnosci] || !obecnePole.dostepneNumeryLewo[indeksDostepnosci])
                    {
                        indeksDostepnosci++;
                        if(indeksDostepnosci == rozmiar + 1)
                        {
                            indeksDostepnosci = 1;
                        }
                    }
                    obecnieSprawdzaWartosc = indeksDostepnosci;
                    obecnePole.wartosc = obecnieSprawdzaWartosc;
                    obecnePole.sprawdzoneCyfry++;
                    int indeksI = obecnePole.nrPola / 10;
                    int indeksJ = obecnePole.nrPola % 10;
                    usunDostepneCyfry(indeksI, indeksJ);
                    if (sprawdzCzyJakiesDostepne(indeksI, indeksJ) && sprawdzPrawa(indeksI, indeksJ) && sprawdzDol(indeksI, indeksJ)) {
                        sprawdzWartoscPola = true;
                    }
                    else
                    {
                        indeksI = obecnePole.nrPola / 10;
                        indeksJ = obecnePole.nrPola % 10;
                        przywrocDostepneCyfry(indeksI, indeksJ);
                    }
                }
                if (!sprawdzWartoscPola) {
                    if (obecnePole.numerWKolejnosci == 1 && obecnePole.sprawdzoneCyfry == rozmiar) {
                        return false;
                    } else {
                        int indeksI = obecnePole.nrPola / 10;
                        int indeksJ = obecnePole.nrPola % 10;
                        przywrocDostepneCyfry(indeksI, indeksJ);
                        obecnePole.wartosc = 0;
                        obecnePole.sprawdzoneCyfry = 0;
                        obecnePole.uzyto = false;
                        obecnePole = obecnePole.poprzedniePole;
                        dostepneSprawdzenia = 0;
                        for(int i = 1; i < rozmiar + 1; i++)
                        {
                            if(obecnePole.dostepneNumeryRzad[i] && obecnePole.dostepneNumeryKolumna[i] && obecnePole.dostepneNumeryGora[i] && obecnePole.dostepneNumeryLewo[i])
                            {
                                dostepneSprawdzenia++;
                            }
                        }
                        indeksI = obecnePole.nrPola / 10;
                        indeksJ = obecnePole.nrPola % 10;
                        przywrocDostepneCyfry(indeksI, indeksJ);
                        obecnyNumerPola--;
                        obecnieSprawdzaWartosc = obecnePole.wartosc;

                    }
                }
            }
            obecnieSprawdzaWartosc = obecnePole.wartosc;

            if(obecnePole.numerWKolejnosci != rozmiar * rozmiar) {
                PoleSky najlepszyWybor = plansza[1][1];
                PoleSky pomocniczaZmienna;
                int najmniejMozliwosci = 10;
                for(int i = 1; i < rozmiar + 1; i++) {
                    for (int j = 1; j < rozmiar + 1; j++) {
                        if (!plansza[i][j].uzyto) {
                            dostepneSprawdzenia = 0;
                            for (int m = 1; m < rozmiar + 1; m++) {
                                if (plansza[i][j].dostepneNumeryRzad[m] && plansza[i][j].dostepneNumeryKolumna[m] && plansza[i][j].dostepneNumeryGora[m] && plansza[i][j].dostepneNumeryLewo[m]) {
                                    dostepneSprawdzenia++;
                                }
                            }
                            if (dostepneSprawdzenia < najmniejMozliwosci ) {
                                najmniejMozliwosci = dostepneSprawdzenia;
                                najlepszyWybor = plansza[i][j];
                            }
                        }
                    }
                }
                dostepneSprawdzenia = najmniejMozliwosci;
                pomocniczaZmienna = obecnePole;
                obecnePole.nastepnePole = najlepszyWybor;
                obecnePole = obecnePole.nastepnePole;
                obecnePole.poprzedniePole = pomocniczaZmienna;
                obecnePole.uzyto =  true;


            }

            obecnyNumerPola++;
        }
        return true;
    }
}
