package day_9_29.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Scanner;

import day_7.Queue;

public class GraphBFS {
    static HashMap<Integer,ArrayList<Integer>> node= new HashMap<>();

    static void bfs(Integer orgin){
        PriorityQueue<Integer> que=new PriorityQueue<>();
        ArrayList<Integer> visited=new ArrayList<>();
        que.add(orgin);
        Integer cur;
        while(!que.isEmpty()){
            cur=que.poll();
            if(visited.contains(cur))
            continue;
            visited.add(cur);
            System.out.print(cur+" ");
            que.addAll(node.get(cur));
        }
        System.out.println();
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        PriorityQueue<Integer> que=new PriorityQueue<>();
        Integer child;
        while(true){
            System.out.println("Would you like to add a node 1.yes 2.no");
            if(sc.nextInt()==2)
            break;
            System.out.println("Enter the element");
            Integer cur=sc.nextInt();
            if(!node.containsKey(cur))
            node.put(cur, new ArrayList<>());
            que.add(cur);
            while(!que.isEmpty()){
            cur=que.poll();
            if(node.containsKey(cur) && node.get(cur).size()>0)
            continue;
            System.out.println("Would you like to add a child node for "+cur+"  1.yes 2.no");
            Integer choise=sc.nextInt();
            if(choise==2){
            continue;
            }
           
            System.out.println("Enter the list of element with space and at end of the list write \'b\'");
            while(sc.hasNextInt()){
                child=sc.nextInt();
                node.get(cur).add(child);
                que.add(child);
                if(!node.containsKey(child))
                node.put(child, new ArrayList<>()); 
            }
            sc.nextLine();
        }
        }

        System.out.println(node);
        while(true){
            System.out.println("Would you like to do bfs 1.yes 2.no");
            Integer choise=sc.nextInt();
            if(choise==2)
            break;
            System.out.println("Enter the orgin element");
            Integer orgin=sc.nextInt();
            bfs(orgin);
        }
        
    }
    
}
