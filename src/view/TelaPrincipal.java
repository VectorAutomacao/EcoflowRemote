package view;

import control.ControlarAplicativo;
import java.awt.Toolkit;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import model.SerialCom;

public class TelaPrincipal extends javax.swing.JFrame {
    
    private ControlarAplicativo controleAplicativo = new ControlarAplicativo();

    public TelaPrincipal() {
        initComponents();
        listaSerialCom();
        setIcon();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jToggleButton1 = new javax.swing.JToggleButton();
        jDesktopPane1 = new javax.swing.JDesktopPane();
        lbPorta = new javax.swing.JLabel();
        cbPortas = new javax.swing.JComboBox<>();
        lbSlaveadd = new javax.swing.JLabel();
        lbInitialregister = new javax.swing.JLabel();
        lbInitialinput = new javax.swing.JLabel();
        lbMaxpulses = new javax.swing.JLabel();
        lbRegsize = new javax.swing.JLabel();
        lbBaudrate = new javax.swing.JLabel();
        lbStopbits = new javax.swing.JLabel();
        lbParity = new javax.swing.JLabel();
        lbFormat = new javax.swing.JLabel();
        btnAlterar = new javax.swing.JButton();
        btnPadrao = new javax.swing.JButton();
        txtSlaveadd = new javax.swing.JTextField();
        txtInitialRegister = new javax.swing.JTextField();
        txtInitialInput = new javax.swing.JTextField();
        txtMaxpulses = new javax.swing.JTextField();
        txtRegSize = new javax.swing.JTextField();
        txtBaudrate = new javax.swing.JTextField();
        txtParity = new javax.swing.JTextField();
        txtFormat = new javax.swing.JTextField();
        txtStopBits = new javax.swing.JTextField();
        btnFinalizar = new javax.swing.JButton();
        btnSelecionar = new javax.swing.JButton();
        btnAtualizar = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        btnLeitura = new javax.swing.JButton();

        jToggleButton1.setText("jToggleButton1");

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("ECOflow v0.3");
        setIconImages(null);
        setName("framePrincipal"); // NOI18N
        setResizable(false);

        lbPorta.setText("Porta:");

        cbPortas.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        lbSlaveadd.setText("Slaveadd:");

        lbInitialregister.setText("Initialregister:");

        lbInitialinput.setText("Initialinput:");

        lbMaxpulses.setText("Maxpulses:");

        lbRegsize.setText("Regsize:");

        lbBaudrate.setText("Baudrate:");

        lbStopbits.setText("Stopbits:");

        lbParity.setText("Parity:");

        lbFormat.setText("Format:");

        btnAlterar.setText("Alterar");
        btnAlterar.setEnabled(false);
        btnAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlterarActionPerformed(evt);
            }
        });

        btnPadrao.setText("Padrão");
        btnPadrao.setEnabled(false);
        btnPadrao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPadraoActionPerformed(evt);
            }
        });

        txtSlaveadd.setEnabled(false);

        txtInitialRegister.setEnabled(false);

        txtInitialInput.setEnabled(false);

        txtMaxpulses.setEnabled(false);

        txtRegSize.setEnabled(false);

        txtBaudrate.setEnabled(false);

        txtParity.setEnabled(false);

        txtFormat.setEnabled(false);

        txtStopBits.setEnabled(false);

        btnFinalizar.setText("Finalizar");
        btnFinalizar.setEnabled(false);
        btnFinalizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFinalizarActionPerformed(evt);
            }
        });

        btnSelecionar.setText("Selecionar");
        btnSelecionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSelecionarActionPerformed(evt);
            }
        });

        btnAtualizar.setText("Atualizar");
        btnAtualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAtualizarActionPerformed(evt);
            }
        });

        btnLeitura.setText("Leitura");
        btnLeitura.setEnabled(false);
        btnLeitura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLeituraActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lbPorta)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbPortas, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lbSlaveadd)
                            .addComponent(lbInitialinput)
                            .addComponent(lbInitialregister)
                            .addComponent(lbMaxpulses)
                            .addComponent(lbRegsize)
                            .addComponent(lbBaudrate)
                            .addComponent(lbStopbits)
                            .addComponent(lbParity)
                            .addComponent(lbFormat))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtInitialRegister)
                            .addComponent(txtMaxpulses)
                            .addComponent(txtRegSize)
                            .addComponent(txtBaudrate)
                            .addComponent(txtParity)
                            .addComponent(txtStopBits)
                            .addComponent(txtFormat)
                            .addComponent(txtSlaveadd)
                            .addComponent(txtInitialInput)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(btnSelecionar)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnAtualizar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnPadrao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnAlterar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnFinalizar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnLeitura, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(jSeparator1))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbPorta)
                    .addComponent(cbPortas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(4, 4, 4)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAtualizar)
                    .addComponent(btnSelecionar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbSlaveadd)
                    .addComponent(btnPadrao)
                    .addComponent(txtSlaveadd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbInitialregister)
                    .addComponent(btnAlterar)
                    .addComponent(txtInitialRegister, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbInitialinput)
                    .addComponent(txtInitialInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLeitura))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbMaxpulses)
                    .addComponent(txtMaxpulses, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnFinalizar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbRegsize)
                    .addComponent(txtRegSize, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbBaudrate)
                    .addComponent(txtBaudrate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbStopbits)
                    .addComponent(txtStopBits, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbParity)
                    .addComponent(txtParity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbFormat)
                    .addComponent(txtFormat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlterarActionPerformed
        alterar();
    }//GEN-LAST:event_btnAlterarActionPerformed

    private void btnPadraoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPadraoActionPerformed
        padrao();
    }//GEN-LAST:event_btnPadraoActionPerformed

    private void btnFinalizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFinalizarActionPerformed
        limpar();
        finalizar();
    }//GEN-LAST:event_btnFinalizarActionPerformed

    private void btnSelecionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSelecionarActionPerformed
        selecionar();
    }//GEN-LAST:event_btnSelecionarActionPerformed

    private void btnAtualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtualizarActionPerformed
        listaSerialCom();
    }//GEN-LAST:event_btnAtualizarActionPerformed

    private void btnLeituraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLeituraActionPerformed
        Leitura leitura = new Leitura(this, true);
        leitura.setVisible(true);
    }//GEN-LAST:event_btnLeituraActionPerformed

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
    private javax.swing.JButton btnAlterar;
    private javax.swing.JButton btnAtualizar;
    private javax.swing.JButton btnFinalizar;
    private javax.swing.JButton btnLeitura;
    private javax.swing.JButton btnPadrao;
    private javax.swing.JButton btnSelecionar;
    private javax.swing.JComboBox<String> cbPortas;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JToggleButton jToggleButton1;
    private javax.swing.JLabel lbBaudrate;
    private javax.swing.JLabel lbFormat;
    private javax.swing.JLabel lbInitialinput;
    private javax.swing.JLabel lbInitialregister;
    private javax.swing.JLabel lbMaxpulses;
    private javax.swing.JLabel lbParity;
    private javax.swing.JLabel lbPorta;
    private javax.swing.JLabel lbRegsize;
    private javax.swing.JLabel lbSlaveadd;
    private javax.swing.JLabel lbStopbits;
    private javax.swing.JTextField txtBaudrate;
    private javax.swing.JTextField txtFormat;
    private javax.swing.JTextField txtInitialInput;
    private javax.swing.JTextField txtInitialRegister;
    private javax.swing.JTextField txtMaxpulses;
    private javax.swing.JTextField txtParity;
    private javax.swing.JTextField txtRegSize;
    private javax.swing.JTextField txtSlaveadd;
    private javax.swing.JTextField txtStopBits;
    // End of variables declaration//GEN-END:variables

    //**************************************************************************
    
    private void setIcon() {
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("ECOFlow.png")));
    }
    
    //**************************************************************************
    
    //Lista de portas de comunicação ativas
    private void listaSerialCom(){
        DefaultComboBoxModel comboModel = (DefaultComboBoxModel) cbPortas.getModel();
        comboModel.removeAllElements();
        
        ArrayList<SerialCom> listas = controleAplicativo.getListaSerialCom();
        for(int i = 0; i < listas.size(); i++ ){
            SerialCom com = listas.get(i);
            comboModel.addElement(com.getNome() );
        }
    }
    
    //**************************************************************************
    
    //retorna as configurações atuais
    private void selecionar(){
        if(!controleAplicativo.selecionarPorta((String) cbPortas.getSelectedItem()).equals("ok\r") ){
            //Ativar botões e campos
            btnPadrao.setEnabled(true);
            btnAlterar.setEnabled(true);
            btnFinalizar.setEnabled(true);
            btnSelecionar.setEnabled(false);
            btnAtualizar.setEnabled(false);
            btnLeitura.setEnabled(true);
            txtSlaveadd.setEnabled(true);
            cbPortas.setEnabled(false);

            buscar();
        }else{
            JOptionPane.showMessageDialog(null, "Porta Selecionada inválida!", "Alerta",JOptionPane.ERROR_MESSAGE);
            controleAplicativo.fechar();
        }
    }
    
    //**************************************************************************
    
    private void buscar(){
        //Busca valor atual configurado
        txtSlaveadd.setText(controleAplicativo.comando("get slaveadd") );
        txtInitialRegister.setText(controleAplicativo.comando("get initialregister") );
        txtInitialInput.setText(controleAplicativo.comando("get initialinput") );
        txtMaxpulses.setText(controleAplicativo.comando("get maxpulses") );
        txtRegSize.setText(controleAplicativo.comando("get regsize") );
        txtBaudrate.setText(controleAplicativo.comando("get baudrate") );
        txtStopBits.setText(controleAplicativo.comando("get stopbits") );
        txtParity.setText(controleAplicativo.comando("get parity") );
        txtFormat.setText(controleAplicativo.comando("get format") );
    }
    
    //**************************************************************************
    
    private void alterar(){
        boolean verifica = true;
        //Aplica a nova configuração
        if(!controleAplicativo.comando("set slaveadd " + txtSlaveadd.getText() ).equals("ok\r") )
            verifica = false;
        if(!controleAplicativo.comando("set initialregister 33").equals("ok\r") )
            verifica = false;
        if(!controleAplicativo.comando("set initialinput 1").equals("ok\r") )
            verifica = false;
        if(!controleAplicativo.comando("set maxpulses 999").equals("ok\r") )
            verifica = false;
        if(!controleAplicativo.comando("set regsize 2").equals("ok\r") )
            verifica = false;
        if(!controleAplicativo.comando("set baudrate 9600").equals("ok\r") )
            verifica = false;
        if(!controleAplicativo.comando("set stopbits 1").equals("ok\r") )
            verifica = false;
        if(!controleAplicativo.comando("set parity 0").equals("ok\r") )
            verifica = false;
        if(!controleAplicativo.comando("set format bin").equals("ok\r") )
            verifica = false;
        
        //Verifica-se todos os comandos foram enviado com sucesso
        if(verifica){
            //verifica se as alterações foram salvas
            if(!controleAplicativo.comando("save").equals("ok\r") ){
                JOptionPane.showMessageDialog(null, "Ocorreu um problema em salvar as configurações! Tente novamente.",
                    "Alerta",JOptionPane.ERROR_MESSAGE);
                controleAplicativo.fechar();
            }
        }else{
            JOptionPane.showMessageDialog(null, "Ocorreu um problema em alterar as configurações! Tente novamente.",
                    "Alerta",JOptionPane.ERROR_MESSAGE);
            controleAplicativo.fechar();
        }
        buscar();
    }
    
    //**************************************************************************
    
    private void padrao(){
        boolean verifica = true;
        //Aplica a configuração padrão
        if(!controleAplicativo.comando("set slaveadd 1").equals("ok\r") )
            verifica = false;
        if(!controleAplicativo.comando("set initialregister 33").equals("ok\r") )
            verifica = false;
        if(!controleAplicativo.comando("set initialinput 1").equals("ok\r") )
            verifica = false;
        if(!controleAplicativo.comando("set maxpulses 999").equals("ok\r") )
            verifica = false;
        if(!controleAplicativo.comando("set regsize 2").equals("ok\r") )
            verifica = false;
        if(!controleAplicativo.comando("set baudrate 9600").equals("ok\r") )
            verifica = false;
        if(!controleAplicativo.comando("set stopbits 1").equals("ok\r") )
            verifica = false;
        if(!controleAplicativo.comando("set parity 0").equals("ok\r") )
            verifica = false;
        if(!controleAplicativo.comando("set format bin").equals("ok\r") )
            verifica = false;
        
        //Verifica-se todos os comandos foram enviado com sucesso
        if(verifica){
            //verifica se as alterações foram salvas
            if(!controleAplicativo.comando("save").equals("ok\r") ){
                JOptionPane.showMessageDialog(null, "Ocorreu um problema em salvar as configurações! Tente novamente.",
                    "Alerta",JOptionPane.ERROR_MESSAGE);
                controleAplicativo.fechar();
            }
        }else{
            JOptionPane.showMessageDialog(null, "Ocorreu um problema em alterar as configurações! Tente novamente.",
                    "Alerta",JOptionPane.ERROR_MESSAGE);
            controleAplicativo.fechar();
        }
        buscar();
    }
    
    //**************************************************************************
    
    private void finalizar(){
        
        //Ativar e desativar botões e campos
        btnPadrao.setEnabled(false);
        btnAlterar.setEnabled(false);
        btnFinalizar.setEnabled(false);
        btnSelecionar.setEnabled(true);
        btnAtualizar.setEnabled(true);
        btnLeitura.setEnabled(false);
        txtSlaveadd.setEnabled(false);
        cbPortas.setEnabled(true);
        
        controleAplicativo.fechar();
    }
    
    //**************************************************************************
    
    private void limpar(){
        //Limpar os dados dos campos
        txtSlaveadd.setText(null);
        txtInitialRegister.setText(null);
        txtInitialInput.setText(null);
        txtMaxpulses.setText(null);
        txtRegSize.setText(null);
        txtBaudrate.setText(null);
        txtStopBits.setText(null);
        txtParity.setText(null);
        txtFormat.setText(null);
    }
    
    //**************************************************************************

}
