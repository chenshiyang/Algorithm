package csy.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;


/**
 * <p>Description: An implementation of binary search tree.</p>
 * @author chenshiyang
 * @date Feb 27, 2016
 * @time 1:15:43 PM
 */
public class BinarySearchTree {
	private TreeNode root;
	public int size(){
		return size(root);
	}
	//can not update size when tree is changed
	private int size(TreeNode node){
		if(null == node){
			return 0;
		}
		if(node.N > 0){
			return node.N;
		}
		else{
			node.N = 1 + size(node.left) + size(node.right);
			return node.N;
		}
	}

	public void setRoot(TreeNode root) {
		this.root = root;
	}

	public Value search(Key key){
		return search(root, key);
	}
	
	private Value search(TreeNode root, Key key){
		TreeNode node = this.root;
		while(node != null){
			int cp = node.key.compareTo(key);
			if(cp == 0){
				return node.val;
			}
			else if(cp < 0){
				node = node.left;
			}
			else{
				node = node.right;
			}
		}
		return null;
	}
	
	public void insert(Key key, Value val){
		root = insert(root, key, val);
	}
	
	private TreeNode insert(TreeNode node, Key key, Value value){
		if(null == node){
			return new TreeNode(key, value, 1);
		}
		int cmp = key.compareTo(node.key);
		if(cmp < 0){
			node.left = insert(node.left, key, value);
		}
		else if(cmp > 0){
			node.right = insert(node.right, key, value);
		}
		else{
			node.val = value;
		}
		node.N = size(node.left) + size(node.right) + 1;
		return node;
	}
	
	public Key minimum(){
		TreeNode node = minimum(root);
		if(null == node){
			return null;
		}
		return node.key;
	}
	
	private TreeNode minimum(TreeNode node){
		if(null == node){
			return null;
		}
		TreeNode n = node;
		while(n.left != null){
			n = n.left;
		}
		return n;
	}
	
	public Key maximum(){
		TreeNode node = maximum(root);
		if(null == node){
			return null;
		}
		return node.key;
	}
	
	private TreeNode maximum(TreeNode node){
		if(null == node){
			return null;
		}
		TreeNode n = node;
		while(n.right != null){
			n = n.right;
		}
		return n;
	}
	
	public TreeNode predecessor(TreeNode node){
		if(null != node.left){
			return maximum(node.left);
		}
		TreeNode n = node;
		TreeNode p = n.parent;
		while(p != null && n == p.left){
			n = p;
			p = n.parent;
		}
		return p;
	}
	
	public TreeNode successor(TreeNode node){
		if(null != node.right){
			return minimum(node.right);
		}
		TreeNode n = node;
		TreeNode p = n.parent;
		while(p != null && n == p.right){
			n = p;
			p = n.parent;
		}
		return p;
	}
	
	public void insert(TreeNode node){
		insert(root, node);
	}
	
	private void insert(TreeNode root, TreeNode node){
		TreeNode n = root;
		TreeNode p = root.parent;
		while(n != null){
			p = n;
			if(node.key.compareTo(n.key) < 0){
				n = n.left;
			}
			else{
				n = n.right;
			}
		}
		node.parent = p;
		if(null == p){//tree was empty before insert
			root = node;
		}
		else{
			if(node.key.compareTo(p.key) < 0){
				p.left = node;
			}
			else{
				p.right = node;
			}
		}
	}
	
	public void delete(TreeNode node){
		TreeNode p = node.parent;
		//node has no children
		if(null == node.left && null == node.right){
			if(null == p){//node is root
				root = null;
			}
			else if(p.left == node){
				p.left = null;
			}
			else{
				p.right = null;
			}
		}
		//node has one child
		else if(null != node.left && null == node.right){
			if(null == p){
				root = node.left;
			}
			else if(p.left == node){
				p.left = node.left;
			}
			else{
				p.right = node.left;
			}
			node.left.parent = p;
		}
		else if(null == node.left && null != node.right){
			if(null == p){
				root = node.right;
			}
			else if(p.left == node){
				p.left = node.right;
			}
			else{
				p.right = node.right;
			}
			node.right.parent = p;
		}
		//node has two children
		else{
			TreeNode succ = successor(node);
			delete(succ);
			TreeNode left = node.left;
			TreeNode right = node.right;
			if(null == p){
				root = succ;
			}
			else if(p.left == node){
				p.left = succ;
			}
			else{
				p.right = succ;
			}
			succ.left = left;
			succ.right = right;			
		}
		node.parent = null;
		node.left = null;
		node.right = null;
	}
	
