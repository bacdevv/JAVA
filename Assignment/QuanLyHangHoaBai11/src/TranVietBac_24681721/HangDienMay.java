package TranVietBac_24681721;

import java.text.DecimalFormat;

public class HangDienMay extends HangHoa {
	private int thoiGianBaoHanh;
	private double congSuat;
	
	public HangDienMay(String maHang, String tenHang, int soLuongTon, double donGia, int thoiGianBaoHanh,
			double congSuat) {
		super(maHang, tenHang, soLuongTon, donGia);
		setThoiGianBaoHanh(thoiGianBaoHanh);
		setCongSuat(congSuat);
	}
	public int getThoiGianBaoHanh() {
		return thoiGianBaoHanh;
	}
	
	public void setThoiGianBaoHanh(int thoiGianBaoHanh) {
		if (thoiGianBaoHanh < 0) {
			throw new IllegalArgumentException("Thoi gian bao hanh phai >= 0");
		}
		this.thoiGianBaoHanh = thoiGianBaoHanh;
	}
	public double getCongSuat() {
		return congSuat;
	}
	public void setCongSuat(double congSuat) {
		if (congSuat <= 0) {
			throw new IllegalArgumentException("Cong suat phai > 0");
		}
		this.congSuat = congSuat;
	}
	@Override
	public double tinhVAT() {
		return 0.1;
	}
	@Override
	public MucDoBuonBan mucDoBuonBan() {
		if (soLuongTon < 3) {
			return MucDoBuonBan.BANDUOC;
		}
		return MucDoBuonBan.KHONGDANHGIA;
	}
	
	@Override
	public String toString() {
		DecimalFormat df = new DecimalFormat("0.00KW");
		
		String infoChung = String.format("%s", super.toString());
		String infoRieng = String.format("%-10s %-20s",
					thoiGianBaoHanh,
					df.format(congSuat)
				);
		System.out.printf("%-10s %-20s",
				"TG BH", "Cong suat"
			);
		return "\nHang Dien May\n" + infoChung + infoRieng;
	}
}
