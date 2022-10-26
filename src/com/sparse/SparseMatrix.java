package com.sparse;

import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *  class : "SparseMatrix"
 *  desc : This class represent a Sparse Matrix it stores only non zero elements and
 *  perform different in matrix.
 *  
 *  @author Kushal Kanungo
 *  @since 22 Oct 2022 11:00 AM
 */
public class SparseMatrix  {
    private final MatrixBlock[] matrixSparse;
    private final int matrixRows;
    private final int matrixCols;
    private final int totalElements;

    /**
     * 
     * Constructor it takes a Matrix and create Sparse Matrix by using non zero elements
     * Time Complexity : O(n*m) as we have to traverse the whole matrix
     *                 
     * 
     * @param userMatrix
     */
    public SparseMatrix(int[][] userMatrix) {
        this.totalElements = calcNonZeros(userMatrix);
        if (this.totalElements == 0)
        	throw new InvalidParameterException("Matrix Cannot Be Empty");
        
        this.matrixRows = userMatrix.length;
        this.matrixCols = userMatrix[0].length;
        MatrixBlock[] tempSparseMatrix = new MatrixBlock[totalElements];
        int idx = 0;
        for (int row = 0; row < userMatrix.length; row++) {
            for (int col = 0; col < userMatrix[0].length; col++) {
                if (userMatrix[row][col] != 0)
                    tempSparseMatrix[idx++] = new MatrixBlock(row, col, userMatrix[row][col]);
            }
        }
        
        
        this.matrixSparse = tempSparseMatrix;
    }


    /**
     * Contructor which directly takes the the array of MatrixBlock
     * TimeComplexity : O(n) as we have to save each block in our array
     * 
     * @param blockArray
     * @param row
     * @param col
     */
    private SparseMatrix(MatrixBlock[] blockArray, int row, int col){
        this.matrixSparse = blockArray;
        this.matrixRows = row;
        this.matrixCols = col;
        this.totalElements= blockArray.length;
    }

    
    /** 
     * Desc : This method is used to find the number of nonZero elements.
     * Time Complexity : O(n*m) : as we have to traverse whole matrix
     * 
     * @param userMatrix
     * @return int
     */
    private int calcNonZeros(int[][] userMatrix) {
        int tempNonZero = 0;
        for (int row = 0; row < userMatrix.length; row++) {
            for (int col = 0; col < userMatrix[0].length; col++) {
                if (userMatrix[row][col] != 0)
                    tempNonZero++;
            }
        }
        return tempNonZero;
    } 

    /** 
     * This method will return the value present at particular row and col in matrix
     * 
     * @param row
     * @param col
     * @return int
     */
    public int getValue(int row, int col){
        for (int idx = 0; idx < totalElements; idx++) {
            if(matrixSparse[idx].getRow()==row && matrixSparse[idx].getCol()==col)
                return matrixSparse[idx].getValue();
        }
        return 0;
    }


    /**
     * This method will swap the row and col of each {@link MatrixBlock}  return new {@link SparseMatrix}
     * Time Complexity : O(n) ->where n is nonZero elements of sparse matrix
     * 
     * @return SparseMatrix
     */
    public SparseMatrix transposeMatrix(){
        MatrixBlock[] transposed = new MatrixBlock[this.totalElements];
        int idx=0;
        for (MatrixBlock block : this.matrixSparse) 
            transposed[idx++] = block.transpose();
        Arrays.sort(transposed);
        return new SparseMatrix(transposed, this.matrixCols, this.matrixRows);
    }


    /**
     * This method is used to an ArrayList to primitive array by mapping each element
     * 
     * @param blocksList
     * @return
     */
    public static MatrixBlock[] convertToArray(List<MatrixBlock> blocksList){
        MatrixBlock[] blocksArray = new MatrixBlock[blocksList.size()];
        int idx = 0;
        for (MatrixBlock block : blocksList) {
            blocksArray[idx++] = block;
        }
        return blocksArray;
    }
    

