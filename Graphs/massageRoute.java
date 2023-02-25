import java.io.*;
import java.util.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class massageRoute{

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
    static int N = 100005;
    static ArrayList<Integer> [] g = new ArrayList[N];
    static boolean [] vis = new boolean [N];
    static int [] level = new int [N];
    static int [] parent = new int [N];
    static ArrayList<Integer> path = new ArrayList<Integer>();

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
		
        n = sc.nextInt();
        m = sc.nextInt();

        for(int i=0; i<m; i++){
            int x = sc.nextInt();
            int y = sc.nextInt();

            g[x].add(y);
            g[y].add(x);
        }

        
        bfs(1);
        // for(int i=1; i<=n; i++){
        //     if(vis[i] != true){
        //         System.out.println("IMPOSSIBLE");
        //         break
        //     }
        // }
        if(vis[n] != true) System.out.println("IMPOSSIBLE");

        else{
            parent[1] = -1;

            path(n);
            System.out.println(path.size());
            for(int i=path.size()-1; i>=0; i--){
                System.out.print(path.get(i) + " ");
            }

        }


	}

    static void bfs(int index){

        vis[index] = true;

        Queue<Integer> q = new LinkedList<>();
        q.add(index);

        while(!q.isEmpty()){
            int current = q.poll();
            //System.out.println(current);
            for(int child: g[current]){
                if(vis[child] == true) continue;
                vis[child] = true;
                q.add(child);
                level[child] = level[current] + 1;
                parent[child] = current;
            }
        }
    }

    static void path (int index){

        while(index != -1){
            path.add(index);
            index = parent[index];
        }

    }
}