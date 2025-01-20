public class LeftAndRightDiagonalSum {
    public static void main(String[] args) {
        int[][] Array = { {2,4,6}, {8,10,12},{15,18,21}};

        int n = Array.length;
        int leftDiagonal = 0, rightDiagonal = 0;

        for (int i = 0; i < n; i++) {
            leftDiagonal += Array[i][i];
        }
        System.out.println("Sum of Left Diagonal for the given Matrix is :  "+leftDiagonal);     //Left diagonal

        for (int i = 0; i < n; i++) {
            rightDiagonal += Array[i][n - i - 1];
        }
        System.out.println("Sum of Right Diagonal for the given matrix is : "+rightDiagonal);     //Right diagonal
    }
}
