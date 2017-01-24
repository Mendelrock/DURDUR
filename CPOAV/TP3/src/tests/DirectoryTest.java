package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import fileKinds.Directory;
import fileKinds.File;
import fileSystem.IFile;

public class DirectoryTest {

	@Test
	public void test() {
		String dirname = "dir";
		IFile d = new Directory(dirname);
		assertEquals(dirname+"\n", d.ls());
		String path = "/";
		assertEquals(path+dirname+"\n", d.display(path));
		path="a/b/";
		assertEquals(path+dirname+"\n", d.display(path));
		String filename = "monFichier.txt";
		File f = new File(filename);
		d.add(f);
		System.out.println(d.ls());
		assertEquals(d.ls(),dirname+"\n"
				+dirname+"/"+filename+"\n");
	}

}
