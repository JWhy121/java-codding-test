package Softeer;

import java.io.*;
import java.util.*;

public class 성적_평균 {

    private static int N;
    private static int K;
    private static StringTokenizer st;

    public static void main(String[] args) throws IOException{


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        int[] scores = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        for(int i = 0; i < K; i++){
            double sum = 0.00;

            st = new StringTokenizer(br.readLine());

            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            for(int j = n; j <= k; j++){
                sum += scores[j - 1];
            }

            // double result = Math.round(sum / (k - n + 1) * 100.00) / 100.00;

            bw.write(String.format("%.2f\n", sum / (k - n + 1)));

            // bw.write(result + "\n");
        }

        bw.flush();
        bw.close();
    }
}
