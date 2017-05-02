package control;

import gnu.io.CommPortIdentifier;
import gnu.io.SerialPort;
import gnu.io.SerialPortEvent;
import gnu.io.SerialPortEventListener;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Enumeration;
import model.SerialCom;

public class ControlarSerialCom implements Runnable, SerialPortEventListener {

    SerialPort porta;
    private OutputStream saida;
    private InputStream entrada;
    private Thread threadLeitura;
    private boolean leitura;
    private boolean escrita;
    private String msgEntrada = "";
    
    //**************************************************************************
    /*Get da menssagem de leitura da porta COM*/
    public String getMsgEntrada() {
        return msgEntrada;
    }
    
    //**************************************************************************
     /* Habilita a porta serial COM para Escrita */
    public void HabilitarEscrita() {
        escrita = true;
        leitura = false;
        msgEntrada = "";
    }

    //**************************************************************************
    /* Habilita a porta serial COM para Leitura */
    public void HabilitarLeitura() {
        escrita = false;
        leitura = true;
    }
    
    //**************************************************************************
    /* Lista de Portas Serial */
    public ArrayList<SerialCom> getListaPorta() {
        //Lista de portas COM disponiveis
        Enumeration portList = CommPortIdentifier.getPortIdentifiers();
        //lista das portas
        ArrayList<SerialCom> listSerialCom = new ArrayList<>();

        while (portList.hasMoreElements()) {
            //Porta atual da lista
            CommPortIdentifier portId = (CommPortIdentifier) portList.nextElement();

            if (portId.getPortType() == CommPortIdentifier.PORT_SERIAL) {
                //Adicionar porta a lista de serial COM
                SerialCom com = new SerialCom(portId.getName());
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
    public SerialCom getIdPorta(SerialCom serialCom) {
        try {
            serialCom.setId(CommPortIdentifier.getPortIdentifier(serialCom.getNome()));
            System.out.println("Sucesso em obter o ID da porta: " + serialCom.getNome());
        } catch (Exception e) {
            System.out.println("Erro obtendo ID da porta: " + e);
        }
        return serialCom;
    }

    //**************************************************************************
    /* 
    comunicação com a porta serial, após essa porta aberta podemos ou enviar ou ler a serial
    é muito importante que os dados de DATABITS, STOPBITS, PARITY e FLOWCONTROL sejam exatos 
    ao do seu equipamento serial, pois são parâmetros que vão estabelecer a velocidade e modo de 
    leitura e escrita serial do computador com o seu equipamento
     */
    public SerialCom AbrirPorta(SerialCom serialCom) {

        try {
            porta = (SerialPort) serialCom.getId().open("SerialComLeitura", serialCom.getTimeout());

            //configurar parâmetros
            porta.setSerialPortParams(serialCom.getBaudrate(),
                    SerialPort.DATABITS_8,
                    SerialPort.STOPBITS_1,
                    SerialPort.PARITY_NONE);
            porta.setFlowControlMode(SerialPort.FLOWCONTROL_NONE);
        } catch (Exception e) {
            System.out.println("Erro abrindo comunicação: " + e);
        }
        return serialCom;
    }

    //**************************************************************************
    /*Saida de de dados da porta serial*/
    public void escrita(SerialCom serialCom, String msgSaida) {

        if (escrita == true && leitura == false) {

            try {
                saida = porta.getOutputStream();
                System.out.println("FLUXO OK!");

            } catch (Exception e) {
                System.out.println("Erro.STATUS: " + e);
            }

            try {
                System.out.println("Enviando um byte para " + serialCom.getNome());
                System.out.println("Enviando : " + msgSaida);
                saida.write(msgSaida.getBytes());
                Thread.sleep(100);
                saida.flush();

            } catch (Exception e) {
                System.out.println("Houve um erro durante o envio. ");
                System.out.println("STATUS: " + e);
                System.exit(1);
            }

        } else {
            System.exit(1);
        }
    }

    //**************************************************************************
    /*Habilitar leitura da porta*/
    public void leitura() {

        if (leitura == true && escrita == false) {

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
    /*Metodo absstrato manter e controlar a thread de leitura*/
    public void run() {

        try {
            Thread.sleep(5);
        } catch (Exception e) {
            System.out.println("Erro de Thred: " + e);
        }
    }

    //**************************************************************************
    /*Metodo que monitora a porta serial entrada de dados*/
    public void serialEvent(SerialPortEvent ev) {

        StringBuffer bufferLeitura = new StringBuffer();
        int novoDado = 0;

        switch (ev.getEventType()) {
            case SerialPortEvent.BI:
            case SerialPortEvent.OE:
            case SerialPortEvent.FE:
            case SerialPortEvent.PE:
            case SerialPortEvent.CD:
            case SerialPortEvent.CTS:
            case SerialPortEvent.DSR:
            case SerialPortEvent.RI:
            case SerialPortEvent.OUTPUT_BUFFER_EMPTY:
                break;
            case SerialPortEvent.DATA_AVAILABLE:

                //Novo algoritmo de leitura.
                while (novoDado != -1) {

                    try {
                        novoDado = entrada.read();

                        if (novoDado == -1) {
                            break;
                        }
                        
                        bufferLeitura.append((char) novoDado);

                    } catch (IOException ioe) {
                        System.out.println("Erro de leitura serial: " + ioe);
                    }
                }
                msgEntrada = new String(bufferLeitura);
                System.out.println("Recebido: " + msgEntrada);
                break;
        }
    }

    //**************************************************************************
    /*Fechar porta Serial COM e finalizar Thread*/
    public void FecharPorta() {

        try {
            porta.close();//fechar a porta
            threadLeitura.interrupt();// finaliza a Thread de leitura
            
        } catch (Exception e) {
            System.out.println("Erro fechando porta: " + e);
            System.exit(0);
        }
    }

    //**************************************************************************
}
