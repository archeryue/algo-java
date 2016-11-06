package leetcode;

/**
 * archeryue
 * 11/6/16
 */
public class LeetCode10 {

    public static boolean isMatch(String s, String p) {
        return isMatch(s, p, 0, 0);
    }

    private static boolean isMatch(String s, String p, int i, int j) {
        if (j == p.length()) return i == s.length();
        if (j >= p.length()) return false;
        if (j == p.length() - 1 || p.charAt(j+1) != '*') {
            return match(s, p, i, j) && isMatch(s, p, i+1, j+1);
        } else {
            if (isMatch(s, p, i, j+2)) return true;
            while (match(s, p, i, j)) {
                i++;
                if (isMatch(s, p, i, j+2)) return true;
            }
        }
        return false;
    }

    private static boolean match(String s, String p, int i, int j) {
        if (i == s.length() && j == p.length()) return true;
        if (i >= s.length() || j >= p.length()) return false;
        return s.charAt(i) == p.charAt(j) || (i < s.length() && p.charAt(j) == '.');
    }

    public static void main(String[] args) {
        System.out.println(isMatch("aaa", "a"));
        System.out.println(isMatch("abc", "abc"));
        System.out.println(isMatch("abc", ".bc"));
        System.out.println(isMatch("aaac", "a*ac"));
        System.out.println(isMatch("aab", "c*a*b"));
        System.out.println(isMatch("ab", ".*"));
        System.out.println(isMatch("abc", ".**"));
        System.out.println(isMatch("abc", "h*d*c*..c"));
        System.out.println(isMatch("aaa", "ab*c*a*a"));
        System.out.println(isMatch("aba", "ab*a*c*a"));
        System.out.println(isMatch("a", "ab*"));
        System.out.println(isMatch("a", ".*"));
        long time = System.currentTimeMillis();
        System.out.println(isMatch("aaaaaaaaaaaaab", "a*a*a*a*a*a*a*a*a*a*a*a*b"));
        System.out.println(System.currentTimeMillis() - time);
    }

}
