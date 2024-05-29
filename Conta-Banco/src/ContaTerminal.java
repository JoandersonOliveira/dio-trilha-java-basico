import java.text.MessageFormat;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ContaTerminal {
    public static int numero;
    public static int agencia;
    public static String nomeCliente;
    public static double saldo;

    public static void menu() {
        Scanner scanner = new Scanner(System.in);
        int resposta;

        while (true) {
            System.out.println("------Seja bem vindo-------\n");
            System.out.println("Digite a opção desejada para continuar\n");
            System.out.println("  ----Menu----");
            System.out.println("1 - CADASTRAR");
            System.out.println("2 - DEPOSITAR");
            System.out.println("3 - SAQUE");
            System.out.println("4 - EXTRATO");
            System.out.println("5 - DADOS DA CONTA");
            System.out.println("\n");

            try {
                resposta = scanner.nextInt();
                switch (resposta) {
                    case 1:
                        pegaInformacoes();
                        break;
                    case 2:
                        depositar();
                        break;
                    case 3:
                        sacar();
                        break;
                    case 4:
                        extrato();
                        break;
                    case 5:
                        dadosDaConta();
                        break;
                    default:
                        System.out.println("Valor inválido! Tente novamente.");
                }

            } catch (InputMismatchException e) {
                System.out.println("Valor inválido, digite uma das opções do Menu\n\n");
                scanner.next();
            }

        }

    }

    public static void pegaInformacoes() {
        Scanner scanner = new Scanner(System.in);
        Scanner entradaDeposito = new Scanner(System.in);

        System.out.println("Olá, seja bem vindo. Informe o seu nome por gentileza: ");
        nomeCliente = scanner.nextLine();

        while (true) {
            try {
                System.out.println("Por favor, digite o número da agência: ");
                agencia = scanner.nextInt();
                break;
            } catch (InputMismatchException e) {
                System.out.println("Valor inválido, digite um número para o número da agência");
                scanner.next();
            }
        }

        while (true) {
            try {
                System.out.println("Por favor, digite o número da conta: ");
                numero = scanner.nextInt();
                break;
            } catch (InputMismatchException e) {
                System.out.println("Valor inválido, digite um número para o número da conta");
                scanner.next();
            }
        }

        System.out.println(
                "olá " + nomeCliente + ", obrigado por criar uma conta em nosso banco, sua agência é a agência "
                        + agencia + ", conta " + numero + " e seu saldo R$" + saldo + " já está disponível para saque");

        while (true) {
            int respostafinal;
            try {
                System.out.println("Deseja fazer um depósito? 1 sim ou 2 não?");
                respostafinal = scanner.nextInt();
                if (respostafinal == 1) {
                    depositar();
                    break;
                } else if (respostafinal == 2) {
                    menu();
                }
            } catch (InputMismatchException e) {
                System.out.println("Valor inválido. Digite 1 caso queira fazer algum depósito ou 2 para encerrar.");
            }
        }
    }

    public static void depositar() {
        Scanner scanner = new Scanner(System.in);
        double valor;
        while (true) {
            try {
                System.out.println("Por gentileza informe o valor que gostaria de depositar.");
                valor = scanner.nextDouble();
                saldo += valor;
                System.out.println("Operação realizada com sucesso. Foi desopsitado vo valor de R$" + valor);
                menu();
                break;
            } catch (InputMismatchException e) {
                System.out.println("O valor digitado é inválido, por favor digite um valor válido Ex: 50.00");
                scanner.next();
            }
        }

        System.out.println("Valor de " + valor + " depositado com sucesso!\n Seu novo saldo é de" + saldo);
    }

    public static void sacar() {

        Scanner scanner = new Scanner(System.in);
        double valorSaque;
        System.out.println("Informe o valor para saque");
        valorSaque = scanner.nextDouble();
        saldo -= valorSaque;
        System.out.println("Saque realizado no valor de R$" + valorSaque);
    }

    public static void extrato() {
        System.out.println("-------EXTRATO-------\nSALDO: " + saldo + "\n\n");
    }

    public static void dadosDaConta() {
        System.out.println(
                "olá " + nomeCliente + ", obrigado por criar uma conta em nosso banco, sua agência é a agência "
                        + agencia + ", conta " + numero + " e seu saldo R$" + saldo + " já está disponível para saque");
    }

    public static void main(String[] args) throws Exception {
        menu();

    }
}