package Codding.BOJ.silver;

import java.io.*;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class _s2_1012_유기농_배추 {

    private static int T;
    private static int M;
    private static int N;
    private static int K;
    private static int[][] arr;
    private static int count;
    private static int[] dx = {1, -1, 0, 0};
    private static int[] dy = {0, 0, 1, -1};
    private static StringTokenizer st;
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        T = Integer.parseInt(br.readLine());

        for(int t = 0; t < T; t++)
        {
            count = 0;
            st = new StringTokenizer(br.readLine());

            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            arr = new int[N][M];

            for (int i = 0; i < K; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                arr[b][a] = 1;
            }

            bfs(arr);

            bw.write(count + "\n");
        }

        bw.flush();
        bw.close();
    }

    private static boolean isValid(int nx, int ny){
        return nx >= 0 && nx < N && ny >= 0 && ny < M;
    }

    private static void bfs(int[][] arr){
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {

                ArrayDeque<int[]> queue = new ArrayDeque<>();

                if (arr[i][j] == 1) {
                    queue.add(new int[]{i, j});
                    arr[i][j] = 0;
                    while (!queue.isEmpty()) {
                        int[] tmp = queue.poll();

                        for (int k = 0; k < 4; k++) {
                            int nx = tmp[0] + dx[k];
                            int ny = tmp[1] + dy[k];
                            if (isValid(nx, ny)) {
                                if (arr[nx][ny] == 1) {
                                    arr[nx][ny] = 0;
                                    queue.add(new int[]{nx, ny});
                                }
                            }
                        }
                    }
                    count++;
                }
            }
        }
    }
}
