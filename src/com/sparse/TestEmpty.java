package com.sparse;

import static org.junit.jupiter.api.Assertions.*;

import java.security.InvalidParameterException;

import org.junit.jupiter.api.Test;

class TestEmpty {

	@Test
	void test() {
		assertThrows(InvalidParameterException.class, ()->{
			SparseMatrix matrix  = new SparseMatrix(new int[][] {{0,0}, {0, 0}});
			matrix.getInMatrixForm();
		});
	}

}
