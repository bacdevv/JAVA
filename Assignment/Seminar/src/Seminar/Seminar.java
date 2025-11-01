package Seminar;

import java.time.LocalDate;

public class Seminar {
    private String maTour;
    private String tenDiaDiem;
    private String huongDanVien;
    private long giaTour;
    private int soNgay;
    private LocalDate ngayKH;

    public Seminar() {

    }

    public Seminar(String maTour, String tenDiaDiem, String huongDanVien, long giaTour, int soNgay, LocalDate ngayKH) {
        this.maTour = maTour;
        this.tenDiaDiem = tenDiaDiem;
        this.huongDanVien = huongDanVien;
        this.giaTour = giaTour;
        this.soNgay = soNgay;
        this.ngayKH = ngayKH;
    }

    public String getMaTour() {
        return maTour;
    }

    public void setMaTour(String maTour) {
        if (maTour == null || maTour.trim().isEmpty()) {
            throw new IllegalArgumentException("Ma khong duoc rong");
        }
        else {
            this.maTour = maTour;
        }
    }

    public String getTenDiaDiem() {
        return tenDiaDiem;
    }

    public void setTenDiaDiem(String tenDiaDiem) {
        if (tenDiaDiem == null || tenDiaDiem.trim().isEmpty()) {
            throw new IllegalArgumentException("Ten dia diem khong duoc rong");
        }
        else {
            this.tenDiaDiem = tenDiaDiem;
        }
    }

    public String getHuongDanVien() {
        return huongDanVien;
    }

    public void setHuongDanVien(String huongDanVien) {
        this.huongDanVien = huongDanVien;
    }

    public long getGiaTour() {
        return giaTour;
    }

    public void setGiaTour(long giaTour) {
        this.giaTour = giaTour;
    }

    public int getSoNgay() {
        return soNgay;
    }

    public void setSoNgay(int soNgay) {
        this.soNgay = soNgay;
    }

    public LocalDate getNgayKH() {
        return ngayKH;
    }

    public void setNgayKH(LocalDate ngayKH) {
        this.ngayKH = ngayKH;
    }

    
}