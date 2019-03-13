public class Przedmiot implements Comparable<Przedmiot> {
    int index;
    int wartosc;
    int waga;
    int idmiasta;
    boolean wziety;

    public Przedmiot(int index, int wartosc, int waga, int idmiasta)
    {
        this.index = index;
        this.wartosc = wartosc;
        this.waga = waga;
        this.idmiasta = idmiasta;
        wziety = false;

    }

    public String toString()
    {
        return "index: " +  index + " wartosc: " + wartosc + " waga: " + waga + " idmiasta: " + idmiasta;
    }

    public Double getProfit() {
        return (double) wartosc/waga;
    }

    @Override
    public int compareTo(Przedmiot p) {
        if (getProfit() == null || p.getProfit() == null) {
            return 0;
        }
        return getProfit().compareTo(p.getProfit());
    }
}
