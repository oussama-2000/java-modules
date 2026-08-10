import java.util.Scanner;

public class Program {

    public static int count_words(String str) {
        int count = 1;
        int i = 0;
        int len = str.length();

        while (i < len && str.charAt(i) == ' ')
            i++;

        if (i == len)
            return 0;

        while (i < len) {

            if (str.charAt(i) == ' ') {
                while (str.charAt(i) == ' ') {
                    if (i == len - 1)
                        return count;
                    i++;
                }
                count++;
            }
            i++;
        }
        return count;
    }

    public static String[] split(String str) {
        int words_count = count_words(str);
        String[] elements = new String[words_count];

        if (words_count == 0)
            return null;

        int i = 0;
        for (int w = 0; w < words_count; w++) {
            String cur_str = "";

            while (str.charAt(i) == ' ')
                i++;
            while (i < str.length() && str.charAt(i) != ' ') {
                cur_str += str.charAt(i);
                i++;
            }

            elements[w] = cur_str;
        }
        return elements;
    }

    public static int max(int[] nums) {
        int max = nums[0];
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > max)
                max = nums[i];
        }
        return max;
    }

    public static int min(int[] nums) {
        int min = nums[0];
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < min)
                min = nums[i];
        }
        return min;
    }

    public static boolean is_in(String e, String[] a) {

        for (int i = 0; i < a.length; i++) {
            if (a[i] == null)
                return false;

            if (a[i].equals(e))
                return true;
        }
        return false;
    }

    public static void main(String[] args) {

        String[] names = new String[10];
        String[][] times = new String[10][2];
        String[][] attendances = new String[10][4];

        Scanner scanner = new Scanner(System.in);

        int columns = 0;
        String state = "names";
        int i = 0;

        while (columns < 3) {
            String input = scanner.nextLine();

            if (state.equals("names")) {
                names[i] = input;
            }
            if (state.equals("times")) {
                times[i] = split(input);
            }
            if (state.equals("attendances")) {
                attendances[i] = split(input);
            }

            i++;

            if (input.equals(".")) {
                if (state.equals("names"))
                    state = "times";
                else if (state.equals("times"))
                    state = "attendances";
                i = 0;
                columns++;
            }

        }

        String[] days = new String[10];
        int[] hours = new int[10];

        for (int t = 0; t < times.length; t++) {

            if (times[t][0].equals(null) || times[t][0].equals("."))
                break;
            if (times[t][1].equals(null) || times[t][1].equals("."))
                break;

            days[t] = times[t][1];
            int hour = Integer.parseInt(times[t][0]);
            boolean dup = false;
            for (int k = 0; k < hours.length; k++) {
                if (hours[k] == hour)
                    dup = true;
            }
            if (!dup)
                hours[t] = Integer.parseInt(times[t][0]);
        }

        int h = 0;
        while (h < hours.length) {
            if (hours[h] == 0)
                break;
            h++;
        }

        int[] days_num = new int[10];
        int a = 0;
        while (a < attendances.length) {

            if (attendances[a][0].equals(null) || attendances[a][0].equals("."))
                break;
            if (attendances[a][1].equals(null) || attendances[a][1].equals("."))
                break;
            if (attendances[a][2].equals(null) || attendances[a][2].equals("."))
                break;

            days_num[a] = Integer.parseInt(attendances[a][2]);
            a++;
        }

        int max = max(days_num);
        int min = min(days_num);

        String[] week_days = { "MO", "TU", "WE", "TH", "FR", "SA", "SU" };

        System.out.print("       ");
        int index = 0;
        for (int s = 0; s < a; s++) {

            if (s == 0) {
                index = 0;
                for (int r = 0; r <= (max - min); r++) {
                    if (is_in(week_days[r % 7], days) && r != 0) {
                        if (index >= h)
                            index = 0;
                        System.out.print(hours[index] + " " + week_days[r % 7] + " " + r + " | ");
                        index++;
                    }
                }
                System.out.println("");
            }
            System.out.print(attendances[s][0] + "   ");

            for (int c = min; c <= max; c++) {
                if (is_in(week_days[c % 7], days) && c != 0) {
                    boolean found = false;

                    // check every attendance record
                    for (int k = 0; k < a; k++) {
                        if (attendances[k][0].equals(attendances[s][0])
                                && Integer.parseInt(attendances[k][1]) == hours[index]
                                && Integer.parseInt(attendances[k][2]) == c) {
                            if (attendances[k][3].equals("HERE"))
                                System.out.print("      1|");
                            else
                                System.out.print("     -1|");

                            found = true;
                            break;
                        }
                    }

                    if (!found)
                        System.out.print("       |");
                }
            }
            System.out.println("");
        }

    }
}