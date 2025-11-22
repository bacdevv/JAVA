package thuvien;

import java.time.LocalDate;

public class SachGiaoKhoa extends Sach {
	private TinhTrangSach tinhTrang;

	public SachGiaoKhoa(String maSach, LocalDate ngayNhap, double donGia,
			int soLuong, String nhaXuatBan, TinhTrangSach tinhTrang) {
		super(maSach, ngayNhap, donGia, soLuong, nhaXuatBan);
		this.tinhTrang = tinhTrang;
	}

	public TinhTrangSach getTinhTrang() {
		return tinhTrang;
	}

	public void setTinhTrang(TinhTrangSach tinhTrang) {
		this.tinhTrang = tinhTrang;
	}

	@Override
	public double thanhTien() {
		return TinhTrangSach.CU == tinhTrang ? soLuong * donGia * 0.5 : soLuong * donGia; 
	}
	
	@Override
	public String toString() {
		return super.toString() + String.format("| %s", tinhTrang);
	}
}
