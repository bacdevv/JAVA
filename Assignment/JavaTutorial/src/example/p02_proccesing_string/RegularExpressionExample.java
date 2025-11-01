package example.p02_proccesing_string;

import java.util.regex.Pattern;

public class RegularExpressionExample {
	
	public static void main(String[] args) {
		// CÁC THAO TÁC VỚI BIỂU THỨC CHÍNH QUY
		// 1. CHUỖI KIỂM TRA : testString
		// 2. CHUỖI BIỂU THỨC CHÍNH QUY : regexString
		// 3. CHUỖI BIỂU THỨC CHÍNH QUY ĐÃ ĐƯỢC BIÊN DỊCH : Pattern object ~ Pattern.compile(regexString)
		// 4. BỘ SO KHỚP : Matcher object ~ patternObject.matcher(testString)
		// 5. Matcher object HỖ TRỢ CÁC PHƯƠNG THỨC SAU:
		// + lookingAt() : KIỂM TRA SO KHỚP Ở ĐẦU CHUỖI testString
		// + find() : KIỂM TRA SO KHỚP TỪNG CHUỖI CON KẾ TIẾP TRONG CHUỖI testString
		// + matches() : KIỂM TRA SO KHỚP VỚI TOÀN BỘ CHUỖI testString
		// + start() : TRẢ VỀ VỊ TRÍ BẮT ĐẦU CỦA CHUỖI CON SO KHỚP
		// + end() : TRẢ VỀ VỊ TRÍ KẾT THÚC CỦA CHUỖI CON SO KHỚP
		// + replaceFirst() : THAY THẾ CHUỖI CON SO KHỚP ĐẦU TIÊN BẰNG CHUỖI THAY THẾ
		// + replaceAll() : THAY THẾ TẤT CẢ CHUỖI CON SO KHỚP BẰNG CHUỖI THAY THẾ
		
		
		String[] emailTests = {
				"alice@example.com.vn",
	            "bob@gmail.com",
	            "charlie@yahoo.com",
	            "david@outlook.com",
	            "eva13 @company.org"
		};
		String emailRegex =  "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+[.][A-Za-z]{2,6}$";
		Pattern emailPattern = Pattern.compile(emailRegex);
		for (String test : emailTests) {
			System.out.printf("%-5b | %s\n", emailPattern.matcher(test).matches(), test);
		}
		
		System.out.println("--------------------");
		
		String[] phoneNumberTests = {
				"0987654321",
				"987654321",
				"+84987654321",
				"+84 987654321",
				"+84-987654321",
				"84987654321",
				"12345678",
				"A12345678",
		};
		String phoneNumberRegex= "^([+]?\\d{1,3}[- ]?)?(0?\\d{9,10})$";
		Pattern phoneNumberPattern = Pattern.compile(phoneNumberRegex);
		for (String test : phoneNumberTests) {
			System.out.printf("%-5b | %s\n", phoneNumberPattern.matcher(test).matches(), test);
		}
		
		System.out.println("--------------------");
		
		String[] fullNameTests = {
				"Phạm Thanh Phong",
				"Trần Tiến",
				"Nguyễn A Long",
				"nguyễn hoàng Vân",
				"Lê Hoàng Ngọc Diệp",
				"Phạm 1Toàn",
				"Võ Văn Vương2",
				"Kha"
		};
		String fullNameRegex= "^\\p{Lu}\\p{Ll}*(?:\\s\\p{Lu}\\p{Ll}*)+$";
		Pattern fullNamePattern = Pattern.compile(fullNameRegex);
		for (String test : fullNameTests) {
			System.out.printf("%-5b | %s\n", fullNamePattern.matcher(test).matches(), test);
		}
		
	}
}
