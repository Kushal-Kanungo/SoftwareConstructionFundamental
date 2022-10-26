package intset;

import static org.junit.jupiter.api.Assertions.*;

import java.security.InvalidParameterException;
import java.util.ArrayList;

import org.junit.jupiter.api.Test;

class TestEmpty {

	@Test
	void testEmpty() {
		
		assertThrows(InvalidParameterException.class,  ()-> {
			InSetClass newSet  = new InSetClass(new ArrayList<Integer>());
			newSet.getSize();
		});
	}

}
