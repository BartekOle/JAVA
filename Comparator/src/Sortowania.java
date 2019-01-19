
public class Sortowania {
	
	public static int[] InterSort(int[] tab) {
		int pods = 0;
    	int por = 1;
        for (int i = 1; i < tab.length; ++i) {
        	
            int pom = tab[i];
            pods++;
             int j;
            for (j = i; j > 0 && tab[j-1] > pom; --j)
            {
               tab[j] = tab[j-1];
               pods++;
               por++;
            }
            tab[j] = pom;
            pods++;
            por++;
        }
        System.out.println("Porownan w InsertSort wykonalo sie: " + por + " Natomiast podstawien: " + pods);
        return tab;
    }
	
	public static void main(String[] args)
    {
      int[] tab = new int[4];
      tab[0] = 5;
      tab[1] = 3;
      tab[2] = 10;
      tab[3] = 1;
      InterSort(tab);
      for(int i = 0; i < tab.length; i++)
      {
    	  System.out.println(tab[i]);
      }
    }
    

}
