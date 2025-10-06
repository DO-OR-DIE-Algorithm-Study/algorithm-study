import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ2110 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        long[] house = new long[n];
        for(int i = 0; i < n; i++){
            house[i] = Long.parseLong(br.readLine());
        }

        Arrays.sort(house);

        long l = 0, r = house[house.length - 1] - house[0];
        long answer = 0;

        while(l <= r){
            long mid = (l + r) / 2;
            long start = house[0];
            int count = 1;
            for(int i = 1; i < n; i++){
                if(house[i] - start >= mid){
                    count++;
                    start = house[i];
                }
            }

            if(count >= c){
                answer = mid;
                l = mid + 1;
            }else{
                r = mid - 1;
            }
        }

        System.out.println(answer);

    }
}
