package com.citrix.f2f;

import java.util.HashMap;

/**
 * Program to implement Most recent used cache.
 * @author AkshayB1
 *
 */
public class TestMostRecentUsedCache {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

class Node {

	Object key;
	Object value;
	Node prev;
	Node next;

	public Node(Object key, Object value) {
		this.key = key;
		this.value = value;
	}
}

class MosrRecentUsedCache {

	int capacity;
	HashMap<Object, Node> mapData = new HashMap<Object, Node>();
	Node head = null;
	Node end = null;

	public MosrRecentUsedCache() {
		this(100);
	}

	public MosrRecentUsedCache(int capacity) {
		this.capacity = capacity;
	}
	
	public void set(Object key,Object value){
		if(mapData.containsKey(key)){
			Node old = mapData.get(key);
			old.value=value;
			remove(old);
			setHead(old);
		}else{
			Node newNode = new Node(key,value);
			if(mapData.size()>capacity){
				mapData.remove(end.key);
				remove(end);
			}
			setHead(newNode);
			mapData.put(newNode.key, newNode);
			
		}
	}
	
	public Object get(Object key){
		if(mapData.containsKey(key)){
			Node node = mapData.get(key);
			remove(node);
			setHead(node);
			return node.value;
		}
		return null;
	}

	private void setHead(Node node) {
		node.next=head;
		node.prev=null;
		
		if(head!=null){
			head.prev=node;
		}
		
		head=node;
		
		if(end==null){
			end=head;
		}
		
	}

	private void remove(Node node) {
		if(node.prev!=null){
			node.prev.next = node.next;
		}else{
			head = node.next;
		}
		
		if(node.next!=null){
			node.next.prev = node.prev;
		}else{
			end= node.prev;
		}
		
	}

}
