package example.p04_modifiers.access.demo_same;

public class SamePackageClass {
	
	private String privateText = "privateText";
	String defaultText = "defaultText";
	protected String protectedText = "protectedText";
	public String publicText = "publicText";
	
	static String defaultStaticText = "defaultStaticText";
	protected static String protectedStaticText = "protectedStaticText";
	
	public String getSameClass() {
		return this.privateText;
	}
}
