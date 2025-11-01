package example.p04_modifiers.access.demo_same;

import example.p04_modifiers.access.demo_other.OtherPackageClass;

public class SamePackageExample {
	
	public String getSamePackage() {
		String result = "";
		SamePackageClass instance = new SamePackageClass();
		result = instance.publicText;
		result = instance.protectedText;
		result = instance.defaultText;
		return result;
	}
	
	public String getOtherPackage() {
		String result = "";
		OtherPackageClass instance = new OtherPackageClass();
		result = instance.publicText;
		return result;
	}

}
