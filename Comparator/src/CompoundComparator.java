public class CompoundComparator implements Comparator {

    private final Comparator[] comparators;
    int n;
    
    public CompoundComparator()
    {
    	comparators = new Comparator[3]; 
    	n = 0;
    }

    public void addComparator(Comparator com) 
    {  
    	if(n >= 3)
    	{
    		System.out.println("Tablica jest pelna");
    	}
    	comparators[n] = com;
    	n++;
    }

    public int compare(Object left, Object right) throws ClassCastException {
        int result = 0;
        int i = 0;
       while(i < 3 && (result = comparators[i].compare(left, right))==0) 
    	 {
    	   i++;
    	 }
        return result;
    }
}
