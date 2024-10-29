import java.util.Scanner;

public class ElementSearch {
    static int findElement(int[] array , int  n , int key){

        for (int i = 0; i < n; i++) {
            if(array[i] == key){
                return i;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] array = {3, 5 , 7 , 9 ,10};
        int N = array.length;

        System.out.print("Enter the key value: ");
        int keyValue = sc.nextInt();

        int position = findElement(array,N,keyValue);
        if(position == -1 ){
            System.out.println("Element not found :)");
        }
        else System.out.println("Element found at position : "+(position+1));
    }
}
