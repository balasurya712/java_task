package Sorting;

import java.util.Scanner;

public class MergeSort {
    public static void main(String[] args) {
        System.out.println("Enter the array size");
        Scanner sc=new Scanner(System.in);
        Integer size=sc.nextInt();
        Integer arr[]=new Integer[size];
        System.out.println("Enter the list of elements");
        for(Integer i=0;i<size;i++){
            arr[i]=sc.nextInt();
        }
        System.out.println("element before sort");
        for(Integer i=0;i<size;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
        mergeSort(arr,0,size-1);
        System.out.println("element after sort");
        for(Integer i=0;i<size;i++){
            System.out.print(arr[i]+" ");
        }
        sc.close();
    }

    static void mergeSort(Integer[] arr, Integer start,Integer end) {
        if(start==end || start<0 || end<=0)
        return;
        Integer mid=(start+end)/2;
        mergeSort(arr, start, mid);
        mergeSort(arr, mid+1, end);
        merge(arr,start,mid,end);

    }

    private static void merge(Integer[] arr, Integer start, Integer mid, Integer end) {
        Integer temp;
        if(start==(end-1)){
            if(arr[start]>arr[end]){
                temp=arr[start];
                arr[start]=arr[end];
                arr[end]=temp;
            }
            return;
        }
        Integer midStart=mid+1;
        while(start<=midStart && midStart<=end){
            if(arr[start]>arr[midStart]){
                temp=arr[midStart];
                for(Integer i=midStart;i>start;i--){
                    arr[i]=arr[i-1];
                }
                arr[start]=temp;
                start++;
                midStart++;
            }
            else{
                start++;
            }
        }
    }

   
    
    
}
