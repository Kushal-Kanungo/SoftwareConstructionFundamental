package com.sparse;

/**
 * 
 * @author Kushal
 * @since 22 Oct 2022 3:00 PM
 */
public class MatrixBlock implements Comparable<MatrixBlock> {
    private final int row;
    private final int col;
    private final int value;

    /**
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

    public int getRow() {
        return this.row;
    }

    public int getCol() {
        return this.col;
    }

    public int getValue() {
        return this.value;
    }

    /**
     * 
     * @return
     */
    public MatrixBlock transpose() {
        return new MatrixBlock(this.col, this.row, this.value);
    }

    /**
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
     * 
     * @param secBlock
     * @return
     */
    public MatrixBlock multiplyBlock(MatrixBlock secBlock){
        if(this.row==secBlock.col)
            return new MatrixBlock(this.row, this.col, this.value*secBlock.value);
        return null;
    }

    /**
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

    @Override
    public int compareTo(MatrixBlock block) {
        if (this.row != block.row)
            return this.row - block.row;
        return this.col - block.col;
    }
    
    
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
