import java.util.Scanner;

public class StosOgr {
	public Object tablica[];
	public int n;
	
	public StosOgr(int size)
	{
		tablica = new Object[size];
		n = -1;
	}
	public  void push(Object value) throws IndexOutOfBoundsException
	{
	   if(n >= tablica.length-1)
	   {
		   System.out.println("Nie mo¿na dodaæ elementu, poniewa¿ stos jest pe³ny");
	   }
	   else
	   {
		   n++;
	   tablica[n] = value;
	 
	   }
	}
	
	public  Object pop() throws EmptyStackException {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        Object temp = tablica[n];
        tablica[n] = null;
        n--;
        return temp;
	}
	
	public  Object peak() throws EmptyStackException {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
      
        return tablica[n];
	}
	
	public boolean isEmpty() throws EmptyStackException
    { if(n == -1)
        throw new EmptyStackException();
     return false;
     }
	
	public void clear() {
		for(int i = 0; i <= n; i++)
		{
			tablica[i] = null;
		}
        n = -1;
    }
	
	public void wyswietl() {
	for(int i = 0; i <= n; i++)
	{
		
	}
	}
	
	public static void main(String[] args) {
        
		String napis = "";
		String pom = "";
		Scanner odcz = new Scanner(System.in);
		System.out.println("Podaj napis: ");
		while(!pom.equals("end"))
		{
			pom = odcz.nextLine();
			
			if(!pom.equals("end"))
			{
			napis += pom;
			napis += " ";
			}
			
		}
		int a = 0;
		Scanner odczy1 = new Scanner(napis);
		while(odczy1.hasNext())
		{
			odczy1.next();
			a++;
		}
    	StosOgr grupa = new StosOgr(a);
    	Scanner odczy2 = new Scanner(napis);
    	while(odczy2.hasNext())
		{
			String temp = odczy2.next();
			grupa.push(new String(temp));
			
		}

    	
    	while(grupa.n > -1)
    	{
    		System.out.print((String)grupa.pop() + " ");
    	}
    
    }
}
