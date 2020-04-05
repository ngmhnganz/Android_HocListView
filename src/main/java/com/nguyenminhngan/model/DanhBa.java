package com.nguyenminhngan.model;

public class DanhBa {
    private String ten;
    private String phone;

    public String getTen() {
        return ten;
    }

    public String getPhone() {
        return phone;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "DanhBa{" +
                "ten='" + ten + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }

    public DanhBa(String ten, String phone) {
        this.ten = ten;
        this.phone = phone;
    }

    public DanhBa() {
    }
}
