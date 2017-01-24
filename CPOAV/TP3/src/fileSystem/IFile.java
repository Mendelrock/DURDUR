package fileSystem;

public interface IFile {

	void add(IFile f);
	
	String display(String path);

	String ls();

}