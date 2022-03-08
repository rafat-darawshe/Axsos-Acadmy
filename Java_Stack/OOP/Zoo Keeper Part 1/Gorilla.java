package comvillage88projectone;
public class Gorilla extends Mammal{
	public void throwSomething() {
		System.out.println("the gorilla has thrown something");
		super.setEnergy(super.displayEnergy()-5);
		System.out.println(super.displayEnergy());
		
		
	}
	public void eatBananas() {
		System.out.println("the gorilla's satisfaction ");
		super.setEnergy(super.displayEnergy()+10);
		System.out.println(super.displayEnergy());
		
	}
	public void climb() {
		System.out.println("the gorilla has climbed a tree");
		super.setEnergy(super.displayEnergy()-10);
		System.out.println(super.displayEnergy());
		
	}
}