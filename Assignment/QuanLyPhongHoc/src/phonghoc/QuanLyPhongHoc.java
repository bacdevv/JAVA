package phonghoc;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class QuanLyPhongHoc implements IQuanLyPhongHoc {
    private List<PhongHoc> danhSach;

    public QuanLyPhongHoc() {
        this.danhSach = new ArrayList<>();
    }

    @Override
    public boolean themPhongHoc(PhongHoc p) {
        boolean daTonTai = danhSach.stream()
                .anyMatch(ph -> ph.getMaPhong().equalsIgnoreCase(p.getMaPhong()));
        
        if (daTonTai) return false;
        return danhSach.add(p);
    }

    @Override
    public PhongHoc timPhongHoc(String maPhong) {
        return danhSach.stream()
                .filter(p -> p.getMaPhong().equalsIgnoreCase(maPhong))
                .findFirst()
                .orElse(null);
    }

    @Override
    public void inDanhSach() {
        if (danhSach.isEmpty()) {
            System.out.println("Danh sách trống.");
        } else {
            danhSach.forEach(System.out::println);
        }
    }

    @Override
    public List<PhongHoc> layDsDatChuan() {
        return danhSach.stream()
                .filter(PhongHoc::datChuan)
                .collect(Collectors.toList());
    }

    @Override
    public void sapXepTheoDayNha() {
        danhSach.sort(Comparator.comparing(PhongHoc::getDayNha));
    }

    @Override
    public void sapXepTheoDienTich() {
        danhSach.sort(Comparator.comparingDouble(PhongHoc::getDienTich).reversed());
    }

    @Override
    public void sapXepTheoBongDen() {
        danhSach.sort(Comparator.comparingInt(PhongHoc::getSoBongDen));
    }

    @Override
    public boolean capNhatSoMayTinh(String maPhong, int soMayMoi) {
        PhongHoc ph = timPhongHoc(maPhong);
        if (ph instanceof PhongMayTinh pmt) {
            pmt.setSoMayTinh(soMayMoi);
            return true;
        }
        return false;
    }

    @Override
    public boolean xoaPhongHoc(String maPhong) {
        PhongHoc ph = timPhongHoc(maPhong);
        if (ph != null) {
            return danhSach.remove(ph);
        }
        return false;
    }

    @Override
    public int tongSoPhong() {
        return danhSach.size();
    }

    @Override
    public List<PhongMayTinh> layDsMayTinh60May() {
        return danhSach.stream()
                .filter(p -> p instanceof PhongMayTinh)
                .map(p -> (PhongMayTinh) p)
                .filter(pmt -> pmt.getSoMayTinh() == 60)
                .collect(Collectors.toList());
    }
}