import java.util.*;


public class OverlappingLineSegment {
	static Map<Integer, Integer> result = new HashMap<Integer, Integer>();
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		String[] line1 = in.nextLine().trim().split(" ");
		int n = Integer.valueOf(line1[0]);
		int m = Integer.valueOf(line1[1]);
		
		Point[] p = new Point[n];
		for(int i = 0; i<n; i++){
			String[] line = in.nextLine().trim().split(" ");
			Point point = new Point(Integer.valueOf(line[0]), Integer.valueOf(line[1]));
			p[i] = point;
		}
		
		int[] query = new int[m];
		for(int i = 0; i<m; i++){
			int temp = Integer.valueOf(in.nextLine().trim());
			query[i] = temp;
			result.put(query[i], 0);
		}
		process(p, query);
	}
	
	public static void process(Point[] p, int[] query){
		
		for(Point point : p){
			for(Integer i : result.keySet()){
				if(point.x1 <= i && point.x2 >= i){
					result.put(i, result.get(i)+1);
				}
			}
		}
		
		for(int i = 0; i<query.length; i++){
			System.out.println(result.get(query[i]));
		}
	}
	
	static class Point{
		int x1;
		int x2;
		public Point(int x1, int x2){
			this.x1 = x1;
			this.x2 = x2;
		}
	}
}
