
public class Proces {
double start;
double doZrobienia;
double oczekiwanie;
double pomocnicza; 




public Proces (double h, double g){
	this.start = h;
	this.doZrobienia =g;
	this.oczekiwanie = 0;
	this.pomocnicza = g;
	
}
public String toString(){
	return("Do zrobienia: "+this.doZrobienia + "   Czas oczekiwania: "+this.oczekiwanie + "   Start: " +this.start);
}
}
