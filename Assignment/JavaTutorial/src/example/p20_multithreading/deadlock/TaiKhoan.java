package example.p20_multithreading.deadlock;

public class TaiKhoan {
	int tongTien = 10000;
	
	public int getTongTien() {
		return tongTien;
	}

	public void guiTien(int tienGui) {
		this.tongTien += tienGui;
	}
	public void rutTien(int tienRut) {
		this.tongTien -= tienRut;
	}
	
	public void doGiaoDich(TaiKhoan tkGui, TaiKhoan tkRut, int soTien) {
		tkGui.guiTien(soTien);
		tkRut.rutTien(soTien);
	}
	
}
