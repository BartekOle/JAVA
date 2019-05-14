import java.util.ArrayList;

public class PoleFuto {
    protected int wartosc;
    protected int nrPola;
    protected int numerWKolejnosci;
    protected PoleFuto nastepnePole;
    protected PoleFuto poprzedniePole;
    protected  boolean dostepneNumeryRzad[];
    protected boolean dostepneNumeryKolumna[];
    protected boolean dostepneNumeryWieksze[];
    protected boolean dostepneNumeryMniejsze[];
    protected ArrayList<PoleFuto> mniejsze;
    protected ArrayList<PoleFuto> wieksze;
    protected boolean naStale;
    protected int sprawdzoneCyfry;
    protected boolean uzyto;
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
        if(wartosc != 0)
        {
            this.naStale = true;
            this.uzyto = true;
        }
        else {
            for (int i = 1; i < rozmiar + 1; i++) {
                this.dostepneNumeryRzad[i] = true;
                this.dostepneNumeryKolumna[i] = true;
                this.dostepneNumeryMniejsze[i] = true;
                this.dostepneNumeryWieksze[i] = true;
            }
            this.naStale = false;
            this.uzyto = false;
        }
    }
}
