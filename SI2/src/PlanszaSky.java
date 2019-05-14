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
        rozmiar = Integer.parseInt(line);
        plansza = new PoleSky[rozmiar + 1][rozmiar + 1];
        GoraDol = new int[2][rozmiar + 1];
        LewaPrawa = new int[rozmiar + 1][2];
        String[] split;
        for (int i = 0; i < 2; i++) {
            line = br.readLine();
            split = line.split(";");
            for (int j = 1; j < rozmiar + 1; j++) {
                GoraDol[i][j] = Integer.parseInt(split[j]);
            }
        }
        for (int i = 0; i < 2; i++) {
            line = br.readLine();
            split = line.split(";");
            for (int j = 1; j < rozmiar + 1; j++) {
                LewaPrawa[j][i] = Integer.parseInt(split[j]);
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
        if (GoraDol[0][j] == 0) {
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
            if (ileWidac > GoraDol[0][j] && i == rozmiar) {
                return false;
            }
            else if(ileWidac == GoraDol[0][j])
            {
                return true;
            }
            else
            {
                if(ileWidac + (rozmiar - i) >= GoraDol[0][j])
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

        if (GoraDol[1][j] == 0) {
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
            if (ileWidac > GoraDol[1][j] && i == rozmiar) {
                return false;
            }
            else if(ileWidac == GoraDol[1][j])
            {
                return true;
            }
            else
            {
                if(ileWidac + (rozmiar - i) >= GoraDol[1][j])
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

        if (LewaPrawa[i][0] == 0) {
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
            if (ileWidac > LewaPrawa[i][0] && j == rozmiar) {
                return false;
            }
            else if(ileWidac == LewaPrawa[i][0])
            {
                return true;
            }
            else
            {
                if(ileWidac + (rozmiar - j) >= LewaPrawa[i][0])
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

        if (LewaPrawa[i][1] == 0) {
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
            if (ileWidac > LewaPrawa[i][1] && j == rozmiar) {
                return false;
            }
            else if(ileWidac == LewaPrawa[i][1])
            {
                return true;
            }
            else
            {
                if(ileWidac + (rozmiar - j) >= LewaPrawa[i][1])
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
}
