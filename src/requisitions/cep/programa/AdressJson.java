package requisitions.cep.programa;

public record AdressJson(String cep, String logradouro,
                         String complemento, String unidade,
                         String bairro, String localidade,
                         String uf, String ibge, String ddd,
                         String siafi) {
}
