/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apresentacao;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author luisf
 */
public class TelaPrincipal extends javax.swing.JFrame {

    /**
     * Creates new form TelaPrincipal
     */
    
    public TelaPrincipal() {
        initComponents();
        setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ImageIcon icon = new ImageIcon(getClass().getResource("/util/back.jpg"));
        Image image = icon.getImage();
        jDesktopPrincipal = new javax.swing.JDesktopPane(){

            @Override
            public void paintComponent(Graphics gr){
                gr.drawImage(image,0,0,getWidth(),getHeight(), this);
            }
        };
        btnPedido = new javax.swing.JButton();
        btnCliente = new javax.swing.JButton();
        btnProduto = new javax.swing.JButton();
        btnTitulo = new javax.swing.JButton();
        jButtonFornecedor = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Gestão da Floricultura");
        setResizable(false);
        setSize(new java.awt.Dimension(1000, 800));

        jDesktopPrincipal.setPreferredSize(new java.awt.Dimension(1200, 1000));

        btnPedido.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnPedido.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/017plant.png"))); // NOI18N
        btnPedido.setText("Pedido");
        btnPedido.setActionCommand("");
        btnPedido.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnPedido.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnPedido.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        //btnPedido.setVerticalTextPosition(SwingConstants.BOTTOM);
        btnPedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPedidoActionPerformed(evt);
            }
        });

        btnCliente.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/019bonsai.png"))); // NOI18N
        btnCliente.setText("Cliente");
        btnCliente.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnCliente.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClienteActionPerformed(evt);
            }
        });

        btnProduto.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnProduto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/033plant.png"))); // NOI18N
        btnProduto.setText("Produto");
        btnProduto.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnProduto.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProdutoActionPerformed(evt);
            }
        });

        btnTitulo.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnTitulo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/030-fertilizer.png"))); // NOI18N
        btnTitulo.setText("Título");
        btnTitulo.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        btnTitulo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnTitulo.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnTitulo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTituloActionPerformed(evt);
            }
        });

        jButtonFornecedor.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButtonFornecedor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/041-fruit.png"))); // NOI18N
        jButtonFornecedor.setText("Fornecedor");
        jButtonFornecedor.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonFornecedor.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButtonFornecedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonFornecedorActionPerformed(evt);
            }
        });

        jDesktopPrincipal.setLayer(btnPedido, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPrincipal.setLayer(btnCliente, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPrincipal.setLayer(btnProduto, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPrincipal.setLayer(btnTitulo, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPrincipal.setLayer(jButtonFornecedor, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jDesktopPrincipalLayout = new javax.swing.GroupLayout(jDesktopPrincipal);
        jDesktopPrincipal.setLayout(jDesktopPrincipalLayout);
        jDesktopPrincipalLayout.setHorizontalGroup(
            jDesktopPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPrincipalLayout.createSequentialGroup()
                .addGap(94, 94, 94)
                .addGroup(jDesktopPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jDesktopPrincipalLayout.createSequentialGroup()
                        .addComponent(btnPedido)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnCliente)
                        .addGap(112, 112, 112)
                        .addComponent(btnProduto)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jDesktopPrincipalLayout.createSequentialGroup()
                        .addGap(0, 115, Short.MAX_VALUE)
                        .addComponent(btnTitulo)
                        .addGap(100, 100, 100)
                        .addComponent(jButtonFornecedor)
                        .addGap(253, 253, 253))))
        );
        jDesktopPrincipalLayout.setVerticalGroup(
            jDesktopPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPrincipalLayout.createSequentialGroup()
                .addGap(121, 121, 121)
                .addGroup(jDesktopPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnCliente)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDesktopPrincipalLayout.createSequentialGroup()
                        .addGroup(jDesktopPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnPedido)
                            .addComponent(btnProduto))
                        .addGap(46, 46, 46)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
                .addGroup(jDesktopPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnTitulo)
                    .addComponent(jButtonFornecedor))
                .addContainerGap(163, Short.MAX_VALUE))
        );

        jMenu1.setText("Sobre");
        jMenu1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu1MouseClicked(evt);
            }
        });
        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, 800, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, 579, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProdutoActionPerformed
        try {
            TelaProduto telaProduto = new TelaProduto(jDesktopPrincipal);
            jDesktopPrincipal.add(telaProduto);
            telaProduto.setLocation(15, 15);
            telaProduto.setVisible(true);
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }//GEN-LAST:event_btnProdutoActionPerformed

    private void btnClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClienteActionPerformed
        try {
            boolean botaoSelecionar = false;
            
            TelaCliente telaCliente = new TelaCliente(jDesktopPrincipal, botaoSelecionar, 1);
            jDesktopPrincipal.add(telaCliente);
            telaCliente.setLocation(15, 15);
            telaCliente.setVisible(true);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }//GEN-LAST:event_btnClienteActionPerformed

    private void btnPedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPedidoActionPerformed
        try {
            TelaPedido telaPedido = new TelaPedido(jDesktopPrincipal);
            jDesktopPrincipal.add(telaPedido);
            telaPedido.setLocation(15, 15);
            telaPedido.setVisible(true);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }//GEN-LAST:event_btnPedidoActionPerformed

    private void jMenu1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu1MouseClicked
        JOptionPane.showMessageDialog(rootPane, "Desenvolvido pelos alunos do Senai/Fatesg: \n\nArthur Dourado\nDaniel Silva"
                + "\nFranzwagner Ternus\nLetícia Ribeiro\nLuis Faria\n\nÍcones fornecidos por Freepik via"
                + " Flaticon (www.flaticon.com)\n\nGoiânia - 2018", "Sobre", 2);
    }//GEN-LAST:event_jMenu1MouseClicked

    private void btnTituloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTituloActionPerformed
        // TODO add your handling code here:
        try {
            TelaTitulo telaTitulo = new TelaTitulo(jDesktopPrincipal);
            jDesktopPrincipal.add(telaTitulo);
            telaTitulo.setLocation(15, 15);
            telaTitulo.setVisible(true);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        
        
    }//GEN-LAST:event_btnTituloActionPerformed

    private void jButtonFornecedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonFornecedorActionPerformed
        // TODO add your handling code here:
        try {
            TelaFornecedor telaFornecedor = new TelaFornecedor(jDesktopPrincipal);
            jDesktopPrincipal.add(telaFornecedor);
            telaFornecedor.setLocation(15, 15);
            telaFornecedor.setVisible(true);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }//GEN-LAST:event_jButtonFornecedorActionPerformed
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
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCliente;
    private javax.swing.JButton btnPedido;
    private javax.swing.JButton btnProduto;
    private javax.swing.JButton btnTitulo;
    private javax.swing.JButton jButtonFornecedor;
    private javax.swing.JDesktopPane jDesktopPrincipal;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    // End of variables declaration//GEN-END:variables
}
