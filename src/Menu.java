import exceptions.cep.programa.EntradaInvalida;
import requisitions.cep.programa.Requisitions;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Menu {
    private String inputCep;


    public void openMenu() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Para buscar um endereço, digite o CEP sem nenhuma pontuação, por exemplo: 38414171\n");
        System.out.println("Digite o CEP:\n");
        try {
            inputCep = scanner.nextLine();
            if (inputCep.length() != 8 ) {
                throw new EntradaInvalida("O CEP informado é inválido!");
            }
            Requisitions requisition = new Requisitions();
            requisition.searchCep(inputCep);
            searchAgain();
        } catch (EntradaInvalida e) {
            System.out.println(e.getMessage());
            openMenu();
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void searchAgain(){
        Scanner secondScanner = new Scanner(System.in);
        System.out.println("""
                
                Escolha uma opção abaixo:
                1- Procurar novo CEP
                2- Sair e obter histórico
                """);
        int input = secondScanner.nextInt();
        switch (input) {
            case 1:
                openMenu();
            case 2:
                break;
        }
    }
}
