import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class Procesy {
Proces tablica[];
int m = 0;

public Procesy (int a) throws FileNotFoundException{
	this.tablica = new Proces [a];
	 
	Scanner wej = new Scanner(new FileReader("dane.txt"));
	int i = 0;
	while(wej.hasNextLine())
    {
       Proces test = new Proces(Double.parseDouble(wej.next()), Double.parseDouble(wej.next()));
       tablica[i] = test;
       i++;
    		   }
}
public void drukuj (){
	for(int i = 0;i<this.tablica.length;i++){
		System.out.println(this.tablica[i]);
		}
	}
public double sredniczas (){
	double m = 0;
	for(int i = 0;i<this.tablica.length;i++){
		m=m+this.tablica[i].oczekiwanie;
	}
	return m/this.tablica.length;
	}
public void fcfs(){
	double uplynelo = this.tablica[0].start;
	
		
		for(int i=0;i<this.tablica.length-1;i++){
			Boolean policzono = false;
			while(policzono == false)
			{
			if(this.tablica[i].doZrobienia>0 && uplynelo >= this.tablica[i].start){
				
					
					if(uplynelo + this.tablica[i].doZrobienia < this.tablica[i+1].start)
					{
						policzono = true;
						uplynelo = uplynelo + this.tablica[i].doZrobienia; 
						this.tablica[i].doZrobienia = 0;
					}
				
					else{
						while(uplynelo < this.tablica[i+1].start)
						{
							this.tablica[i].doZrobienia--;
							uplynelo++;
						}
						if(this.tablica[i+1].start - this.tablica[i].start >=  this.tablica[i].oczekiwanie)
						{
							this.tablica[i+1].oczekiwanie = this.tablica[i].doZrobienia;
							uplynelo = uplynelo + this.tablica[i].doZrobienia;
							this.tablica[i].doZrobienia = 0;
							policzono = true;
						}
						else{
						this.tablica[i+1].oczekiwanie = this.tablica[i].doZrobienia + this.tablica[i].oczekiwanie - (this.tablica[i+1].start - this.tablica[i].start  );
						uplynelo = uplynelo + this.tablica[i].doZrobienia;
						this.tablica[i].doZrobienia = 0;
						policzono = true;
						}
						
					}
		
			}
			else if(uplynelo < this.tablica[i].start){
				uplynelo = this.tablica[i].start;
			}
			else if(this.tablica[i].doZrobienia==0 && uplynelo == this.tablica[i].start)
			{
				policzono = true;
			}
			
			}
			}
	}

	
		



public Boolean czyCzeka(){
	Boolean czyCzeka=false;
	for(int i=0;i<tablica.length;i++){
		if (tablica[i].doZrobienia>0 && tablica[i].start==0){
			czyCzeka=true;
		}
	}
	return czyCzeka;
}
public boolean czyKoniec(){
	boolean koniec = true;
	for(int i=0; i<tablica.length;i++){
		if(tablica[i].doZrobienia > 0){
			koniec = false;
		}
	}
	return koniec;
}

public void jeslikonczy(double o, int i, double z){
	if(this.tablica[i].doZrobienia <= z)
	{
		this.tablica[i].oczekiwanie = o - this.tablica[i].pomocnicza - this.tablica[i].start; 
	}
}
public int najkrotszy(){
	int A=0;
	for(int i = 0; i<tablica.length;i++){
		if(tablica[i].doZrobienia >0 && tablica[i].start == 0){
			A=i;
		}
	}
	for(int i = 0; i<tablica.length;i++){
		if((tablica[i].doZrobienia < tablica[A].doZrobienia) && (tablica[i].start == 0) && (tablica[i].doZrobienia>0)){
			A=i;
		}
	}
	return A;
}
public void sjf(){
	while (this.czyKoniec()==false){
		if(this.czyCzeka()==true){
			int A = this.najkrotszy();
				while(tablica[A].doZrobienia > 0){
					for(int i=0;i<tablica.length;i++){
						if(this.tablica[i].start == 0 && this.tablica[i].doZrobienia > 0){
							this.tablica[i].oczekiwanie++;}
						if(this.tablica[i].start > 0){
							this.tablica[i].start--;}
					}
						this.tablica[A].doZrobienia--;
						this.tablica[A].oczekiwanie--;
					}
				}
		else{
			for(int i=0;i<tablica.length;i++){
				if(this.tablica[i].start>0){
				this.tablica[i].start--;}
			}
		}
		}
}
public void sjfw(){
	while (this.czyKoniec()==false){
		if(this.czyCzeka()==true){
			int A = this.najkrotszy();
			for(int i=0;i<tablica.length;i++){
				if(this.tablica[i].start == 0 && this.tablica[i].doZrobienia > 0){
					this.tablica[i].oczekiwanie++;}
				if(this.tablica[i].start > 0){
					this.tablica[i].start--;}
			}
				this.tablica[A].doZrobienia--;
				this.tablica[A].oczekiwanie--;
			
			}
		else{
			for(int i=0;i<tablica.length;i++){
				if(this.tablica[i].start>0){
				this.tablica[i].start--;}
			}
	}
	}
}

public void rr(double k){
	double uplynelo = this.tablica[0].start;
    double oczekiwanie = 0;
	while (this.czyKoniec()==false){
	
		for(int i=0;i<this.tablica.length;i++){
			if(this.tablica[i].doZrobienia>0 && uplynelo >= this.tablica[i].start){
				if(this.tablica[i].doZrobienia >= k){
						uplynelo += k;
					    oczekiwanie = oczekiwanie + k;
						jeslikonczy(oczekiwanie, i, k);
						this.tablica[i].doZrobienia = this.tablica[i].doZrobienia - k;
						}
			         else
			         {
			        	    uplynelo += this.tablica[i].doZrobienia;
			        	    oczekiwanie += this.tablica[i].doZrobienia;
							jeslikonczy(oczekiwanie, i, k);
							this.tablica[i].doZrobienia = 0;
				            
							
							}
				         }
					}
		
			}
					
				
				   
			}
	

}



