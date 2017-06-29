package control;

import java.util.ArrayList;
import model.SerialCom;

public class ControlarAplicativo {

    private ControlarSerialCom controleSerialCom = new ControlarSerialCom();
    private ArrayList<SerialCom> listaSerialCom = new ArrayList<>();
    private SerialCom serialCom;
    
    private final int TEMPO_RESPOSTA = 500;
    
    //**************************************************************************

    public ControlarAplicativo() {
    }
    
    //**************************************************************************
    /*Lista de portas COM disponiveis*/
    public ArrayList<SerialCom> getListaSerialCom() {
        return controleSerialCom.getListaPorta();
    }
    
    //**************************************************************************
    /*Selecionar e abrir comunicação com porta serial*/
    public String selecionarPorta(String com){
        //Definindo propriedades da porta serial COM
        serialCom = new SerialCom(com, 115200, 0);
        
        //Obter ID da porta
        serialCom = controleSerialCom.getIdPorta(serialCom);
        
        //Abrir porta para Leitura e escrita
        serialCom = controleSerialCom.AbrirPorta(serialCom);
        
        //Iniciar Leitura
        controleSerialCom.HabilitarLeitura();
        controleSerialCom.leitura();
        
        //Enviar string
        controleSerialCom.HabilitarEscrita();
        controleSerialCom.escrita(serialCom, "\r");
        controleSerialCom.HabilitarLeitura();
        
        //Tempo de espera para retonar uma resposta
        try {
            Thread.sleep(TEMPO_RESPOSTA);
        } catch (InterruptedException ex) {
            System.out.println("Erro na Thread: " + ex);
        }
        
        return controleSerialCom.getMsgEntrada();
        
    }
    
    //**************************************************************************
    /*Metodo para enviar comando status*/
    public String comando(String msgSaida){
        String msg = msgSaida + "\r";
        String resp;
        int i;
        
        System.out.println("Comando: " + msgSaida);
        
        //Enviar string
        controleSerialCom.HabilitarEscrita();
        
        for(i = 0; i < msg.length(); i++) 
            controleSerialCom.escrita(serialCom, String.valueOf(msg.charAt(i)) );
        
        controleSerialCom.HabilitarLeitura();
        
        //Tempo de espera para retonar uma resposta
        try {
            Thread.sleep(TEMPO_RESPOSTA);
        } catch (InterruptedException ex) {
            System.out.println("Erro na Thread: " + ex);
        }
        
        resp = controleSerialCom.getMsgEntrada();
        System.out.println("Resposta: " + resp);
        
        return resp;
        
    }
    
    //**************************************************************************
    
    //Fechar a porta COM e finaliza a Thread de leitura
    public void fechar(){
        controleSerialCom.FecharPorta();
    }
    
    //**************************************************************************
}
