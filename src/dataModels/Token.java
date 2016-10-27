package dataModels;

import javax.xml.bind.annotation.XmlElement;

public class Token {
	private int _beginPos;
	private int _endPos;
	private String _word;
	private Boolean _namedEntity = false;
	
	public Token(String iWord, int iBeginPos, int iEndPos) {
		_word = iWord;
		_beginPos = iBeginPos;
		_endPos = iEndPos;
	}
	
	@XmlElement
	public String getWord() {
		return _word;
	}
	
	@XmlElement
	public int getBeginPos() {
		return _beginPos;
	}
	
	@XmlElement
	public int getEndPos() {
		return _endPos;
	}
	
	@XmlElement
	public Boolean getNamedEntity() {
		return _namedEntity;
	}
	
	public void setNamedEntityTrue() {
		_namedEntity=true;
	}
}
