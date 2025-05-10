package Codding.BOJ.silver;

import java.io.*;
import java.util.StringTokenizer;

public class _s2_2630_색종이_자르기 {

    private static int[][] paper;
    private static int white;
    private static int blue;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        paper = new int[n][n];
        white = 0;
        blue = 0;

        for(int i = 0; i < n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++){
                paper[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        partition(0, 0, n);

        bw.append(String.valueOf(white)).append("\n");
        bw.append(String.valueOf(blue)).append("\n");

        bw.flush();
        bw.close();
    }

    private static void partition(int row, int col, int size){

        if(checkColor(row, col, size)){
            if(paper[row][col] == 0){
                white++;
            }else{
                blue++;
            }
            return;
        }

        int reSize = size / 2;

        partition(row + reSize, col, reSize); //1사분면
        partition(row, col, reSize); //2사분면
        partition(row, col + reSize, reSize); //3사분면
        partition(row + reSize, col + reSize, reSize); //4사분면

    }


    private static boolean checkColor(int row, int col, int size){
        //종이의 첫번째 색깔을 기준으로 바뀌면 바로 false return
        int firstColor = paper[row][col];

        for(int i = row; i < row + size; i++){
            for(int j = col; j < col + size; j++){
                if (paper[i][j] != firstColor){
                    return false;
                }
            }
        }

        return true;
    }
}
