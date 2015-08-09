import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CompareList {
	static Map<String, Integer> vins = new HashMap<String, Integer>();
	public static void main(String[] args) throws IOException{
		//read db
		List<String> lines = Files.readAllLines(Paths.get("/Users/sikarwv/Documents/Work/gif/vins_db.csv"));
		for(String line : lines){
			String vin = line.trim().split(",")[0];
			vins.put(vin.substring(1, vin.length() - 1), 0);
			//System.out.println(vin.substring(1, vin.length() - 1));
		}
		System.out.println(vins.size());
		vins.remove("VIN");
		System.out.println(vins.size());
		//read intransit
		
		//12105
		
		//9871
		//4819
		
		
		//261
		//14429
		
		List<String> linesIntransit = Files.readAllLines(Paths.get("/Users/sikarwv/Documents/Work/gif/inventory_new_01232015.txt"));
		for(String line : linesIntransit){
			String vin = line.trim().split("\\t")[2];
			if(vins.get(vin) != null){
				vins.put(vin, vins.get(vin)+1);
			}
		}
		
		int notFound = 0;
		int found = 0;
		for(String vin : vins.keySet()){
			if(vins.get(vin) == 0){
				notFound++;
			}else{
				found++;
			}
		}
		
		System.out.println("Found : " + found + " not found : " + notFound);
	}
	
}
