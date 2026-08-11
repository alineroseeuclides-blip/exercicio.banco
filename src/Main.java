import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Banco banco = new Banco(5);

        System.out.println("=================================");
        System.out.println("     CADASTRO DE CONTAS");
        System.out.println("=================================");

        
        for (int i = 0; i < 5; i++) {

            System.out.println("\nCadastro da conta " + (i + 1));

            System.out.print("Nome do titular: ");
            String nome = scanner.nextLine();

            Pessoa pessoa = new Pessoa(nome);

            System.out.print("Agência: ");
            String agencia = scanner.nextLine();

            System.out.print("Número da conta: ");
            String numero = scanner.nextLine();

            System.out.print("Saldo inicial: ");
            float saldo = scanner.nextFloat();
            scanner.nextLine();

            ContaBancaria conta = new ContaBancaria(saldo);

            conta.setTitular(pessoa);
            conta.setAgencia(agencia);
            conta.setNumero(numero);

            if (banco.adicionar(conta)) {
                System.out.println("Conta cadastrada com sucesso!");
            } else {
                System.out.println(
                        "Erro: já existe uma conta com essa agência e número."
                );
                i--;
            }
        }

        int opcao;

        do {

            System.out.println("\n=================================");
            System.out.println("          MENU PRINCIPAL");
            System.out.println("=================================");
            System.out.println("1. Fazer um depósito");
            System.out.println("2. Fazer um saque");
            System.out.println("3. Consultar saldo");
            System.out.println("4. Listar todos os clientes do banco");
            System.out.println("5. Informar total de contas cadastradas");
            System.out.println("6. Sair");
            System.out.println("=================================");

            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {

                case 1:
                    fazerDeposito(scanner, banco);
                    break;

                case 2:
                    fazerSaque(scanner, banco);
                    break;

                case 3:
                    consultarSaldo(scanner, banco);
                    break;

                case 4:
                    listarClientes(banco);
                    break;

                case 5:
                    System.out.println(
                            "Total de contas cadastradas: "
                                    + banco.quantidadeContas()
                    );
                    break;

                case 6:
                    System.out.println("\nEncerrando o programa...");
                    break;

                default:
                    System.out.println("Opção inválida!");
            }

        } while (opcao != 6);


        System.out.println("\n=================================");
        System.out.println("      TITULARES DAS CONTAS");
        System.out.println("=================================");

        for (ContaBancaria conta : banco.getContas()) {
            System.out.println(conta.getTitular().getNome());
        }

        scanner.close();
    }

    // OPÇÃO 1 - DEPÓSITO
    public static void fazerDeposito(
            Scanner scanner,
            Banco banco) {

        System.out.print("Agência: ");
        String agencia = scanner.nextLine();

        System.out.print("Número da conta: ");
        String numero = scanner.nextLine();

        ContaBancaria conta = banco.recuperar(agencia, numero);

        if (conta == null) {
            System.out.println("Conta não encontrada!");
            return;
        }

        System.out.print("Valor do depósito: ");
        float valor = scanner.nextFloat();
        scanner.nextLine();

        if (conta.depositar(valor)) {
            System.out.println("Depósito realizado com sucesso!");
            System.out.println("Novo saldo: R$ " + conta.getSaldo());
        } else {
            System.out.println(
                    "Não foi possível realizar o depósito."
            );
        }
    }

   
    public static void fazerSaque(
            Scanner scanner,
            Banco banco) {

        System.out.print("Agência: ");
        String agencia = scanner.nextLine();

        System.out.print("Número da conta: ");
        String numero = scanner.nextLine();

        ContaBancaria conta = banco.recuperar(agencia, numero);

        if (conta == null) {
            System.out.println("Conta não encontrada!");
            return;
        }

        System.out.print("Valor do saque: ");
        float valor = scanner.nextFloat();
        scanner.nextLine();

        if (conta.sacar(valor)) {
            System.out.println("Saque realizado com sucesso!");
            System.out.println("Novo saldo: R$ " + conta.getSaldo());
        } else {
            System.out.println(
                    "Não foi possível realizar o saque."
            );
        }
    }

    
    public static void consultarSaldo(
            Scanner scanner,
            Banco banco) {

        System.out.print("Agência: ");
        String agencia = scanner.nextLine();

        System.out.print("Número da conta: ");
        String numero = scanner.nextLine();

        ContaBancaria conta = banco.recuperar(agencia, numero);

        if (conta == null) {
            System.out.println("Conta não encontrada!");
            return;
        }

        System.out.println("\n" + conta);
    }

 
    public static void listarClientes(Banco banco) {

        System.out.println("\n=================================");
        System.out.println("          CLIENTES");
        System.out.println("=================================");

        for (ContaBancaria conta : banco.getContas()) {

            System.out.println(
                    "Titular: " +
                    conta.getTitular().getNome()
            );
        }
    }
}
