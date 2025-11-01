public abstract class CoSoVatChat {
    private String ma;
    private ChatLieu chatLieu;
    private KichCo kichCo;
    private int soChan;
    public abstract double canNang();
    
    public CoSoVatChat(String ma, ChatLieu chatLieu, KichCo kichCo, int soChan) {
        setMa(ma);
        setChatLieu(chatLieu);
        setKichCo(kichCo);
        setSoChan(soChan);
    }
    public String getMa() {
        return ma;
    }
    public void setMa(String ma) {
        if (ma == null || ma.isEmpty()) throw new IllegalArgumentException("Ma khong duoc rong");
        this.ma = ma;
    }
    public ChatLieu getChatLieu() {
        return chatLieu;
    }
    public void setChatLieu(ChatLieu chatLieu) {
        if (chatLieu == null) throw new IllegalArgumentException("Chat lieu khong duoc rong");
        this.chatLieu = chatLieu;
    }
    public KichCo getKichCo() {
        return kichCo;
    }
    public void setKichCo(KichCo kichCo) {
        if (kichCo == null) throw new IllegalArgumentException("Kich co khong duoc rong");
        this.kichCo = kichCo;
    }
    public int getSoChan() {
        return soChan;
    }
    public void setSoChan(int soChan) {
        if (soChan <= 0) throw new IllegalArgumentException("So chan phai lon hon 0");
        this.soChan = soChan;
    }

    @Override
    public String toString() {
        return String.format("Mã: %s, Chất liệu: %s, Kích cỡ: %s, Số chân: %d, Cân nặng: %.2f",
                ma, chatLieu, kichCo, soChan, canNang());
    }
}
