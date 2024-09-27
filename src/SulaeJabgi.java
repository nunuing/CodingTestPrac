import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SulaeJabgi {
    static Can[][] map;
    static int n, m, h, k;
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        map = new Can[n][n];

        Position sullae = new Position(n/2 , n/2, 0);
        Queue<Position> runner = new LinkedList<>();
        for (int i = 1; i <= m; i++) {
            st = new StringTokenizer(br.readLine());
            int tx = Integer.parseInt(st.nextToken());
            int ty = Integer.parseInt(st.nextToken());
            int td = Integer.parseInt(st.nextToken());
            runner.offer(new Position(tx, ty, td));

            map[ty][tx].runner = i;
        }

        for (int i = 1; i <= h; i++) {
            st = new StringTokenizer(br.readLine());
            int tx = Integer.parseInt(st.nextToken());
            int ty = Integer.parseInt(st.nextToken());

            map[ty][tx].tree = i;
        }
//        Move();
    }
     static void Move() {
        int[] center = new int[] {n/2, n/2};
        int nx = (n/2 + 1);
        int ny = (n/2 + 1);
        //상 우 좌 하
        int cur = 1;
        while (true) {
            for (int i = 0; i < dx.length; i++) {
                while (Math.abs(nx - center[0]) <= cur && (Math.abs(ny - center[1]) <= cur)) {
                    nx += dx[i];
                    ny += dy[i];

                    if (nx < 0 || nx >= n || ny < 0 || ny >= n)
                        break;
                }
                if (nx == 0 && ny == 0)
                    break;
            }
        }
    }
    static void MoveBack() {
        int nx = 0;
        int ny = 0;
        //          하 우  상  좌
        int[] mx = {0, 1, 0, -1};
        int[] my = {-1, 0, 1, 0};

        while (true) {
            for (int i = 0; i < mx.length; i++) {

            }
        }
    }
    static class Can {
        public int tree = 0;
        public int runner = 0;
    }
    static class Position {
        public int x;
        public int y;
        public int dir;
        public Position(int x, int y, int dir) {
            this.x = x;
            this.y = y;
            this.dir = dir;
        }
    }
}
