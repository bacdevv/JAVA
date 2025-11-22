package phonghoc;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Sử dụng Interface để khai báo biến (Polymorphism)
        IQuanLyPhongHoc ql = new QuanLyPhongHoc(); 
        Scanner sc = new Scanner(System.in);

        // Mock data để test nhanh
        ql.themPhongHoc(new PhongLyThuyet("A101", "A", 100, 15, true));
        ql.themPhongHoc(new PhongMayTinh("B201", "B", 50, 10, 25));
        ql.themPhongHoc(new PhongMayTinh("B202", "B", 120, 20, 60));
        ql.themPhongHoc(new PhongThiNghiem("C301", "C", 80, 8, "Hoa Hoc", 40, true));

        int choice;
        do {
            System.out.println("\n--- QUẢN LÝ PHÒNG HỌC ĐẠI HỌC ---");
            System.out.println("1. Thêm phòng học");
            System.out.println("2. Tìm phòng học theo mã");
            System.out.println("3. In toàn bộ danh sách");
            System.out.println("4. In danh sách phòng đạt chuẩn");
            System.out.println("5. Sắp xếp tăng dần theo dãy nhà");
            System.out.println("6. Sắp xếp giảm dần theo diện tích");
            System.out.println("7. Sắp xếp tăng dần theo bóng đèn");
            System.out.println("8. Cập nhật số máy tính");
            System.out.println("9. Xóa phòng học");
            System.out.println("10. Tổng số phòng học");
            System.out.println("11. Liệt kê phòng máy có 60 máy");
            System.out.println("0. Thoát");
            System.out.print("Chọn chức năng: ");
            
            try {
                choice = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                choice = -1;
            }

            switch (choice) {
                case 1 -> nhapPhongHoc(ql, sc);
                case 2 -> {
                    System.out.print("Nhập mã phòng cần tìm: ");
                    String ma = sc.nextLine();
                    PhongHoc ph = ql.timPhongHoc(ma);
                    System.out.println(ph != null ? ph : "Không tìm thấy!");
                }
                case 3 -> ql.inDanhSach();
                case 4 -> {
                    System.out.println("--- DANH SÁCH ĐẠT CHUẨN ---");
                    ql.layDsDatChuan().forEach(System.out::println);
                }
                case 5 -> {
                    ql.sapXepTheoDayNha();
                    System.out.println("Đã sắp xếp theo dãy nhà.");
                    ql.inDanhSach();
                }
                case 6 -> {
                    ql.sapXepTheoDienTich();
                    System.out.println("Đã sắp xếp giảm dần diện tích.");
                    ql.inDanhSach();
                }
                case 7 -> {
                    ql.sapXepTheoBongDen();
                    System.out.println("Đã sắp xếp tăng dần bóng đèn.");
                    ql.inDanhSach();
                }
                case 8 -> {
                    System.out.print("Nhập mã phòng máy tính: ");
                    String ma = sc.nextLine();
                    System.out.print("Nhập số máy mới: ");
                    int soMay = Integer.parseInt(sc.nextLine());
                    if (ql.capNhatSoMayTinh(ma, soMay)) {
                        System.out.println("Cập nhật thành công.");
                    } else {
                        System.out.println("Không tìm thấy hoặc không phải phòng máy tính.");
                    }
                }
                case 9 -> {
                    System.out.print("Nhập mã phòng cần xóa: ");
                    String ma = sc.nextLine();
                    if (ql.timPhongHoc(ma) == null) {
                        System.out.println("Không tồn tại phòng này.");
                    } else {
                        System.out.print("Bạn có chắc chắn muốn xóa? (y/n): ");
                        String xacNhan = sc.nextLine();
                        if (xacNhan.equalsIgnoreCase("y")) {
                            ql.xoaPhongHoc(ma);
                            System.out.println("Đã xóa.");
                        } else {
                            System.out.println("Hủy thao tác xóa.");
                        }
                    }
                }
                case 10 -> System.out.println("Tổng số phòng: " + ql.tongSoPhong());
                case 11 -> {
                    System.out.println("--- PHÒNG MÁY CÓ 60 MÁY ---");
                    ql.layDsMayTinh60May().forEach(System.out::println);
                }
                case 0 -> System.out.println("Kết thúc chương trình.");
                default -> System.out.println("Lựa chọn không hợp lệ!");
            }
        } while (choice != 0);
    }

    // Thay đổi tham số đầu vào thành Interface
    private static void nhapPhongHoc(IQuanLyPhongHoc ql, Scanner sc) {
        System.out.println("Chọn loại: 1. Lý thuyết | 2. Máy tính | 3. Thí nghiệm");
        int loai = Integer.parseInt(sc.nextLine());
        
        System.out.print("Nhập mã phòng: "); String ma = sc.nextLine();
        System.out.print("Nhập dãy nhà: "); String day = sc.nextLine();
        System.out.print("Nhập diện tích: "); double dt = Double.parseDouble(sc.nextLine());
        System.out.print("Nhập số bóng đèn: "); int bong = Integer.parseInt(sc.nextLine());

        PhongHoc ph = null;
        switch (loai) {
            case 1 -> {
                System.out.print("Có máy chiếu? (true/false): ");
                boolean mc = Boolean.parseBoolean(sc.nextLine());
                ph = new PhongLyThuyet(ma, day, dt, bong, mc);
            }
            case 2 -> {
                System.out.print("Số máy tính: ");
                int soMay = Integer.parseInt(sc.nextLine());
                ph = new PhongMayTinh(ma, day, dt, bong, soMay);
            }
            case 3 -> {
                System.out.print("Chuyên ngành: "); String cn = sc.nextLine();
                System.out.print("Sức chứa: "); int scua = Integer.parseInt(sc.nextLine());
                System.out.print("Có bồn rửa? (true/false): ");
                boolean br = Boolean.parseBoolean(sc.nextLine());
                ph = new PhongThiNghiem(ma, day, dt, bong, cn, scua, br);
            }
            default -> System.out.println("Loại phòng không đúng.");
        }

        if (ph != null) {
            if (ql.themPhongHoc(ph)) System.out.println("Thêm thành công!");
            else System.out.println("Thêm thất bại (trùng mã).");
        }
    }
}