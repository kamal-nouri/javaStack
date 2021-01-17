public class StringManipulator {
    public String trimAndConcat(String a, String b) {
        String x = (a.trim()).concat(b.trim());
        return x;
    }

    public Integer getIndexOrNull(String c, char letter) {
        Integer y = c.indexOf(letter);
        return y;
    }

    public Integer getIndexOrNull(String s, String z) {
        if (s.indexOf(z) >= 0) {
            Integer h = s.indexOf(z);
            return h;
        } else {
            return null;
        }

    }

    public String concatSubstring(String q, int w, int e, String r) {
        String v = q.substring(w, e).concat(r);
        return v;
    }

}

