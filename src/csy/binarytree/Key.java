/**
* <p>Title: Key.java</p>
* <p>Description: </p>
* @author chenshiyang
* @date Feb 27, 2016
* @version version 1.0
*/
package csy.binarytree;

/**
 * <p>Title: Key</p>
 * <p>Description: </p>
 * @author chenshiyang
 * @date Feb 27, 2016
 * @time 1:47:45 PM
 */
public class Key implements Comparable<Key>{
	
	private int keyValue;
	
	public Key(){
		
	}
	
	public Key(int val){
		keyValue = val;
	}

	/* (non-Javadoc)
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	@Override
	public int compareTo(Key other) {
		if(this.keyValue > other.keyValue){
			return 1;
		}
		else if(this.keyValue < other.keyValue){
			return -1;
		}
		else{
			return 0;
		}
	}
	
	public String toString(){
		return this.keyValue + "";
	}
}
