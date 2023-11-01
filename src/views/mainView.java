/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package views;


import connectDB.ConnectSQL;
import java.awt.CardLayout;
import java.awt.Color;
import java.sql.SQLException;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public final class mainView extends javax.swing.JFrame {

    private CardLayout card = null;
//  private final Color color_hover = new Color(216, 238, 255);
    private final Color color_active = new Color(187, 222, 251);
    private final Color default_color = new Color(242, 242, 242);


   
    public mainView() {
         try {
		ConnectSQL.getInstance().connect();
	} catch (SQLException e) {
            // TODO: handle exception
            
	}
        initComponents();
        card = (CardLayout) this.pnl_Main.getLayout();
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        pnl_Main.add(new panel_ManHinhChinh(), "manhinhchinh");
        card.show(this.pnl_Main, "manhinhchinh");


        //===================================Sự kiện đóng===================================//
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        this.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                if (JOptionPane.showConfirmDialog(null,
                        "Bạn có muốn tắt Karaoke Night Light?", "Đóng ứng dụng?",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                    System.exit(0);
                }
            }
        });
        
        //        Sự kiện đổi size
//        this.addComponentListener(new ComponentAdapter() {
//            @Override
//            public void componentResized(ComponentEvent e) {
//                ((panel_ManHinhChinh) panel_ManHinhChinh).resize();
//            }
//        });
//    }

    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnLeft = new javax.swing.JPanel();
        pnMenu = new javax.swing.JPanel();
        lbl_ManHinhChinh = new javax.swing.JLabel();
        lbl_PhongHat = new javax.swing.JLabel();
        lbl_TaiLieu = new javax.swing.JLabel();
        lbl_KhachHang = new javax.swing.JLabel();
        lbl_DichVu = new javax.swing.JLabel();
        lbl_NhanVien = new javax.swing.JLabel();
        lbl_ThongKe = new javax.swing.JLabel();
        lbl_TroGiup = new javax.swing.JLabel();
        pnNhanVienDangNhap = new javax.swing.JPanel();
        lblNhanVienDangNhap = new javax.swing.JLabel();
        pnl_Main = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setSize(new java.awt.Dimension(0, 0));

        pnLeft.setBackground(new java.awt.Color(255, 255, 255));
        pnLeft.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        pnLeft.setPreferredSize(new java.awt.Dimension(200, 182));

        pnMenu.setLayout(new javax.swing.BoxLayout(pnMenu, javax.swing.BoxLayout.PAGE_AXIS));

        lbl_ManHinhChinh.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbl_ManHinhChinh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/utilities/icon/home.png"))); // NOI18N
        lbl_ManHinhChinh.setText("Trang chủ");
        lbl_ManHinhChinh.setMaximumSize(new java.awt.Dimension(200, 64));
        lbl_ManHinhChinh.setPreferredSize(new java.awt.Dimension(200, 64));
        lbl_ManHinhChinh.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_ManHinhChinhMouseClicked(evt);
            }
        });
        pnMenu.add(lbl_ManHinhChinh);

        lbl_PhongHat.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbl_PhongHat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/utilities/icon/karaoke.png"))); // NOI18N
        lbl_PhongHat.setText("Phòng hát");
        lbl_PhongHat.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_PhongHatMouseClicked(evt);
            }
        });
        pnMenu.add(lbl_PhongHat);

        lbl_TaiLieu.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbl_TaiLieu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/utilities/icon/documentation.png"))); // NOI18N
        lbl_TaiLieu.setText("Tài liệu");
        lbl_TaiLieu.setMaximumSize(new java.awt.Dimension(200, 64));
        lbl_TaiLieu.setPreferredSize(new java.awt.Dimension(200, 64));
        lbl_TaiLieu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_TaiLieuMouseClicked(evt);
            }
        });
        pnMenu.add(lbl_TaiLieu);

        lbl_KhachHang.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbl_KhachHang.setIcon(new javax.swing.ImageIcon(getClass().getResource("/utilities/icon/management.png"))); // NOI18N
        lbl_KhachHang.setText("Khách hàng");
        lbl_KhachHang.setMaximumSize(new java.awt.Dimension(200, 64));
        lbl_KhachHang.setPreferredSize(new java.awt.Dimension(200, 64));
        lbl_KhachHang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_KhachHangMouseClicked(evt);
            }
        });
        pnMenu.add(lbl_KhachHang);

        lbl_DichVu.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbl_DichVu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/utilities/icon/fast-food.png"))); // NOI18N
        lbl_DichVu.setText("Dịch vụ");
        lbl_DichVu.setMaximumSize(new java.awt.Dimension(200, 64));
        lbl_DichVu.setPreferredSize(new java.awt.Dimension(200, 64));
        lbl_DichVu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_DichVuMouseClicked(evt);
            }
        });
        pnMenu.add(lbl_DichVu);

        lbl_NhanVien.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbl_NhanVien.setIcon(new javax.swing.ImageIcon(getClass().getResource("/utilities/icon/user.png"))); // NOI18N
        lbl_NhanVien.setText("Nhân viên");
        lbl_NhanVien.setMaximumSize(new java.awt.Dimension(200, 64));
        lbl_NhanVien.setPreferredSize(new java.awt.Dimension(200, 64));
        lbl_NhanVien.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_NhanVienMouseClicked(evt);
            }
        });
        pnMenu.add(lbl_NhanVien);

        lbl_ThongKe.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbl_ThongKe.setIcon(new javax.swing.ImageIcon(getClass().getResource("/utilities/icon/description.png"))); // NOI18N
        lbl_ThongKe.setText("Thống kê");
        lbl_ThongKe.setMaximumSize(new java.awt.Dimension(200, 64));
        lbl_ThongKe.setPreferredSize(new java.awt.Dimension(200, 64));
        lbl_ThongKe.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_ThongKeMouseClicked(evt);
            }
        });
        pnMenu.add(lbl_ThongKe);

        lbl_TroGiup.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbl_TroGiup.setIcon(new javax.swing.ImageIcon(getClass().getResource("/utilities/icon/question.png"))); // NOI18N
        lbl_TroGiup.setText("Trợ giúp");
        lbl_TroGiup.setMaximumSize(new java.awt.Dimension(200, 64));
        lbl_TroGiup.setPreferredSize(new java.awt.Dimension(200, 64));
        pnMenu.add(lbl_TroGiup);

        pnNhanVienDangNhap.setBackground(new java.awt.Color(0, 255, 0));

        lblNhanVienDangNhap.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblNhanVienDangNhap.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblNhanVienDangNhap.setText("Nguyễn Văn A");

        javax.swing.GroupLayout pnNhanVienDangNhapLayout = new javax.swing.GroupLayout(pnNhanVienDangNhap);
        pnNhanVienDangNhap.setLayout(pnNhanVienDangNhapLayout);
        pnNhanVienDangNhapLayout.setHorizontalGroup(
            pnNhanVienDangNhapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnNhanVienDangNhapLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblNhanVienDangNhap, javax.swing.GroupLayout.DEFAULT_SIZE, 182, Short.MAX_VALUE)
                .addContainerGap())
        );
        pnNhanVienDangNhapLayout.setVerticalGroup(
            pnNhanVienDangNhapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnNhanVienDangNhapLayout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(lblNhanVienDangNhap)
                .addContainerGap(38, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout pnLeftLayout = new javax.swing.GroupLayout(pnLeft);
        pnLeft.setLayout(pnLeftLayout);
        pnLeftLayout.setHorizontalGroup(
            pnLeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnLeftLayout.createSequentialGroup()
                .addGroup(pnLeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(pnMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pnNhanVienDangNhap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(522, 522, 522))
        );
        pnLeftLayout.setVerticalGroup(
            pnLeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnLeftLayout.createSequentialGroup()
                .addComponent(pnNhanVienDangNhap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnMenu, javax.swing.GroupLayout.DEFAULT_SIZE, 637, Short.MAX_VALUE))
        );

        getContentPane().add(pnLeft, java.awt.BorderLayout.WEST);

        pnl_Main.setBackground(new java.awt.Color(255, 204, 204));
        pnl_Main.setLayout(new java.awt.CardLayout());
        getContentPane().add(pnl_Main, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void lbl_ManHinhChinhMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_ManHinhChinhMouseClicked
        pnl_Main.add(new panel_ManHinhChinh(), "manhinhchinh");
        card.show(this.pnl_Main, "manhinhchinh");
    }//GEN-LAST:event_lbl_ManHinhChinhMouseClicked

    private void lbl_TaiLieuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_TaiLieuMouseClicked

    }//GEN-LAST:event_lbl_TaiLieuMouseClicked

    private void lbl_KhachHangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_KhachHangMouseClicked

    }//GEN-LAST:event_lbl_KhachHangMouseClicked

    private void lbl_DichVuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_DichVuMouseClicked

    }//GEN-LAST:event_lbl_DichVuMouseClicked

    private void lbl_NhanVienMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_NhanVienMouseClicked

    }//GEN-LAST:event_lbl_NhanVienMouseClicked

    private void lbl_ThongKeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_ThongKeMouseClicked

    }//GEN-LAST:event_lbl_ThongKeMouseClicked

    private void lbl_PhongHatMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_PhongHatMouseClicked

        pnl_Main.add(new panel_QuanLyPhong(),"phong");
        card.show(this.pnl_Main,"phong");

    }//GEN-LAST:event_lbl_PhongHatMouseClicked

    //====================CHUYỂN MÀU NÚT ĐƯỢC BẤM============================//
//    private void buttonActive(Component c) {
//        Arrays.stream(new Component[]{lbl_PhongHat,lbl_DichVu,lbl_KhachHang,lbl_ManHinhChinh,lbl_NhanVien,lbl_TaiKhoan}).forEach(item -> item.setBackground(default_color));
//        c.setBackground(color_active);
//    }
    //====================CHUYỂN MÀU NÚT ĐƯỢC BẤM============================//
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> {
            new mainView().setVisible(true);
        });
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel lblNhanVienDangNhap;
    private javax.swing.JLabel lbl_DichVu;
    private javax.swing.JLabel lbl_KhachHang;
    private javax.swing.JLabel lbl_ManHinhChinh;
    private javax.swing.JLabel lbl_NhanVien;
    private javax.swing.JLabel lbl_PhongHat;
    private javax.swing.JLabel lbl_TaiLieu;
    private javax.swing.JLabel lbl_ThongKe;
    private javax.swing.JLabel lbl_TroGiup;
    private javax.swing.JPanel pnLeft;
    private javax.swing.JPanel pnMenu;
    private javax.swing.JPanel pnNhanVienDangNhap;
    private javax.swing.JPanel pnl_Main;
    // End of variables declaration//GEN-END:variables

  
}
