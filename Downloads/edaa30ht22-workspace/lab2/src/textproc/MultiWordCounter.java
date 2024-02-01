package textproc;

import java.util.HashMap;
import java.util.Map;

public class MultiWordCounter implements TextProcessor {
	private Map<String, Integer> list = new HashMap<>();
	
	public MultiWordCounter(String[] w) {
		for(String s : w) {
			list.put(s, 0);
		}
		
	}

	public void process(String s) {
		if(list.containsKey(s)) {
			list.put(s, list.get(s) + 1);
		}
		
		
	}

	@Override
	public void report() {
		list.forEach((k,v) -> System.out.println(k +" "+ v));
		
	}

}
