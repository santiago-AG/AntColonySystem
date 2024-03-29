/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI;

import javax.swing.JOptionPane;

/**
 *
 * @author santi
 */
public class InsertarCiudad extends javax.swing.JFrame {

    /**
     * Creates new form InsertarCiudad
     */
    public InsertarCiudad() {
        initComponents();
        this.setLocationRelativeTo(null);

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
        CrearCiudad = new javax.swing.JButton();
        InputCiudad = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        InputAristas = new javax.swing.JTextArea();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        VolverMenu = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel1.setText("Agregar Ciudad");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 10, 100, 20));

        CrearCiudad.setText("Agregar");
        CrearCiudad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CrearCiudadActionPerformed(evt);
            }
        });
        jPanel1.add(CrearCiudad, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 210, -1, -1));

        InputCiudad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                InputCiudadActionPerformed(evt);
            }
        });
        jPanel1.add(InputCiudad, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 42, 180, 30));

        InputAristas.setColumns(20);
        InputAristas.setRows(5);
        jScrollPane1.setViewportView(InputAristas);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 110, 280, 90));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel2.setText("Ciudad");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 50, 50, -1));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel3.setText("Aristas");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 90, -1, -1));

        jLabel4.setText("Ciudad, Destino, Distancia->  4,5,8.1");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 90, 220, -1));

        VolverMenu.setText("Cancelar");
        VolverMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VolverMenuActionPerformed(evt);
            }
        });
        jPanel1.add(VolverMenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 210, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 341, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void InputCiudadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_InputCiudadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_InputCiudadActionPerformed

    private void VolverMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VolverMenuActionPerformed
        this.setVisible(false);
        
    }//GEN-LAST:event_VolverMenuActionPerformed

    private void CrearCiudadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CrearCiudadActionPerformed
        String ciudad = InputCiudad.getText();
        String aristas = InputAristas.getText();
                
        char someChar = ',';
        int count = 0;
        
        for (int i = 0; i < aristas.length(); i++) {
            if (aristas.charAt(i) == someChar) {
                count++;
            }
        }
        int remainder = count % 2 ;
        
        //validador de que los campos ciudad y arista no esten vacios (y que el numero de comas sea par)
        if((remainder ==0)&&(!ciudad.isEmpty())&&(!aristas.isEmpty())){
            Menu.grafo.addVertex(ciudad, aristas);
            //Home.grafo.imprimir(Menu.grafo.getVertices());
            this.setVisible(false);
            Menu.ShowFile.setText(Menu.grafo.imprimir());
        }
        else{
            JOptionPane.showMessageDialog(null, "Posee un formato invalido o faltan campos");
        }
        
        
        
    }//GEN-LAST:event_CrearCiudadActionPerformed

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
            java.util.logging.Logger.getLogger(InsertarCiudad.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InsertarCiudad.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InsertarCiudad.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InsertarCiudad.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InsertarCiudad().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton CrearCiudad;
    private javax.swing.JTextArea InputAristas;
    private javax.swing.JTextField InputCiudad;
    private javax.swing.JButton VolverMenu;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
