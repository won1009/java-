package week7.practice2;


public class P2Test {
    public static void main(String[] args) {
        int[][] data1 = {{1, 2, 3}, {4, 5, 6}};      
        int[][] data2 = {{1, 4}, {2, 5}, {3, 6}};
        int[][] data3 = {{1, 4, 7}, {2, 5, 8}, {3, 6, 9}};       
        
        P2MatrixFull m1 = new P2MatrixFull(data1);
        P2MatrixFull m2 = new P2MatrixFull(data2);
        P2MatrixFull m3 = new P2MatrixFull(data3);

        System.out.println("Matrix 1:");
        m1.print();

        System.out.println("Matrix 2:");
        m2.print();
        
        System.out.println("Matrix 3:");
        m3.print();
              
        System.out.println("Matrix 2 + Matrix 2:");
        m2.addMatrix(m2).print();
          
        System.out.println("Matrix 1 * Matrix 3:");
        m1.mulMatrix(m3).print();
    }
}
