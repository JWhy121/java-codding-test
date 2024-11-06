package Softeer;

import java.io.*;
import java.util.*;


//다이나믹 프로그래밍, 이분탐색을 이용
//개념이 어렵지만 그래도 이해할 만은 하다
//LIS(최장 길이 수열)
public class 징검다리2 {
    private static int N;
    private static StringTokenizer st;

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());

        int[] adj = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int[] adjR = new int[N];

        for(int i = 0; i < N; i++){
            adjR[i] = adj[N - i - 1];
        }

        ArrayList<Integer> arr_l = new ArrayList<>();
        ArrayList<Integer> arr_r = new ArrayList<>();
        int[] lCnt = new int[N];
        int[] rCnt = new int[N];
        for(int i = 0; i < N; i++){

            if(arr_l.size() == 0 || arr_l.get(arr_l.size()-1) < adj[i]){

                arr_l.add(adj[i]);

            }else if(arr_l.get(arr_l.size() - 1) > adj[i]){

                int idx = Collections.binarySearch(arr_l, adj[i]);

                //인덱스가 음수라면
                if(idx < 0){
                    idx = idx*(-1)-1;
                }

                arr_l.set(idx, adj[i]);
            }

            lCnt[i] = arr_l.size();
        }

        for(int i = 0; i < N; i++){

            if(arr_r.size() == 0 || arr_r.get(arr_r.size()-1) < adjR[i]){
                arr_r.add(adjR[i]);
            }else if(arr_r.get(arr_r.size() - 1) > adjR[i]){
                int idx = Collections.binarySearch(arr_r, adjR[i]);

                //인덱스가 음수라면
                if(idx < 0){
                    idx = idx*(-1) - 1;
                    arr_r.set(idx, adjR[i]);
                }
            }

            rCnt[i] = arr_r.size();
        }

        int result = 0;
        for(int i = 1; i < N - 1; i++){

            int m = rCnt[i] + lCnt[N - i - 1];
            if(m > result){
                result = m;
            }
        }

        if(result == 0){
            bw.write(1 + "");
        }else{
            bw.write(result - 1 + "");
        }

        bw.flush();
        bw.close();

    }
}
