


public class Osoba 
{
    
	
	
    String nazwisko;
     String imie;
     int wiek;

   
    public Osoba(String n, String im, int w)
    {
        nazwisko = n;
        imie = im;
        wiek = w;
    }
    
   

    
    public String toString() {
        return nazwisko + " "+ imie +" " + wiek;
    }
                
        public int porNazw(Osoba o) { return nazwisko.compareTo(o.nazwisko);
        }
        public int porImie(Osoba o) { return imie.compareTo(o.imie);
        }
        public int porWiek(Osoba o) { return wiek-o.wiek;}
}
