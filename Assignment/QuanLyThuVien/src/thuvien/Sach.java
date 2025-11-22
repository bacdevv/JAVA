package thuvien;

import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public abstract class Sach {
	protected final String maSach;
	protected LocalDate ngayNhap;
	protected double donGia;
	protected int soLuong;
	protected String nhaXuatBan;
	
	public abstract double thanhTien();

	public Sach(String maSach, LocalDate ngayNhap, double donGia, int soLuong,
			String nhaXuatBan) {
		this.maSach = maSach;
		this.ngayNhap = ngayNhap;
		this.donGia = donGia;
		this.soLuong = soLuong;
		this.nhaXuatBan = nhaXuatBan;
	}

	public LocalDate getNgayNhap() {
		return ngayNhap;
	}

	public void setNgayNhap(LocalDate ngayNhap) {
		this.ngayNhap = ngayNhap;
	}

	public double getDonGia() {
		return donGia;
	}

	public void setDonGia(double donGia) {
		this.donGia = donGia;
	}

	public int getSoLuong() {
		return soLuong;
	}

	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}

	public String getNhaXuatBan() {
		return nhaXuatBan;
	}

	public void setNhaXuatBan(String nhaXuatBan) {
		this.nhaXuatBan = nhaXuatBan;
	}

	public String getMaSach() {
		return maSach;
	}
	
	@Override
	public String toString() {
		NumberFormat nb = NumberFormat.getCurrencyInstance(Locale.forLanguageTag("vi-VN"));
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		
		return String.format("%-5s | %-5s | %-17s | %-5s | %-25s | %-20s",
					maSach,
					dtf.format(ngayNhap),
					nb.format(donGia),
					soLuong,
					nhaXuatBan,
					nb.format(thanhTien())
				);
	}
	
	public static String inTieuDe() {
		return String.format("%-5s | %-10s | %-17s | %-5s | %-25s | %-20s", 
					"mã",
					"ngày nhập",
					"đơn giá",
					"SL",
					"nhà xuất bản",
					"thành tiền"
				).toUpperCase();
	}
}
