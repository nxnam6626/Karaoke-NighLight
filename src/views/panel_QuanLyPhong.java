/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package views;

import connectDB.ConnectSQL;
import dao.Phong_dao;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import models.Phong;
import java.util.ArrayList;
import java.util.Locale;
import javax.swing.JOptionPane;
import javax.swing.border.EmptyBorder;

public final class panel_QuanLyPhong extends javax.swing.JPanel {
    private final Phong_dao phongDao;
 
    
   
    public panel_QuanLyPhong() {
        try {
	     ConnectSQL.getInstance().connect();
	} catch (SQLException e) {
            // TODO: handle exception
	}
        phongDao= new Phong_dao();
        initComponents();
        loadALLPhong();
        loadTrangThaiPhong();
        
       
    }

    
    
    
    @SuppressWarnings("unchecked")
//=======================================XEM GIÚP TUI CÁI NÀY VỚI==================================================//
    public JPanel taoPanelPhong(Phong phong) {
       JPanel panelPhong = new JPanel();
       panelPhong.setBounds(0, 0, 200, 200);
       panelPhong.setBackground(Color.LIGHT_GRAY);
       EmptyBorder margin = new EmptyBorder(10, 10, 10, 10);
       panelPhong.setBorder(margin);
       //panelPhong.setBorder(new LineBorder(Color.BLACK, 3));
    
       JLabel lblNewLabel = new JLabel("");
       lblNewLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
    
       lblNewLabel.setIcon(new ImageIcon(layDiaChiIconTheoLoaiVaTrangThaiPhong(phong.getTrangThaiPhong())));
      


       String soPhong = "Phòng: " + phong.getMaPhong();
       JLabel lblNewLabel_1 = new JLabel(soPhong);
       lblNewLabel_1.setAlignmentX(Component.LEFT_ALIGNMENT);
//       lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
       lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 16));
       
       int tt = phong.getTrangThaiPhong();
       String trangThai;
       trangThai = switch (tt) {
            case 1 -> "Trống";
            case 2 -> "Đã đặt";
            default -> "Đang sử dụng";
        };
       JLabel trangThaiPhong = new JLabel("Trạng thái: " + trangThai);
       trangThaiPhong.setAlignmentX(Component.LEFT_ALIGNMENT);
       trangThaiPhong.setFont(new Font("Tahoma", Font.PLAIN, 16));

       
       int np = phong.getNhomPhong();
       String soNguoi;
       soNguoi = switch (np) {
            case 1 -> "Nhỏ";
            case 2 -> "Trung";
            default -> "Lớn";
        };
       JLabel nguoi = new JLabel("Nhóm phòng: "+ soNguoi);
       nguoi.setAlignmentX(Component.LEFT_ALIGNMENT);
       nguoi.setFont(new Font("Tahoma", Font.PLAIN, 16));
       
       String lp = phong.getLoaiPhong();
       JLabel loaiPhong = new JLabel("Loại phòng: "+ lp);
       loaiPhong.setAlignmentX(Component.LEFT_ALIGNMENT);
       loaiPhong.setFont(new Font("Tahoma", Font.PLAIN, 16));
       
       DecimalFormatSymbols symbols = new DecimalFormatSymbols(Locale.getDefault());
       symbols.setGroupingSeparator('.');
       DecimalFormat df = new DecimalFormat("#,##0.##", symbols);
       double giaPhong = phong.getGiaPhong();
       JLabel giaP = new JLabel("Giá: "+ df.format(giaPhong) +" vnđ/giờ");
       giaP.setAlignmentX(Component.LEFT_ALIGNMENT);
       giaP.setFont(new Font("Tahoma", Font.PLAIN, 16));
       giaP.setForeground(Color.red);
       
       panelPhong.setLayout(new BoxLayout(panelPhong, BoxLayout.Y_AXIS));
       panelPhong.add(lblNewLabel);
       panelPhong.add(lblNewLabel_1);
       panelPhong.add(loaiPhong);
       panelPhong.add(trangThaiPhong);
       panelPhong.add(nguoi);
       panelPhong.add(giaP);
      

