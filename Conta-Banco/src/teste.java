import java.text.MessageFormat;
import java.util.Scanner;

public class ContaTerminal {
    int numero;
    String agencia = "";
    String nomeCliente = "";
    double saldo;

    // Método para exibir o menu de opções
    public void exibirMenu() {
        Scanner scanner = new Scanner(System.in);
        int opcao = -1;

        while (opcao != 0) {
            System.out.println("\nMenu:");
            System.out.println("1. Exibir informações da conta");
            System.out.println("2. Depositar");
            System.out.println("3. Sacar");
            System.out.println("4. Imprimir extrato");
            System.out.println("0. Sair");
            System.out.print("Selecione uma opção: ");

            if (scanner.hasNextInt()) {
                opcao = scanner.nextInt();
                switch (opcao) {
                    case 1:
                        imprimirInformacoesConta();
                        break;
                    case 2:
                        System.out.print("Digite o valor para depositar: ");
                        if (scanner.hasNextDouble()) {
                            double valorDeposito = scanner.nextDouble();
                            depositar(valorDeposito);
                        } else {
                            System.out.println("Valor inválido.");
                            scanner.next(); // Limpar a entrada inválida
                        }
                        break;
                    case 3:
                        System.out.print("Digite o valor para sacar: ");
                        if (scanner.hasNextDouble()) {
                            double valorSaque = scanner.nextDouble();
                            sacar(valorSaque);
                        } else {
                            System.out.println("Valor inválido.");
                            scanner.next(); // Limpar a entrada inválida
                        }
                        break;
                    case 4:
                        imprimirExtrato();
                        break;
                    case 0:
                        System.out.println("Saindo...");
                        break;
                    default:
                        System.out.println("Opção inválida. Tente novamente.");
                }
            } else {
                System.out.println("Entrada inválida. Por favor, insira um número.");
                scanner.next(); // Limpar a entrada inválida
            }
        }
    }

    // Método para pegar informações do cliente
    public void pegarInformacoesCliente() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite o número da conta: ");
        while (!scanner.hasNextInt()) {
            System.out.println("Entrada inválida. Por favor, insira um número inteiro.");
            scanner.next();
        }
        numero = scanner.nextInt();

        System.out.print("Digite o nome da agência: ");
        agencia = scanner.next();

        System.out.print("Digite o nome do cliente: ");
        nomeCliente = scanner.next();

        System.out.print("Digite o saldo inicial: ");
        while (!scanner.hasNextDouble()) {
            System.out.println("Entrada inválida. Por favor, insira um número decimal.");
            scanner.next();
        }
        saldo = scanner.nextDouble();
    }

    // Método para exibir informações da conta
    public void imprimirInformacoesConta() {
        System.out.println("Número da conta: " + numero);
        System.out.println("Agência: " + agencia);
        System.out.println("Nome do cliente: " + nomeCliente);
        System.out.println("Saldo: " + saldo);
    }

    // Método para depositar
    public void depositar(double valor) {
        if (valor > 0) {
            saldo += valor;
            System.out.println("Depósito realizado com sucesso. Novo saldo: " + saldo);
        } else {
            System.out.println("Valor de depósito inválido.");
        }
    }

    // Método para sacar
    public void sacar(double valor) {
        if (valor > 0 && valor <= saldo) {
            saldo -= valor;
            System.out.println("Saque realizado com sucesso. Novo saldo: " + saldo);
        } else {
            System.out.println("Valor de saque inválido ou saldo insuficiente.");
        }
    }

    // Método para imprimir extrato
    public void imprimirExtrato() {
        System.out.println("Número da conta: " + numero);
        System.out.println("Agência: " + agencia);
        System.out.println("Nome do cliente: " + nomeCliente);
        System.out.println("Saldo: " + saldo);
    }

    public static void main(String[] args) {
        ContaTerminal conta = new ContaTerminal();
        
        // Chamando métodos da classe para interagir com o usuário
        conta.pegarInformacoesCliente();
        conta.exibirMenu();
    }
}
