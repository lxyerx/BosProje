package com.example.bosproje;

public class insan {
    private String ad;
    private String soyad;
    private String id;

    public insan() {
        // Boş yapıcı metod
    }

    public insan(String id, String ad, String soyad) {
        this.ad = ad;
        this.soyad = soyad;
        this.id = id;
    }

    public String getAd() {
        return ad;
    }

    public void setAd(String ad) {
        this.ad = ad;
    }

    public String getSoyad() {
        return soyad;
    }

    public void setSoyad(String soyad) {
        this.soyad = soyad;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}




