package leetcode;

import java.util.Stack;

/**
 * archeryue
 * 11/13/16
 */
public class LeetCode388 {

    public static int lengthLongestPath(String input) {
        int max = 0;
        Stack<Integer> stack = new Stack<>();
        int index = 0;
        int len = 0;
        boolean file = false;
        while (index < input.length()) {
            len++;
            if (index == input.length() - 1 && file) {
                int tmp = getLen(stack, len);
                max = Math.max(max, tmp);
            } else if (input.charAt(index) == '.') {
                file = true;
            } else if (input.charAt(index) == '\n') {
                len--;
                if (file) {
                    int tmp = getLen(stack, len);
                    max = Math.max(max, tmp);
                    file = false;
                }
                int t = 0;
                while (input.charAt(index + 1) == '\t') {
                    t++;
                    index++;
                }
                if (t == stack.size() + 1) {
                    stack.push(len);
                } else if (t < stack.size()) {
                    t = stack.size() - t;
                    for (int i = 0; i < t; i++) stack.pop();
                }
                len = 0;
            }
            index++;
        }
        return max;
    }

    private static int getLen(Stack<Integer> stack, int len) {
        return stack.stream().mapToInt(i -> i).sum() + len + stack.size();
    }

    public static void main(String[] args) {
        System.out.println(lengthLongestPath("dir\n\tsubdir1\n\tsubdir2\n\t\tfile.ext"));
        System.out.println(lengthLongestPath("dir\n    file.ext"));
        System.out.println(lengthLongestPath("a\n\taa\n\t\taaa\n\t\t\tfile1.txt\naaaaaaaaaaaaaaaaaaaaa\n\tsth.png"));
    }

}
