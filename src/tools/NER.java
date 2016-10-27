package tools;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Set;
import java.util.TreeSet;

public class NER {
	String _fileName;
	Set<String> _dict;
	
	public NER(String iFileName) throws IOException {
		_fileName = iFileName;
		_dict = new TreeSet<String>();
		PopulateSet();
	}
	
	private void PopulateSet() throws IOException {
		try (BufferedReader br = new BufferedReader(new FileReader(_fileName))) {
		    String line;
		    while ((line = br.readLine()) != null) {
		       _dict.add(line);
		    }
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public Set<String> getNERSet() {
		return _dict;
	}
}
