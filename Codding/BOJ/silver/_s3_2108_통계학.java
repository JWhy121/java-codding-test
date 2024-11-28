package Codding.BOJ.silver;

import java.io.*;
import java.util.*;

public class _s3_2108_통계학 {

    private static int N;
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());


        HashMap<Integer, Integer> map = new HashMap<>();
        int[] arr = new int[N];

        for(int i = 0; i < N; i++){
            int num = Integer.parseInt(br.readLine());
            arr[i] = num;
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        double sum = 0.0;
        for(int i = 0; i < N; i++){
            sum += arr[i];
        }
        sb.append(Math.round(sum / arr.length) +"\n");

        Arrays.sort(arr);
        sb.append(arr[N / 2] + "\n");

        /*
        HashMap의 Key와 Value를 정렬할 때는 entrySet으로 변경 후 정렬
         */
        List<Map.Entry<Integer, Integer>> keySet = new ArrayList<>(map.entrySet());

        keySet.sort(((o1, o2) -> {
            return o1.getValue() != o2.getValue() ? o2.getValue() - o1.getValue() : o1.getKey() - o2.getKey();
        }));

        if(keySet.size() > 1){
            if(keySet.get(0).getValue().equals(keySet.get(1).getValue())){
                sb.append(keySet.get(1).getKey() + "\n");
            }else {
                sb.append(keySet.get(0).getKey() + "\n");
            }
        }else {
            sb.append(keySet.get(0).getKey() + "\n");
        }


        if(keySet.size() > 1){
            sb.append(arr[N-1] - arr[0] + "");
        }else{
            sb.append(0 + "");
        }

        bw.write(sb.toString());

        bw.flush();
        bw.close();

    }
}
