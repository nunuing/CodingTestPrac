import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q20125 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        char[][] map = new char[n][n];
        Pair heart = null;
        for (int i = 0; i < n; i++) {
            map[i] = br.readLine().toCharArray();
            for (int j = 0; j < n; j++) {
                if ((heart == null) && (map[i][j] == '*')) {        //머리 찾음 -> 밑에가 심장
                    heart = new Pair(i + 1, j);
                }
            }
        }

        int[] dr = {0, 0, 1, 1, 1};
        int[] dc = {-1, 1, 0, 0, 0};
        StringBuilder sb = new StringBuilder();
        sb.append((heart.row + 1) + " " + (heart.col + 1) + "\n");

        for (int i = 0; i < dr.length; i++) {
            int cnt = 0;
            int tr = heart.row;
            int tc = heart.col;
            if (i == 3) {
                tc -= 1;
            }
            else if (i == 4) {
                tc += 1;
            }

            while (true) {
                tr += dr[i];
                tc += dc[i];
                if (tr < 0 || tr >= n || tc < 0  || tc >= n){
                    break;
                }
                if (map[tr][tc] == '_') {
                    break;
                }
                else {
                    cnt++;
                }
            }
            if (i == 2) {
                heart = new Pair(tr - 1, tc);
            }
            sb.append(cnt + " ");
        }
        System.out.println(sb);

    }
    static class Pair {
        public int col;
        public int row;
        Pair(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }
}
