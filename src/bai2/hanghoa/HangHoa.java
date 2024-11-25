package bai2.hanghoa;

import java.text.DecimalFormat;

public abstract class HangHoa {
    protected final String maHang;
    protected String tenHang;
    protected double donGia;
    protected int soLuong;

    public HangHoa(){
        this("", "xxx", 0.0, 0);
    }

    public HangHoa(String maHang, String tenHang, double donGia, int soLuong) {
        if(maHang == null || maHang.trim().length()==0)
            throw new RuntimeException("Mã hàng not null");
        this.maHang = maHang;
        this.setTenHang(tenHang);
        this.setDonGia(donGia);
        this.setSoLuong(soLuong);
    }

    public String getMaHang() {
        return maHang;
    }

    public String getTenHang() {
        return tenHang;
    }

    public void setTenHang(String tenHang) {
        if(tenHang== null || tenHang.trim().length()==0) {
            this.tenHang = "xxx";
        }else{
            this.tenHang = tenHang;
        }
    }

    public double getDonGia() {
        return donGia;
    }

    public void setDonGia(double donGia) {
        if(donGia < 0.0)
            throw new RuntimeException("Đơn giá >= 0.0");
        this.donGia = donGia;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        if(soLuong < 0)
            throw new RuntimeException("Số lượng >= 0");
        this.soLuong = soLuong;
    }

    public abstract String danhGiaMucBanBuong();
    public abstract double getTienThue();

    @Override
    public String toString() {
        DecimalFormat df = new DecimalFormat("#,##0 VNĐ");
        return String.format("| %s | %-15s | %-15s | %d |", maHang, tenHang, df.format(donGia), soLuong);
    }
}
