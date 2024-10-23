import java.util.Scanner;

public class SumOfNNumbers {
    Scanner sc = new Scanner(System.in);

    void SumOfNumbers(){
        System.out.print("Enter N: ");
        int n = sc.nextInt();
        int sum = 0;

        for (int i = 1; i <=n; i++) {
            sum += i;
        }
        System.out.println("Sum of the First n Natural numbers is : "+sum);
    }

    public static void main(String[] args) {
        SumOfNNumbers s = new SumOfNNumbers();
        s.SumOfNumbers();
    }
}
