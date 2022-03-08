package comvillage88projectone;

public class Mammal {
	private int energyLevel = 100;
	
	public Mammal() {

   }
	public void setEnergy(int energyLevel) {
		this.energyLevel = energyLevel;
	}
	
	public int displayEnergy() {
		
		return energyLevel;
	}
}
