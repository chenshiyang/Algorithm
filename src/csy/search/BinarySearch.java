package csy.search;

/**
 * 
 * Description: 
 */
public class BinarySearch {
	public <T extends Comparable> int search(T[] array, T target){
		int l = 0, r = array.length - 1;
		while(l <= r){
			int mid = (l + r) / 2;
			int cmp = target.compareTo(array[mid]);
			if(0 == cmp){
				return mid;
			}
			else if(cmp < 0){
				r = mid - 1;
			}
			else{
				l = mid + 1;
			}
		}
		return -1;//not found
	}

	/**
	 * 上面哪个泛型版本的优化,
	 * 1 是mid的计算防止了int类型数值溢出
	 * 2 条件的判断, 相等的概率低,挪到最后判断
	 *
	 * @param array
	 * @param target
	 * @return
	 */
	public int search(int[] array, int target) {
		if(null == array || array.length == 0) {
			return -1;
		}
		int l = 0, r = array.length - 1;
		while(l <= r) {
			int mid = l + (r - l) / 2;
			if(array[mid]  < target) {
				l = mid + 1;
			} else if(array[mid] > target) {
				r = mid - 1;
			} else {
				return mid;
			}
		}
		return -1;
	}

	public static void main(String[] args){
		BinarySearch so = new BinarySearch();
		Integer[] test1 = {1, 2, 3, 4, 5, 6, 7, 8};
		String[] test2 = {"andy", "bob", "cat", "doom", "ellen", "filcon"};
		System.out.println(so.search(test1, 5));
		System.out.println(so.search(test2, "cat"));
		System.out.println(so.search(test2, "gg"));
		int[] array = {1, 2, 3, 4, 5, 6};
		System.out.println(so.search(array, 4));
	}
}
