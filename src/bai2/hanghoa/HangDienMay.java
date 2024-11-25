package bai2.hanghoa;

public class HangDienMay extends HangHoa{
    private int thoiGianBaoHanh;
    private double congSuat;

    public HangDienMay(){
        this("", "xxx", 0.0, 0, 0, 0.0);
    }

    public HangDienMay(String maHang, String tenHang, double donGia, int soLuong, int thoiGianBaoHanh, double congSuat) {
        super(maHang, tenHang, donGia, soLuong);
       this.setThoiGianBaoHanh(thoiGianBaoHanh);
       this.setCongSuat(congSuat);
    }

    public int getThoiGianBaoHanh() {
        return thoiGianBaoHanh;
    }

    public void setThoiGianBaoHanh(int thoiGianBaoHanh) {
        if(thoiGianBaoHanh < 0)
            throw new RuntimeException("Thời gian bảo hành >= 0");
        this.thoiGianBaoHanh = thoiGianBaoHanh;
    }

    public double getCongSuat() {
        return congSuat;
    }

    public void setCongSuat(double congSuat) {
        if(congSuat < 0.0)
            throw new RuntimeException("Công suất >= 0.0");
        this.congSuat = congSuat;
    }

    @Override
    public String danhGiaMucBanBuong() {
        if(soLuong < 3)
            return "bán được";
        return "không bán được";
    }

    @Override
    public double getTienThue() {
        return donGia*soLuong*0.1;
    }

    @Override
    public String toString() {
        return super.toString() + " | " + thoiGianBaoHanh + " | " + congSuat;
    }
}
