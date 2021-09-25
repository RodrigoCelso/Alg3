package br.ufmt.alg3.telas;

import br.ufmt.alg3.entidades.Atendente;
import br.ufmt.alg3.dao.AtendenteDAO;
import br.ufmt.alg3.dao.EmpresaDAO;
import br.ufmt.alg3.entidades.Empresa;
import br.ufmt.alg3.factory.AtendenteFactory;
import br.ufmt.alg3.factory.EmpresaFactory;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class AtendenteJPanel extends javax.swing.JPanel {

    private AtendenteDAO dao = new AtendenteFactory().createDAO();
    private EmpresaDAO daoEmp = new EmpresaFactory().createDAO();
    
    /**
     * Creates new form AtendenteJPanel
     */
    public AtendenteJPanel() {
        initComponents();
        atualizaTabela();
        atualizaTabelaEmpresa();
    }
    
    private void atualizaTabela(){
        List<Atendente> tuplas = dao.listar();
        DefaultTableModel dtm = (DefaultTableModel) jTableAtendente.getModel();
        int linhas = jTableAtendente.getRowCount();
        for(int i = linhas - 1; i >= 0; i--){
            dtm.removeRow(i);
        }
        for(Atendente atendente : tuplas){
            Object[] obj = new Object[]{atendente.getIdAtendente(),atendente.getNome(),atendente.getEmpresa().getIdEmpresa()};
            dtm.addRow(obj);
        }
    }
    
    private void atualizaTabelaEmpresa(){
        List<Empresa> tuplas = daoEmp.listar();
        DefaultTableModel dtm = (DefaultTableModel) jTableIDEmpresa.getModel();
        int linhas = jTableIDEmpresa.getRowCount();
        for(int i = linhas -1; i >= 0; i--){
            dtm.removeRow(i);
        }
        for(Empresa empresa: tuplas){
            Object[] obj = new Object[]{empresa.getIdEmpresa(), empresa.getNome()};
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

        jScrollPane1 = new javax.swing.JScrollPane();
        jTableAtendente = new javax.swing.JTable();
        jLabelIDAtendente = new javax.swing.JLabel();
        jTextFieldIDAtendente = new javax.swing.JTextField();
        jLabelNome = new javax.swing.JLabel();
        jTextFieldNome = new javax.swing.JTextField();
        jLabelIDEmpresa = new javax.swing.JLabel();
        jButtonEditar = new javax.swing.JButton();
        jButtonExcluir = new javax.swing.JButton();
        jButtonSalvar = new javax.swing.JButton();
        jButtonCancelar = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableIDEmpresa = new javax.swing.JTable();
        jTextFieldIDEmpresa = new javax.swing.JTextField();
        jButtonConfirmar = new javax.swing.JButton();

        setBorder(javax.swing.BorderFactory.createTitledBorder("Atendente"));
        setToolTipText("");

        jTableAtendente.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "ID Atendente", "Nome", "ID Empresa"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTableAtendente);

        jLabelIDAtendente.setText("ID Atendente:");

        jTextFieldIDAtendente.setEditable(false);

        jLabelNome.setText("Nome:");

        jLabelIDEmpresa.setText("ID Empresa:");

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

        jTableIDEmpresa.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "ID Empresa", "Nome"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(jTableIDEmpresa);

        jTextFieldIDEmpresa.setEditable(false);

        jButtonConfirmar.setText("Confirmar");
        jButtonConfirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonConfirmarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelIDEmpresa)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jButtonConfirmar))
                            .addComponent(jTextFieldIDEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, 305, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 305, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(42, 42, 42)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 549, Short.MAX_VALUE)))
                .addGap(14, 14, 14))
            .addGroup(layout.createSequentialGroup()
                .addComponent(jTextFieldNome, javax.swing.GroupLayout.PREFERRED_SIZE, 442, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelNome)
                    .addComponent(jLabelIDAtendente)
                    .addComponent(jTextFieldIDAtendente, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButtonEditar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButtonSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(77, 77, 77)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButtonExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonCancelar))
                .addGap(42, 42, 42))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(jLabelIDAtendente)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldIDAtendente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelNome))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButtonEditar)
                            .addComponent(jButtonExcluir))
                        .addGap(54, 54, 54)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButtonSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButtonCancelar, javax.swing.GroupLayout.Alignment.TRAILING))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelIDEmpresa)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jTextFieldIDEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButtonConfirmar)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 269, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelarActionPerformed
        // Limpar campos
        jTextFieldIDAtendente.setText("");
        jTextFieldNome.setText("");
        jTextFieldIDEmpresa.setText("");
        atualizaTabela();
        atualizaTabelaEmpresa();
    }//GEN-LAST:event_jButtonCancelarActionPerformed

    private void jButtonSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSalvarActionPerformed
        // Adicionar ou Alterar
        Atendente atendente = new Atendente();
        Empresa empresa = new Empresa();
        try{
            empresa.setIdEmpresa(Integer.parseInt(jTextFieldIDEmpresa.getText()));
            atendente.setEmpresa(empresa);
            atendente.setNome(jTextFieldNome.getText());
            try{
                int id = Integer.parseInt(jTextFieldIDAtendente.getText());
                atendente.setIdAtendente(id);
                dao.atualizar(atendente);
                JOptionPane.showMessageDialog(jTableAtendente, "Atualizado com sucesso!");
            }catch(NumberFormatException e){
                dao.adicionar(atendente);
                JOptionPane.showMessageDialog(jTableAtendente, "Adicionado com sucesso!");
            }
        }catch(NumberFormatException e){
            JOptionPane.showMessageDialog(jTableIDEmpresa, "Adicione uma empresa");
        }
        jButtonCancelarActionPerformed(evt);
    }//GEN-LAST:event_jButtonSalvarActionPerformed

    private void jButtonEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEditarActionPerformed
        // Editar
        if(jTableAtendente.getSelectedRowCount() == 1){
            int linha = jTableAtendente.getSelectedRow();
            jTextFieldIDAtendente.setText(jTableAtendente.getValueAt(linha, 0) + "");
            jTextFieldNome.setText(jTableAtendente.getValueAt(linha, 1) + "");
            jTextFieldIDEmpresa.setText(jTableAtendente.getValueAt(linha, 2) + "");
            atualizaTabela();
        }else{
            if(jTableAtendente.getSelectedRowCount() < 1){
                JOptionPane.showMessageDialog(jTableAtendente, "ISelecione 1 linha");
            }else if(jTableAtendente.getSelectedRowCount() > 1){
                JOptionPane.showMessageDialog(jTableAtendente, "ISelecione 1 linha apenas");
            }
        }
    }//GEN-LAST:event_jButtonEditarActionPerformed

    private void jButtonExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonExcluirActionPerformed
        // Excluir
        try{
            if(jTableAtendente.getSelectedRowCount() >= 1){
                int[] tuplas = jTableAtendente.getSelectedRows();
                for(int i = tuplas.length - 1; i >= 0; i--){
                    int id = Integer.parseInt(jTableAtendente.getValueAt(tuplas[i], 0) + "");
                    dao.remover(id);
                }
                JOptionPane.showMessageDialog(jTableAtendente, "Removido com sucesso");
                jButtonCancelarActionPerformed(evt);
            }else{
                JOptionPane.showMessageDialog(jTableAtendente, "Selecione ao menos 1 linha");
            }
        }catch(ArrayIndexOutOfBoundsException e){
            JOptionPane.showMessageDialog(jTableAtendente, "Erro 404! Linha não existe");
        }
    }//GEN-LAST:event_jButtonExcluirActionPerformed

    private void jButtonConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonConfirmarActionPerformed
        // Confirmar
        if(jTableIDEmpresa.getSelectedRowCount() == 1){
            int linha = jTableIDEmpresa.getSelectedRow();
            jTextFieldIDEmpresa.setText(jTableIDEmpresa.getValueAt(linha, 0) + "");
            atualizaTabela();
        }else{
            if(jTableIDEmpresa.getSelectedRowCount() < 1){
                JOptionPane.showMessageDialog(jTableIDEmpresa, "Selecione 1 linha");
            }else if(jTableIDEmpresa.getSelectedRowCount() > 1){
                JOptionPane.showMessageDialog(jTableIDEmpresa, "Selecione 1 linha apenas");
            }
        }
    }//GEN-LAST:event_jButtonConfirmarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonCancelar;
    private javax.swing.JButton jButtonConfirmar;
    private javax.swing.JButton jButtonEditar;
    private javax.swing.JButton jButtonExcluir;
    private javax.swing.JButton jButtonSalvar;
    private javax.swing.JLabel jLabelIDAtendente;
    private javax.swing.JLabel jLabelIDEmpresa;
    private javax.swing.JLabel jLabelNome;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTableAtendente;
    private javax.swing.JTable jTableIDEmpresa;
    private javax.swing.JTextField jTextFieldIDAtendente;
    private javax.swing.JTextField jTextFieldIDEmpresa;
    private javax.swing.JTextField jTextFieldNome;
    // End of variables declaration//GEN-END:variables
}
