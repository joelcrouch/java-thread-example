import java.util.Random;

public class Bubble {
    static int upperbound;

    public static void main(String[] args) {
        int size = 10;
        int temp = 0;
        upperbound = Integer.parseInt(args[0]);
        int num[] = new int[10];

        for (int i = 0; i < 10; i++) {
            Random rand = new Random();
            num[i] = rand.nextInt(upperbound);
        }
        for (int i = 0; i < 10; i++) {
            System.out.println("nums [" + i + "]: = " + num[i]);
        }

        for (int i = 1; i < size; i++) {
            for (int j = size - 1; j >= i; j--) {
                if (num[j - 1] > num[j]) {
                    temp = num[j - 1];
                    num[j - 1] = num[j];
                    num[j] = temp;
                }
            }
        }
        System.out.println("\nSorted\n");
        for (int i = 0; i < 10; i++) {
            System.out.println("nums [" + i + "]: = " + num[i]);
        }

    }
}
