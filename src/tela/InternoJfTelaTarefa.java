/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tela;

import controle.ControlerTarefa;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author Diana
 */
public class InternoJfTelaTarefa extends javax.swing.JInternalFrame {

    private final ControlerTarefa controler;

    /**
     * Creates new form InternoJfTelaDisicplina
     */
    public InternoJfTelaTarefa() {
        initComponents();
        controler = new ControlerTarefa(this);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelTarefas = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jLayeredPaneGereTarefa = new javax.swing.JLayeredPane();
        jPanelInicGerencia = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jPanelGerenciatarefa = new javax.swing.JPanel();
        jTextTarefaCod = new javax.swing.JTextField();
        jFormattedTextData = new javax.swing.JFormattedTextField();
        jLabelStatus = new javax.swing.JLabel();
        jRadioButtonConcluido = new javax.swing.JRadioButton();
        jRadioButtonNconcluido = new javax.swing.JRadioButton();
        jTextTarefaDisciplina = new javax.swing.JTextField();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTextArea2 = new javax.swing.JTextArea();
        jButtonSaLvar = new javax.swing.JButton();
        jTextField2 = new javax.swing.JTextField();
        jRadioButtonDsicpli = new javax.swing.JRadioButton();
        jRadioButtonPeriodo = new javax.swing.JRadioButton();
        jPanelTableTarefas = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTableTarefas = new javax.swing.JTable();
        jLabelPesquisar = new javax.swing.JLabel();
        jPanelEdicaoTarefa = new javax.swing.JPanel();
        jButtonNovaTarefa = new javax.swing.JButton();
        jButtonExcluirTarefa = new javax.swing.JButton();
        jButtonEditar = new javax.swing.JButton();

        setBackground(new java.awt.Color(69, 69, 71));
        setBorder(null);
        setMaximumSize(new java.awt.Dimension(955, 575));
        setPreferredSize(new java.awt.Dimension(955, 575));

        jPanelTarefas.setBackground(new java.awt.Color(69, 69, 71));
        jPanelTarefas.setPreferredSize(new java.awt.Dimension(950, 570));

        jLabel11.setBackground(new java.awt.Color(66, 244, 158));
        jLabel11.setFont(new java.awt.Font("Candara", 0, 36)); // NOI18N
        jLabel11.setText(" Tarefas");
        jLabel11.setMaximumSize(new java.awt.Dimension(318, 45));
        jLabel11.setMinimumSize(new java.awt.Dimension(318, 45));
        jLabel11.setOpaque(true);
        jLabel11.setPreferredSize(new java.awt.Dimension(318, 45));

        jLayeredPaneGereTarefa.setLayout(new java.awt.CardLayout());

        jPanelInicGerencia.setBackground(new java.awt.Color(69, 69, 71));
        jPanelInicGerencia.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(66, 244, 158), 2, true));
        jPanelInicGerencia.setPreferredSize(new java.awt.Dimension(311, 428));

        jPanel1.setBackground(new java.awt.Color(69, 69, 71));

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/morpheus.png"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(70, Short.MAX_VALUE)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(47, 47, 47))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(84, 84, 84)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(88, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanelInicGerenciaLayout = new javax.swing.GroupLayout(jPanelInicGerencia);
        jPanelInicGerencia.setLayout(jPanelInicGerenciaLayout);
        jPanelInicGerenciaLayout.setHorizontalGroup(
            jPanelInicGerenciaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelInicGerenciaLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelInicGerenciaLayout.setVerticalGroup(
            jPanelInicGerenciaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelInicGerenciaLayout.createSequentialGroup()
                .addGap(87, 87, 87)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(63, Short.MAX_VALUE))
        );

        jLayeredPaneGereTarefa.add(jPanelInicGerencia, "card2");

        jPanelGerenciatarefa.setBackground(new java.awt.Color(69, 69, 71));
        jPanelGerenciatarefa.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(66, 244, 158), 2, true));

        jTextTarefaCod.setEditable(false);
        jTextTarefaCod.setBackground(new java.awt.Color(69, 69, 71));
        jTextTarefaCod.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jTextTarefaCod.setForeground(new java.awt.Color(255, 255, 255));
        jTextTarefaCod.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextTarefaCod.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(66, 215, 244), 1, true), "Código", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12), new java.awt.Color(214, 206, 55))); // NOI18N
        jTextTarefaCod.setMaximumSize(new java.awt.Dimension(385, 40));
        jTextTarefaCod.setPreferredSize(new java.awt.Dimension(385, 40));

        jFormattedTextData.setBackground(new java.awt.Color(69, 69, 71));
        jFormattedTextData.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(66, 215, 244), 1, true), "Data", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12), new java.awt.Color(214, 206, 55))); // NOI18N
        jFormattedTextData.setForeground(new java.awt.Color(255, 255, 255));
        jFormattedTextData.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter()));
        jFormattedTextData.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jFormattedTextData.setText("05/06/2019");
        jFormattedTextData.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jFormattedTextData.setSelectedTextColor(new java.awt.Color(51, 153, 255));

        jLabelStatus.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabelStatus.setForeground(new java.awt.Color(214, 206, 55));
        jLabelStatus.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelStatus.setText("Status");

        jRadioButtonConcluido.setBackground(new java.awt.Color(69, 69, 71));
        jRadioButtonConcluido.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jRadioButtonConcluido.setForeground(new java.awt.Color(66, 244, 158));
        jRadioButtonConcluido.setText("Concluido");

        jRadioButtonNconcluido.setBackground(new java.awt.Color(69, 69, 71));
        jRadioButtonNconcluido.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jRadioButtonNconcluido.setForeground(new java.awt.Color(66, 244, 158));
        jRadioButtonNconcluido.setText("Não concluído");

        jTextTarefaDisciplina.setBackground(new java.awt.Color(69, 69, 71));
        jTextTarefaDisciplina.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jTextTarefaDisciplina.setForeground(new java.awt.Color(255, 255, 255));
        jTextTarefaDisciplina.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextTarefaDisciplina.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(66, 215, 244), 1, true), "Disciplina", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12), new java.awt.Color(214, 206, 55))); // NOI18N
        jTextTarefaDisciplina.setMaximumSize(new java.awt.Dimension(385, 40));
        jTextTarefaDisciplina.setPreferredSize(new java.awt.Dimension(385, 40));

        jScrollPane5.setBorder(null);

        jTextArea2.setBackground(new java.awt.Color(69, 69, 71));
        jTextArea2.setColumns(20);
        jTextArea2.setRows(5);
        jTextArea2.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(66, 215, 244), 1, true), "Descrição", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12), new java.awt.Color(214, 206, 55))); // NOI18N
        jScrollPane5.setViewportView(jTextArea2);

        jButtonSaLvar.setBackground(new java.awt.Color(181, 92, 28));
        jButtonSaLvar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButtonSaLvar.setText("SALVAR");
        jButtonSaLvar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonSaLvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSaLvarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelGerenciatarefaLayout = new javax.swing.GroupLayout(jPanelGerenciatarefa);
        jPanelGerenciatarefa.setLayout(jPanelGerenciatarefaLayout);
        jPanelGerenciatarefaLayout.setHorizontalGroup(
            jPanelGerenciatarefaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelGerenciatarefaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelGerenciatarefaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelGerenciatarefaLayout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(jTextTarefaCod, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(51, 51, 51)
                        .addComponent(jFormattedTextData, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelGerenciatarefaLayout.createSequentialGroup()
                        .addGroup(jPanelGerenciatarefaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane5, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextTarefaDisciplina, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addGroup(jPanelGerenciatarefaLayout.createSequentialGroup()
                                .addGap(0, 10, Short.MAX_VALUE)
                                .addComponent(jLabelStatus)
                                .addGap(18, 18, 18)
                                .addComponent(jRadioButtonConcluido)
                                .addGap(18, 18, 18)
                                .addComponent(jRadioButtonNconcluido)
                                .addGap(28, 28, 28)))
                        .addContainerGap())))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelGerenciatarefaLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButtonSaLvar, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(55, 55, 55))
        );
        jPanelGerenciatarefaLayout.setVerticalGroup(
            jPanelGerenciatarefaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelGerenciatarefaLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanelGerenciatarefaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jFormattedTextData, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextTarefaCod, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addComponent(jTextTarefaDisciplina, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelGerenciatarefaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelStatus)
                    .addComponent(jRadioButtonConcluido)
                    .addComponent(jRadioButtonNconcluido))
                .addGap(21, 21, 21)
                .addComponent(jButtonSaLvar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(41, Short.MAX_VALUE))
        );

        jLayeredPaneGereTarefa.add(jPanelGerenciatarefa, "card3");

        jTextField2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(66, 244, 158), 2, true));
        jTextField2.setOpaque(false);

        jRadioButtonDsicpli.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jRadioButtonDsicpli.setForeground(new java.awt.Color(255, 255, 255));
        jRadioButtonDsicpli.setText("Disciplina");
        jRadioButtonDsicpli.setOpaque(false);

        jRadioButtonPeriodo.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jRadioButtonPeriodo.setForeground(new java.awt.Color(255, 255, 255));
        jRadioButtonPeriodo.setSelected(true);
        jRadioButtonPeriodo.setText("Período");
        jRadioButtonPeriodo.setOpaque(false);

        jPanelTableTarefas.setBackground(new java.awt.Color(69, 69, 71));
        jPanelTableTarefas.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(69, 69, 71), 6, true));
        jPanelTableTarefas.setOpaque(false);

        jScrollPane4.setBackground(new java.awt.Color(69, 69, 71));
        jScrollPane4.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(69, 69, 71), 1, true));
        jScrollPane4.setViewportBorder(new javax.swing.border.LineBorder(new java.awt.Color(69, 69, 71), 1, true));
        jScrollPane4.getViewport().setOpaque(false);

        jTableTarefas.setBackground(new java.awt.Color(69, 69, 71));
        jTableTarefas.setForeground(new java.awt.Color(255, 255, 255));
        jTableTarefas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                { new Integer(1), "05/05/2019", "Matematica", "dasdas", null},
                { new Integer(2), "05/06/2019", "Portugues", "sdasdas", null},
                { new Integer(3), "05/07/2019", "Sistemas Operacionais", "dasdsad", null},
                { new Integer(4), "05/08/2019", "Programação I", "asdasd",  new Boolean(true)},
                { new Integer(5), "05/09/2019", "Modelos de Gestão", "asdasd",  new Boolean(true)},
                { new Integer(6), "05/10/2019", "Matematica", "sdasd", null},
                { new Integer(7), "05/11/2019", "Sistemas Operacionais", "asdsadsa", null}
            },
            new String [] {
                "Cód", "Data", "Disciplina", "Descrição", "Concluído"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Boolean.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableTarefas.setToolTipText("");
        jTableTarefas.setFocusable(false);
        jTableTarefas.setOpaque(false);
        jTableTarefas.setRowHeight(30);
        jTableTarefas.setSelectionBackground(new java.awt.Color(66, 244, 158));
        jTableTarefas.setSelectionForeground(new java.awt.Color(0, 0, 0));
        jTableTarefas.setShowVerticalLines(false);
        jTableTarefas.getTableHeader().setReorderingAllowed(false);
        DefaultTableCellRenderer renderer = (DefaultTableCellRenderer) jTableTarefas
        .getDefaultRenderer(JLabel.class);
        renderer.setHorizontalAlignment(SwingConstants.CENTER);
        DefaultTableCellRenderer headerRenderer = new DefaultTableCellRenderer();
        headerRenderer.setBackground(new java.awt.Color(40, 109, 58));
        //60, 74, 178
        //headerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
        for (int i = 0; i < jTableTarefas.getModel().getColumnCount(); i++) {
            jTableTarefas.getColumnModel().getColumn(i).setHeaderRenderer(headerRenderer);
        }
        jTableTarefas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableTarefasMouseClicked(evt);
            }
        });
        jTableTarefas.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTableTarefasKeyReleased(evt);
            }
        });
        jScrollPane4.setViewportView(jTableTarefas);

        javax.swing.GroupLayout jPanelTableTarefasLayout = new javax.swing.GroupLayout(jPanelTableTarefas);
        jPanelTableTarefas.setLayout(jPanelTableTarefasLayout);
        jPanelTableTarefasLayout.setHorizontalGroup(
            jPanelTableTarefasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelTableTarefasLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 522, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanelTableTarefasLayout.setVerticalGroup(
            jPanelTableTarefasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 461, Short.MAX_VALUE)
        );

        jLabelPesquisar.setBackground(new java.awt.Color(66, 244, 158));
        jLabelPesquisar.setFont(new java.awt.Font("Candara", 1, 18)); // NOI18N
        jLabelPesquisar.setForeground(new java.awt.Color(255, 255, 255));
        jLabelPesquisar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelPesquisar.setText("Pesquisar ");
        jLabelPesquisar.setOpaque(true);

        jPanelEdicaoTarefa.setBackground(new java.awt.Color(69, 69, 71));
        jPanelEdicaoTarefa.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(66, 244, 158), 2, true));

        jButtonNovaTarefa.setBackground(new java.awt.Color(66, 244, 158));
        jButtonNovaTarefa.setText("Nova Tarefa");
        jButtonNovaTarefa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonNovaTarefaActionPerformed(evt);
            }
        });

        jButtonExcluirTarefa.setBackground(new java.awt.Color(66, 244, 158));
        jButtonExcluirTarefa.setText("Excluir Tarefa");
        jButtonExcluirTarefa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonExcluirTarefaActionPerformed(evt);
            }
        });

        jButtonEditar.setBackground(new java.awt.Color(66, 244, 158));
        jButtonEditar.setText("Editar Tarefa");
        jButtonEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEditarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelEdicaoTarefaLayout = new javax.swing.GroupLayout(jPanelEdicaoTarefa);
        jPanelEdicaoTarefa.setLayout(jPanelEdicaoTarefaLayout);
        jPanelEdicaoTarefaLayout.setHorizontalGroup(
            jPanelEdicaoTarefaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelEdicaoTarefaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButtonNovaTarefa)
                .addGap(5, 5, 5)
                .addComponent(jButtonEditar)
                .addGap(5, 5, 5)
                .addComponent(jButtonExcluirTarefa)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelEdicaoTarefaLayout.setVerticalGroup(
            jPanelEdicaoTarefaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelEdicaoTarefaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelEdicaoTarefaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButtonExcluirTarefa, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
                    .addComponent(jButtonEditar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButtonNovaTarefa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanelTarefasLayout = new javax.swing.GroupLayout(jPanelTarefas);
        jPanelTarefas.setLayout(jPanelTarefasLayout);
        jPanelTarefasLayout.setHorizontalGroup(
            jPanelTarefasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanelTarefasLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelTarefasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelTarefasLayout.createSequentialGroup()
                        .addGap(103, 103, 103)
                        .addGroup(jPanelTarefasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelTarefasLayout.createSequentialGroup()
                                .addGap(48, 48, 48)
                                .addComponent(jRadioButtonPeriodo)
                                .addGap(49, 49, 49)
                                .addComponent(jRadioButtonDsicpli))
                            .addGroup(jPanelTarefasLayout.createSequentialGroup()
                                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabelPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(78, 78, 78))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelTarefasLayout.createSequentialGroup()
                        .addComponent(jPanelTableTarefas, javax.swing.GroupLayout.PREFERRED_SIZE, 543, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addGroup(jPanelTarefasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLayeredPaneGereTarefa)
                    .addComponent(jPanelEdicaoTarefa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(71, Short.MAX_VALUE))
        );
        jPanelTarefasLayout.setVerticalGroup(
            jPanelTarefasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelTarefasLayout.createSequentialGroup()
                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addGroup(jPanelTarefasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanelEdicaoTarefa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelTarefasLayout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addGroup(jPanelTarefasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabelPesquisar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jTextField2, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE))
                        .addGroup(jPanelTarefasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jRadioButtonPeriodo)
                            .addComponent(jRadioButtonDsicpli))))
                .addGap(18, 18, 18)
                .addGroup(jPanelTarefasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanelTableTarefas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLayeredPaneGereTarefa, javax.swing.GroupLayout.PREFERRED_SIZE, 376, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 955, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanelTarefas, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 955, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 588, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanelTarefas, javax.swing.GroupLayout.PREFERRED_SIZE, 588, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEditarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonEditarActionPerformed

    private void jButtonExcluirTarefaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonExcluirTarefaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonExcluirTarefaActionPerformed

    private void jButtonNovaTarefaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonNovaTarefaActionPerformed
        
        controler.TrocaTarefas(jPanelGerenciatarefa);
    }//GEN-LAST:event_jButtonNovaTarefaActionPerformed

    private void jTableTarefasKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTableTarefasKeyReleased
        // TODO add your handling code here:
        //        controleEventoTabela();
    }//GEN-LAST:event_jTableTarefasKeyReleased

    private void jTableTarefasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableTarefasMouseClicked
        // TODO add your handling code here:

        //        controleEventoTabela();
    }//GEN-LAST:event_jTableTarefasMouseClicked

    private void jButtonSaLvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSaLvarActionPerformed

        controler.TrocaTarefas(jPanelInicGerencia);
    }//GEN-LAST:event_jButtonSaLvarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonEditar;
    private javax.swing.JButton jButtonExcluirTarefa;
    private javax.swing.JButton jButtonNovaTarefa;
    private javax.swing.JButton jButtonSaLvar;
    private javax.swing.JFormattedTextField jFormattedTextData;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabelPesquisar;
    private javax.swing.JLabel jLabelStatus;
    private javax.swing.JLayeredPane jLayeredPaneGereTarefa;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanelEdicaoTarefa;
    private javax.swing.JPanel jPanelGerenciatarefa;
    private javax.swing.JPanel jPanelInicGerencia;
    private javax.swing.JPanel jPanelTableTarefas;
    private javax.swing.JPanel jPanelTarefas;
    private javax.swing.JRadioButton jRadioButtonConcluido;
    private javax.swing.JRadioButton jRadioButtonDsicpli;
    private javax.swing.JRadioButton jRadioButtonNconcluido;
    private javax.swing.JRadioButton jRadioButtonPeriodo;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTable jTableTarefas;
    private javax.swing.JTextArea jTextArea2;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextTarefaCod;
    private javax.swing.JTextField jTextTarefaDisciplina;
    // End of variables declaration//GEN-END:variables

    public javax.swing.JLayeredPane getjLayeredPaneGereTarefa() {
        return jLayeredPaneGereTarefa;
    }

    public void setjLayeredPaneGereTarefa(javax.swing.JLayeredPane jLayeredPaneGereTarefa) {
        this.jLayeredPaneGereTarefa = jLayeredPaneGereTarefa;
    }
}
