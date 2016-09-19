/**
 * archeryue
 * 9/19/16
 */
public class LeetCode65 {
    public boolean isNumber(String s) {
        if (s == null) return false;

        char[] arr = s.trim().toCharArray();
        if (arr.length == 0) return false;

        boolean isDigit = false;
        boolean isPoint = false;
        boolean isE = false;
        boolean isS = true;

        for (int i = 0; i < arr.length; i++) {
            char c = arr[i];
            if (c == '+' || c == '-') {
                if (i != 0 && arr[i - 1] != 'e') return false;
                if (i == arr.length - 1) return false;
            } else if (c == 'e') {
                if (isE || !isDigit) return false;
                if (i == arr.length - 1) return false;
                isE = true;
            } else if (c == '.') {
                if (isPoint || isE) return false;
                if (arr.length == 1) return false;
                isPoint = true;
            } else if (c >= '0' && c <='9') {
                isDigit = true;
            } else {
                return false;
            }
        }
        return isDigit;
    }
}
