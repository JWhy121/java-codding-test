package Softeer;

import java.io.*;
import java.util.*;

//내가 누구와 친구인지를 연결하고 이후에 이중 for문 돌면서 확인하기
public class 우물_안_개구리 {

    private static int N;
    private static int M;
    private static StringTokenizer st;
    private static ArrayList<ArrayList<Integer>> friend = new ArrayList<>();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        int[] weight = new int[N + 1];

        //무게 저장
        for(int i = 1; i <= N; i++){
            weight[i] = Integer.parseInt(st.nextToken());
        }

        //N+1 크기의 ArrayList 초기화
        for(int i = 0; i <= N; i++){
            friend.add(new ArrayList<>());
        }


        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            friend.get(n).add(m);
            friend.get(m).add(n);
        }

        int count = 0;

        for(int i = 1; i <= N; i++){
            //초기에 자기 자신의 무게 넣기
            boolean max = true;

            if(friend.get(i).size() == 0){
                count++;
                continue;
            }


            for(int j = 0; j < friend.get(i).size(); j++){

                if(weight[friend.get(i).get(j)] >= weight[i]){
                    max = false;
                }
            }

            if(max)
                count++;


        }

        bw.write(count + "");

        bw.flush();
        bw.close();



    }
}
