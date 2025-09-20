import java.util.ArrayList;

public class Banco {
    public static void main(String[] args) {
    }

    private String nome;
    public String getNome() {
        return nome;}
    public void setNome(String nome) {
        this.nome = nome;}
    //atributo "nome" do banco e seu get e set.
    
     ArrayList<Conta> contas = new ArrayList<>();
    //declarando o arraylist que guarda as contas.

    public void criarConta(String titular, int num){
        Conta novaconta = new Conta(titular, num);
        this.contas.add(novaconta);
    }
    /*metodo de criação de contas que é chamado pela classe
    *principal quando o usuário desejar criar uma conta nova*/


    public boolean procurarConta (int num){
        for(Conta conta : this.contas){
            if(conta.getNumero() == num){
                return true;
            }
        }
        return false;
    }
    /*esse método recebe o numero de uma conta a qual é desejado saber se existe.
     *ele percorre todo o array list, chamando a conta da vez da busca de "i" e,
     *assim, se o numero (getNumero) de i for igual ao numero dado, ele retorna true.*/


    public Conta retornarConta (int numeroconta){
        for(Conta conta : this.contas){
            if(conta.getNumero() == numeroconta){
                return conta;
            }
        }
        return null;
    }
    //metodo semelhante ao outro. MAS, em vez de retornar só se a conta existe, ele retorna seu número.


    public boolean transfEntreContas(int numcontaorigem, int numcontadestino, double valor){
    Conta contaOrigem = retornarConta(numcontaorigem);
    Conta contaDestino = retornarConta(numcontaorigem);

    //casos de erros
    if (contaOrigem == null) {
        return false;
    }
    if (contaDestino == null) {
        return false;
    }
    if (valor <= 0) {
        return false;
    }
    if (contaOrigem.getSaldo() < valor) {
        return false;
    }
    //caso esteja tudo certo:
    contaOrigem.sacar(valor);
    contaDestino.depositar(valor);
    return true; 
    }
    /*metodo que instancia 2 contas por meio de seus numeros e do metodo "retornarConta".
    *Após isso, confere se há algo de errado por meio desses 4 if's e, se tudo estiver correto,
    Ele transfere, retorna true e a mensagem de sucesso.*/
}
