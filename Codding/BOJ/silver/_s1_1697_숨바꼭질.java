package Codding.BOJ.silver;

import java.io.*;
import java.util.ArrayDeque;
import java.util.StringTokenizer;


/*
1. 수빈이가 동생보다 앞에 있으면 간격이 답
2.
5 ~ 17
5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17
5에서 갈 수 있는 경우의 수 4, 6, 10
break 조건
0 미만 100000 초과
도착했으면 원래 가지고 있는 최댓값보다 작은 지 확인해서 넣고 return
8 12 라면 4 이상 16 이하

5 17 이라면 0부터 17 + 12 = 29까지
5와 17 사이 간격 12
8 12
간격 4
7 > 6 > 12 3초
9 > 10 > 11 > 12 4초
언제까지 뒤로 갈 수 있어? -> 4까지 갈 수 있음. 왜? 거기까지 갔다는 건 이미 간격보다 많이 간 거라 어차피 안돼

5 17

 */
/*
윗부분은 나의 돌아돌아 여정을 나타낸.. ㅠㅠ
 */
public class _s1_1697_숨바꼭질 {

    private static int N;
    private static int K;
    private static int gap;
    private static int[] seconds;
    private static int[] move = {-1, 1, 2};
    private static StringTokenizer st;
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        seconds = new int[100001];

        //둘 사이의 간격 저장
        gap = Math.abs(N - K);

        if(N >= K || gap == 1){
            bw.write(String.valueOf(Math.abs(N - K)));
            bw.flush();
            bw.close();
            return;
        }

        ArrayDeque<Integer> queue = new ArrayDeque<>();

        queue.add(N);

        while(!queue.isEmpty()){

            if(seconds[K] != 0)
                break;

            int now = queue.poll();

            for(int i = 0; i < 3; i++){
                int num;

                if(i == 2){
                    num = now * move[2];
                }else{
                    num = now + move[i];
                }

                //num이 유효범위 안에 있고 seconds 배열의 길이보다 짧고 아직 0으로 시간이 없으면 방문한 적 없는거니까
                if(num >=0 && num < seconds.length && num <= 100000 && seconds[num] == 0){
                    queue.add(num);
                    seconds[num] = seconds[now] + 1;
                }
            }
        }

        bw.write(String.valueOf(seconds[K]));

        bw.flush();
        bw.close();

    }
}
