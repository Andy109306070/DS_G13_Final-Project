

import java.io.IOException;
import java.util.ArrayList;

public class Webpage {
	public String url;
	public String name;
	public WordCounter counter;
	public double score;
	
	public Webpage(String url,String name){
		this.url = url;
		this.name = name;
		this.counter = new WordCounter(url);	
	}
	
	public void setScore(ArrayList<Keyword> keywords) throws IOException{
		score = 0;
		for(Keyword k : keywords){	
			score +=k.getWeight() *  counter.countKeyword(k.getName());
		}
	}
	public double getScore() {
		return score;
	}
	public String getUrl() {
		return url;
	}
	public String getName() {
		return name;
	}
	
}
