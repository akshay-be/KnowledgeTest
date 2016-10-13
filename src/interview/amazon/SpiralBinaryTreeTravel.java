package interview.amazon;

import java.util.Stack;

/**
 * Spiral tree parsing using stack.
 * @author AkshayB1
 *
 */
public class SpiralBinaryTreeTravel {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(0);
		TreeNode n1 = new TreeNode(1);
		TreeNode n2 = new TreeNode(2);
		TreeNode n3 = new TreeNode(3);
		TreeNode n4 = new TreeNode(4);
		TreeNode n5 = new TreeNode(5);
		TreeNode n6 = new TreeNode(6);
		TreeNode n7 = new TreeNode(7);
		TreeNode n8 = new TreeNode(8);
		TreeNode n9 = new TreeNode(9);
		TreeNode n10 = new TreeNode(10);
		TreeNode n11 = new TreeNode(11);
		TreeNode n12 = new TreeNode(12);
		TreeNode n13 = new TreeNode(13);

		root.left = n1;
		root.right = n2;

		n1.left = n3;
		n1.right = n4;

		n2.left = n5;
		n2.right = n6;

		n4.left = n7;
		n4.right = n8;

		n6.left = n9;
		
		n7.left = n10;
		n7.right = n11;
		
		n9.left = n12;
		n9.right = n13;
		
		
		spiralTraversal(root);
	}
	
	static void spiralTraversal(TreeNode root){
		
		if(root==null){
			return;
		}
		
		Stack<TreeNode> stackEven = new Stack<TreeNode>();
		Stack<TreeNode> stackOdd = new Stack<TreeNode>();
		
		stackEven.push(root);
		boolean evenLevel = true;
		
		 while (!stackEven.isEmpty() || !stackOdd.isEmpty()){
			
			 if(evenLevel){
				 //System.out.println("evenLevel");
				 while(!stackEven.isEmpty()){
					 TreeNode currentNode = stackEven.pop();
					 System.out.print(" "+currentNode.value);
					 
					 if(currentNode.right!=null){
						 stackOdd.push(currentNode.right);
					 }
					 
					 if(currentNode.left!=null){
						 stackOdd.push(currentNode.left);
					 }
					 //System.out.println("Even : "+stackEven);
				 }
				 evenLevel = false;
			 }else{
				// System.out.println("oddLevel");
				 while(!stackOdd.isEmpty()){
					 TreeNode currentNode = stackOdd.pop();
					 System.out.print(" "+currentNode.value);
					 
					 if(currentNode.left!=null) {
						 stackEven.push(currentNode.left);
					 }
					 
					 if(currentNode.right!=null) {
						 stackEven.push(currentNode.right);
					 }
					// System.out.println("Odd : "+stackOdd);
				 }
				 evenLevel = true;
			 }
			
		 }
	}
}

class TreeNode {

	TreeNode left;
	TreeNode right;
	int value;

	public TreeNode(int value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return "[" + value + "]";
	}

	
}
