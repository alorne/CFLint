package com.cflint.integration;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.junit.Test;

import com.cflint.main.CFLintMain;

public class TestIntegrationFolder {

	@Test
	public void testFolder() throws Exception{
		CFLintMain.main(
				new String[]{
				"--folder",
				"src\\test\\resources\\com\\cflint\\integration",
				"--json",
				"--jsonfile",
				"src\\test\\resources\\com\\cflint\\integration\\output.json"
				});
        final String expected = loadFile(new File("src\\test\\resources\\com\\cflint\\integration\\output.expected.json"));
        final String actual = loadFile(new File("src\\test\\resources\\com\\cflint\\integration\\output.json"));
        assertEquals( 
                expected.replaceAll("\\\\","/").replaceAll("/+","/").replaceAll("\r\n", "\n"),
                actual.replaceAll("\\\\","/").replaceAll("/+","/").replaceAll("\r\n", "\n"));

	}
	
	   public static String loadFile(File file) throws IOException {
	        InputStream is = new FileInputStream(file);
	        byte[] b = new byte[is.available()];
	        is.read(b);
	        is.close();
	        return new String(b);
	    }
}