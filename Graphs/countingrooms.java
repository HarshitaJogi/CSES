import java.io.*;
import java.util.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class countingrooms{

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

        for(int i=0; i<n; i++){
            String s = sc.nextLine();
            for(int j=0; j<m; j++){
                char c = s.charAt(j);
                if(c == '.') map[i][j] = 1;
                else map[i][j] = 0;
            }
        }

        // for(int i=0; i<n; i++){
        //     for(int j=0; j<m; j++){
        //         System.out.print(map[i][j]);
        //     }
        //     System.out.println();
        // }

        int cnt = 0;
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(vis[i][j] == true) continue;
                if(map[i][j] == 0) continue;
                dfs(i, j);
                cnt++;
            }
        }

        System.out.println(cnt);


	}

    static void dfs(int i, int j){
        vis[i][j] = true;

        
        if(i-1>=0 && vis[i-1][j]==false && map[i-1][j]==1){
            dfs(i-1, j);
        }

        if(j+1<m && vis[i][j+1]==false && map[i][j+1]==1){
            dfs(i, j+1);
        }

        if(j-1>=0 && vis[i][j-1]==false && map[i][j-1]==1){
            dfs(i, j-1);
        }

        if(i+1<n && vis[i+1][j]==false && map[i+1][j]==1){
            dfs(i+1, j);
        }
    }
}
