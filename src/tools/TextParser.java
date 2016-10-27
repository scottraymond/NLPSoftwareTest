package tools;

import java.lang.Object;
import java.text.BreakIterator;
import java.util.ArrayList;
import java.util.Locale;

import dataModels.Token;
import dataModels.Sentence;

public class TextParser {
	
	public ArrayList<Sentence> SentenceSeparator(String iText) {
		BreakIterator bi = BreakIterator.getSentenceInstance(Locale.US);
		ArrayList<Sentence> sentences = new ArrayList<Sentence>();
        bi.setText(iText);

        int lastIndex = bi.first();
        int id = 1;
        while (lastIndex != BreakIterator.DONE) {
            int firstIndex = lastIndex;
            lastIndex = bi.next();

            if (lastIndex != BreakIterator.DONE) {
            	Sentence newSentence = new Sentence(id++, firstIndex, lastIndex);
                String sentenceText = iText.substring(firstIndex, lastIndex);
                newSentence.addWords(TokenCreator(sentenceText));
                sentences.add(newSentence);
            }
        }
		return sentences;
	}
	
	ArrayList<Token> TokenCreator(String iSentenceText) {
		ArrayList<Token> tokens = new ArrayList<Token>();
		BreakIterator bi = BreakIterator.getWordInstance(Locale.US);
		bi.setText(iSentenceText);;
		
		int lastIndex = bi.first();
		int id = 1;
		while (lastIndex != BreakIterator.DONE) {
            int firstIndex = lastIndex;
            lastIndex = bi.next();

            if (lastIndex != BreakIterator.DONE) {
            	Token newToken = new Token(id++, iSentenceText.substring(firstIndex, lastIndex));
            	tokens.add(newToken);
            }
		}
		return tokens;
	}
}
