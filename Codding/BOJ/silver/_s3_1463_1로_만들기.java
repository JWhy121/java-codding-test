package Codding.BOJ.silver;

import java.io.*;

        /*
        1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18
        0 1 1 2 3 2 3 3 2 3  4  3  4  4  4  4  5  3
        12 > 6 > 2 > 1
        12 > 4 > 2 > 1
        13 > 12 >
        15 > 14 > 7 > 6 > 2 > 1
        15 > 5 > 4 > 2 > 1
        16 > 8 > 4 > 2 > 1
        16 > 15 > 5 > 4 > 2 > 1
        11 > 10 > 9 > 3 > 1
        10 > 5
        10 > 9 > 3 > 1
        7 > 6 > 2 > 1
        5 > 4 > 2 > 1
        6 > 2 > 1
        8 > 4 > 2 > 1
        8 > 7 > 6 > 2 > 1
        3 > 2 > 1
        3 > 1
         */

public class _s3_1463_1로_만들기 {

    private static int N;
    private static int[] arr;
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());

        arr = new int[N + 3];

        arr[1] = 0;
        arr[2] = arr[3] = 1;


        for(int i = 4; i <= N; i++){

            //3으로만 나누어떨어지는 경우
            if(i % 2 == 1 && i % 3 == 0){
                arr[i] = Math.min(arr[i / 3], arr[i-1]) + 1;
                continue;
            }

            //2로만 나누어떨어지는 경우
            if(i % 2 == 0 && i % 3 != 0){
                arr[i] = Math.min(arr[i / 2], arr[i-1]) + 1;
                continue;
            }

            //2,3 중에 아무것도 나뉘는 게 없는 경우
            if(i % 2 != 0 && i % 3 != 0){
                arr[i] = arr[i - 1] + 1;
                continue;
            }

            //2,3 둘 다 가능한 경우
            if(i % 2 == 0 && i % 3 == 0){
                arr[i] = Math.min(arr[i / 2], arr[i / 3]) + 1;
                continue;
            }

        }


        bw.write(arr[N] + "");


        bw.flush();
        bw.close();

    }
}
