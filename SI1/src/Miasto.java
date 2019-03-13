import java.util.ArrayList;
import java.util.List;

public class Miasto {
    int index;
    double x;
    double y;
    List<Przedmiot> listaPrzedmiotow;

    public Miasto(int index, double x, double y)
    {
        this.index = index;
        this.x = x;
        this.y = y;
        listaPrzedmiotow = new ArrayList<>();
    }

    public double odleglosc(Miasto m2)
    {
       double odl =  Math.sqrt(Math.pow(m2.x - x, 2) + Math.pow(m2.y - y, 2));
        return odl;
    }

    public void przedmioty(Przedmiot [] list)
    {
        for(int i = 0; i < list.length-1; i++)
        {
            if(list[i+1].idmiasta == index )
            {
                listaPrzedmiotow.add(list[i+1]);
            }

        }
    }

    public String toString()
    {
        return "index: " +  index + " x: " + x + " y: " + y;
    }
}


