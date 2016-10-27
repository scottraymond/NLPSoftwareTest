package dataModels;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import javax.xml.bind.annotation.XmlElement;

public class Sentence {
	private String _text;
	private int _beginPos;
	private int _endPos;
	private ArrayList<Token> _words;
	private Set<String> _foundNers;
	
	public Sentence(){
		_beginPos=0;
		_endPos=0;
	}
	
	public Sentence(int iBeginPos, int iEndPos) {
		_beginPos = iBeginPos;
		_endPos = iEndPos;
		_foundNers = new HashSet<String>();
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
	
	public void setText(String iText) {
		_text = iText;
	}
	
	@XmlElement
	public String getText() {
		return _text;
	}
	
	@XmlElement
	public int getBeginPos() {
		return _beginPos;
	}
	
	@XmlElement
	public int getEndPos() {
		return _endPos;
	}

	public Set<String> getFoundNers(){
		return _foundNers;
	}
	
	public void findNER(Set<String> iNERSet) {
		for(String temp : iNERSet) {
			Boolean tokenFound = false;
			int index = _text.indexOf(temp);
			if(index > -1) {
				int i = 0, curPos = _beginPos;
				int startPos = index + _beginPos;
				int endPos = index+_beginPos+temp.length()-1;
				while(curPos<startPos){
					curPos=_words.get(++i).getBeginPos();
				}
				if(curPos != _words.get(i).getBeginPos()) {
					continue;
				}
				int j = i;
				while(curPos<endPos){
					curPos=_words.get(j++).getBeginPos();
				}
				if(_words.get(j-2).getEndPos() != endPos){
					continue;
				}
				else{
					while(i<=j-2){
						_words.get(i++).setNamedEntityTrue();
						tokenFound=true;
					}
				}
			}
			if(tokenFound) {
				_foundNers.add(temp);
			}
		}
	}
}
