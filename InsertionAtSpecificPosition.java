public class InsertionAtSpecificPosition {
    static void insertElement(int[] array, int n, int x, int position){
        for (int i = n-1; i >= position; i--)
        {
            array[i + 1] = array[i];
        }
            array[position] = x;
    }
    public static void main(String[] args) {
        int[] array = new int[15];
        array[0] = 2;
        array[1] = 4;
        array[2] = 1;
        array[3] = 8;
        array[4] = 5;

        int n = 5, x = 10 , position = 2;

        System.out.print("Before Insertion: ");
        for (int i = 0; i < n; i++) {
            System.out.print(array[i]+ " ");
        }

        insertElement(array,n,x,position);
        n += 1;

        System.out.print("\nAfter Insertion: ");
        for (int i = 0; i < n; i++) {
            System.out.print(array[i]+ " ");
        }
    }
}
