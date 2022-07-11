import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main009_DNA비밀번호 {

    static int checkArr[]; // 비밀번호를 체크하기 위한 배열
    static int myArr[]; // 현재 상태 배열
    static int checkSecret; // 관련된 개수를 충족했는지 판단하는 변수

    public static void main(String[] args) throws IOException {

        /*
         * 주어진 문자열 A C G T가 있다. 이를 DNA코드라고 하자.
         * 이 DNA의 글자가 최소 몇 개 포함되는지 결정한 후
         * 주어진 문자열에 해당 글자 수 조건이 포함되는 문자가 몇 개나 되는지 
         * 예를 들어서 GATA 글자에서 A가 1개 T가 1개 들어가는 조건은 2개이다.
        */

        /*
         * 전략: 슬라이딩 윈도우
         * 
         * 문자열 조건을 담은 문자열 배열을 슬라이딩 윈도우라고 한다. 
         * 슬라이딩 윈도우를 한 칸씩 올리면서 모든 배열을 체크한다.
         * 
        */

        // 데이터 저장
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        // 변수 선언
        int S = Integer.parseInt(st.nextToken()); // 문자열의 크기
        int P = Integer.parseInt(st.nextToken()); // 부분 문자열의 크기
        int Result = 0; // 결과  = 몇 개의 DNA범위 값이 유효한가
        char A[] = new char[S]; // 문자열 데이터
        checkArr = new int[4]; // 체크용 배열 세팅
        myArr = new int[4]; // 현재 상태 배열
        checkSecret = 0;// 몇 개의 문자와 관련된 개수를 충족했는지 판단하는 변수
        A = bf.readLine().toCharArray(); // 받은 데이터를 심어줌
        st = new StringTokenizer(bf.readLine());
        System.out.println(st);
        // 
        for (int i = 0; i < 4; i++) {
            checkArr[i] = Integer.parseInt(st.nextToken());
            System.out.println(checkArr[i]);
            if(checkArr[i] == 0) checkSecret++;
        }



        // P 범위(0~P-1)만큼 S배열에 적용하고, 유효한 비밀번호인지 판단하기

        // 반복

        // 출력

        
    }

    // 더하기 함수

    // 빼기 함수
}