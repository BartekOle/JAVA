
public class Comparator3 implements Comparator  {

	public static final Comparator3 INSTANCE = new Comparator3();

    public Comparator3() 
    { 
    }

	public int compare(Object left, Object right)  throws ClassCastException 
	{ return ((Osoba)left).porWiek((Osoba)right); }

}
