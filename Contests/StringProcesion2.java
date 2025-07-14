public class StringProcesion2 {
    public static char processStr(String s, long k) {
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
        String result = res.toString();
        if (k >= res.length()) {
            return '.';
        }
        return result.charAt((int) k);
    }

    public static void main(String[] args) {
        System.out.println(processStr("%#bz%xum##i##vzo#pwc*#dkwbh####%uf%s*%cgppqhqa%h#l##o%ij%%cz%iga##e###u%#e####jfwx##%%*x%m*%#", 6523));
    }
}
