package Codding.BOJ;

import java.io.*;
import java.util.ArrayDeque;

public class _s4_10845_큐 {
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        ArrayDeque<Integer> queue = new ArrayDeque<>();


        int n = Integer.parseInt(br.readLine());

        for(int i = 0; i < n; i++){
            String s = br.readLine();

            if(s.startsWith("push")){
                String[] s_arr = s.split(" ");
                queue.addLast(Integer.parseInt(s_arr[1]));
            }

            if(s.equals("pop")){
                if(!queue.isEmpty()){
                    bw.write(String.valueOf(queue.pollFirst()) + "\n");
                }else{
                    bw.write("-1" + "\n");
                }
            }

            if(s.equals("size")){
                bw.write(String.valueOf(queue.size()) + "\n");
            }

            if(s.equals("empty")){
                if(queue.isEmpty()){
                    bw.write("1" + "\n");
                }else
                    bw.write("0" + "\n");
            }

            if(s.equals("front")){
                if(!queue.isEmpty()){
                    bw.write(String.valueOf(queue.peekFirst()) + "\n");
                }else{
                    bw.write("-1" + "\n");
                }
            }

            if(s.equals("back")){
                if(!queue.isEmpty()){
                    bw.write(String.valueOf(queue.peekLast()) + "\n");
                }else{
                    bw.write("-1" + "\n");
                }
            }
        }

        bw.flush();
        bw.close();


    }
}
