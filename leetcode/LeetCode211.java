package leetcode;

/**
 * archeryue
 * 9/24/16
 */
public class LeetCode211 {

    public class WordDictionary {

        private Node root;

        public WordDictionary() {
            root = new Node();
        }

        // Adds a word into the data structure.
        public void addWord(String word) {
            if (word.length() == 0) {
                root.setFin();
                return;
            }

            Node node = root;
            for (char ch : word.toCharArray()) {
                if (node.getChild(ch) == null) {
                    node.addChild(ch);
                }
                node = node.getChild(ch);
            }
            node.setFin();
        }

        // Returns if the word is in the data structure. A word could
        // contain the dot character '.' to represent any one letter.
        public boolean search(String word) {
            return innerSearch(root, word, 0);
        }

        private boolean innerSearch(Node node, String word, int i) {
            if (node == null) {
                return false;
            }

            if (word.length() <= i) {
                return node.isFin();
            }

            char ch = word.charAt(i);
            if (ch == '.') {
                for (char c = 'a'; c <= 'z'; c++) {
                    if (innerSearch(node.getChild(c), word, i + 1)) {
                        return true;
                    }
                }
                return false;
            }

            return innerSearch(node.getChild(ch), word, i + 1);
        }

        private class Node {
            private boolean fin;
            private Node[] children = new Node[26];

            public boolean isFin() {
                return fin;
            }

            public void setFin() {
                fin = true;
            }

            public Node getChild(char ch) {
                return children[ch - 'a'];
            }

            public void addChild(char ch) {
                children[ch - 'a'] = new Node();
            }
        }
    }
}
