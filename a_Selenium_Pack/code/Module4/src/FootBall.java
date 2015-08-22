
public class FootBall extends Game {
	
	int goals;
	
	public void scoreGoal(){
		System.out.println("Goal scored");
	}
	// overriding
	@Override // annotation
	public void start(){
		System.out.println("game of football is starting");
	}

}
