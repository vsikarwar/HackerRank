package General;

public class A {
	
	public static void main(String[] args){
		int a = 1;
		System.out.println(5 >> 1);
		swap(10, 12);
		for(int j = 0; j<20; j++){
			System.out.print("\n" + Integer.toBinaryString(j) + " : ");
			for(int i=20; i>=0; i--){
				System.out.print(getBit(j, i) + " ");
			}
		}
	}
	
	public static void swap(int a , int b){
		System.out.println(a + " "  + b);
		a ^= b;
		b ^= a;
		a ^= b;
		
		System.out.println(a + " "  + b);
	}
	
	public static int getBit(int n, int index){
		if((n & (1 << index)) > 0){
			return 1;
		}else{
			return 0;
		}
	}

}
