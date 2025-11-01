import java.util.Scanner;

public class KiemNghiem {
    private static Scanner scanner = new Scanner(System.in);
    private static DanhSachCD danhSach;
    
    public static void main(String[] args) {
        // Khởi tạo danh sách CD với kích thước tối đa
        System.out.print("Nhap kich thuoc toi da cua danh sach CD (hoac Enter de dung 10): ");
        String input = scanner.nextLine();
        int kichThuoc = input.isEmpty() ? 10 : Integer.parseInt(input);
        danhSach = new DanhSachCD(kichThuoc);
        
        // Thêm dữ liệu mẫu
        taoDataMau();
        
        int luaChon;
        do {
            xuatMenu();
            System.out.print("Nhap lua chon cua ban: ");
            luaChon = scanner.nextInt();
            scanner.nextLine(); // Đọc bỏ dòng trống
            
            switch (luaChon) {
                case 1:
                    themCD();
                    break;
                case 2:
                    hienThiSoLuongCD();
                    break;
                case 3:
                    hienThiTongGiaThanh();
                    break;
                case 4:
                    xuatDanhSach();
                    break;
                case 5:
                    sapXepGiamDanTheoGia();
                    break;
                case 6:
                    sapXepTangDanTheoTua();
                    break;
                case 0:
                    System.out.println("Cam on ban da su dung chuong trinh!");
                    break;
                default:
                    System.out.println("Lua chon khong hop le! Vui long chon lai.");
            }
            
            if (luaChon != 0) {
                System.out.println("\nNhan Enter de tiep tuc...");
                scanner.nextLine();
            }
            
        } while (luaChon != 0);
        
        scanner.close();
    }
    
    private static void taoDataMau() {
        System.out.println("Dang tao du lieu mau...");
        
        // Tạo một số CD mẫu
        CD cd1 = new CD(1001, "Album Pop Hits", 12, 250000);
        CD cd2 = new CD(1002, "Rock Legends", 15, 300000);
        CD cd3 = new CD(1003, "Classical Masters", 8, 180000);
        CD cd4 = new CD(1004, "Jazz Collection", 10, 220000);
        CD cd5 = new CD(1005, "Acoustic Sessions", 14, 280000);
        
        // Thêm vào danh sách
        danhSach.themCD(cd1);
        danhSach.themCD(cd2);
        danhSach.themCD(cd3);
        danhSach.themCD(cd4);
        danhSach.themCD(cd5);
        
        System.out.println("Da them " + danhSach.getSoLuongCD() + " CD mau vao danh sach.");
        System.out.println("Ban co the them CD moi hoac thao tac voi du lieu co san.");
    }
    
    private static void xuatMenu() {
        System.out.println("\n" + "=".repeat(50));
        System.out.println("         CHUONG TRINH QUAN LY CD");
        System.out.println("=".repeat(50));
        System.out.println("1. Them CD moi");
        System.out.println("2. Xem so luong CD");
        System.out.println("3. Tinh tong gia thanh");
        System.out.println("4. Xuat danh sach CD");
        System.out.println("5. Sap xep giam dan theo gia thanh");
        System.out.println("6. Sap xep tang dan theo tua CD");
        System.out.println("0. Thoat");
        System.out.println("=".repeat(50));
    }
    
    private static void themCD() {
        System.out.println("\n--- THEM CD MOI ---");
        
        System.out.print("Nhap ma CD (>0): ");
        int maCD = scanner.nextInt();
        scanner.nextLine(); // Đọc bỏ dòng trống
        
        System.out.print("Nhap tua CD: ");
        String tuaCD = scanner.nextLine();
        
        System.out.print("Nhap so bai hat (>0): ");
        int soBaiHat = scanner.nextInt();
        
        System.out.print("Nhap gia thanh (>0): ");
        double giaThanh = scanner.nextDouble();
        
        // Tạo đối tượng CD mới
        CD cd = new CD(maCD, tuaCD, soBaiHat, giaThanh);
        
        // Thêm vào danh sách
        danhSach.themCD(cd);
    }
    
    private static void hienThiSoLuongCD() {
        System.out.println("\n--- SO LUONG CD ---");
        System.out.println("Hien tai co " + danhSach.getSoLuongCD() + " CD trong danh sach.");
    }
    
    private static void hienThiTongGiaThanh() {
        System.out.println("\n--- TONG GIA THANH ---");
        System.out.printf("Tong gia thanh cua tat ca CD: %.2f VND%n", danhSach.tinhTongGiaThanh());
    }
    
    private static void xuatDanhSach() {
        System.out.println("\n--- DANH SACH CD ---");
        danhSach.xuatDanhSach();
    }
    
    private static void sapXepGiamDanTheoGia() {
        System.out.println("\n--- SAP XEP GIAM DAN THEO GIA ---");
        danhSach.sapXepGiamDanTheoGia();
        danhSach.xuatDanhSach();
    }
    
    private static void sapXepTangDanTheoTua() {
        System.out.println("\n--- SAP XEP TANG DAN THEO TUA ---");
        danhSach.sapXepTangDanTheoTua();
        danhSach.xuatDanhSach();
    }
}