import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	private static int[] arr = new int[50];
	private static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for (int i = 0; i < arr.length; i++) {
			arr[i] = i + 1;
		}

		int n;
		while ((n = Integer.parseInt(br.readLine())) != 0) {
			binarySearch(n);
		}
		
		System.out.println(sb);
	}

	private static String binarySearch(int n) {
		int row = 0;
		int high = arr.length - 1;

		while (high >= row) {
			int mid = (row + high) / 2;

			if (arr[mid] == n) {
				sb.append(arr[mid]);
				break;
			} else if (arr[mid] < n) {
				row = mid + 1;
			} else {
				high = mid - 1;
			}

			sb.append(arr[mid] + " ");
		}

		sb.append("\n");

		return null;
	}
}
