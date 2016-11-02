/**
* <p>Title: TreeNode.java</p>
* <p>Description: </p>
* @author chenshiyang
* @date Feb 27, 2016
* @version version 1.0
*/
package csy.tree;

/**
 * <p>Title: TreeNode</p>
 * <p>Description: </p>
 * @author chenshiyang
 * @date Feb 27, 2016
 * @time 1:32:33 PM
 */
public class TreeNode {
	public TreeNode left;
	public TreeNode right;
	public TreeNode parent;
	public Key key;
	public Value val;
	public int N = -1;
	
	public TreeNode(){
		
	}
	
	public TreeNode(Key key){
		this.key = key;
	}
	
	public TreeNode(Key key, Value val){
		this.key = key;
		this.val = val;
	}
	
	public TreeNode(int key, int val){
		this.key = new Key(key);
		this.val = new Value(val);
	}
	
	public TreeNode(Key key, Value val, int N){
		this.key = key;
		this.val = val;
		this.N = N;
	}
	
	public TreeNode(int key, int val, int N){
		this.key = new Key(key);
		this.val = new Value(val);
		this.N = N;
	}
}
