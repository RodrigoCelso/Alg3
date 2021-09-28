package br.ufmt.alg3.telas;

import br.ufmt.alg3.dao.VendaDAO;
import br.ufmt.alg3.entidades.Venda;
import br.ufmt.alg3.factory.VendaFactory;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class VendaJPanel extends javax.swing.JPanel {

    private VendaDAO dao = VendaFactory.createDAO();
    
    /**
     * Creates new form VendaJPanel
     */
    public VendaJPanel() {
        initComponents();
        atualizaTabela();
    }
    
    private void atualizaTabela(){
        List<Venda> tuplas = dao.listar();
        DefaultTableModel dtm = (DefaultTableModel) jTableVenda.getModel();
        int linhas = jTableVenda.getRowCount();
        for(int i = linhas -1; i >= 0; i--){
            dtm.removeRow(i);
        }
        for(Venda venda : tuplas){
            Object[] obj = new Object[]{venda.getIdVenda(),venda.isEntrega(),venda.getValor(),venda.getModoPagamento(),venda.getData()};
            dtm.addRow(obj);
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

        jScrollPane = new javax.swing.JScrollPane();
        jTableVenda = new javax.swing.JTable();
        jLabelIDVenda = new javax.swing.JLabel();
        jTextFieldIDVenda = new javax.swing.JTextField();
        jLabelData = new javax.swing.JLabel();
        jTextFieldData = new javax.swing.JTextField();
        jLabelValor = new javax.swing.JLabel();
        jTextFieldValor = new javax.swing.JTextField();
        jLabelModoPagamento = new javax.swing.JLabel();
        jTextFieldModoPagamento = new javax.swing.JTextField();
        jButtonEditar = new javax.swing.JButton();
        jButtonExcluir = new javax.swing.JButton();
        jButtonSalvar = new javax.swing.JButton();
        jButtonCancelar = new javax.swing.JButton();
        jRadioButtonEntrega = new javax.swing.JRadioButton();

        setBorder(javax.swing.BorderFactory.createTitledBorder("Venda"));

        jTableVenda.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ID Venda", "Entrega", "Valor", "Modo Pagamento", "Data"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane.setViewportView(jTableVenda);

        jLabelIDVenda.setText("ID Venda:");

        jTextFieldIDVenda.setEditable(false);

        jLabelData.setText("Data:");

        jLabelValor.setText("Valor:");

        jLabelModoPagamento.setText("Modo de Pagamento:");

        jButtonEditar.setText("Editar");
        jButtonEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEditarActionPerformed(evt);
            }
        });

        jButtonExcluir.setText("Excluir");
        jButtonExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonExcluirActionPerformed(evt);
            }
        });

        jButtonSalvar.setText("Salvar");
        jButtonSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSalvarActionPerformed(evt);
            }
        });

        jButtonCancelar.setText("Cancelar");
        jButtonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelarActionPerformed(evt);
            }
        });

        jRadioButtonEntrega.setText("Entrega");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButtonEditar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButtonSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(55, 55, 55)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButtonExcluir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButtonCancelar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabelValor)
                                .addGap(184, 184, 184))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jTextFieldValor)
                                .addGap(32, 32, 32)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextFieldModoPagamento, javax.swing.GroupLayout.PREFERRED_SIZE, 276, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelModoPagamento)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelIDVenda)
                            .addComponent(jTextFieldIDVenda, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(32, 32, 32)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jTextFieldData, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(73, 73, 73)
                                .addComponent(jRadioButtonEntrega))
                            .addComponent(jLabelData))))
                .addGap(0, 369, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelIDVenda)
                    .addComponent(jLabelData))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldIDVenda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jRadioButtonEntrega))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelValor)
                    .addComponent(jLabelModoPagamento))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldValor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldModoPagamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 378, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButtonEditar)
                            .addComponent(jButtonExcluir))
                        .addGap(74, 74, 74)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButtonSalvar)
                            .addComponent(jButtonCancelar)))))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelarActionPerformed
        // Limpar campos
        jTextFieldIDVenda.setText("");
        jRadioButtonEntrega.setSelected(false);
        jTextFieldValor.setText("");
        jTextFieldModoPagamento.setText("");
        jTextFieldData.setText("");
        atualizaTabela();
    }//GEN-LAST:event_jButtonCancelarActionPerformed

    private void jButtonSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSalvarActionPerformed
        // Adicionar ou Alterar
        Venda venda = new Venda();
        venda.setEntrega(jRadioButtonEntrega.isSelected());
        venda.setValor(Double.parseDouble(jTextFieldValor.getText()));
        venda.setModoPagamento(jTextFieldModoPagamento.getText());
        venda.setData(jTextFieldData.getText());
        
        try{
            int id = Integer.parseInt(jTextFieldIDVenda.getText());
            venda.setIdVenda(id);
            dao.atualizar(venda);
            JOptionPane.showMessageDialog(jTableVenda, "Atualizado com sucesso!");
        }catch(NumberFormatException e){
            dao.adicionar(venda);
            JOptionPane.showMessageDialog(jTableVenda, "Adicionado com sucesso!");
        }
        jButtonCancelarActionPerformed(evt);
    }//GEN-LAST:event_jButtonSalvarActionPerformed

    private void jButtonEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEditarActionPerformed
        // Editar
        if(jTableVenda.getSelectedRowCount() == 1){
            int linha = jTableVenda.getSelectedRow();
            jTextFieldIDVenda.setText(jTableVenda.getValueAt(linha, 0) + "");
            jRadioButtonEntrega.setSelected(Boolean.parseBoolean(jTableVenda.getValueAt(linha, 1) + "" ));
            jTextFieldValor.setText(jTableVenda.getValueAt(linha, 2) + "");
            jTextFieldModoPagamento.setText(jTableVenda.getValueAt(linha, 3) + "");
            jTextFieldData.setText(jTableVenda.getValueAt(linha, 4) + "");
            atualizaTabela();
        }else{
            if(jTableVenda.getSelectedRowCount() < 1){
                JOptionPane.showMessageDialog(jTableVenda, "Selecione ao menos 1 linha");
            }else if(jTableVenda.getSelectedRowCount() > 1){
                JOptionPane.showMessageDialog(jTableVenda, "Selecione 1 linha apenas");
            }
        }
    }//GEN-LAST:event_jButtonEditarActionPerformed

    private void jButtonExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonExcluirActionPerformed
        // Excluir
        try{
            if(jTableVenda.getSelectedRowCount() >= 1){
                int[] tuplas = jTableVenda.getSelectedRows();
                for(int i = tuplas.length - 1; i >= 0; i--){
                    int id = Integer.parseInt(jTableVenda.getValueAt(tuplas[i], 0) + "");
                    dao.remover(id);
                }
                JOptionPane.showMessageDialog(jTableVenda, "Removido com sucesso");
                jButtonCancelarActionPerformed(evt);
            }else{
                JOptionPane.showMessageDialog(jTableVenda, "Selecione ao menos 1 linha");
            }
        }catch(ArrayIndexOutOfBoundsException e){
            JOptionPane.showMessageDialog(jTableVenda, "Erro 404! Linha não existe");
        }
    }//GEN-LAST:event_jButtonExcluirActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonCancelar;
    private javax.swing.JButton jButtonEditar;
    private javax.swing.JButton jButtonExcluir;
    private javax.swing.JButton jButtonSalvar;
    private javax.swing.JLabel jLabelData;
    private javax.swing.JLabel jLabelIDVenda;
    private javax.swing.JLabel jLabelModoPagamento;
    private javax.swing.JLabel jLabelValor;
    private javax.swing.JRadioButton jRadioButtonEntrega;
    private javax.swing.JScrollPane jScrollPane;
    private javax.swing.JTable jTableVenda;
    private javax.swing.JTextField jTextFieldData;
    private javax.swing.JTextField jTextFieldIDVenda;
    private javax.swing.JTextField jTextFieldModoPagamento;
    private javax.swing.JTextField jTextFieldValor;
    // End of variables declaration//GEN-END:variables
}
