/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package ticketing.system.client;

import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Lenovo
 */
public class FormSlotParkir extends javax.swing.JFrame {

    /**
     * Creates new form FormSlotParkir
     */
    FormParkir parent;
    Parkir parkir;
    java.util.List<ticketing.system.client.SlotParkir> listSlotParkir;
    java.util.List<ticketing.system.client.JamParkir> listJamParkir;
    SlotParkir selectedSlotParkir;
    public FormSlotParkir() {
        initComponents();        
    }
    public FormSlotParkir(FormParkir p, Parkir selectedParkir) {
        this();
        parent = p;
        parkir = selectedParkir; 
        RefreshTable();
        RefreshJamParkir();                 
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
        jScrollPane1 = new javax.swing.JScrollPane();
        jTabelParkir = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTextFieldNama = new javax.swing.JTextField();
        jTextFieldLokasi = new javax.swing.JTextField();
        jButtonBook = new javax.swing.JButton();
        jComboBoxJamParkir = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new java.awt.CardLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jTabelParkir.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Kode", "Harga"
            }
        ));
        jTabelParkir.setRowHeight(40);
        jTabelParkir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTabelParkirMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTabelParkir);

        jLabel1.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(102, 102, 102));
        jLabel1.setText("Kode :");

        jLabel3.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLabel3.setText("Tanggal:");

        jTextFieldNama.setEditable(false);
        jTextFieldNama.setEnabled(false);

        jTextFieldLokasi.setEnabled(false);

        jButtonBook.setBackground(new java.awt.Color(0, 51, 51));
        jButtonBook.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButtonBook.setForeground(new java.awt.Color(255, 255, 255));
        jButtonBook.setText("Book");
        jButtonBook.setEnabled(false);
        jButtonBook.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBookActionPerformed(evt);
            }
        });

        jComboBoxJamParkir.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBoxJamParkirItemStateChanged(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(102, 102, 102));
        jLabel4.setText("Jam Parkir :");

        kGradientPanel3.setkEndColor(new java.awt.Color(0, 51, 51));
        kGradientPanel3.setkStartColor(new java.awt.Color(0, 102, 153));
        kGradientPanel3.setkTransparentControls(false);

        btnParkir.setBackground(new java.awt.Color(255, 255, 255));
        btnParkir.setFont(new java.awt.Font("SansSerif", 1, 48)); // NOI18N
        btnParkir.setForeground(new java.awt.Color(255, 255, 255));
        btnParkir.setText("Parkir");

        javax.swing.GroupLayout kGradientPanel3Layout = new javax.swing.GroupLayout(kGradientPanel3);
        kGradientPanel3.setLayout(kGradientPanel3Layout);
        kGradientPanel3Layout.setHorizontalGroup(
            kGradientPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel3Layout.createSequentialGroup()
                .addGap(529, 529, 529)
                .addComponent(btnParkir)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        kGradientPanel3Layout.setVerticalGroup(
            kGradientPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel3Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(btnParkir, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(43, Short.MAX_VALUE))
        );

        jDateChooser1.setDate(new java.util.Date());
        jDateChooser1.setMinSelectableDate(new java.util.Date());
        jDateChooser1.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jDateChooser1PropertyChange(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLabel5.setText("Harga:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(btnSlotParkir))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(118, 118, 118)
                                .addComponent(jButtonBook))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel5))
                                .addGap(72, 72, 72)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jComboBoxJamParkir, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jTextFieldLokasi, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 158, Short.MAX_VALUE)
                                    .addComponent(jTextFieldNama, javax.swing.GroupLayout.DEFAULT_SIZE, 158, Short.MAX_VALUE)
                                    .addComponent(jDateChooser1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 760, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(7, 7, 7))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(kGradientPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextFieldNama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextFieldLokasi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(17, 17, 17)
                                .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jLabel3)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jComboBoxJamParkir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonBook, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(14, 14, 14))
        );

        getContentPane().add(jPanel1, "card2");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTabelParkirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabelParkirMouseClicked
        JTable klik = (JTable) evt.getSource();
        int row = klik.getSelectedRow();

        jTextFieldNama.setText(klik.getValueAt(row, 0).toString());
        jTextFieldLokasi.setText(klik.getValueAt(row, 1).toString());

        selectedSlotParkir = listSlotParkir.get(row);
        refreshButtonBook();
    }//GEN-LAST:event_jTabelParkirMouseClicked

    private void RefreshTable()
    {
        listSlotParkir = getSlotParkir(parkir.id);
        
        jTabelParkir.removeAll();
        
        DefaultTableModel model = (DefaultTableModel) jTabelParkir.getModel();
        model.setRowCount(0);
        Object[] rowData=new Object[2];
        
        for ( ticketing.system.client.SlotParkir obj : listSlotParkir)
        {            
            ticketing.system.client.SlotParkir tampung = (ticketing.system.client.SlotParkir)obj;
            rowData[0]=tampung.getKode();                
            rowData[1]=tampung.getHarga();                            
            model.addRow(rowData);
        }
    }
    private void RefreshJamParkir(){
        jComboBoxJamParkir.removeAllItems();
        listJamParkir = getJamParkir();
        for(JamParkir jp : listJamParkir){
            jComboBoxJamParkir.addItem(jp.jamMulai + " - " + jp.jamSelesai);
        }
    }
    private void refreshButtonBook(){
        if(selectedSlotParkir != null){
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            if(cekKetersediaanSlotParkir(selectedSlotParkir.getParkir().getId(),selectedSlotParkir.getKode(),listJamParkir.get(jComboBoxJamParkir.getSelectedIndex()).getId(),sdf.format(jDateChooser1.getDate()))){
                jButtonBook.setEnabled(true);
            }
            else{
                jButtonBook.setEnabled(false);
            }
        
        }
        
    }
    private void jButtonBookActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBookActionPerformed
        // TODO add your handling code here:        
        if(JOptionPane.showConfirmDialog(this, "Apakah anda yakin ingin memesan?","Konfirmasi",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE)== JOptionPane.YES_OPTION){
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            if(tambahNotaParkir(parent.parent.idUserLogin, sdf.format(jDateChooser1.getDate()), parkir.getId(), selectedSlotParkir.getKode(), listJamParkir.get(jComboBoxJamParkir.getSelectedIndex()).getId())){
                JOptionPane.showMessageDialog(parent, "Booking berhasil");
                parent.setVisible(true);
                this.dispose();
            }
            else{
                JOptionPane.showMessageDialog(parent, "Booking gagal");
            }
        }
    }//GEN-LAST:event_jButtonBookActionPerformed

    private void jDateChooser1PropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jDateChooser1PropertyChange
        // TODO add your handling code here:       
        refreshButtonBook();
    }//GEN-LAST:event_jDateChooser1PropertyChange

    private void jComboBoxJamParkirItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBoxJamParkirItemStateChanged
        // TODO add your handling code here:
        refreshButtonBook();
    }//GEN-LAST:event_jComboBoxJamParkirItemStateChanged

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
            java.util.logging.Logger.getLogger(FormSlotParkir.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormSlotParkir.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormSlotParkir.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormSlotParkir.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormSlotParkir().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btnParkir;
    private javax.swing.JButton jButtonBook;
    private javax.swing.JComboBox<String> jComboBoxJamParkir;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTabelParkir;
    private javax.swing.JTextField jTextFieldLokasi;
    private javax.swing.JTextField jTextFieldNama;
    // End of variables declaration//GEN-END:variables

    private static java.util.List<ticketing.system.client.SlotParkir> getSlotParkir(int idParkir) {
        ticketing.system.client.TicketingService_Service service = new ticketing.system.client.TicketingService_Service();
        ticketing.system.client.TicketingService port = service.getTicketingServicePort();
        return port.getSlotParkir(idParkir);
    }

    private static java.util.List<ticketing.system.client.JamParkir> getJamParkir() {
        ticketing.system.client.TicketingService_Service service = new ticketing.system.client.TicketingService_Service();
        ticketing.system.client.TicketingService port = service.getTicketingServicePort();
        return port.getJamParkir();
    }

    private static Boolean cekKetersediaanSlotParkir(int parkirId, java.lang.String kode, int jamParkirId, java.lang.String tanggalBooking) {
        ticketing.system.client.TicketingService_Service service = new ticketing.system.client.TicketingService_Service();
        ticketing.system.client.TicketingService port = service.getTicketingServicePort();
        return port.cekKetersediaanSlotParkir(parkirId, kode, jamParkirId, tanggalBooking);
    }

    private static boolean tambahNotaParkir(int idUser, java.lang.String tanggalBooking, int parkirId, java.lang.String slotParkirKode, int jamParkirId) {
        ticketing.system.client.TicketingService_Service service = new ticketing.system.client.TicketingService_Service();
        ticketing.system.client.TicketingService port = service.getTicketingServicePort();
        return port.tambahNotaParkir(idUser, tanggalBooking, parkirId, slotParkirKode, jamParkirId);
    }




}
