package Test;
import java.util.*;

public class Third {
        private static int[] color; // 0 for black, 1 for red
        private static int[] leftChild;
        private static int[] rightChild;

        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);

            int Q = scanner.nextInt();

            color = new int[2 * Q + 1];
            leftChild = new int[2 * Q + 1];
            rightChild = new int[2 * Q + 1];

            int root = 1;

            while (Q-- > 0) {
                char queryType = scanner.next().charAt(1);

                if (queryType == 'i') {
                    invertColors(root);
                } else {
                    int x = scanner.nextInt();
                    int y = scanner.nextInt();

                    if (queryType == 'b') {
                        System.out.println(countBlack(root, x, y));
                    } else if (queryType == 'r') {
                        System.out.println(countRed(root, x, y));
                    }
                }
            }

            scanner.close();
        }

        private static void invertColors(int node) {
            if (node == 0) return;

            if (color[node] == 0) {
                color[node] = 1;
            } else {
                color[node] = 0;
            }

            invertColors(leftChild[node]);
            invertColors(rightChild[node]);
        }

        private static int countBlack(int node, int x, int y) {
            if (node == 0) return 0;

            if (x <= node && y >= node) {
                return color[node] == 0 ? 1 : 0;
            } else if (y < node) {
                return countBlack(leftChild[node], x, y);
            } else {
                return countBlack(rightChild[node], x, y);
            }
        }

        private static int countRed(int node, int x, int y) {
            if (node == 0) return 0;

            if (x <= node && y >= node) {
                return color[node] == 1 ? 1 : 0;
            } else if (y < node) {
                return countRed(leftChild[node], x, y);
            } else {
                return countRed(rightChild[node], x, y);
            }
        }

        private static void buildTree(int node, int parent) {
            if (node == 0) return;

            if (node == 1) {
                leftChild[node] = 2;
                rightChild[node] = 3;
            } else {
                leftChild[node] = 2 * node;
                rightChild[node] = 2 * node + 1;
            }

            buildTree(leftChild[node], node);
            buildTree(rightChild[node], node);
        }
    }
