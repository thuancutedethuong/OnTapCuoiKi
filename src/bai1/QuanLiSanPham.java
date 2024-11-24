package bai1;

import java.time.LocalDate;
import java.util.*;

public class QuanLiSanPham {
    private List<SanPham> ds;

    public QuanLiSanPham(){
        ds = new ArrayList<>();
    }

    public boolean themSanPham(SanPham sanpham){
        if(sanpham == null ){
            throw new RuntimeException("Mảng rỗng");
        }

        for(SanPham sp : ds){
            if(sp.getMaSanPham().equalsIgnoreCase(sanpham.getMaSanPham()))
                throw new RuntimeException("Trùng mã sản phẩm");
        }

        ds.add(sanpham);
        return true;
    }

    public List<SanPham> getDs(){
        return ds;
    }

    public Map<String, Double> thongKeGiaTriTonKhoTrungBinh(){
        Map<String, Double> temp = new HashMap<>();

        double giaTriTBCuaTP = 0.0;
        double giaTriTBCuaDT = 0.0;
        int demTP = 0;
        int demDT = 0;

        for(SanPham sp : ds){
            if(sp instanceof SanPhamThucPham){
                giaTriTBCuaTP += sp.getGiaTriTonKho();
                demTP++;
            }else if(sp instanceof SanPhamDienTu){
                giaTriTBCuaDT += sp.getGiaTriTonKho();
                demDT++;
            }
        }

        double tongTBTP = (demTP > 0) ? giaTriTBCuaTP/demTP : 0.0;
        double tongTBDT = (demDT > 0) ? giaTriTBCuaDT/demDT : 0.0;
        temp.put("Giá trị tồn kho trung bình của thực phẩm", tongTBTP);
        temp.put("Giá trị tồn kho trung bình của điện tử", tongTBDT);
        return temp;
    }

    public List<SanPham> getDSThucPhamHetHan(){
        // dùng stream
//        return ds.stream()
//                .filter(sp -> sp instanceof SanPhamThucPham && ((SanPhamThucPham) sp).getHanSuDung().isAfter(LocalDate.now()))
//                .sorted(Comparator.comparing(sp->((SanPhamThucPham)sp).getHanSuDung()))
//                .toList();

        // dùng cách bình thường
        List<SanPham> temp = new ArrayList<>();
        for (SanPham sp : ds){
            if(sp instanceof SanPhamThucPham){
                if(((SanPhamThucPham)sp).getHanSuDung().isAfter(LocalDate.now()))
                    temp.add(((SanPhamThucPham)sp));
            }
        }

        temp.sort((h1,h2)->((SanPhamThucPham)h1).getHanSuDung().compareTo(((SanPhamThucPham)h2).getHanSuDung()));
        return temp;

    }

    public List<SanPham> getDSSanPhamCongSuatLonNhat(){
        int maxCongXuat = ds.stream()
                .filter(sp -> sp instanceof SanPhamDienTu)
                .mapToInt(sp-> ((SanPhamDienTu)sp).getCongSuat())
                .max().orElse(0);

        return ds.stream()
                .filter(sp->sp instanceof  SanPhamDienTu && ((SanPhamDienTu)sp).getCongSuat() == maxCongXuat)
                .toList();


        // cách làm thông thường
//        List<SanPham> temp = new ArrayList<>();
//        int congSuatLonNhat = 0;
//
//        for(SanPham sp : ds){
//            if(sp instanceof SanPhamDienTu){
//                if(((SanPhamDienTu)sp).getCongSuat() > congSuatLonNhat){
//                    congSuatLonNhat = ((SanPhamDienTu)sp).getCongSuat();
//                }
//            }
//        }
//
//        for(SanPham sp : ds){
//            if(sp instanceof SanPhamDienTu){
//                if(((SanPhamDienTu)sp).getCongSuat() == congSuatLonNhat){
//                    temp.add(sp);
//                }
//            }
//        }
//        return temp;

    }

    public boolean capNhapGiaSanPham(String maSo, double donGiaMoi){
        for(SanPham sp : ds){
            if(sp.getMaSanPham().equalsIgnoreCase(maSo)){
                sp.setDonGia(donGiaMoi);
                return true;
            }
        }

        return false;
    }

    public Map<String, Integer> demSanPhamTheoTungLoai(){
        Map<String, Integer> kq = new HashMap<>();

        int countTP = 0;
        int countDT = 0;

        for(SanPham sp : ds){
            if(sp instanceof SanPhamThucPham){
                countTP++;
            } else if (sp instanceof  SanPhamDienTu) {
                countDT++;
            }
        }

        kq.put("Số lượng sản phẩm thực phẩm", countTP);
        kq.put("Số lượng sản phẩm điện tử", countDT);
        return kq;
    }

    public List<String> demSanPhamTheoTungLoai2(){
        List<String> temp = new ArrayList<>();

        int demTP = 0;
        int demDT = 0;

        for(SanPham sp : ds){
            if(sp instanceof  SanPhamThucPham){
                demTP++;
            }else if(sp instanceof  SanPhamDienTu){
                demDT++;
            }
        }

        temp.add("Sản phẩm thực phẩm: " + demTP);
        temp.add("Sản phẩm điện tử: " + demDT);
        return temp;
    }

    public List<String> timkiemSanPhamGiaTriTonKhoCaoNhat(){
        List<String> temp = new ArrayList<>();

        double TPMax = 0.0;
        double DTMax = 0.0;

        for(SanPham sp : ds){
            if(sp instanceof SanPhamThucPham){
                if(((SanPhamThucPham)sp).getGiaTriTonKho() > TPMax)
                    TPMax = ((SanPhamThucPham)sp).getGiaTriTonKho();
            }else if(sp instanceof SanPhamDienTu){
                if(((SanPhamDienTu)sp).getGiaTriTonKho() > DTMax){
                    DTMax = ((SanPhamDienTu)sp).getGiaTriTonKho();
                }
            }
        }

        temp.add("Giá trị tồn kho thực phẩm lớn nhất là: " + TPMax);
        temp.add("Giá trị tồn kho điện tử lớn nhất là: " +  DTMax);

        return temp;
    }

    public boolean xoaSanPham(String maSo){
        for(SanPham sp : ds){
            if(sp.getMaSanPham().equalsIgnoreCase(maSo)){
                ds.remove(sp);
                return true;
            }
        }
        return false;
    }
}
