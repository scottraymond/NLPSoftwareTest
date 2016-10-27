package dataModels;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import dataModels.Token;


public class Sentence {
	private int _id;
	private int _beginPos;
	private int _endPos;
	private ArrayList<Token> _words;
	
	public Sentence(){
		_id=0;
		_beginPos=0;
		_endPos=0;
	}
	
	public Sentence(int iID, int iBeginPos, int iEndPos) {
		_id = iID;
		_beginPos = iBeginPos;
		_endPos = iEndPos;
	}
	
	public void addWords(ArrayList<Token> iWordTokens) {
		_words = iWordTokens;
	}
	
	@XmlElement
	public ArrayList<Token> getTokens(){
		return _words;
	}
	
	public Token getToken(int i) {
		return _words.get(i);
	}
	
	public int getCount() {
		return _words.size();
	}
	
	@XmlElement
	public int getID() {
		return _id;
	}
	
	@XmlElement
	public int getBeginPos() {
		return _beginPos;
	}
	
	@XmlElement
	public int getEndPos() {
		return _endPos;
	}
}
