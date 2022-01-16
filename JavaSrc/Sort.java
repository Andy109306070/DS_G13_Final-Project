
import java.io.IOException;
import java.util.ArrayList;

public class Sort {
	private ArrayList<Webpage> sortedPageList;
	private ArrayList<Webpage> rootPageList;
	private KeywordList keywordlist;

	public Sort() {
		keywordlist = new KeywordList();
		rootPageList = new ArrayList<Webpage>();
		sortedPageList = new ArrayList<Webpage>();
	}

	public void addWagePage(String url, String title) throws IOException {
		Webpage webpage = new Webpage(url, title);
		setScore(webpage);
		rootPageList.add(webpage);
	}

	public void setScore(Webpage webpage) throws IOException {
//		webpage.setScore(keywordlist.getKeywordList());
		BuildFamilyTree tree = new BuildFamilyTree(webpage);
		tree.setChildren();
		tree.setPostOrderScore(keywordlist.getKeywordList());
		tree.eularPrintTree();
		webpage.score = tree.root.nodeScore;
	}

	public void pageListSort() {
//		Quicksort quicksort = new Quicksort(pageList);
//		quicksort.sort();
//		sortedPageList = quicksort.getLst();
		WebpageHeap heap = new WebpageHeap(rootPageList);
		sortedPageList = heap.output();
	}

	public ArrayList<Webpage> getSortedPageList() {
		return sortedPageList;
	}
}
