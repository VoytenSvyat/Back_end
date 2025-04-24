
public class Main {
    public static void main(String[] args) {
        m(10);
        System.out.println(fib(4));
        System.out.println(fib(5));
        System.out.println(fib(6));
        System.out.println(factorial(5));
    }

    public static  void m (int i){
        System.out.println("Start " + i);
        if (i==0){
            System.out.println("  ----- finish -----");
            return;
        }

        m2(i-1);


        // System.out.println("Finish " + i);
    }
    public static void m2(int i){
        m(i);
    }
    // Пример чисел Фибоначчи
    public static int fib(int n){
        if (n==0 || n==1){
            return 1;
        } else {
            return fib(n-1)+fib(n-2);
        }

    }
    public static long factorial(long i){
        if (i==1){
            return 1;
        } else {
            return i * factorial(i-1);
        }
    }
}
/*
Факториал — это математическая операция, которая обозначается как n! и означает произведение всех целых чисел от 1 до n.
Примеры:
5! = 5 × 4 × 3 × 2 × 1 = 120
3! = 3 × 2 × 1 = 6
1! = 1
0! = 1 (по определению)
 */
