package Codding.BOJ.silver;

import java.io.*;
import java.util.*;

public class _s2_18870_좌표_압축 {

    private static int[] arr;
    private static Set<Integer> set;
    private static Map<Integer, Integer> map;


    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        set = new HashSet<>();
        map = new HashMap<>();
        arr = new int[N];
        for(int i = 0; i < N; i++){
            int num = Integer.parseInt(st.nextToken());
            set.add(num);
            arr[i] = num;
        }

        List<Integer> sorted_list = new ArrayList<>(set);
        Collections.sort(sorted_list);

        for(int i = 0; i < sorted_list.size(); i++){
            map.put(sorted_list.get(i), i);
        }

        for(int i = 0; i < N; i++){
            bw.append(String.valueOf(map.get(arr[i]))).append(" ");
        }

        bw.flush();
        bw.close();

    }
}
