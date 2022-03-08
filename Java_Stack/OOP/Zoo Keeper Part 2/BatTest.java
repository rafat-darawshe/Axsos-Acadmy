
public class BatTest {
	public static void main(String []args) {
		Bat a = new Bat();
		a.fly();
		a.fly();
		a.eatHumans();
		a.eatHumans();
		a.attackTown();
		a.attackTown();
		a.attackTown();
		
	}
    public int displayEnergy(){
        System.out.println("The dragon's energy level is at: " + energyLevel);

        return energyLevel;
    }
	

}
