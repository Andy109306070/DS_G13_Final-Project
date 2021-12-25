import java.util.ArrayList;
public class javaMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Keyword> KeywordList=new ArrayList<Keyword>();
		Keyword MicrosoftCh=new Keyword ("微軟",5);
		Keyword Microsoft=new Keyword ("Microsoft",4.5);
		Keyword laptopCh=new Keyword ("平板",4);
		Keyword laptop=new Keyword ("laptop",3.5);
		Keyword ChangeablelaptopCh=new Keyword ("變形電腦",5);
		Keyword computerCh=new Keyword ("電腦",4);
		Keyword unboxingCh=new Keyword ("開箱",2);
		Keyword testingCh=new Keyword ("評測",3);
		Keyword reviewCh=new Keyword ("心得",3);
		Keyword review =new Keyword ("review",2);
		Keyword commentCh =new Keyword ("評價",3);
		Keyword comment =new Keyword ("comment",2.5);
		Keyword tablet =new Keyword ("tablet  ",1);
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

	}

}
