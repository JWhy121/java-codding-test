package Codding.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.StringTokenizer;

public class _s3_15649_N과M {

    private static boolean[] visited;
    private static int[] arr;
    private static StringBuilder sb;
    private static int N;
    private static int M;

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        sb = new StringBuilder();

        //N,M에 입력받은 숫자 저장
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        //방문한 곳 저장
        visited = new boolean[N];

        arr = new int[M];

        backtracking(0);


        System.out.println(sb);

    }

    private static void backtracking(int depth){

        if(depth == M){

            for(int val : arr){
                sb.append(val + " ");
            }

            sb.append("\n");
            return;

        }

        for(int i = 0; i < N; i++){

            //방문한 적이 없다면 방문처리하고 다음 값으로 넘어가기
            if(!visited[i]){
                visited[i] = true;
                arr[depth] = i + 1;
                backtracking(depth + 1);

                visited[i] = false;
            }
        }


    }


}
