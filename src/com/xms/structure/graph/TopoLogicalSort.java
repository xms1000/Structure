package com.xms.structure.graph;

import java.util.Stack;

/**
 * Created by xms on 2017/8/19.
 */
public class TopoLogicalSort {
	public static boolean topoLogicalSort(EdgeNode[] nodes,Stack<Integer> stack,int[] etv) {
		Stack<Integer> stack1 = new Stack<>();
		Stack<Integer> stack2 = stack;
		for (int i = 0; i < nodes.length; i++) {
			if (nodes[i].in == 0) {
				stack1.add(i);
			}
		}
		while (!stack1.isEmpty()) {
			int top = stack1.pop();
			stack2.push(top);

			VertexNode vertexNode = nodes[top].firstedge;
			while (vertexNode != null) {
				int k  = vertexNode.adjvex;
				if ((--nodes[k].in) == 0) {
					stack1.push(k);
				}
				if(etv[k]<etv[top]+vertexNode.weight){
					etv[k] = etv[k]+vertexNode.weight;
				}
				vertexNode = vertexNode.next;
			}
		}
		if(stack2.size()==nodes.length){
			return true;
		}else{
			return false;
		}
	}
	public static void CriticalPaht(EdgeNode[] nodes){
		Stack<Integer> stack = new Stack<>();
		int n = nodes.length;
		int[] etv = new int[n];
		int[] ltv = new int[n];
		topoLogicalSort(nodes,stack,etv);
		for(int i =0;i<n;i++){
			ltv[i] = etv[n-1];
		}
		while(!stack.isEmpty()){
			int top = stack.pop();
			VertexNode vertexNode = nodes[top].firstedge;
			while(vertexNode!=null){
				int k = vertexNode.adjvex;
				if(ltv[k]>ltv[top]-vertexNode.weight){
					ltv[k] = ltv[top]-vertexNode.weight;
				}
				vertexNode =vertexNode.next;
			}
		}
		for(int i=0;i<n;i++){
			VertexNode vertexNode = nodes[i].firstedge;
			while(vertexNode!=null){
				int k = vertexNode.adjvex;
				if(etv[i]==ltv[k]-vertexNode.weight){
					System.out.println(i+" "+k+" "+vertexNode.weight);
				}
				vertexNode = vertexNode.next;
			}
		}
		
		
	}
}

class EdgeNode {
	public int in;
	public String data;
	public VertexNode firstedge;
}

class VertexNode {
	public int adjvex;
	public int weight;
	public VertexNode next;
}
