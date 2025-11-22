package nhanvien;

import java.text.NumberFormat;
import java.util.Locale;

public class NhanVienVanPhong extends NhanVien {
	private double heSoLuong;

	public NhanVienVanPhong(String maNhanVien, String hoTen, String dienThoai,
			double luongCanBan, double heSoLuong) {
		super(maNhanVien, hoTen, dienThoai, luongCanBan);
		setHeSoLuong(heSoLuong);
	}

	public double getHeSoLuong() {
		return heSoLuong;
	}

	public void setHeSoLuong(double heSoLuong) {
		if (heSoLuong < 1.86 || heSoLuong > 8.69)
			throw new IllegalArgumentException("He so luong phai >= 1.86 va <= 8.69");
		this.heSoLuong = heSoLuong;
	}

	@Override
	public double tienLuong() {
		return luongCanBan * heSoLuong;
	}
	
	@Override
	public String toString() {
        NumberFormat nb = NumberFormat.getCurrencyInstance(Locale.forLanguageTag("vi-VN"));

		return String.format("%s %s",
					super.toString(),
					nb.format(tienLuong())
				);
	}
}
