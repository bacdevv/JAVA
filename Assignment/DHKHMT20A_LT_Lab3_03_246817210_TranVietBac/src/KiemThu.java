public class KiemThu {
    public static void main(String[] args) {
        Ban ban = new Ban("B001", ChatLieu.GO, KichCo.LON, 4, 2.0, 1.0);
        System.out.println(ban);

        Ghe ghe1 = new Ghe("G001", ChatLieu.NHUA, KichCo.VUA, 4, true);
        Ghe ghe2 = new Ghe("G002", ChatLieu.KIMLOAI, KichCo.NHO, 3, false);

        System.out.println(ghe1);
        System.out.println(ghe2);
    }
}
