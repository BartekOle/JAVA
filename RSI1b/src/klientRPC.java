import org.apache.xmlrpc.XmlRpcClient;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import java.util.Scanner;

public class klientRPC {

    public static void main(String[] args) {

        try{
            Scanner scan = new Scanner(System.in);
           XmlRpcClient srv = new XmlRpcClient("http://localhost:10012");
            AC cb = new AC();
            System.out.println("Podaj swoj wiek");
            int wiek = scan.nextInt();
            System.out.println("Podaj swoje imie");
            scan.nextLine();
            String imie = scan.nextLine();
            Vector<Object> params3 = new Vector<Object>();
            params3.add(wiek);
            params3.add(imie);
            Vector<Integer> params5 = new Vector<Integer>();
            params5.add(new Integer(0));
            Object result5 = srv.execute("MojSerwer.show", params5);
            String wynik5 = result5.toString();
            System.out.println(wynik5);
            /*Vector<Integer []> params6 = new Vector<Integer []>();
            Integer tab[] = new Integer[3];
            tab[0] = 5;
            tab[1] = 3;
            tab[2] = 4;
            params6.add(tab);
            Object result6 = srv.execute("MojSerwer.najwiekszaLiczba", params6);
            int wynik6 = ((Integer) result6).intValue();
            System.out.println(wynik6);*/
            String koniec = "fadf";
            while(!koniec.equals("zero")) {
                koniec = scan.nextLine();
                switch (koniec) {
                    case "poleTrojkata":
                        Vector<Double> params4 = new Vector<Double>();
                        System.out.println("Podaj wartosc podstawy trojkata");
                        double a = scan.nextDouble();
                        System.out.println("Podaj wartosc wysokosci trojkata");
                        double h = scan.nextDouble();
                        scan.nextLine();
                        params4.add(a);
                        params4.add(h);
                        Object result3 = srv.execute("MojSerwer.poleTrojkata", params4);
                        double wynik3 = ((Double) result3).doubleValue();
                        System.out.println(wynik3);
                        break;
                    case "echo":
                        Vector<Integer> params = new Vector<Integer>();
                        params.addElement(new Integer(17));
                        params.addElement(new Integer(21));
                        Object result = srv.execute("MojSerwer.echo", params);
                        int wynik = ((Integer) result).intValue();
                        System.out.println(wynik);
                        break;
                    case "execAsy":
                        Vector<Integer> params2 = new Vector<Integer>();
                        params2.addElement(new Integer(3000));
                        srv.executeAsync("MojSerwer.execAsy", params2, cb);
                        System.out.println("Wywolano asynchronicznie");
                        break;
                    case "daneOsobowe":
                        Object result2 = srv.execute("MojSerwer.daneOsobowe", params3);
                        String wynik2 = result2.toString();
                        System.out.println(wynik2);
                        break;
                    case "pierwiastek":
                        Vector<Object> params7 = new Vector<Object>();
                        System.out.println("Podaj liczbe z ktorej chcesz obliczc pierwiasteka");
                        double liczba = scan.nextDouble();
                        scan.nextLine();
                        params7.addElement(liczba);
                        params7.addElement(new Integer(3000));
                        srv.executeAsync("MojSerwer.pierwiastek", params7, cb);
                        System.out.println("Wywolano asynchronicznie oblcizenie pierwiastka: ");
                        break;
                    case "zero":
                        break;
                        default:
                            System.out.println("Zle polecenie");

                }
            }
        } catch(Exception exception) {
            System.err.println("Klient XML-RPC: " + exception);
        }

    }


}
