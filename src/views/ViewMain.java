package views;

import java.text.DecimalFormat;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Gustavo Argenis
 */
public class ViewMain extends javax.swing.JFrame {

    DefaultTableModel model = new DefaultTableModel();
    double a, b;

    /**
     * Creates new form FrmMain
     */
    public ViewMain() {
        initComponents();
        this.setLocationRelativeTo(this);
        this.setTitle("Regresión lineal");
        //                  0    1      2        3         4          5            6
        String titles[] = {"X", "Y", "(x-x)", "(y-y)", "(x-x)^2", "(y-y)^2", "(x-x)(y-y)"};
        model.setColumnIdentifiers(titles);
        tblDatos.setModel(model);
    }

    public double promedioX() {
        int contar = tblDatos.getRowCount();
        double suma = 0;
        double resultado = 0;
        for (int i = 0; i < contar; i++) {
            suma += Double.parseDouble(tblDatos.getValueAt(i, 0).toString());
            resultado = suma / contar;
        }
        return resultado;
    }

    public double promedioY() {
        int contar = tblDatos.getRowCount();
        double suma = 0;
        double resultado = 0;
        for (int i = 0; i < contar; i++) {
            suma += Double.parseDouble(tblDatos.getValueAt(i, 1).toString());
            resultado = suma / contar;
        }
        return resultado;
    }

    public void calcularX() {
        int contar = tblDatos.getRowCount();
        for (int i = 0; i < contar; i++) {
            String celda = String.valueOf(tblDatos.getValueAt(i, 0));
            double numero = Double.parseDouble(celda);
            tblDatos.setValueAt(numero - promedioX(), i, 2);
        }
    }

    public void calcularY() {
        int contar = tblDatos.getRowCount();
        for (int i = 0; i < contar; i++) {
            String celda = String.valueOf(tblDatos.getValueAt(i, 1));
            double numero = Double.parseDouble(celda);
            tblDatos.setValueAt(numero - promedioY(), i, 3);
        }
    }

    public void calcularXElevada() {
        int contar = tblDatos.getRowCount();
        for (int i = 0; i < contar; i++) {
            String celda = String.valueOf(tblDatos.getValueAt(i, 0));
            double numero = Double.parseDouble(celda);
            tblDatos.setValueAt(Math.pow(numero - promedioX(), 2), i, 4);
        }
    }

    public void calcularYElevada() {
        int contar = tblDatos.getRowCount();
        for (int i = 0; i < contar; i++) {
            String celda = String.valueOf(tblDatos.getValueAt(i, 1));
            double numero = Double.parseDouble(celda);
            tblDatos.setValueAt(Math.pow(numero - promedioY(), 2), i, 5);
        }
    }

    public void productoXY() {
        int contar = tblDatos.getRowCount();
        for (int i = 0; i < contar; i++) {
            String celda1 = String.valueOf(tblDatos.getValueAt(i, 2));
            double numero1 = Double.parseDouble(celda1);
            String celda2 = String.valueOf(tblDatos.getValueAt(i, 3));
            double numero2 = Double.parseDouble(celda2);
            tblDatos.setValueAt(numero1 * numero2, i, 6);
        }
    }

    public double sumatoriaXElevada() {
        int contar = tblDatos.getRowCount();
        double suma = 0;
        for (int i = 0; i < contar; i++) {
            suma += Double.parseDouble(tblDatos.getValueAt(i, 4).toString());
        }
        return suma;
    }

    public double sumatoriaYElevada() {
        int contar = tblDatos.getRowCount();
        double suma = 0;
        for (int i = 0; i < contar; i++) {
            suma += Double.parseDouble(tblDatos.getValueAt(i, 5).toString());
        }
        return suma;
    }

    public double calcularSX() {
        int contar = tblDatos.getRowCount();
        double res = 0;
        res = Math.sqrt(sumatoriaXElevada() / (contar - 1));
        return res;
    }

    public double calcularSY() {
        int contar = tblDatos.getRowCount();
        double res = 0;
        res = Math.sqrt(sumatoriaYElevada() / (contar - 1));
        return res;
    }

    public double sumatoriaProductoXY() {
        int contar = tblDatos.getRowCount();
        double suma = 0;
        for (int i = 0; i < contar; i++) {
            suma += Double.parseDouble(tblDatos.getValueAt(i, 6).toString());
        }
        return suma;
    }

    public double calcularR() {
        int contar = tblDatos.getRowCount();
        double res = 0;
        res = sumatoriaProductoXY() / ((contar - 1) * calcularSX() * calcularSY());
        return res;
    }

    public double calcularRCuadrada() {
        double res = 0;
        res = Math.pow(calcularR(), 2);
        return res;
    }

    public double calcularB() {
        double res = 0;
        res = (calcularR() * (calcularSY() / calcularSX()));
        return res;
    }

