![image](https://user-images.githubusercontent.com/67637716/162231530-dba49dd3-c980-4dce-8b11-6de320586b6d.p)

# 나의 풀이
```
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class KthNumber {
	public int[] solution(int[] array, int[][] commands) {
		int[] answer = new int[commands.length];
		for (int i = 0; i < commands.length; i++) {
			List<Integer> list = new ArrayList<>();
			for (int j = commands[i][0] - 1; j < commands[i][1]; j++) {
				list.add(array[j]);
			}
			list.sort(Comparator.comparingInt(Integer::intValue));
			answer[i] = list.get(commands[i][2] - 1);
		}

		return answer;
	}

	public static void main(String[] args) {
		KthNumber k = new KthNumber();
		int[] array = { 1, 5, 2, 6, 3, 7, 4 };
		int[][] commands = { { 2, 5, 3 }, { 4, 4, 1 }, { 1, 7, 3 } };

		int[] answer = k.solution(array, commands);

		System.out.println(Arrays.stream(answer).boxed().collect(Collectors.toList()));

	}
}

풀이 시간 : 30분

채점 결과
정확성: 100.0
합계: 100.0 / 100.0
```  

# 다른 사람의 풀이 
``` java
// Arrays.copyOfRange를 사용 
// Arrays.copyOf() , Arrays.copyOfRange() 메소드를 통해 배열을 복사 할 수 있다.
// Arrays.copyOf(원본배열, 복사할 길이);
// Arrays.copyOfRange(원본 배열, 복사할 시작인덱스, 복사할 끝인덱스) 인덱스는 0부터 시작하는것 기준

// 값에 의한 복사이므로 복사된 배열에서 값을 바꿔도 원본 배열의 값이 바뀌지 않음!

// Arrays.sort() 는 배열만 sort됨. List<Integer>불가.
public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];

        for(int i=0; i<commands.length; i++){
            int[] temp = Arrays.copyOfRange(array, commands[i][0]-1, commands[i][1]);
            Arrays.sort(temp);
            answer[i] = temp[commands[i][2]-1];
        }

        return answer;
    }
```
