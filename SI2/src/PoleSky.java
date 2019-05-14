public class PoleSky {
    protected int wartosc;
    protected int nrPola;
    protected int numerWKolejnosci;
    protected int sprawdzoneCyfry;
    protected PoleSky nastepnePole;
    protected PoleSky poprzedniePole;
    protected boolean dostepneNumeryRzad[];
    protected boolean dostepneNumeryKolumna[];
    protected boolean dostepneNumeryGora[];
    protected boolean dostepneNumeryLewo[];
    protected boolean uzyto;
    public PoleSky(int nrPola, int numerWKolejnosci, int rozmiar)
    {
        uzyto = false;
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
