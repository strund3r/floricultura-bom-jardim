/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apresentacao;

import entidade.Fornecedor;
import java.sql.SQLException;
import javax.swing.JDesktopPane;
import javax.swing.JOptionPane;
import negocio.NFornecedor;

/**
 *
 * @author arthu
 */
public class TelaEditaFornecedor extends javax.swing.JInternalFrame {

    /**
     * Creates new form TelaEditaFornecedor
     */
    JDesktopPane jDesktopPrincipal = new JDesktopPane();
    
    public TelaEditaFornecedor() {
        initComponents();
    }

    TelaEditaFornecedor(JDesktopPane jDesktopPrincipal) {
        this();
        this.jDesktopPrincipal = jDesktopPrincipal;
    }
    TelaEditaFornecedor(JDesktopPane jDesktopPrincipal, String codigo) {
        this();
        this.jDesktopPrincipal = jDesktopPrincipal;
        //preencher a tela
        try {

            NFornecedor negocio = new NFornecedor();
            Fornecedor fornecedor = negocio.consultar(Integer.parseInt(codigo));

            jTextFieldCodigo1.setText(fornecedor.getIdentificador()+ "");
            jTextFieldFornecedor1.setText(fornecedor.getNome());
            jTextFieldEndereco1.setText(fornecedor.getEndereco());
            jFormattedCnpj1.setText(fornecedor.getCnpj()+ "");
            jFormattedTelefone1.setText(fornecedor.getTelefone()+ "");
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
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

        btnSalvar = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jTextFieldFornecedor1 = new javax.swing.JTextField();
        jTextFieldEndereco1 = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jTextFieldCodigo1 = new javax.swing.JTextField();
        jFormattedCnpj1 = new javax.swing.JFormattedTextField();
        jFormattedTelefone1 = new javax.swing.JFormattedTextField();
        btnVoltar = new javax.swing.JButton();
        btnLimpar = new javax.swing.JButton();

        btnSalvar.setText("Salvar");
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setText("FORNECEDOR:");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel7.setText("ENDEREÇO:");

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel9.setText("TELEFONE:");

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel10.setText("CNPJ:");

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel12.setText("CÓDIGO:");

        jTextFieldCodigo1.setEditable(false);
        jTextFieldCodigo1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldCodigo1ActionPerformed(evt);
            }
        });

        try {
            jFormattedCnpj1.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##############")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jFormattedTelefone1.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#########"))));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(jLabel9)
                    .addComponent(jLabel6)
                    .addComponent(jLabel12))
                .addGap(16, 16, 16)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jFormattedTelefone1, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jFormattedCnpj1, javax.swing.GroupLayout.DEFAULT_SIZE, 149, Short.MAX_VALUE))
                    .addComponent(jTextFieldEndereco1)
                    .addComponent(jTextFieldFornecedor1)
                    .addComponent(jTextFieldCodigo1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 20, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(jTextFieldCodigo1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jTextFieldFornecedor1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jTextFieldEndereco1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jFormattedCnpj1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10)
                    .addComponent(jFormattedTelefone1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(27, Short.MAX_VALUE))
        );

        btnVoltar.setText("Voltar");
        btnVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVoltarActionPerformed(evt);
            }
        });

        btnLimpar.setText("Limpar");
        btnLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimparActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(btnVoltar)
                .addGap(118, 118, 118)
                .addComponent(btnLimpar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 121, Short.MAX_VALUE)
                .addComponent(btnSalvar)
                .addGap(26, 26, 26))
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSalvar)
                    .addComponent(btnLimpar)
                    .addComponent(btnVoltar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        try {

            if (jTextFieldFornecedor1.getText().isEmpty()) {
                throw new Exception("E necessário preencher o nome do fornecedor.");
            }
            if (jTextFieldEndereco1.getText().isEmpty()) {
                throw new Exception("E necessário preencher o endereço.");
            }
            if (jFormattedTelefone1.getText().isEmpty()) {
                throw new Exception("E necessário preencher o telefone.");
            }
            if (jFormattedCnpj1.getText().isEmpty()) {
                throw new Exception("E necessário preencher o CNPJ.");
            }
            
            Fornecedor fornecedor = new Fornecedor();

            if (!jTextFieldCodigo1.getText().isEmpty()) {
                fornecedor.setIdentificador(Integer.parseInt(jTextFieldCodigo1.getText()));
            }

            fornecedor.setNome(jTextFieldFornecedor1.getText());
            fornecedor.setEndereco(jTextFieldEndereco1.getText());
            fornecedor.setTelefone(Integer.parseInt(jFormattedTelefone1.getText()));
            fornecedor.setCnpj(Long.parseLong(jFormattedCnpj1.getText()));
            
            NFornecedor negocio = new NFornecedor();

            negocio.salvar(fornecedor);
            JOptionPane.showMessageDialog(null, "Operação efetuada com sucesso!");

            limpar();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void jTextFieldCodigo1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldCodigo1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldCodigo1ActionPerformed

    private void btnVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVoltarActionPerformed
        dispose();
        try {
            TelaFornecedor telaFornecedor = new TelaFornecedor(jDesktopPrincipal);
            jDesktopPrincipal.add(telaFornecedor);
            telaFornecedor.setLocation(15, 15);
            telaFornecedor.setVisible(true);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }//GEN-LAST:event_btnVoltarActionPerformed

    private void btnLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimparActionPerformed
        limpar();
    }//GEN-LAST:event_btnLimparActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLimpar;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JButton btnVoltar;
    private javax.swing.JFormattedTextField jFormattedCnpj1;
    private javax.swing.JFormattedTextField jFormattedTelefone1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField jTextFieldCodigo1;
    private javax.swing.JTextField jTextFieldEndereco1;
    private javax.swing.JTextField jTextFieldFornecedor1;
    // End of variables declaration//GEN-END:variables

    private void limpar() {
        
        jTextFieldCodigo1.setText("");
        jTextFieldEndereco1.setText("");
        jTextFieldFornecedor1.setText("");
        jFormattedCnpj1.setText("");
        jFormattedTelefone1.setText("");
    }
}