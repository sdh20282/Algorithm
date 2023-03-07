import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String operation = br.readLine();
		
		// +, -, 숫자로 분리된 연산을 담기 위한 리스트
		ArrayList<String> operations = new ArrayList<>();
		// 전체적인 최솟값을 저장하기 위한 min, 부분적인 최재값을 저장하기 위한 part
		int min = 0, part = 0;
		
		// 연산 분리, 문자열 내에서의 현재 위치(i)와 이전 숫자의 시작 위치(p)를 통해 숫자와 연산자 구분
		// 초기에는 i와 p를 0으로 초기화, 처음에는 무조건 숫자 존재
		for (int i = 0, p = 0; i < operation.length(); i++) {
			// 현재 위치에서 연산자를 만나면
			if (operation.charAt(i) == '+' || operation.charAt(i) == '-') {
				// 숫자 파싱
				operations.add(operation.substring(p, i));
				// 연산자 파싱
				operations.add(operation.substring(i, i + 1));
				// 숫자 위치 갱신
				p = i + 1;
			}
			
			// 현재 위치가 배열의 끝에 도달했다면
			if (i == operation.length() - 1) {
				// 숫자 추가
				operations.add(operation.substring(p, i + 1));
			}
		}
		
		// 최솟값을 구하기 위에 분리한 연산의 마지막에서부터 접근
		// 숫자들을 모았다가 -가 나오면 한꺼번에 빼줌
		for (int i = operations.size() - 1; i >= 0; i--) {
			// 현재 연산자가 -라면
			if (operations.get(i).equals("-")) {
				// 모아두었던 숫자들을 빼주고
				min -= part;
				// 갱신
				part = 0;
			// 현재 위치가 숫자라면
			} else if (!operations.get(i).equals("+")) {
				// 숫자들을 part 변수에 모아두기
				part += Integer.parseInt(operations.get(i));
			}
		}
		
		// 남아있는 값을 min에 더해줌
		min += part;
		
		System.out.println(min);
	}
}
