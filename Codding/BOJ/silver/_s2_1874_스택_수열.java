package Codding.BOJ.silver;

import java.io.*;
import java.util.ArrayDeque;

public class _s2_1874_스택_수열 {

    private static int N;
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());

        //거꾸로 들어갈 Stack과 1부터 N까지의 숫자 차례대로 들어갈 Stack 초기화
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        ArrayDeque<Integer> stack_rev = new ArrayDeque<>();

        //N부터 1까지 넣은 Stack
        for(int i = N; i > 0; i--){
            stack.push(i);
        }

        /*
        입력받은 수를 확인하면서 for문 실행
         */
        for(int i = 0; i < N; i++){
            int num = Integer.parseInt(br.readLine());

            //입력된 수가 기존 stack의 맨 위보다 크거나 같으면
            if(!stack.isEmpty() && stack.peek() <= num){

                //작은 수들을 stack_rev에 넣고 입력된 수는 pop
                while(!stack.isEmpty()){
                    if(stack.peek() == num){
                        stack.pop();
                        sb.append("+\n-\n");
                        break;
                    }else{
                        stack_rev.push(stack.pop());
                        sb.append("+\n");
                    }
                }
                //stack_rev에 담긴 수가 입력된 수라면 바로 pop
            }else if(!stack_rev.isEmpty() && stack_rev.peek() == num){
                stack_rev.pop();
                sb.append("-\n");
            }else //위 조건에 다 안맞으면 수열을 만들 수 없으므로 바로 break
                break;

        }


        //stack_rev가 비어있다는 건 모든 수가 차례대로 잘 pop 되었다는 의미이므로 sb 출력
        if(stack_rev.isEmpty()){
            bw.write(String.valueOf(sb));
            //stack_rev가 비어있지 않으면 도중에 break 되었다는 의미이므로 NO 출력
        }else{
            bw.write("NO");
        }

        bw.flush();
        bw.close();

    }
}
