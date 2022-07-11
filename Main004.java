import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main004 {
    
    public static void main(String[] args) throws Exception{
        /* 2차원 배열의 구간 합 구하기
         * 구간의 합이므로 각 누적합으로 이뤄진 배열을 만들어낸다.
         * 예를 들어서 모든 칸이 1인 3x3배열의 누적합 배열은
         * 1 2 3    1 3 6
         * 2 3 4  > 3 8 15
         * 3 4 5    6 15 27
         * 형태가 될 것이다. 
         * 구간의 합은 전체 구간 = 마지막 구간을 구하고
         * 포함되지 않는 구간의 누적합을 뺀다. 행에서 한 번, 열에서 한 번.
         * 그리고 두 번 뺀 구간을 한 번 더해준다.
         * 따라서 위의 (2,2)에서 (3,3)의 값은
         * 27-6-6+1 = 16 = 3+4+4+5이 되는 것이다. 
         * 대각선의 합을 구하는 공식은 아래와 같다.
         * 누적합D : D[i-1][j] + D[i][j-i] - D[i-1][j-1] + A[i][j]
         * 쉽게 말해서 구하는 누적합 위치 위,아래 누적합을 더하고 겹치는 부분 빼고, 해당 위치 값을 더하는 것
         */

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 배열 크기 4 -> 4x4
        int M = Integer.parseInt(st.nextToken()); // 질문 횟수 

        // 배열 만들기
        int A[][] = new int[N+1][N+1];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                A[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        // 누적 배열 만들기
        int D[][] = new int[N+1][N+1];
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                D[i][j] = D[i][j-1] + D[i-1][j] - D[i-1][j-1] + A[i][j];
            }
        }
        // 질문 횟수만큼 답변
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            // 구간의 합 공식
            int result = D[x2][y2] - D[x1-1][y2] - D[x2][y1-1] + D[x1-1][y1-1];
            System.out.println(result);
        }
    }
}
