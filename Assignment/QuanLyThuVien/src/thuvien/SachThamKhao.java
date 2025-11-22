package thuvien;

import java.text.DecimalFormat;
import java.time.LocalDate;

public class SachThamKhao extends Sach {
	private double thue;

	public SachThamKhao(String maSach, LocalDate ngayNhap, double donGia,
			int soLuong, String nhaXuatBan, double thue) {
		super(maSach, ngayNhap, donGia, soLuong, nhaXuatBan);
		this.thue = thue;
	}

	public double getThue() {
		return thue;
	}

	public void setThue(double thue) {
		this.thue = thue;
	}

	@Override
	public double thanhTien() {
		double tienCoThue = thue * donGia;
		return soLuong * donGia + tienCoThue;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		DecimalFormat df = new DecimalFormat("0.00");
		return super.toString() + String.format("| %s", df.format(thue) + "%");
	}
}
