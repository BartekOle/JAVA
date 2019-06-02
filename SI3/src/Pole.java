import java.util.ArrayList;

public class Pole {

    int numerPola;
    String pionek;
    ArrayList<Integer> sasiedzi;

    public Pole(int numerPola)
    {
        this.numerPola = numerPola;
        pionek = "Brak";
        this.sasiedzi = new ArrayList<Integer>();
    }
}
