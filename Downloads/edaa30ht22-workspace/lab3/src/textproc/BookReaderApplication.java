package textproc;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.io.File;
import java.io.FileNotFoundException;


public class BookReaderApplication {

	public static void main(String[] args) throws FileNotFoundException {
		ArrayList<TextProcessor> lista = new ArrayList<TextProcessor>();
				
		Set<String> stopWords = new HashSet<String>();
		
		Scanner s = new Scanner(new File("nilsholg.txt"));
		s.findWithinHorizon("\uFEFF", 1);
		s.useDelimiter("(\\s|,|\\.|:|;|!|\\?|'|\\\")+"); // se handledning

		Scanner scan = new Scanner(new File("undantagsord.txt"));
		scan.findWithinHorizon("\uFEFF", 1);
		scan.useDelimiter("(\\s|,|\\.|:|;|!|\\?|'|\\\")+"); // se handledning

		while (scan.hasNext()) {
			String word = scan.next().toLowerCase();
			stopWords.add(word);
		}
		scan.close();
		GeneralWordCounter wc = new GeneralWordCounter(stopWords);
		
		lista.add(wc);
		

		while (s.hasNext()) {
			String word = s.next().toLowerCase();
			for (TextProcessor p : lista) {
				p.process(word);
			}
		}

		   s.close();
		   
		for (TextProcessor p : lista) {
			p.report();
		}
		
		BookReaderController gui = new BookReaderController(wc);
		
		
	}
	}


