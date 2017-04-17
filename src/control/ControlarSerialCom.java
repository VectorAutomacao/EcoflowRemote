package control;

import gnu.io.CommPortIdentifier;
import gnu.io.SerialPort;
import java.util.ArrayList;
import java.util.Enumeration;
import model.SerialCom;

public class ControlarSerialCom {
    
    //**************************************************************************
    
    /* Lista de Portas Serial */
    public ArrayList<SerialCom> getListaPorta(){
        //Lista de portas COM disponiveis
        Enumeration portList = CommPortIdentifier.getPortIdentifiers();
        //lista das portas
        ArrayList<SerialCom> listSerialCom = new ArrayList<>();
        
        while (portList.hasMoreElements()) {
            //Porta atual da lista
            CommPortIdentifier portId = (CommPortIdentifier) portList.nextElement();
            
            if (portId.getPortType() == CommPortIdentifier.PORT_SERIAL) {
                //Adicionar porta a lista de serial COM
                SerialCom serialCom = new SerialCom(portId.getName() );
                listSerialCom.add(serialCom);
                
                //Printa a porta se disponivel
                System.out.println("Available port: " + portId.getName());
                
            } 
 
        } 
        
        return listSerialCom;
        
    } 
    
    //**************************************************************************
    
    /*
    identificar a porta selecionada
    obter o ID da porta para ser utilizado na identificação da mesma
    */
    public CommPortIdentifier getIdPorta(SerialCom serialCom){
        CommPortIdentifier id;
        
        try {
             id = CommPortIdentifier.getPortIdentifier(serialCom.getNome() );
             System.out.println("Sucesso em obter o ID da porta: " + serialCom.getNome() );
        } catch (Exception e) {
            System.out.println("Erro obtendo ID da porta: " + e);
        }
        
        return id;
        
    } 
    
    //**************************************************************************
    
    // comunicação com a porta serial, após essa porta aberta podemos ou enviar ou ler a serial
    /*
    é muito importante que os dados de DATABITS, STOPBITS, PARITY e FLOWCONTROL sejam exatos 
    ao do seu equipamento serial, pois são parâmetros que vão estabelecer a velocidade e modo de 
    leitura e escrita serial do computador com o seu equipamento
    */
    public SerialCom AbrirPorta(SerialCom serialCom){
        SerialPort porta;

        try {
            porta = (SerialPort)serialCom.getId().open("SerialComLeitura", serialCom.getTimeout());

            //configurar parâmetros
            porta.setSerialPortParams(serialCom.getBaudrate(),
            porta.DATABITS_8,
            porta.STOPBITS_1,
            porta.PARITY_NONE);
            porta.setFlowControlMode(SerialPort.FLOWCONTROL_NONE);
        }catch(Exception e){
            System.out.println("Erro abrindo comunicação: " + e);
        }
        
        return serialCom;
    }
    
    //**************************************************************************
    
    public void LerDados(SerialCom serialCom){
        
        if (serialCom.isEscrita() == false){

            try {
                entrada = porta.getInputStream();
            } catch (Exception e) {
                System.out.println("Erro de stream: " + e);
                System.exit(1);
            }

            try {
                porta.addEventListener(this);
            } catch (Exception e) {
                System.out.println("Erro de listener: " + e);
                System.exit(1);
            }
            porta.notifyOnDataAvailable(true);
            
            try {
                threadLeitura = new Thread(this);
                threadLeitura.start();
               run();
            } catch (Exception e) {
                System.out.println("Erro de Thred: " + e);
            }
        }
    }
    
    //**************************************************************************
    
}
