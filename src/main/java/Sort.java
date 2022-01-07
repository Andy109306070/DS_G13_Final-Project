import java.util.ArrayList;

public class Sort {
	ArrayList<BinaryTree> TreeList = new ArrayList<BinaryTree>();
	
	public void sort(){
		if(TreeList.size() == 0)
		{
			System.out.println("InvalidOperation");
		}
		else 
		{
			quickSort(0, TreeList.size()-1);
		}

	}
	private void quickSort(int leftbound, int rightbound){
		if(leftbound >= rightbound) {
			return;
		}
		int pivotIdx = leftbound;
		double pivot = TreeList.get(rightbound).score;
		
		for(int i = leftbound;i < rightbound;i++) {
			if(TreeList.get(i).score < pivot) {
				swap(i , pivotIdx);
				pivotIdx++;
			}
		}
		swap(pivotIdx , rightbound);
		quickSort(leftbound, pivotIdx - 1);
		quickSort(pivotIdx +1 , rightbound);
	}
	private void swap(int aIndex, int bIndex){
		BinaryTree temp = TreeList.get(aIndex);
		TreeList.set(aIndex, TreeList.get(bIndex));
		TreeList.set(bIndex, temp);
	}

}
