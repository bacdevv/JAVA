package nhanvien;

import java.text.NumberFormat;
import java.util.Locale;

public abstract class NhanVien {
	protected final String maNhanVien;
	protected String hoTen;
	protected String dienThoai;
	protected double luongCanBan = 1800000;
	
	public NhanVien(String maNhanVien, String hoTen, String dienThoai,
			double luongCanBan) {
		this.maNhanVien = maNhanVien;
		setHoTen(hoTen);
		setDienThoai(dienThoai);
		setLuongCanBan(luongCanBan);
	}
	
	public String getHoTen() {
		return hoTen;
	}
	
	public void setHoTen(String hoTen) {
		if (hoTen == null || hoTen.trim().isEmpty())
			throw new IllegalArgumentException("Ho ten khong duoc rong");
		this.hoTen = hoTen;
	}
	
	public String getDienThoai() {
		return dienThoai;
	}
	
	public void setDienThoai(String dienThoai) {
		if (dienThoai == null || dienThoai.trim().isEmpty())
			throw new IllegalArgumentException("So dien thoai khong duoc rong");
		this.dienThoai = dienThoai;
	}
	
	public double getLuongCanBan() {
		return luongCanBan;
	}
	
	public void setLuongCanBan(double luongCanBan) {
		if (luongCanBan < 0)
			throw new IllegalArgumentException("Luong can ban phai > 0");
		this.luongCanBan = luongCanBan;
	}
	
	public String getMaNhanVien() {
		return maNhanVien;
	}
	
	public abstract double tienLuong();
	
	@Override
	public String toString() {
		NumberFormat nb = NumberFormat.getCurrencyInstance(Locale.forLanguageTag("vi-VN"));
		
		return String.format("%s | %-25s | %-10s | %-15s |",
					maNhanVien,
					hoTen,
					dienThoai,
					nb.format(luongCanBan)
				);
	}
}
