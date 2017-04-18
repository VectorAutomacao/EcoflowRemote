package control;

import java.util.ArrayList;
import model.SerialCom;

public class ControlarAplicativo {
    
    private ControlarSerialCom controleSerialCom = new ControlarSerialCom();
    private ArrayList<SerialCom> listSerialCom = new ArrayList<>();
    private SerialCom serialCom = new SerialCom();
    
    public ControlarAplicativo(){
        
        //Obter lista de serial COM disponivel
        listSerialCom = controleSerialCom.getListaPorta();
        
        //verifica se existe porta serial COM
        if( listSerialCom.size() != 0)
            //Obter ID da porta
            serialCom = controleSerialCom.getIdPorta( listSerialCom.get(1) );
        else
            System.out.println("Sem porta serial COM");
        
        //Definindo propriedades da porta serial COM
        serialCom.setTimeout(0);
        serialCom.setBaudrate(9600);
        
        //Controlar porta serial
        controleSerialCom.HabilitarEscrita(serialCom);
        serialCom = controleSerialCom.AbrirPorta(serialCom);
        controleSerialCom.EnviarString(serialCom, "Ola mundo!");
        
        controleSerialCom.FecharCom();
        
    }
    
    
}
