package Codding.BOJ.silver;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _s1_1931_회의실_배정 {

    private static int N;
    private static int[][] arr;
    private static StringTokenizer st;
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());

        arr = new int[N][2];

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            arr[i][0] = a;
            arr[i][1] = b;
        }

        //끝나는 시간 오름차순(끝나는 시간이 같은 경우 시작 시간이 작은 순서)
        Arrays.sort(arr, ((o1, o2) -> {
            return o1[1] == o2[1] ? o1[0] - o2[0] : o1[1] - o2[1];
        }));

        //끝나는 시간이 제일 빠른 경우 미리 세기(count 1)
        int count = 1;

        //arr[1] 부터 보겠다는 뜻(0행은 이미 추가했으므로)
        int start = 1;

        //처음 넣은 0행의 끝나는 시간 저장
        int end = arr[0][1];

        //for문을 타는 지 안 타는 지 결정(for문을 안타면 더이상 회의실 배정 불가능하므로 while문 종료)
        boolean flag = false;

        while (true){

            if(flag)
                break;

            flag = true;


            for(int i = start; i < N; i++){
                if(arr[i][0] >= end){
                    count++;
                    start = i + 1;
                    end = arr[i][1];
                    flag = false;
                    break;
                }
            }
        }
        bw.write(String.valueOf(count));
        bw.flush();
        bw.close();

    }
}
