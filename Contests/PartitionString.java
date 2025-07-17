import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PartitionString {
    public static List<String> partitionString(String s) {
        Map<String, Integer> map = new HashMap<>();
        List<String> res = new ArrayList<>();
        StringBuilder temp = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            temp.append(s.charAt(i));
            if (!map.containsKey(temp.toString())) {
                map.put(temp.toString(), 1);
                res.add(temp.toString());
                temp.setLength(0);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(partitionString("aaaa"));

    }
}
