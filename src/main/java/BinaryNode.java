import java.io.IOException;
import java.util.ArrayList;

public class BinaryNode {
	public BinaryNode parent;
	public ArrayList<BinaryNode> children;
	public Webpage webPage;
	public double nodeScore;
	
	public BinaryNode(Webpage webPage){
		this.webPage = webPage;
		this.children = new ArrayList<BinaryNode>();
	}
	public void setNodeScore(ArrayList<Keyword> keywords) throws IOException{
		webPage.setScore(keywords);
		
		nodeScore = webPage.score;
		
		for(BinaryNode child : children){
			nodeScore += child.nodeScore;
		}
			
	}
	
	public void addChild(BinaryNode child){
		this.children.add(child);
		child.parent = this;
	}
	
	public boolean isTheLastChild(){
		if(this.parent == null) return true;
		ArrayList<BinaryNode> siblings = this.parent.children;
		
		return this.equals(siblings.get(siblings.size() - 1));
	}
	public int getDepth(){
		int retVal = 1;
		BinaryNode currNode = this;
		while(currNode.parent!=null){
			retVal ++;
			currNode = currNode.parent;
		}
		return retVal;
	}
}
