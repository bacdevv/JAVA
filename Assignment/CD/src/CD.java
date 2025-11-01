import java.text.NumberFormat;
import java.util.Locale;

public class CD {
    // 1. Attributes - Khai báo private để đóng gói
    private int maCD;
    private String tuaCD;
    private int soBaiHat;
    private double giaThanh;

    // 2. Constructors - Phương thức khởi tạo
    // Constructor mặc định
    public CD() {
        this.maCD = 999999;
        this.tuaCD = "chưa xác định";
        this.soBaiHat = 1; // Giá trị mặc định hợp lệ
        this.giaThanh = 1.0; // Giá trị mặc định hợp lệ
    }

    // Constructor có tham số
    public CD(int maCD, String tuaCD, int soBaiHat, double giaThanh) {
        // Gọi các hàm set để tận dụng lại việc kiểm tra dữ liệu
        setMaCD(maCD);
        setTuaCD(tuaCD);
        setSoBaiHat(soBaiHat);
        setGiaThanh(giaThanh);
    }

    // 3. Getters and Setters - Cổng giao tiếp với thuộc tính private
    public int getMaCD() {
        return maCD;
    }

    public void setMaCD(int maCD) {
        if (maCD > 0) {
            this.maCD = maCD;
        } else {
            this.maCD = 999999; // Giá trị mặc định
        }
    }

    public String getTuaCD() {
        return tuaCD;
    }

    public void setTuaCD(String tuaCD) {
        if (tuaCD != null && !tuaCD.trim().isEmpty()) {
            this.tuaCD = tuaCD;
        } else {
            this.tuaCD = "chưa xác định";
        }
    }

    public int getSoBaiHat() {
        return soBaiHat;
    }

    public void setSoBaiHat(int soBaiHat) {
        if (soBaiHat > 0) {
            this.soBaiHat = soBaiHat;
        } else {
            this.soBaiHat = 1; // Giá trị mặc định hợp lệ tối thiểu
        }
    }

    public double getGiaThanh() {
        return giaThanh;
    }

    public void setGiaThanh(double giaThanh) {
        if (giaThanh > 0) {
            this.giaThanh = giaThanh;
        } else {
            this.giaThanh = 1.0; // Giá trị mặc định hợp lệ tối thiểu
        }
    }

    // 4. Override toString() method
    @Override
    public String toString() {
        // Định dạng tiền tệ cho đẹp
        Locale localeVN = new Locale("vi", "VN");
        NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance(localeVN);
        String formattedPrice = currencyFormatter.format(giaThanh);

        return String.format("%-10d %-30s %-15d %-20s", maCD, tuaCD, soBaiHat, formattedPrice);
    }
}