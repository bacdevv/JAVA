package TranVietBac_24681721;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class HangThucPham extends HangHoa {
	private String nhaCungCap;
	private LocalDate ngaySanXuat;
	private LocalDate ngayHetHan;
	
	public HangThucPham(String maHang, String tenHang, int soLuongTon, double donGia, String nhaCungCap,
			LocalDate ngaySanXuat, LocalDate ngayHetHan) {
		super(maHang, tenHang, soLuongTon, donGia);
		setNhaCungCap(nhaCungCap);
		setNgaySanXuat(ngaySanXuat);
		setNgayHetHan(ngayHetHan);
	}

	public String getNhaCungCap() {
		return nhaCungCap;
	}

	public void setNhaCungCap(String nhaCungCap) {
		if (nhaCungCap == null || nhaCungCap.trim().isEmpty()) {
			throw new IllegalArgumentException("Nha cung cap khong duoc rong");
		}
		this.nhaCungCap = nhaCungCap;
	}

	public LocalDate getNgaySanXuat() {
		return ngaySanXuat;
	}

	public void setNgaySanXuat(LocalDate ngaySanXuat) {
		if (ngayHetHan != null && ngaySanXuat.isAfter(ngayHetHan)) {
			throw new IllegalArgumentException("Ngay san xuat phai truoc ngay het han");
		}
		this.ngaySanXuat = ngaySanXuat;
	}

	public LocalDate getNgayHetHan() {
		return ngayHetHan;
	}

	public void setNgayHetHan(LocalDate ngayHetHan) {
		if (ngaySanXuat != null && ngayHetHan.isBefore(ngaySanXuat)) {
			throw new IllegalArgumentException("Ngay het han phai sau ngay san xuat");
		}
		this.ngayHetHan = ngayHetHan;
	}

	@Override
	public double tinhVAT() {
		return 0.05;
	}

	@Override
	public MucDoBuonBan mucDoBuonBan() {
		if (soLuongTon > 0 && ngayHetHan.isBefore(ngaySanXuat)) {
			return MucDoBuonBan.KHOBAN;
		}
		return MucDoBuonBan.KHONGDANHGIA;
	}
	
	@Override
	public String toString() {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		
		String infoChung = String.format("%s", super.toString());
		String infoRieng = String.format("%-20s %-15s %-15s",
					nhaCungCap,
					dtf.format(ngaySanXuat),
					dtf.format(ngayHetHan)
				);
		System.out.printf("%-20s %-15s %-15s",
				"NCC", "Ngay SX", "Ngay HH"
			);
		return "\nHang Thuc Pham\n" + infoChung + infoRieng;
	}
	
	
}
