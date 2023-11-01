/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package views;

public class panel_ManHinhChinh extends javax.swing.JPanel {


    public panel_ManHinhChinh() {
        initComponents();
  
    }

//    public void resize() {
//        ImageIcon icon = new ImageIcon(getClass().getResource("/utilities/image/anhnen.jpg"));
//        ImageIcon imageIcon = new ImageIcon(icon.getImage().getScaledInstance(this.getWidth(), this.getHeight(), Image.SCALE_SMOOTH));
//        lbl_imgHome.setIcon(imageIcon);
//    }
    
  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblTieuDe = new javax.swing.JLabel();
        lblimage = new javax.swing.JLabel();

        setLayout(new java.awt.BorderLayout());

        lblTieuDe.setBackground(new java.awt.Color(51, 51, 51));
        lblTieuDe.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblTieuDe.setForeground(new java.awt.Color(255, 51, 51));
        lblTieuDe.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTieuDe.setText("KARAOKE NIGHT LIGHT");
        lblTieuDe.setOpaque(true);
        lblTieuDe.setPreferredSize(new java.awt.Dimension(273, 114));
        add(lblTieuDe, java.awt.BorderLayout.NORTH);
        add(lblimage, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel lblTieuDe;
    private javax.swing.JLabel lblimage;
    // End of variables declaration//GEN-END:variables
}
