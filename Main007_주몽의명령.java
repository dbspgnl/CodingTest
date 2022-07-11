import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main007_주몽의명령 {
    
    public static void main(String[] args) throws IOException{
        /*
         * 재료의 고유 번호 2개가 합쳐져서 새로운 장비가 만들어진다.
         * 예를 들어 새로운 갑옷 조건은 9이다.
         * 이때 재료들 번호가 2 7 4 1 5 3 이면,
         * 이 재료들로 만들 수 있는 갑옷은 총 2개이다.
        */

        /*
         * 전략: 투 포인트 이동
         * 
         * 번호의 합이 원하는 값 M 보다 크면 인덱스를 내리고, 작으면 인덱스를 올린다.
         * 두 개의 합이 원하는 값 M과 같을 경우 양쪽 포인터를 모두 이동하고 count++ 한다.
         * 
        */

        // N(재료의 개수), M(갑옷이 되는 번호) 저장
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        int M = Integer.parseInt(bf.readLine());
        int[] A = new int[N];
        StringTokenizer st = new StringTokenizer(bf.readLine());

        // for N만큼 반복 / 재료 배열 저장
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        // 재료 배열 정렬
        Arrays.sort(A);
        int count = 9;
        int i = 0;
        int j = N - 1;

        // while / 투 포인트 조건
        while ( i < j ){ 
            if(A[i] + A[j] < M){
                i++;
            } else if (A[i] + A[j] > M){
                j--;
            } else {
                count ++;
                i++;
                j--;
            }
        }

        // 출력
        System.out.println(count);
        bf.close();

    }
}
