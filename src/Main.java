import requisitions.cep.programa.Requisitions;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Requisitions requisition = new Requisitions();
        requisition.cleanData();
        System.out.println("Bem vindo ao programa de busca de CEP!\n");
        Menu menu = new Menu();
        menu.openMenu();

    }
}