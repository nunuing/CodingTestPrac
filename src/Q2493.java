import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Q2493 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] height = new int[n + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            height[i] = Integer.parseInt(st.nextToken());
        }

        int[] answer = new int[n + 1];
        Stack<Integer> stack = new Stack<>();
        stack.push(n);
        for (int i = n - 1; i > 0; i--) {
            while (!stack.isEmpty()) {
                int temp = stack.peek();
                if (height[temp] <= height[i]) {
                    int c = stack.pop();
                    answer[c] = i;
                }
                else {
                    break;
                }
            }
            stack.push(i);
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            sb.append(answer[i] + " ");
        }

        System.out.println(sb);
    }
}
