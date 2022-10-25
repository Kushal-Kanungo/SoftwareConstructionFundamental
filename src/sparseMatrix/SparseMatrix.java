package sparseMatrix;

public class SparseMatrix {
    private final int[][] matrix;
    private final int totalElements;

    
    public SparseMatrix(int[][] userMatrix) {
        totalElements = calculateNonEmpty(userMatrix);
        matrix = new int[this.totalElements][3];
        int matrixIdx = 0;
        for (int row = 0; row < userMatrix.length; row++) {
            for (int col = 0; col < userMatrix[0].length; col++) {
                matrix[matrixIdx] = new int[]{row, col, userMatrix[row][col]};
            }
        }
    }

    private int calculateNonEmpty(int[][] userMatrix) {
        int size = 0;
        for (int row = 0; row < userMatrix.length; row++) {
            for (int col = 0; col < userMatrix[0].length; col++) {
                if (userMatrix[row][col]!=0)
                    size++;        
            }
        }
        return size;
    }

    public static void main(String[] args) {
        System.out.println("Hello World");
    }

}
