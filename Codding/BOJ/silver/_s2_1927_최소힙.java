package Codding.BOJ.silver;

import java.io.*;
import java.util.ArrayList;

public class _s2_1927_최소힙 {

    private static int M;
    private static int N;
    private static ArrayList<Integer> heap;

    public _s2_1927_최소힙() {
        heap = new ArrayList<>();
        heap.add(-1);
    }

    public int deleteNum(){

        if(heap.size() <= 1){
            return 0;
        }

        if(heap.size() == 2){
            int temp = heap.get(heap.size() - 1);
            heap.remove(heap.size() - 1);
            return temp;
        }
        //삭제될 가장 작은 수
        int deletedNum = heap.get(1);

        //루트노드에 마지막 노드의 값 넣기
        heap.set(1, heap.get(heap.size() - 1));
        //마지막 노드 값 지우기
        heap.remove(heap.size() - 1);

        int pos = 1;

        while((pos * 2) < heap.size()){

            //부모노드의 왼쪽 노드 정보
            int min = heap.get(pos * 2);
            int minPos = pos * 2;

            //오른쪽 노드 유무 확인하고, 있다면 둘 중 어느 값이 더 큰지 확인
            if((pos * 2 + 1) < heap.size() && min > heap.get(pos * 2 + 1)){
                min = heap.get(pos * 2 + 1);
                minPos = pos * 2 + 1;
            }

            if(heap.get(pos) < min)
                break;

            int temp = heap.get(pos);
            heap.set(pos, heap.get(minPos));
            heap.set(minPos, temp);
            pos = minPos;
        }

        return deletedNum;
    }

    public void addNum(int num){

        heap.add(num);

        int pos = heap.size() - 1;

        //pos가 루트보다 아래에 있고, pos의 값이 부모노드의 값보다 작으면 swap
        while(pos > 1 && heap.get(pos) < heap.get(pos / 2)){

            int temp = heap.get(pos);
            heap.set(pos, heap.get(pos / 2));
            heap.set(pos / 2, temp);

            pos = pos / 2;
        }


    }


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());

        _s2_1927_최소힙 minimupHeap = new _s2_1927_최소힙();

        for(int i = 0; i < N; i++){
            int x = Integer.parseInt(br.readLine());
            if(x == 0){
                System.out.println(minimupHeap.deleteNum());
            }else {
                minimupHeap.addNum(x);
            }
        }

        bw.flush();
        bw.close();

    }
}
