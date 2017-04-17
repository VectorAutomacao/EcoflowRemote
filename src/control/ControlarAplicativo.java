package control;

import java.util.ArrayList;
import model.SerialCom;

public class ControlarAplicativo {
    
    private ControlarSerialCom controleSerialCom = new ControlarSerialCom();
    private ArrayList<SerialCom> listSerialCom = new ArrayList<>();
    private SerialCom serialCom = new SerialCom();
    
    public ControlarAplicativo(){
        
        listSerialCom = controleSerialCom.getListaPorta();
        
        //verifica se existe porta serial COM
        if( listSerialCom.size() != 0)
            serialCom = controleSerialCom.getIdPorta( listSerialCom.get(3) );
        else
            System.out.println("Sem porta serial COM");
        
        //
        serialCom.setTimeout(0);
        serialCom.setBaudrate(9600);
        serialCom.HabilitarLeitura();
        
        serialCom = controleSerialCom.AbrirPorta(serialCom);
        
        
        
    }
    
    
}
