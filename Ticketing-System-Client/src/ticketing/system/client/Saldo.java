/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package ticketing.system.client;

import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Salman Alfarizi
 */
public class Saldo extends javax.swing.JPanel {

    /**
     * Creates new form Saldo
     */
    private DashBoard parent;
    int idUser;
    public Saldo() {
        initComponents();
    }
     public Saldo(DashBoard p,int id) {
        this();
        parent = p;
        idUser = id;
        RefreshTabel(idUser);
    }
    private void RefreshTabel(int idUser){
        DefaultTableModel dtm = (DefaultTableModel) tableSaldo.getModel();
        dtm.setRowCount(0);
        Object[] rowData = new Object[2];
        
        java.util.List<ticketing.system.client.HistoryTransaksi> listTransaksi = dataHistoryTransaksi(idUser);
        for ( ticketing.system.client.HistoryTransaksi obj : listTransaksi)
        {
            if (obj instanceof ticketing.system.client.HistoryTransaksi)
            {
                ticketing.system.client.HistoryTransaksi tampung = (ticketing.system.client.HistoryTransaksi)obj;
                rowData[0]=tampung.getId();
                rowData[1]=tampung.getJumlah();
                dtm.addRow(rowData);
            }
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

        jTextFieldUsername = new javax.swing.JTextField();
        jTextFieldSaldo = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jButtonBack = new javax.swing.JButton();
        jButtonTopup = new javax.swing.JButton();
        kGradientPanel1 = new keeptoo.KGradientPanel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableSaldo = new javax.swing.JTable();

        jTextFieldUsername.setEditable(false);

        jTextFieldSaldo.setEditable(false);

        jLabel3.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel3.setText("USERNAME :");

        jLabel4.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel4.setText("CURRENT SALDO :");

        jButtonBack.setFont(new java.awt.Font("SansSerif", 1, 15)); // NOI18N
        jButtonBack.setText("BACK");
        jButtonBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBackActionPerformed(evt);
            }
        });

        jButtonTopup.setFont(new java.awt.Font("SansSerif", 1, 15)); // NOI18N
        jButtonTopup.setText("TOPUP");
        jButtonTopup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonTopupActionPerformed(evt);
            }
        });

        kGradientPanel1.setkEndColor(new java.awt.Color(0, 255, 204));
        kGradientPanel1.setkStartColor(new java.awt.Color(0, 102, 153));

        jLabel2.setFont(new java.awt.Font("SansSerif", 1, 48)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("INFO SALDO");

        javax.swing.GroupLayout kGradientPanel1Layout = new javax.swing.GroupLayout(kGradientPanel1);
        kGradientPanel1.setLayout(kGradientPanel1Layout);
        kGradientPanel1Layout.setHorizontalGroup(
            kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel1Layout.createSequentialGroup()
                .addGap(297, 297, 297)
                .addComponent(jLabel2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        kGradientPanel1Layout.setVerticalGroup(
            kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel1Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel2)
                .addContainerGap(38, Short.MAX_VALUE))
        );

        tableSaldo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "ID", "Jumlah", "Keterangan"
            }
        ));
        tableSaldo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableSaldoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tableSaldo);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(kGradientPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextFieldUsername, javax.swing.GroupLayout.DEFAULT_SIZE, 210, Short.MAX_VALUE)
                            .addComponent(jTextFieldSaldo)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButtonBack)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButtonTopup)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 427, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(kGradientPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jTextFieldUsername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(jTextFieldSaldo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButtonBack)
                            .addComponent(jButtonTopup))))
                .addGap(0, 43, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBackActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_jButtonBackActionPerformed

    private void jButtonTopupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonTopupActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_jButtonTopupActionPerformed

    private void tableSaldoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableSaldoMouseClicked
        // TODO add your handling code here:

    }//GEN-LAST:event_tableSaldoMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonBack;
    private javax.swing.JButton jButtonTopup;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextFieldSaldo;
    private javax.swing.JTextField jTextFieldUsername;
    private keeptoo.KGradientPanel kGradientPanel1;
    private javax.swing.JTable tableSaldo;
    // End of variables declaration//GEN-END:variables

    private static java.util.List<ticketing.system.client.HistoryTransaksi> dataHistoryTransaksi(int id) {
        ticketing.system.client.TicketingService_Service service = new ticketing.system.client.TicketingService_Service();
        ticketing.system.client.TicketingService port = service.getTicketingServicePort();
        return port.dataHistoryTransaksi(id);
    }
}
