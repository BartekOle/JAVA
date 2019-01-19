
public class Comparator1 implements Comparator  {

	public static final Comparator1 INSTANCE = new Comparator1();

    public Comparator1() 
    { 
    }

	public int compare(Object left, Object right)  throws ClassCastException 
	{ return ((Osoba)left).porNazw((Osoba)right); }

}
