package example.p05_umlclass.inheritance.demo_relationship;

public class DependencyRelationship {
	
	@SuppressWarnings("unused")
	private int size = 0;

	public DependencyRelationship(int size) {
		this.size = size;
	}
	
	public void printObject(ObjectClass object) {
		System.out.println(object);	// Dependency
	}
	
	
	

}
