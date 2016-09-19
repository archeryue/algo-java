/**
 * archeryue
 * 9/13/16
 */
public class ArrangeArray {

    private static class Val<T> {
        private T val;

        private Val(T val) {
            this.val = val;
        }

        private T getVal() {
            return val;
        }

        private int getIndex() {
            if (val instanceof Integer) {
                return ((Integer) val - 1) * 2;
            } else if (val instanceof Character) {
                return ((Character) val - 'a') * 2 + 1;
            }
            throw new RuntimeException();
        }

    }

    private static Val[] arrangeArray(Val[] p) {
        int n = p.length;
        for (int i = 0; i < n; i++) {
            if (i != p[i].getIndex()) {
                Val pick = p[i];
                int next = p[i].getIndex();
                while (next != i) {
                    Val tmp = p[next];
                    p[next] = pick;
                    pick = tmp;
                    next = pick.getIndex();
                }
                p[i] = pick;
            }
        }
        return p;
    }

    @SuppressWarnings("all")
    public static void main(String[] args) {
        Val[] vals = new Val[]{new Val(1), new Val(2), new Val(3),
                new Val('a'), new Val('b'), new Val('c')};
        Val[] res = arrangeArray(vals);
        for (Val val : res) {
            System.out.print(val.getVal().toString() + ",");
        }
        System.out.println("");
    }

}
