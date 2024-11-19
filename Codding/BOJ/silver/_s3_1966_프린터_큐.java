package Codding.BOJ.silver;

import java.io.*;
import java.util.*;

//중요도 순으로 있는 큐 한개
//실제 있는 큐 한개
//실제 큐에서 peek 한 거랑 중요도 순으로 있는 큐랑 숫자가 같으면 pull 아니면 맨 뒤로 보내기
public class _s3_1966_프린터_큐 {

    private static int T;
    private static int N;
    private static int M;
    private static StringTokenizer st;
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        //테스트케이스의 수
        T = Integer.parseInt(br.readLine());

        for(int i = 0; i < T; i++){
            ArrayDeque<int[]> print_queue = new ArrayDeque<>();
            ArrayList<Integer> arr = new ArrayList<>();
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++){
                int num = Integer.parseInt(st.nextToken());
                print_queue.add(new int[]{j, num});
                arr.add(num);
            }

            Collections.sort(arr, Collections.reverseOrder());

            int count = 0;

            while(true){
                //프린트큐의 첫번째랑 arr의 맨 앞에 같으면 그게 중요도 높은 거니까 pop
                if(print_queue.peekFirst()[1] == arr.get(0)){
                    int[] poll = print_queue.pollFirst();
                    arr.remove(0);
                    count++;

                    if(poll[0] == M){
                        System.out.println(count);
                        break;
                    }

                }else{
                    int[] pop = print_queue.pollFirst();
                    print_queue.addLast(pop);
                }
            }


        }

    }
}