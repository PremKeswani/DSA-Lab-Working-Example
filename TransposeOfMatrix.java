public class TransposeOfMatrix {
    public static void main(String[] args) {
        int[][] Matrix = {{1,2,3},{4,5,6,},{7,8,9}};
        int row = Matrix.length;
        int column = Matrix[0].length;

        int[][] transpose = new int[column][row];

        for (int i = 0; i < transpose.length; i++) {
            for (int j = 0; j < transpose[i].length; j++) {
                transpose[j][i] = Matrix[i][j];
            }
        }
        System.out.println("Transpose of the Matrix is : ");
        for (int i = 0; i < transpose.length; i++) {
            for (int j = 0; j < transpose[0].length; j++) {
                System.out.print(transpose[i][j]+" ");
            }
            System.out.println();
        }
    }
}
