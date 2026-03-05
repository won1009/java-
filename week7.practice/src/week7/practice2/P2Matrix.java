package week7.practice2;

import week7.practice.P1IntegerList;

/**
 * Matrix 클래스를 구현
 * P1IntegerList를 사용하여 2차원 행렬을 관리
 * 각 행은 P1IntegerList의 인스턴스(생성된 객체)로 관리
 */

public class P2Matrix {
    private P1IntegerList[] rows; // 행렬의 각 행을 관리하는 선형 리스트

    /**
     * 주어진 2차원 배열 데이터를 받아 행렬을 초기화하는 생성자를 구현
     * @param data 이 행렬을 초기화하는 데 사용되는 2차원 배열
     * 
     * TODO:
     * 1. data 배열의 각 행에 대해 반복
     * 2. 각 행을 P1IntegerList 객체로 변환하여 rows 배열에 추가
     */
    public P2Matrix(int[][] data) {
        rows = new P1IntegerList[data.length];
        // 데이터를 반복하여 행을 채움
        for (int i = 0; i < data.length; i++) {
            rows[i] = new P1IntegerList(); // 각 행마다 새로운 정수 리스트를 생성
            for (int value : data[i]) {  // 현재 데이터 행의 각 요소를 반복
                rows[i].append(value); // 현재 행의 정수 리스트에 값을 추가
            }
        }
    }

    /**
     * 현재 행렬과 다른 행렬을 더하여 새로운 행렬을 반환하는 메서드를 구현
     * @param other 더해질 다른 Matrix 객체
     * 
     * TODO:
     * 1. 두 행렬의 행 수가 동일한지 검사
     * 2. 두 행렬의 각 행의 길이가 일치하는지 확인
     * 3. 두 행렬의 각 원소를 더하여 결과 행렬을 생성
     */
    public P2Matrix addMatrix(P2Matrix other) {
        if(this.rows.length != other.rows.length) {
            System.out.println("행의 개수가 다릅니다");
            return null; // 완성 후 제거
        }
        
        int[][] resultData = new int[rows.length][rows[0].length()];
        for (int i = 0; i < this.rows.length; i++) {
            if (this.rows[i].length() != other.rows[i].length()) {
                System.out.println("열의 개수가 다릅니다.");
                return null;
            } else {
                for (int j = 0; j < this.rows[i].length(); j++) {
                    resultData[i][j] = this.rows[i].get(j) + other.rows[i].get(j);
                }
            }
        }
        return new P2Matrix(resultData);
    }

    /**
     * 현재 행렬과 다른 행렬을 곱하여 새로운 행렬을 반환하는 메서드를 구현
     * @param other 곱해질 다른 Matrix 객체
     * 
     * TODO:
     * 1. 첫 번째 행렬의 열 수와 두 번째 행렬의 행 수가 일치하는지 검사
     * 2. 곱셈 결과에 해당하는 새로운 행렬을 생성
     * 3. 곱셈 연산을 수행하여 결과 행렬의 각 원소 값을 계산
     */
    public P2Matrix mulMatrix(P2Matrix other) {
        if (this.rows[0].length() != other.rows.length) {
            System.out.println("첫 번째 행렬의 열 수와 두 번째 행렬의 행 수가 일치하지 않습니다.");
            return null;
        }
        
        int[][] resultData = new int[this.rows.length][other.rows[0].length()]; // 곱셈 결과에 해당하는 행렬 생성
        
        for (int i = 0; i < this.rows.length; i++) { // 첫 번째 행렬의 행 수만큼 반복
            for (int j = 0; j < other.rows[0].length(); j++) { // 두 번째 행렬의 열 수만큼 반복
                int sum = 0;
                for (int k = 0; k < this.rows[i].length(); k++) { // 첫 번째 행렬의 열 수만큼 반복
                    sum += this.rows[i].get(k) * other.rows[k].get(j); // 곱셈 연산 수행
                }
                resultData[i][j] = sum; // 결과 행렬에 값 할당
            }
        }
        
        return new P2Matrix(resultData); // 결과 행렬 반환
    }

    /**
     * 행렬의 모든 원소를 출력하는 메서드를 구현
     * 
     * TODO:
     * 1. 행렬의 각 행을 순회
     * 2. 각 행의 각 원소를 출력
     */
    public void print() {
        for (int i = 0; i < this.rows.length; i++) { // 각 행을 순회
            for (int j = 0; j < this.rows[i].length(); j++) { // 각 행의 원소를 순회
                System.out.print(this.rows[i].get(j) + " "); // 각 원소 출력
            }
            System.out.println(); // 행을 모두 출력한 후 줄 바꿈
        }
    }
}
