package interview.amazon;


public class KthSmallestElementRowAndColumnSorted2DArray {

	public static void main(String[] args) {
		  int mat[][] ={  {10, 20, 30, 40},
                  {15, 25, 35, 45},
                  {25, 29, 37, 48},
                  {32, 33, 39, 50},
               };
		int k = 2;
		int res1 = kthSmallest(mat, k);
		System.out.println(k + "th smallest element is: " + res1);

	}

	private static int kthSmallest(int[][] matrix, int k) {
		int n = matrix.length;
		
		HeapNode[] nodeArr = new HeapNode[n];
		for(int i=0;i<matrix.length;i++){
			nodeArr[i] = new HeapNode();
            nodeArr[i].data = matrix[0][i];
            nodeArr[i].r = 0;
            nodeArr[i].c = i;
		}
		return 0;
	}
}


class HeapNode {
    int data, r, c;

    public HeapNode() {
        this.data = data;
        this.r = r;
        this.c = c;
    }

    public HeapNode(HeapNode node) {
        this.data = node.data;
        this.r = node.r;
        this.c = node.c;
    }

}
