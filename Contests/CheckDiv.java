import javax.naming.InsufficientResourcesException;
import java.util.HashMap;
import java.util.HashSet;

public class CheckDiv {
    public static boolean checkDivisibility(int n) {
        int temp = n, lastdig = 0;
        int sum = 0, prod = 1;
        while (temp > 0) {
            System.out.println(temp);
            lastdig = temp % 10;
            sum += lastdig;
            prod *= lastdig;
            temp = (temp - lastdig)/10;
        }
        System.out.println("prod:"+prod);
        System.out.println("sum:"+sum);
        if ((n % (sum + prod)) == 0) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(checkDivisibility(80));
    }
}
