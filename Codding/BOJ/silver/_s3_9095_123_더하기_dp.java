package Codding.BOJ.silver;

import java.io.*;
import java.util.StringTokenizer;

/*
4를 1,2,3의 합
1 1 1 1
1 1 2
1 2 1
2 1 1
2 2
3 1
1 3
 */
/*
5를 1,2,3의 합
1 1 1 1 1
1 1 1 2
1 1 2 1
1 2 1 1
2 1 1 1
1 2 2
2 1 2
2 2 1
2 3
3 2
 */
/*
6을 1,2,3의 합
1 1 1 1 1 1
1 1 1 1 2
1 1 1 2 1
1 1 2 1 1
1 2 1 1 1
2 1 1 1 1
1 1 1 3
1 1 3 1
1 3 1 1
3 1 1 1
 */
/*
dp로 풀기(Memoization)
1을 만드는 경우 : 1 의 1개
2를 만드는 경우 : 1+1, 2 의 2개
3을 만드는 경우 : 1+1+1, 1+2, 2+1, 3 의 4개

4를 만드는 경우부터는 앞의 경우를 이용해서 풀기
3 + 1 --> 3을 만드는 경우 => 4개
2 + 2 --> 2를 만드는 경우 => 2개
1 + 3 --> 1을 만드는 경우 => 1개

==> 7개

5를 만드는 경우부터는 앞의 경우를 이용해서 풀기
4 + 1 --> 4를 만드는 경우 => 7개
3 + 2 --> 3을 만드는 경우 => 4개
2 + 3 --> 2를 만드는 경우 => 2개

==> 13개
점화식
dp[n] = dp[n-1] + dp[n-2] + dp[n-3]
 */

public class _s3_9095_123_더하기_dp {

    private static int N;
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());

        int[] memoization = new int[11];

        memoization[1] = 1;
        memoization[2] = 2;
        memoization[3] = 4;

        for(int i = 4; i < 11; i++){
            memoization[i] = memoization[i - 1] + memoization[i - 2] + memoization[i - 3];
        }

        for(int i = 0; i < N; i++){
            int n = Integer.parseInt(br.readLine());
            sb.append(memoization[n] + "\n");
        }

        bw.write(sb.toString());

        bw.flush();
        bw.close();

    }
}