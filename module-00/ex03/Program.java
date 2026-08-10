import java.util.Scanner;


public class Program {

    public static String chart(int total)
    {
        System.out.println(total);
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
        Scanner scanner;
        int i;
        String buffer;
        int exams_num;
        boolean iter;
        String exams;
        int j;
        int sum;
        String element;
        int k;
        int n;

        scanner = new Scanner(System.in);
        i = 1;
        buffer = "";
        exams_num = 0;
        iter = true;

        
        while (iter)
        {
            
            System.out.println("Week " + i);
            exams = scanner.nextLine();


            j = 0;
            sum = 0;
            while (j < exams.length())
            {
                element = "";
                k = j;
                
                while (k < exams.length())
                {
                    if (exams.charAt(k) == ' ')
                    {
                        exams_num++;
                        break;
                    }
                    element += exams.charAt(k);
                    j++;
                    k++;
                }

                if (element.length() > 0)
                {
                    n = Integer.parseInt(element);
                    if (n == 42)
                    {
                        iter = false;
                        break;
                    }
                    sum += n;
                }
                j++;
            }

            if (!iter)
                break;
            
            if (exams_num != 4)
            {
                System.err.println("exams number must be 5 per week.");
                System.exit(-1);
            }

            buffer += "Week " + i + " " + chart(sum) + "\n";
            exams_num = 0;
            i++;
        }
        System.out.println(buffer);
    }
}