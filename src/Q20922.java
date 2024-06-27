import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q20922 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] nums = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        int[] count  = new int[100001];
        int answer = 0;
        int str = 0, end = 0;
        while (str <= end) {
            if (end >= n) {
                break;
            }
            count[nums[end]]++;
            while (str <= end && count[nums[end]] > k) {
                count[nums[str]]--;
                str++;
            }
            int length = (end - str) + 1;
            answer = answer >= length ? answer : length;
            end++;
        }
        System.out.println(answer);

    }
}
