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
        if (listSerialCom.size() != 0)
        {
            //Definindo propriedades da porta serial COM
            serialCom = new SerialCom(listSerialCom.get(1).getNome(), 9600, 0);
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
        
        //Enviar string 1
        controleSerialCom.HabilitarEscrita();
        controleSerialCom.escrita(serialCom, "Ola mundo! 1");
        controleSerialCom.HabilitarLeitura();
       
        //Enviar string 2
        controleSerialCom.HabilitarEscrita();
        controleSerialCom.escrita(serialCom, "Ola mundo! 2");
        controleSerialCom.HabilitarLeitura();
        
        //controleSerialCom.FecharPorta();

    }

}
