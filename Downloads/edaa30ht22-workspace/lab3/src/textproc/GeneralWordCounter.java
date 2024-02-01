package textproc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class GeneralWordCounter implements TextProcessor {
    private Set<String> stopWords; // En uppsättning stoppord att ignorera
    private Map<String, Integer> list = new TreeMap<String, Integer>(); // En karta för att lagra frekvensen av ord

    public GeneralWordCounter(Set<String> stopWords) {
        this.stopWords = stopWords;
    }

    @Override
    public void process(String w) {
        // Bearbeta ett ord, uppdatera dess frekvens i kartan om det inte är ett stoppord
        if (!stopWords.contains(w)) {
            if (!list.containsKey(w)) {
                list.put(w, 1);
            } else {
                list.put(w, list.get(w) + 1);
            }
        }
    }

    @Override
    public void report() {
        // Sortera ordfrekvenserna och skriv ut de 15 mest frekventa orden
        Set<Map.Entry<String, Integer>> wordSet = list.entrySet();
        List<Map.Entry<String, Integer>> wordList = new ArrayList<>(wordSet);

        wordList.sort((w1, w2) -> {
            if (w2.getValue() - w1.getValue() == 0) {
                return w1.getKey().compareTo(w2.getKey());
            }
            return w2.getValue() - w1.getValue();
        });

        for (int i = 0; i < 15 && i < wordList.size(); i++) {
            System.out.println(wordList.get(i));
        }
    }

    public List<Map.Entry<String, Integer>> getWordList() {
        // Returnera en lista av ordfrekvenser efter att ha filtrerat bort ord som börjar med siffror
        Set<Map.Entry<String, Integer>> wordSet = list.entrySet();
        List<Map.Entry<String, Integer>> wordList = new ArrayList<>(wordSet);
        wordList.removeIf(entry -> Character.isDigit(entry.getKey().charAt(0)));
        return wordList;
    }
}

