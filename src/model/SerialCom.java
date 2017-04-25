package model;

import gnu.io.CommPortIdentifier;

public class SerialCom {

    private String nome;
    CommPortIdentifier id;
    private int baudrate;
    private int timeout;

    //**************************************************************************
    public SerialCom() {
    }

    //**************************************************************************
    public SerialCom(String p) {
        this.nome = p;
    }

    //**************************************************************************
    public SerialCom(String p, int b, int t) {
        this.nome = p;
        this.baudrate = b;
        this.timeout = t;
    }

    //**************************************************************************
    public String getNome() {
        return nome;
    }

    //**************************************************************************
    public void setNome(String Porta) {
        this.nome = Porta;
    }

    //**************************************************************************
    public int getBaudrate() {
        return baudrate;
    }

    //**************************************************************************
    public void setBaudrate(int baudrate) {
        this.baudrate = baudrate;
    }

    //**************************************************************************
    public int getTimeout() {
        return timeout;
    }

    //**************************************************************************
    public void setTimeout(int timeout) {
        this.timeout = timeout;
    }
    
    //**************************************************************************
    public CommPortIdentifier getId() {
        return id;
    }

    //**************************************************************************
    public void setId(CommPortIdentifier id) {
        this.id = id;
    }

    //**************************************************************************
}
