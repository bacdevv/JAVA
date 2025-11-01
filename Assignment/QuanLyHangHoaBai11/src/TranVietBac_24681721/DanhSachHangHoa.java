package TranVietBac_24681721;

import java.util.ArrayList;

public class DanhSachHangHoa {
	private ArrayList<HangHoa> dsHangHoa;

	public DanhSachHangHoa() {
		this.dsHangHoa = new ArrayList<>();
	}
	
//	public HangHoa timHangHoa(String maHang) {
//		for (HangHoa hh : dsHangHoa) {
//			if (hh.getMaHang().equals(maHang)) {
//				return hh;
//			}
//		}
//		return null;
//	}
	
	public HangHoa timHangHoa(String maHang) {
		return dsHangHoa.stream()
				.filter(hh->hh.getMaHang().equals(maHang))
				.findFirst()
				.orElse(null);
	}
	
	public boolean themHangHoa(HangHoa hh) {
		if (hh == null) return false;
		
		if (timHangHoa(hh.getMaHang()) != null) {
			return false;
		}
		
		return dsHangHoa.add(hh);
	}
}
