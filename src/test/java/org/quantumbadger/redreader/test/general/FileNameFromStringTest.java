package org.quantumbadger.redreader.test.general;


import org.junit.Test;
import org.quantumbadger.redreader.common.General;

import static org.junit.Assert.assertEquals;

public class FileNameFromStringTest {

	@Test(expected = StringIndexOutOfBoundsException.class)
	public void testEmtpyString(){
		String result = General.filenameFromString("");
		assertEquals(result, "");
	}

	@Test
	public void testJPGFile(){
		String result = General.filenameFromString("fake_filename.jpg");
		assertEquals(result, "fake_filename.jpg");
	}
}
