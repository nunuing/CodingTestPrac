import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Q1943 {
    static int target, num;
    static boolean jud;
    static Coin[] coins;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int cur = 3;
        while (cur-- > 0) {
            num = Integer.parseInt(br.readLine());
            coins = new Coin[num];
            int total = 0;
            for (int i = 0; i < num; i++) {
                st = new StringTokenizer(br.readLine());
                int price = Integer.parseInt(st.nextToken());
                int number = Integer.parseInt(st.nextToken());
                coins[i] = new Coin(price, number);

                total += (coins[i].price * coins[i].number);
            }

            Arrays.sort(coins, new Comparator<Coin>() {
                @Override
                public int compare(Coin o1, Coin o2) {
                    return o2.price - o2.price;
                }
            });

            if (total % 2 != 0) {
                sb.append("0\n");
                continue;
            }
            target = total / 2;
        }

        System.out.println(sb);
    }
    static class Coin{
        public int price;
        public int number;
        public Coin(int price, int number) {
            this.price = price;
            this.number = number;
        }
    }
    static void dfs(int now, int price) {
        if (price >= target) {
            if (price == target)
                jud = true;
            return;
        }
        for (int i = now; i < coins.length; i++) {
            if (coins[i].number > 0) {
                coins[i].number--;
//                dfs();
            }
        }
    }
}
