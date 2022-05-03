package laba4;

import java.sql.*;
import java.util.Arrays;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class ProkatInfo extends javax.swing.JFrame {

    public ProkatInfo() {
        initComponents();
        Connect();
        Load();
    }
    
    Connection conn;
    Statement s;
    PreparedStatement pst;
    ResultSet rs;
    DefaultTableModel d;
    
    public void Connect()
    {
        try 
        {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/prokattovara","root","root");       
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ProkatInfo.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ProkatInfo.class.getName()).log(Level.SEVERE, null, ex);
        }   
    }
    
    public void Load()
    {
        try 
        {
            pst = conn.prepareStatement("select * from prokatinfo");
            rs = pst.executeQuery();
            
            ResultSetMetaData rsd = rs.getMetaData();
            int c = rsd.getColumnCount();
            d = (DefaultTableModel)jTable1.getModel();
            d.setRowCount(0);
            
            while(rs.next())
            {
                Vector v = new Vector();
                for(int i = 0; i <= c; i++)
                {
                    v.add(rs.getString("id_pr"));
                    v.add(rs.getString("name"));
                    v.add(rs.getString("kod"));
                    v.add(rs.getString("count"));
                    v.add(rs.getString("starttime"));
                    v.add(rs.getString("endtime"));
                    v.add(rs.getString("datareg"));
                    v.add(rs.getString("fnameprod"));
                    v.add(rs.getString("lnameprod"));
                }
                d.addRow(v);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProkatInfo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 0, 0));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 40)); // NOI18N
        jLabel1.setText("Инфо о прокате товара");

        jButton1.setBackground(new java.awt.Color(255, 153, 153));
        jButton1.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jButton1.setText("Добавить");
        jButton1.setToolTipText("");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton3.setBackground(new java.awt.Color(255, 153, 153));
        jButton3.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jButton3.setText("Удалить");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Название", "Код", "Стоимость", "НачалоРаб", "КонецРаб", "ДатаРег", "Имя продавца", "Фам продавца"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jButton2.setBackground(new java.awt.Color(255, 153, 153));
        jButton2.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jButton2.setText("Очистить");
        jButton2.setToolTipText("");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton5.setBackground(new java.awt.Color(255, 255, 255));
        jButton5.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jButton5.setText("Назад");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(58, 58, 58)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 529, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1)
                        .addGap(18, 18, 18)
                        .addComponent(jButton2)
                        .addGap(18, 18, 18)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1008, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(54, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel1))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 415, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(30, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // Добавить
        try 
        {
            String sql = "select count(*) from tovar";
            s = conn.createStatement();
            ResultSet ress = s.executeQuery(sql);
            int count = 0;
            while(ress.next()){
                count = ress.getInt(1);
            }
            
            String sql_sel2 = "select count, datareg from dataintro";
            s = conn.createStatement();
            ResultSet res2 = s.executeQuery(sql_sel2);
            double coun = 0;
            String datareg;
            double[] c = new double[count];
            String[] dat = new String[count];
            int j = 0;
            while (res2.next()){
                coun = res2.getInt("count");
                c[j] = coun;
                datareg = res2.getString("datareg");
                dat[j] = datareg;
                j++;
            }
            
            System.out.println("count: " + Arrays.toString(c));
            System.out.println("datareg: " + Arrays.toString(dat));
            
            
            String sql_sel3 = "select fnameprod, lnameprod from prodavec";
            s = conn.createStatement();
            ResultSet res3 = s.executeQuery(sql_sel3);
            String startmar;
            String endmar;
            String[] sm = new String[count];
            String[] em = new String[count];
            int l = 0;
            while (res3.next()){
                startmar = res3.getString("fnameprod");
                sm[l] = startmar;
                endmar = res3.getString("lnameprod");
                em[l] = endmar;
                l++;
            }
            
            System.out.println("fnameprod: " + Arrays.toString(sm));
            System.out.println("lnameprod: " + Arrays.toString(em));
            
            
            String sql_sel4 = "select starttime, endtime from worktime";
            s = conn.createStatement();
            ResultSet res4 = s.executeQuery(sql_sel4);
            String starttime;
            String endtime;
            String[] st = new String[count];
            String[] et = new String[count];
            int q = 0;
            while (res4.next()){
                starttime = res4.getString("starttime");
                st[q] = starttime;
                endtime = res4.getString("endtime");
                et[q] = endtime;
                q++;
            }
            
            System.out.println("starttime: " + Arrays.toString(st));
            System.out.println("endtime: " + Arrays.toString(et));
            
            String sql_sel5 = "select name, kod from tovar";
            s = conn.createStatement();
            ResultSet res5 = s.executeQuery(sql_sel5);
            String name;
            int number;
            String[] n = new String[count];
            int[] num = new int[count];
            int w = 0;
            while (res5.next()){
                name = res5.getString("name");
                n[w] = name;
                number = res5.getInt("kod");
                num[w] = number;
                w++;
            }
            
            System.out.println("name: " + Arrays.toString(n));
            System.out.println("kod: " + Arrays.toString(num));
            
            int k = 0;
            
            for(int p = 0; p < count; p++){
                pst = conn.prepareStatement("insert into prokatinfo(name, kod, count, starttime, endtime, datareg, fnameprod, lnameprod) values(?,?,?,?,?,?,?,?)");
                pst.setString(1, n[p]);
                pst.setInt(2, num[p]);
                pst.setDouble(3, c[p]);
                pst.setString(4, st[p]);
                pst.setString(5, et[p]);
                pst.setString(6, dat[p]);
                pst.setString(7, sm[p]);
                pst.setString(8, em[p]);
                k = pst.executeUpdate();
            }
            
            if(k > 0)
            {
                JOptionPane.showMessageDialog(this, "Данные успешно добавлены");
                Load();
            }
            else
            {
                JOptionPane.showMessageDialog(this, "Ошибка, не удалось добавить данные");
            }   
        } catch (SQLException ex) {
            Logger.getLogger(ProkatInfo.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // Удалить
        try 
        {
            d = (DefaultTableModel)jTable1.getModel();
            int selectIndex = jTable1.getSelectedRow();
            String id = d.getValueAt(selectIndex, 0).toString();
            
            pst = conn.prepareStatement("delete from prokatinfo where id_pr=?");
            pst.setString(1, id);
            
            int k = pst.executeUpdate();
            if(k == 1)
            {
                JOptionPane.showMessageDialog(this, "Данные успешно удалены");
                jButton1.setEnabled(true);
                Load();
            }
            else
            {
                JOptionPane.showMessageDialog(this, "Ошибка, не удалось удалить данные");
            }   
        } catch (SQLException ex) {
            Logger.getLogger(ProkatInfo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        //  Удаление по клику на мышку
        d = (DefaultTableModel)jTable1.getModel();
        int selectIndex = jTable1.getSelectedRow();
        String id = d.getValueAt(selectIndex, 0).toString();
    }//GEN-LAST:event_jTable1MouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // Очистить
        try 
        {
            d.setRowCount(0);
            pst = conn.prepareStatement("delete from prokatinfo");
            int k = pst.executeUpdate();
            JOptionPane.showMessageDialog(this, "Данные успешно удалены");
        }catch (SQLException ex) {
            Logger.getLogger(ProkatInfo.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // Назад
        this.setVisible(false);
    }//GEN-LAST:event_jButton5ActionPerformed

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ProkatInfo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ProkatInfo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ProkatInfo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ProkatInfo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ProkatInfo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
