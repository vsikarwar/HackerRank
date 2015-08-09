package randomNum;

import java.util.Random;
import java.util.Scanner;

public class RandomNum {
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		Integer testCase = Integer.valueOf(in.nextLine().trim());
		
		for(int i = 0; i<testCase; i++){
			String[] timeStr = in.nextLine().trim().split(" ");
			Long startTime = Long.valueOf(timeStr[0]);
			Long endTime = Long.valueOf(timeStr[1]);
			int[] val = new int[10];
			for(int j = 0; j<10; j++){
				val[j] = Integer.valueOf(in.nextLine().trim());
			}
			
			for(long j =  startTime; j<=endTime; j++){
				Random r = new Random(j);
				boolean result = true;
				for(int k = 0; k<10; k++){
					int v = r.nextInt(1000);
					if(val[k] != v){
						result = false;
						break;
					}
				}
				if(result){
					System.out.print(j);
					for(int l = 0; l<10; l++){
						System.out.print(" " +r.nextInt(1000));
					}
					System.out.print("\n");
					break;
				}
			}
			
		}
		
	}
}
