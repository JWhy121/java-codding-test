package Codding.BOJ;

import java.io.*;
import java.util.StringTokenizer;

public class _s3_11659_구간_합_구하기_4 {

    private static int M;
    private static int N;
    private static StringTokenizer st;
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        int[] arr = new int[N + 1];

        st = new StringTokenizer(br.readLine());

        for(int i = 1; i <= N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] sum_arr = new int[N + 1];

        sum_arr[1] = arr[1];

        for(int i = 2; i <= N; i++){
            sum_arr[i] = sum_arr[i - 1] + arr[i];
        }

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            sb.append(String.valueOf(sum_arr[b] - sum_arr[a - 1])).append("\n");
        }

        bw.write(sb.toString());


        bw.flush();
        bw.close();

    }
}
