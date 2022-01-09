

import java.util.ArrayList;
import java.util.PriorityQueue;

public class KeywordHeap {
	private PriorityQueue<Webpage> heap;
	
	public KeywordHeap(ArrayList<Webpage> pageList){
		
		this.heap = new PriorityQueue<Webpage>();
		
		for(int i=0;i<pageList.size();i++) {
			heap.add(pageList.get(i));
		}
	}
	
	public void add(Webpage k){
		heap.offer(k);
//		System.out.println("Done");
		
	}
	
	public void peek(){
		if(heap.peek() == null){
			System.out.println("InvalidOperation");
			return;
		}
		
		Webpage k = heap.peek();		
		System.out.println(k.toString());
	}
	
	public void removeMin(){
		//TODO: write remove minimal element logic here...
		Webpage k=heap.poll();
		System.out.println(k.toString());		
	}
	
	public ArrayList<Webpage> output(){
		//TODO: write output and remove all element logic here...
		ArrayList<Webpage> Webpages = new ArrayList<Webpage>();
		
		while(heap.peek() != null){
			 Webpages.add(heap.poll());	
		}
		return Webpages;
		
	}
}