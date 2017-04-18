package model;

import gnu.io.CommPortIdentifier;

public class SerialCom {
    
    private String nome;
    CommPortIdentifier id;
    private int baudrate;
    private int timeout;
    protected String peso;
    private boolean leitura;
    private boolean escrita;

    //**************************************************************************
    
    public SerialCom(){
        this.leitura = false;
        this.leitura = false;
    }
    
    //**************************************************************************
    
    public SerialCom(String p){
        this.nome = p;
        this.leitura = false;
        this.leitura = false;
    }
    
    //**************************************************************************
    
    public SerialCom( String p , int b , int t ){
        this.nome = p;
        this.baudrate = b;
        this.timeout = t;
        this.leitura = false;
        this.escrita = false;
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

    public String getPeso() {
        return peso;
    }
    
    //**************************************************************************

    public void setPeso(String peso) {
        this.peso = peso;
    }
    
    //**************************************************************************

    public boolean isLeitura() {
        return leitura;
    }
    
    //**************************************************************************

    public void setLeitura(boolean Leitura) {
        this.leitura = Leitura;
    }
    
    //**************************************************************************

    public boolean isEscrita() {
        return escrita;
    }
    
    //**************************************************************************

    public void setEscrita(boolean Escrita) {
        this.escrita = Escrita;
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
