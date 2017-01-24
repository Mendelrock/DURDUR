package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import fileKinds.File;

public class FileTest {

	@Test
	public void test() {
		String filename = "monFichier.txt";
		File f = new File(filename);
		assertEquals(filename, f.ls());
		String path = "/";
		assertEquals(path+filename, f.display(path));
		path="a/b/";
		assertEquals(path+filename, f.display(path));
	}
	
	@Test(expected=UnsupportedOperationException.class)
	public void testerAdd() {
		String filename = "monFichier.txt";
		File f = new File(filename);
		String filename1 = "autreFichier.txt";
		File f1 = new File(filename1);
		f.add(f1);
	}

}
