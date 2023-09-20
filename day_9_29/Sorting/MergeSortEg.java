package day_9_29.Sorting;

import java.util.ArrayList;
import java.util.Scanner;

public class MergeSortEg {

    ArrayList merge(ArrayList<Integer> arr1,ArrayList<Integer> arr2){
        System.out.println("arr1");
        printArray(arr1);
        System.out.println("arr2");
        printArray(arr2);

        ArrayList arr=new ArrayList<>();
        Integer i=0,j=0;
        while(i<arr1.size() && j<arr2.size()){
            if(arr1.get(i)<arr2.get(j)){
                arr.add(arr1.get(i));
                i++;
            }
            else{
                arr.add(arr2.get(j));
                j++;
            }
        
        }
        while(i<arr1.size()){
                arr.add(arr1.get(i));
                i++;
        }
        while(j<arr2.size()){
                arr.add(arr2.get(j));
                i++;
        }
        return arr;
    }

    ArrayList mergeSort(ArrayList<Integer> arr,Integer left,Integer right){

        
        Integer mid=(left+right)/2;
        ArrayList arr1=new ArrayList<>();
        arr1.addAll(mergeSort(arr, left, mid));
        ArrayList arr2=new ArrayList<>();
        arr2.addAll(mergeSort(arr, mid+1, right));
        arr.clear();
        arr.addAll(merge(arr1, arr2));
        if(left>right){
        ArrayList ar=new ArrayList<>(arr.get(right));
        return ar;
        }
        return arr;
    }

    private void printArray(ArrayList<Integer> arr) {
        System.out.println("Elements in array");
        for(Integer i=0;i<arr.size();i++){
            System.out.print(arr.get(i)+" ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        ArrayList<Integer> arr=new ArrayList<>();
        MergeSortEg ms=new MergeSortEg();
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the list of element with space and at end of the list write \'b\'");
        while(sc.hasNextInt()){
            arr.add(sc.nextInt());
        }
        ms.printArray(arr);
        ms.mergeSort(arr, 0, arr.size());
        ms.printArray(arr);
    }

    
}
