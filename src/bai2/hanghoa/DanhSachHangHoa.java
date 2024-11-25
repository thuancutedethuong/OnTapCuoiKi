package bai2.hanghoa;

import java.util.*;

public class DanhSachHangHoa implements  IDanhSachHangHoa{
    private List<HangHoa> ds;


    public DanhSachHangHoa () {
        ds = new ArrayList<>();
    }

    @Override
    public boolean themHangHoa(HangHoa hangHoa) {
        if (hangHoa == null)
            throw new RuntimeException("Mảng rỗng");

        for(HangHoa hh: ds){
            if (hh.getMaHang().equalsIgnoreCase(hangHoa.getMaHang())){
                throw new RuntimeException("Trùng ma");
            }
        }

        ds.add(hangHoa);
        return true;
    }

    @Override
    public List<HangHoa> layDanhSachHangHoa() {
        return ds;
    }

    @Override
    public List<HangHoa> layTheoLoaiHang(String tenLoaiHang) {
        // Kiểm tra danh sách ban đầu
        if (ds == null || tenLoaiHang == null || tenLoaiHang.isBlank()) {
            return new ArrayList<>(); // Trả về danh sách rỗng nếu không hợp lệ
        }

        List<HangHoa> temp = new ArrayList<>();

        for(HangHoa hh: ds){
            if (hh instanceof HangSanhSu && tenLoaiHang.toLowerCase().contains("sanh su")){
                temp.add(hh);
            } else if (hh instanceof HangDienMay && tenLoaiHang.toLowerCase().contains("dien may")) {
                temp.add(hh);
            }else if (hh instanceof  HangThucPham && tenLoaiHang.toLowerCase().contains("thuc pham")){
                temp.add(hh);
            }
        }
        return temp;
    }

    @Override
    public HangHoa timHangHoaTheoMa(String maHang) {
        for (HangHoa hh: ds){
            if (hh.getMaHang().equalsIgnoreCase(maHang)){
                return hh;
            }
        }
        return null;
    }

    @Override
    public List<HangHoa> sapXepTheoTen() {
        return ds.stream()
                .sorted(Comparator.comparing(hh->hh.getTenHang()))
                .toList();
    }

    @Override
    public List<HangHoa> sapXepTheoSoLuongTon() {
        return ds.stream()
                .sorted(Comparator.comparing(hh->hh.getSoLuong()))
                .toList();
    }

    @Override
    public Set<HangHoa> layHangThucPhamKhoBan() {
        Set<HangHoa> temp = new HashSet<>();

        for(HangHoa hh: ds){
            if (hh.danhGiaMucBanBuong() == "khó bán")
                temp.add(hh);
        }
        return temp;
    }

    @Override
    public Map<String, Integer> demHangThucPhamKhoBanTheoLoai() {
        Map<String,Integer> temp = new HashMap<>();

        int demTP = 0;
        int demDM = 0;
        int demSS = 0;

        for(HangHoa hh: ds){
            if (hh instanceof HangThucPham){
                demTP++;
            } else if (hh instanceof  HangSanhSu) {
                demSS++;
            } else if (hh instanceof  HangDienMay) {
                demDM++;

            }
        }

        temp.put("So san pham sanh su", demSS);
        temp.put("So san pham dien may", demDM);
        temp.put("So san pham thuc pham", demTP);

        return temp;
    }

    @Override
    public boolean xoaHangHoa(String maHang) {
        for (HangHoa hh : ds){
            if (hh.getMaHang().equalsIgnoreCase(maHang)){
                ds.remove(hh);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean capNhatDonGia(String maHang, double donGia) {
        if (maHang == null)
            return false;
        for (HangHoa hh: ds){
            if (hh.getMaHang().equalsIgnoreCase(maHang)){
                hh.setDonGia(donGia);
                return true;
            }
        }
        return false;
    }

    @Override
    public Map<String, Double> tinhVAT() {
        if (ds == null || ds.isEmpty())
            return Map.of();

        Map<String, Double> temp = new HashMap<>();
        
        double TongVAPTP = 0.0;
        double TongVAPDM = 0.0;
        double TongVAPSS = 0.0;
        
        for(HangHoa hh: ds){

            if (hh instanceof HangDienMay) {
                TongVAPDM += hh.getTienThue();
            } else if (hh instanceof  HangSanhSu) {
                TongVAPSS += hh.getTienThue();
            } else if (hh instanceof  HangThucPham) {
                TongVAPTP += hh.getTienThue();
            }
        }

        temp.put("Tong vat hang thuc pham", TongVAPTP);
        temp.put("Tong vat hang dien may", TongVAPDM);
        temp.put("Tong vat hang sanh su", TongVAPSS);

        return temp;
    }


    @Override
    public List<HangHoa> layHangDienMayBanDuoc() {
        List<HangHoa> temp = new ArrayList<>();

        for (HangHoa hh: ds){
            if (hh instanceof  HangDienMay && hh.danhGiaMucBanBuong().equalsIgnoreCase("bán được")){
                temp.add(hh);
            }
        }
        return temp;
    }

    @Override
    public List<HangHoa> layHangSanhSuBanCham() {
        List<HangHoa> temp = new ArrayList<>();

        for(HangHoa hh: ds){
            if (hh instanceof HangSanhSu &&"bán chậm".equalsIgnoreCase(hh.danhGiaMucBanBuong())){
                temp.add(hh);
            }
        }
        return temp;
    }

    @Override
    public List<HangHoa> locHangHoaTonKho(int soLuongToiThieu) {
        List<HangHoa> temp = new ArrayList<>();

        for (HangHoa hh : ds){
            if (hh.getSoLuong() >= soLuongToiThieu){
                temp.add(hh);
            }
        }

        return temp;
    }

    // sap xep theo ten Hàng neu cung ten thi sap xep theo so luong
    public List<HangHoa> sx2tieuchi(){
        Collections.sort(ds, (hh1, hh2) -> {
            // So sánh tên hàng
            int result = hh1.getTenHang().compareTo(hh2.getTenHang());

            // Nếu tên giống nhau, sắp xếp theo số lượng giảm dần
            if (result == 0) {
                return Integer.compare(hh1.getSoLuong(),hh2.getSoLuong()) ; // Số lượng giảm dần
            }

            return result;  // Nếu tên khác nhau, trả về kết quả so sánh theo tên
        });

        return ds;
    }
}
