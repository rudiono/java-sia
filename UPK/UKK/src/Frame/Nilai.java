package Frame;

import Connection.*;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
public class Nilai extends javax.swing.JFrame {
String kode,nilaihuruf,nilaiangka;
    /** Creates new form Nilai */
    public Nilai() {
        initComponents();
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Dimension frameSize = getSize();
        setLocation(
        (screenSize.width - frameSize.width) / 2,
        (screenSize.height - frameSize.height) / 2);
        tampiltabel();
    }

    void tampildata()
    {
        try
        {
            Koneksi objkoneksi = new Koneksi();
            Connection con = objkoneksi.bukakoneksi();
            Statement st = con.createStatement();
            String sql = "select nama from siswa where nis ="+nis.getText()+"";
            ResultSet set = st.executeQuery(sql);
            if (set.next())
            {
                nama.setText(set.getString(1));
            }
            nis.setEditable(false);
            nama.setEditable(false);
            
        }
        catch (SQLException e)
        {
            System.out.println("gagal query ini"+e);
        }
    }

    void tampiltabel()
    {
        try
        {
            Koneksi objkoneksi = new Koneksi();
            Connection con = objkoneksi.bukakoneksi();
            Statement st = con.createStatement();
            String sql = "select *from nilaiUN";
            ResultSet set = st.executeQuery(sql);
            ResultSetTableModel model = new ResultSetTableModel (set);
            tabel.setModel (model);
        }
        catch (SQLException e)
        {
            System.out.println("gagal query ini"+e);
        }
    }

//    void tambahitem()
//    {
//        try
//        {
//            Koneksi objkoneksi = new Koneksi();
//            Connection con = objkoneksi.bukakoneksi();
//            Statement st = con.createStatement();
//            String sql = "select *from nilaiun";
//            ResultSet res=st.executeQuery(sql);
//            while (res.next()) {
//                bin.setText(res.getString(2));
//                Matematika.setText(res.getString(3));
//                big.setText(res.getString(4));
//            }
//        }
//        catch (SQLException e)
//        {
//            System.out.println("gagal query ini"+e);
//        }
//    }
    void bersih()
    {
        nis.setText("");
        nama.setText("");
        txtbin.setText("");
        txtmat.setText("");
        txtbig.setText("");
    }

//    void rapot()
//    {
//        try {
//            Koneksi objkoneksi = new Koneksi();
//            Connection con =objkoneksi.bukakoneksi();
//            Statement st = con.createStatement();
//
//            String sql = "insert into rapot (NIS, Nama, Kelas, Jurusan, Mapel, NilaiAngka, NilaiHuruf)"
//                    + "values ('"+nis.getText()+"','"+nama.getText()+"','"+kelas.getText()+"','"+jurusan.getText()+"','"+mapel.getSelectedItem()+"','"+txtbin.getText()+"','"+nilaihuruf+"')";
//            int row =st.executeUpdate(sql);
//            if (row==1)
//            {
//                JOptionPane.showMessageDialog(null,"Data sudah ditambahkan ke database","informasi",JOptionPane.INFORMATION_MESSAGE);
//            }
//        }
//        catch (SQLException e)
//        {
//            JOptionPane.showMessageDialog(null,"data tidak ditambahkan ke database","informasi",JOptionPane.INFORMATION_MESSAGE);
//            System.out.println(e);
//        }
//    }

