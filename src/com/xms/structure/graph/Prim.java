package com.xms.structure.graph;
/**
 * Created by xms on 2017/8/19.
 */

public class Prim {

	public static void prim(int[][] G) {
		int n = G.length;
		int[] lowcast = new int[n];
		int[] adjvex = new int[n];
		lowcast = G[0];
		int k = 0;
		for(int i =1;i<n;i++){
			int min =Integer.MAX_VALUE;
			for(int j=1;j<n;j++){
				if(lowcast[j]!=0&&lowcast[j]<min){
					min = lowcast[j];
					k = j;
				}
			}
			System.out.println("("+adjvex[k]+","+k+") "+G[adjvex[k]][k]);
			lowcast[k] = 0;
			for(int j =1 ;j<n;j++){
				if(lowcast[j]!=0&&G[k][j]<lowcast[j]){
					lowcast[j]= G[k][j];
					adjvex[j] = k;
				}
			}
		}
	}
	public static void main(String[] args) {
		prim(Floyd.G);
	}
}
