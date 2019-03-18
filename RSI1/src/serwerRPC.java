///Bartłomiej Olejniczak 238338

import org.apache.xmlrpc.WebServer;
import java.util.ArrayList;

import java.util.List;
import java.util.Vector;

public class serwerRPC {

    public static void main(String[] args) {

        try{
            System.out.println("Startuje serwer XML-RPC...");
            int port = 10012;
            WebServer server = new WebServer(port);
            server.addHandler("MojSerwer",new serwerRPC());
            server.start();
            System.out.println("Serwer wystartowal pomyslnie.");
            System.out.println("Nasluchuje na porcie: " + port);
            System.out.println("Aby zatrzymać serwer nacisnij crl+c");
        } catch(Exception exception) {
            System.err.println("Serwer XML-RPC: " + exception);
        }

    }

    public Integer echo(int x, int y)
    {
        return new Integer(x+y);

    }

    public int execAsy(int x) {
        System.out.println("... wywołano asy - odliczam");
        try {
            Thread.sleep(x);
        } catch(InterruptedException ex) {
            ex.printStackTrace();
            Thread.currentThread().interrupt();
        }
        System.out.println(".. asy - koniec odbliczania");
        return (123);
    }

    public String daneOsobowe(int x, String y) {
        String wynik = "Imie uzytkownika: " + y  + " Wiek uzytkownika: " + x;
        return wynik;
    }

    public double poleTrojkata(double x, double y) {
        return x*y/2;
    }

    public double pierwiastek(double liczba, int x) {
        System.out.println("... wywołano asy - odliczam");
        try {
            Thread.sleep(x);
        } catch(InterruptedException ex) {
            ex.printStackTrace();
            Thread.currentThread().interrupt();
        }
        System.out.println(".. asy - koniec odbliczania");
        return (Math.sqrt(liczba));
    }

    public int najwiekszaLiczba(Integer[] tab) {
        int najwieksza = tab[0];
        for (int i = 1; i < tab.length; i++)
        { if (tab[0] > najwieksza)
        {
            najwieksza = tab[0];
        }
        }
        return najwieksza;
    }
    public String show(int i)
    {
        String wynik = "Dostepne metody to echo(Testowa metoda z cwiczenia 1, dajaca wynik dodawania, Parametry(int, int)), execAsy(test wywolania asynchronicznego, Parametr(int)), daneOsobowe(wyswietlenie imienia i wieku uzytkownika, Paramety(int, String)), poleTrojkata(Oblicza pole trojkata z danych podanych przez uzytkownika, Parametry(double, double)), pierwiastek(Oblicza asynchronicznie pierwiastek z liczby podanej przez uzytkownik, Paramery(double, int)), jesli chcesz zakonczyc wywolywnaie wpisz zero";
        return wynik;
    }

}
