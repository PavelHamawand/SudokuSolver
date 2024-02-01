package textproc;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Holgersson {

	public static final String[] REGIONS = { "blekinge", "bohuslän", "dalarna", "dalsland", "gotland", "gästrikland",
			"halland", "hälsingland", "härjedalen", "jämtland", "lappland", "medelpad", "närke", "skåne", "småland",
			"södermanland", "uppland", "värmland", "västerbotten", "västergötland", "västmanland", "ångermanland",
			"öland", "östergötland" };

	public static void main(String[] args) throws FileNotFoundException {
		long t0 = System.nanoTime();
		ArrayList<TextProcessor> lista = new ArrayList<TextProcessor>();
		lista.add(new SingleWordCounter("nils"));
		lista.add(new SingleWordCounter("norge"));
		lista.add(new MultiWordCounter(REGIONS));
				
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
		lista.add(new GeneralWordCounter(stopWords));

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
		
		long t1 = System.nanoTime();
		System.out.println();
		System.out.println("tid: " + (t1-t0) / 1000000 + " ms");
		
	}
	
}