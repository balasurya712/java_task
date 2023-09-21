package Sorting;

import java.util.Scanner;

public class QuickSort {
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
        quickSortPivotMid(arr,0,size-1);
        System.out.println("element after sort");
        for(Integer i=0;i<size;i++){
            System.out.print(arr[i]+" ");
        }
        sc.close();
    }

    static void quickSortPivotEnd(Integer[] arr, Integer start,Integer end) {
        if(start==end || start<0 || end<=0)
        return;
        Integer pivot=arr[end];
        Integer front=start,back=end-1;
        Integer temp;
        while(front<back){
            if(arr[front]<pivot)
            front++;
            else if(arr[back]>pivot)
            back--;
            else{
                temp=arr[front];
                arr[front]=arr[back];
                arr[back]=temp;
                front++;
                back--;
            }
        }
        if(arr[front]>pivot){
            temp=arr[front];
            arr[front]=arr[end];
            arr[end]=temp;
        }
        if(start==(end-1))
        return;
        quickSortPivotEnd(arr, start, front-1);
        quickSortPivotEnd(arr, front+1, end);

    
    }

    static void quickSortPivotMid(Integer[] arr, Integer start,Integer end) {
        if(start==end || start<0 || end<=0)
        return;
        Integer pivot=arr[(start+end)/2];
        Integer front=start,back=end;
        Integer temp;
        while(front<back){
            if(arr[front]==pivot)
            front++;
            else if(arr[front]==pivot)
            back--;
            else if(arr[front]<pivot)
            front++;
            else if(arr[back]>pivot)
            back--;
            else{
                temp=arr[front];
                arr[front]=arr[back];
                arr[back]=temp;
                front++;
                back--;
            }
        }
        if(arr[front]>pivot){
            temp=arr[front];
            arr[front]=arr[end];
            arr[end]=temp;
        }
        if(start==(end-1))
        return;
        quickSortPivotMid(arr, start, front-1);
        quickSortPivotMid(arr, front+1, end);

    
    }
}
