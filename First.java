package Test;
import java.util.*;

public class First {
        private static int[] values;
        private static int H;

        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);

            H = scanner.nextInt();
            int numNodes = (int) Math.pow(2, H) - 1;

            values = new int[numNodes + 1];

            for (int i = 1; i <= numNodes; i++) {
                values[i] = scanner.nextInt();
            }

            int P1 = computeP(1);

            System.out.println(P1);

            scanner.close();
        }

        private static int computeP(int nodeIndex) {
            if (2 * nodeIndex > values.length - 1) { // leaf node
                return values[nodeIndex];
            }

            int PL = computeP(2 * nodeIndex);
            int PR = computeP(2 * nodeIndex + 1);

            return Math.max(values[nodeIndex] * PL, values[nodeIndex] * PR);
        }
}
