package com.sparse;

/**
 * class : "MatrixBlock"
 * This class stores row, col, val of a sparse matrix and their actions 
 * 
 * @author Kushal
 * @since 22 Oct 2022 3:00 PM
 */
public class MatrixBlock implements Comparable<MatrixBlock> {
    private final int row;
    private final int col;
    private final int value;

    /**
     * Constructor to initialize the object of this class 
     * 
     * @param row
     * @param col
     * @param value
     */
    public MatrixBlock(int row, int col, int value) {
        this.row = row;
        this.col = col;
        this.value = value;
    }

    /**
     * Getter for row
     * @return
     */
    public int getRow() {
        return this.row;
    }

    /**
     * Getter for column
     * @return
     */
    public int getCol() {
        return this.col;
    }

    /**
     * Getter for value
     * @return
     */
    public int getValue() {
        return this.value;
    }

    /**
     * To transpose we are swapping the rows and columns
     * 
     * @return
     */
    public MatrixBlock transpose() {
        return new MatrixBlock(this.col, this.row, this.value);
    }

    /**
     * To add two block we check row and column and when they are same we add it and return new object
     * 
     * @param secondBlock
     * @return
     */
    public MatrixBlock addBlock(MatrixBlock secondBlock) {
        if (this.row == secondBlock.getRow() && this.col == secondBlock.getCol())
            return new MatrixBlock(this.row, this.col, this.value + secondBlock.getValue());
        return null;
    }

    /**
     * To multiply the block we check if row and col are same and then multiply the value
     * 
     * @param secBlock
     * @return
     */
    public MatrixBlock multiplyBlock(MatrixBlock secBlock){
        if(this.row==secBlock.col)
            return new MatrixBlock(this.row, this.col, this.value*secBlock.value);
        return null;
    }
    
    public boolean hasSamePostion(MatrixBlock secBlock) {
    	if (this.row == secBlock.row && this.col == secBlock.col)
    		return true;
    	return false;
    }

    /**
     * It checks which block comes before so that we can use two pointer for linear time.
     * 
     * @param secondBlock
     * @return
     */
    public boolean isBeforeThan(MatrixBlock secondBlock){
        if(this.row > secondBlock.row)
            return false;
        if(this.row < secondBlock.row)
            return true;
        return this.col < secondBlock.col;
    }

    
    /**
     * We are overriding this function so that we can use sorting in these blocks 
     * 
     * @param block
     * 
     */
    @Override
    public int compareTo(MatrixBlock block) {
        if (this.row != block.row)
            return this.row - block.row;
        return this.col - block.col;
    }
    
    
    /**
     * This function will check equality between two object of MatrixBlock class.
     * @param o
     * 
     */
    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof MatrixBlock)) {
            return false;
        }
        MatrixBlock matrixBlock = (MatrixBlock) o;
        return row == matrixBlock.row && col == matrixBlock.col && value == matrixBlock.value;
    }
 
}
