import java.io.*;
import java.util.StringTokenizer;

public class BOJ3079 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] t = new int[n];
        for(int i = 0; i < n; i++){
            t[i] = Integer.parseInt(br.readLine());
        }


    }
}