//    // Thêm sự kiện khi người dùng nhấp chuột vào phòng
//    panelPhong.addMouseListener(new MouseAdapter() {
//        @Override
//        public void mouseClicked(MouseEvent e) {
//            // Xử lý sự kiện khi phòng được nhấp chuột
//            // Ví dụ: hiển thị thông tin chi tiết phòng, chuyển đến trang khác, vv.
//        }
//    });

        return panelPhong;
    }
    
     public String layDiaChiIconTheoLoaiVaTrangThaiPhong(int trangThai) {
         return  "/utilities/imagePhong/" + trangThai + ".png";
    }
//=======================================XEM GIÚP TUI CÁI NÀY VỚI==================================================// 
    
    
    
    
    
    

    
    //=========================================================================================================//
    public void RemoveAllElememntPanel(){
        pnPhongNho.removeAll();
        pnPhongTrung.removeAll();
        pnPhongLon.removeAll();
        pnPhongVIP.removeAll();
        pnPhongNho.revalidate();
        pnPhongNho.repaint();
        pnPhongTrung.revalidate();
        pnPhongTrung.repaint();
        pnPhongLon.revalidate();
        pnPhongLon.repaint();
        pnPhongVIP.revalidate();
        pnPhongVIP.repaint();
    }
//=========================================================================================================//
    private void loadTrangThaiPhong() {
		int pt = phongDao.laySoLuongPhongTheoTrangThai(1);  //trống
		int pc = phongDao.laySoLuongPhongTheoTrangThai(2);  //chờ
		int pdsd = phongDao.laySoLuongPhongTheoTrangThai(4);// đang sử dung
		int pv = phongDao.laySoLuongPhongTheoTrangThai(3);  //vip

		lblPhongTrongCT.setText("Phòng trống (" + pt + ")");
		lblPhongSuDungCT.setText("Phòng đang sử dụng (" + pdsd + ")");
                lblPhongChoCT.setText("Phòng chờ (" + pc +")");
		lblPhongVipCT.setText("Phòng VIP (" + pv + ")");
   }
//=========================================================================================================//
    public void loadGUIDanhSachPhongTim(String maPhong, int tt, int lp, int sn) {
    ArrayList<Phong> danhSachPhong = phongDao.LayDanhSachPhongTheoTieuChi(maPhong, tt, lp, sn);
    ArrayList<JPanel> phongPanels = new ArrayList<>();
    for (Phong phong : danhSachPhong) {
        JPanel panelPhong = taoPanelPhong(phong);
        phongPanels.add(panelPhong);
    }
    RemoveAllElememntPanel();
    switch (sn) {
        case 1:
            for (JPanel panel : phongPanels) {
                pnPhongNho.add(panel);
            }
            
            break;
        case 2:
            for (JPanel panel : phongPanels) {
                pnPhongTrung.add(panel);
            }
            
            break;
        case 3:
            for (JPanel panel : phongPanels) {
                pnPhongLon.add(panel);
            }
            break;
    }
    
    if (lp == 2) {
        for (JPanel panel : phongPanels) {
            pnPhongVIP.add(panel);
        }
    }
}
//=========================================================================================================//
     public void lamMoi() {
		cmbLoaiPhong.setSelectedIndex(0);
                cmbTrangThai.setSelectedIndex(0);
                cmbSoNguoi.setSelectedIndex(0);
		txtTimPhong.setText("");
		loadALLPhong();
    }
//=============================================================================================================//
    public void loadALLPhong(){
        ArrayList<Phong> danhSachPhongNho = phongDao.LayDanhSachPhongTheoTieuChi(null,0 , 0, 1);
        ArrayList<Phong> danhSachPhongTrung = phongDao.LayDanhSachPhongTheoTieuChi(null,0 , 0, 2);
        ArrayList<Phong> danhSachPhongLon = phongDao.LayDanhSachPhongTheoTieuChi(null,0 , 0, 3);
        ArrayList<Phong> danhSachPhongVIP = phongDao.LayDanhSachPhongTheoTieuChi(null,0 , 2, 0);
        pnPhongVIP.removeAll();
        pnPhongNho.removeAll();
        pnPhongTrung.removeAll();
        pnPhongLon.removeAll();
        for (Phong phongNho : danhSachPhongNho) {
           JPanel panelPhong = taoPanelPhong(phongNho); 
           pnPhongNho.add(panelPhong); 
        }
        for (Phong phongLon : danhSachPhongLon) {
           JPanel panelPhong = taoPanelPhong(phongLon); 
           pnPhongLon.add(panelPhong); 
        }
        for (Phong phongTrung : danhSachPhongTrung) {
           JPanel panelPhong = taoPanelPhong(phongTrung); 
           pnPhongTrung.add(panelPhong); 
        }
        for (Phong phongVIP : danhSachPhongVIP) {
           JPanel panelPhong = taoPanelPhong(phongVIP); 
           pnPhongVIP.add(panelPhong); 
        }
        pnPhongNho.revalidate(); 
        pnPhongNho.repaint();
        pnPhongLon.revalidate(); 
        pnPhongLon.repaint();
        pnPhongTrung.revalidate(); 
        pnPhongTrung.repaint();
        pnPhongVIP.revalidate(); 
        pnPhongVIP.repaint();
    }
