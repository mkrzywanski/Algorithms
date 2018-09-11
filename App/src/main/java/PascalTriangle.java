import java.util.Arrays;

public class PascalTriangle {
    public static void main(String[] args) {
        drawTriangle(10);
    }

    public static void drawTriangle(int n) {
        int[][] tab = new int[n][];
        for (int i = 0; i < n; i++) {
            tab[i] = new int[i + 1];
            tab[i][0] = 1;
            tab[i][i] = 1;

            for (int j = 0; j < i - 1; j++) {
                tab[i][j + 1] = tab[i - 1][j] + tab[i - 1][j + 1];
            }
        }
        int rowCount = tab.length;
        for (int[] array : tab) {
            for (int i = rowCount; i > 0; i--) {
                System.out.print(" ");
            }
            rowCount--;
            for (int in : array) {
                System.out.print(in + " ");
            }
            System.out.println();
        }
    }
}
