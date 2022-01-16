
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Webpage {
	public String url;
	public String name;
	public WordCounter counter;
	public double score;

	public Webpage(String url, String name) {
		this.url = url;
		this.name = name;
		this.counter = new WordCounter(url);
	}

	public void setScore(ArrayList<Keyword> keywords) throws IOException {
		score = 0;
		for (Keyword k : keywords) {
			score += k.getWeight() * counter.countKeyword(k.getName());
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
