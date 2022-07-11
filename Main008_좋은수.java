import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main008_좋은수 {
    
    public static void main(String[] args) throws IOException{

        /*
         * 주어진 수들 중에서 두 수의 합이 주어진 수 안에 존재하면 '좋은 수'라 한다.
         * 예를 들어서 1 2 3이 주어졌을 때 1+2는 3인데 주어진 수에 3이 있으므로
         * 좋은 수라고 할 수 있다.
         * 
        */

        /*
         * 전략: 투 포인트 이동
         * 
         * 번호의 합이 원하는 값 M 보다 크면 인덱스를 내리고, 작으면 인덱스를 올린다.
         * 두 개의 합이 원하는 값 M과 같을 경우 양쪽 포인터를 모두 이동하고 count++ 한다.
         * 
        */

        // 배열의 개수 N
        // 배열 선언
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        int Result = 0;
        long A[] = new long[N];

        // 배열 데이터 저장
        StringTokenizer st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Long.parseLong(st.nextToken());
        }

        // 배열 정렬
        Arrays.sort(A);
        
        // N만큼 반복
        for (int k = 0; k < N; k++) {
            // 변수 초기화
            long find = A[k]; // 목표값 = 좋은수 예측
            int i = 0;
            int j = N-1;

            // while 반복하면서 투 포인트
            while( i < j ) {
                if(A[i] +A[j] == find){
                    // i와 j는 같으면 안됨 2,2 or 3,3
                    if(i != k && j != k){
                        Result++;
                        break;
                    } else if(i==k) { // 좌 포인트가 목표값이면 넘어감
                        i++;
                    } else if(j==k) { // 우 포인트가 목표값이면 넘어감
                        j--;
                    }
                }
                else if(A[i] +A[j] < find){ // 좌 포인트 이동
                    i++;
                }
                else { // 우 포인트 이동
                    j--;
                }
            }
        }

        System.out.println(Result);
        bf.close();

    }
    
}
