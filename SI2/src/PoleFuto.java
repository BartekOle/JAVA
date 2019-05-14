import java.util.ArrayList;

public class PoleFuto {
    int wartosc;
    int nrPola;
    int numerWKolejnosci;
    PoleFuto nastepnePole;
    PoleFuto poprzedniePole;
    boolean dostepneNumeryRzad[];
    boolean dostepneNumeryKolumna[];
    boolean dostepneNumeryWieksze[];
    boolean dostepneNumeryMniejsze[];
    boolean dostepneNumeryWieksze2[];
    boolean dostepneNumeryMniejsze2[];
    ArrayList<PoleFuto> mniejsze;
    ArrayList<PoleFuto> wieksze;
    boolean naStale;
    int sprawdzoneCyfry;
    public PoleFuto(int wartosc, int nrPola, int numerWKolejnosci, int rozmiar)
    {
        mniejsze = new ArrayList<PoleFuto>();
        wieksze = new ArrayList<PoleFuto>();
        this.sprawdzoneCyfry = 0;
        this.wartosc = wartosc;
        this.nrPola = nrPola;
        this.numerWKolejnosci = numerWKolejnosci;
        this.dostepneNumeryRzad = new boolean[rozmiar+1];
        this.dostepneNumeryKolumna = new boolean[rozmiar+1];
        this.dostepneNumeryMniejsze = new boolean[rozmiar+1];
        this.dostepneNumeryWieksze = new boolean[rozmiar+1];
        this.dostepneNumeryMniejsze2 = new boolean[rozmiar+1];
        this.dostepneNumeryWieksze2 = new boolean[rozmiar+1];
        if(wartosc != 0)
        {
            this.naStale = true;
        }
        else {
            for (int i = 1; i < rozmiar + 1; i++) {
                this.dostepneNumeryRzad[i] = true;
                this.dostepneNumeryKolumna[i] = true;
                this.dostepneNumeryMniejsze[i] = true;
                this.dostepneNumeryWieksze[i] = true;
                this.dostepneNumeryMniejsze2[i] = true;
                this.dostepneNumeryWieksze2[i] = true;
            }
            this.naStale = false;
        }
    }
}
