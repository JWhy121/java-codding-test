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

public class _s3_9095_123_더하기_완전탐색 {

    private static int T;
    private static int N;
    private static int M;
    private static StringTokenizer st;
    private static int count = 0;
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());

        for(int i = 0; i < N; i++){
            count = 0;
            int n = Integer.parseInt(br.readLine());
            dfs(n, 0);
            sb.append(count + "\n");
        }

        bw.write(sb.toString());

        bw.flush();
        bw.close();

    }

    private static void dfs(int n, int sum){

        //sum이 n보다 크면 return
        if(sum > n)
            return;

        //sum이 n과 같아지면 count++ 하고 return
        if(sum == n){
            count++;
            return;
        }

        for(int i = 1; i <= 3; i++){
            dfs(n, sum + i);
        }

    }
}
