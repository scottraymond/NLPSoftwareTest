package dataModels;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class InputFile {
	private String _fileName;
	private ArrayList<Sentence> _sentences;
	
	@XmlElement
	public String getFileName(){
		return _fileName;
	}
	
	public void setFileName(String iFileName) {
		_fileName = iFileName;
	}
	
	@XmlElement
	public ArrayList<Sentence> getSentences(){
		return _sentences;
	}
	
	public void setSentences(ArrayList<Sentence> iSentences) {
		_sentences = iSentences;
	}
	
	
}
