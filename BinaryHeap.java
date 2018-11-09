public class BinaryHeap {
    private int[] arr;
    private int capacity;
    private int size;

    public BinaryHeap(){
        this(10);
    }
    public BinaryHeap(int eger){
    capacity = eger;
    arr = new int[capacity];
    size = 0;
    }
    public void add(int obj){
        if(size == arr.length){
            doubleArr();
        }
        size++;
        arr[size - 1] = obj;
        shiftUp(size - 1);
    }
    public int remove(){
        if(arr.length == 0){
            throw new IllegalArgumentException();
        }
        int tbr = arr[0];
        arr[0] = arr[size - 1];
        size--;
        shiftDown(0);
        return tbr;
    }
    public void shiftDown(int parent){
        int child;
        int lChild = (2*parent+1);
        int rChild = (2*parent+2);
        if(rChild >= size){
            if(lChild >= size){
                return;
            } 
            else{
                child = lChild;
            }
        }
        else{
            if(arr[lChild] <= arr[rChild]){
                child = lChild;
            }
            else{
                child = rChild;
            }
        }
        if(arr[parent] > arr[child]){
            swap(arr, child, parent);
            shiftDown(child);
        }
        return;
    }
    public void shiftUp(int index) {
        int parIndex, temp; 
        if (index != 0){
            parIndex = (index-1)/2; 
            if (arr[parIndex] > arr[index]) {
                swap(arr, parIndex, index);
                shiftUp(parIndex);
            }
        }
    } 
/*    private boolean isleaf(int pos){
        return ((pos > size/2) && (pos <= size));
    }*/
    public void doubleArr(){
        int[] newArr = new int[capacity*2];
        for(int i = 0; i < capacity; i++){
            newArr[i] = arr[i];
        }
        arr = newArr;
        capacity = capacity*2;
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