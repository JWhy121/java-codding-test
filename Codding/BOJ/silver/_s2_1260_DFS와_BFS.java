package Codding.BOJ.silver;

import java.io.*;
import java.util.*;

public class _s2_1260_DFS와_BFS {

    private static int V;
    private static int M;
    private static int N;
    private static ArrayList<ArrayList<Integer>> arr;
    private static boolean[] visited;
    private static StringTokenizer st;
    private static StringBuilder sb;
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        st = new StringTokenizer(br.readLine());
        sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());

        arr = new ArrayList<>();
        visited = new boolean[N + 1];

        for(int i = 0; i <= N; i++){
            arr.add(new ArrayList<>());
        }

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            arr.get(a).add(b);
            arr.get(b).add(a);

        }

        for(int i = 1; i <= N; i++){
            Collections.sort(arr.get(i));
        }

        visited[V] = true;
        sb.append(String.valueOf(V) + " ");
        dfs(V);

        bw.write(sb.toString() + "\n");

        visited = new boolean[N + 1];
        visited[V] = true;
        sb.setLength(0);
        sb.append(String.valueOf(V) + " ");

        bfs(V);

        bw.write(sb.toString());


        bw.flush();
        bw.close();

    }

    private static void dfs(int v){

        for(int i = 0; i < arr.get(v).size(); i++){
            if(!visited[arr.get(v).get(i)]){
                visited[arr.get(v).get(i)] = true;
                sb.append(String.valueOf(arr.get(v).get(i))).append(" ");
                dfs(arr.get(v).get(i));
            }
        }
    }

    private static void bfs(int v){
        ArrayDeque<ArrayList<Integer>> queue = new ArrayDeque<>();

        queue.add(arr.get(v));

        while(!queue.isEmpty()){
            ArrayList<Integer> tmp = queue.poll();

            for(int i = 0; i < tmp.size(); i++){
                if(!visited[tmp.get(i)]){
                    visited[tmp.get(i)] = true;
                    sb.append(String.valueOf(tmp.get(i))).append(" ");
                    queue.add(arr.get(tmp.get(i)));
                }
            }

        }
    }
}
