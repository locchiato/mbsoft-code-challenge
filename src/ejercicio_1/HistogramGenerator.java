package ejercicio_1;

public class HistogramGenerator {

    public static void main(String[] args) {

        int[] myArray= {1, 2, 1, 3, 3, 1, 2, 1, 5, 1};

        generateHistogram(myArray);

    }

    static void generateHistogram(int myArray[]) {

        int counters[] = new int[5];

        for (int integer : myArray) counters[integer-1]++;

        System.out.println();
        System.out.println("╔═══════════════════════╗");
        System.out.println("║ Histograma de enteros ║");
        System.out.println("╚═══════════════════════╝");

        for (int i = 0; i < counters.length; i++) {
            System.out.print(" #" + (i+1) + ": ");
            for (int j = 0; j < counters[i]; j++)
                System.out.print("*");

            System.out.println("");
        }


    }

}
