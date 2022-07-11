import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main003 {
    public static void main(String[] args) throws IOException {
        // 합 배열 공식
        // s[i] = s[i-1] - a[i] 
        // 간단히 어떤 배열까지의 합은 이전 배열까지 합 + 해당 배열의 합 = 당연한 말

        // 구간 합 공식
        // s[j] - s[i-1]
        // i부터 j까지 합은 인덱스0부터인 특징에 의해서 j-(i-1)이 된다.

        // 문제
        // 1. 배열의 크기와 질의할 횟수를 기입한다.
        // 2. 배열 값을 입력한다. (배열 크기에 맞게)
        // 3. 질의할 횟수만 큼 i와 j를 입력한다.

        // suNo 숫자 개수 받기
        // quizNo 질의 개수 받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int suNo = Integer.parseInt(st.nextToken());
        int quizNo = Integer.parseInt(st.nextToken());
        long[] s = new long[suNo +1]; // 입력 5이면 배열이 6
        // +1 하는 이유는 s[0] 값은 0으로 시작하기 때문이다.
        st = new StringTokenizer(br.readLine()); // 배열 받기

        // for(숫자 개수만큼 반복)
        // (s[i] = s[i-1]+a(i))
        for (int i = 1; i <= suNo; i++) { // 입력받은 N번만큼 시행하면 종료
            s[i] = s[i-1] + Integer.parseInt(st.nextToken());
        }

        // for(질의 개수만큼 반복)
        // 질의 범위 받기
        // 구간 합 출력 s[j] - s[i-1]
        for (int q = 0; q < quizNo; q++) {
            st = new StringTokenizer(br.readLine());
            int i = Integer.parseInt(st.nextToken());
            int j = Integer.parseInt(st.nextToken());
            System.out.println(s[j] - s[i-1]);
        }

    }
}
