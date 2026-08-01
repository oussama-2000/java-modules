import java.util.Scanner;

public class Program {

    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        int n;
        boolean is;
        int checks;

        System.out.print("Enter number: ");
        n = scanner.nextInt();

        is = true;
        checks = 0;

        if (n <= 1)
        {
            System.err.println("IllegalArgument");
            System.exit(-1);
        }

        for (int i = 2; i < n / 2; i++)
        {
            checks++;
            if (n % i == 0)
            {
                is = false;
                break;
            }
        }
        System.out.println(is + " " + checks);
    }
}

// Scanner :  is a built-in class in java.util package used to parse primitive types and strings.
// new : the java keyword that instantiates a new object.
// System.in : the standard input stream .