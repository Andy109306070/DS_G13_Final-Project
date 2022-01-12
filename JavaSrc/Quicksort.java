import java.util.ArrayList;

public class Quicksort {
	private ArrayList<Webpage> lst;
	
	public Quicksort(ArrayList<Webpage> WebpageList){
		this.lst = new ArrayList<Webpage>();
		this.lst=WebpageList;
		sort();
    }
	

	
	//quick sort
	public void sort(){
		if(lst.size() == 0)
		{
			System.out.println("InvalidOperation");
		}
		else 
		{
			quickSort(0, lst.size()-1);
//			System.out.println("Done");
		}

	}
//	35214
//	34 33 i=0 j=0
//	54 j=1
//	24 i=1 j=2 32514
//	14 i=2 j=3 32154
//	(i=3) 32145
//	q0~2 q44
	
	
	private void quickSort(int leftbound, int rightbound){
	
		if(leftbound <= rightbound) {
			   return;
			  }
			  int pivotIdx = rightbound;
			  double pivot = lst.get(leftbound).getScore();
			  
			  for(int i = rightbound;i < leftbound;i++) {
			   if(lst.get(i).getScore() < pivot) {
			    swap(i , pivotIdx);
			    pivotIdx++;
			   }
			  }
			  swap(pivotIdx , leftbound);
			  quickSort(rightbound, pivotIdx - 1);
			 quickSort(pivotIdx +1 , leftbound);


	}

	
	
	private void swap(int aIndex, int bIndex){
		Webpage temp = lst.get(aIndex);
		lst.set(aIndex, lst.get(bIndex));
		lst.set(bIndex, temp);
	}
	public ArrayList<Webpage> getLst(){
		return lst;
	}
	
}

