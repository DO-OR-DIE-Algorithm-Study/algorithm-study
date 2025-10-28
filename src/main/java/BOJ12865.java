import java.io.*;

public class BOJ12865 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] line = br.readLine().split(" ");
        int n = Integer.parseInt(line[0]);
        int k = Integer.parseInt(line[1]);

        int[][] dp = new int[n + 1][k + 1];

        for(int i = 1; i < n + 1; i++){
            String[] split = br.readLine().split(" ");
            int w = Integer.parseInt(split[0]);
            int v = Integer.parseInt(split[1]);

            for(int j = 1; j < k + 1; j++){
                if(j - w >= 0){
                    dp[i][j] = dp[i - 1][j - w] + v;
                }
                dp[i][j] = Math.max(dp[i][j], dp[i - 1][j]);
            }
        }
        bw.append(String.valueOf(dp[n][k]));
        bw.flush();
        bw.close();
        br.close();
    }
}
