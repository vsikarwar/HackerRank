package subsequence_weighting;

import java.util.Arrays;

public class BinaryIndexedTree {
	public static void main(String[] args){
		int[] arr = {2, 1, 1, 3, 2, 3, 4, 5, 6, 7, 8, 9};
		int[] tree = constructTree(arr);
		System.out.println(Arrays.toString(tree));
		
		System.out.println(getSum(tree, 5));
	}
	
	public static int[] constructTree(int[] a){
		int[] tree = new int[a.length + 1];
		for(int i = 0; i<tree.length; i++){
			tree[i] = 0;
		}
		
		for(int i = 0; i<tree.length - 1; i++){
			updateBIT(tree, i, a[i]);
		}
		
		return tree;
	}
	
	public static void updateBIT(int[] tree, int index, int val){
		index = index + 1;
		while(index < tree.length){
			tree[index] += val;
			index += index & (-index);
		}
	}
	
	public static int getSum(int[] tree, int index){
		int sum = 0;
		index = index + 1;
		while(index > 0){
			sum += tree[index];
			index -= index & (-index);
		}
		return sum;
	}
	
}
