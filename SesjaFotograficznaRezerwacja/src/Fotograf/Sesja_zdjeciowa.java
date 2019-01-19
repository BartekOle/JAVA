package Fotograf;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Sesja_zdjeciowa {
	
	public enum Kolor_zdjec {
		CzarnoBiale, kolorowe;
	}
	
	public Date data;
	public Kolor_zdjec kolorZdjec;
	public String miejsceWykonania;
	public Dane_kontaktowe daneKlienta;
	public Dane_podstawowe fotograf;
	public Fotograf danefotografa;
	public Klient klient;
	public Rachunek rachunek;
	
	public Sesja_zdjeciowa()
	{
		this.data = null;
		this.kolorZdjec = null;
		this.miejsceWykonania = null;
		this.daneKlienta = null;
		this.fotograf = null;
		this.danefotografa = null;
		this.klient = null;
		this.rachunek = null;
	}
	
	public Sesja_zdjeciowa(Date data, Kolor_zdjec kolorZdjec, String miejsceWykonania, Dane_kontaktowe daneKlienta, Dane_podstawowe fotograf, Fotograf danefotografa, Klient klient, Rachunek rachunek)
	{
		this.data = data;
		this.kolorZdjec = kolorZdjec;
		this.miejsceWykonania = miejsceWykonania;
		this.daneKlienta = daneKlienta;
		this.fotograf = fotograf;
		this.danefotografa = danefotografa;
		this.klient = klient;
		this.rachunek = rachunek;
	}
	
	public Sesja_zdjeciowa(Date data, Kolor_zdjec kolorZdjec, String miejsceWykonania, Dane_kontaktowe daneKlienta, Dane_podstawowe fotograf)
	{
		this.data = data;
		this.kolorZdjec = kolorZdjec;
		this.miejsceWykonania = miejsceWykonania;
		this.daneKlienta = daneKlienta;
		this.fotograf = fotograf;
	}
	
	public void addDate(String dateString) throws ParseException
	{
		 
    	 SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
		 this.data = dateFormat.parse(dateString);
	}
	
	public boolean correctdate(Date data)
	{
		Date currendate = new Date();
		return data.after(currendate);
	}

}
