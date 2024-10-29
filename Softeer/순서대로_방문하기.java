package Softeer;

import java.io.*;
import java.util.*;


//중간 지점에 도착하면 다음 depth로 넘어가기
//마지막 지점에 도착하면 count++
public class 순서대로_방문하기 {

    static class Node{
        int x, y;

        public Node(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    private static int[] dx= {0, 0, 1, -1};
    private static int[] dy= {1, -1, 0, 0};
    private static boolean[][] visited;
    private static Node[] spot;
    private static int[][] locations;
    private static int N;
    private static int M;
    private static int count;
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        //초기화
        visited = new boolean[N + 1][N + 1];
        spot = new Node[M];
        locations = new int[N + 1][N + 1];
        count = 0;

        //locations 설정(벽 만들기)
        for(int i = 1; i <= N; i++){
            st = new StringTokenizer(br.readLine());

            for(int j = 1; j <= N; j++){
                locations[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        //spot 설정
        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());

            spot[i] = new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        //첫 spot을 먼저 방문
        visited[spot[0].x][spot[0].y] = true;

        dfs(1, spot[0]);

        System.out.print(count);

    }

    private static boolean isValid(int nx, int ny){

        //갈 수 없는 곳이면 false
        if(nx < 1 || nx >= locations.length || ny < 1 || ny >= locations.length){
            return false;
        }

        //벽이면 false
        if(locations[nx][ny] == 1){
            return false;
        }

        //방문한 노드면 false
        if(visited[nx][ny]){
            return false;
        }

        return true;

    }

    private static void dfs(int depth, Node current){

        //마지막 도착지에 도착하면 빠져나오고 count++
        if(depth == spot.length - 1 && current.x == spot[depth].x && current.y == spot[depth].y){

            count++;

            return;
        }

        //중간 지점일 경우 다음 depth로 이동
        if(current.x == spot[depth].x && current.y == spot[depth].y){
            dfs(depth + 1, current);
        }

        //4방향으로 돌면서 모든 경로 탐색
        for(int i = 0; i < 4; i++){

            int nx = current.x + dx[i];
            int ny = current.y + dy[i];

            if(isValid(nx, ny)){
                visited[nx][ny] = true;

                dfs(depth, new Node(nx, ny));


                visited[nx][ny] = false;
            }


        }

    }
}
