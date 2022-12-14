/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import dao.KhoaHocDAO;
import dao.NguoiHocDAO;

import dao.ThongKeDAO;
import entity.KhoaHoc;
import entity.NguoiHoc;
import entity.NhanVien;
import java.awt.Color;
import java.awt.Font;
import java.io.File;
import java.io.FileOutputStream;
import java.text.DecimalFormat;
import java.util.List;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.AuthenticationFailedException;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFileChooser;
import javax.swing.table.DefaultTableModel;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import utils.Auth;
import utils.MsgBox;
import utils.ValidateForm;

/**
 *
 * @author dy
 */
public class ThongKeJDialog extends javax.swing.JDialog {

    /**
     * Creates new form ThongKeJDialog
     */
    DefaultTableModel model;

    public ThongKeJDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();

//        String[] bangDiem = {"MÃ NH", "HỌ VÀ TÊN", "ĐIỂM", "XẾP LOẠI"};
//        model = new DefaultTableModel(bangDiem, 0);
//        tblBangDiem.setModel(model);
//
//        String[] nguoiHoc = {"NĂM", "SỐ NGƯỜI HỌC", "ĐK SỚM NHẤT", "ĐK MUỘN NHẤT"};
//        model = new DefaultTableModel(nguoiHoc, 0);
//        tblNguoiHoc.setModel(model);
//
//        String[] chuyeDe = {"CHUYÊN ĐỀ", "SL HV", "ĐIỂM TN", "ĐIỂM CN", "ĐIỂM TB"};
//        model = new DefaultTableModel(chuyeDe, 0);
//        tblDiemChuyenDe.setModel(model);
//
//        String[] doanhThu = {"CHUYÊN ĐỀ", "SỐ KH", "SỐ HV", "D.THU", "HP.CN", "HP.TN", "HP.TB"};
//        model = new DefaultTableModel(doanhThu, 0);
//        tblDoanhThu.setModel(model);

        tblBangDiem.getTableHeader().setOpaque(false);
        tblBangDiem.getTableHeader().setFont(new Font("tahoma", Font.BOLD, 14));
        tblBangDiem.getTableHeader().setForeground(Color.white);
        tblBangDiem.getTableHeader().setBackground(Color.black);

        tblNguoiHoc.getTableHeader().setOpaque(false);
        tblNguoiHoc.getTableHeader().setFont(new Font("tahoma", Font.BOLD, 14));
        tblNguoiHoc.getTableHeader().setForeground(Color.white);
        tblNguoiHoc.getTableHeader().setBackground(Color.black);

        tblDiemChuyenDe.getTableHeader().setOpaque(false);
        tblDiemChuyenDe.getTableHeader().setFont(new Font("tahoma", Font.BOLD, 14));
        tblDiemChuyenDe.getTableHeader().setForeground(Color.white);
        tblDiemChuyenDe.getTableHeader().setBackground(Color.black);

        tblDoanhThu.getTableHeader().setOpaque(false);
        tblDoanhThu.getTableHeader().setFont(new Font("tahoma", Font.BOLD, 14));
        tblDoanhThu.getTableHeader().setForeground(Color.white);
        tblDoanhThu.getTableHeader().setBackground(Color.black);

        tblBangDiem.getColumnModel().getColumn(0).setMaxWidth(90);
        tblBangDiem.getColumnModel().getColumn(1).setMaxWidth(400);
        tblBangDiem.getColumnModel().getColumn(2).setMaxWidth(100);
        tblBangDiem.getColumnModel().getColumn(3).setMaxWidth(130);

        tblDiemChuyenDe.getColumnModel().getColumn(0).setMaxWidth(400);
        tblDiemChuyenDe.getColumnModel().getColumn(1).setMaxWidth(100);
        tblDiemChuyenDe.getColumnModel().getColumn(2).setMaxWidth(100);
        tblDiemChuyenDe.getColumnModel().getColumn(3).setMaxWidth(80);
        tblDiemChuyenDe.getColumnModel().getColumn(4).setMaxWidth(80);

