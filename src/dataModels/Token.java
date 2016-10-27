package dataModels;

import javax.xml.bind.annotation.XmlElement;

public class Token {
	private int _id;
	private String _word;
	
	public Token(int iID, String iWord) {
		_id = iID;
		_word = iWord;
	}
	
	@XmlElement
	public String getWord() {
		return _word;
	}
	
	@XmlElement
	public int getID() {
		return _id;
	}
}
