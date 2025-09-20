public class Conta {
    public static void main(String[] args) {
    }

    private String titular;
    private int numero;
    private double saldo;
    //atributos básicos da conta

    public String getTitular() {
        return titular;}
    public void setTitular(String titular) {
        this.titular = titular;}
    public int getNumero() {
        return numero;}
    public void setNumero(int numero) {
        this.numero = numero;}
    public double getSaldo() {
        return saldo;}
    public void setSaldo(double saldo) {
        this.saldo = saldo;}
    /*getters e setters dos atributos das contas, já que elas são privadas
    *e seus atributos precisam ser usados na criação ou manipulação das contas*/

    public Conta (String titular, int num){
        this.titular = titular;
        this.numero = num;
        this.saldo = 0;
    }
    //objeto conta utilizado no metodo "criarConta" na classe banco.

    public void sacar (double valor){
        if(valor > 0 && this.saldo >= valor){
            this.saldo -= valor;
        }
    }
    /*esse método confere se o valor a ser sacado é válido (>0) e se a conta tem
    *dinheiro suficiente para realizar o saque. Se tudo estiver de acordo, ele
    *saca o valor.*/

    public void depositar (double valor){
        if(valor>0){    
            this.saldo += valor;
        }
    }


}
