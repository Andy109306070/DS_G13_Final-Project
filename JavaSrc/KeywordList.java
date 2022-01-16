
import java.util.ArrayList;

public class KeywordList {
	Keyword MicrosoftCh = new Keyword("微軟", 10);
	Keyword Microsoft = new Keyword("Microsoft", 10);
	Keyword laptopCh = new Keyword("平板", 10);
	Keyword laptop = new Keyword("laptop", 3.5);
	Keyword ChangeablelaptopCh = new Keyword("變形電腦", 5);
	Keyword computerCh = new Keyword("電腦", 10);
	Keyword unboxingCh = new Keyword("開箱", 2);
	Keyword testingCh = new Keyword("評測", 10);
	Keyword reviewCh = new Keyword("心得",10);
	Keyword review = new Keyword("review", 2);
	Keyword commentCh = new Keyword("評價", 10);
	Keyword comment = new Keyword("comment", 2.5);
	Keyword tablet = new Keyword("tablet", 1);
	Keyword nobuy = new Keyword("購物", -1);
	Keyword nobuy1 = new Keyword("拍賣", -1);
	Keyword nobuy2 = new Keyword("購買", -1);
	
	ArrayList<Keyword> KeywordList = new ArrayList<Keyword>();

	public KeywordList() {
		KeywordList.add(MicrosoftCh);
		KeywordList.add(Microsoft);
		KeywordList.add(laptopCh);
		KeywordList.add(laptop);
		KeywordList.add(ChangeablelaptopCh);
		KeywordList.add(computerCh);
		KeywordList.add(unboxingCh);
		KeywordList.add(testingCh);
		KeywordList.add(reviewCh);
		KeywordList.add(review);
		KeywordList.add(commentCh);
		KeywordList.add(comment);
		KeywordList.add(tablet);
		KeywordList.add(nobuy);
		KeywordList.add(nobuy1);
		KeywordList.add(nobuy2);
	}

	public ArrayList<Keyword> getKeywordList() {
		return KeywordList;
	}
}
