import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q12865 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[][] bags = new int[n][2];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            bags[i][0] = Integer.parseInt(st.nextToken());
            bags[i][1] = Integer.parseInt(st.nextToken());
        }

        int[][] values = new int[n][2];
        int[][] weight = new int[n][2];
        values[0][0] = 0;
        weight[0][0] = 0;


        weight[0][1] = bags[0][0] <= k ? bags[0][0] : 0;
        values[0][1] = bags[0][0] <= k ? bags[0][1] : 0;

        for (int i = 1; i < n; i++) {
            if (weight[i - 1][0] + bags[i][0] <= k){

            }
        }
    }
}
