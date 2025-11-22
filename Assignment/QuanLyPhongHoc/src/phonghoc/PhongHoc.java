package phonghoc;

public abstract class PhongHoc {
	protected final String maPhong;
	protected String dayNha;
	protected double dienTich;
	protected int soBongDen;
	
	public PhongHoc(String maPhong, String dayNha, double dienTich,
			int soBongDen) {
		
		if (maPhong == null || maPhong.trim().isEmpty()) {
			throw new IllegalArgumentException("Ma phong khong duoc trong !");
		}
		
		this.maPhong = maPhong;
		this.dayNha = dayNha;
		this.dienTich = dienTich;
		this.soBongDen = soBongDen;
	}
	
	public boolean duAnhSang() {
		return (dienTich / soBongDen) <= 10;
	}
	
	public abstract boolean datChuan();
	
	public String getDayNha() {
		return dayNha;
	}

	public void setDayNha(String dayNha) {
		this.dayNha = dayNha;
	}

	public double getDienTich() {
		return dienTich;
	}

	public void setDienTich(double dienTich) {
		this.dienTich = dienTich;
	}

	public int getSoBongDen() {
		return soBongDen;
	}

	public void setSoBongDen(int soBongDen) {
		this.soBongDen = soBongDen;
	}

	public String getMaPhong() {
		return maPhong;
	}

	@Override
	public String toString() {
		return String.format("%s | %s | %s | %s",
					maPhong,
					dayNha,
					dienTich,
					soBongDen
				);
	}
	
}	