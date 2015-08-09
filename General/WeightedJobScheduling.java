import java.util.Arrays;


public class WeightedJobScheduling {
	public static void main(String[] args){
		int[][] job = {{3, 10,20}, {1, 2, 50}, {6,19,100}, {2, 100, 200}};
		//sort job according to finish time
		int[][] sortJobs = {{1, 2, 50}, {3, 10,20}, {6,19,100}, {2, 100, 200}};
		process(sortJobs);
	}
	
	public static void process(int[][] job){
		
		int[] table = new int[job.length];
		table[0] = job[0][2];
		for(int i = 1; i<job.length; i++){
			int prof = job[i][2];
			int index = -1;
			for(int j = i-1; j>=0; j--){
				if(job[j][1] <= job[i][0]){
					index = j;
					break;
				}
			}
			if(index >= 0)
				table[i] = max(prof + table[index], prof);
		}
		System.out.println(Arrays.toString(table));
	}
	
	public static int max(int a, int b){
		if(a > b) return a;
		else return b;
	}
	
	static class Job{
		int start;
		int stop;
		int finish;
		public Job(int start, int stop, int finish){
			this.start = start;
			this.stop = stop;
			this.finish = finish;
		}
	}
	
	
}
