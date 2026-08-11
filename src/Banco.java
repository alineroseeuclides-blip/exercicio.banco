import java.util.ArrayList;
import java.util.List;

public class Banco {

    private List<ContaBancaria> contas;

    
    public Banco(int tamanhoInicial) {
        contas = new ArrayList<>(tamanhoInicial);
    }

  
    public boolean adicionar(ContaBancaria conta) {

        if (conta == null) {
            return false;
        }

        for (ContaBancaria contaExistente : contas) {

            if (contaExistente.getAgencia().equals(conta.getAgencia())
                    && contaExistente.getNumero().equals(conta.getNumero())) {

                return false;
            }
        }

        contas.add(conta);
        return true;
    }

    public ContaBancaria recuperar(String agencia, String numero) {

        for (ContaBancaria conta : contas) {

            if (conta.getAgencia().equals(agencia)
                    && conta.getNumero().equals(numero)) {

                return conta;
            }
        }

        return null;
    }

    public List<ContaBancaria> getContas() {
        return contas;
    }

    public int quantidadeContas() {
        return contas.size();
    }
}