        tblDoanhThu.getColumnModel().getColumn(0).setMaxWidth(300);
        tblDoanhThu.getColumnModel().getColumn(1).setMaxWidth(80);
        tblDoanhThu.getColumnModel().getColumn(2).setMaxWidth(80);
        tblDoanhThu.getColumnModel().getColumn(3).setMaxWidth(80);
        tblDoanhThu.getColumnModel().getColumn(4).setMaxWidth(80);
        tblDoanhThu.getColumnModel().getColumn(5).setMaxWidth(80);
        tblDoanhThu.getColumnModel().getColumn(6).setMaxWidth(80);

        init();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        tabs = new javax.swing.JTabbedPane();
        pnlBangDiem = new javax.swing.JPanel();
        pnlKhoaHoc = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblBangDiem = new javax.swing.JTable();
        cboKhoaHoc = new javax.swing.JComboBox<>();
        lblKhoaHoc = new javax.swing.JLabel();
        txtMatKhauEmailNV = new javax.swing.JPasswordField();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        pnlNguoiHoc = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblNguoiHoc = new javax.swing.JTable();
        pnlDiemChuyenDe = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblDiemChuyenDe = new javax.swing.JTable();
        pnlDoanhThu = new javax.swing.JPanel();
        pnlNam = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tblDoanhThu = new javax.swing.JTable();
        lblNam = new javax.swing.JLabel();
        cboNam = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("THỐNG KÊ");
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        tabs.setBackground(new java.awt.Color(255, 255, 255));

        pnlKhoaHoc.setBackground(new java.awt.Color(255, 255, 255));

