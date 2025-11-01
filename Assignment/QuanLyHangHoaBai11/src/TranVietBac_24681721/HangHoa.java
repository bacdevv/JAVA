package TranVietBac_24681721;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;

public abstract class HangHoa {
	protected final String maHang;
	protected String tenHang;
	protected int soLuongTon;
	protected double donGia;
	
	public HangHoa(String maHang, String tenHang, int soLuongTon, double donGia) {
		if (maHang == null || maHang.trim().isEmpty()) {
			throw new IllegalArgumentException("Ma hang khong duoc de trong");
		}
		
		this.maHang = maHang;
		setTenHang(tenHang);
		setSoLuongTon(soLuongTon);
		setDonGia(donGia);
	}
	
	public String getMaHang() {
		return maHang;
	}

	public String getTenHang() {
		return tenHang;
	}
	public void setTenHang(String tenHang) {
		if (tenHang == null || tenHang.trim().isEmpty()) {
			throw new IllegalArgumentException("Ten hang khong duoc de trong");
		}
		this.tenHang = tenHang;
	}
	public int getSoLuongTon() {
		return soLuongTon;
	}
	public void setSoLuongTon(int soLuongTon) {
		if (soLuongTon < 0) {
			throw new IllegalArgumentException("So luong ton phai >= 0");	
		}
		this.soLuongTon = soLuongTon;
	}
	public double getDonGia() {
		return donGia;
	}
	public void setDonGia(double donGia) {
		if (donGia <= 0) {
			throw new IllegalArgumentException("Don gia phai > 0");
		}
		this.donGia = donGia;
	}
	
	
	public abstract double tinhVAT();
	public abstract MucDoBuonBan mucDoBuonBan();
	
	@Override
	public String toString() {
		NumberFormat nf = NumberFormat.getCurrencyInstance(Locale.forLanguageTag("vi-VN"));
		DecimalFormat df = new DecimalFormat("0.00%");
		System.out.printf("%-10s %-20s %-10s %-15s %-10s %-20s",
					"Ma Hang", "Ten Hang", "SLT", "Don Gia", "VAT", "Muc Do"
				);
		
		return String.format("%-10s %-20s %-10s %-15s %-10s %-20s",
					maHang,
					tenHang,
					soLuongTon,
					nf.format(donGia),
					df.format(tinhVAT()),
					mucDoBuonBan()
				);
	}
}
