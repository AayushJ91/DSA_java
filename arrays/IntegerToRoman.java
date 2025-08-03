import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class IntegerToRoman {
    public static void main(String[] args) {
        System.out.println(naive(5));
    }

    static String naive(int num) {
        List<Integer> list = new ArrayList<>();
        while (num > 0) {
            int rem = num % 10;
            list.add(rem);
            num = (num - rem)/10;
        }
        String res = "";
        HashMap<Double, Character> guide = new HashMap<>();
        guide.put(1.0, 'I'); guide.put(1.5, 'V'); guide.put(2.0, 'X'); guide.put(2.5, 'L');
        guide.put(3.0, 'C'); guide.put(3.5, 'D'); guide.put(4.0, 'M');
        int digits = list.size();
        for (int i = 0; i < digits; i++) {
            double place = (double) digits + 1;
            int curr = list.get((int) place - 1);
            if (curr > 5) {
                place -= 0.5;
                curr -= 5;
                res = res + guide.get(place);
            }
            System.out.println("place:" + place);
            char toAdd = guide.get(place);
            System.out.println("toAdd:"+toAdd);
            for (int j = 0; j < curr; j++) {
                res = res + toAdd;
            }
        }
        System.out.println(list);
        return res;
    }
}
