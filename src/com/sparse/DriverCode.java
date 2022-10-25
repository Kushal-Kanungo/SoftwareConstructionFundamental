package com.sparse;

public class DriverCode {
    public static void main(String[] args) {
        SparseMatrix spm = new SparseMatrix(new int[][]{
            {2,3,6},
            {3,4,5},
            {6,5,9}
            }
            );
        System.out.print(spm);
        System.out.print("\nTransposed \n");
        System.out.println(spm.transposeMatrix());

        System.out.println(spm.isSymmetric());
    }
    
}

