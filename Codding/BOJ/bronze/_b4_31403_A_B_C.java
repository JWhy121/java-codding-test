package Codding.BOJ.bronze;

import java.io.*;

public class _b4_31403_A_B_C {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] arr = new int[3];

        for(int i = 0; i < 3; i++){

            arr[i] = Integer.parseInt(br.readLine());
        }

        bw.write(String.valueOf(arr[0] + arr[1] - arr[2]) + "\n");
        bw.write(Integer.parseInt(String.valueOf(arr[0]) + String.valueOf(arr[1])) - arr[2] + "\n");

        bw.flush();
        bw.close();
    }
}
