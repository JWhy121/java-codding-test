package Codding.BOJ.silver;

import java.io.*;

public class _s3_11726_2xn_타일링 {

    private static int N;
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] arr = new int[1001];

        arr[1] = 1;
        arr[2] = 2;

        N = Integer.parseInt(br.readLine());

        for(int i = 3; i <= N; i++){
            arr[i] = (arr[i - 1] + arr[i - 2]) % 10007;
        }

        bw.write(arr[N] + "");

        bw.flush();
        bw.close();

    }

}
