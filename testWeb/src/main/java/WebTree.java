import java.io.IOException;
import java.util.ArrayList;

public class WebTree {
	public WebNode root;

	public WebTree(WebPage rootPage) {
		this.root = new WebNode(rootPage);
	}

	public void setPostOrderScore(ArrayList<Keyword> keywords) throws IOException {
		setPostOrderScore(root, keywords);
	}

	private void setPostOrderScore(WebNode startNode, ArrayList<Keyword> keywords) {

		try {
			startNode.setNodeScore(keywords);
		} catch (Exception e) {

		}
	}

	public void eularPrintTree() {
		eularPrintTree(root);
	}

	private void eularPrintTree(WebNode startNode) {
		int nodeDepth = startNode.getDepth();

		if (nodeDepth > 1) {
			System.out.print("\n" + repeat("\t", nodeDepth - 1));
		}
		System.out.print("(");
		System.out.print(startNode.webPage.name + "," + startNode.nodeScore);


		for (int i = 0; i < startNode.children.size(); i++) {
			eularPrintTree(startNode.children.get(i));
		}
		System.out.print(")");

		if (startNode.isTheLastChild()) {
			System.out.print("\n" + repeat("\t", nodeDepth - 2));
		}
	}

	private String repeat(String str, int repeat) {
		String retVal = "";
		for (int i = 0; i < repeat; i++) {
			retVal += str;
		}
		return retVal;
	}
}