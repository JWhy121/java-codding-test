package Softeer;

import java.io.*;
import java.util.*;

public class GPT식_숫자_비교 {

    private static int N;
    private static List<String> arr;

    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());

        arr = new ArrayList<>();

        for(int i = 0; i < N; i++){
            arr.add(br.readLine());
        }

        arr.sort((a, b) -> {

            String[] numA = a.split("\\.");
            String[] numB = b.split("\\.");

            int cpr = Integer.compare(Integer.parseInt(numA[0]), Integer.parseInt(numB[0]));
            if(cpr != 0){
                return cpr;
            }

            int cprA = numA.length > 1 ? Integer.parseInt(numA[1]) : -1;
            int cprB = numB.length > 1 ? Integer.parseInt(numB[1]) : -1;

            return Integer.compare(cprA, cprB);
        });

        for(String s: arr){
            bw.append(s).append("\n");
        };

        bw.flush();
        bw.close();

    }


}
