

public class Bat extends Specimen{
	public void fly() {
		System.out.println("the sound a bat taking off");
		super.setEnergy(super.displayEnergy()-50);
		System.out.println(super.displayEnergy());
		
		
	}
	public void eatHumans() {
		System.out.println("the so- well, never mind");
		super.setEnergy(super.displayEnergy()+25);
		System.out.println(super.displayEnergy());
		
	}
	public void attackTown() {
		System.out.println("the sound of a town on fire");
		super.setEnergy(super.displayEnergy()-100);
		System.out.println(super.displayEnergy());
		
	}
}