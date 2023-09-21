package Sorting;

import java.util.Scanner;

public class CockTailSort {
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
        cockTailSort(arr,size);
        System.out.println("element after sort");
        for(Integer i=0;i<size;i++){
            System.out.print(arr[i]+" ");
        }
        sc.close();
    }

    static void cockTailSort(Integer[] arr, Integer size) {
        for(Integer i=0,tempSize=size-1;i<tempSize;i++,tempSize--){
            Integer min=i;
            Integer max=tempSize;
            Integer temp;
            for(Integer j=i+1;j<=tempSize;j++){
                if(arr[min]>arr[j]){
                    min=j;
                }
                if(arr[max]<arr[j]){
                    max=j;
                }
            }
            if(arr[i]>arr[min]){
                temp=arr[i];
                arr[i]=arr[min];
                arr[min]=temp;
            }
            if(arr[tempSize]<arr[max]){
                temp=arr[tempSize];
                arr[tempSize]=arr[max];
                arr[max]=temp;
            }
            
        }
    
    }
}
