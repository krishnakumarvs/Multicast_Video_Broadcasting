/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import General.Configuration;
import db.Dbcon;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Jithinpv
 */
public class CreateMulticastSubscription extends javax.swing.JFrame {
    
    ArrayList<String> buffer;

    /**
     * Creates new form CreateMulticastSubscription
     */
    public CreateMulticastSubscription() {
        initComponents();
        this.setLocationRelativeTo(null);
        Configuration.setIconOnLabel("choose.jpg", jLabel4);
        
    }
    
    public CreateMulticastSubscription(ArrayList<String> buffer) {
        initComponents();
        this.setLocationRelativeTo(null);
       Configuration.setIconOnLabel("choose.jpg", jLabel4);
        this.buffer = buffer;
        DefaultTableModel model = (DefaultTableModel) oraganisation_table.getModel();
        String arr[] = new String[10];
        int index = 1;
        for (String buff : buffer) {
            String[] split = buff.split("-");
            arr[0] = (index++) + "";
            arr[1] = split[0];
            arr[2] = split[2];
            arr[3] = split[1];
            model.addRow(arr);
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

        jScrollPane1 = new javax.swing.JScrollPane();
        oraganisation_table = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        oraganisation_table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "ORGANIZATION NAME", "COUNTRIES", "STATES"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(oraganisation_table);
        if (oraganisation_table.getColumnModel().getColumnCount() > 0) {
            oraganisation_table.getColumnModel().getColumn(0).setMinWidth(50);
            oraganisation_table.getColumnModel().getColumn(0).setPreferredWidth(50);
            oraganisation_table.getColumnModel().getColumn(0).setMaxWidth(50);
            oraganisation_table.getColumnModel().getColumn(1).setResizable(false);
            oraganisation_table.getColumnModel().getColumn(2).setResizable(false);
            oraganisation_table.getColumnModel().getColumn(3).setResizable(false);
        }

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(22, 52, 537, 99));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("CREATE MULTICAST SUBSCRIPTION");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 20, 290, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Multicast Subscription Name:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(28, 196, 190, -1));
        getContentPane().add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(236, 188, 241, 30));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Description:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(48, 246, 136, -1));

        jTextArea1.setColumns(1);
        jTextArea1.setRows(3);
        jTextArea1.setTabSize(0);
        jScrollPane2.setViewportView(jTextArea1);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(236, 246, 241, 95));

        jButton1.setText("OK");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(305, 352, 68, -1));

        jButton2.setText("BACK");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(236, 352, -1, -1));

        jLabel4.setText("jLabel4");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(-6, -6, 640, 400));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        this.dispose();
        ChooseOrganization chooseOrganization = new ChooseOrganization();
        chooseOrganization.setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        String sub = "";
        String subscription_name = jTextField1.getText();
        String description = jTextArea1.getText();
        if(subscription_name.equals("")){
            JOptionPane.showMessageDialog(rootPane, "Enter subscription name");
        }else if(description.equals("")){
            JOptionPane.showMessageDialog(rootPane, "Enter description");
        }else{
            
      
        Dbcon dbcon = new Dbcon();
        
        int ins = dbcon.insert("insert into tbl_subscription(subscription_name,description,created_at)values('" + subscription_name + "','" + description + "','" + System.currentTimeMillis() + "')");
        if (ins > 0) {
            ResultSet rs = dbcon.select("select max(id) from tbl_subscription ");
            try {
                if (rs.next()) {
                    sub = rs.getString("max(id)");
                    //dbcon.update("update  tbl_subscription_list set subscription_id='"+sub+"' where country_id='"++"'");
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            
            for (int i = 0; i < oraganisation_table.getRowCount(); i++) {
                
                String org_name = oraganisation_table.getValueAt(i, 1).toString();
                String country_name = oraganisation_table.getValueAt(i, 2).toString();
                String state_name = oraganisation_table.getValueAt(i, 3).toString();
                String query = "select state.state_name,country.country_name,org.* from tbl_organization as org,tbl_state as state,tbl_country as country where country.country_id=org.country and state.state_id=org.state and  org.organization_name='" + org_name + "' and  country.country_name='" + country_name + "' and state.state_name='" + state_name + "'";
                System.out.println(query);
                ResultSet r = dbcon.select(query);
                try {
                    if (r.next()) {
                        String org_id = r.getString("organization_id");
                        dbcon.insert("insert into tbl_subscription_list(organization_id,subscription_id)values('" + org_id + "','" + sub + "')");
                    }
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
            JOptionPane.showMessageDialog(rootPane, "inserted successfully");
            this.dispose();
            AdminHome adminHome = new AdminHome();
            adminHome.setVisible(true);
        }
        }
    }//GEN-LAST:event_jButton1ActionPerformed
    
    private void updatesubscriptionList() {
        try {
            Dbcon dbcon = new Dbcon();
            for (String buff : buffer) {
                String[] split = buff.split("-");
                String organisationName = split[0];
                String countyName = split[2];
                String stateName = split[1];
                
                String query = "select organization_id from tbl_organization where ";
                
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

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
            java.util.logging.Logger.getLogger(CreateMulticastSubscription.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CreateMulticastSubscription.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CreateMulticastSubscription.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CreateMulticastSubscription.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            
            public void run() {
                new CreateMulticastSubscription().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTable oraganisation_table;
    // End of variables declaration//GEN-END:variables
}
