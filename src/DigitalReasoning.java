import java.io.File;
import java.io.FileWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import javax.xml.bind.JAXB;

import tools.TextParser;
import dataModels.InputFile;
import dataModels.Sentence;

public class DigitalReasoning {
	
	static void Print(InputFile iInputFile, File iFile) throws Exception{
		JAXB.marshal(iInputFile, iFile);
	}

	public static void main(String[] args) throws Exception {
		
		InputFile inputFile = new InputFile();
		inputFile.setFileName("nlp_data.txt");
		String text = new String(Files.readAllBytes(Paths.get(inputFile.getFileName())), StandardCharsets.UTF_8);
		TextParser parser = new TextParser();
		inputFile.setSentences(parser.SentenceSeparator(text));
		File file = new File("logs/NLP_data.xml");
		ArrayList<Sentence> sentences = inputFile.getSentences();
		Set<String> ners = new HashSet<String> ();
		for(Sentence temp : sentences){
			parser.FindNERS(temp);
			ners.addAll(temp.getFoundNers());
		}
		FileWriter writer = new FileWriter("logs/output.txt"); 
		for(String str: ners) {
		  writer.write(str);
		}
		writer.close();
		Print(inputFile, file);

		}
}



