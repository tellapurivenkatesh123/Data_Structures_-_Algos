package org.venki;
import java.util.*;
public class Graph {
    private int v;
    private List<List<Integer>> adj;

    public Graph(int v){
        this.v=v;
        adj=new ArrayList<>();

        for(int i=0;i<v;i++){
            adj.add(new ArrayList<>());
        }

    }

    public void addEdge(int u,int v){
        if(u<0||v<0)throw new IllegalArgumentException("invalid input");
        adj.get(u).add(v);
        adj.get(v).add(u);
    }

    public void addVertex(){
        adj.add(new ArrayList<>());
        v++;
    }

    public void display(){
        if(adj.isEmpty())throw new IllegalArgumentException("graph is empty");
        for(int i=0;i<v;i++){
            System.out.print(i+"-->");
            for(int j:adj.get(i)){
                System.out.print(j+",");
            }
            System.out.println();
        }
    }

    public void bfs(int root){
        if(adj.isEmpty()) throw new IllegalArgumentException("graph is empty");
        boolean[] visited=new boolean[v];
        Queue<Integer> q=new LinkedList<>();
        q.add(root);
        visited[root]=true;
        while(!q.isEmpty()){
            int size=q.size();
            for(int i=0;i<size;i++) {
                int current = q.remove();
                System.out.print(current + " ");

                for (int neighbor : adj.get(current)){
                    if(!visited[neighbor]){
                        visited[neighbor]=true;
                        q.add(neighbor);
                    }
                }
            }
            System.out.println();
        }
    }

    public void dfs(int root){
        if(adj.isEmpty())throw new IllegalArgumentException("graph is Empty");
        Stack <Integer> stack =new Stack<>();
        boolean[] visited=new boolean[v];
        stack.push(root);
        while(!stack.isEmpty()){
            int current=stack.pop();
            if(!visited[current]){
                visited[current]=true;
                System.out.print(current);
            }
            for(int neighbor:adj.get(current)){
                if(!visited[neighbor]){
                    stack.push(neighbor);
                }
            }
        }
    }

    public boolean hasEdge(int u,int v){
        if(adj.isEmpty())throw new IllegalArgumentException("graph is empty");
        return (adj.get(u).contains(v));
    }

    public List<Integer> getNeighbor(int u){
        if(adj.isEmpty())throw new IllegalArgumentException("graph is empty");
        return adj.get(u);
    }

    public boolean hasCycle(int parent){
        if(adj.isEmpty())throw new IllegalArgumentException("graph is empty");
        boolean visited[]=new boolean[v];
        for(int i=0;i<v;i++){
            if(!visited[i]){
                if(dfsCycle(i,visited,parent))
                    return true;
            }
        }
        return false;
    }

    public boolean dfsCycle(int node,boolean[] visited,int parent){
        visited[node]=true;
            for(int neighbor: adj.get(node)){
                if(!visited[neighbor]){
                    dfsCycle(neighbor,visited,node);
                    return true;
                }
                else if(neighbor!=parent)
                    return true;
            }

        return false;
    }


}
