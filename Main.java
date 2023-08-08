import java.util.ArrayList;
import java.util.Scanner;

public class Main{
    public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    ArrayList<Item> cardapio = new ArrayList<>();

    cardapio.add(new Item("Refrigerante", 6.00));
    cardapio.add(new Item("Suco", 7.00));
    cardapio.add(new Item("Salgado", 6.00));
    cardapio.add(new Item("Hamburguer", 11.00));

     boolean sair = false;
        while (!sair) {
            System.out.println("===== MENU =====");
            System.out.println("1 - Fazer Pedido");
            System.out.println("2 - Sair");

            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();

            if (opcao == 1) {
                scanner.nextLine(); 
                System.out.print("Digite o nome do cliente: ");
                String nomeCliente = scanner.nextLine();

                ArrayList<Item> pedido = new ArrayList<>();
                int itemEscolhido;
                do {
                    System.out.println("\nCardápio:");
                    for (int i = 0; i < cardapio.size(); i++) {
                        System.out.println(i + 1 + "- " + cardapio.get(i).getNome() + " - R$" + cardapio.get(i).getPreco());
                    }
                    System.out.println("0- Finalizar Pedido");

                    System.out.print("Olá " + nomeCliente + " Digite o número do item desejado: ");
                    itemEscolhido = scanner.nextInt();

                    if (itemEscolhido >= 1 && itemEscolhido <= cardapio.size()) {
                        pedido.add(cardapio.get(itemEscolhido - 1));
                    } else if (itemEscolhido != 0) {
                        System.out.println("Opção inválida!");
                    }
                } while (itemEscolhido != 0);

                double totalPedido = 0;
                System.out.println("\nNota Fiscal:");
                for (Item item : pedido) {
                    System.out.println(item.getNome() + " - R$" + item.getPreco());
                    totalPedido += item.getPreco();
                }

                double taxaServico = totalPedido * 0.10;
                double totalComTaxa = totalPedido + taxaServico;
                System.out.println("Taxa de Serviço (10%): R$" + taxaServico);
                System.out.println("Total: R$" + totalComTaxa);
                
                double troco;
                do {
                    System.out.print("\nDigite o valor recebido em dinheiro: ");
                    double valorRecebido = scanner.nextDouble();

                    troco = valorRecebido - totalComTaxa;

                    if (troco < 0) {
                        System.out.println("Valor insuficiente! Ta querendo enganar quem?");
                    }
                } while (troco < 0);

                System.out.println("Troco: R$" + troco);

            } else if (opcao == 2) {
                sair = true;
            } else {
                System.out.println("Opção inválida!");
            }
        }

        scanner.close();
    }
}