        tblBangDiem.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        tblBangDiem.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "MÃ NH", "HỌ VÀ TÊN", "ĐIỂM ", "XẾP LOẠI"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblBangDiem.setGridColor(new java.awt.Color(255, 255, 255));
        tblBangDiem.setRowHeight(25);
        tblBangDiem.setRowMargin(0);
        tblBangDiem.setSelectionBackground(new java.awt.Color(102, 102, 102));
        tblBangDiem.setShowHorizontalLines(false);
        tblBangDiem.setShowVerticalLines(false);
        tblBangDiem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblBangDiemMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblBangDiem);

        cboKhoaHoc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboKhoaHocActionPerformed(evt);
            }
        });

        lblKhoaHoc.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblKhoaHoc.setText("KHÓA HỌC:");

        txtMatKhauEmailNV.setText("15102002zxc");
        txtMatKhauEmailNV.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtMatKhauEmailNVKeyReleased(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 255));
        jLabel2.setText("Nhập mật khẩu email: ");

        jButton1.setBackground(new java.awt.Color(255, 255, 255));
        jButton1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton1.setForeground(new java.awt.Color(0, 0, 255));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Hinh/email.png"))); // NOI18N
        jButton1.setText("GỬI");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(255, 255, 255));
        jButton2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton2.setForeground(new java.awt.Color(0, 0, 255));
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Hinh/excel.png"))); // NOI18N
        jButton2.setText("Export Exel");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlKhoaHocLayout = new javax.swing.GroupLayout(pnlKhoaHoc);
        pnlKhoaHoc.setLayout(pnlKhoaHocLayout);
        pnlKhoaHocLayout.setHorizontalGroup(
            pnlKhoaHocLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlKhoaHocLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlKhoaHocLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 684, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlKhoaHocLayout.createSequentialGroup()
                        .addComponent(lblKhoaHoc)
                        .addGap(18, 18, 18)
                        .addComponent(cboKhoaHoc, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(pnlKhoaHocLayout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtMatKhauEmailNV, javax.swing.GroupLayout.PREFERRED_SIZE, 309, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton2)))
                .addContainerGap())
        );
        pnlKhoaHocLayout.setVerticalGroup(
            pnlKhoaHocLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlKhoaHocLayout.createSequentialGroup()
                .addGroup(pnlKhoaHocLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cboKhoaHoc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblKhoaHoc))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 497, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlKhoaHocLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtMatKhauEmailNV, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addContainerGap())
        );

        javax.swing.GroupLayout pnlBangDiemLayout = new javax.swing.GroupLayout(pnlBangDiem);
        pnlBangDiem.setLayout(pnlBangDiemLayout);
        pnlBangDiemLayout.setHorizontalGroup(
            pnlBangDiemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlKhoaHoc, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        pnlBangDiemLayout.setVerticalGroup(
            pnlBangDiemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlBangDiemLayout.createSequentialGroup()
                .addComponent(pnlKhoaHoc, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 9, Short.MAX_VALUE))
        );

        tabs.addTab("BẢNG ĐIỂM", pnlBangDiem);

        pnlNguoiHoc.setBackground(new java.awt.Color(255, 255, 255));

        tblNguoiHoc.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        tblNguoiHoc.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "NĂM", "SỐ NGƯỜI HỌC", "ĐK SỚM NHẤT", "ĐK MUỘN NHẤT"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblNguoiHoc.setGridColor(new java.awt.Color(255, 255, 255));
        tblNguoiHoc.setRowHeight(25);
        tblNguoiHoc.setRowMargin(0);
        tblNguoiHoc.setSelectionBackground(new java.awt.Color(102, 102, 102));
        tblNguoiHoc.setShowHorizontalLines(false);
        tblNguoiHoc.setShowVerticalLines(false);
        jScrollPane1.setViewportView(tblNguoiHoc);

        javax.swing.GroupLayout pnlNguoiHocLayout = new javax.swing.GroupLayout(pnlNguoiHoc);
        pnlNguoiHoc.setLayout(pnlNguoiHocLayout);
        pnlNguoiHocLayout.setHorizontalGroup(
            pnlNguoiHocLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlNguoiHocLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 684, Short.MAX_VALUE)
                .addContainerGap())
        );
        pnlNguoiHocLayout.setVerticalGroup(
            pnlNguoiHocLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlNguoiHocLayout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 573, Short.MAX_VALUE)
                .addContainerGap())
        );

        tabs.addTab("NGƯỜI HỌC", pnlNguoiHoc);

        pnlDiemChuyenDe.setBackground(new java.awt.Color(255, 255, 255));

        tblDiemChuyenDe.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        tblDiemChuyenDe.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "CHUYÊN ĐỀ", "SL HV", "ĐIỂM TN", "ĐIỂM CN", "ĐIỂM TB"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblDiemChuyenDe.setGridColor(new java.awt.Color(255, 255, 255));
        tblDiemChuyenDe.setRowHeight(25);
        tblDiemChuyenDe.setRowMargin(0);
        tblDiemChuyenDe.setSelectionBackground(new java.awt.Color(102, 102, 102));
        tblDiemChuyenDe.setShowHorizontalLines(false);
        tblDiemChuyenDe.setShowVerticalLines(false);
        jScrollPane3.setViewportView(tblDiemChuyenDe);

        javax.swing.GroupLayout pnlDiemChuyenDeLayout = new javax.swing.GroupLayout(pnlDiemChuyenDe);
        pnlDiemChuyenDe.setLayout(pnlDiemChuyenDeLayout);
        pnlDiemChuyenDeLayout.setHorizontalGroup(
            pnlDiemChuyenDeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDiemChuyenDeLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 684, Short.MAX_VALUE)
                .addContainerGap())
        );
        pnlDiemChuyenDeLayout.setVerticalGroup(
            pnlDiemChuyenDeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDiemChuyenDeLayout.createSequentialGroup()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 573, Short.MAX_VALUE)
                .addContainerGap())
        );

        tabs.addTab("ĐIỂM CHUYÊN ĐỀ", pnlDiemChuyenDe);

        pnlNam.setBackground(new java.awt.Color(255, 255, 255));

        tblDoanhThu.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        tblDoanhThu.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "CHUYÊN ĐỀ", "SỐ KH", "SỐ HV", "D.THU", "HP.CN", "HP.TN", "HP.TB"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblDoanhThu.setToolTipText("TỔNG HỢP THỐNG KÊ");
        tblDoanhThu.setGridColor(new java.awt.Color(255, 255, 255));
        tblDoanhThu.setRowHeight(25);
        tblDoanhThu.setRowMargin(0);
        tblDoanhThu.setSelectionBackground(new java.awt.Color(102, 102, 102));
        tblDoanhThu.setShowHorizontalLines(false);
        tblDoanhThu.setShowVerticalLines(false);
        jScrollPane4.setViewportView(tblDoanhThu);

        lblNam.setText("NĂM:");

        cboNam.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboNamActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlNamLayout = new javax.swing.GroupLayout(pnlNam);
        pnlNam.setLayout(pnlNamLayout);
        pnlNamLayout.setHorizontalGroup(
            pnlNamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlNamLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlNamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 684, Short.MAX_VALUE)
                    .addGroup(pnlNamLayout.createSequentialGroup()
                        .addComponent(lblNam)
                        .addGap(18, 18, 18)
                        .addComponent(cboNam, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        pnlNamLayout.setVerticalGroup(
            pnlNamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlNamLayout.createSequentialGroup()
                .addGroup(pnlNamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNam)
                    .addComponent(cboNam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 547, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout pnlDoanhThuLayout = new javax.swing.GroupLayout(pnlDoanhThu);
        pnlDoanhThu.setLayout(pnlDoanhThuLayout);
        pnlDoanhThuLayout.setHorizontalGroup(
            pnlDoanhThuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlNam, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        pnlDoanhThuLayout.setVerticalGroup(
            pnlDoanhThuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlNam, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        tabs.addTab("DOANH THU", pnlDoanhThu);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 51, 255));
        jLabel1.setText("TỔNG HỢP THỐNG KÊ");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(tabs)
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(tabs)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cboKhoaHocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboKhoaHocActionPerformed
        this.fillTableBangDiem();
    }//GEN-LAST:event_cboKhoaHocActionPerformed

    private void cboNamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboNamActionPerformed
        this.fillTableDoanhThu();
    }//GEN-LAST:event_cboNamActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if (!flag) {
            MsgBox.alert(this, "Vui lòng chọn hàng!");
            return;
        }
        if (ValidateForm.Rong(txtMatKhauEmailNV, this, "Vui lòng nhập mật khẩu email!")) {
            return;
        }else
            guiMail();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
            xuatFileExel();
    }//GEN-LAST:event_jButton2ActionPerformed
    boolean flag = false;
    private void tblBangDiemMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblBangDiemMouseClicked
         flag = true;
    }//GEN-LAST:event_tblBangDiemMouseClicked

    private void txtMatKhauEmailNVKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtMatKhauEmailNVKeyReleased
        // TODO add your handling code here:
        ValidateForm.mauTrang(txtMatKhauEmailNV);
    }//GEN-LAST:event_txtMatKhauEmailNVKeyReleased

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ThongKeJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ThongKeJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ThongKeJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ThongKeJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ThongKeJDialog dialog = new ThongKeJDialog(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cboKhoaHoc;
    private javax.swing.JComboBox<String> cboNam;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JLabel lblKhoaHoc;
    private javax.swing.JLabel lblNam;
    private javax.swing.JPanel pnlBangDiem;
    private javax.swing.JPanel pnlDiemChuyenDe;
    private javax.swing.JPanel pnlDoanhThu;
    private javax.swing.JPanel pnlKhoaHoc;
    private javax.swing.JPanel pnlNam;
    private javax.swing.JPanel pnlNguoiHoc;
    private javax.swing.JTabbedPane tabs;
    private javax.swing.JTable tblBangDiem;
    private javax.swing.JTable tblDiemChuyenDe;
    private javax.swing.JTable tblDoanhThu;
    private javax.swing.JTable tblNguoiHoc;
    private javax.swing.JPasswordField txtMatKhauEmailNV;
    // End of variables declaration//GEN-END:variables
    ThongKeDAO tkdao = new ThongKeDAO();
    KhoaHocDAO khdao = new KhoaHocDAO();

    private void init() {
        setLocationRelativeTo(null);
        fillComboBoxKhoaHoc();
        fillTableBangDiem();
        fillTableLuongNguoiHoc();
        fillTableDiemChuyenDe();
        fillComBoxNam();
        fillTableDoanhThu();
        this.selectTab(0);
        if (!Auth.isManager()) {//k phải trưởng pòng
            tabs.remove(3);//xóa tab doanh thu
        }
    }

    public void selectTab(int index) {
        tabs.setSelectedIndex(index);
    }

    private void fillTableBangDiem() {
        DefaultTableModel model = (DefaultTableModel) tblBangDiem.getModel();
        model.setRowCount(0);

        KhoaHoc kh = (KhoaHoc) cboKhoaHoc.getSelectedItem();
        List<Object[]> list = tkdao.getBangDiem(kh.getMaKH());

        for (Object[] row : list) {
            double diem = (double) row[2];
            model.addRow(
                    new Object[]{
                        row[0],
                        row[1],
                        diem,
                        getXepLoai(diem)
                    });
        }
    }
    
    private void xuatFileExel(){
        try {
            XSSFWorkbook workbook = new XSSFWorkbook();// tạo workbook
            XSSFSheet spreadsheet = workbook.createSheet("Học viên");// tạo 1 sheet

            XSSFRow row = null;
            Cell cell = null;

            KhoaHoc kh = (KhoaHoc) cboKhoaHoc.getSelectedItem();
            row = spreadsheet.createRow((short) 2);
            row.setHeight((short) 500);
            cell = row.createCell(0, CellType.STRING);
            cell.setCellValue("BẢNG ĐIỂM HỌC VIÊN " + kh.toString());

            row = spreadsheet.createRow((short) 3);
            row.setHeight((short) 500);
            cell = row.createCell(0, CellType.STRING);
            cell.setCellValue("STT");
            cell = row.createCell(0, CellType.STRING);
            cell.setCellValue("Mã người học");
            cell = row.createCell(1, CellType.STRING);
            cell.setCellValue("Họ và tên");
            cell = row.createCell(2, CellType.STRING);
            cell.setCellValue("Điểm");
            cell = row.createCell(3, CellType.STRING);
            cell.setCellValue("Xếp loại");

       
        List<Object[]> list = tkdao.getBangDiem(kh.getMaKH());
        int stt = 0;
        for (Object[] r : list) {
                row = spreadsheet.createRow((short) 4 + stt );
                row.setHeight((short) 400);
                
                String manh =  String.valueOf(r[0]);
                String hoTen =  String.valueOf(r[1]);   
                double diem = (double) r[2];
                String xepLoai =  getXepLoai(diem);
                
                row.createCell(0).setCellValue(stt + 1);
                row.createCell(1).setCellValue(manh);
                row.createCell(2).setCellValue(hoTen);
                row.createCell(3).setCellValue(diem);
                row.createCell(4).setCellValue(xepLoai);  
                stt++;
        }
            JFileChooser jFileChooser = new JFileChooser();
            int chose = jFileChooser.showSaveDialog(this);
            if (chose == JFileChooser.APPROVE_OPTION) {
                File f = new File(jFileChooser.getSelectedFile().getPath());
                FileOutputStream out = new FileOutputStream(f + ".xlsx");
                workbook.write(out);
                out.close();
                MsgBox.alert(this, "Xuất file Exel thành công!");
            }else{
                MsgBox.alert(this, "Lỗi");
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private String getXepLoai(double diem) {
        if (diem < 5) {
            return "Chưa đạt";
        }
        if (diem < 6.5) {
            return "Trung bình";
        }
        if (diem < 7.5) {
            return "Khá";
        }
        if (diem < 9) {
            return "Giỏi";
        }
        return "Xuất sắc";
    }

    private void fillTableLuongNguoiHoc() {//lượng ng học theo năm
        DefaultTableModel model = (DefaultTableModel) tblNguoiHoc.getModel();
        model.setRowCount(0);

        List<Object[]> list = tkdao.getLuongNguoiHoc();
        for (Object[] row : list) {
            model.addRow(row);
        }
    }

    private void fillComBoxNam() {
        DefaultComboBoxModel model = (DefaultComboBoxModel) cboNam.getModel();
        model.removeAllElements();

        List<Integer> list = khdao.selectYears();
        for (Integer year : list) {
            model.addElement(year);
        }
    }

    private void fillTableDoanhThu() {
        DefaultTableModel model = (DefaultTableModel) tblDoanhThu.getModel();
        model.setRowCount(0);

        int nam = (Integer) cboNam.getSelectedItem();
        List<Object[]> list = tkdao.getDoanhThu(nam);
        for (Object[] row : list) {
            model.addRow(row);
        }
    }

    private void fillComboBoxKhoaHoc() {
        DefaultComboBoxModel model = (DefaultComboBoxModel) cboKhoaHoc.getModel();
        model.removeAllElements();

        List<KhoaHoc> list = khdao.selectAll();
        for (KhoaHoc kh : list) {
            model.addElement(kh);
        }
    }

    private void fillTableDiemChuyenDe() {
        DefaultTableModel model = (DefaultTableModel) tblDiemChuyenDe.getModel();
        model.setRowCount(0);

        List<Object[]> list = tkdao.getDiemChuyenDe();
        for (Object[] row : list) {
            model.addRow(new Object[]{
                row[0],
                row[1],
                row[2],
                row[3],
                String.format("%.1f", row[4])
            });
        }
    }
    
    // làm thêm gửi mail
    NguoiHocDAO nhdao = new NguoiHocDAO();
    private void guiMail() {
        KhoaHoc khoaHoc = (KhoaHoc) cboKhoaHoc.getSelectedItem();

        NhanVien nv = Auth.user;
        String emailNV = nv.getEmail();
        String matKhau = txtMatKhauEmailNV.getText();
        for (int row : tblBangDiem.getSelectedRows()) {
            String manh = (String) tblBangDiem.getValueAt(row, 0);
            NguoiHoc nh = nhdao.selectById(manh);
            String email = nh.getEmail();
            String hoTen = (String) tblBangDiem.getValueAt(row, 1);
            Double diem = (Double) tblBangDiem.getValueAt(row, 2);
            String xepLoai = (String) tblBangDiem.getValueAt(row, 3);
            System.out.println(manh + hoTen + diem + email + xepLoai + khoaHoc + emailNV);

            try {
                Properties p = new Properties();
                p.put("mail.smtp.auth", "true");
                p.put("mail.smtp.starttls.enable", "true");
                p.put("mail.smtp.host", "smtp.gmail.com");
                p.put("mail.smtp.port", 587);

                Session s = Session.getInstance(p,
                        new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(emailNV, matKhau);
                    }
                });
                String subject = "Thông báo điểm của bạn trong khóa học " + khoaHoc;
                String body = manh + " " + hoTen + " " + diem + " " + xepLoai;
                
                Message msg = new MimeMessage(s);
                try {
                    msg.setSubject(subject);
                     msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(email));//đến
                msg.setText(body);

                Transport.send(msg);
                } catch (AuthenticationFailedException ex) {
                   MsgBox.alert(this, "Chưa accep hoặc sai mặt khẩu vui lòng xem lại");
                   return;
                }
            } catch(Exception e){
               e.printStackTrace();
            }
        }
        MsgBox.alert(this, "Gửi thành công");
    }
}
