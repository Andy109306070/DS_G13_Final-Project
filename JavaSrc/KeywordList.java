
import java.util.ArrayList;

public class KeywordList {
	Keyword MicrosoftCh = new Keyword("�L�n", 10);
	Keyword Microsoft = new Keyword("Microsoft", 10);
	Keyword laptopCh = new Keyword("���O", 10);
	Keyword laptop = new Keyword("laptop", 3.5);
	Keyword ChangeablelaptopCh = new Keyword("�ܧιq��", 5);
	Keyword computerCh = new Keyword("�q��", 10);
	Keyword unboxingCh = new Keyword("�}�c", 2);
	Keyword testingCh = new Keyword("����", 10);
	Keyword reviewCh = new Keyword("�߱o",10);
	Keyword review = new Keyword("review", 2);
	Keyword commentCh = new Keyword("����", 10);
	Keyword comment = new Keyword("comment", 2.5);
	Keyword tablet = new Keyword("tablet", 1);
	Keyword nobuy = new Keyword("�ʪ�", -1);
	Keyword nobuy1 = new Keyword("���", -1);
	Keyword nobuy2 = new Keyword("�ʶR", -1);
	
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
