package Sorting;

import java.util.Scanner;

public class SelectionSort {
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
        selectionSort(arr,size);
        System.out.println("element after sort");
        for(Integer i=0;i<size;i++){
            System.out.print(arr[i]+" ");
        }
        sc.close();
    }

    static void selectionSort(Integer[] arr, Integer size) {
        for(Integer i=0;i<size-1;i++){
            Integer min=i;
            Integer temp;
            for(Integer j=i+1;j<size;j++){
                if(arr[min]>arr[j]){
                    min=j;
                }
            }
            if(arr[i]>arr[min]){
                temp=arr[i];
                arr[i]=arr[min];
                arr[min]=temp;
            }
        }
    
    }
}
