package Fotograf;

import java.util.*;

public class Fotograf {
	
	public String login;
	public String haslo;
	public String imie;
	public String nazwisko;
	public String plec;
	public String email;
	public Date dataUrodzenia;
	public List<Sesja_zdjeciowa> listaSesji = new ArrayList<Sesja_zdjeciowa>();
	public int iloscSesji;
	
	public Fotograf()
	{
		
	}
	
	public void addsesja(Sesja_zdjeciowa sesja)
	{
		listaSesji.add(sesja);
		iloscSesji++;
	}

}
