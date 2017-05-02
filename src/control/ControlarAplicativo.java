package control;

import java.util.ArrayList;
import model.SerialCom;

public class ControlarAplicativo {

    private ControlarSerialCom controleSerialCom = new ControlarSerialCom();
    private ArrayList<SerialCom> listaSerialCom = new ArrayList<>();
    private SerialCom serialCom;
    
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
            Thread.sleep(500);
        } catch (InterruptedException ex) {
            System.out.println("Erro na Thread: " + ex);
        }
        
        return controleSerialCom.getMsgEntrada();
        
    }
    
    //**************************************************************************
    /*Metodo para enviar comando status*/
    public String comando(String msgSaida){
        
        //Enviar string
        controleSerialCom.HabilitarEscrita();
        controleSerialCom.escrita(serialCom, msgSaida + "\r");
        controleSerialCom.HabilitarLeitura();
        
        //Tempo de espera para retonar uma resposta
        try {
            Thread.sleep(500);
        } catch (InterruptedException ex) {
            System.out.println("Erro na Thread: " + ex);
        }
        
        return controleSerialCom.getMsgEntrada();
        
    }
    
    //**************************************************************************
    
    //Fechar a porta COM e finaliza a Thread de leitura
    public void fechar(){
        controleSerialCom.FecharPorta();
    }
    
    //**************************************************************************
}
