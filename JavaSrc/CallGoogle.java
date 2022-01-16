
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.HashMap;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class CallGoogle {
	public String searchKeyword;
	public String url;
	public String content;

	public CallGoogle(String searchKeyword) {
		this.searchKeyword = searchKeyword;

		// Encode Chinese keyword to UTF-8 for request URL
		// And get 20 results from Google with modified keyword
		try {

			this.url = "http://www.google.com/search?q="
					+ java.net.URLEncoder.encode(searchKeyword + " ·L³n -ÁÊª« -©ç½æ -ÁÊ¶R", "UTF-8") + "&oe=utf8&num=20";
//			System.out.print(url);
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
		}
	}

	private String fetchContent() throws IOException {
		String retVal = "";

		URL u = new URL(url);
		URLConnection conn = u.openConnection();
		conn.setRequestProperty("User-agent", "Chrome/7.0.517.44");

		InputStream in = conn.getInputStream();
		InputStreamReader inReader = new InputStreamReader(in, "utf-8");

		BufferedReader bufReader = new BufferedReader(inReader);
		String line = null;
		while ((line = bufReader.readLine()) != null) {
			retVal += line;
		}
		
		in.close();
		inReader.close();
		bufReader.close();
		
		return retVal;
	}

	public ArrayList<Webpage> query() throws IOException {
		Sort sort = new Sort();

		if (content == null) {
			content = fetchContent();
		}

//		HashMap<String, String> retVal = new HashMap<String, String>();

		Document doc = Jsoup.parse(content);
//		System.out.println(doc.text());
		Elements lis = doc.select("div");
//		 System.out.println(lis);
		lis = lis.select(".kCrYT");
//		 System.out.println(lis.size());

		for (Element li : lis) {
			try {
				String citeUrl = li.select("a").get(0).attr("href");
				String title = li.select("a").get(0).select(".vvjwJb").text();

				// Continue to next round if there is no title
				if (title.equals("")) {
					continue;
				}

				// Remove the extra text in the end of the URL and decode the Chinese URL
				citeUrl = citeUrl.substring(7, citeUrl.indexOf("&"));
				citeUrl = java.net.URLDecoder.decode(citeUrl, "utf-8");
//				System.out.println(citeUrl);

//				retVal.put(title, citeUrl);

				try {
					sort.addWagePage(citeUrl, title);
				} catch (Exception e) {

				}

//				System.out.println(title + ","+citeUrl);

			} catch (IndexOutOfBoundsException e) {
//				e.printStackTrace();
			}
		}

//		System.out.print(sort);
		sort.pageListSort();
		
		System.out.println("\nResult:");
		for (Webpage w : sort.getSortedPageList()) {
			// retVal.put( , w.getUrl());
			System.out.println(w.getName() + " " + w.getScore());
		}

		return sort.getSortedPageList();
	}

}
