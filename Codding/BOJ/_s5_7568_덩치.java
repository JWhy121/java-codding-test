package Codding.BOJ;

import java.io.*;

public class _s5_7568_덩치 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        //키, 몸무게를 담을 2차원 배열 생성
        int[][] arr = new int[n][2];

        String[] str;


        //키, 몸무게 입력받아서 담기
        for(int i = 0; i < n; i++){
            str = br.readLine().split(" ");
            arr[i][0] = Integer.parseInt(str[0]);
            arr[i][1] = Integer.parseInt(str[1]);
        }

        StringBuilder sb = new StringBuilder();

        //모든 덩치들과 비교해서 등수 매김
        for(int i = 0; i < n; i++){
            int rank = 1;

            for(int j = 0; j < n; j++){
                if(i == j)
                    continue;
                //키, 몸무게 모두 크면 rank++
                if(arr[i][0] < arr[j][0] && arr[i][1] < arr[j][1]){
                    rank++;
                }
            }

            sb.append(rank).append(' ');
        }

        System.out.println(sb);


    }
}
