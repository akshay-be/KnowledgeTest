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
		
		buildHeap(nodeArr, n);
		
		return 0;
	}
	
	public static void buildHeap(HeapNode[] arr, int n) {
        int i = (n -1)/2;
        while (i >= 0) {
            minHeapify(arr, i, n);
            i--;
        }
    }
	
	
	public static void minHeapify(HeapNode arr[], int i, int heap_size) {
        int l = i*2 + 1;
        int r = i*2 + 2;
        int smallest = i;
        if (l < heap_size && arr[l].data < arr[i].data)
            smallest = l;
        if (r < heap_size && arr[r].data < arr[smallest].data)
            smallest = r;
        if (smallest != i ) {
            HeapNode tmp = new HeapNode(arr[i]);
            arr[i] = new HeapNode(arr[smallest]);
            arr[smallest] = new HeapNode(tmp);
            minHeapify(arr, smallest, heap_size);
        }
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
