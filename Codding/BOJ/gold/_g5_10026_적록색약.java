package Codding.BOJ.gold;

import java.io.*;
import java.util.ArrayDeque;

public class _g5_10026_적록색약 {

    private static int N;
    private static int[][] arr;
    private static int[][] s_arr;
    private static boolean[][] visited;
    private static int[] dx = {1, -1, 0, 0};
    private static int[] dy = {0, 0, 1, -1};
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());

        arr = new int[N][N];
        s_arr = new int[N][N];

        for(int i = 0; i < N; i++){
            String s = br.readLine();
            for(int j = 0; j < N; j++){

                if(s.charAt(j) == 'R'){
                    arr[i][j] = 1;
                    s_arr[i][j] = 1;
                }


                if(s.charAt(j) == 'G'){
                    arr[i][j] = 2;
                    s_arr[i][j] = 1;
                }


                if(s.charAt(j) == 'B'){
                    arr[i][j] = 3;
                    s_arr[i][j] = 2;
                }


            }
        }

        int count = bfs(arr);
        int s_count = bfs(s_arr);

        bw.write(count + " " + s_count);

        bw.flush();
        bw.close();

    }

    private static boolean isValid(int nx, int ny){
        return nx >=0 && nx < N && ny >= 0 && ny < N;
    }

    private static int bfs(int[][] arr){

        int count = 0;

        visited = new boolean[N][N];

        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){

                ArrayDeque<int[]> queue = new ArrayDeque<>();

                if(!visited[i][j])
                    queue.add(new int[]{i, j});
                else
                    continue;

                while(!queue.isEmpty()){

                    int[] now = queue.poll();

                    for(int k = 0; k < 4; k++){
                        int nx = now[0] + dx[k];
                        int ny = now[1] + dy[k];

                        if(isValid(nx, ny) && !visited[nx][ny]){
                            //두개가 서로 같으면
                            if(arr[now[0]][now[1]] == arr[nx][ny]){
                                visited[nx][ny] = true;
                                queue.add(new int[]{nx, ny});
                            }
                        }
                    }
                }

                count++;
            }
        }

        return count;
    }
}
