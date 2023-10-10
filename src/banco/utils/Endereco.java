package banco.utils;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

// Builder Class
@ToString
@Setter
@Builder
public class Endereco {
    @Getter private String logradouro;
    @Getter private int numero;
    @Getter private String cidade;
    private EstadosBrasileiros estado;

    public String getEstado() {
        return estado.getEstado();
    }
}