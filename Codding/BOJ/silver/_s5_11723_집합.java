package Codding.BOJ.silver;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class _s5_11723_집합 {

    private static int T;
    private static int M;
    private static int num;
    private static StringTokenizer st;
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        ArrayList<Integer> arr = new ArrayList<>();

        M = Integer.parseInt(br.readLine());


        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            String s = st.nextToken();
            if(st.hasMoreTokens()){
                num = Integer.parseInt(st.nextToken());
            }

            int index = arr.indexOf(num);

            //add 연산
            if(s.equals("add")){
                if(!arr.contains(num)){
                    arr.add(num);
                }
                continue;
            }

            //remove 연산
            if(s.equals("remove")){
                if(index != -1){
                    arr.remove(index);
                }
                continue;
            }

            //check 연산
            if(s.equals("check")){
                if(index != -1){
                    sb.append(1 + "\n");
                }else
                    sb.append(0 + "\n");
                continue;
            }

            //toggle 연산
            if(s.equals("toggle")){
                if(index != -1){
                    arr.remove(index);
                }else
                    arr.add(num);
                continue;
            }

            //all 연산
            if(s.equals("all")){
                arr.clear();
                for(int j = 1; j <= 20; j++){
                    arr.add(j);
                }
                continue;
            }
            //empty 연산
            if(s.equals("empty")){
                arr.clear();
                continue;
            }

        }

        bw.write(sb.toString());

        bw.flush();
        bw.close();

    }
}
