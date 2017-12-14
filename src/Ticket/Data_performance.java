/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ticket;

import java.util.*;
import javax.swing.*;

/**
 *
 * @author 7조
 */
public class Data_performance extends javax.swing.JFrame {
    DefaultListModel model = new DefaultListModel();
    java.util.List<String> code = new ArrayList<>();
    static String listcode = "0";
    static int pagecode = 1;
    static int pascode = 0;
    /**
     * Creates new form Home_Data
     */
    public void lodelist() {
        ConnectPas con = new ConnectPas(pascode, listcode, pagecode);
        
        con.datacode.forEach((imsi) -> {
            model.addElement(imsi);
        });
        jList1.setModel(model); //파싱데이터 불러오기
        
        con.contcode.forEach((imsi) -> {
            code.add(imsi);
        });
    }
    
    public Data_performance() {
        initComponents();
        listcode = "0";
        pagecode = 1;
        lodelist();
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
        jLabel7 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        HomeButton = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        MusicDance = new javax.swing.JButton();
        Exhibit = new javax.swing.JButton();
        Festival = new javax.swing.JButton();
        Musical = new javax.swing.JButton();
        jButtonF = new javax.swing.JButton();
        jButtonN = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel7.setFont(new java.awt.Font("THE왼손잡이", 1, 48)); // NOI18N
        jLabel7.setText("공연");

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel2MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 129, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 80, Short.MAX_VALUE)
        );

        HomeButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/folder/KakaoTalk_20171212_174724068.png"))); // NOI18N
        HomeButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                HomeButtonMousePressed(evt);
            }
        });
        HomeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HomeButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jLabel7)
                .addGap(118, 118, 118)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(HomeButton)
                .addGap(37, 37, 37))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(HomeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jList1.setFont(new java.awt.Font("나눔고딕", 1, 16)); // NOI18N
        jList1.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "서버에 연결되지 않았습니다." };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jList1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jList1.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                jList1ValueChanged(evt);
            }
        });
        jScrollPane2.setViewportView(jList1);

        jTextArea1.setEditable(false);
        jTextArea1.setColumns(20);
        jTextArea1.setFont(new java.awt.Font("나눔고딕", 0, 18)); // NOI18N
        jTextArea1.setLineWrap(true);
        jTextArea1.setRows(5);
        jTextArea1.setText("선택한 항목의 상세정보가 출력됩니다.");
        jScrollPane1.setViewportView(jTextArea1);

        MusicDance.setFont(new java.awt.Font("THE왼손잡이", 0, 24)); // NOI18N
        MusicDance.setText("음악/무용");
        MusicDance.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MusicDanceActionPerformed(evt);
            }
        });

        Exhibit.setFont(new java.awt.Font("THE왼손잡이", 0, 24)); // NOI18N
        Exhibit.setText("전시/행사");
        Exhibit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ExhibitActionPerformed(evt);
            }
        });

        Festival.setFont(new java.awt.Font("THE왼손잡이", 0, 24)); // NOI18N
        Festival.setText("축제");
        Festival.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FestivalActionPerformed(evt);
            }
        });

        Musical.setFont(new java.awt.Font("THE왼손잡이", 0, 24)); // NOI18N
        Musical.setText("연극");

        jButtonF.setText("<");
        jButtonF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonFActionPerformed(evt);
            }
        });

        jButtonN.setText(">");
        jButtonN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonNActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(276, Short.MAX_VALUE)
                .addComponent(Musical, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(MusicDance, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(Exhibit, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(Festival, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(275, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 279, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(127, 127, 127)
                        .addComponent(jButtonF)
                        .addGap(18, 18, 18)
                        .addComponent(jButtonN)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 707, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(7, 7, 7)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(MusicDance, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Exhibit, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Festival, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Musical, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 337, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jScrollPane2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButtonF)
                            .addComponent(jButtonN))))
                .addContainerGap(49, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jPanel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel2MouseClicked
        // TODO add your handling code here:
        //new Home().show();
        
    }//GEN-LAST:event_jPanel2MouseClicked

    private void MusicDanceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MusicDanceActionPerformed
        // TODO add your handling code here:
        //dispose();
        listcode = "2"; 
        pagecode = 1;
        model.clear();
        code.clear();
        lodelist();
        jList1.repaint();
    }//GEN-LAST:event_MusicDanceActionPerformed

    private void ExhibitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ExhibitActionPerformed
        // TODO add your handling code here:
        //dispose();
        listcode = "1"; 
        pagecode = 1;
        model.clear();
        code.clear();
        lodelist();
        jList1.repaint();
    }//GEN-LAST:event_ExhibitActionPerformed

    private void FestivalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FestivalActionPerformed
        // TODO add your handling code here:
        //dispose();
        listcode = "3"; 
        pagecode = 1;
        model.clear();
        code.clear();
        lodelist();
        jList1.repaint();
    }//GEN-LAST:event_FestivalActionPerformed

    private void HomeButtonMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_HomeButtonMousePressed
        new Home().show();  // TODO add your handling code here:
    }//GEN-LAST:event_HomeButtonMousePressed

    private void HomeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HomeButtonActionPerformed

        dispose();        // TODO add your handling code here:
    }//GEN-LAST:event_HomeButtonActionPerformed

    private void jList1ValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_jList1ValueChanged
        // TODO add your handling code here:
        int i = jList1.getSelectedIndex();
        if(i == -1) {
            
        }
        else {
            ConnectPas con = new ConnectPas(pascode, listcode, code.get(i));
            jTextArea1.setText(con.content); //파싱데이터 불러오기
            jTextArea1.removeAll();
            jTextArea1.repaint();
        }
    }//GEN-LAST:event_jList1ValueChanged

    private void jButtonNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonNActionPerformed
        // TODO add your handling code here:
        if(jList1.getModel().getSize() == 0) {
            JOptionPane.showMessageDialog(null, "비어있는 페이지입니다!",
                    "경고", JOptionPane.WARNING_MESSAGE);
            pagecode--;
            model.clear();
            code.clear();
            lodelist();
            jList1.repaint();
        }
        else {
            pagecode++;
            model.clear();
            code.clear();
            lodelist();
            jList1.repaint();
        }
    }//GEN-LAST:event_jButtonNActionPerformed

    private void jButtonFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonFActionPerformed
        // TODO add your handling code here:
        if(pagecode == 1) {
            JOptionPane.showMessageDialog(null, "첫번째 페이지입니다!",
                    "경고", JOptionPane.WARNING_MESSAGE);
        }
        else {
            pagecode--;
            model.clear();
            code.clear();
            lodelist();
            jList1.repaint();
        }
    }//GEN-LAST:event_jButtonFActionPerformed

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
            java.util.logging.Logger.getLogger(Data_performance.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Data_performance.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Data_performance.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Data_performance.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Data_performance().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Exhibit;
    private javax.swing.JButton Festival;
    private javax.swing.JButton HomeButton;
    private javax.swing.JButton MusicDance;
    private javax.swing.JButton Musical;
    private javax.swing.JButton jButtonF;
    private javax.swing.JButton jButtonN;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JList<String> jList1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea jTextArea1;
    // End of variables declaration//GEN-END:variables
}
