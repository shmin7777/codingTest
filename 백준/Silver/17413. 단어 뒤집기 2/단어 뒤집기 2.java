import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();

        char[] chars = line.toCharArray();
        StringBuilder answer = new StringBuilder();
        StringBuilder sb = new StringBuilder();

        boolean flag = false; // <>안에 있냐 없냐 : 있으면 true

        for (char c : chars) {
            if (c == '<') {
                answer.append(sb.reverse());
                sb.delete(0, sb.capacity());
                flag = true;
            } else if (c == '>') {
                answer.append(c);
                flag = false;
                continue;
            }

            if (flag) {
                answer.append(c);
                continue;
            }

            if (c == ' ') {
                sb.reverse();
                sb.append(c);
                answer.append(sb);
                sb.delete(0, sb.capacity());
            }else {
                sb.append(c);
            }

        }
        answer.append(sb.reverse());
        
        System.out.println(answer);
    }
}
