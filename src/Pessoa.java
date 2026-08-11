import java.time.Instant;

public class Pessoa {

    private long id;
    private String nome;

    // Construtor padrão
    public Pessoa() {
        this.id = Instant.now().toEpochMilli();
    }

    // Construtor recebendo o nome
    public Pessoa(String nome) {
        this.id = Instant.now().toEpochMilli();
        this.nome = nome;
    }

    public long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "Pessoa{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                '}';
    }
}
