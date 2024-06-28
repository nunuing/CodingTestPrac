import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Q1446 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());

        ArrayList<Road> roads = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int str = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int dist = Integer.parseInt(st.nextToken());

            if (end > d)        //갈 수 없는 길
                continue;
            if ((end - str) < dist) //지름길이 아님
                continue;
            roads.add(new Road(str, end, dist));
        }

        roads.sort(Road::compareTo);

        int[] dist = new int[d + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        int now = 0;
        int idx = 0;
        dist[0] = 0;
        while (now < d) {
            if (idx < roads.size()) {
                Road r = roads.get(idx);
                if (r.str == now) {
                    dist[r.end] = Math.min(dist[r.end], dist[now] + r.dist);
                    idx++;
                } else {
                    dist[now + 1] = Math.min(dist[now] + 1, dist[now + 1]);
                    now++;
                }
            }
            else {
                dist[now + 1] = Math.min(dist[now] + 1, dist[now + 1]);
                now++;
            }
        }
        System.out.println(dist[d]);
    }
    static class Road implements Comparable<Road> {
        public int str;
        public int end;
        public int dist;
        public Road(int str, int end, int dist){
            this.str = str;
            this.end = end;
            this.dist = dist;
        }

        @Override
        public int compareTo(Road r) {
            return this.str - r.str;
        }
    }
}
