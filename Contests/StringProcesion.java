import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class StringProcesion {
    public static String processStr(String s) {
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char curr = s.charAt(i);
            if (curr != '*' && curr != '#' && curr != '%'){
                res.append(curr);
            }
            else if (curr == '*') {
                if (res.isEmpty()) continue;
                res.deleteCharAt(res.length() - 1);
            }else if (curr == '#') {
                if (res.isEmpty()) {
                    res.append("");
                }else res.append(res);
            }else if (curr == '%') {
                res.reverse();
            }
        }
        return res.toString();
    }

    public static void main(String[] args) {
        System.out.println(processStr("p##"));
        StringBuilder  s = new StringBuilder();
        System.out.println(s.reverse());
    }
}