	public List<Key> inorderTraversal(){
		ArrayList<Key> res = new ArrayList<Key>();
		Stack<TreeNode> stack = new Stack<TreeNode>();
		TreeNode node = root;
		while(node != null || !stack.isEmpty()){
			while(node != null){
				stack.push(node);
				node = node.left;
			}
			node = stack.pop();
			res.add(node.key);
			node = node.right;
		}
		return res;
	}
	
	public List<Key> preorderTraversal(){
		ArrayList<Key> res = new ArrayList<Key>();
		Stack<TreeNode> stack = new Stack<TreeNode>();
		TreeNode node = root;
		while(node != null || !stack.isEmpty()){
			while(node != null){
				res.add(node.key);
				stack.push(node);
				node = node.left;
			}
			node = stack.pop();
			node = node.right;
		}
		return res;
	}
	
	/**
	* Description: Use two stack.
	* @return
	*/
	public List<Key> postorderTraversal(){
		ArrayList<Key> res = new ArrayList<Key>();
		Stack<TreeNode> stack = new Stack<TreeNode>();
		Stack<Boolean> visitedStack = new Stack<Boolean>();
		TreeNode node = root;
		while(node != null || !stack.isEmpty()){
			while(node != null){
				stack.push(node);
				visitedStack.push(false);//unvisited
				node = node.left;
			}
			node = stack.pop();
			boolean visited = visitedStack.pop();
			if(!visited){
				//now set it to visited
				stack.push(node);
				visitedStack.push(true);
				//and visit its right child
				node = node.right;
			}
			else{//visited = true, means that its's right child has benn traversed.
				res.add(node.key);
				node = null;
			}
		}
		return res;
	}
	
	/**
	* Description: Use only one stack, plus a variable to remember the last node that we visited.
	* @return
	*/
	public List<Key> postorderTraversal2(){
		ArrayList<Key> res = new ArrayList<Key>();
		Stack<TreeNode> stack = new Stack<TreeNode>();
		TreeNode node = root;
		TreeNode prev = null;
		while(node != null || !stack.isEmpty()){
			while(node != null){
				stack.push(node);
				node = node.left;
			}
			node = stack.peek();
			if(null == node.right || prev == node.right){
				res.add(node.key);
				stack.pop();
				prev = node;
				node = null;
			}
			else{
				node = node.right;
			}
		}
		return res;
	}
	
	public static void main(String[] args){
		BinarySearchTree tree = new BinarySearchTree();
		TreeNode n1 = new TreeNode(new Key(5), new Value(1));
		TreeNode n2 = new TreeNode(new Key(3), new Value(2));
		TreeNode n3 = new TreeNode(new Key(7), new Value(3));
		TreeNode n4 = new TreeNode(new Key(2), new Value(4));
		TreeNode n5 = new TreeNode(new Key(4), new Value(5));
		TreeNode n6 = new TreeNode(new Key(6), new Value(6));
		TreeNode n7 = new TreeNode(new Key(8), new Value(7));
		TreeNode n8 = new TreeNode(new Key(1), new Value(8));
		TreeNode n9 = new TreeNode(new Key(9), new Value(9));
		TreeNode n10 = new TreeNode(new Key(10), new Value(10));

		n1.left = n2;
		n1.right = n3;
		n2.parent = n1;
		n3.parent = n1;
		
		n2.left = n4;
		n2.right = n5;
		n4.parent = n2;
		n5.parent = n2;
		
		n3.left = n6;
		n3.right = n7;
		n6.parent = n3;
		n7.parent = n3;
		
		n4.left = n8;
		n8.parent = n4;
		n7.right = n9;
		n9.parent = n7;
		
		tree.root = n1;
/*		//test size
		System.out.println(tree.size());
		System.out.println(tree.size(n2));
		
		//test search
		System.out.println(tree.search(new Key(4)));
		System.out.println(tree.search(new Key(10)));
		
		//test insert
		tree.insert(new Key(11), new Value(11));
		System.out.println(tree.size());
		System.out.println(n9.right.val);
		
		//test minimum maximum
		System.out.println(tree.minimum());
		System.out.println(tree.maximum());
		
		//test predecessor successor
		System.out.println(tree.predecessor(n1).val);
		System.out.println(tree.successor(n6).val);
		
		//test insert
		tree.insert(n10);
		System.out.println(n10.parent.val);
		
		//test delete
		tree.delete(n1);
		System.out.println(tree.root.val);*/
		
		//test preorder traversal
		System.out.println(tree.preorderTraversal());
		
		//test inorder traversal
		System.out.println(tree.inorderTraversal());
		
		//test postorder traversal
		System.out.println(tree.postorderTraversal());
		System.out.println(tree.postorderTraversal2());
	}
}
