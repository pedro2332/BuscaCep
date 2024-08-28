package requisitions.cep.programa;

public class Adress {
    private String cep;
    private String logradouro;
    private String complemento;
    private String unidade;
    private String bairro;
    private String localidade;
    private String uf;
    private String ibge;
    private String ddd;
    private String siafi;

    public Adress(AdressJson adress) {
        this.cep = adress.cep();
        this.logradouro = adress.logradouro();
        this.complemento = adress.complemento();
        this.unidade = adress.unidade();
        this.bairro = adress.bairro();
        this.localidade = adress.localidade();
        this.uf = adress.uf();
        this.ibge = adress.ibge();
        this.ddd = adress.ddd();
        this.siafi = adress.siafi();
    }

    @Override
    public String toString() {
        return "CEP: " + this.cep + "\nLogradouro: " + this.logradouro +
                "\nComplemento: " + this.complemento + "\nUnidade: " + this.unidade +
                "\nBairro: " + this.bairro + "\nLocalidade: " + this.localidade +
                "\nUF: " + this.uf + "\nIBGE: " + this.ibge + "\nDDD: " + this.ddd +
                "\nSiafi: " + this.siafi;
    }
}
