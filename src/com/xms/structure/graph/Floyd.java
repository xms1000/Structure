package com.xms.structure.graph;

import java.util.Arrays;

/**
 * Created by xms on 2017/8/19.
 */
public class Floyd {
	public static int M = Integer.MAX_VALUE;
	public static int[][] G = {
			/********A  B  C  D  E  F ********/
			/* A */{ 0, 1, 3, M, M, M }, 
			/* B */{ 1, 0, 2, 5, M, M }, 
			/* C */{ 3, 2, 0, 3, 4, M },
			/* D */{ M, 5, 3, 0, 2, 3 }, 
			/* E */{ M, M, 4, 2, 0, 5 },
			/* F */{ M, M, M, 3, 5, 0 } 
			};
	public static void floyd(int[][] G){
		int n = G.length;
		int[][] D= new int[n][n];
		int[][] P= new int[n][n];
		for(int i= 0;i<n;i++){
			for(int j=0;j<n;j++){
				D[i][j]=G[i][j];
				P[i][j]=j;
 			}
		}
		for(int i= 0;i<n;i++){
			for(int j=0;j<n;j++){
				for(int k=0;k<n;k++){
					if(D[j][i]<M&&D[i][k]<M&&D[j][k]>D[j][i]+D[i][k]){
						D[j][k]=D[j][i]+D[i][k];
						P[j][k]=P[j][i];
					}
				}
 			}
		}
		System.out.println(Arrays.deepToString(D));
		System.out.println(Arrays.deepToString(P));
	}
	public static void main(String[] args) {
		floyd(G);
	}
}