    /**
     * For Symmetry we first check it is square matrix than transpose the matrix and check each block we it is equal.
     * 
     * @return boolean
     */
    public boolean isSymmetric(){
        if (this.matrixRows != this.matrixCols)
            return false;
        SparseMatrix transposed = this.transposeMatrix();
        for (int idx = 0; idx < matrixSparse.length; idx++) {
            if(!matrixSparse[idx].equals(transposed.matrixSparse[idx]))
                return false;
        }   
        return true;
    }

    /**
     * This funtion will add the value of block having same row and col and return new 
     * Sparse matrix.
     * Alogorithm used : Two Pointer to achieve linear time complexity.
     * Time Complexity : O(n) where n is max length b/w two sparse matrix.
     * 
     * @param secondMatrix
     * @return SparseMatrix
     */
    public SparseMatrix addMatrix(SparseMatrix secondMatrix){
    	if (this.matrixRows != secondMatrix.matrixRows || this.matrixCols != secondMatrix.matrixCols)
    		throw new InvalidParameterException("Two matrices with different dimension cannot be added");
    	
        int firstIdx = 0;
        int secondIdx = 0;
        List<MatrixBlock> newList = new ArrayList<MatrixBlock>();
        
        while (firstIdx<this.totalElements && secondIdx<secondMatrix.totalElements){
            MatrixBlock firstBlock = this.matrixSparse[firstIdx];
            MatrixBlock secondBlock = secondMatrix.matrixSparse[secondIdx];
            if (firstBlock.hasSamePostion(secondBlock)) {
                newList.add(firstBlock.addBlock(secondBlock));
                firstIdx++;
                secondIdx++;
            }
            else if(firstBlock.isBeforeThan(secondBlock)){
                newList.add(firstBlock);
                firstIdx++;
            }
            else{
                newList.add(secondBlock);
                secondIdx++;
            }
        }
        for ( ; firstIdx < this.totalElements; firstIdx++) 
            newList.add(matrixSparse[firstIdx]);
        for ( ; secondIdx < secondMatrix.totalElements; secondIdx++) 
            newList.add(secondMatrix.matrixSparse[secondIdx]);
        return new SparseMatrix(convertToArray(newList), matrixRows, matrixCols);
    }

    /**
     * Desc : This method multiply the two sparse matrix and return the new Matrix having 
     * Time Complexity = O(m*n) : where m = non elements in first matrix and n = non zero elements in second matrix
     * 
     * @param secondMatrix
     * @return SparseMatrix
     */
    public SparseMatrix multiplyWith(SparseMatrix secondMatrix){

            if (this.matrixRows!=secondMatrix.matrixCols)
                throw new InvalidParameterException("Cannot Multiply These Two Matrices");
        
            secondMatrix = secondMatrix.transposeMatrix();
            int[][] newMatrix = new int[this.matrixRows][ secondMatrix.matrixCols];
            
            for (MatrixBlock firstBlock : this.matrixSparse) {
                for (MatrixBlock secondBlock : secondMatrix.matrixSparse) {
                    if(firstBlock.getCol()==secondBlock.getCol()){
                        int value = firstBlock.getValue()*secondBlock.getValue();
                        newMatrix[firstBlock.getRow()][secondBlock.getRow()]+=value;
                    }
                }
            }
            return new SparseMatrix(newMatrix);
    }

    public int[][] getInMatrixForm(){
    	int[][] result = new int[matrixRows][matrixCols];
    	 int idx = 0;
         for (int row = 0; row < matrixRows; row++) {
             for (int col = 0; col < matrixCols; col++) {
                 if (idx < totalElements && matrixSparse[idx].getRow() == row && matrixSparse[idx].getCol() == col)
                      result[row][col] = matrixSparse[idx++].getValue();
                 else
                     result[row][col] = 0;
             }
         }
         return result;
    }
    
    @Override
    public String toString() {
            String result = "";
            int idx = 0;
            for (int row = 0; row < matrixRows; row++) {
                for (int col = 0; col < matrixCols; col++) {
                    if (idx < totalElements && matrixSparse[idx].getRow() == row && matrixSparse[idx].getCol() == col)
                        result += matrixSparse[idx++].getValue() + " ";
                    else
                        result+= 0+" ";
                }
                result+="\n";
            }
            return result;
    }
}
