package fileKinds;

import java.util.ArrayList;
import java.util.List;

import fileSystem.IFile;

public class Directory implements IFile {
	public Directory( String name ) { this.name = name; }
	   /* (non-Javadoc)
	 * @see fileKinds.IFile#add(fileKinds.File)
	 */
	@Override
	public void add( IFile f ) { files.add( f ); }
	public void add( Directory d ) { directories.add( d ); }
	 
	@Override
	public String display(String path) {
			  String s = path + name + "\n";
		      String npath = path + name +"/";
		      for(IFile f: files)
		         s += f.display(npath)+"\n";
		      for(IFile d: directories)
		         s += d.display(npath)+"\n";
		      return s;
	   }
	   /* (non-Javadoc)
	 * @see fileKinds.IFile#ls()
	 */
	
	@Override
	public String ls(){ return display(""); }
	private String name;
	private List<IFile> files = new ArrayList<IFile>();
	private List<IFile> directories = new ArrayList<IFile>();
}