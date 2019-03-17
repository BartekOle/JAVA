import java.util.Random;

public class Osobnik {
    int [] trasa;
    int W;
    int Wc;
    double Vmax;
    double Vmin;

    public Osobnik(int W, double Vmax, double Vmin)
    {
        this.W = W;
        this.Wc = 0;
        this.Vmax = Vmax;
        this.Vmin = Vmin;
    }

    public void chromoson(int iloscmiast)
    {
        trasa = new int[iloscmiast+1];
        int pom[] = new int[iloscmiast+1];
        for(int i = 1; i < trasa.length; i++)
        {
            pom[i] = 0;
        }
        for(int i = 0; i < trasa.length-1; i++)
        {

            Random rand = new Random();
            int liczba = rand.nextInt(iloscmiast)+1;

           while(pom[liczba] != 0)
           {
               liczba = rand.nextInt(iloscmiast)+1;
           }


           trasa[i] = liczba;
           pom[liczba] = liczba;
        }
        trasa[trasa.length-1] = trasa[0];

    }

    public double obecnapredkosc()
    {
        double Vc = Vmax - Wc * ((Vmax - Vmin)/W);
        return Vc;
    }

    public double czas(double Vc, double d)
    {
        double t = d/Vc;
        return t;
    }


}
