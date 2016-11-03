package csy.backtracking;


/**
 * 
 * Description: 
 */
public class NextPermutation {
	public void nextPermutation(int[] num){
		if(null == num || num.length <= 1){
			return;
		}
		
		int i = num.length - 2;
		while(i >= 0 && num[i] >= num[i + 1]){
			i --;
		}
		//if all in order. reverse directly.
		if(i < 0){
			reverse(num, 0, num.length - 1);
			return;
		}
		int j = i + 1;
		for(; j < num.length - 1; j ++){
			if(num[j] > num[i] && num[j + 1] <= num[i]){//deal with duplicate
				break;
			}
		}
		swap(num, i, j);
		reverse(num, i + 1, num.length - 1);
	}
	
//	private void reverse(int[] num, int l, int r){
//		for(int i = 0; i < (r - l + 1) / 2; i ++){
//			swap(num, l + i, r - i);
//		}
//	}
	
	private void reverse(int[] num, int l, int r) {
		while(l < r) {
			swap(num, l, r);
			l ++;
			r --;
		}
	}
	
	private void swap(int[] num, int i, int j){
		int temp = num[i];
		num[i] = num[j];
		num[j] = temp;
	}
	
	public static void main(String[] args){
		NextPermutation so = new NextPermutation();
		int[] test1 = {5, 2, 4, 2, 2};
		for(int i = 0; i < 15; i ++){
			so.nextPermutation(test1);
			for(int j = 0; j < test1.length; j ++){
				System.out.print(test1[j] + " ");
			}
			System.out.println();
		}
	}
}
