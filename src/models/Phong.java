/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

public class Phong {
    private String maPhong;
    private int nhomPhong;
    private String loaiPhong;
    private int trangThaiPhong;
    private double giaPhong;

    public String getMaPhong() {
        return maPhong;
    }

    public void setMaPhong(String maPhong) {
        this.maPhong = maPhong;
    }

    public int getNhomPhong() {
        return nhomPhong;
    }

    public void setNhomPhong(int nhomPhong) {
        this.nhomPhong = nhomPhong;
    }

    public String getLoaiPhong() {
        return loaiPhong;
    }

    public void setLoaiPhong(String loaiPhong) {
        this.loaiPhong = loaiPhong;
    }



    public int getTrangThaiPhong() {
        return trangThaiPhong;
    }

    public void setTrangThaiPhong(int trangThaiPhong) {
        this.trangThaiPhong = trangThaiPhong;
    }

    public double getGiaPhong() {
        return giaPhong;
    }

    public void setGiaPhong(double giaPhong) {
        this.giaPhong = giaPhong;
    }

    public Phong() {
    }

    public Phong(String maPhong, int nhomPhong, String loaiPhong, int trangThaiPhong, double giaPhong) {
        this.maPhong = maPhong;
        this.nhomPhong = nhomPhong;
        this.loaiPhong = loaiPhong;
        this.trangThaiPhong = trangThaiPhong;
        this.giaPhong = giaPhong;
    }
       
    

}
