package Codding.BOJ.silver;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class _s4_1620_나는야_포켓몬_마스터_이다솜 {

    private static StringTokenizer st;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        st = new StringTokenizer(br.readLine());

        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        Map<Integer, String> number_map = new HashMap<>();
        Map<String, Integer> chatacter_map = new HashMap<>();



        for(int i = 1; i <= M; i++){
            String character = br.readLine();
            number_map.put(i, character);
            chatacter_map.put(character, i);
        }

        for(int i = 1; i <= N; i++){
            String str = br.readLine();
            //숫자 판별식
            if(str.matches("\\d+")){
                bw.append(number_map.get(Integer.parseInt(str))).append("\n");
            }else{
                bw.append(String.valueOf(chatacter_map.get(str))).append("\n");
            }
        }

        bw.flush();
        bw.close();

    }
}
