package Codding.BOJ.gold;

import java.io.*;
import java.util.*;

public class _g5_16928_뱀과_사다리_게임 {

    private static int M;
    private static int N;
    private static StringTokenizer st;
    private static int[] arr;
    private static boolean[] visited;
    private static Queue<Info> queue = new LinkedList<>();

    public static class Info {

        int count;
        int now;

        public Info(int count, int now){
            this.count = count;
            this.now = now;
        }

    }
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[101];
        visited = new boolean[107];

        for(int i = 1; i < arr.length; i++){
            arr[i] = i;
        }

        for(int i = 0; i < N + M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            arr[a] = b;
        }

        int result = bfs();

        bw.write(result + "");

        bw.flush();
        bw.close();

    }

    private static int bfs(){
        queue.offer(new Info(0, 1));
        visited[1] = true;

        while(!queue.isEmpty()){

            Info info = queue.poll();

            visited[info.now] = true;

            for(int i = 1; i <= 6; i++){

                int move = arr[info.now + i];

                if(move >= 100)
                    return info.count + 1;

                if(!visited[move]){
                    queue.add(new Info(info.count + 1, arr[move]));
                }
            }
        }

        return -1;
    }
}
