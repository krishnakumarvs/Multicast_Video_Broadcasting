/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * LaunchingFrame.java
 *
 * Created on Sep 24, 2016, 10:08:10 PM
 */
package view;

import General.Configuration;
import Network.DataSender;
import db.Dbcon;
import java.io.File;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Arrays;
import java.util.Random;

/**
 *
 * @author kakes
 */
public class LaunchingFrame extends javax.swing.JFrame {

    /** Creates new form LaunchingFrame */
    public LaunchingFrame() {
        initComponents();
        this.setLocationRelativeTo(null);
        Configuration.setIconOnLabel("launch-present.jpg", jLabel3);
    }

    public LaunchingFrame(String presentation, String multicastListName) {
        initComponents();
        this.setLocationRelativeTo(null);
        presentation_name.setText(presentation);
        subscription_list.setText(multicastListName);
        loadOrganisations(multicastListName);
        Configuration.setIconOnLabel("launch-present.jpg", jLabel3);
    }

    private void loadOrganisations(String subscribtionName) {
        try {
            String sql = "SELECT * FROM tbl_subscription AS sub WHERE sub.subscription_name='" + subscribtionName.trim() + "'";
            Dbcon dbcon = new Dbcon();
            ResultSet select = dbcon.select(sql);
            if (select.next()) {
                String subscriptionId = select.getString("id");
                ResultSet rs = dbcon.select("select org.organization_name,org.ip_address,org.port from tbl_subscription_list as sub, tbl_organization as org where sub.organization_id=org.organization_id and subscription_id=" + subscriptionId);

                Object arr[] = new Object[10];

                int count = 0;
                DefaultTableModel model = (DefaultTableModel) subscribtion_list_table.getModel();
                while (rs.next()) {
                    count++;
                    arr[0] = count + "";
                    arr[1] = rs.getString("organization_name");
                    arr[2] = false;
                    arr[3] = rs.getString("port");
                    arr[4] = rs.getString("ip_address");
                    model.addRow(arr);
                }
            } else {
                JOptionPane.showMessageDialog(rootPane, "Such a scubsciption could not be found now");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        presentation_name = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        subscription_list = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        subscribtion_list_table = new javax.swing.JTable();
        jSeparator1 = new javax.swing.JSeparator();
        jButton1 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("Launching presentation");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(28, 24, 133, 30));

        jButton2.setText("HOME");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 326, 78, 25));

        presentation_name.setEditable(false);
        getContentPane().add(presentation_name, new org.netbeans.lib.awtextra.AbsoluteConstraints(193, 24, 185, 30));

        jLabel2.setText("Launching to");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(28, 65, 133, 30));

        subscription_list.setEditable(false);
        getContentPane().add(subscription_list, new org.netbeans.lib.awtextra.AbsoluteConstraints(193, 65, 185, 30));

        subscribtion_list_table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "No", "Organisation", "Sending progress", "port", "ip"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, true, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(subscribtion_list_table);
        subscribtion_list_table.getColumnModel().getColumn(0).setMinWidth(50);
        subscribtion_list_table.getColumnModel().getColumn(0).setPreferredWidth(50);
        subscribtion_list_table.getColumnModel().getColumn(0).setMaxWidth(50);
        subscribtion_list_table.getColumnModel().getColumn(3).setMinWidth(0);
        subscribtion_list_table.getColumnModel().getColumn(3).setPreferredWidth(0);
        subscribtion_list_table.getColumnModel().getColumn(3).setMaxWidth(0);
        subscribtion_list_table.getColumnModel().getColumn(4).setMinWidth(0);
        subscribtion_list_table.getColumnModel().getColumn(4).setPreferredWidth(0);
        subscribtion_list_table.getColumnModel().getColumn(4).setMaxWidth(0);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 126, 419, 194));
        getContentPane().add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 113, 439, -1));

        jButton1.setText("START");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(98, 326, -1, 25));

        jLabel3.setText("jLabel3");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(-6, -6, 450, 400));

        pack();
    }// </editor-fold>//GEN-END:initComponents

