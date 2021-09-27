package br.ufmt.alg3.telas;

import br.ufmt.alg3.dao.FabricanteDAO;
import br.ufmt.alg3.entidades.Fabricante;
import br.ufmt.alg3.factory.FabricanteFactory;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class FabricanteJPanel extends javax.swing.JPanel {

    private FabricanteDAO dao = FabricanteFactory.createDAO();
    
    /**
     * Creates new form FabricanteJPanel
     */
    public FabricanteJPanel() {
        initComponents();
        atualizaTabela();
    }
    
    private void atualizaTabela(){
        List<Fabricante> tuplas = dao.listar();
        DefaultTableModel dtm = (DefaultTableModel) jTableFabricante.getModel();
        int linhas = jTableFabricante.getRowCount();
        for(int i = linhas -1; i >= 0; i--){
            dtm.removeRow(i);
        }
        for(Fabricante fabricante : tuplas){
            Object[] obj = new Object[]{fabricante.getIdFabricante(),fabricante.getNome(),fabricante.getCnpj()};
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
        jTableFabricante = new javax.swing.JTable();
        jLabelNome = new javax.swing.JLabel();
        jTextFieldNome = new javax.swing.JTextField();
        jLabelIDFabricante = new javax.swing.JLabel();
        jTextFieldIDFabricante = new javax.swing.JTextField();
        jLabelCNPJ = new javax.swing.JLabel();
        jTextFieldCNPJ = new javax.swing.JTextField();
        jButtonCancelar = new javax.swing.JButton();
        jButtonExcluir = new javax.swing.JButton();
        jButtonEditar = new javax.swing.JButton();
        jButtonSalvar = new javax.swing.JButton();

        setBorder(javax.swing.BorderFactory.createTitledBorder("Fabricante"));

        jTableFabricante.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "ID Fabricante", "CNPJ", "Nome"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane.setViewportView(jTableFabricante);

        jLabelNome.setText("Nome:");

        jLabelIDFabricante.setText("ID Fabricante:");

        jTextFieldIDFabricante.setEditable(false);

        jLabelCNPJ.setText("CNPJ:");

        jButtonCancelar.setText("Cancelar");
        jButtonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelarActionPerformed(evt);
            }
        });

        jButtonExcluir.setText("Excluir");
        jButtonExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonExcluirActionPerformed(evt);
            }
        });

        jButtonEditar.setText("Editar");
        jButtonEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEditarActionPerformed(evt);
            }
        });

        jButtonSalvar.setText("Salvar");
        jButtonSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSalvarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabelIDFabricante)
                    .addComponent(jLabelCNPJ)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButtonEditar, javax.swing.GroupLayout.DEFAULT_SIZE, 75, Short.MAX_VALUE)
                            .addComponent(jButtonSalvar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButtonCancelar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButtonExcluir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(jTextFieldCNPJ)
                    .addComponent(jTextFieldIDFabricante, javax.swing.GroupLayout.DEFAULT_SIZE, 238, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelNome)
                    .addComponent(jTextFieldNome, javax.swing.GroupLayout.PREFERRED_SIZE, 520, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 176, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelNome)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabelIDFabricante)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldIDFabricante, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelCNPJ)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldCNPJ, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 121, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButtonEditar)
                            .addComponent(jButtonExcluir))
                        .addGap(44, 44, 44)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButtonCancelar)
                            .addComponent(jButtonSalvar)))
                    .addComponent(jScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelarActionPerformed
        // Limpar campos
        jTextFieldIDFabricante.setText("");
        jTextFieldCNPJ.setText("");
        jTextFieldNome.setText("");
        atualizaTabela();
    }//GEN-LAST:event_jButtonCancelarActionPerformed

    private void jButtonSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSalvarActionPerformed
        // Adicionar ou Alterar
        Fabricante fabricante = new Fabricante();
        fabricante.setNome(jTextFieldNome.getText());
        fabricante.setCnpj(jTextFieldCNPJ.getText());
        fabricante.setNome(jTextFieldNome.getText());
        
        try{
            int id = Integer.parseInt(jTextFieldIDFabricante.getText());
            fabricante.setIdFabricante(id);
            dao.atualizar(fabricante);
            JOptionPane.showMessageDialog(jTableFabricante, "Atualizado com sucesso!");
        }catch(NumberFormatException e){
            dao.adicionar(fabricante);
            JOptionPane.showMessageDialog(jTableFabricante, "Adicionado com sucesso!");
        }
        jButtonCancelarActionPerformed(evt);
    }//GEN-LAST:event_jButtonSalvarActionPerformed

    private void jButtonEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEditarActionPerformed
        // Editar
        if(jTableFabricante.getSelectedRowCount() == 1){
            int linha = jTableFabricante.getSelectedRow();
            jTextFieldIDFabricante.setText(jTableFabricante.getValueAt(linha, 0) + "");
            jTextFieldNome.setText(jTableFabricante.getValueAt(linha, 1) + "");
            jTextFieldCNPJ.setText(jTableFabricante.getValueAt(linha, 2) + "");
            atualizaTabela();
        }else{
            if(jTableFabricante.getSelectedRowCount() < 1){
                JOptionPane.showMessageDialog(jTableFabricante, "Selecione 1 linha");
            }else if(jTableFabricante.getSelectedRowCount() > 1){
                JOptionPane.showMessageDialog(jTableFabricante, "Selecione 1 linha apenas");
            }
        }
    }//GEN-LAST:event_jButtonEditarActionPerformed

    private void jButtonExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonExcluirActionPerformed
        // Excluir
        try{
            if(jTableFabricante.getSelectedRowCount() >= 1){
                int[] tuplas = jTableFabricante.getSelectedRows();
                for(int i = tuplas.length - 1; i >= 0; i--){
                    int id = Integer.parseInt(jTableFabricante.getValueAt(tuplas[i], 0) + "");
                    dao.remover(id);
                }
                JOptionPane.showMessageDialog(jTableFabricante, "Removido com sucesso");
                jButtonCancelarActionPerformed(evt);
            }else{
                JOptionPane.showMessageDialog(jTableFabricante, "Selecione ao menos 1 linha");
            }
        }catch(ArrayIndexOutOfBoundsException e){
            JOptionPane.showMessageDialog(jTableFabricante, "Erro 404! Linha não existe");
        }
    }//GEN-LAST:event_jButtonExcluirActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonCancelar;
    private javax.swing.JButton jButtonEditar;
    private javax.swing.JButton jButtonExcluir;
    private javax.swing.JButton jButtonSalvar;
    private javax.swing.JLabel jLabelCNPJ;
    private javax.swing.JLabel jLabelIDFabricante;
    private javax.swing.JLabel jLabelNome;
    private javax.swing.JScrollPane jScrollPane;
    private javax.swing.JTable jTableFabricante;
    private javax.swing.JTextField jTextFieldCNPJ;
    private javax.swing.JTextField jTextFieldIDFabricante;
    private javax.swing.JTextField jTextFieldNome;
    // End of variables declaration//GEN-END:variables
}
