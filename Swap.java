public class Swap {

    // this method Swaps the values of a ,b without creating an extra variable for it with the help of + , - arithmetic operations.
   static void SwapWithout3rdVariable(int a, int b){

        System.out.println("Before Swap a = "+a+" b = "+b);

        a = a + b;              // a = a(7) + b(21) = 28.   a = 28.
        b = a - b;             // b = a(28) - b(21) = 7.   b = 7.
        a = a - b;            // a = a(28) - b(7) = 21.   a = 21.
       
        System.out.println("After Swap a = "+a+" b = "+b);
    }

    public static void main(String[] args) {
        int a = 7 , b = 21;
        SwapWithout3rdVariable(a,b);
    }
}
