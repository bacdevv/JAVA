package example.p04_modifiers.access.demo_same;

import example.p04_modifiers.access.demo_other.OtherPackageClass;

public class SubclassInOtherPackageExample extends OtherPackageClass {
	
	public String getOtherPackage() {
		String result = "";
		OtherPackageClass instance = new OtherPackageClass();
		result = instance.publicText;
		result = super.protectedText;
		result = this.protectedText;
		return result;
	}
}