    void nilai()
    {
        try {
            Koneksi objkoneksi = new Koneksi();
            Connection con =objkoneksi.bukakoneksi();
            Statement st = con.createStatement();

            String sql = "insert into nilaiun (NIS, BIN,MAT,BIG)"
                    + "values ('"+nis.getText()+"','"+txtbin.getText()+"','"+txtmat.getText()+"','"+txtbig.getText()+"')";
            int row =st.executeUpdate(sql);
            if (row==1)
            {
                JOptionPane.showMessageDialog(null,"Data sudah ditambahkan ke database","informasi",JOptionPane.INFORMATION_MESSAGE);
            }
        }
        catch (SQLException e)
        {
//            JOptionPane.showMessageDialog(null,"data tidak ditambahkan ke database","informasi",JOptionPane.INFORMATION_MESSAGE);
        }
    }

//    void mapel()
//    {
//        try {
//            Koneksi objkoneksi = new Koneksi();
//            Connection con =objkoneksi.bukakoneksi();
//            Statement st = con.createStatement();
//            String sql = "select kodepelajaran from pelajaran where mapel ='"+mapel.getSelectedItem()+"'";
//            ResultSet rs = st.executeQuery(sql);
//            if(rs.next())
//            {
//                kode=rs.getString(1);
//            }
//            }
//        catch (SQLException e)
//        {
//            //JOptionPane.showMessageDialog(null,"data tidak ditambahkan ke database"+e,"informasi",JOptionPane.INFORMATION_MESSAGE);
//        }
//        nilaiangka=txtbin.getText();
//        int na = Integer.parseInt(nilaiangka);
//        if(na>=80){ nilaihuruf="A";}
//        else if(na>=70) { nilaihuruf="B";}
//        else if(na>=60) { nilaihuruf="C";}
//        else { nilaihuruf="D";}
//    }

    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        nis = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        nama = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtbin = new javax.swing.JTextField();
        back = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabel = new javax.swing.JTable();
        txtmat = new javax.swing.JTextField();
        txtbig = new javax.swing.JTextField();
        batal = new javax.swing.JButton();
        simpan = new javax.swing.JButton();
        bin = new javax.swing.JLabel();
        Matematika = new javax.swing.JLabel();
        big = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Data Nilai");

        jLabel1.setText("NIS");

        nis.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                nisKeyPressed(evt);
            }
        });

        jLabel2.setText("Nama");

        jLabel5.setText("Mata Pelajaran :");

        jLabel6.setText("Nilai :");

        back.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Back.png"))); // NOI18N
        back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backActionPerformed(evt);
            }
        });

        tabel.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tabel);

        batal.setBackground(new java.awt.Color(0, 204, 255));
        batal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/remove_32.png"))); // NOI18N
        batal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                batalActionPerformed(evt);
            }
        });

        simpan.setBackground(new java.awt.Color(0, 204, 255));
        simpan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Addnew toolbar.png"))); // NOI18N
        simpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                simpanActionPerformed(evt);
            }
        });

        bin.setText("Bahasa Indonesia");

        Matematika.setText("Matematika");

        big.setText("Bahasa Inggris");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(385, 385, 385)
                .addComponent(back)
                .addGap(20, 20, 20))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel5)
                            .addComponent(bin)
                            .addComponent(Matematika)
                            .addComponent(big))
                        .addGap(41, 41, 41)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtmat, javax.swing.GroupLayout.DEFAULT_SIZE, 149, Short.MAX_VALUE)
                            .addComponent(nama, javax.swing.GroupLayout.DEFAULT_SIZE, 149, Short.MAX_VALUE)
                            .addComponent(jLabel6)
                            .addComponent(nis, javax.swing.GroupLayout.DEFAULT_SIZE, 149, Short.MAX_VALUE)
                            .addComponent(txtbin, javax.swing.GroupLayout.DEFAULT_SIZE, 149, Short.MAX_VALUE)
                            .addComponent(txtbig, javax.swing.GroupLayout.DEFAULT_SIZE, 149, Short.MAX_VALUE))
                        .addGap(26, 26, 26)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(simpan)
                            .addComponent(batal))
                        .addGap(3, 3, 3))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 369, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(91, 91, 91))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(nis, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(nama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtbin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(bin))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtmat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Matematika))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtbig, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(big)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(simpan)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(batal)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addComponent(back)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backActionPerformed
        dispose();
        new MenuUtama().setVisible(true);
    }//GEN-LAST:event_backActionPerformed

    private void nisKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nisKeyPressed
        if (evt.getKeyCode() == evt.VK_ENTER)

        {
                tampildata();
        }
    }//GEN-LAST:event_nisKeyPressed

    private void simpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_simpanActionPerformed
        nilai();
        bersih();
        tampiltabel();
        nis.setEditable(true);
        nama.setEditable(true);
    }//GEN-LAST:event_simpanActionPerformed

    private void batalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_batalActionPerformed
        bersih();
        nis.setEditable(true);
    }//GEN-LAST:event_batalActionPerformed

    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Nilai().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Matematika;
    private javax.swing.JButton back;
    private javax.swing.JButton batal;
    private javax.swing.JLabel big;
    private javax.swing.JLabel bin;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField nama;
    private javax.swing.JTextField nis;
    private javax.swing.JButton simpan;
    private javax.swing.JTable tabel;
    private javax.swing.JTextField txtbig;
    private javax.swing.JTextField txtbin;
    private javax.swing.JTextField txtmat;
    // End of variables declaration//GEN-END:variables

}
