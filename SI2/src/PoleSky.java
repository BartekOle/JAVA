public class PoleSky {
    int wartosc;
    int nrPola;
    int numerWKolejnosci;
    int sprawdzoneCyfry;
    PoleSky nastepnePole;
    PoleSky poprzedniePole;
    boolean dostepneNumery[];
    public PoleSky(int nrPola, int numerWKolejnosci, int rozmiar)
    {
        this.wartosc = 0;
        this.nrPola = nrPola;
        this.sprawdzoneCyfry = 0;
        this.numerWKolejnosci = numerWKolejnosci;
        this.dostepneNumery = new boolean[rozmiar+1];
        for (int i = 1; dostepneNumery.length < rozmiar + 1; i++) {
                this.dostepneNumery[i] = true;
        }
    }
}
