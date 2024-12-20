package Codding.BOJ.silver;

import java.io.*;
import java.util.StringTokenizer;

public class _s3_1929_소수_구하기 {

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

        //5 ~ 16
        for(int i = M; i <= N; i++){

            if(i == 2){
                sb.append(i + "\n");
                continue;
            }

            if(i == 1){
                continue;
            }
            //짝수이면 바로 컷
            if(i % 2 == 0)
                continue;

            boolean flag = true;

            for(int j = 2; j <= Math.sqrt(i); j++){

                if(i % j == 0){
                    flag = false;
                    break;
                }
            }
            if(flag){
                sb.append(i + "\n");
            }

        }
        bw.write(sb.toString());


        bw.flush();
        bw.close();

    }
}
