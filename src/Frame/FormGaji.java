/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Frame;

import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.DriverManager;
import koneksi.database;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.sql.Statement;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author User
 */
public class FormGaji extends javax.swing.JFrame {
 
    private database obj;
    private DefaultTableModel modelTabelGaji; 
    
    
    
    /**
     * Creates new form FormGaji
     */
    public FormGaji() {
        initComponents();
        this.setLocationRelativeTo(null);
        
        obj = new database();
        modelTabelGaji = new DefaultTableModel();
        TabelGaji.setModel(modelTabelGaji);
        modelTabelGaji.addColumn("ID GAJI");
        modelTabelGaji.addColumn("ID PEGAWAI");
        modelTabelGaji.addColumn("JUMLAH GAJI");
        modelTabelGaji.addColumn("TANGGAL PEMBAYARAN");
        tampilDataGaji();
       
    }
    
    public void tampilDataGaji() {
         try {
            modelTabelGaji.setRowCount(0);

            String query = "SELECT * FROM tb_gaji";
            try (PreparedStatement preparedStatement = obj.konek.prepareStatement(query);
                 ResultSet data = preparedStatement.executeQuery()) {
                while (data.next()) {
                    Object[] line = new Object[4];
                    line[0] = data.getString("id_gaji");
                    line[1] = data.getString("id_pegawai");
                    line[2] = data.getString("jumlah_gaji");
                    line[3] = data.getString("tanggal_pembayaran");
                    modelTabelGaji.addRow(line);
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
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
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        tfIdGaji = new javax.swing.JTextField();
        tfIdPegawai = new javax.swing.JTextField();
        tfJmlhGaji = new javax.swing.JTextField();
        tfTglPembayaran = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        TabelGaji = new javax.swing.JTable();
        btnSimpan = new javax.swing.JButton();
        btnUbah = new javax.swing.JButton();
        btnHapus = new javax.swing.JButton();
        btnClear = new javax.swing.JButton();
        btnCetak = new javax.swing.JButton();
        btnKeluar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 98, 176));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Form Gaji"));
        jPanel1.setForeground(new java.awt.Color(255, 153, 153));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel1.setText("ID Gaji");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setText("ID Pegawai");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setText("Jumlah Gaji");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setText(" Tanggal Pembayaran");

        tfIdGaji.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N

        tfIdPegawai.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N

        tfJmlhGaji.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N

        tfTglPembayaran.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        tfTglPembayaran.setText("00/00/00");

        TabelGaji.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        TabelGaji.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TabelGajiMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(TabelGaji);

        btnSimpan.setBackground(new java.awt.Color(204, 204, 204));
        btnSimpan.setText("SIMPAN");
        btnSimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSimpanActionPerformed(evt);
            }
        });

        btnUbah.setBackground(new java.awt.Color(204, 204, 204));
        btnUbah.setText("UBAH");
        btnUbah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUbahActionPerformed(evt);
            }
        });

        btnHapus.setBackground(new java.awt.Color(204, 204, 204));
        btnHapus.setText("HAPUS");
        btnHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHapusActionPerformed(evt);
            }
        });

        btnClear.setBackground(new java.awt.Color(204, 204, 204));
        btnClear.setText("CLEAR");
        btnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearActionPerformed(evt);
            }
        });

        btnCetak.setBackground(new java.awt.Color(204, 204, 204));
        btnCetak.setText("CETAK");
        btnCetak.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCetakActionPerformed(evt);
            }
        });

        btnKeluar.setBackground(new java.awt.Color(204, 204, 204));
        btnKeluar.setText("KELUAR");
        btnKeluar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKeluarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(197, 197, 197)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnHapus)
                            .addComponent(btnSimpan))
                        .addGap(44, 44, 44)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnUbah)
                            .addComponent(btnClear))
                        .addGap(47, 47, 47)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnKeluar)
                            .addComponent(btnCetak)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addGap(25, 25, 25)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(tfIdGaji, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 117, Short.MAX_VALUE)
                                .addComponent(tfIdPegawai, javax.swing.GroupLayout.Alignment.LEADING))
                            .addComponent(tfJmlhGaji, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfTglPembayaran, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(34, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(tfIdGaji, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(28, 28, 28)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(tfIdPegawai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(tfJmlhGaji, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(tfTglPembayaran, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(53, 53, 53)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnUbah)
                    .addComponent(btnSimpan)
                    .addComponent(btnKeluar))
                .addGap(16, 16, 16)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCetak)
                    .addComponent(btnClear)
                    .addComponent(btnHapus))
                .addContainerGap(85, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnUbahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUbahActionPerformed
      try {
        if (tfIdGaji.getText().isEmpty() || tfIdPegawai.getText().isEmpty() ||
            tfJmlhGaji.getText().isEmpty() || tfTglPembayaran.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Silahkan isi semua data terlebih dahulu!");
        } else {
        // Bagian untuk INSERT
        String sqlInsert = "INSERT INTO tb_gaji (id_gaji, id_pegawai, jumlah_gaji, tanggal_pembayaran) " +
                           "VALUES (?, ?, ?, ?)";
        PreparedStatement insertStmt = obj.konek.prepareStatement(sqlInsert);

        insertStmt.setString(1, tfIdGaji.getText());
        insertStmt.setString(2, tfIdPegawai.getText());
        insertStmt.setString(3, tfJmlhGaji.getText());
        insertStmt.setString(4, tfTglPembayaran.getText());

        // Bagian untuk UPDATE
        String sqlUpdate = "UPDATE tb_gaji SET id_pegawai=?, jumlah_gaji=?, " +
                           "tanggal_pembayaran=? WHERE id_gaji=?";
        PreparedStatement updateStmt = obj.konek.prepareStatement(sqlUpdate);

        updateStmt.setString(1, tfIdPegawai.getText());
        updateStmt.setString(2, tfJmlhGaji.getText());
        updateStmt.setString(3, tfTglPembayaran.getText());
        updateStmt.setString(4, tfIdGaji.getText());

        // Eksekusi query UPDATE
        int hasilUpdate = updateStmt.executeUpdate();

        // Jika tidak ada baris yang terpengaruh (data tidak ada), eksekusi query INSERT
        if (hasilUpdate == 0) {
            int hasilInsert = insertStmt.executeUpdate();

            if (hasilInsert > 0) {
                tampilDataGaji();
                JOptionPane.showMessageDialog(this, "Data Berhasil Diubah!");
            } else {
                JOptionPane.showMessageDialog(this, "Gagal mengubah data. Pastikan ID Gaji yang dimasukkan benar.");
            }
        } else {
            tampilDataGaji();
            JOptionPane.showMessageDialog(this, "Data Berhasil Diubah!");
        }
    }
} catch (Exception e) {
    JOptionPane.showMessageDialog(this, "Error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
}

    }//GEN-LAST:event_btnUbahActionPerformed

    private void btnHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHapusActionPerformed
      try {
        // Mengecek apakah semua kolom input kosong
        if (tfIdGaji.getText().isEmpty() && tfIdPegawai.getText().isEmpty()
                && tfJmlhGaji.getText().isEmpty() && tfTglPembayaran.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Silahkan pilih data terlebih dahulu!");
        } else {
            // Menampilkan dialog konfirmasi sebelum menghapus
            int confirmDialogResult = JOptionPane.showConfirmDialog(this,
                    "Apakah Anda yakin ingin menghapus data?", "Konfirmasi Hapus",
                    JOptionPane.YES_NO_OPTION);

            // Jika pengguna mengonfirmasi untuk menghapus
            if (confirmDialogResult == JOptionPane.YES_OPTION) {
                // Query SQL untuk menghapus data dari tabel gaji
                String sql = "DELETE FROM tb_gaji WHERE id_gaji=?";
                
                // Menggunakan try-with-resources untuk PreparedStatement
                try (PreparedStatement hapus = obj.konek.prepareStatement(sql)) {
                    hapus.setString(1, tfIdGaji.getText());
                    
                    // Menjalankan query DELETE dan mendapatkan jumlah baris yang terpengaruh
                    int rowsAffected = hapus.executeUpdate();

                    // Jika ada baris yang terpengaruh, berarti data berhasil dihapus
                    if (rowsAffected > 0) {
                        tampilDataGaji();
                        JOptionPane.showMessageDialog(this, "Data Berhasil Dihapus!");
                    } else {
                        // Jika tidak ada baris yang terpengaruh, berarti data tidak ditemukan
                        JOptionPane.showMessageDialog(this, "Gagal menghapus data. Data tidak ditemukan.");
                    }
                }
            }
        }
    } catch (SQLException | HeadlessException e) {
        // Menangani kesalahan dan menampilkan pesan kesalahan kepada pengguna
        JOptionPane.showMessageDialog(this, "Terjadi kesalahan: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    }
    }//GEN-LAST:event_btnHapusActionPerformed

    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed
        tfIdGaji.setText("");
        tfIdPegawai.setText("");
        tfJmlhGaji.setText("");
        tfTglPembayaran.setText("");
    }//GEN-LAST:event_btnClearActionPerformed

    private void btnSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSimpanActionPerformed
         try {
           if (tfIdGaji.getText().isEmpty()) {
               JOptionPane.showMessageDialog(this, "ID Gaji belum Diisi");
               tfIdGaji.requestFocus();
           } else if (tfIdPegawai.getText().isEmpty()) {
               JOptionPane.showMessageDialog(this, "ID Pegawai belum Diisi");
               tfIdPegawai.requestFocus();
           } else if (tfJmlhGaji.getText().isEmpty()) {
               JOptionPane.showMessageDialog(this, "Jumlah Gaji belum diisi");
               tfJmlhGaji.requestFocus();
           } else if (tfTglPembayaran.getText().isEmpty()) {
               JOptionPane.showMessageDialog(this, "Tanggal Pembayaran belum diisi");
               tfTglPembayaran.requestFocus();
           } else {
               String sql = "insert into tb_gaji value('"+tfIdGaji.getText()+"','"+tfIdPegawai.getText()+"','"+tfJmlhGaji.getText()+"','"+tfTglPembayaran.getText()+"')";
               obj.konek.createStatement().execute(sql);
               JOptionPane.showMessageDialog(this, "Data Berhasil Disimpan");
           }
           tampilDataGaji();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.toString());
        }
    }//GEN-LAST:event_btnSimpanActionPerformed

    private void TabelGajiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TabelGajiMouseClicked
        int baris = TabelGaji.getSelectedRow();
        String id_gaji = TabelGaji.getValueAt(baris, 0).toString();
        String id_pegawai = TabelGaji.getValueAt(baris, 1).toString();
        String jumlah_gaji = TabelGaji.getValueAt(baris, 2).toString();
        String tanggal_pembayaran = TabelGaji.getValueAt(baris, 3).toString();
        tfIdGaji.setText(id_gaji);
        tfIdPegawai.setText(id_pegawai);
        tfJmlhGaji.setText(jumlah_gaji);
        tfTglPembayaran.setText(tanggal_pembayaran);
    }//GEN-LAST:event_TabelGajiMouseClicked

    private void btnCetakActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCetakActionPerformed
      String path = ".\\src\\report\\LaporanGaji.jasper";
        try {
        // Mengatur koneksi database (gantilah parameter koneksi dengan yang sesuai)
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/dbkepegawaian", "root", "");

        // Mengisi laporan dengan data dari database
        JasperPrint jprint = JasperFillManager.fillReport(path, null, conn);

        // Menampilkan laporan menggunakan JasperViewer
        JasperViewer jviewer = new JasperViewer(jprint, false);
        jviewer.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        jviewer.setVisible(true);

        // Menutup koneksi database setelah selesai
        conn.close();
     } catch (JRException | SQLException e) {
        // Menangkap dan menampilkan exception
        e.printStackTrace();
        JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
     }
    }//GEN-LAST:event_btnCetakActionPerformed

    private void btnKeluarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKeluarActionPerformed
        new FormUtama().setVisible(true);
        dispose();
    }//GEN-LAST:event_btnKeluarActionPerformed

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
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FormGaji.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormGaji.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormGaji.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormGaji.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormGaji().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable TabelGaji;
    private javax.swing.JButton btnCetak;
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnHapus;
    private javax.swing.JButton btnKeluar;
    private javax.swing.JButton btnSimpan;
    private javax.swing.JButton btnUbah;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField tfIdGaji;
    private javax.swing.JTextField tfIdPegawai;
    private javax.swing.JTextField tfJmlhGaji;
    private javax.swing.JTextField tfTglPembayaran;
    // End of variables declaration//GEN-END:variables
}
