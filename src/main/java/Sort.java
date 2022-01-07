
public class Sort {
	
	public void sort(){
		if(lst.size() == 0)
		{
			System.out.println("InvalidOperation");
		}
		else 
		{
			quickSort(0, lst.size()-1);
		}

	}
	private void quickSort(int leftbound, int rightbound){
		if(leftbound >= rightbound) {
			return;
		}
		int pivotIdx = leftbound;
		int pivot = lst.get(rightbound).count;
		
		for(int i = leftbound;i < rightbound;i++) {
			if(lst.get(i).count < pivot) {
				swap(i , pivotIdx);
				pivotIdx++;
			}
		}
		swap(pivotIdx , rightbound);
		quickSort(leftbound, pivotIdx - 1);
		quickSort(pivotIdx +1 , rightbound);
	}
	private void swap(int aIndex, int bIndex){
		Keyword temp = lst.get(aIndex);
		lst.set(aIndex, lst.get(bIndex));
		lst.set(bIndex, temp);
	}

}
