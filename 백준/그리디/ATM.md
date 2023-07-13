![image](https://github.com/shmin7777/codingTest/assets/67637716/e996e86d-ce98-46a4-b128-64997f330eab)  


``` java
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) throws IOException {
        try (Scanner sc = new Scanner(System.in)) {
            int n = Integer.parseInt(sc.nextLine());
            String nextLine = sc.nextLine();
            String[] times = nextLine.split(" ");

            List<Integer> collect =
                    Arrays.stream(times).map(i -> Integer.parseInt(i)).collect(Collectors.toList());

            Collections.sort(collect);
            
            int result = 0;
            int sum = 0;
            for (int i = 0; i < collect.size(); i++) {
                sum += collect.get(i);
                result += sum;
            }
            System.out.println(result);
        }


    }
}

```  
