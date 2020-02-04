import java.io.File; 
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner; 
public class Main
{
public static final int WHITE = 0;
public static final int GRAY = 1;
public static final int BLACK = 2;
public static void main(String[] args) throws FileNotFoundException 
{ 
	// pass the path to the file as a parameter 
	String file_dir = "C:\\Users\\18201214\\Desktop\\New folder\\src\\graph.txt";
	File file = new File(file_dir); 
	Scanner sc = new Scanner(file); 
        int vertices = sc.nextInt() + 1;
        int [][] adjMat = new int[vertices][vertices]; 
       	while (sc.hasNextInt()) {
            int i = sc.nextInt();
            int j = sc.nextInt();
            adjMat[i][j]++;
            adjMat[j][i]++;
            
        }         
     
      
BFS(adjMat,1);
} 

public static void BFS(int[][]G , int s){
	/*colors will be white, parent will be zero and  by default, 
	so skipping those*/
	int[] colors = new int[G[0].length];
	Object[] parent = new Object[G[0].length];
	
	int []distance = new int[G[0].length];
	for(int i = 1;i<G[0].length;i++)distance[i] = -1;
	
		
	colors[s] = GRAY;
	distance[s] = 0;
	parent[s] = null;
	
	Queue <Integer>Q = new LinkedList<Integer>();
	Q.add(s);
	
	while(!Q.isEmpty()){
		
		int u = Q.remove();
		for(int v = 1; v<G[0].length; v++){
			
			if(colors[v]==WHITE){
				
				colors[v] = GRAY;
				distance[v] = distance[u]+1;
				parent[v] = u;
				Q.add(v);
				
			}
		colors[u] = BLACK;	
		}
	}
	
	
for(int color:colors)System.out.println(color);	
for(int d:distance)System.out.println("1"+d);
for(Object p:parent)System.out.println("2"+p);
}
}