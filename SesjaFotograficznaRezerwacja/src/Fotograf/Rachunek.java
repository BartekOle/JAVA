package Fotograf;

public class Rachunek {
		public double suma;
		public boolean CzyOplacone;
		public Sesja_zdjeciowa sesja;
		
		public Rachunek(int suma)
		{
			this.suma = suma;
			CzyOplacone = false;
		}
		
		public Rachunek()
		{
			CzyOplacone = false;
		}
		
		public void changeCzyOplacone()
		{
			this.CzyOplacone = true;
		}
}
