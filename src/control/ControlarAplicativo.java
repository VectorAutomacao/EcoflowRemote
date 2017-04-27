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
    public void selecionarPorta(String com){
        //Definindo propriedades da porta serial COM
        serialCom = new SerialCom(com, 115200, 0);
        
        //Obter ID da porta
        serialCom = controleSerialCom.getIdPorta(serialCom);
        
    }
    
    //**************************************************************************
    /*Metodo para enviar comando status*/
    public String comando(String msgSaida){
        //Abrir porta para Leitura e escrita
        serialCom = controleSerialCom.AbrirPorta(serialCom);
        
        //Iniciar Leitura
        controleSerialCom.HabilitarLeitura();
        controleSerialCom.leitura();
        
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
        controleSerialCom.FecharPorta();
        return controleSerialCom.getMsgEntrada();
        
    }
    
    //**************************************************************************
}
