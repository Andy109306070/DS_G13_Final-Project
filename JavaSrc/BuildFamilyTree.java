import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class BuildFamilyTree extends BinaryTree {
	private String rootContent;

	public BuildFamilyTree(Webpage root) throws IOException {
		super(root);
		this.rootContent = fetchContent(root);
	}

	private String fetchContent(Webpage w) throws IOException {
		String retVal = "";

		URL u = new URL(w.getUrl());
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

	public void setChildren() throws IOException {
		// Parse the website content
		Document doc = Jsoup.parse(rootContent);

		Elements lis = doc.select("a");

		System.out.println("looking for child...");
		
		for (Element li : lis) {
			try {
//				System.out.println(li.text() + " " + li.attr("href").toString());
				String url = li.attr("href");
				String title = li.text();
				// Continue to next round if there is no title
				// and there isn't a complete subpage url
				if (title.equals("") || url.indexOf("http") == -1) {
					continue;
				}
				// Check if the url is the subpage of parent
				// If so, add child to the parent node
				else if (url.indexOf(this.root.webPage.getUrl()) != -1
						&& url.length() > this.root.webPage.getUrl().length()) {
//					System.out.println(this.root.webPage.getName() + " - subpage found! " + url);
					BinaryNode childNode = new BinaryNode(new Webpage(url, title));
					this.root.addChild(childNode);
					setChildren(childNode);
				}

			} catch (IndexOutOfBoundsException e) {
				e.printStackTrace();
			}
		}
	}

	private void setChildren(BinaryNode nd) throws IOException {
		// We want to build a tree which height is only 2
		if (nd.getDepth() <= 2) {
			Document doc = Jsoup.parse(fetchContent(nd.webPage));

			Elements lis = doc.select("a");

			if (lis != null) {
				for (Element li : lis) {
					try {
//						System.out.println(li.text() + " " + li.attr("href").toString());
						String url = li.attr("href");
						String title = li.text();
					
						// Continue to next round if there is no title
						// and there isn't a complete subpage url
						if (title.equals("") || url.indexOf("http") == -1) {
							continue;
						}
						// Check if the url is the subpage of root
						// If so, add child to the parent node
						else if (url.indexOf(nd.webPage.getUrl()) != -1
								&& url.length() > nd.webPage.getUrl().length()) {
//							System.out.println(nd.webPage.getName() + " - more subpage found! " + url);
							BinaryNode childNode = new BinaryNode(new Webpage(url, title));
							nd.addChild(childNode);
							// Recursive function here
							setChildren(childNode);
						}

					} catch (IndexOutOfBoundsException e) {
//						e.printStackTrace();
					}
				}
			}
		}

		return;

	}
}