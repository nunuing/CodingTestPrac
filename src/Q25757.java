import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Q25757 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        char game = st.nextToken().charAt(0);

        HashSet<String> hs = new HashSet<>();
        for (int i = 0; i < n; i++) {
            String temp = br.readLine();
            hs.add(temp);
        }

        int number = 0;
        if (game == 'Y') {
            number = 1;
        }
        else if (game == 'F') {
            number = 2;
        }
        else {
            number = 3;
        }

        int answer = hs.size() / number;
        System.out.println(answer);
    }
}

