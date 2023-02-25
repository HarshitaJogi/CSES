import java.io.*;
import java.util.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class labyrinth{

	static class FastReader {
        BufferedReader br;
        StringTokenizer st;
  
        public FastReader()
        {
            br = new BufferedReader(
                new InputStreamReader(System.in));
        }
  
        String next()
        {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                }
                catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }
  
        int nextInt() { return Integer.parseInt(next()); }
  
        long nextLong() { return Long.parseLong(next()); }
  
        double nextDouble()
        {
            return Double.parseDouble(next());
        }
  
        String nextLine()
        {
            String str = " ";
            StringTokenizer st = new StringTokenizer(str);
            try {
                if(st.hasMoreTokens()){
                    str = st.nextToken("\n");
                }
                else{
                    str = br.readLine();
                }
            }
            catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }

	static int n,m;
    static int [][] map = new int [1005][1005];
    static boolean [][] vis = new boolean [1005][1005];
    static int [][] level = new int [1005][1005]; 

    public static void main(String[] args) {
		

		try {
			System.setIn(new FileInputStream("input.txt"));
			System.setOut(new PrintStream(new FileOutputStream("output.txt")));
		} catch (Exception e) {
			System.err.println("Error");
		}
		FastReader sc = new FastReader();
		
        n = sc.nextInt();
        m = sc.nextInt();

        int si=0;
        int sj = 0;
        int ei = 0;
        int ej = 0;

        for(int i=0; i<n; i++){
            String s = sc.nextLine();
            //System.out.println(s);
            for(int j=0; j<m; j++){
                char c = s.charAt(j);
                //System.out.println(c);
                if(c == '.') map[i][j] = 1;
                else if(c == 'A'){
                    map[i][j] = 1;
                    si = i;
                    sj = j;
                } 
                else if(c == 'B'){
                    map[i][j] = 1;
                    ei = i;
                    ej = j;
                } 
                else  if (c == '#')map[i][j] = 0;
            }
        }

        // for(int i=0; i<n; i++){
        //     for(int j=0; j<m; j++){
        //         System.out.print(map[i][j]);
        //     }
        //     System.out.println();
        // }

        //System.out.println();

        bfs(si, sj);


        //   for(int i=0; i<n; i++){
        //     for(int j=0; j<m; j++){
        //         System.out.print(vis[i][j] + " ");
        //     }
        //     System.out.println();
        // }

        if(vis[ei][ej] == true) System.out.println("YES");
        else System.out.println("NO");

        System.out.println(level[ei][ej]);

	}

    static void bfs(int row, int col){

        vis[row][col] = true;

        Queue <pair> q = new LinkedList<>();
        q.add(new pair(row, col));

        while(!q.isEmpty()){
            pair current = q.poll();
            int i = current.x;
            int j = current.y;
            //System.out.println(row + "," + col);

            if(vis[i-1][j]==false && map[i-1][j]==1){
                q.add(new pair(i-1, j));
                vis[i-1][j] = true;
                level[i-1][j] = level[i][j] + 1;
            }

            if(vis[i][j+1]==false && map[i][j+1]==1){
                q.add(new pair(i, j+1));
                vis[i][j+1] = true;
                level[i][j+1] = level[i][j] + 1;
            }

            if(vis[i][j-1]==false && map[i][j-1]==1){
                q.add(new pair(i, j-1));
                vis[i][j-1] = true;
                level[i][j-1] = level[i][j] + 1;
            }

            if(vis[i+1][j]==false && map[i+1][j]==1){
                q.add(new pair(i+1, j));
                vis[i+1][j] = true;
                level[i+1][j] = level[i][j] + 1;
            }
        }


    }
}

class pair{
    public int x,y;

    pair(int x, int y){
        this.x = x;
        this.y = y;
    }
}