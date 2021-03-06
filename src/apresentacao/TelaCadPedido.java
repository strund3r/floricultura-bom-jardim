/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apresentacao;

import entidade.ClientePF;
import entidade.Pedido;
import entidade.Produto;
import java.awt.Component;
import java.sql.SQLException;
import java.text.NumberFormat;
import java.util.Locale;
import java.util.Vector;
import javax.swing.JDesktopPane;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import negocio.NClientePF;
import negocio.NPedido;
import negocio.NProduto;
import util.FormataApenasNumeros;

/**
 *
 * @author luisf
 */
public class TelaCadPedido extends javax.swing.JInternalFrame {

    /**
     * Creates new form TelaCadProduto
     */
    JDesktopPane jDesktopPrincipal = new JDesktopPane();
    ClientePF clientePF;
    NClientePF negocioClientePF;
    Produto produto;
    NProduto negocioProduto;

    public TelaCadPedido() {
        initComponents();
    }

    public TelaCadPedido(JDesktopPane jDesktopPrincipal) {
        this();
        this.jDesktopPrincipal = jDesktopPrincipal;
        carregarTabelaCliente();
        carregarTabelaProduto();
    }

    TelaCadPedido(JDesktopPane jDesktopPrincipal, String codigo, int op) {
        this();
        this.jDesktopPrincipal = jDesktopPrincipal;
        
        carregarTabelaProduto();
        try {
            
            
            NPedido negocioPedido = new NPedido();
            NClientePF negocioClientePF = new NClientePF();
            NProduto negocioProduto = new NProduto();
            Pedido pedido = negocioPedido.consultar(Integer.parseInt(codigo));
            ClientePF clientepf = negocioClientePF.consultar(pedido.getId_cliente());
            Produto produto = negocioProduto.consultar(pedido.getId_produto());

            if (op == 0){
                carregarTabelaCliente();
            }
            
            jTextFieldCodigoPedido.setText(pedido.getID()+ "");
            jTextFieldCodigoCliente.setText(clientepf.getIdentificador()+"");
            jTextFieldNomeCliente.setText(clientepf.getNome()+"");
            jTextFieldCodigoProduto.setText(produto.getIdentificador()+ "");
            jTextFieldProduto.setText(produto.getNome()+"");
            jTextFieldValor.setText(pedido.getValor()+"");
 //           jTextFieldQuantidade.setText(pedido.getQuantidade()+"");
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }


    private void limpar() {
        
        jTextFieldCodigoCliente.setText("");
        jTextFieldCodigoPedido.setText("");
        jTextFieldNomeCliente.setText("");
        jTextFieldProduto.setText("");
        jTextFieldCodigoProduto.setText("");
        jTextFieldValor.setText("");
//        jTextFieldQuantidade.setText("");
    }

    private void carregarTabelaCliente() {
        try {

            Vector<String> cabecalho = new Vector();
            cabecalho.add("Cód.");
            cabecalho.add("Nome");

            NClientePF negocio = new NClientePF();
            Vector linhas = new Vector();

            for (ClientePF clientePF : negocio.listar()) {
                Vector<String> conteudo = new Vector();

                conteudo.add(clientePF.getIdentificador() + "");
                conteudo.add(clientePF.getNome() + "");
                linhas.add(conteudo);
            }
            tblCliente.setModel(new DefaultTableModel(linhas, cabecalho));

            tblCliente.setAutoResizeMode(JTable.AUTO_RESIZE_SUBSEQUENT_COLUMNS);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    private void carregarTabelaProduto() {
        NumberFormat nf = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));

        try {

            Vector<String> cabecalho = new Vector();
            cabecalho.add("Cód.");
            cabecalho.add("Nome");
            cabecalho.add("Valor");
            cabecalho.add("Qnt");

            NProduto negocio = new NProduto();
            Vector linhas = new Vector();

            for (Produto produto : negocio.listar()) {
                Vector<String> conteudo = new Vector();

                conteudo.add(produto.getIdentificador() + "");
                conteudo.add(produto.getNome() + "");
                conteudo.add(nf.format(produto.getValorVenda()));
//                conteudo.add(produto.getQuantidade() + "");
                linhas.add(conteudo);
            }
            tblProduto.setModel(new DefaultTableModel(linhas, cabecalho));

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
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

        jPanel4 = new javax.swing.JPanel();
        btnSalvar = new javax.swing.JButton();
        btnLimpar = new javax.swing.JButton();
        btnVoltar = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jTextFieldNomeCliente = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jTextFieldProduto = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jTextFieldValor = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jTextFieldCodigoPedido = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jTextFieldCodigoCliente = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jTextFieldCodigoProduto = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblProduto = new javax.swing.JTable(){
            @Override
            public Component prepareRenderer(TableCellRenderer renderer, int row, int column) {
                Component component = super.prepareRenderer(renderer, row, column);
                int rendererWidth = component.getPreferredSize().width;
                TableColumn tableColumn = getColumnModel().getColumn(column);
                tableColumn.setPreferredWidth(Math.max(rendererWidth + getIntercellSpacing().width, tableColumn.getPreferredWidth()));
                return component;
            }
        };
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblCliente = new javax.swing.JTable(){
            @Override
            public Component prepareRenderer(TableCellRenderer renderer, int row, int column) {
                Component component = super.prepareRenderer(renderer, row, column);
                int rendererWidth = component.getPreferredSize().width;
                TableColumn tableColumn1 = getColumnModel().getColumn(column);
                tableColumn1.setPreferredWidth(Math.max(rendererWidth + getIntercellSpacing().width, tableColumn1.getPreferredWidth()));
                return component;
            }
        };

        setTitle("Cadastro de Pedidos");
        setToolTipText("");
        setPreferredSize(new java.awt.Dimension(625, 530));

        jPanel4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        btnSalvar.setText("Salvar");
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });

        btnLimpar.setText("Limpar");
        btnLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimparActionPerformed(evt);
            }
        });

        btnVoltar.setText("Voltar");
        btnVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVoltarActionPerformed(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setText("NOME CLIENTE:");

        jTextFieldNomeCliente.setEditable(false);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setText("PRODUTO.......:");

        jTextFieldProduto.setEditable(false);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setText("VALOR...........:");

        jTextFieldValor.setEditable(false);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("CÓDIGO PEDIDO:");

        jTextFieldCodigoPedido.setEditable(false);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setText("CÓDIGO CLIENTE:");

        jTextFieldCodigoCliente.setEditable(false);

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel7.setText("CÓDIGO PRODUTO:");

        jTextFieldCodigoProduto.setEditable(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(18, 18, 18)
                        .addComponent(jTextFieldCodigoCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel3)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(jTextFieldProduto))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel5)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(jTextFieldValor))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel1)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(jTextFieldNomeCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(jTextFieldCodigoPedido, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addGap(18, 18, 18)
                        .addComponent(jTextFieldCodigoProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTextFieldCodigoPedido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jTextFieldCodigoCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTextFieldNomeCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jTextFieldCodigoProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTextFieldProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jTextFieldValor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(85, 85, 85))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        tblProduto.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tblProduto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblProdutoMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblProduto);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 244, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 211, Short.MAX_VALUE)
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        tblCliente.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tblCliente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblClienteMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblCliente);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(btnVoltar)
                        .addGap(61, 61, 61)
                        .addComponent(btnLimpar)
                        .addGap(58, 58, 58)
                        .addComponent(btnSalvar)))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 11, Short.MAX_VALUE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnVoltar)
                            .addComponent(btnLimpar)
                            .addComponent(btnSalvar))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVoltarActionPerformed
        dispose();
        try {
            TelaPedido telaPedido = new TelaPedido(jDesktopPrincipal);
            jDesktopPrincipal.add(telaPedido);
            telaPedido.setLocation(15, 15);
            telaPedido.setVisible(true);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }//GEN-LAST:event_btnVoltarActionPerformed

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        try {
            Pedido pedido = new Pedido();
            if (jTextFieldNomeCliente.getText().isEmpty()) {
                throw new Exception("E necessário buscar um cliente no cadastro.");
            }
            if (jTextFieldProduto.getText().isEmpty()) {
                throw new Exception("E necessário buscar um produto no cadastro.");
            }       

            if (!jTextFieldCodigoPedido.getText().isEmpty()) {
                pedido.setID(Integer.parseInt(jTextFieldCodigoPedido.getText()));
            }

            pedido.setId_cliente(Integer.parseInt(jTextFieldCodigoCliente.getText()));
            pedido.setId_produto(Integer.parseInt(jTextFieldCodigoProduto.getText()));
            String valor = jTextFieldValor.getText();
            valor = valor.replace(",", ".");
            pedido.setValor(Double.parseDouble(valor));

            NPedido negocioPedido = new NPedido();

            negocioPedido.salvar(pedido);

            JOptionPane.showMessageDialog(null, "Operação efetuada com sucesso!");

            limpar();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }        
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void tblClienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblClienteMouseClicked
        limpar();
        try {
            NClientePF negocio = new NClientePF();

            String cliente = tblCliente.getValueAt(tblCliente.getSelectedRow(), 0).toString();
            int codCliente = Integer.parseInt(cliente);
            jTextFieldNomeCliente.setText(negocio.consultar(codCliente).getNome());
            jTextFieldCodigoCliente.setText(Integer.toString(codCliente));
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }//GEN-LAST:event_tblClienteMouseClicked

    private void tblProdutoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblProdutoMouseClicked
        try {

            NProduto negocio = new NProduto();
            String produto = tblProduto.getValueAt(tblProduto.getSelectedRow(), 0).toString();
            int codProduto = Integer.parseInt(produto);

            jTextFieldCodigoProduto.setText(Integer.toString(codProduto));
            jTextFieldProduto.setText(negocio.consultar(codProduto).getNome());
            jTextFieldValor.setText(Double.toString(negocio.consultar(codProduto).getValorVenda()));
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }//GEN-LAST:event_tblProdutoMouseClicked

    private void btnLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimparActionPerformed
        limpar();
    }//GEN-LAST:event_btnLimparActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLimpar;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JButton btnVoltar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jTextFieldCodigoCliente;
    private javax.swing.JTextField jTextFieldCodigoPedido;
    private javax.swing.JTextField jTextFieldCodigoProduto;
    private javax.swing.JTextField jTextFieldNomeCliente;
    private javax.swing.JTextField jTextFieldProduto;
    private javax.swing.JTextField jTextFieldValor;
    private javax.swing.JTable tblCliente;
    private javax.swing.JTable tblProduto;
    // End of variables declaration//GEN-END:variables
}
