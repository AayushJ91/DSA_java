public class factorial {
    public static void main(String[] args) {
        System.out.println(factorials(5));
    }
    static int factorials(int n) {
        if (n == 0){
            return 1;
        }
        System.out.println(n);
        return n * factorials(n-1);
    }
}
