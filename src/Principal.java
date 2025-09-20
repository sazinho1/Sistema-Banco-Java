import java.util.Scanner;

public class Principal {
    int operacao, cpf;
    String nometitular;
    //variaveis essenciais para o uso do sistema

    Banco meubanco = new Banco();
    Conta minhaconta = new Conta(nometitular, cpf);
    //instanciando as classes para poder chamar seus metodos

    Scanner teclado = new Scanner (System.in);
    //instanciando o teclado

    public void main(String[] args) {
        System.out.println("Olá e seja bem vindo ao sistema do banco ficcional!\nO que deseja fazer hoje?");
        System.out.println("1 - Acessar uma conta\n2 - Criar uma conta\n3 - Sair");
        operacao = teclado.nextInt();
        switch(operacao){
            case 1 -> {
                System.out.println("Digite o numero(cpf) da conta:");
                cpf = teclado.nextInt();
                if(meubanco.procurarConta(cpf)){
                    System.out.println("O que deseja fazer agora?");
                    System.out.println("1 - Consultar saldo\n2 - Transferir um valor\n3 - Sacar um valor\n4 - Depositar um valor\n 5 - Sair");
                    operacao = teclado.nextInt();
                    dentroDaConta(operacao, cpf);
                }
                else System.out.println("Erro. Conta não existente");
            }

            case 2 -> {
                System.out.println("Digite o seu nome:");
                nometitular = teclado.nextLine();
                System.out.println("\nAgora digite seu cpf");
                cpf = teclado.nextInt();
                meubanco.criarConta(nometitular, cpf);
                //para pegar e cadastrar nome e cpf do indivíduo na conta
            }
                
            default -> {
                break;
            }
        }
    }

    public void dentroDaConta(int opcao, int cpf){
        double valor;
        switch(opcao){
            case 1 -> System.out.println("Seu saldo é R$" + minhaconta.getSaldo());

            case 2 -> {
                int cpfdestino;
                System.out.println("Digite o numero(cpf) da conta de destino:");
                cpfdestino = teclado.nextInt();
                System.out.println("Digite o valor a ser transferido:");
                valor = teclado.nextDouble();
                if(meubanco.transfEntreContas(cpf, cpfdestino, valor)){
                    System.out.println("Transferencia de R$" + valor + "realizada com sucesso.");
                }
                else System.out.println("Erro. Tente novamente");
            }

            case 3 -> {
                System.out.println("Digite o valor a ser sacado:");
                valor = teclado.nextDouble();
                if(minhaconta.getSaldo() > valor){
                    minhaconta.sacar(valor);
                    System.out.println("Sucesso.");
                }
                System.out.println("Erro. Saldo insuficiente");
            }
            case 4 -> {
                System.out.println("Digite o valor a ser depositado:");
                valor = teclado.nextDouble();
                minhaconta.depositar(valor);
                System.out.println("Sucesso.");
            }
            default ->{
                break;
            }
        }
    }
}
