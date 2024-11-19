package Codding.BOJ.silver;

import java.io.*;
import java.util.*;

public class _s3_2606_바이러스 {

    private static int T;
    private static int N;
    private static StringTokenizer st;
    private static List[] arr;
    private static boolean[] visited;
    private static int count;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //컴퓨터의 수
        T = Integer.parseInt(br.readLine());

        //컴퓨터 쌍의 수
        N = Integer.parseInt(br.readLine());

        visited = new boolean[T + 1];

        arr = new List[T + 1];

        for(int i = 0; i <= T; i++){
            arr[i] = new ArrayList<Integer>();
        }

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            arr[a].add(b);
            arr[b].add(a);
        }

        count = 0;

        dfs(1);

        System.out.println(count - 1);



    }

    private static void dfs(int now){

        if(!visited[now]){
            visited[now] = true;
            count++;
            for(int i = 0; i < arr[now].size(); i++){
                dfs((Integer)arr[now].get(i));
            }
        }

    }
}
