public class Basic {
    public static void main(String[] args) {
        printAll();
        printOdd();
        printSum();
        iter();
        max();
        avg();
        greater();
        shift();

    }

    public static void printAll() {
        for (int i = 1; i < 256; i++) {
            System.out.println(i);
        }
    }

    public static void printOdd() {
        for (int i = 1; i < 256; i++) {
            if (i % 2 != 0) {
                System.out.println(i);
            }

        }
    }

    public static void printSum() {
        int sum = 0;
        for (int i = 1; i < 256; i++) {
            sum += i;
            System.out.println("New Number :" + i + "," + "Sum " + sum);
        }
    }

    public static void iter() {
        int[] array = {1, 3, 5, 7, 9, 13};
        for (int i = 0; i < array.length; i++) {
            int x = array[i];
            System.out.println(x);
        }
    }

    public static void max() {
        int[] array = {1, 3, 5, 7, 20, 13};
        int maximum = 0;
        for (int i = 0; i < array.length; i++) {
            if (maximum < array[i]) {
                maximum = array[i];
            }
        }
        System.out.println(maximum);
    }

    public static void avg() {
        int[] array = {1, 3, 5, 8, 10, 13};
        double sum = 0;
        for (int i = 0; i < array.length; i++) {
            sum += array[i];
        }
        double average = sum / array.length;
        System.out.println(average);
    }

    public static void greater() {
        int[] array = {1, 3, 5, 8, 10, 13};
        int count = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] > 3) {
                count += 1;
            }
        }
        System.out.println(count);
    }

    public static void shift() {
        int[] array = {1, 3, 5, 8, 10, 13};
        for (int i = 1; i < array.length; i++) {
            array[i - 1] = array[i];
        }
        array[array.length - 1] = 0;

        for (int i = 0; i < array.length; i++) {

            System.out.println(array[i]);
        }
    }

}
