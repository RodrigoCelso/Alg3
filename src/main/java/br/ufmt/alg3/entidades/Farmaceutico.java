package br.ufmt.alg3.entidades;

public class Farmaceutico {
    private int idFarmaceutico;
    private Empresa empresa;
    private String nome;
    private char[] crf = new char[5];

    public int getIdFarmaceutico() {
        return idFarmaceutico;
    }

    public void setIdFarmaceutico(int idFarmaceutico) {
        this.idFarmaceutico = idFarmaceutico;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public char[] getCrf() {
        return crf;
    }

    public void setCrf(char[] crf) {
        this.crf = crf;
    }
    
    
}
