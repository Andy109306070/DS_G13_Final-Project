

import java.io.IOException;
import java.util.ArrayList;

import java.io.IOException;
import java.util.ArrayList;

import javax.swing.text.StyledEditorKit.ForegroundAction;


public class BinaryTree {
	public BinaryNode root;
	
	public BinaryTree(Webpage rootPage){
		this.root = new BinaryNode(rootPage);
	}
	
	public void setPostOrderScore(ArrayList<Keyword> keywords) throws IOException{
		setPostOrderScore(root, keywords);
	}
	
	private void setPostOrderScore(BinaryNode startNode, ArrayList<Keyword> keywords) throws IOException{
		//1. compute the score of children nodes postorder
		for(BinaryNode child : startNode.children){
			setPostOrderScore(child, keywords);
		}
		//**setNode score of startNode
			startNode.setNodeScore(keywords);
		}
	
	public void eularPrintTree(){
		eularPrintTree(root);
	}
	
	private void eularPrintTree(BinaryNode startNode){
		int nodeDepth = startNode.getDepth();
		
		if(nodeDepth > 1) System.out.print("\n" + repeat("\t", nodeDepth-1));
		//print "("
		System.out.print("(");
		//print "name","score"
		System.out.print(startNode.webPage.name+","+startNode.nodeScore);
		
		//2.print child preorder
		for(BinaryNode child : startNode.children){
			eularPrintTree(child);
		}
		
		//print ")"
		System.out.print(")");
		
		/*for example
		(Soslab,459.0
				(Publication,286.2)
				(Projects,42.0
						(Stranger,0.0)
				)
				(MEMBER,12.0)
				(Course,5.3999999999999995)
		)
		*/
		if(startNode.isTheLastChild()) System.out.print("\n" + repeat("\t", nodeDepth-2));
		
	}
	
	private String repeat(String str,int repeat){
		String retVal  = "";
		for(int i=0;i<repeat;i++){
			retVal+=str;
		}
		return retVal;
	}
}	