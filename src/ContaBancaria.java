public class ContaBancaria {

    private float saldo;
    private String agencia;
    private String numero;
    private Pessoa titular;


    public ContaBancaria() {
        this.saldo = 0;
    }

    
    public ContaBancaria(float saldo) {
        if (saldo >= 0) {
            this.saldo = saldo;
        } else {
            this.saldo = 0;
        }
    }

    public float getSaldo() {
        return saldo;
    }

    public String getAgencia() {
        return agencia;
    }

    public void setAgencia(String agencia) {
        this.agencia = agencia;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public Pessoa getTitular() {
        return titular;
    }

    public void setTitular(Pessoa titular) {
        this.titular = titular;
    }

    public boolean depositar(float valor) {

        if (valor <= 0) {
            return false;
        }

        saldo += valor;
        return true;
    }


    public boolean sacar(float valor) {

        if (valor <= 0) {
            return false;
        }

        if (valor > saldo) {
            return false;
        }

        saldo -= valor;
        return true;
    }

    @Override
    public String toString() {
        return "Titular: " + titular.getNome() +
                " | Saldo: R$ " + saldo;
    }
}
