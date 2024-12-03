package Codding.BOJ.silver;

import java.io.*;
import java.util.Arrays;
import java.util.Iterator;
import java.util.StringTokenizer;

public class _s2_2805_나무_자르기 {

    private static int N;
    private static int M;
    private static StringTokenizer st;
    private static int[] trees;
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        trees = new int[N];
        int max = 0;
        int min = 0;
        int h = 0;

        for(int i = 0; i < N; i++){
            int tree = Integer.parseInt(st.nextToken());
            if(max < tree)
                max = tree;
            trees[i] = tree;
        }


        while(min <= max){

            if(min == max)
                break;

            long sum = 0;

            h = (max + min) / 2;

            for(int i = 0; i < N; i++){
                if(trees[i] <= h)
                    continue;
                sum += trees[i] - h;
            }

            if(sum == M)
                break;

            if(sum > M){
                if(min == h)
                    break;
                min = h;
            }

            if(sum < M){
                if(max == h)
                    break;
                max = h;
            }
        }


        bw.write(h + "");


        bw.flush();
        bw.close();

    }

}
