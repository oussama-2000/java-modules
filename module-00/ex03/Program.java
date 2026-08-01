import java.util.Scanner;


public class Program {

    public static String chart(int total)
    {
        String chart = "";
        for (int i = 0; i <= total; i++)
        {
            chart += '=';
        }
        chart += '>';
        return chart;
    }

    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        int i = 1;
        String buffer = "";
        
        while (i < 3)
        {
            System.out.println("Week " + i);
            String exams = scanner.nextLine();

            // if (exams.length() != 5)
            // {
            //     System.err.println("number of tests must be 5 per week.");
            //     System.exit(-1);
            // }
            int j = 0;
            int sum = 0;

            while (j < 5)
            {
                String element = "";
                int k = j;
                
                while (k < 5)
                {
                    if (exams.charAt(k) == ' ')
                        break;
                    element += exams.charAt(k);
                    j++;
                    k++;
                }

                if (element.length() > 0)
                {
                    int n = Integer.parseInt(element);
                    if (n == 42)
                        System.exit(-1);
                    sum += n;
                }
                j++;
            }

            buffer += "Week " + i + " " + chart(sum) + "\n";
            i++;
        }
        System.out.println(buffer);
    }
}