package Fotograf;

import java.util.*;

public class Lista {
	
	List<Sesja_zdjeciowa> lista1 = new ArrayList<Sesja_zdjeciowa>();
	List<Rachunek> lista2 = new ArrayList<Rachunek>();
	List<String> lista3 = new ArrayList<String>();
	List<String> lista4 = new ArrayList<String>();
	public int ilosc;
	
	public Lista()
	{
		ilosc  = 0;
	}
	
	public void addsesja(Sesja_zdjeciowa sesja, Rachunek rachunek, String klient, String fotograf)
	{
		lista1.add(sesja);
		lista2.add(rachunek);
		lista3.add(klient);
		lista4.add(fotograf);
		ilosc++;
	}

}
