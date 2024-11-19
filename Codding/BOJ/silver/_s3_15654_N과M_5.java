package Codding.BOJ.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _s3_15654_N과M_5 {
    private static int[] arr;
    private static int[] answer;
    private static int N;
    private static int M;
    private static boolean[] visited;
    private static StringBuilder sb;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st1 = new StringTokenizer(br.readLine());
        sb = new StringBuilder();

        //N,M에 입력받은 숫자 저장
        N = Integer.parseInt(st1.nextToken());
        M = Integer.parseInt(st1.nextToken());

        arr = new int[N];
        answer = new int[M];
        visited  = new boolean[N];

        StringTokenizer st2 = new StringTokenizer(br.readLine());

        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st2.nextToken());
        }

        Arrays.sort(arr);

        backtracking(0, 0);

        System.out.println(sb);

    }

    private static void backtracking(int cur, int depth){

        if(depth == M){

            for(int val : answer){
                sb.append(val + " ");
            }

            sb.append("\n");

            return;
        }

        for(int i = 0; i < N; i++){

            if(!visited[i]){
                visited[i] = true;
                answer[depth] = arr[i];
                backtracking(i + 1, depth + 1);
                visited[i] = false;
            }

        }

    }
}
