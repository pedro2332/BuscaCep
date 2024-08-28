package exceptions.cep.programa;

public class EntradaInvalida extends Throwable {
    private String mensagem;
    public EntradaInvalida(String mensagem) {
        this.mensagem = mensagem;
    }

    @Override
    public String getMessage() {
        return this.mensagem;
    }
}
