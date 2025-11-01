package TranVietBac_24681721;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class HangSanhSu extends HangHoa {
	private String nhaSanXuat;
	private LocalDate ngayNhapKho;
	public HangSanhSu(String maHang, String tenHang, int soLuongTon, double donGia, String nhaSanXuat,
			LocalDate ngayNhapKho) {
		super(maHang, tenHang, soLuongTon, donGia);
		this.nhaSanXuat = nhaSanXuat;
		this.ngayNhapKho = ngayNhapKho;
	}
	
	public String getNhaSanXuat() {
		return nhaSanXuat;
	}
	public void setNhaSanXuat(String nhaSanXuat) {
		if (nhaSanXuat == null || nhaSanXuat.trim().isEmpty()) {
			throw new IllegalArgumentException("Nha san xuat khong duoc rong");
		}
		this.nhaSanXuat = nhaSanXuat;
	}
	public LocalDate getNgayNhapKho() {
		return ngayNhapKho;
	}
	public void setNgayNhapKho(LocalDate ngayNhapKho) {
		if (ngayNhapKho == null) {
			throw new IllegalArgumentException("Ngay nhap kho khong duoc rong");
		}
		this.ngayNhapKho = ngayNhapKho;
	}

	@Override
	public double tinhVAT() {
		return 0.1;
	}

	@Override
	public MucDoBuonBan mucDoBuonBan() {
		long thoiGianLuuKho = ChronoUnit.DAYS.between(ngayNhapKho, LocalDate.now());
		
		if (soLuongTon > 50 && thoiGianLuuKho > 10) {
			return MucDoBuonBan.BANCHAM;
		}
		return MucDoBuonBan.KHONGDANHGIA;
	}
	
	@Override
	public String toString() {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");

		String infoChung = String.format("%s", super.toString());
		String infoRieng = String.format("%-20s %-15s",
					nhaSanXuat,
					dtf.format(ngayNhapKho)
				);
		System.out.printf("%-20s %-15s",
				"Nha SX", "Ngay NK"
			);
		return "\nHang Sanh Su\n" + infoChung + infoRieng;
	}
}
