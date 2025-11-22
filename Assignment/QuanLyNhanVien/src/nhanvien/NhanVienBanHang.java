package nhanvien;

import java.text.NumberFormat;
import java.util.Locale;

public class NhanVienBanHang extends NhanVien{
	private double doanhSoBan;

	public NhanVienBanHang(String maNhanVien, String hoTen, String dienThoai,
			double luongCanBan, double doanhSoBan) {
		super(maNhanVien, hoTen, dienThoai, luongCanBan);
		setDoanhSoban(doanhSoBan);
	}

	public double getDoanhSoban() {
		return doanhSoBan;
	}

	public void setDoanhSoban(double doanhSoBan) {
		if (doanhSoBan < 0)
			throw new IllegalArgumentException("Doanh so ban phai >= 0");
		this.doanhSoBan = doanhSoBan;
	}

	@Override
	public double tienLuong() {
		return doanhSoBan > 20000000 ? luongCanBan + (0.03 * doanhSoBan) : luongCanBan;
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
