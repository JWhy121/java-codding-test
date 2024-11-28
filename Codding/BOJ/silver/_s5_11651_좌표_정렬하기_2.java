package Codding.BOJ.silver;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _s5_11651_좌표_정렬하기_2 {

    private static int N;
    private static StringTokenizer st;
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());

        int[][] arr = new int[N][2];

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        /*
        람다식을 통한 정렬 : 첫번째 요소 오름차순 -> 첫번째 요소 같은 경우 두번째 요소 오름차순
         */
        Arrays.sort(arr, (o1, o2) -> {
            return o1[1] != o2[1] ? o1[1] - o2[1] : o1[0] - o2[0];
        });

        for(int i = 0; i < N; i++){
            sb.append(arr[i][0] + " ");
            sb.append(arr[i][1] + "\n");
        }

        bw.write(sb.toString());

        bw.flush();
        bw.close();

    }
}
