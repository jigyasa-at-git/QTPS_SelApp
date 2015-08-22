
public class Loops {


	public static void main(String[] args) {

		int i = 0;
		
		while(i<10){
			System.out.println("value of i is " +i);
			i=i+1;
		}
		
		System.out.println("****************************");
		for(int t_no=1;t_no<=10 ;t_no++){
			System.out.println("TABLE OF -- " + t_no);
			for(int x=1; x<=10 ;x=x+1 ){
				System.out.println(t_no + " * " +x + " = " + t_no*x);
			}
		}
		
		
		for(int q=1000 ; q<50000 ; q++){
			System.out.println(q);
			
			if(q==1010){
				break; // come out of the for loop
			}
			
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
