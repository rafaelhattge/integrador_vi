/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tela;

import controle.ControleTelaRelatorio;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JProgressBar;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import tela.dialog.PanelAdicionarSubtarefa;

/**
 *
 * @author Diana
 */
public class InternoJfTelaRelatorio extends javax.swing.JInternalFrame {

    private final ControleTelaRelatorio controle;
    private PanelAdicionarSubtarefa dialogAdicionar;

    /**
     * Creates new form InternoJfTelaRelatorio
     */
    public InternoJfTelaRelatorio() {
        initComponents();
        controle = new ControleTelaRelatorio(this, dialogAdicionar);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelInicio = new javax.swing.JPanel();
        jPanelDetalhes = new javax.swing.JPanel();
        jProgressBar = new javax.swing.JProgressBar();
        jLabel7 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTableExercicios = new javax.swing.JTable();
        jButtonAdicionar = new javax.swing.JButton();
        jButtonRemover = new javax.swing.JButton();
        jLabelDisciplinaTitulo = new javax.swing.JLabel();
        jLabelDisciplinaNome = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jListTarefa = new javax.swing.JList<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        jListData = new javax.swing.JList<>();
        jLabelTitulo = new javax.swing.JLabel();
        jLabelDetalhes = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextAreaDescricao = new javax.swing.JTextArea();
        jLabelTarefa = new javax.swing.JLabel();
        jLabelData = new javax.swing.JLabel();
        jLabelTarefa1 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(69, 69, 71));
        setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));
        setMaximumSize(new java.awt.Dimension(950, 570));
        setPreferredSize(new java.awt.Dimension(955, 575));

        jPanelInicio.setBackground(new java.awt.Color(69, 69, 71));
        jPanelInicio.setMaximumSize(new java.awt.Dimension(915, 544));

        jPanelDetalhes.setBackground(new java.awt.Color(69, 69, 69));

        jProgressBar.setForeground(new java.awt.Color(66, 215, 244));
        jProgressBar.setToolTipText("");
        jProgressBar.setStringPainted(true);

        jLabel7.setFont(new java.awt.Font("Candara", 0, 15)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(240, 240, 240));
        jLabel7.setText("Progresso:");

        jSeparator2.setBackground(new java.awt.Color(66, 215, 244));
        jSeparator2.setForeground(new java.awt.Color(66, 215, 244));

        jScrollPane4.setBackground(new java.awt.Color(69, 69, 71));
        jScrollPane4.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(69, 69, 71), 1, true));
        jScrollPane4.setViewportBorder(new javax.swing.border.LineBorder(new java.awt.Color(69, 69, 71), 1, true));
        jScrollPane4.getViewport().setOpaque(false);

        jTableExercicios.setBackground(new java.awt.Color(69, 69, 71));
        jTableExercicios.setForeground(new java.awt.Color(255, 255, 255));
        jTableExercicios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "", "", "", "", ""
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Boolean.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jTableExercicios.setToolTipText("");
        jTableExercicios.setFocusable(false);
        jTableExercicios.setOpaque(false);
        jTableExercicios.setRowHeight(30);
        jTableExercicios.setSelectionBackground(new java.awt.Color(43, 87, 151));
        jTableExercicios.setSelectionForeground(new java.awt.Color(255, 255, 255));
        jTableExercicios.setShowVerticalLines(false);
        jTableExercicios.getTableHeader().setReorderingAllowed(false);
        DefaultTableCellRenderer renderer = (DefaultTableCellRenderer) jTableExercicios
        .getDefaultRenderer(JLabel.class);
        renderer.setHorizontalAlignment(SwingConstants.LEFT);
        DefaultTableCellRenderer headerRenderer = new DefaultTableCellRenderer();
        headerRenderer.setBackground(new java.awt.Color(66,215,244));

        for (int i = 0; i < jTableExercicios.getModel().getColumnCount(); i++) {
            jTableExercicios.getColumnModel().getColumn(i).setHeaderRenderer(headerRenderer);
        }
        jTableExercicios.getColumnModel().getColumn(0).setPreferredWidth(6);
        jTableExercicios.getModel().addTableModelListener(new TableModelListener(){
            public void tableChanged(TableModelEvent evt) {
                jTableExerciciosTableChanged(evt);
            }
        });
        jTableExercicios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableExerciciosMouseClicked(evt);
            }
        });
        jTableExercicios.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTableExerciciosKeyReleased(evt);
            }
        });
        jScrollPane4.setViewportView(jTableExercicios);
        if (jTableExercicios.getColumnModel().getColumnCount() > 0) {
            jTableExercicios.getColumnModel().getColumn(0).setMinWidth(0);
            jTableExercicios.getColumnModel().getColumn(0).setPreferredWidth(0);
            jTableExercicios.getColumnModel().getColumn(0).setMaxWidth(0);
            jTableExercicios.getColumnModel().getColumn(1).setMinWidth(20);
            jTableExercicios.getColumnModel().getColumn(1).setPreferredWidth(20);
            jTableExercicios.getColumnModel().getColumn(1).setMaxWidth(20);
            jTableExercicios.getColumnModel().getColumn(3).setMinWidth(0);
            jTableExercicios.getColumnModel().getColumn(3).setPreferredWidth(0);
            jTableExercicios.getColumnModel().getColumn(3).setMaxWidth(0);
            jTableExercicios.getColumnModel().getColumn(4).setMinWidth(0);
            jTableExercicios.getColumnModel().getColumn(4).setPreferredWidth(0);
            jTableExercicios.getColumnModel().getColumn(4).setMaxWidth(0);
        }

        jButtonAdicionar.setBackground(new java.awt.Color(66, 215, 244));
        jButtonAdicionar.setFont(new java.awt.Font("Candara", 1, 18)); // NOI18N
        jButtonAdicionar.setForeground(new java.awt.Color(240, 240, 240));
        jButtonAdicionar.setText("Adicionar Subtarefa");
        jButtonAdicionar.setFocusable(false);
        jButtonAdicionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAdicionarActionPerformed(evt);
            }
        });

        jButtonRemover.setBackground(new java.awt.Color(66, 215, 244));
        jButtonRemover.setFont(new java.awt.Font("Candara", 1, 18)); // NOI18N
        jButtonRemover.setForeground(new java.awt.Color(240, 240, 240));
        jButtonRemover.setText("Remover Subtarefa");
        jButtonRemover.setFocusable(false);
        jButtonRemover.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRemoverActionPerformed(evt);
            }
        });

        jLabelDisciplinaTitulo.setFont(new java.awt.Font("Candara", 0, 15)); // NOI18N
        jLabelDisciplinaTitulo.setForeground(new java.awt.Color(255, 255, 255));
        jLabelDisciplinaTitulo.setText("Disciplina:");

        jLabelDisciplinaNome.setFont(new java.awt.Font("Candara", 0, 15)); // NOI18N
        jLabelDisciplinaNome.setForeground(new java.awt.Color(66, 215, 244));
        jLabelDisciplinaNome.setText(" ");

        javax.swing.GroupLayout jPanelDetalhesLayout = new javax.swing.GroupLayout(jPanelDetalhes);
        jPanelDetalhes.setLayout(jPanelDetalhesLayout);
        jPanelDetalhesLayout.setHorizontalGroup(
            jPanelDetalhesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelDetalhesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelDetalhesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator2, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(jPanelDetalhesLayout.createSequentialGroup()
                        .addComponent(jButtonRemover)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                        .addComponent(jButtonAdicionar))
                    .addGroup(jPanelDetalhesLayout.createSequentialGroup()
                        .addGroup(jPanelDetalhesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelDisciplinaTitulo))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanelDetalhesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelDisciplinaNome, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jProgressBar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        jPanelDetalhesLayout.setVerticalGroup(
            jPanelDetalhesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelDetalhesLayout.createSequentialGroup()
                .addGroup(jPanelDetalhesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelDisciplinaTitulo)
                    .addComponent(jLabelDisciplinaNome))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelDetalhesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jProgressBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 309, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelDetalhesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonAdicionar)
                    .addComponent(jButtonRemover))
                .addGap(95, 95, 95))
        );

        jScrollPane3.setBorder(null);

        jListTarefa.setBackground(new java.awt.Color(69, 69, 69));
        jListTarefa.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jListTarefa.setForeground(new java.awt.Color(255, 255, 255));
        jListTarefa.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jListTarefa.setSelectionBackground(new java.awt.Color(43, 87, 151));
        jListTarefa.setSelectionForeground(new java.awt.Color(255, 255, 255));
        jListTarefa.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                jListTarefaValueChanged(evt);
            }
        });
        jScrollPane3.setViewportView(jListTarefa);
        jListTarefa.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (e.getValueIsAdjusting()) {
                    try {
                        //System.out.println("Exibindo subtarefas");
                        controle.exibirSubtarefas();
                    } catch (NullPointerException eex){
                        //System.out.println("Tamanho da jListData: " + jListTarefa.getModel().getSize());
                    }
                }
            }
        });

        jScrollPane1.setBorder(null);
        jScrollPane1.setName(""); // NOI18N
        jScrollPane1.setOpaque(false);

        jListData.setBackground(new java.awt.Color(69, 69, 69));
        jListData.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jListData.setForeground(new java.awt.Color(240, 240, 240));
        jListData.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jListData.setSelectionBackground(new java.awt.Color(43, 87, 151));
        jListData.setSelectionForeground(new java.awt.Color(255, 255, 255));
        jListData.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jListDataPropertyChange(evt);
            }
        });
        jScrollPane1.setViewportView(jListData);
        jListData.addListSelectionListener(new ListSelectionListener(){
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (e.getValueIsAdjusting()) {
                    try {
                        controle.selecionarTarefasPorData();

                        DefaultTableModel model = (DefaultTableModel)jTableExercicios.getModel();
                        model.setRowCount(0);
                        if(jListTarefa.getModel().getSize() > 0){
                            jListTarefa.setSelectedIndex(0);
                            controle.exibirSubtarefas();
                        }

                    } catch (SQLException ex) {
                        Logger.getLogger(InternoJfTelaRelatorio.class
                            .getName()).log(Level.SEVERE, null, ex);
                    } catch (NullPointerException eex){
                        //System.out.println("Tamanho da jListData: " + jListData.getModel().getSize());
                    }
                }
            }
        });

        jLabelTitulo.setBackground(new java.awt.Color(66, 215, 244));
        jLabelTitulo.setFont(new java.awt.Font("Candara", 0, 36)); // NOI18N
        jLabelTitulo.setText(" Relatório Geral");
        jLabelTitulo.setOpaque(true);

        jLabelDetalhes.setFont(new java.awt.Font("Candara", 0, 18)); // NOI18N
        jLabelDetalhes.setForeground(new java.awt.Color(255, 255, 255));
        jLabelDetalhes.setText("Detalhes");

        jScrollPane2.setBorder(null);

        jTextAreaDescricao.setEditable(false);
        jTextAreaDescricao.setBackground(new java.awt.Color(69, 69, 69));
        jTextAreaDescricao.setColumns(20);
        jTextAreaDescricao.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jTextAreaDescricao.setForeground(new java.awt.Color(240, 240, 240));
        jTextAreaDescricao.setLineWrap(true);
        jTextAreaDescricao.setRows(5);
        jTextAreaDescricao.setToolTipText("");
        jTextAreaDescricao.setBorder(null);
        jTextAreaDescricao.setSelectedTextColor(new java.awt.Color(255, 255, 255));
        jScrollPane2.setViewportView(jTextAreaDescricao);

        jLabelTarefa.setFont(new java.awt.Font("Candara", 0, 18)); // NOI18N
        jLabelTarefa.setForeground(new java.awt.Color(255, 255, 255));
        jLabelTarefa.setText("Tarefa");

        jLabelData.setFont(new java.awt.Font("Candara", 0, 18)); // NOI18N
        jLabelData.setForeground(new java.awt.Color(255, 255, 255));
        jLabelData.setText("Data");

        jLabelTarefa1.setFont(new java.awt.Font("Candara", 0, 18)); // NOI18N
        jLabelTarefa1.setForeground(new java.awt.Color(255, 255, 255));
        jLabelTarefa1.setText("Descrição da Tarefa");

        javax.swing.GroupLayout jPanelInicioLayout = new javax.swing.GroupLayout(jPanelInicio);
        jPanelInicio.setLayout(jPanelInicioLayout);
        jPanelInicioLayout.setHorizontalGroup(
            jPanelInicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelInicioLayout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(jPanelInicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelTarefa1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanelInicioLayout.createSequentialGroup()
                        .addGroup(jPanelInicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelInicioLayout.createSequentialGroup()
                                .addGroup(jPanelInicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                    .addComponent(jLabelData, javax.swing.GroupLayout.DEFAULT_SIZE, 97, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanelInicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 326, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabelTarefa, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 441, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelInicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelDetalhes)
                    .addComponent(jPanelDetalhes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(76, 76, 76))
            .addComponent(jLabelTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanelInicioLayout.setVerticalGroup(
            jPanelInicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelInicioLayout.createSequentialGroup()
                .addComponent(jLabelTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addGroup(jPanelInicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelDetalhes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabelTarefa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabelData, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(jPanelInicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelInicioLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanelInicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabelTarefa1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(83, 83, 83))
                    .addGroup(jPanelInicioLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanelDetalhes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 959, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanelInicio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 632, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(jPanelInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jListDataPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jListDataPropertyChange
        if (jListData.getModel().getSize() > 0) {

        }
    }//GEN-LAST:event_jListDataPropertyChange

    private void jListTarefaValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_jListTarefaValueChanged

    }//GEN-LAST:event_jListTarefaValueChanged

    private void jButtonRemoverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRemoverActionPerformed
        if (jTableExercicios.getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(this, "Nenhuma subtarefa foi selecionada.");
        } else {
            controle.removerSubtarefa();
        }
    }//GEN-LAST:event_jButtonRemoverActionPerformed

    private void jButtonAdicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAdicionarActionPerformed
        if (jListTarefa.getSelectedIndex() == -1) {
            JOptionPane.showMessageDialog(this, "Selecione uma tarefa à qual adicionar a subtarefa.");
        } else {
            dialogAdicionar = new PanelAdicionarSubtarefa(this, (JFrame) this.getTopLevelAncestor());
        }
    }//GEN-LAST:event_jButtonAdicionarActionPerformed

    private void jTableExerciciosKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTableExerciciosKeyReleased
        // TODO add your handling code here:
        //        controleEventoTabela();
    }//GEN-LAST:event_jTableExerciciosKeyReleased

    private void jTableExerciciosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableExerciciosMouseClicked
        // TODO add your handling code here:

        //        controleEventoTabela();
    }//GEN-LAST:event_jTableExerciciosMouseClicked

    private void jTableExerciciosTableChanged(TableModelEvent evt) {
        if(evt.getType() == TableModelEvent.UPDATE){
            int idSubtarefa = (int)jTableExercicios.getValueAt(jTableExercicios.getSelectedRow(), 0);
            boolean status = (boolean)jTableExercicios.getValueAt(jTableExercicios.getSelectedRow(), jTableExercicios.getSelectedColumn());
            try {
                controle.editarStatusSubtarefa(idSubtarefa, status);
            } catch (ParseException ex) {
                Logger.getLogger(InternoJfTelaRelatorio.class.getName()).log(Level.SEVERE, null, ex);
            }   
        }
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAdicionar;
    private javax.swing.JButton jButtonRemover;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabelData;
    private javax.swing.JLabel jLabelDetalhes;
    private javax.swing.JLabel jLabelDisciplinaNome;
    private javax.swing.JLabel jLabelDisciplinaTitulo;
    private javax.swing.JLabel jLabelTarefa;
    private javax.swing.JLabel jLabelTarefa1;
    private javax.swing.JLabel jLabelTitulo;
    private javax.swing.JList<String> jListData;
    private javax.swing.JList<String> jListTarefa;
    private javax.swing.JPanel jPanelDetalhes;
    private javax.swing.JPanel jPanelInicio;
    private javax.swing.JProgressBar jProgressBar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTable jTableExercicios;
    private javax.swing.JTextArea jTextAreaDescricao;
    // End of variables declaration//GEN-END:variables

    public JList<String> getjListData() {
        return jListData;
    }

    public void setjListData(JList<String> jListData) {
        this.jListData = jListData;
    }

    public JList<String> getjListTarefa() {
        return jListTarefa;
    }

    public void setjListTarefa(JList<String> jListTarefa) {
        this.jListTarefa = jListTarefa;
    }

    public JTable getjTableExercicios() {
        return jTableExercicios;
    }

    public void setjTableExercicios(JTable jTableExercicios) {
        this.jTableExercicios = jTableExercicios;
    }

    public JProgressBar getjProgressBar() {
        return jProgressBar;
    }

    public void setjProgressBar(JProgressBar jProgressBar) {
        this.jProgressBar = jProgressBar;
    }

    public PanelAdicionarSubtarefa getDialogAdicionar() {
        return dialogAdicionar;
    }

    public JTextArea getjTextAreaDescricao() {
        return jTextAreaDescricao;
    }

    public void setjTextAreaDescricao(JTextArea jTextAreaDescricao) {
        this.jTextAreaDescricao = jTextAreaDescricao;
    }

    public JLabel getjLabelDisciplinaNome() {
        return jLabelDisciplinaNome;
    }

    public void setjLabelDisciplinaNome(JLabel jLabelDisciplinaNome) {
        this.jLabelDisciplinaNome = jLabelDisciplinaNome;
    }
    
}
