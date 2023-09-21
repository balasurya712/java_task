package Sorting;

import java.util.Scanner;

public class BubbleSort {
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
        bubbleSort(arr,size);
        System.out.println("element after sort");
        for(Integer i=0;i<size;i++){
            System.out.print(arr[i]+" ");
        }
        sc.close();
    }

    static void bubbleSort(Integer[] arr, Integer size) {
        for(Integer i=size-1;i>0;i--){
            Integer temp;
            for(Integer j=0;j<i;j++){
                if(arr[j]>arr[j+1]){
                    temp=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;
                }
            }
        }
    
    }
}
