import java.util.Scanner;

public class FloatingPointNumbers {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter Number A : ");
        double A = sc.nextDouble();
        System.out.println("Enter Number B :");
        double B = sc.nextDouble();

        int A1 = (int) (A*1000);     // changing both A and B values from Double to int by casting.
        int B1 = (int) (B*1000);

        if(A1 == B1){
            System.out.println("The Numbers are same up to Three decimal points:) ");
        }
        else {
            System.out.println("The Numbers are not Same :(");
        }
    }
}
