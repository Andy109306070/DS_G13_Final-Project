import java.io.IOException;
import java.util.ArrayList;


public class BinaryTree {
	public BinaryNode root;
	
	public BinaryTree(Webpage rootPage){
		this.root = new BinaryNode(rootPage);
	}
	
	public void setPostOrderScore(ArrayList<Keyword> keywords) throws IOException{
		setPostOrderScore(root, keywords);
	}
	
	private void setPostOrderScore(BinaryNode startNode, ArrayList<Keyword> keywords) throws IOException{
		for(BinaryNode child : startNode.children){
			child.setNodeScore(keywords);
		}
		startNode.setNodeScore(keywords);
		}
	
	private String repeat(String str,int repeat){
		String retVal  = "";
		for(int i=0;i<repeat;i++){
			retVal+=str;
		}
		return retVal;
	}
}