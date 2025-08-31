import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class BOJ11000 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[][] lectures = new int[n][2];

        for(int i = 0; i < n; i++){
            String[] split = br.readLine().split(" ");
            lectures[i][0] = Integer.parseInt(split[0]);
            lectures[i][1] = Integer.parseInt(split[1]);
        }

        /**
         * 내 아이디어
         * 1. 강의를 시작 순서로 정렬
         * 2. 우선순위 큐에서 끝시간을 기준으로 최소 힙 값을 조사
         * 3. 현재 보고 있는 강의의 시작 시간이 조사한 값의 끝시간보다 크면 해당 강의를 삽입하고 원래 값 추출, 아니면 그냥 삽입
         * 4. 마지막에 큐의 사이즈가 최소 강의실 수
         */

        Arrays.sort(lectures, Comparator.comparing(x -> x[0]));

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparing(x -> x[1]));

        for(int i = 0; i < n; i++){
            if(pq.isEmpty()){
                pq.add(lectures[i]);
                continue;
            }

            int[] cur = pq.peek();
            int[] lecture = lectures[i];

            if(cur[1] <= lecture[0]){
                pq.poll();
                pq.add(lecture);
            }else{
                pq.add(lecture);
            }
        }

        System.out.println(pq.size());
    }
}
