import java.sql.Connection;
import java.util.*;

public class P_여행경로 {
    static boolean[] used;
    static ArrayList<String> answer;
    public static void main(String[] args) {
        System.out.println(solution(new String[][]{{"ICN", "JFK"}, {"HND", "IAD"}, {"JFK", "HND"}}));
        System.out.println(solution(new String[][]{{"ICN", "SFO"}, {"ICN", "ATL"}, {"SFO", "ATL"}, {"ATL", "ICN"}, {"ATL","SFO"}}));
    }
    static public String[] solution(String[][] tickets) {
        answer = new ArrayList<>();
//        주어진 항공권을 모두 이용하여 여행경로
//        항상 "ICN" 공항에서 출발
        used = new boolean[tickets.length];
        Arrays.sort(tickets, new Comparator<String[]>() {
            @Override
            public int compare(String[] o1, String[] o2) {
                if (o1[0].equals(o2[0]))
                    return o1[1].compareTo(o2[1]);
                else
                    return o1[0].compareTo(o2[0]);
            }
        });
        dfs(0, "ICN", "ICN", tickets);
        Collections.sort(answer);
        return answer.get(0).split(" ");
    }
    static void dfs(int depth, String route, String now, String[][] tickets) {
        if (depth >= tickets.length) {
            answer.add(route);
            return;
        }
        for (int i = 0; i < tickets.length; i++) {
            if (!used[i] && tickets[i][0].equals(now)) {
                used[i] = true;
                dfs(depth + 1, route + " " + tickets[i][1], tickets[i][1], tickets);
                used[i] = false;
            }
        }
    }
}
