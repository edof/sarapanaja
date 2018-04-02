package com.edo.esarapan.model;

import java.io.Serializable;

/**
 * Created by Edo Firmansyah on 3/17/2018.
 */

public class AspirasiItem implements Serializable{

    private String id_aspirasi;
    private String nama;
    private String phonemail;
    private String uraian;
    private String jalan;
    private String rt;
    private String rw;
    private String kelurahan;
    private String kecamatan;
    private String created_at;
    private String kategori;

    public AspirasiItem(String id_aspirasi, String nama, String phonemail, String uraian, String jalan, String rt, String rw, String kelurahan, String kecamatan, String created_at, String kategori) {
        this.id_aspirasi = id_aspirasi;
        this.nama = nama;
        this.phonemail = phonemail;
        this.uraian = uraian;
        this.jalan = jalan;
        this.rt = rt;
        this.rw = rw;
        this.kelurahan = kelurahan;
        this.kecamatan = kecamatan;
        this.created_at = created_at;
        this.kategori = kategori;
    }

    public String getId_aspirasi() {
        return id_aspirasi;
    }

    public void setId_aspirasi(String id_aspirasi) {
        this.id_aspirasi = id_aspirasi;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getPhonemail() {
        return phonemail;
    }

    public void setPhonemail(String phonemail) {
        this.phonemail = phonemail;
    }

    public String getUraian() {
        return uraian;
    }

    public void setUraian(String uraian) {
        this.uraian = uraian;
    }

    public String getJalan() {
        return jalan;
    }

    public void setJalan(String jalan) {
        this.jalan = jalan;
    }

    public String getRt() {
        return rt;
    }

    public void setRt(String rt) {
        this.rt = rt;
    }

    public String getRw() {
        return rw;
    }

    public void setRw(String rw) {
        this.rw = rw;
    }

    public String getKelurahan() {
        return kelurahan;
    }

    public void setKelurahan(String kelurahan) {
        this.kelurahan = kelurahan;
    }

    public String getKecamatan() {
        return kecamatan;
    }

    public void setKecamatan(String kecamatan) {
        this.kecamatan = kecamatan;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public String getKategori() {
        return kategori;
    }

    public void setKategori(String kategori) {
        this.kategori = kategori;
    }
}
