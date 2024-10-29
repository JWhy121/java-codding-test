package Softeer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 함께하는_효도 {

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
    private static Node[] friends;
    private static int[][] trees;
    private static int N;
    private static int M;
    private static int max_num;
    private static int idx;
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        //초기화
        visited = new boolean[N + 1][N + 1];
        friends = new Node[M];
        trees = new int[N + 1][N + 1];
        max_num = 0;

        //수확물 판 만들기
        for(int i = 1; i <= N; i++){
            st = new StringTokenizer(br.readLine());

            for(int j = 1; j <= N; j++){
                trees[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        //friends 설정
        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());

            friends[i] = new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        //idx, 현재 친구의 위치, 3초인지 아닌지
        dfs(0, friends[0], 0, max_num);

        System.out.println(max_num);

    }

    private static boolean isValid(int nx, int ny){

        //갈 수 없는 곳이면 false
        if(nx < 1 || nx >= trees.length || ny < 1 || ny >= trees.length){
            return false;
        }

        //수확한 노드면 false
        if(visited[nx][ny]){
            return false;
        }

        return true;

    }

    private static void dfs(int idx, Node current, int time, int max){

        visited[current.x][current.y] = true;
        max += trees[current.x][current.y];

        //3초 수확한 경우 모두 수집
        if(time == 3){

            //마지막 친구이면
            if(idx == friends.length - 1){

                if(max >= max_num){
                    max_num = max;
                }

            }else{

                dfs(idx + 1, friends[idx + 1], 0, max);
            }

            visited[current.x][current.y] = false;

            return;

        }

        //4방향으로 돌면서 모든 경로 탐색
        for(int i = 0; i < 4; i++){

            int nx = current.x + dx[i];
            int ny = current.y + dy[i];

            if(isValid(nx, ny)){
                visited[nx][ny] = true;

                dfs(idx, new Node(nx, ny), time + 1, max);
            }
        }
        visited[current.x][current.y] = false;
    }
}
