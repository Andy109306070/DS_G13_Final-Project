

import java.util.ArrayList;
import java.util.PriorityQueue;

public class WebpageHeap {
	private PriorityQueue<Webpage> heap;
	
	public WebpageHeap(ArrayList<Webpage> pageList){
		
		this.heap = new PriorityQueue<Webpage>(pageList.size(), new WebpageComparator());
		
		for(int i = 0; i < pageList.size(); i++) {
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
		
		System.out.println(heap.toString());		
	}
	
	public ArrayList<Webpage> output(){
		//TODO: write output and remove all element logic here...
		ArrayList<Webpage> webpages = new ArrayList<Webpage>();
		
		while(heap.peek() != null){
			 webpages.add(heap.poll());	
		}
		
		return webpages;
	}
}