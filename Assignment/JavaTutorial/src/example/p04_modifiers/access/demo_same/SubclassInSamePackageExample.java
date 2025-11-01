package example.p04_modifiers.access.demo_same;

public class SubclassInSamePackageExample extends SamePackageClass {
	
	public String getSamePackage() {
		String result = "";
		SamePackageClass instance = new SamePackageClass();
		result = instance.publicText;
		result = instance.protectedText;
		result = instance.defaultText;
		
		result = super.defaultText;
		result = super.protectedText;
		result = this.defaultText;
		result = this.protectedText;
		return result;
	}

}
