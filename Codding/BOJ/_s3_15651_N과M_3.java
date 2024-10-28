package Codding.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class _s3_15651_N과M_3 {

    private static int[] arr;
    private static int N;
    private static int M;
    private static StringBuilder sb;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        sb = new StringBuilder();

        //N,M에 입력받은 숫자 저장
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[M];

        backtracking(1, 0);

        System.out.println(sb);

    }

    private static void backtracking(int cur, int depth){

        if(depth == M){

            for(int val : arr){
                sb.append(val + " ");
            }

            sb.append("\n");

            return;
        }

        for(int i = 1; i < N + 1; i++){

            arr[depth] = i;
            backtracking(i + 1, depth + 1);
        }

    }

}
