package fileSystem;
import fileKinds.Directory;
import fileKinds.File;

public class FSClient {
   public static void main( java.lang.String[] args ) {
      IFile d = new Directory("dir1");
      File  f = new File("a");
      d.add(f);
	  System.out.println(f.ls());
	  System.out.println(d.ls());
   }
}