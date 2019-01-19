
public class ComparZbiorczy implements Comparator  {

	public static final ComparZbiorczy INSTANCE = new ComparZbiorczy();

    public ComparZbiorczy() 
    { 
    }

	public int compare(Object left, Object right)  throws ClassCastException 
	{  int pom = ((Osoba)left).porNazw((Osoba)right);
	   
		if(pom == 0)
		{
			pom = ((Osoba)left).porImie((Osoba)right);
			if(pom == 0)
			{
				pom = ((Osoba)left).porWiek((Osoba)right);
			}
			
		}
		return pom;
		}

}
