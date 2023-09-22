package day_9_29;

import java.util.*;

public class BinarySearch {

    static Integer search(Integer ele,ArrayList<Integer> arr){
        Integer l=0,r=arr.size();
        Integer mid;
        while(l<r){
            mid=(l+r)/2;
            if(arr.get(mid)<ele)
            l=mid+1;
            else if(arr.get(mid)>ele)
            r=mid-1;
            else if(arr.get(mid)==ele)
            return mid;
        }
        return -1;
    }
    public static void main(String[] args) {
        ArrayList<Integer> arr=new ArrayList<>();
        Scanner sc=new Scanner(System.in);
        Integer a;
        while(true){
            System.out.println("Would you like to add element 1.yes 2.no");
            Integer choise=sc.nextInt();
            if(choise==2)
            break;
            System.out.println("Enter the Element value");
            a=sc.nextInt();
            arr.add(a);
        }
        Collections.sort(arr);
        Integer res;
        while(true){
            System.out.println("Enter the element to search");
            res=search(sc.nextInt(), arr);
            if(res==-1)
            System.out.println("Element not found");
            else
            System.out.println( "Element found at: "+res);
            System.out.println("Would you like to continue searching 1.yes 2.no");
            if(sc.nextInt()==2)
            break;
            }
    }
}
