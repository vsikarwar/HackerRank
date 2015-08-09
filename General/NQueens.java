import java.util.Arrays;


public class NQueens {
	
	public static void main(String[] args){
		//int[] a = {3, 1, 4, 2};
		int[] a = {8, 4, 5, 1, 3, 7, 8, 2, 6};
		//int[] a = {2, 3, 1};
		
		System.out.println(maxThreats(a));
	}
	
	public static int maxThreats(int[] a){
		
		int mcount = 0;
		int[][] matrix = new int[a.length][a.length];
		
		int[][] dir = {{1,0}, {-1,0}, {0, -1},
							{0, 1},{-1, -1},{-1, 1},
							{1, -1},{1, 1}};
		
		for(int i = 0; i<a.length; i++){
			matrix[i][a[i]-1] = 1;
		}
		
//		for(int[] r : matrix){
//			System.out.println(Arrays.toString(r));
//		}
		
		for(int i = 0; i<a.length; i++){
			int count = 0;
			int y = i;
			int x = a[i] - 1;
			
			int[][] res = new int[8][2];
			
			for(int j = 0; j<dir.length; j++){
				res[j][0] = x + dir[j][0];
				res[j][1] = y + dir[j][1];
				while(res[j][0] >= 0 && res[j][0] < a.length && res[j][1] >= 0 && res[j][1] < a.length){
					if(matrix[res[j][1]][res[j][0]] == 1){
						count++;
						break;
					}
					res[j][0] = res[j][0] + dir[j][0];
					res[j][1] = res[j][1] + dir[j][1];
				}
			}
			if(mcount < count){
				mcount = count;
			}
		}
		
		return mcount;
		
	}

}
