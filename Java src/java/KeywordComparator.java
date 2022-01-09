package java;

import java.util.Comparator;
public class KeywordComparator {
	public int compare(Webpage o1,Webpage o2){
		if(o1==null || o2==null) throw new NullPointerException();
		//count �Ȥp����e��(�ܦ���)  min heap [count �Ȥj����e��(�ܦ���) max heap]
		if(o1.getScore()>o2.getScore()){ 
			return -1;
		}else if(o1.getScore()<o2.getScore()){
			return 1;
		}
		return 0;
	}
}
