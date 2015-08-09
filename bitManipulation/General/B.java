package General;

public class B {
	public static void main(String[] args){
		int index = 12;
		//index -= index & (-index);
		System.out.println(index);
		
		System.out.println(Integer.toBinaryString(index));
		System.out.println(Integer.toBinaryString(-index));
		System.out.println(Integer.toBinaryString(index & (-index)));
		System.out.println("fuck");
		System.out.println(Integer.toBinaryString(0x55));
		System.out.println(Integer.toBinaryString(1 << 1));
		System.out.println(Integer.toBinaryString(1 << 2));
		System.out.println(Integer.toBinaryString(1 << 6));
		System.out.println(Integer.toBinaryString((1 << 6) -1));
		System.out.println(Integer.toBinaryString(~0));
		System.out.println(Integer.toBinaryString(~0 - ((1 << 6) -1)));
		System.out.println(Integer.toBinaryString(0xaa));
		System.out.println(1 << 5);
		
	}
}
