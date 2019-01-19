public class InsertSort  {
  
    private static Comparator comparator;

    public InsertSort(Comparator c)  { comparator = c; }

    
    public static Osoba[] sort(Osoba[] tab) {
        for (int i = 1; i < tab.length; ++i) {
            Osoba value = tab[i];
            int j = i;
            Osoba temp;
            for (j = i; j > 0 && comparator.compare(value, tab[j-1])< 0; --j)
               tab[j] = tab[j-1];
            tab[j] = value;
        }
        return tab;
    }
    
    
        
      
        
    
    
}