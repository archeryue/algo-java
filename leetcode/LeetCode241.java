package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * archeryue
 * 10/16/16
 */
public class LeetCode241 {

    List<Integer> numbers = new ArrayList<>();
    List<Character> operations = new ArrayList<>();

    public List<Integer> diffWaysToCompute(String input) {
        List<Integer> res = new ArrayList<>();

        int num = 0;
        for (Character ch : input.toCharArray()) {
            if (ch >= '0' && ch <= '9')
                num = num * 10 + (ch - '0');
            else {
                operations.add(ch);
                numbers.add(num);
                num = 0;
            }
        }
        numbers.add(num);

        assert numbers.size() == operations.size() + 1;

        return divide(0, numbers.size() - 1);
    }

    private List<Integer> divide(int left, int right) {
        List<Integer> res = new ArrayList<>();
        if (left == right) {
            res.add(numbers.get(left));
            return res;
        }

        for (int i = left; i < right; i++) {
            List<Integer> lList = divide(left, i);
            List<Integer> rList = divide(i + 1, right);
            for (int l : lList) {
                for (int r : rList) {
                    switch (operations.get(i)) {
                        case '+':
                            res.add(l + r);
                            break;
                        case '-':
                            res.add(l - r);
                            break;
                        case '*':
                            res.add(l * r);
                    }
                }
            }
        }

        return res;
    }

}
