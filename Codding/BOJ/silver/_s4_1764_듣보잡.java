package Codding.BOJ.silver;

import java.io.*;
import java.util.*;

public class _s4_1764_듣보잡 {

    private static int M;
    private static int N;
    private static StringTokenizer st;
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        st = new StringTokenizer(br.readLine());
        HashSet<String> hashSet = new HashSet<>();

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        String[] str_n = new String[N];

        for(int i = 0; i < N; i++){
            str_n[i] = br.readLine();
        }

        Arrays.sort(str_n);

        for(int i = 0; i < M; i++){
            int idx = Arrays.binarySearch(str_n, br.readLine());

            if(idx >= 0){
                hashSet.add(str_n[idx]);
            }
        }

       List<String> arr_set = new ArrayList<>(hashSet);

       arr_set.sort((o1, o2) -> o1.compareTo(o2));

       sb.append(arr_set.size() + "\n");

       for(int i = 0; i < arr_set.size(); i++){
           sb.append(arr_set.get(i) + "\n");
       }

       bw.write(sb.toString());

        bw.flush();
        bw.close();

    }
}
