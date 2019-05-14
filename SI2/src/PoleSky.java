public class PoleSky {
    int wartosc;
    int nrPola;
    int numerWKolejnosci;
    int sprawdzoneCyfry;
    PoleSky nastepnePole;
    PoleSky poprzedniePole;
    boolean dostepneNumeryRzad[];
    boolean dostepneNumeryKolumna[];
    boolean dostepneNumeryGora[];
    boolean dostepneNumeryLewo[];
    public PoleSky(int nrPola, int numerWKolejnosci, int rozmiar)
    {
        this.wartosc = 0;
        this.nrPola = nrPola;
        this.sprawdzoneCyfry = 0;
        this.numerWKolejnosci = numerWKolejnosci;
        this.dostepneNumeryRzad = new boolean[rozmiar+1];
        this.dostepneNumeryKolumna = new boolean[rozmiar+1];
        this.dostepneNumeryGora = new boolean[rozmiar+1];
        this.dostepneNumeryLewo = new boolean[rozmiar+1];
        for (int i = 1; i < rozmiar + 1; i++) {
            this.dostepneNumeryRzad[i] = true;
            this.dostepneNumeryKolumna[i] = true;
            this.dostepneNumeryGora[i] = true;
            this.dostepneNumeryLewo[i] = true;
        }
    }
}
