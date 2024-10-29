public class InsertionAtEndPosition {
    static int insertEnd(int[] array , int n , int key , int capacity){
        if(n>= capacity)
            return n;
            array[n] = key;
        return n+1;
    }

    public static void main(String[] args) {
        int[] arr = new int[20];
        arr[0] = 10;
        arr[1] = 20;
        arr[2] = 40;
        arr[3] = 60;
        arr[4] = 70;
        arr[5] = 80;

        int capacity = 20, n = 6, i , key = 26;

        // before insertion
        for (int j = 0; j < n; j++) {
            System.out.print(arr[j]+" ");
        }
        System.out.println();

        int insertAtEnd = insertEnd(arr,n,key,capacity);
        n +=1;

        //After Insertion
        for (int j = 0; j < n; j++) {
            System.out.print(arr[j]+" ");
        }
    }
}
