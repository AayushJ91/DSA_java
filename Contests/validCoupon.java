import java.util.*;

public class validCoupon {
    public static List<String> validateCoupons(String[] code, String[] businessLine, boolean[] isActive) {
        Map<String, String> check = new HashMap<>();
        for (int i = 0; i < businessLine.length; i++) {
            check.put(businessLine[i], code[i]);
        }
        System.out.println(check);
        Map<String, Integer> num = new HashMap<>();
        num.put("electronics", 1);
        num.put("grocery", 2);
        num.put("pharmacy", 3);
        num.put("restaurant", 4);
        List<String> result = new ArrayList<>();
        for (int i = 0; i < isActive.length; i++) {
            if (!num.containsKey(businessLine[i])) continue;
            if (isActive[i]) {
                if (containSpcl(code[i])) continue;
                result.add(code[i]);
                for (int j = 0; j < result.size(); j++){
                    String last = result.getLast();
                    if (num.get(check.get(last)) > num.get(check.get(code[i]))){
                        result.set(result.size() - 1, code[i]);
                        result.add(last);
                    }
                    result.add(code[i]);
                }
            }
        }
        return result;
    }

    private static boolean containSpcl(String str) {
        if (str.isEmpty()) return true;
        return str.matches(".*[^a-zA-Z0-9_].*");
    }
    public static void main(String[] args) {
        String[] code = {"SAVE20","","PHARMA5","SAVE@20"};
        String[] businessLine ={"restaurant","grocery","invalid","restaurant"};
        boolean[] isActive = {true,true,true,true};
        System.out.println(validateCoupons(code, businessLine, isActive));
    }
}
