package com.xms.structure.graph;

import java.util.Arrays;

/**
 * Created by xms on 2017/8/19.
 */
public class DijKatra {
	public static int M = Integer.MAX_VALUE;
	public int MAXNUM = 10;
	int[] dist = new int[MAXNUM];
	int[] prev = new int[MAXNUM];
	public static int[][] G = {
			/********A  B  C  D  E  F ********/
			/* A */{ 0, 6, 3, M, M, M }, 
			/* B */{ 6, 0, 2, 5, M, M }, 
			/* C */{ 3, 2, 0, 3, 4, M },
			/* D */{ M, 5, 3, 0, 2, 3 }, 
			/* E */{ M, M, 4, 2, 0, 5 },
			/* F */{ M, M, M, 3, 5, 0 } 
			};
	static char[] sets = {'A','B','C','D','E','F'}; 

	public static void DijDatra(int[][] G, int v0) {
		int n = G[0].length;
		boolean[] S = new boolean[n];
		int[] dist = new int[n];
		int[] prev = new int[n];
		for (int i = 0; i < n; i++) {
			dist[i] = G[v0][i];
			S[i] = false;
			if (dist[i] == Integer.MAX_VALUE) {
				prev[i] = -1;
			} else {
				prev[i] = v0;
			}
		}

		dist[v0] = 0;
		S[v0] = true;
		for (int i = 1; i < n; i++) {
			int mindist = Integer.MAX_VALUE;
			int u = v0;
			for (int j = 0; j <n; ++j)
				if ((!S[j]) && dist[j] < mindist) {
					u = j;
					mindist = dist[j];
				}
			S[u] = true;
			for (int j = 0; j <n; j++)
				if ((!S[j]) && G[u][j] < Integer.MAX_VALUE) {
					if (dist[u] + G[u][j] < dist[j])
					{
						dist[j] = dist[u] + G[u][j];
						prev[j] = u;
					}
				}
		}
		System.out.println(Arrays.toString(dist));
		String str ="";
//		print(5,prev,str);
	}

	private static void print(int i,int[] prev,String s) {
		
		if(i==0){
			s=sets[i]+s;
			System.out.print(s);
}
		else{
			s=sets[i]+s;
			print(prev[i],prev,s);
		}
	}

	public static void main(String[] args) {
		DijDatra(G,1);
	}
}