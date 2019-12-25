package com.rtcrack.firebase.firestore;

import java.util.Date;

public class User {
    private String nama;
    private String alamat;
    private String kelamin;
    private String waktu;

    public User(){}

    public User(String nama, String alamat, String kelamin, String waktu){
        this.nama=nama;
        this.alamat=alamat;
        this.kelamin=kelamin;
        this.waktu=waktu;
    }

    public String getWaktu(){
        return this.waktu;
    }

    public String getNama(){
        return this.nama;
    }

    public String getAlamat(){
        return this.alamat;
    }

    public String getKelamin(){
        return this.kelamin;
    }
}