//=============================================================================================================//

   
//=================================================TÌM===========================================================//
    public void timTheoSoPhong(String soPhong){
       int loaiPhongTim = cmbLoaiPhong.getSelectedIndex();
       int trangThaiTim= cmbTrangThai.getSelectedIndex();
       int soNguoiTim = cmbSoNguoi.getSelectedIndex();
       if (soPhong.isEmpty() && loaiPhongTim==0 && trangThaiTim==0 && soNguoiTim==0) {
		JOptionPane.showMessageDialog(null, "Vui lòng nhập mã phòng (VD:SS001) hoặc chọn thông tin cần tìm", "Thông báo",
						JOptionPane.ERROR_MESSAGE);
		return;
	}else{
            if(soPhong.startsWith("SS")){
                loadGUIDanhSachPhongTim(soPhong, 0, 0, 1);
            }else if(soPhong.startsWith("SM")){
                loadGUIDanhSachPhongTim(soPhong, 0, 0, 2);
            }else if(soPhong.startsWith("SL")){
                loadGUIDanhSachPhongTim(soPhong, 0, 0, 3);
            }else if(soPhong.startsWith("V")){
                loadGUIDanhSachPhongTim(soPhong, 0,2 ,0);
            }
        }  
    }
    public void timTheoTrangThai(int trangThaiTim){
       ArrayList<Phong> danhSachPhongNho = phongDao.LayDanhSachPhongTheoTieuChi(null,trangThaiTim , 0, 1);
       ArrayList<Phong> danhSachPhongTrung = phongDao.LayDanhSachPhongTheoTieuChi(null,trangThaiTim , 0, 2);
       ArrayList<Phong> danhSachPhongLon = phongDao.LayDanhSachPhongTheoTieuChi(null,trangThaiTim, 0, 3);
       ArrayList<Phong> danhSachPhongVIP = phongDao.LayDanhSachPhongTheoTieuChi(null,trangThaiTim , 2, 0);
       pnPhongVIP.removeAll();
        pnPhongNho.removeAll();
        pnPhongTrung.removeAll();
        pnPhongLon.removeAll();
        for (Phong phongNho : danhSachPhongNho) {
           JPanel panelPhong = taoPanelPhong(phongNho); 
           pnPhongNho.add(panelPhong); 
        }
        for (Phong phongLon : danhSachPhongLon) {
           JPanel panelPhong = taoPanelPhong(phongLon); 
           pnPhongLon.add(panelPhong); 
        }
        for (Phong phongTrung : danhSachPhongTrung) {
           JPanel panelPhong = taoPanelPhong(phongTrung); 
           pnPhongTrung.add(panelPhong); 
        }
        for (Phong phongVIP : danhSachPhongVIP) {
           JPanel panelPhong = taoPanelPhong(phongVIP); 
           pnPhongVIP.add(panelPhong); 
        }
        pnPhongNho.revalidate(); 
        pnPhongNho.repaint();
        pnPhongLon.revalidate(); 
        pnPhongLon.repaint();
        pnPhongTrung.revalidate(); 
        pnPhongTrung.repaint();
        pnPhongVIP.revalidate(); 
        pnPhongVIP.repaint();
    }
    
    
    public void loadDSTimTheoTrangThaiLoaiPhong(int tt, int lp) {
    ArrayList<Phong> danhSachPhongNho = phongDao.LayDanhSachPhongTheoTieuChi(null, tt, lp, 1);
    ArrayList<Phong> danhSachPhongTrung = phongDao.LayDanhSachPhongTheoTieuChi(null, tt, lp, 2);
    ArrayList<Phong> danhSachPhongLon = phongDao.LayDanhSachPhongTheoTieuChi(null, tt, lp, 3);
    ArrayList<Phong> danhSachPhongVIP = phongDao.LayDanhSachPhongTheoTieuChi(null, tt, lp, 0);
    pnPhongVIP.removeAll();
    pnPhongNho.removeAll();
    pnPhongTrung.removeAll();
    pnPhongLon.removeAll();
        for (Phong phongNho : danhSachPhongNho) {
           JPanel panelPhong = taoPanelPhong(phongNho); 
           pnPhongNho.add(panelPhong); 
        }
        for (Phong phongLon : danhSachPhongLon) {
           JPanel panelPhong = taoPanelPhong(phongLon); 
           pnPhongLon.add(panelPhong); 
        }
        for (Phong phongTrung : danhSachPhongTrung) {
           JPanel panelPhong = taoPanelPhong(phongTrung); 
           pnPhongTrung.add(panelPhong); 
        }
        for (Phong phongTrung : danhSachPhongVIP) {
           JPanel panelPhong = taoPanelPhong(phongTrung); 
           pnPhongVIP.add(panelPhong); 
        }
        pnPhongNho.revalidate(); 
        pnPhongNho.repaint();
        pnPhongLon.revalidate(); 
        pnPhongLon.repaint();
        pnPhongTrung.revalidate(); 
        pnPhongTrung.repaint();
        pnPhongVIP.revalidate(); 
        pnPhongVIP.repaint();

}
//=================================================TÌM===========================================================//
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnLocPhong = new javax.swing.JPanel();
        lblTrangThai = new javax.swing.JLabel();
        lblLoaiPhong = new javax.swing.JLabel();
        btnTim = new javax.swing.JButton();
        btnLamMoi = new javax.swing.JButton();
        lblSoNguoi = new javax.swing.JLabel();
        lblGio = new javax.swing.JLabel();
        lblPhongSo = new javax.swing.JLabel();
        lblNgay = new javax.swing.JLabel();
        pnNgayGioHienTai = new javax.swing.JPanel();
        cmbSoNguoi = new javax.swing.JComboBox<>();
        cmbGio = new javax.swing.JComboBox<>();
        txtTimPhong = new javax.swing.JTextField();
        jdcLich = new com.toedter.calendar.JDateChooser();
        cmbLoaiPhong = new javax.swing.JComboBox<>();
        cmbTrangThai = new javax.swing.JComboBox<>();
        pnChuThich = new javax.swing.JPanel();
        lblPhongTrongCT = new javax.swing.JLabel();
        lblTrongImg = new javax.swing.JLabel();
        lblSuDungImg = new javax.swing.JLabel();
        lblPhongSuDungCT = new javax.swing.JLabel();
        lblChoImg = new javax.swing.JLabel();
        lblPhongChoCT = new javax.swing.JLabel();
        lblVipImg = new javax.swing.JLabel();
        lblPhongVipCT = new javax.swing.JLabel();
        pnChucNangPhong = new javax.swing.JPanel();
        btnDatPhongNgay = new javax.swing.JButton();
        btnDatPhongTruoc = new javax.swing.JButton();
        btnNhanPhongCho = new javax.swing.JButton();
        btnHuyPhong = new javax.swing.JButton();
        btnChuyenPhong = new javax.swing.JButton();
        btnXemChiTiet = new javax.swing.JButton();
        btnDatDichVu = new javax.swing.JButton();
        btnThanhToan = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        pnDSP = new javax.swing.JPanel();
        pnPhongNho = new javax.swing.JPanel();
        lblPhongNho = new javax.swing.JLabel();
        pnPhongTrung = new javax.swing.JPanel();
        lblPhongTrung = new javax.swing.JLabel();
        lblPhongLon = new javax.swing.JLabel();
        pnPhongLon = new javax.swing.JPanel();
        lblPhongVIP = new javax.swing.JLabel();
        pnPhongVIP = new javax.swing.JPanel();

        setLayout(new java.awt.BorderLayout());

        pnLocPhong.setBackground(new java.awt.Color(255, 255, 255));
        pnLocPhong.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        pnLocPhong.setPreferredSize(new java.awt.Dimension(1193, 115));

        lblTrangThai.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblTrangThai.setText("Trạng thái");

        lblLoaiPhong.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblLoaiPhong.setText("Loại phòng");

        btnTim.setBackground(new java.awt.Color(0, 0, 255));
        btnTim.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnTim.setForeground(new java.awt.Color(255, 255, 255));
        btnTim.setText("Tìm");
        btnTim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimActionPerformed(evt);
            }
        });

        btnLamMoi.setBackground(new java.awt.Color(255, 0, 0));
        btnLamMoi.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnLamMoi.setForeground(new java.awt.Color(255, 255, 255));
        btnLamMoi.setText("Làm mới");
        btnLamMoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLamMoiActionPerformed(evt);
            }
        });

        lblSoNguoi.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblSoNguoi.setText("Số người");

        lblGio.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblGio.setText("Giờ");

        lblPhongSo.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblPhongSo.setText("Phòng số");

        lblNgay.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblNgay.setText("Ngày");

        pnNgayGioHienTai.setBackground(new java.awt.Color(255, 204, 51));

        javax.swing.GroupLayout pnNgayGioHienTaiLayout = new javax.swing.GroupLayout(pnNgayGioHienTai);
        pnNgayGioHienTai.setLayout(pnNgayGioHienTaiLayout);
        pnNgayGioHienTaiLayout.setHorizontalGroup(
            pnNgayGioHienTaiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 186, Short.MAX_VALUE)
        );
        pnNgayGioHienTaiLayout.setVerticalGroup(
            pnNgayGioHienTaiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        cmbSoNguoi.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tất cả", "< 10 người", "10-20 người", "20-30 người" }));

        cmbGio.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        cmbLoaiPhong.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tất cả", "Thường", "VIP" }));

        cmbTrangThai.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tất cả", "Trống", "Chờ", "Đang sử dụng" }));

        javax.swing.GroupLayout pnLocPhongLayout = new javax.swing.GroupLayout(pnLocPhong);
        pnLocPhong.setLayout(pnLocPhongLayout);
        pnLocPhongLayout.setHorizontalGroup(
            pnLocPhongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnLocPhongLayout.createSequentialGroup()
                .addComponent(pnNgayGioHienTai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(pnLocPhongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblLoaiPhong)
                    .addComponent(lblTrangThai))
                .addGap(24, 24, 24)
                .addGroup(pnLocPhongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(cmbTrangThai, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbLoaiPhong, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(44, 44, 44)
                .addGroup(pnLocPhongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblPhongSo)
                    .addComponent(lblNgay))
                .addGap(18, 18, 18)
                .addGroup(pnLocPhongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtTimPhong)
                    .addComponent(jdcLich, javax.swing.GroupLayout.DEFAULT_SIZE, 192, Short.MAX_VALUE))
                .addGap(29, 29, 29)
                .addGroup(pnLocPhongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblSoNguoi)
                    .addComponent(lblGio, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(pnLocPhongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cmbSoNguoi, 0, 183, Short.MAX_VALUE)
                    .addComponent(cmbGio, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(pnLocPhongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnTim, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLamMoi, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(73, Short.MAX_VALUE))
        );
        pnLocPhongLayout.setVerticalGroup(
            pnLocPhongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnLocPhongLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(pnLocPhongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cmbLoaiPhong, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTimPhong, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnLocPhongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblLoaiPhong)
                        .addComponent(cmbSoNguoi, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblPhongSo, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblSoNguoi, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnTim, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pnLocPhongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnLocPhongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblNgay, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cmbTrangThai, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblTrangThai))
                    .addGroup(pnLocPhongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jdcLich, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblGio, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnLocPhongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cmbGio, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnLamMoi, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(17, 17, 17))
            .addGroup(pnLocPhongLayout.createSequentialGroup()
                .addComponent(pnNgayGioHienTai, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        txtTimPhong.getAccessibleContext().setAccessibleName("");

        add(pnLocPhong, java.awt.BorderLayout.NORTH);

        pnChuThich.setBackground(new java.awt.Color(255, 255, 255));
        pnChuThich.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        lblPhongTrongCT.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblPhongTrongCT.setForeground(new java.awt.Color(0, 255, 102));
        lblPhongTrongCT.setText("Phòng trống (10)");

        lblTrongImg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/utilities/icon/phongTrong.png"))); // NOI18N
        lblTrongImg.setPreferredSize(new java.awt.Dimension(50, 50));

        lblSuDungImg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/utilities/icon/phongCoKhach.png"))); // NOI18N
        lblSuDungImg.setPreferredSize(new java.awt.Dimension(50, 50));

        lblPhongSuDungCT.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblPhongSuDungCT.setForeground(new java.awt.Color(255, 0, 0));
        lblPhongSuDungCT.setText("Phòng đang sử dụng (10)");

        lblChoImg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/utilities/icon/phongCho.png"))); // NOI18N
        lblChoImg.setPreferredSize(new java.awt.Dimension(50, 50));

        lblPhongChoCT.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblPhongChoCT.setForeground(new java.awt.Color(255, 102, 0));
        lblPhongChoCT.setText("Phòng chờ (10)");

        lblVipImg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/utilities/icon/vip.png"))); // NOI18N
        lblVipImg.setPreferredSize(new java.awt.Dimension(50, 50));

        lblPhongVipCT.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblPhongVipCT.setText("Phòng VIP (5)");

        javax.swing.GroupLayout pnChuThichLayout = new javax.swing.GroupLayout(pnChuThich);
        pnChuThich.setLayout(pnChuThichLayout);
        pnChuThichLayout.setHorizontalGroup(
            pnChuThichLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnChuThichLayout.createSequentialGroup()
                .addGroup(pnChuThichLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnChuThichLayout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addComponent(lblTrongImg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(140, 140, 140)
                        .addComponent(lblSuDungImg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(118, 118, 118)
                        .addComponent(lblChoImg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(105, 105, 105)
                        .addComponent(lblVipImg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnChuThichLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblPhongTrongCT)
                        .addGap(37, 37, 37)
                        .addComponent(lblPhongSuDungCT)
                        .addGap(33, 33, 33)
                        .addComponent(lblPhongChoCT)
                        .addGap(58, 58, 58)
                        .addComponent(lblPhongVipCT)))
                .addContainerGap(726, Short.MAX_VALUE))
        );
        pnChuThichLayout.setVerticalGroup(
            pnChuThichLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnChuThichLayout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addGroup(pnChuThichLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblTrongImg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblSuDungImg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblChoImg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblVipImg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnChuThichLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPhongChoCT)
                    .addComponent(lblPhongSuDungCT)
                    .addComponent(lblPhongTrongCT)
                    .addComponent(lblPhongVipCT))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        add(pnChuThich, java.awt.BorderLayout.SOUTH);

        pnChucNangPhong.setBackground(new java.awt.Color(255, 255, 255));
        pnChucNangPhong.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        btnDatPhongNgay.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnDatPhongNgay.setText("Đặt phòng ngay");

        btnDatPhongTruoc.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnDatPhongTruoc.setText("Đặt phòng trước");

        btnNhanPhongCho.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnNhanPhongCho.setText("Nhận phòng chờ");

        btnHuyPhong.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnHuyPhong.setText("Hủy phòng chờ");

        btnChuyenPhong.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnChuyenPhong.setText("Chuyển phòng");

        btnXemChiTiet.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnXemChiTiet.setText("Xem chi tiết");

        btnDatDichVu.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnDatDichVu.setText("Đặt dịch vụ");

        btnThanhToan.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnThanhToan.setText("Thanh toán");

        javax.swing.GroupLayout pnChucNangPhongLayout = new javax.swing.GroupLayout(pnChucNangPhong);
        pnChucNangPhong.setLayout(pnChucNangPhongLayout);
        pnChucNangPhongLayout.setHorizontalGroup(
            pnChucNangPhongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnChucNangPhongLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(pnChucNangPhongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(btnDatDichVu, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnXemChiTiet, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnChuyenPhong, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnHuyPhong, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnNhanPhongCho, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 169, Short.MAX_VALUE)
                    .addComponent(btnDatPhongTruoc, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnDatPhongNgay, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnThanhToan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(26, Short.MAX_VALUE))
        );
        pnChucNangPhongLayout.setVerticalGroup(
            pnChucNangPhongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnChucNangPhongLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(btnDatPhongNgay, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnDatPhongTruoc, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnNhanPhongCho, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnHuyPhong, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnChuyenPhong, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnXemChiTiet, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnDatDichVu, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnThanhToan, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(1161, Short.MAX_VALUE))
        );

        add(pnChucNangPhong, java.awt.BorderLayout.EAST);
        pnChucNangPhong.getAccessibleContext().setAccessibleParent(this);

        jScrollPane2.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        pnDSP.setPreferredSize(new java.awt.Dimension(1120, 1630));

        pnPhongNho.setBackground(new java.awt.Color(255, 255, 255));
        pnPhongNho.setMaximumSize(new java.awt.Dimension(1130, 32767));
        pnPhongNho.setMinimumSize(new java.awt.Dimension(1130, 5));
        pnPhongNho.setPreferredSize(new java.awt.Dimension(1130, 80));
        java.awt.FlowLayout flowLayout1 = new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 40, 40);
        flowLayout1.setAlignOnBaseline(true);
        pnPhongNho.setLayout(flowLayout1);

        lblPhongNho.setBackground(new java.awt.Color(51, 51, 255));
        lblPhongNho.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblPhongNho.setForeground(new java.awt.Color(255, 255, 255));
        lblPhongNho.setText(" Phòng nhỏ");
        lblPhongNho.setOpaque(true);

        pnPhongTrung.setBackground(new java.awt.Color(255, 255, 255));
        java.awt.FlowLayout flowLayout8 = new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 40, 40);
        flowLayout8.setAlignOnBaseline(true);
        pnPhongTrung.setLayout(flowLayout8);

        lblPhongTrung.setBackground(new java.awt.Color(51, 51, 255));
        lblPhongTrung.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblPhongTrung.setForeground(new java.awt.Color(255, 255, 255));
        lblPhongTrung.setText(" Phòng VIP");
        lblPhongTrung.setOpaque(true);

        lblPhongLon.setBackground(new java.awt.Color(51, 51, 255));
        lblPhongLon.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblPhongLon.setForeground(new java.awt.Color(255, 255, 255));
        lblPhongLon.setText(" Phòng trung");
        lblPhongLon.setOpaque(true);

        pnPhongLon.setBackground(new java.awt.Color(255, 255, 255));
        java.awt.FlowLayout flowLayout9 = new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 40, 40);
        flowLayout9.setAlignOnBaseline(true);
        pnPhongLon.setLayout(flowLayout9);

        lblPhongVIP.setBackground(new java.awt.Color(51, 51, 255));
        lblPhongVIP.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblPhongVIP.setForeground(new java.awt.Color(255, 255, 255));
        lblPhongVIP.setText(" Phòng lớn");
        lblPhongVIP.setOpaque(true);

        pnPhongVIP.setBackground(new java.awt.Color(255, 255, 255));
        java.awt.FlowLayout flowLayout10 = new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 40, 40);
        flowLayout10.setAlignOnBaseline(true);
        pnPhongVIP.setLayout(flowLayout10);

        javax.swing.GroupLayout pnDSPLayout = new javax.swing.GroupLayout(pnDSP);
        pnDSP.setLayout(pnDSPLayout);
        pnDSPLayout.setHorizontalGroup(
            pnDSPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblPhongNho, javax.swing.GroupLayout.PREFERRED_SIZE, 1130, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(pnPhongNho, javax.swing.GroupLayout.PREFERRED_SIZE, 1131, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(lblPhongLon, javax.swing.GroupLayout.PREFERRED_SIZE, 1130, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(pnPhongTrung, javax.swing.GroupLayout.PREFERRED_SIZE, 1130, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(lblPhongVIP, javax.swing.GroupLayout.PREFERRED_SIZE, 1130, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(pnPhongLon, javax.swing.GroupLayout.PREFERRED_SIZE, 1130, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(lblPhongTrung, javax.swing.GroupLayout.PREFERRED_SIZE, 1130, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(pnPhongVIP, javax.swing.GroupLayout.PREFERRED_SIZE, 1130, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        pnDSPLayout.setVerticalGroup(
            pnDSPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnDSPLayout.createSequentialGroup()
                .addComponent(lblPhongNho, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(pnPhongNho, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(lblPhongLon, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(pnPhongTrung, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(lblPhongVIP, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(pnPhongLon, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(lblPhongTrung, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(pnPhongVIP, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pnPhongNho.getAccessibleContext().setAccessibleName("");

        jScrollPane2.setViewportView(pnDSP);

        add(jScrollPane2, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents
//=============================================SỰ KIỆN TÌM KIẾM==================================================//
    private void btnTimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimActionPerformed
       String soPhongTim = txtTimPhong.getText();
       int loaiPhongTim = cmbLoaiPhong.getSelectedIndex();
       int trangThaiTim= cmbTrangThai.getSelectedIndex();
       int soNguoiTim = cmbSoNguoi.getSelectedIndex();
       
       timTheoSoPhong(soPhongTim);
       if(trangThaiTim !=0 && loaiPhongTim ==0 && soNguoiTim==0){
           timTheoTrangThai(trangThaiTim);
       }
       if(trangThaiTim !=0 && loaiPhongTim !=0){
           loadDSTimTheoTrangThaiLoaiPhong(trangThaiTim, loaiPhongTim);
           //khongCanTruyenVaoSoNguoi
       }
       if(trangThaiTim != 0 && soNguoiTim !=0){
           loadGUIDanhSachPhongTim(null, trangThaiTim, 0, soNguoiTim);
           //truyen vao soNguoi
       }
       if(soNguoiTim !=0 && loaiPhongTim==0 && trangThaiTim==0){
           loadGUIDanhSachPhongTim(null, 0, 0, soNguoiTim);
       }
       if(loaiPhongTim != 0 && trangThaiTim ==0 && soNguoiTim==0){
           if(loaiPhongTim==1){
               loadALLPhong();
               pnPhongVIP.removeAll();
           }else{
               loadALLPhong();
               pnPhongNho.removeAll();
               pnPhongLon.removeAll();
               pnPhongTrung.removeAll();
           }
       }
        
       
    }//GEN-LAST:event_btnTimActionPerformed

    private void btnLamMoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLamMoiActionPerformed
        // TODO add your handling code here:
        lamMoi();
    }//GEN-LAST:event_btnLamMoiActionPerformed
   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnChuyenPhong;
    private javax.swing.JButton btnDatDichVu;
    private javax.swing.JButton btnDatPhongNgay;
    private javax.swing.JButton btnDatPhongTruoc;
    private javax.swing.JButton btnHuyPhong;
    private javax.swing.JButton btnLamMoi;
    private javax.swing.JButton btnNhanPhongCho;
    private javax.swing.JButton btnThanhToan;
    private javax.swing.JButton btnTim;
    private javax.swing.JButton btnXemChiTiet;
    private javax.swing.JComboBox<String> cmbGio;
    private javax.swing.JComboBox<String> cmbLoaiPhong;
    private javax.swing.JComboBox<String> cmbSoNguoi;
    private javax.swing.JComboBox<String> cmbTrangThai;
    private javax.swing.JScrollPane jScrollPane2;
    private com.toedter.calendar.JDateChooser jdcLich;
    private javax.swing.JLabel lblChoImg;
    private javax.swing.JLabel lblGio;
    private javax.swing.JLabel lblLoaiPhong;
    private javax.swing.JLabel lblNgay;
    private javax.swing.JLabel lblPhongChoCT;
    private javax.swing.JLabel lblPhongLon;
    private javax.swing.JLabel lblPhongNho;
    private javax.swing.JLabel lblPhongSo;
    private javax.swing.JLabel lblPhongSuDungCT;
    private javax.swing.JLabel lblPhongTrongCT;
    private javax.swing.JLabel lblPhongTrung;
    private javax.swing.JLabel lblPhongVIP;
    private javax.swing.JLabel lblPhongVipCT;
    private javax.swing.JLabel lblSoNguoi;
    private javax.swing.JLabel lblSuDungImg;
    private javax.swing.JLabel lblTrangThai;
    private javax.swing.JLabel lblTrongImg;
    private javax.swing.JLabel lblVipImg;
    private javax.swing.JPanel pnChuThich;
    private javax.swing.JPanel pnChucNangPhong;
    private javax.swing.JPanel pnDSP;
    private javax.swing.JPanel pnLocPhong;
    private javax.swing.JPanel pnNgayGioHienTai;
    private javax.swing.JPanel pnPhongLon;
    private javax.swing.JPanel pnPhongNho;
    private javax.swing.JPanel pnPhongTrung;
    private javax.swing.JPanel pnPhongVIP;
    private javax.swing.JTextField txtTimPhong;
    // End of variables declaration//GEN-END:variables
}
