import java.util.Scanner;

public class Program {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();
        char[] chars = text.toCharArray();

        int[] freq = new int[65536];

        for (int i = 0; i < chars.length; i++) {
            freq[chars[i]]++;
        }

        char[] topChar = new char[10];
        int[] topFreq = new int[10];

        // find the 10 most frequent characters
        for (int c = 0; c < freq.length; c++) {
            if (freq[c] == 0)
                continue;

            for (int i = 0; i < 10; i++) {
                if (freq[c] > topFreq[i]) {

                    // shift elements
                    for (int j = 9; j > i; j--) {
                        topFreq[j] = topFreq[j - 1];
                        topChar[j] = topChar[j - 1];
                    }


                    
                    topFreq[i] = freq[c];
                    topChar[i] = (char)c;
                    break;
                }
            }
        }

        int max = topFreq[0];
        if (max == 0)
            return;

        // print histogram
        for (int level = 10; level >= 0; level--) {
            boolean printed = false;

            for (int i = 0; i < 10 && topFreq[i] > 0; i++) {
                int height = topFreq[i] * 10 / max;
                if (topFreq[i] > 0 && height == 0)
                    height = 1;

                if (height >= level) {
                    if (level == height) {
                        System.out.print(topFreq[i]);
                    } else {
                        System.out.print("#");
                    }
                } else {
                    System.out.print("  ");
                }

                if (i != 9 && topFreq[i + 1] > 0)
                    System.out.print("  ");
                printed = true;
            }

            if (printed)
                System.out.println();
        }

        // print characters
        for (int i = 0; i < 10 && topFreq[i] > 0; i++) {
            System.out.print(topChar[i]);
            if (i != 9 && topFreq[i + 1] > 0)
                System.out.print("  ");
        }
        System.out.println();
    }
}