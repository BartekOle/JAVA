import java.util.Scanner;

public class Calculator {
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter text");
        String text = scan.nextLine();
        System.out.println("Result: " + Add(text));
    }
    public static int Add(String numbers)
    {
       int result = 0;
       if(!numbers.isEmpty()) {
           String[] arrayNumbers = numbers.split(",");
           for(String number : arrayNumbers)
           {
               if(!number.isEmpty()) {
                   result += Integer.parseInt(number);
               }
           }
       }
       return result;
    }
}
