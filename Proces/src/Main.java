import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class Main {
	public static void main (String[] args ) throws FileNotFoundException{
		
		
		Scanner sc = new Scanner(System.in);
		int a = 0;
		Scanner wej1 = new Scanner(new FileReader("dane.txt"));
		
		while(wej1.hasNextLine())
	    {
			 Proces p = new Proces(Integer.parseInt(wej1.next()), Integer.parseInt(wej1.next()));
	       a++;
	    		   }
		
		System.out.println("Podaj d³ugoœæ kwantu");
		int kwant = sc.nextInt();
		sc.close();
		
		
			Procesy fcfs = new Procesy(a);
			//System.out.println(System.lineSeparator()+"Przed:");
            //fcfs.drukuj();
			fcfs.fcfs();
			//System.out.println(System.lineSeparator()+ "Po:");
            //fcfs.drukuj();
            System.out.println("Sredni czas dla fcfs wynosi: " + fcfs.sredniczas());
		
		
		
		
		
		
			Procesy sjf = new Procesy(a);
		//System.out.println(System.lineSeparator()+"Przed:");
			////sjf.drukuj();
			sjf.sjf();
			//System.out.println(System.lineSeparator()+ "Po:");
			//sjf.drukuj();
			 System.out.println("Sredni czas dla sjf wynosi: " + sjf.sredniczas());
		
		
		
		Procesy sjfw= new Procesy(a);
		//System.out.println(System.lineSeparator()+"Przed:");
		//sjfw.drukuj();
		sjfw.sjfw();
		//System.out.println(System.lineSeparator()+ "Po:");
	//sjfw.drukuj();
		System.out.println("Sredni czas dla sjfw wynosi: " + sjfw.sredniczas());
		
	
	
	
		Procesy rr= new Procesy(a);
	//System.out.println(System.lineSeparator()+"Przed:");
	//rr.drukuj();
		rr.rr(kwant);
	//System.out.println(System.lineSeparator()+ "Po:");
		//rr.drukuj();
      System.out.println("Sredni czas dla rr wynosi: " + rr.sredniczas());
	
	
	
	}
	}


