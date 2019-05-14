import java.util.ArrayList;

public class PoleFuto {
    int wartosc;
    int nrPola;
    int numerWKolejnosci;
    PoleFuto nastepnePole;
    PoleFuto poprzedniePole;
    boolean dostepneNumery[];
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
        this.dostepneNumery = new boolean[rozmiar+1];
        if(wartosc != 0)
        {
            this.naStale = true;
        }
        else {
            for (int i = 1; dostepneNumery.length < rozmiar + 1; i++) {
                this.dostepneNumery[i] = true;
            }
            this.naStale = false;
        }
    }
}
