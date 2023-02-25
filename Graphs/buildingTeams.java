import java.io.*;
import java.util.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class buildingTeams{

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
    static boolean ispossible;
    static int N = 100005;
    static ArrayList<Integer> [] g = new ArrayList[N];
    static boolean [] vis = new boolean [N];
    static int [] team = new int [N];

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

        //System.out.println(loopexists(1,0));
        //boolean ans = false;
        // for(int i=1; i<=n; i++){
        //     if(vis[i] == true) continue;
        //     if(loopexists(i, 0) == true){
        //         ans = true;
        //         break;
        //     }
        // }
        //if(ans == true) System.out.println("IMPOSSIBLE");
        for(int i=1; i<=n; i++){
            if(vis[i] == true) continue;
            bfs(i);
        }
        if(ispossible == false) System.out.println("IMPOSSIBLE");
        
        else{
            Arrays.fill(vis, false);
            for(int i=1; i<=n; i++){
                if(vis[i] == true) continue;
                bfs(i);
            }

            for(int i=1; i<=n; i++){
                System.out.print(team[i] + " ");
            }
        }


	}

    static void bfs(int index){
        vis[index] = true;
        Queue<Integer> q = new LinkedList<>();
        q.add(index);
        team[index] = 1;

        while(!q.isEmpty()){
            int curr = q.poll();
            for(int child: g[curr]){
                if(vis[child] == true) continue;
                vis[child] = true;
                q.add(child);
                if(team[child] != 0){
                    ispossible = false;
                }
                else{
                    ispossible = true;
                    if(team[curr] == 1) team[child] = 2;
                    else team[child] = 1;
                }
                

            }
        }
    }

    // static boolean loopexists(int index, int par){
    //     boolean loop = false;
    //     vis[index] = true;

    //     for(int child: g[index]){
    //         if(vis[child] == true && child == par) continue;
    //         if(vis[child] == true) return true;

    //         loop |= loopexists(child, index);
    //     }

    //     return loop;
    // }
}