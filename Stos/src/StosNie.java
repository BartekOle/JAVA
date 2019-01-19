import java.util.Scanner;

public class StosNie {

	public  int size;
	public Element first = null;
	
	public StosNie()
	{
		clear();
	}
	
	public  void push(Object value) throws IndexOutOfBoundsException
	{
 
		
		if(first == null)
		{
			 Element temp = new Element(value);
		     first = temp;
		     size++;
		}
		else
		{
			Element element = first;
	        Element temp = new Element(value);
		while(element.getNext() != null)
            element = element.getNext();
        element.setNext(temp);
        size++;
		}
	
	
	}
	
	public  Object pop() throws EmptyStackException {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        Element temp;
        if(size == 1)
        {
        	temp = first;
        	first = null;
        	size--;
        }
        else
        {
        Element element = first;
        while(element.getNext().getNext() != null)
            element = element.getNext();
         temp = element.getNext();
        element.setNext(null);
        size--;
        }
        return temp;
    }
	
	public  Object peek() throws EmptyStackException {
		 if (isEmpty()) {
	            throw new EmptyStackException();
	        }
	        Element temp;
	        if(size == 1)
	        {
	        	temp = first;
	        }
	        else
	        {
	        Element element = first;
	        while(element.getNext().getNext() != null)
	            element = element.getNext();
	         temp = element.getNext();
	        
	      
	        }
	        return temp;

    }

	public void clear() {
		first = null;
        size = 0;
    }
	
	public boolean isEmpty() throws EmptyStackException
    { if(first == null)
        throw new EmptyStackException();
     return false;
     }
	
    public  int size() 
    {   return size;
    }
      public void wyswietl() {
    	  if (isEmpty()) {
              throw new EmptyStackException();
          }
        Element temp = first;
        int i = size();
        while(i>0){
        	Student stu = (Student)temp.getValue();
        	 System.out.println(stu.indeks + " " + stu.nazwisko + " " + stu.imie + " " + stu.ocena);
            temp = temp.getNext();
            i--;
        }
      }
        public static void main(String[] args) {
        
        	StosNie grupa = new StosNie();
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
    		Scanner odczy2 = new Scanner(napis);
        	while(odczy2.hasNext())
    		{
    			String temp = odczy2.next();
    			grupa.push(new String(temp));
    			
    		}

        	
        	while(grupa.size > 0)
        	{
        		Element temp = (Element) grupa.pop();
        		System.out.print((String)temp.getValue() + " ");
        	}
        	
        	grupa.push(new Student(152478,"Kowalski","Jan",3.5));
        	   grupa.push(new Student(123478,"Jankowski","Adam",4.0)); 
		    grupa.wyswietl();
		    grupa.pop();
		    grupa.wyswietl();
		    grupa.push(new Student(451237,"Nowak","Anna",4.5)); 
		    grupa.wyswietl();
		    Element temp = (Element) grupa.peek();
		    Student stu = (Student)temp.getValue();
		    System.out.println("Element na gorze stosu to: " + stu.indeks + " " + stu.nazwisko + " " + stu.imie + " " + stu.ocena);
		    grupa.wyswietl();
		    grupa.clear();
		    grupa.wyswietl();
        }
        
      }
