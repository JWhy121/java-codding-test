package Codding.BOJ.gold;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.StringTokenizer;


/*
1이면 : 옆에 0이 있는지 체크하면서 0인 토마토 익히기
0이면 : 익을 수 있는 지만 확인(여기서 익을 수 없으면 바로 -1 출력하고 종료)
한 턴이 끝나면 일수++
종료조건
1. 전체토마토 개수가 다 익으면 종료
2. 토마토를 익힐 수 없으면 종료
 */
public class _g5_7576_토마토 {

    private static int T;
    private static int M;
    private static int N;
    private static StringTokenizer st;
    private static int[] dx = {1, -1, 0, 0};
    private static int[] dy = {0, 0, 1, -1};
    private static boolean[][] visited;
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        st = new StringTokenizer(br.readLine());

        //6
        N = Integer.parseInt(st.nextToken());

        //4
        M = Integer.parseInt(st.nextToken());

        int[][] arr = new int[M][N];
        visited = new boolean[M][N];
        ArrayDeque<int[]> queue = new ArrayDeque<>();



        int days = 0;

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++){
                int tmp = Integer.parseInt(st.nextToken());
                arr[i][j] = tmp;
                if(tmp == 1){
                    queue.add(new int[]{i, j});
                }
                if(arr[i][j] == -1)
                    visited[i][j] = true;
            }
        }

        while(true){

            while (!queue.isEmpty()){

                int[] now = queue.pollFirst();

                visited[now[0]][now[1]] = true;

                //4방향 돌면서 유효한 곳이고 0이면 1로 바꾸기
                for(int i = 0; i < 4; i++){
                    int nx = now[0] + dx[i];
                    int ny = now[1] + dy[i];
                    //유효한 부분이고
                    if(isValid(nx, ny)){
                        //0이라면 1로 바꾸고 tomato--
                        if(arr[nx][ny] == 0){
                            arr[nx][ny] = 1;
                        }
                    }
                }
            }

            days++;

            for(int i = 0; i < M; i++){
                for(int j = 0; j < N; j++){
                    if(arr[i][j] == 1 && !visited[i][j]){
                        queue.add(new int[]{i, j});
                    }
                }
            }

            if(queue.isEmpty())
                break;
        }

        for(int i = 0; i < M; i++){
            for(int j = 0; j < N; j++){
                if(arr[i][j] == 0){
                    days = 0;
                    break;
                }
            }
        }



        bw.write(String.valueOf(days - 1));
        bw.flush();
        bw.close();

    }

    private static boolean isValid(int nx, int ny){
        return nx >= 0 && nx < M && ny >= 0 && ny < N;
    }
}
