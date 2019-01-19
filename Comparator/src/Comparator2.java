
public class Comparator2 implements Comparator  {

	public static final Comparator2 INSTANCE = new Comparator2();

    public Comparator2() 
    { 
    }

	public int compare(Object left, Object right)  throws ClassCastException 
	{ return ((Osoba)left).porImie((Osoba)right); }

}
