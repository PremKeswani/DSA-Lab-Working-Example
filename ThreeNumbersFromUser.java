import java.util.Scanner;

public class ThreeNumbersFromUser {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] numbers = new int[3];
        System.out.print("Enter Three Numbers:  ");
        numbers[0] = sc.nextInt();
        numbers[1] = sc.nextInt();
        numbers[2] = sc.nextInt();

        //condition check for increasing order
        if(numbers[0] < numbers[1] && numbers[1] < numbers[2]){
            System.out.println("Numbers are in Increasing Order ");
        }
        //for decreasing order
        else if (numbers[0] > numbers[1] && numbers[1] > numbers[2]){
            System.out.println("Numbers are in Decreasing order");
        }
        else {
            System.out.println("Neither increasing nor decreasing ");
        }
    }
}

