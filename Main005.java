import java.util.Scanner;

public class Main005 {
    
    public static void main(String[] args){

        /*
         * 배열의 구간의 합(ex 1~2, 3~4, 2~5, 1~5)을 
         * 특정 값으로 나눠서 0으로 떨어지는 경우의 수 구하기
         * 1. 수열의 개수 N 받기
         * 2. 나눌 수 M 받기
        */

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        long[] S = new long[N];
        long[] C = new long[M];
        long answer = 0;
        S[0] = sc.nextInt();
        for (int i = 1; i < N; i++) { // 배열 만들기
            S[i] = S[i-1] + sc.nextInt();
        }
        for (int i = 0; i < N; i++) { // 합 배열에서 % 나머지 연산 수행
            int remainder = (int)(S[i]%M);
            if(remainder==0) answer ++;
            C[remainder]++;
        }
        for (int i = 0; i < M; i++) { // 경우의 수 구하기
            if(C[i]>1){
                answer = answer + (C[i]*(C[i]-1)/2);
            }
        }
        System.out.println(answer);
        sc.close();

    }

}
