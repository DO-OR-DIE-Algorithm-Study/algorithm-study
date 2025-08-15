import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ18114 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        /**
         * 내 아이디어...
         * 떠오르지... 않는다...
         *
         * 1. 완전 탐색 -> 제한 시간 1초라서 ㅂㄱㄴ
         * 2. 이분 탐색을 해야하는데 start, mid, end를 두고 start와 end의 값이 계속 바뀌는걸로?
         * 해봤는데 절대 아닌듯
         */

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int[] w = new int[n];

        String[] split = br.readLine().split(" ");
        for(int i = 0; i < n; i++){
            w[i] = Integer.parseInt(split[i]);
        }

        Arrays.sort(w);

        boolean isExist = false;
        int start = 0;
        int end = n;
        int mid = (start + end) / 2;

        while(start != mid && mid != end){
            if(w[start] == c || w[mid] == c || w[end] == c){
                isExist = true;
                break;
            }

            if(w[start] + w[mid] == c || w[mid] + w[end] == c){
                isExist = true;
                break;
            }

            if(w[start] + w[mid] + w[end] == c){
                isExist = true;
                break;
            }

            int frontMid = (start + mid) / 2;
            int backMid = (mid + end) / 2;

            if(w[frontMid] < c)
        }
    }
}
