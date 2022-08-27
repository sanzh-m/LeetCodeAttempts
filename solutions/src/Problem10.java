public class Problem10 {
    public boolean isMatch(String s, String p) {
        if (p.equals(".*") || s.equals(p))
            return true;
        int sPointer = 0, pPointer = 0;

        while (sPointer < s.length() && pPointer < p.length()) {
            if (p.charAt(pPointer) == '.'){
                if (pPointer == p.length() - 1 || p.charAt(pPointer + 1) != '*') {
                    pPointer++;
                    sPointer++;
                } else {
                    // case for .* within pattern
                    if (pPointer + 1 == p.length() - 1)
                        return true;
                    String newPattern = p.substring(pPointer + 2);
                    while (sPointer < s.length()) {
                        if (isMatch(s.substring(sPointer), newPattern))
                            return true;
                        sPointer++;
                    }
                }
            } else {
                if (pPointer == p.length() - 1 || p.charAt(pPointer + 1) != '*') {
                    if (s.charAt(sPointer) == p.charAt(pPointer)) {
                        pPointer++;
                        sPointer++;
                    } else {
                        return false;
                    }
                } else {
                    char c = p.charAt(pPointer);
                    if (pPointer + 1 == p.length() - 1)
                        while (sPointer < s.length() && s.charAt(sPointer) == c)
                            sPointer++;
                    pPointer += 2;
                    String newPattern = p.substring(pPointer);
                    while (sPointer < s.length() && s.charAt(sPointer) == c) {
                        if (isMatch(s.substring(sPointer), newPattern))
                            return true;
                        sPointer++;
                    }
                }
            }
        }

        while (pPointer < p.length() - 1 && p.charAt(pPointer + 1) == '*')
            pPointer += 2;

        return sPointer == s.length() && pPointer == p.length();
    }

    public static void main(String[] args) {
        Problem10 problem10 = new Problem10();
        System.out.println(problem10.isMatch("a", "ab*"));
    }
}
