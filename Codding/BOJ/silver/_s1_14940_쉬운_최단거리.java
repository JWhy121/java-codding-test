package Codding.BOJ.silver;

import java.beans.PropertyEditorSupport;
import java.io.*;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class _s1_14940_쉬운_최단거리 {

    private static int N;
    private static int M;
    private static int x;
    private static int y;
    private static final int[] dx = {1, -1, 0, 0};
    private static final int[] dy = {0, 0, -1, 1};
    private static boolean[][] visited;
    private static int[][] map;
    private static int[][] answer;
    private static StringTokenizer st;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        st = new StringTokenizer(br.readLine());

        //세로, 가로 크기 저장
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        visited = new boolean[N][M];
        answer = new int[N][M];

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++){
                int tmp = Integer.parseInt(st.nextToken());
                if(tmp == 2){
                    x = i;
                    y = j;
                }else if(tmp == 0){
                    visited[i][j] = true;
                }
                map[i][j] = tmp;
            }
        }

        bfs(x, y);

        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                // 가지 못한 부분은 -1로 출력
                if(!visited[i][j]){
                    answer[i][j] = -1;
                }
                sb.append(answer[i][j] + " ");
            }
            sb.append("\n");
        }

        bw.write(sb + "");

        bw.flush();
        bw.close();

    }

    private static void bfs(int x, int y){
        //queue 생성
        ArrayDeque<int[]> queue = new ArrayDeque<>();
        //현재위치 넣기
        queue.add(new int[]{x, y});

        //방문처리
        visited[x][y] = true;

        while(!queue.isEmpty()){
            int poll[] = queue.poll();
            for(int i = 0; i < 4; i++){
                int nx = poll[0] + dx[i];
                int ny = poll[1] + dy[i];


                //유효하다면
                if(nx >= 0 && nx < N && ny >= 0 && ny < M){

                    //방문한 적 없고, 갈 수 있는 곳이면 큐에 추가
                    if(!visited[nx][ny] && map[nx][ny] == 1){
                        visited[nx][ny] = true;
                        //방금 poll한 결과값에서 한 칸 더 갔으니까 그 값에서 1 더한 값을 현재 값에 넣기
                        answer[nx][ny] = answer[poll[0]][poll[1]] + 1;
                        queue.add(new int[]{nx, ny});
                    }
                }


            }
        }

    }

}
