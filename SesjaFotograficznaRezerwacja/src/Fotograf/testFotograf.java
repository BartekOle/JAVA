import java.text.ParseException;
import java.util.*;

import Fotograf.*;
import Fotograf.Sesja_zdjeciowa.Kolor_zdjec;
import junit.framework.Assert;


public class testFotograf {

	@SuppressWarnings("deprecation")
	@org.junit.Test
	public void test1() throws ParseException {

		String dateString = "04.08.2018 10:42:00";
		Sesja_zdjeciowa sesja = new Sesja_zdjeciowa();
		sesja.addDate(dateString);
		Assert.assertNotNull(sesja.data);
		
	}
	
	@org.junit.Test
	public void test2() throws ParseException {

		String dateString = "04.08.2018 10:42:00";
		Sesja_zdjeciowa sesja = new Sesja_zdjeciowa();
		sesja.addDate(dateString);
		Assert.assertEquals(true, sesja.correctdate(sesja.data));
		
	}
	
	@org.junit.Test
	public void test3() {

		Rachunek rachunek = new Rachunek(200);
		rachunek.changeCzyOplacone();;
		Assert.assertEquals(true, rachunek.CzyOplacone);
		
		
	}
	@org.junit.Test
	public void test4() {
		
		Date data = new Date();
		Kolor_zdjec kolorZdjec = Kolor_zdjec.kolorowe;
		String miejsceWykonania = "Wroclaw";
		Dane_kontaktowe klient = new Dane_kontaktowe("Adam", "Nowak", "mail@gmail.com", 25, "Wyszynskiego");
		Dane_podstawowe fotograf = new Dane_podstawowe("Karol", "Wieczorek");
		Sesja_zdjeciowa sesja = new Sesja_zdjeciowa(data, kolorZdjec, miejsceWykonania, klient, fotograf);
		Assert.assertNotNull(sesja);
		
	}
	@org.junit.Test
	public void test5() {

		Date data = new Date();
		Kolor_zdjec kolorZdjec = Kolor_zdjec.kolorowe;
		String miejsceWykonania = "Wroclaw";
		Dane_kontaktowe klient = new Dane_kontaktowe("Adam", "Nowak", "mail@gmail.com", 25, "Wyszynskiego");
		Dane_podstawowe fotograf = new Dane_podstawowe("Karol", "Wieczorek");
		Sesja_zdjeciowa sesja = new Sesja_zdjeciowa(data, kolorZdjec, miejsceWykonania, klient, fotograf);
		Lista listasesji = new Lista();
		int iloscpododaniu = listasesji.ilosc+1;
		Rachunek rachunek = new Rachunek(200);
		String klientlogin = "Nowak233";
		String fotograflogin = "Karwww456";
		listasesji.addsesja(sesja, rachunek, klientlogin, fotograflogin);
		Assert.assertEquals(iloscpododaniu, listasesji.ilosc);
		
	}
}
