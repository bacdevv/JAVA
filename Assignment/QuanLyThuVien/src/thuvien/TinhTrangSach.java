package thuvien;

public enum TinhTrangSach {
	MOI("MOI"),
	CU("CU");
	
	private String text;
	
	private TinhTrangSach(String text) {
		this.text = text;
	}
	
	@Override
	public String toString() {
		return text;
	}
}
