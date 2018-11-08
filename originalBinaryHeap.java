public class BinaryHeap {
    private int[] arr;
    private int length;
    private int size;

    public BinaryHeap(){
    	this(10);
    }
    public BinaryHeap(int max){
	length = max;
	arr = new int[length];
	size = 0;
    }
    // public void add(int num){
    // 	arr[size] = num;
    // 	++size;
    // 	int index = size - 1;
    // 	int parent = (index-1)/2;
    // 	while(index > 0 && arr[index] < arr[parent]){
    // 		swap(arr, index, parent);
    // 		int temp = index;
    // 		index = parent;
    // 		parent = (temp-1)/2;
    // 	}
    // }

    public void add(int obj) {
        if(size==length){
        	doubleArr();
        }
        size++;
        int idx = size;
       	arr[idx] = obj;
        int parent = idx/2;
        int index = idx;
        while (index > 0 && arr[parent] > arr[index]) {
            swap(arr,index,parent);
            index = parent;
            parent = parent/2;
        }
    }

    public void bubbleUp(int pos) {
        int parent = pos/2;
        int index = pos;
        while (index > 0 && arr[parent] > arr[index]) {

            swap(arr,index,parent);
            index = parent;
            parent = parent/2;
        }
    }

    public int remove() {
        int min = arr[1];
        arr[1] = arr[size];
        arr[size] = 0;
        sinkDown(1);
        size--;
        return min;
    }

    public void sinkDown(int k) {
        int smallest = k;
        int leftChildIdx = 2 * k;
        int rightChildIdx = 2 * k+1;
        if (leftChildIdx < size && arr[smallest] > arr[leftChildIdx]) {
            smallest = leftChildIdx;
        }
        if (rightChildIdx < size && arr[smallest] > arr[rightChildIdx]) {
            smallest = rightChildIdx;
        }
        if (smallest != k) {

            swap(arr, k, smallest);
            sinkDown(smallest);
        }
    }



    // public int remove(){
    // 	int first = arr[0];
    // 	arr[0] = arr[size-1];
    // 	--size;
    // 	shiftDown(0);
    // 	return first;
    // }
    // private void shiftDown(int parent){
    // 	if(isleaf(parent)){
    // 		return;
    // 	}
    // 	int child = (parent*2)+1;
    // 	if(arr[child+1]<arr[child]){
    // 		child++;
    // 	}
    // 	if(arr[parent]>arr[child]){
    // 		swap(arr, child, parent);
    // 		shiftDown(child);
    // 	}
    // }
/*    private int leftchild(int pos){
		return 2*pos;
    }
    private int rightchild(int pos){
		return 2*pos + 1;
    } */
    private boolean isleaf(int pos){
		return ((pos > size/2) && (pos <= size));
    }
    public void doubleArr(){
    	int[] newArr = new int[length*2];
    	for(int i = 0; i < arr.length; i++){
    		newArr[i] = arr[i];
    	}
    	arr = newArr;
    }
   	private void swap(int[] arr, int pos1, int pos2){
		int tmp;
		tmp = arr[pos1];
		arr[pos1] = arr[pos2];
		arr[pos2] = tmp;
    }

    public static void main(String[] args){

    }

}