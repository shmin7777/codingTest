![image](https://user-images.githubusercontent.com/67637716/161793522-a8cf396d-ee25-4e67-802a-fc168e5319e3.png)  
![image](https://user-images.githubusercontent.com/67637716/161793582-d14e2eee-2f2b-484a-a95d-53b836a5d67e.png)  

# 나의 풀이  
``` java
import java.util.LinkedList;
import java.util.Queue;

public class Printer {

	public int solution(int[] priorities, int location) {
		Queue<Integer> queue = new LinkedList<>(); // priorities queue
		Queue<Integer> answerQueue = new LinkedList<>(); // 중요도 별로 정렬된 queue
		
		// priorities queue에 priorities 배열을 넣어줌
		for (int i = 0; i < priorities.length; i++) {
			queue.offer(priorities[i]);
		}

		// queue의 element의 max값 구하기 
		// max는 optional을 반환하는데, size가 0이나올수 없기 때문에 바로 get()
		int max = queue.stream().max((i1, i2) -> {
			return i1.compareTo(i2);
		}).get();

		while (true) {
			int element = queue.poll(); // queue의 제일 첫번째 요소를 꺼내고 삭제
			if (element < max) { 
				queue.offer(element); // queue의 제일 마지막에 요소 추가
				if (location != 0) {
					location--;	
				} else { 
					location = queue.size() - 1; // location을 quque의 맨 뒤로 보냄
				}
			} else {
				// element가 max값
				answerQueue.offer(element); // answerQueue에 add
				if (location == 0) {
					// 원하는 element가 꺼내졌으므로 break
					break;
				} else {
					// max값 update
					max = queue.stream().max((i1, i2) -> {
						return i1.compareTo(i2);
					}).get();

				}
				
				if (location != 0) {
					location--;
				} else {
					location = queue.size() - 1;
				}
			}
		}
		return answerQueue.size();
	}

	public static void main(String[] args) {
		int[] priorities = { 2, 1, 3, 2 };
		int[] priorities2 = {1, 1, 9, 1, 1, 1};
		
		int location = 2;
		int location2 = 0;
		
		Printer printer = new Printer();
		int result = printer.solution(priorities, location);
		System.out.println(result);
	}
}

풀이 시간 : 40분

채점 결과
정확성: 100.0
합계: 100.0 / 100.0
```  

# 다른 사람의 풀이
``` java
// 내 풀이와 비슷
// 정렬 사용해서 반복문을 돌아서 max값 구하는 logic 생략 :: 시간 복잡도가 줄어듬!
 public int solution(int[] priorities, int location) {
        int answer = 0;
        int l = location;

        Queue<Integer> que = new LinkedList<Integer>();
        for(int i : priorities){
            que.add(i);
        }

        Arrays.sort(priorities);
        int size = priorities.length-1;



        while(!que.isEmpty()){
            Integer i = que.poll();
            if(i == priorities[size - answer]){
                answer++;
                l--;
                if(l <0)
                    break;
            }else{
                que.add(i);
                l--;
                if(l<0)
                    l=que.size()-1;
            }
        }

        return answer;
    }
```
