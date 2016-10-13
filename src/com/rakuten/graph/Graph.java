package com.rakuten.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Graph {

	List<Node> nodes = new ArrayList<Node>();
	List<Edge> edges = new ArrayList<Edge>();
	
	
	boolean isCycllicGraph(Node node){
		
		if(node==null)
			return false;
		
			node.visted = true;
			LinkedList<Node> connecting = getAllNoodesConnecting(node);
			for(Node temp : connecting) {
				if(temp.visted){
					return true;
				}else{
					isCycllicGraph(temp);
				}
			}
			return false;
		
	}
	
	
	LinkedList<Node> getAllNoodesConnecting(Node node){
		LinkedList<Node> nodes = new LinkedList<Node>();
		for(Edge e : edges){
			if(node.equals(e.start)){
				nodes.add(e.end);
			}
		}
		return nodes;
	}
	
}


class Node {
	
	int value;
	boolean visted = false;
	
	
}

class Edge {
	 Node start;
	 Node end;
}