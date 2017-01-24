package fileKinds;

import fileSystem.IFile;

public class File implements IFile {
   public File( String name ) { this.name = name; }
   public String display(String path){ return path+name; }
   public String ls() { return display(""); }
   private String name;
	@Override
	public void add(IFile f) throws UnsupportedOperationException {throw new UnsupportedOperationException();}
}