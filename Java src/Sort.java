

import java.io.IOException;
import java.util.ArrayList;

public class Sort {
	
	private String title;
	private String url;
	private ArrayList<Webpage> sortedPageList;
	
	private ArrayList<Webpage> pageList;
	private KeywordList keywordlist;
	
	public Sort() {
		keywordlist=new KeywordList();
		pageList=new ArrayList<Webpage>();
		sortedPageList=new ArrayList<Webpage>();
	}
	
	public void addWagePage(String url,String title) throws IOException {
		Webpage webpage=new Webpage(url, title);
		setScore(webpage);
		pageList.add(webpage);
	}
	
	public void setScore(Webpage webpage) throws IOException {
		BinaryTree tree =new BinaryTree(webpage);	
		tree.setPostOrderScore(keywordlist.getKeywordList());
	}
	public void pageListSort() {
		KeywordHeap heap=new KeywordHeap(pageList);
		sortedPageList=heap.output();
	}
	public ArrayList<Webpage>getSortedPageList(){
		return sortedPageList;
	}
}
