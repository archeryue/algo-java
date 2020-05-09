package com.archer.other;

/**
 * archeryue
 * 9/20/16
 */
public class T01 {

    public int[] getArray(int a[]) {
        int[] b = new int[a.length];
        int[] head = new int[a.length - 1];
        int[] tail = new int[a.length - 1];
        head[0] = a[0];
        tail[0] = a[a.length - 1];
        for (int i = 1; i < a.length - 1; i++) {
            head[i] = head[i - 1] * a[i];
            tail[i] = tail[i - 1] * a[a.length - i - 1];
        }
        b[0] = tail[0];
        b[a.length - 1] = head[a.length - 2];
        for (int i = 1; i < a.length - 1; i++) {
            b[i] = head[i - 1] * tail[a.length - i - 2];
        }
        return b;
    }

}
