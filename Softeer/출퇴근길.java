package Softeer;

import java.io.*;
import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 출퇴근길 {

    private static int N;
    private static int M;
    private static ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
    private static ArrayList<ArrayList<Integer>> adjR = new ArrayList<>();
    private static int count;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        //리스트 초기화
        for(int i = 0; i < N + 1; i++){
            adj.add(new ArrayList<>());
            adjR.add(new ArrayList<>());
        }

        //정방향, 역방향 그래프 그리기
        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            adj.get(n).add(m);
            adjR.get(m).add(n);
        }

        //4개의 boolen배열 만들기
        //집, 회사는 미리 1로 설정
        st = new StringTokenizer(br.readLine());
        int S = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());

        boolean[] fromS = new boolean[N + 1];
        fromS[T] = true;
        boolean[] fromT = new boolean[N + 1];
        fromT[S] = true;
        boolean[] toS = new boolean[N + 1];
        boolean[] toT = new boolean[N + 1];

        dfs(fromS, adj, S);
        dfs(fromT, adj, T);
        dfs(toS, adjR, T);
        dfs(toT, adjR, S);

        for(int i = 1; i < N + 1; i++){
            if(fromT[i] && fromS[i] && toS[i] && toT[i]){
                count++;
            }
        }

        System.out.println(count - 2);

    }

    private static void dfs(boolean[] visited, ArrayList<ArrayList<Integer>> adj, int now){
        if(visited[now])
            return;

        visited[now] = true;

        for(int i : adj.get(now)){
            dfs(visited, adj, i);
        }

    }
}
