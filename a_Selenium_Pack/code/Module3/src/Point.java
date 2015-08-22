
public class Point {

	int x;
	int y;
	public static void main(String[] args) {
		Point p = new Point();
		p.x=100;
		p.y=200;
		swap(p.x, p.y); // pass by value
		System.out.println("x is  "+p.x);
		System.out.println("y is "+p.y);
		
		swap(p);
		System.out.println("New x is "+ p.x);
		System.out.println("New y is "+ p.y);
	}
	
	public static void swap(int a, int b){ // pass by value
		
		int temp=a;
		a=b;
		b=temp;
		
	}
	
	public static void swap(Point q){  // pass by reference
		
		int temp = q.x;
		q.x=q.y;
		q.y=temp;
		
	}

}
