import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
    }

    private static ArrayList<ArrayList<Integer>> result;
    private static int n;
    private static void backtrack(int sum, ArrayList<Integer> selectedNums, int start){

        if(sum == 10){
            result.add(selectedNums);
            return;
        }

        for(int i = start; i <= n; i++){
            if(sum + i <= 10){
                ArrayList<Integer> list = new ArrayList<>(selectedNums);
                list.add(i);

                backtrack(sum + i, list, i + 1);
            }
        }

    }


    // 이 부분을 변경해서 실행해보세요.
    private static ArrayList<ArrayList<Integer>> solution(int N) {
        result = new ArrayList<>();

        n = N;

        backtrack(0, new ArrayList<>(), 1);

        return result;
    }



}