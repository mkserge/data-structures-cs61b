package sandbox;

public class PascalsTriangle {

    public static int[][] PascalsTriangle(int n) {
        int[][] pt = new int[n][];

        for (int i = 0; i < n; i++) {
            pt[i] = new int[i + 1];
            // Left-most element is always 1
            pt[i][0] = 1;
            // Fill the rest of the array
            for (int j = 1; j < i; j++) {
                pt[i][j] = pt[i - 1][j - 1] + pt[i - 1][j];
            }
            pt[i][i] = 1;
        }
        return pt;
    }

    public static void main(String[] args) {

        int[][] pt = PascalsTriangle(5);



        System.out.println(PascalsTriangle(5));

    }
}
