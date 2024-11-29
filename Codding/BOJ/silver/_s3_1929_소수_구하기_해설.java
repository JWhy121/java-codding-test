package Codding.BOJ.silver;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _s3_1929_소수_구하기_해설 {

    private static int M;
    private static int N;
    private static StringTokenizer st;
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        boolean[] answer = new boolean[N + 1];

        Arrays.fill(answer, true);

        answer[1] = false;

        for(int i = 2; i <= Math.sqrt(N); i++){
            if(answer[i]){
                for(int j = i * i; j <= N; j = j + i){
                    answer[j] = false;
                }
            }

        }

        for(int i = N; i < answer.length; i++){
            if(answer[i]){
                sb.append(i + "\n");
            }
        }

        bw.write(sb.toString());

        bw.flush();
        bw.close();

    }
}
