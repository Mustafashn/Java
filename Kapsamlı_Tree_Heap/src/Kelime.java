public class Kelime {
    private int sayac;
    private String icerik;

    public Kelime(String icerik) {
        this.sayac = 1;
        this.icerik = icerik;
    }

    public int getSayac() {
        return sayac;
    }

    public void setSayac(int sayac) {
        this.sayac = sayac;
    }

    public String getIcerik() {
        return icerik;
    }

    public void setIcerik(String icerik) {
        this.icerik = icerik;
    }
}
