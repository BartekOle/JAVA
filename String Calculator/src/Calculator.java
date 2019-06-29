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
           if(arrayNumbers.length == 1)
           {
               result = Integer.parseInt(arrayNumbers[0]);
           }
           else
           {
               result = Integer.parseInt(arrayNumbers[0]) + Integer.parseInt(arrayNumbers[1]);
           }
       }
       return result;
    }
}
