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
                SerialCom com = new SerialCom(portId.getName() );
                listSerialCom.add(com);
                
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
    public SerialCom getIdPorta(SerialCom serialCom){    
        try {
            serialCom.setId(CommPortIdentifier.getPortIdentifier(serialCom.getNome() ) );
            System.out.println("Sucesso em obter o ID da porta: " + serialCom.getNome() );
        } catch (Exception e) {
            System.out.println("Erro obtendo ID da porta: " + e);
        }
        return serialCom;
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
    
    /* Habilita a porta serial COM para Escrita */
    public SerialCom HabilitarEscrita(SerialCom serialCom){
        serialCom.setEscrita(true);
        serialCom.setLeitura(false);
        
        return serialCom;
    }
    
    //**************************************************************************

    /* Habilita a porta serial COM para Leitura */
    public SerialCom HabilitarLeitura(SerialCom serialCom){
        serialCom.setEscrita(false);
        serialCom.setLeitura(true);
        
        return serialCom;
    }
    
    //**************************************************************************
    
}
