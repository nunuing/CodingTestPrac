import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Q11866 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken()) - 1;

        StringBuilder sb = new StringBuilder();
        LinkedList<Integer> numbers = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            numbers.add(i);
        }

        sb.append('<');
        int pos = 0;
        while (!numbers.isEmpty()) {
            pos = (pos + k) % numbers.size();
            sb.append(numbers.get(pos));
            numbers.remove(pos);

            if (numbers.isEmpty()) {
                sb.append(">");
            }
            else {
                sb.append(", ");
            }
        }
        System.out.println(sb);
    }
}

