import java.util.ArrayList;

public class Pole {

    protected int numerPola;
    protected String pionek;
    protected ArrayList<Integer> sasiedzi;

    public Pole(int numerPola)
    {
        this.numerPola = numerPola;
        pionek = "Brak";
        this.sasiedzi = new ArrayList<Integer>();
    }
}
