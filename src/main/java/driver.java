import java.util.Scanner;

public class driver {
    public static void main(String args[]) {
        System.out.print("Enter number: ");
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        // Write an answer using System.out.println()
        // To debug: System.e

        long value = 0;
        long value2 = 0;
        long start1;
        long start2;
        long time1;
        long time2;

        start1 = System.currentTimeMillis();
        value = power((long)n);
        time1 = System.currentTimeMillis() - start1;

        //System.out.println("___");

        start2 = System.currentTimeMillis();
        for (int i = n; i >= 0; i--) {
            value2 += Math.pow(2,i);
            //System.out.println(value2);
        }
        time2 = System.currentTimeMillis() - start2;

        System.out.println("Recu Answer: " + value +"\t Time: " + time1);
        System.out.println("Loop Answer: " + value2 +"\t Time: " + time2);
    }


    public static long powerN(int n) {
        long value = (long)(Math.pow(2, n--));
        if (n >= 0) value += powerN(n);
        return value;
    }

    public static long power(long n) {
        long value = 0;

        if (n >= 0) {
            value += Math.pow(2,(long) n);
            value+= power(--n);
        }
        //System.out.println(value);
        return value;
    }
}
