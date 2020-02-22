/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package lab03;

/**
 *
 * @author 18201214
 */

import java.io.File; 
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner; 
public class Task03DalaiLama
{
public static final int WHITE = 0;
public static final int GRAY = 1;
public static final int BLACK = 2;
public static int bridges = -1;
public static int T = 1;
public static void main(String[] args) throws FileNotFoundException 
{ 
	// pass the path to the file as a parameter 

	Scanner sc = new Scanner(System.in); 
         int t = sc.nextInt();
       while(T<=t){ 
        int vertices = sc.nextInt();
        int bridge = sc.nextInt();
        int [][] adjMat = new int[vertices][vertices]; 
       	while (bridge>0) {
            int i = sc.nextInt()-1;
            int j = sc.nextInt()-1;
            adjMat[i][j]++;
            adjMat[j][i]++;
            bridge--;
        }         
     
      
        BFS(adjMat,0);
        bridges = -1;
       T++;
       }
} 

public static void BFS(int[][]G , int s){
	/*colors will be white, parent will be zero and  by default, 
	so skipping those*/
	int[] colors = new int[G[0].length];
	int[] parent = new int[G[0].length];
	
	int []distance = new int[G[0].length];
	for(int i = 1;i<G[0].length;i++)distance[i] = 0;
	
		
	colors[s] = GRAY;
	distance[s] = 0;
	parent[s] = s;
	
	Queue <Integer>Q = new LinkedList<Integer>();
	Q.add(s);
	
	while(!Q.isEmpty()){
		int u = Q.remove();
		for(int v = 0; v<G[0].length; v++){
			if(G[u][v] == 1){
			if(colors[v]==WHITE){
				
				colors[v] = GRAY;
				distance[v] = distance[u]+1;
				parent[v] = u;
				Q.add(v);
				
			}
                       }
		colors[u] = BLACK;	
		}
	}
	
	
        String path = getPath(distance.length-1, parent,s);
    System.out.println("TestCase "+T+"\nTotal Bridges:"+ bridges + "\nPath:"+path+"\n");

}


public static String getPath(int v, int [] parent, int source){
    bridges++;    
    if(v == source) return (source+1)+"";
    
    return getPath(parent[v],parent,source) +"->" + (v+1);

}
}