package com.archer.leetcode;

import java.util.*;

/**
 * archeryue
 * 9/11/16
 */
public class LeetCode126 {

    public static List<List<String>> findLadders(String beginWord, String endWord, Set<String> wordList) {
        List<List<String>> res = new LinkedList<>();
        Queue<List<String>> queue = new LinkedList<>();
        List<String> bl = new LinkedList<>();
        bl.add(beginWord);
        queue.offer(bl);

        wordList.add(endWord);
        int finalLevel = Integer.MAX_VALUE;
        int level = 1;
        Set<String> set = new HashSet<>();
        while (!queue.isEmpty()) {
            List<String> list = queue.poll();
            if (list.size() > level) {
                wordList.removeAll(set);
                set.clear();
                if (list.size() >= finalLevel)
                    break;
                else
                    level = list.size();
            }

            char[] arr = list.get(list.size() - 1).toCharArray();
            for (int i = 0; i < arr.length; i++) {
                char origin = arr[i];
                for (char c = 'a'; c <= 'z'; c++) {
                    if (c == origin) continue;

                    arr[i] = c;
                    String word = new String(arr);
                    if (!wordList.contains(word)) continue;

                    if (word.equals(endWord)) {
                        finalLevel = list.size() + 1;
                        res.add(newList(list, word));
                    } else {
                        set.add(word);
                        queue.offer(newList(list, word));
                    }
                }
                arr[i] = origin;
            }
        }

        return res;
    }

    private static List<String> newList(List<String> list, String word) {
        List<String> res = new LinkedList<>();
        res.addAll(list);
        res.add(word);
        return res;
    }

    public static void main(String[] args) {
        Set<String> set = new HashSet<>();
//        set.add("hot");
//        set.add("dot");
//        set.add("dog");
//        set.add("lot");
//        set.add("log");
//        set.add("a");
//        set.add("b");
//        set.add("c");
        set.add("ted");
        set.add("tex");
        set.add("red");
        set.add("tax");
        set.add("tad");
        set.add("den");
        set.add("rex");
        set.add("pee");
        List<List<String>> lists = findLadders("red", "tax", set);
        for (List<String> list : lists) {
            for (String s : list) {
                System.out.print(s + ',');
            }
            System.out.println("");
        }
    }

}
