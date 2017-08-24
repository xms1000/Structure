package com.xms.examination.toutiao;

import java.util.*;

/**
 * Created by xms on 2017/8/23.
 */

public class Main {
    static class Node implements Comparable<Node> {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Node o) {
            return x == o.x ? y - o.y : x - o.x;
        }

        @Override
        public String toString() {
            return x + " " + y;
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int n = in.nextInt();
            Node[] nodes = new Node[n];
            for (int i = 0; i < n; i++) {
                nodes[i] = new Node(in.nextInt(), in.nextInt());
            }
            Arrays.sort(nodes, Collections.<Node>reverseOrder());
            TreeSet<Node> result = new TreeSet<>();
            int max = Integer.MIN_VALUE;
            for (Node node : nodes) {
                if (node.y > max) {
                    max = node.y;
                    result.add(node);
                }
            }
            for (Node node : result) {
                System.out.println(node.toString());
            }
        }
        in.close();
    }
}
