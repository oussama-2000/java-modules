import java.util.Scanner;

public class Program {

    public static boolean is_prime_num(int n)
    {
        boolean it_is = true;

        for (int i = 2; i < n; i++)
        {
            if (n % i == 0)
            {
                it_is = false;
                break;
            }
        }

        return it_is;
    }

    public static void main(String[] args)
    {   
        Scanner scanner = new Scanner(System.in);
        int coffee_queries = 0;
        int n;
        int sum;

        while (true)
        {

            System.out.print("Enter number: ");
            n = scanner.nextInt();

            if (n <= 1)
            {
                System.err.println("IllegalArgument");
                System.exit(-1);
            }
            if (n == 42)
                break;

            sum = 0;
            while (n > 0)
            {
                sum += n % 10;
                n /= 10;
            }
            if (is_prime_num(sum))
                coffee_queries++;
        }

        System.out.println("Count of coffee-request: " + coffee_queries);
    }
}