private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
    // TODO add your handling code here:
    this.dispose();
    AdminHome adminHome = new AdminHome();
    adminHome.setVisible(true);
}//GEN-LAST:event_jButton2ActionPerformed

    private void launchPresentation() {
        String presentationName = presentation_name.getText().trim();
        try {
            Dbcon dbcon = new Dbcon();
            ResultSet select = dbcon.select("select file_name from tbl_create_presentation where name='" + presentationName + "'");
            if (select.next()) {
                String file_name = select.getString("file_name");
                File presentationFile = new File(Configuration.presentationFolder + file_name);

                for (int i = 0; i < subscribtion_list_table.getRowCount(); i++) {
                    String organisationName = (String) subscribtion_list_table.getValueAt(i, 1);
                    String port = (String) subscribtion_list_table.getValueAt(i, 3);
                    String ipAddress = (String) subscribtion_list_table.getValueAt(i, 4);
                    System.out.println("organisationName " + organisationName);
                    System.out.println("ipAddress " + ipAddress);
                    System.out.println("port " + port);
                    sendFileToOrganisation(organisationName, ipAddress, port, presentationFile, i);
//                    subscribtion_list_table.setValueAt(true, i, 2);
                    // sending logic here
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    int packetDataSize = 100;
    String deLimiter = "#######";

    public static int generateNewFTPPort(int min, int max) {
        Random rand = new Random();
        int randomNum = rand.nextInt((max - min) + 1) + min;
        return randomNum;
    }

    class PresentationEmmiterThread extends Thread {

        int ftpPort;
        String ipAddress;
        File fileToBeSend;
        int row;

        private PresentationEmmiterThread(int ftpPort, String ipAddress, File fileToBeSend, int row) {
            this.ftpPort = ftpPort;
            this.ipAddress = ipAddress;
            this.fileToBeSend = fileToBeSend;
            this.row = row;
        }

        class EachPacket {

            int head;
            String dataContent;
            int length;

            public void setHead(int head) {
                this.head = head;
            }

            public void setDataContent(String dataContent) {
                this.dataContent = dataContent;
            }

            public void setLength(int length) {
                this.length = length;
            }
        }

        public void run() {
            System.out.println("FTP thread listening on " + ftpPort);

            try {
                ServerSocket ssock = new ServerSocket(ftpPort);
                Socket socket = ssock.accept();

                //The InetAddress specification
                InetAddress IA = InetAddress.getByName(Configuration.adminIp);

                //Specify the file
                System.out.println("File to be sent " + fileToBeSend.getAbsolutePath());
                FileInputStream fis = new FileInputStream(fileToBeSend);
                BufferedInputStream bis = new BufferedInputStream(fis);

                //Get socket's output stream
                OutputStream os = socket.getOutputStream();

                //Read File Contents into contents array 
                byte[] contents;
                long fileLength = fileToBeSend.length();
                long current = 0;

                int counter = 0;

                long start = System.nanoTime();
                while (current != fileLength) {
                    int size = 10000;
                    EachPacket eachPacket = new EachPacket();
                    eachPacket.setHead(counter);
                    counter++;
                    if (fileLength - current >= size) {
                        current += size;
                    } else {
                        size = (int) (fileLength - current);
                        current = fileLength;
                    }
                    contents = new byte[size];
                    eachPacket.setDataContent(new String(contents));
                    eachPacket.setLength(size);
                    bis.read(contents, 0, size);
                    os.write(contents);
                    int percentagee = (int) ((current * 100) / fileLength);
                    System.out.println("Sending file ... " + percentagee + "% complete!");
                    subscribtion_list_table.setValueAt(percentagee + " %", row, 2);
                }

                os.flush();
                //File transfer done. Close the socket connection!
                socket.close();
                ssock.close();
                System.out.println("File sent succesfully!");
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }

    private void sendFileToOrganisation(String organisation, String ipAddress, String port, File fileToBeSend, int row) {
        System.out.println("Sending file " + fileToBeSend.getPath());
        System.out.println("To " + ipAddress + " with port " + port);

        int ftpPort = generateNewFTPPort(3000, 9999);

        new PresentationEmmiterThread(ftpPort, ipAddress, fileToBeSend, row).start();
        String vedioActivationString = Configuration.adminIp + deLimiter + ftpPort + deLimiter + fileToBeSend.getName();

        DataSender dataSender = new DataSender();
        dataSender.sendNow(vedioActivationString, ipAddress, Integer.parseInt(port));
        // send ping request to client

        try {
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String getStringFormat(byte[] dataArray) {
        return Base64.encode(dataArray);
    }

    class launchThread extends Thread {

        public void run() {
            launchPresentation();
        }
    }
private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed


    new launchThread().start();

}//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(LaunchingFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LaunchingFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LaunchingFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LaunchingFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new LaunchingFrame().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField presentation_name;
    private javax.swing.JTable subscribtion_list_table;
    private javax.swing.JTextField subscription_list;
    // End of variables declaration//GEN-END:variables
}
