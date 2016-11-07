package leetcode;

/**
 * archeryue
 * 11/6/16
 */
public class LeetCode10 {

    public static boolean isMatch(String s, String p) {
        if (p.length() == 0) return s.length() == 0;
        if (p.charAt(0) == '*') return false;

        boolean[][] a = new boolean[p.length() + 1][s.length() + 1];
        a[0][0] = true;
        for (int pi = 2; pi <= p.length(); pi++) {
            a[pi][0] = p.charAt(pi - 1) == '*' && a[pi - 2][0];
        }

        for (int pi = 1; pi <= p.length(); pi++) {
            if (pi < p.length() && p.charAt(pi) == '*') continue;
            for (int si = 1; si <= s.length(); si++) {
                if (p.charAt(pi - 1) == '*') {
                    a[pi][si] = a[pi - 2][si]
                            || a[pi][si - 1]
                            && match(s.charAt(si - 1), p.charAt(pi - 2));
                } else {
                    a[pi][si] = a[pi - 1][si - 1]
                            && match(s.charAt(si - 1), p.charAt(pi - 1));
                }
            }
        }
        return a[p.length()][s.length()];
    }

    private static boolean match(char s, char p) {
        return s == p || p == '.';
    }

    public static void main(String[] args) {
        long time = System.currentTimeMillis();
        System.out.println(isMatch("aaa", "a"));
        System.out.println(isMatch("abc", "abc"));
        System.out.println(isMatch("abc", ".bc"));
        System.out.println(isMatch("aaac", "a*ac"));
        System.out.println(isMatch("aab", "c*a*b"));
        System.out.println(isMatch("ab", ".*"));
        System.out.println(isMatch("abc", "h*d*c*..c"));
        System.out.println(isMatch("aaa", "ab*c*a*a"));
        System.out.println(isMatch("aba", "ab*a*c*a"));
        System.out.println(isMatch("a", "ab*"));
        System.out.println(isMatch("a", ".*"));
        System.out.println(isMatch("aaaaaaaaaaaaab", "a*a*a*a*a*a*a*a*a*a*a*a*b"));
        System.out.println(System.currentTimeMillis() - time);
    }

}
