package DSA.HeapAndHashMap;

import java.util.ArrayList;

public class MinHeap {
    ArrayList<Integer> arr = new ArrayList<>(); // saving CBT + HPT tree as an array.

    public MinHeap(ArrayList<Integer> arr) {
        this.arr = new ArrayList<>();
    }
    private int getParent(int i){
        return (i-1)/2;
    }
    private int leftChild(int i){
        return (2*i+1)/2;
    }
    private int rightChild(int i){
        return (2*i+2)/2;
    }

    public void addValue(int val){
        arr.add(val);
        if(arr.size() == 1) return;
        upheapify(arr.size()-1);
    }

    public int remove(){
       if(arr.size()==1){
           int temp = arr.get(0);
           arr.remove(0);
           return temp;
       }
       swapValues(0, arr.size()-1);
       int temp = arr.get(arr.size()-1);
       arr.remove(arr.size()-1);
       downHeapify(0);
       return temp;
    }

    public int peek(){
        if(arr.size()==0) return -1;
        else return arr.get(0);
    }

    private void downHeapify(int i) {
        int maxIndex = arr.size()-1;
        int leftChildIndex = leftChild(i);
        int rightChildIndex = rightChild(i);
        if(leftChildIndex> maxIndex) return;
        if(rightChildIndex>maxIndex){
            if(arr.get(leftChildIndex)< arr.get(i)) swapValues(leftChildIndex, i);
            return;
        }
        if(arr.get(i)< arr.get(leftChildIndex) && arr.get(i)< arr.get(rightChildIndex)) return;
        else {
            if(arr.get(leftChildIndex)<arr.get(rightChildIndex)){
                swapValues(i, leftChildIndex);
                downHeapify(leftChildIndex);
            } else {
                swapValues(i, rightChildIndex);
                downHeapify(rightChildIndex);
            }
        }
    }

    private void upheapify(int index) {
        if(index==0) return;
        int pIndex = getParent(index);
        if(arr.get(pIndex)> arr.get(index)){ // smaller element at top
            swapValues(pIndex, index);
            upheapify(pIndex);
        }
    }

    private void swapValues(int pIndex, int index) {
        int temp = arr.get(pIndex);
        arr.set(pIndex, arr.get(index));
        arr.set(index, temp);
    }

}
