public class Ghe extends CoSoVatChat {
    private boolean coTuaGhe;

    public Ghe(String ma, ChatLieu chatLieu, KichCo kichCo, int soChan, boolean coTuaGhe) {
        super(ma, chatLieu, kichCo, soChan);
        setCoTuaGhe(coTuaGhe);
    }

    public boolean isCoTuaGhe() {
        return coTuaGhe;
    }

    public void setCoTuaGhe(boolean coTuaGhe) {
        this.coTuaGhe = coTuaGhe;
    }

    @Override
    public double canNang() {
        return getSoChan() * 10 + (coTuaGhe ? 20 : 0);
    }
}
