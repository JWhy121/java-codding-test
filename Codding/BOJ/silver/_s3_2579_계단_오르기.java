package Codding.BOJ.silver;

import java.io.*;


/**
 * DP
 * stair의 각 칸마다 최댓값 저장하기
 *
 * 10 20 15 40 1 20 50
 * 10,30,35,
 * **/
public class _s3_2579_계단_오르기 {

    private static int N;
    private static int[] stair;
    private static int[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        stair =  new int[N];
        dp = new int[N];
        for(int i = 0; i < N; i++){
            stair[i] = Integer.parseInt(br.readLine());
        }
        if(stair.length == 1){
            bw.append(String.valueOf(stair[0]));
            bw.flush();
            bw.close();
            return;
        }else if(stair.length == 2){
            bw.append(String.valueOf(stair[0] + stair[1]));
            bw.flush();
            bw.close();
            return;
        }else if(stair.length == 3){
            bw.append(String.valueOf(Math.max(stair[0] + stair[2], stair[1] + stair[2])));
            bw.flush();
            bw.close();
            return;
        }else {
            dp[0] = stair[0];
            dp[1] = stair[0] + stair[1];
            dp[2] = Math.max(stair[0] + stair[2], stair[1] + stair[2]);
        }

        for(int i = 3; i < N; i++){
            dp[i] = Math.max(dp[i - 2] + stair[i], dp[i - 3] + stair[i - 1] + stair[i]);
        }

        bw.append(String.valueOf(dp[N - 1]));
        bw.flush();
        bw.close();
    }
}
