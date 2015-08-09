
class StairCase 
{ 
static void steps(int n, String alreadyTakenSteps,int k) { 
	if (n == 0) { 
		System.out.println(alreadyTakenSteps); 
		alreadyTakenSteps=null; 
	} 
	for(int i=1;i<=k;i++){ 
		if (n >= i) { 
			steps(n - i, alreadyTakenSteps.concat(""+i),k); 
		} 
	
	} 
} 
public static void main (String[] args) throws java.lang.Exception 
{ 
int n=5; 
String s=new String(); 
steps(n,s,3); 
} 
}