    public double calcularA() {
        double res = 0;
        res = promedioY() - calcularB() * promedioX();
        return res;
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
        btnGenerar = new javax.swing.JButton();
        txtNumeroFilas = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblDatos = new javax.swing.JTable();
        btnCalcular = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        txtPromedioX = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtPromedioY = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtSX = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtSY = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtR = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtRCuadrada = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtB = new javax.swing.JTextField();
        txtA = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        lblY = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(900, 600));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setText("Numero de filas:");
        jLabel1.setPreferredSize(new java.awt.Dimension(100, 30));

        btnGenerar.setText("Generar");
        btnGenerar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGenerarActionPerformed(evt);
            }
        });

        txtNumeroFilas.setPreferredSize(new java.awt.Dimension(50, 30));

        tblDatos.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tblDatos);

        btnCalcular.setText("Calcular");
        btnCalcular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCalcularActionPerformed(evt);
            }
        });

        jLabel2.setText("Promedio X:");
        jLabel2.setPreferredSize(new java.awt.Dimension(100, 30));

        txtPromedioX.setPreferredSize(new java.awt.Dimension(90, 30));

        jLabel3.setText("Promedio Y:");
        jLabel3.setPreferredSize(new java.awt.Dimension(100, 30));

        txtPromedioY.setPreferredSize(new java.awt.Dimension(90, 30));

        jLabel4.setText("Sx:");
        jLabel4.setPreferredSize(new java.awt.Dimension(100, 30));

        txtSX.setPreferredSize(new java.awt.Dimension(90, 30));

        jLabel5.setText("Sy:");
        jLabel5.setPreferredSize(new java.awt.Dimension(100, 30));

        txtSY.setPreferredSize(new java.awt.Dimension(90, 30));

        jLabel6.setText("r:");
        jLabel6.setPreferredSize(new java.awt.Dimension(100, 30));

        txtR.setPreferredSize(new java.awt.Dimension(90, 30));

        jLabel7.setText("r^2:");
        jLabel7.setPreferredSize(new java.awt.Dimension(100, 30));

        txtRCuadrada.setPreferredSize(new java.awt.Dimension(90, 30));

        jLabel8.setText("b:");
        jLabel8.setPreferredSize(new java.awt.Dimension(100, 30));

        jLabel9.setText("a:");
        jLabel9.setPreferredSize(new java.awt.Dimension(100, 30));

        txtB.setPreferredSize(new java.awt.Dimension(90, 30));

        txtA.setPreferredSize(new java.awt.Dimension(90, 30));

        jLabel10.setText("y= a + bx");
        jLabel10.setPreferredSize(new java.awt.Dimension(100, 30));

        lblY.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lblY.setPreferredSize(new java.awt.Dimension(120, 30));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtNumeroFilas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnGenerar))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 390, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnCalcular)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtPromedioX, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtPromedioY, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lblY, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtSX, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtSY, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtR, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtRCuadrada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(152, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNumeroFilas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnGenerar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 550, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnCalcular)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtPromedioX, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtPromedioY, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblY, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtSX, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtSY, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtR, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtRCuadrada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
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
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGenerarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGenerarActionPerformed
        // TODO add your handling code here:
        int numeroFilas = Integer.parseInt(txtNumeroFilas.getText());
        String filaDatos[] = {"", ""};
        for (int i = 0; i < numeroFilas; i++) {
            model.addRow(filaDatos);
        }
    }//GEN-LAST:event_btnGenerarActionPerformed

    private void btnCalcularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCalcularActionPerformed
        // TODO add your handling code here:
        DecimalFormat df = new DecimalFormat("##.##");

        txtPromedioX.setText(Double.toString(promedioX()));
        txtPromedioY.setText(Double.toString(promedioY()));
        calcularX();
        calcularY();
        calcularXElevada();
        calcularYElevada();
        productoXY();
        txtSX.setText(Double.toString(calcularSX()));
        txtSY.setText(Double.toString(calcularSY()));
        txtR.setText(Double.toString(calcularR()));
        txtRCuadrada.setText(Double.toString(calcularRCuadrada()));
        txtB.setText(Double.toString(calcularB()));
        txtA.setText(Double.toString(calcularA()));
        lblY.setText("y=" + calcularA() + "+" + calcularB() + "x");
    }//GEN-LAST:event_btnCalcularActionPerformed

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
            java.util.logging.Logger.getLogger(ViewMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ViewMain().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCalcular;
    private javax.swing.JButton btnGenerar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblY;
    private javax.swing.JTable tblDatos;
    private javax.swing.JTextField txtA;
    private javax.swing.JTextField txtB;
    private javax.swing.JTextField txtNumeroFilas;
    private javax.swing.JTextField txtPromedioX;
    private javax.swing.JTextField txtPromedioY;
    private javax.swing.JTextField txtR;
    private javax.swing.JTextField txtRCuadrada;
    private javax.swing.JTextField txtSX;
    private javax.swing.JTextField txtSY;
    // End of variables declaration//GEN-END:variables
}
