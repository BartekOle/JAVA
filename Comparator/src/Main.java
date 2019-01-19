
public class Main {

	public static void main(String[] args)
    {
    	
        Osoba[] tablica = new Osoba[6];
        tablica[0] = new Osoba("Kowalski", "Jan", 35);
        tablica[1] = new Osoba("Kowalski", "Jan", 25);
        
        tablica[2] = new Osoba("Kowalski", "Dominik", 15);
        tablica[3] = new Osoba("Dabrowski", "Marek", 10);
        tablica[4] = new Osoba("Kaminski", "Rafal", 12);
        tablica[5] = new Osoba("Jankowski", "Jan", 25);
        System.out.println("Tablica w kolejnoœci wpisania");
        for(int i = 0;i<tablica.length;i++){
            System.out.println(tablica[i]);
        }
        CompoundComparator test2 = new CompoundComparator();
        test2.addComparator(Comparator1.INSTANCE);
        test2.addComparator(Comparator2.INSTANCE);
        test2.addComparator(Comparator3.INSTANCE);
        InsertSort test = new InsertSort(test2);
        test.sort(tablica);
        System.out.println("Tablica posortowana:");
        for(int i = 0;i<tablica.length;i++){
            System.out.println(tablica[i]);
        }
}
}
