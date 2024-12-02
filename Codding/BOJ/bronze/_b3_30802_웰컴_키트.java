package Codding.BOJ.bronze;

import com.sun.jdi.event.StepEvent;

import javax.swing.*;
import java.io.*;
import java.util.StringTokenizer;

public class _b3_30802_웰컴_키트 {

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());

        StringTokenizer size = new StringTokenizer(br.readLine());
        StringTokenizer set = new StringTokenizer(br.readLine());

        int T = Integer.parseInt(set.nextToken());
        int P = Integer.parseInt(set.nextToken());

        int sum = 0;

        for(int i = 0; i < 6; i++){
            int tmp = Integer.parseInt(size.nextToken());

            if(tmp == 0)
                continue;

            if(tmp <= T)
                sum += 1;

            if(tmp > T){
                if(tmp % T == 0)
                    sum += tmp / T;
                else
                    sum += tmp / T + 1;
            }
        }

        sb.append(sum + "\n");
        if(N < P)
            sb.append(0 + " " + N);
        else if(N == P)
            sb.append(N + " " + 0);
        else
            sb.append(N / P + " " + N % P);

        bw.write(sb.toString());


        bw.flush();
        bw.close();

    }
}
