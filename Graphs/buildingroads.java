import java.io.*;
import java.util.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class buildingroads{

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

	static int N = 100005;
    static ArrayList<Integer> [] g = new ArrayList[N];
    static boolean [] vis = new boolean [N];

    public static void main(String[] args) {
		

		try {
			System.setIn(new FileInputStream("input.txt"));
			System.setOut(new PrintStream(new FileOutputStream("output.txt")));
		} catch (Exception e) {
			System.err.println("Error");
		}
		FastReader sc = new FastReader();

        for(int i=0; i<N; i++){
            g[i] = new ArrayList<Integer>();
        }
		
        int n = sc.nextInt();
        int m = sc.nextInt();

        for(int i=0; i<m; i++){
            int x = sc.nextInt();
            int y = sc.nextInt();

            g[x].add(y);
            g[y].add(x);

        }

        int cnt = 0;
        ArrayList<pair> ans = new ArrayList<pair>();
        int prev_vis = 0;

        for(int i=1; i<n; i++){
            if(vis[i] == true){
                prev_vis = i;
                continue;
            }
            ans.add(new pair(prev_vis, i));
            cnt++;
            dfs(i);
            prev_vis = i;

        }

        System.out.println(cnt-1);
        for(int i=1; i<ans.size(); i++){
            System.out.println(ans.get(i).x + " " + ans.get(i).y);
        }


	}

    static void dfs(int index){
        vis[index] = true;

        for(int child: g[index]){
            if(vis[child] == true) continue;
            dfs(child);
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