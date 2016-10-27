package tools;

import java.io.IOException;
import java.text.BreakIterator;
import java.util.ArrayList;
import java.util.Locale;

import dataModels.Sentence;
import dataModels.Token;

public class TextParser {
	
	public ArrayList<Sentence> SentenceSeparator(String iText) {
		BreakIterator bi = BreakIterator.getSentenceInstance(Locale.US);
		ArrayList<Sentence> sentences = new ArrayList<Sentence>();
        bi.setText(iText);

        int lastIndex = bi.first();
        while (lastIndex != BreakIterator.DONE) {
            int firstIndex = lastIndex;
            lastIndex = bi.next();

            if (lastIndex != BreakIterator.DONE) {
            	Sentence newSentence = new Sentence(firstIndex, lastIndex - 1);
                String sentenceText = iText.substring(firstIndex, lastIndex);
                newSentence.setText(sentenceText);
                newSentence.addWords(TokenCreator(sentenceText, firstIndex));
                sentences.add(newSentence);
            }
        }
		return sentences;
	}
	
	ArrayList<Token> TokenCreator(String iSentenceText, int iPosOffset) {
		ArrayList<Token> tokens = new ArrayList<Token>();
		BreakIterator bi = BreakIterator.getWordInstance(Locale.US);
		bi.setText(iSentenceText);;
		
		int lastIndex = bi.first();
		while (lastIndex != BreakIterator.DONE) {
            int firstIndex = lastIndex;
            lastIndex = bi.next();

            if (lastIndex != BreakIterator.DONE) {
            	Token newToken = new Token(iSentenceText.substring(firstIndex, lastIndex), firstIndex + iPosOffset, lastIndex + iPosOffset - 1);
            	tokens.add(newToken);
            }
		}
		return tokens;
	}
	
	public void FindNERS(Sentence iSentence) throws IOException {
		NER ner = new NER("NER.txt");
		iSentence.findNER(ner.getNERSet());
	}
}
