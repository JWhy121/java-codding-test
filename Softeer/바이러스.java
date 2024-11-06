package Softeer;

import java.io.*;
import java.util.*;


//모듈러 연산 참고
//중간 중간 값을 나누어 주어야 한다!@_@
public class 바이러스 {

    private static int K;
    private static int P;
    private static int N;
    private static long result;
    private static StringTokenizer st;


    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        st = new StringTokenizer(br.readLine());

        K = Integer.parseInt(st.nextToken());
        P = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        result = K;

        for(int i = 0; i < N; i++){
            result = (result * P) % 1000000007;
        }

        bw.write(result + "");

        bw.flush();
        bw.close();
    }
}
