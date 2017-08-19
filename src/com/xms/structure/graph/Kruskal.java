package com.xms.structure.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by xms on 2017/8/19.
 */
public class Kruskal {

	public static void kruskal(int[][] G){
		int n = G.length;
		List<Node> list = new ArrayList<>();
		
		for(int i=0;i<n;i++){
			for(int j =i+1;j<n;j++){
				if(G[i][j]<Integer.MAX_VALUE){					
					list.add(new Node(i,j,G[i][j]));
				}
			}
		}
		Node[] node = new Node[list.size()];
		int j=0;
		for(Node e:list){
			node[j++] = e;
		}
		int[] parent = new int[n];
		Arrays.sort(node);
		for(int i =0;i<node.length;i++){
			int k = find(parent,node[i].begin);
			int l = find(parent,node[i].end);
			if(k!=l){
				parent[k] = l;
				System.out.println("("+node[i].begin+","+node[i].end+") "+node[i].weight);
			}
//			System.out.println("("+node[i].begin+","+node[i].end+") "+node[i].weight);
		}
		System.out.println(Arrays.toString(parent));
	}

	private static int find(int[] parent, int f) {
		while(parent[f]>0){
			f=parent[f];
		}
		return f;
	}
	public static void main(String[] args) {
		kruskal(Floyd.G);
	}
}
class Node implements Comparable<Node>{
	public int begin;
	public int end;
	public int weight;
	public Node(int begin, int end, int weight) {
		super();
		this.begin = begin;
		this.end = end;
		this.weight = weight;
	}
	@Override
	public int compareTo(Node o) {
		// TODO Auto-generated method stub
		return Integer.compare(this.weight, o.weight);
	}
	
}
