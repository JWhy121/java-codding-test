package Codding.BOJ.silver;

import java.io.*;
import java.util.*;

public class _s2_11724_연결_요소의_개수 {

    private static ArrayList<ArrayList<Integer>> list;
    private static boolean[] visited;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        list = new ArrayList<>();

        for(int i = 0; i < N + 1; i++){
            list.add(new ArrayList<>());
        }
        visited = new boolean[N + 1];

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int key = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());
            list.get(key).add(value);
            list.get(value).add(key);
        }

        int count = 0;

        for(int i = 1; i <= N; i++){
            if(visited[i]) continue;
            dfs(i);
            count++;
        }

        bw.append(String.valueOf(count));

        bw.flush();
        bw.close();

    }

    private static void dfs(int n){
        //방문처리
        visited[n] = true;
        for(int s : list.get(n)){
            if(visited[s]) continue;
            dfs(s);
        }
    }
}
