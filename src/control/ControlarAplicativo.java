package control;

import java.util.ArrayList;
import model.SerialCom;

public class ControlarAplicativo {

    private ControlarSerialCom controleSerialCom = new ControlarSerialCom();
    private ArrayList<SerialCom> listSerialCom = new ArrayList<>();
    private SerialCom serialCom;

    public ControlarAplicativo() {

        //Obter lista de serial COM disponivel
        listSerialCom = controleSerialCom.getListaPorta();

        //verifica se a lista de portas não esta vazia
        if (!listSerialCom.isEmpty())
        {
            //Definindo propriedades da porta serial COM
            serialCom = new SerialCom(listSerialCom.get(0).getNome(), 115200, 0);
            //Obter ID da porta
            serialCom = controleSerialCom.getIdPorta(serialCom);
        } else {
            System.out.println("Sem porta serial COM");
        }

        //Abrir porta para Leitura e escrita
        serialCom = controleSerialCom.AbrirPorta(serialCom);
        
        //Iniciar Leitura
        controleSerialCom.HabilitarLeitura();
        controleSerialCom.leitura();
        
        //Enviar string
        controleSerialCom.HabilitarEscrita();
        controleSerialCom.escrita(serialCom, "get version\r");
        controleSerialCom.HabilitarLeitura();
        
        try {
            Thread.sleep(500);
        } catch (InterruptedException ex) {
            System.out.println("Erro na Thread: " + ex);
        }
        
        System.out.println(controleSerialCom.getMsgEntrada());
        
        controleSerialCom.HabilitarEscrita();
        controleSerialCom.escrita(serialCom, "get baudrate\r");
        controleSerialCom.HabilitarLeitura();
        
        try {
            Thread.sleep(500);
        } catch (InterruptedException ex) {
            System.out.println("Erro na Thread: " + ex);
        }
        
        System.out.println(controleSerialCom.getMsgEntrada());
        
        controleSerialCom.FecharPorta();

    }

}
