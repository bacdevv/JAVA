package LeTrongNghia_24672691_37;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class HoiThao {
	// Thuộc tính
	private String maTour;
	private String tenTour;
	private String huongDanVien;
	private LocalDate ngayKH;
	private int soNgay;
	private long giaTour;
	
	// Constructor mặc định
	public HoiThao() {
	}
	
	// Constructor đầy đủ
	public HoiThao(String maTour, String tenTour, String huongDanVien, LocalDate ngayKH, int soNgay, long giaTour) {
		this.maTour = maTour;
		this.tenTour = tenTour;
		this.huongDanVien = huongDanVien;
		this.ngayKH = ngayKH;
		this.soNgay = soNgay;
		this.giaTour = giaTour;
	}
	
	// Getter
	public String getMaTour() {
		return maTour;
	}
	
	public String getTenTour() {
		return tenTour;
	}
	
	public String getHuongDanVien() {
		return huongDanVien;
	}
	
	public LocalDate getNgayKH() {
		return ngayKH;
	}
	
	public int getSoNgay() {
		return soNgay;
	}
	
	public long getGiaTour() {
		return giaTour;
	}
	
	// Setter
	public void setMaTour(String maTour) {
		this.maTour = maTour;
	}
	
	public void setTenTour(String tenTour) {
		this.tenTour = tenTour;
	}
	
	public void setHuongDanVien(String huongDanVien) {
		this.huongDanVien = huongDanVien;
	}
	
	public void setNgayKH(LocalDate ngayKH) {
		this.ngayKH = ngayKH;
	}
	
	public void setSoNgay(int soNgay) {
		this.soNgay = soNgay;
	}
	
	public void setGiaTour(long giaTour) {
		this.giaTour = giaTour;
	}
	
	// toString
	public String toString() {
		DateTimeFormatter dft = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		String ngayStr = dft.format(ngayKH);
		return String.format("%-10s | %-15s | %-25s | %-12s | %5d | %,12d",
				maTour, tenTour, huongDanVien, ngayStr, soNgay, giaTour);
	}
}
