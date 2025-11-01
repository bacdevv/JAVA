package TranVietBac_24681721;

public enum MucDoBuonBan {
	BANDUOC("Ban Duoc"),
	BANCHAM("Ban Cham"),
	KHOBAN("Kho Ban"),
	KHONGDANHGIA("Khong Danh Gia");
	
	private final String text;
	
	private MucDoBuonBan(String text) {
		this.text = text;
	}
	
	@Override
	public String toString() {
		return text;
	}
}
