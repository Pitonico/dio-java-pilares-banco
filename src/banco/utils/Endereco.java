package banco.utils;

// Builder Class
public class Endereco {
    private String logradouro;
    private int numero;
    private String cidade;
    private String estado;

    public static class Builder {
        private String logradouro;
        private int numero;
        private String cidade;
        private EstadosBrasileiros estado;

        public Builder setLogradouro(String logradouro) {
            this.logradouro = logradouro;
            return this;
        }
        public Builder setNumero(int numero) {
            this.numero = numero;
            return this;
        }
        public Builder setCidade(String cidade) {
            this.cidade = cidade;
            return this;
        }
        public Builder setEstado(EstadosBrasileiros estado) {
            this.estado = estado;
            return this;
        }

        public Endereco build() {
            Endereco endereco = new Endereco();
            endereco.setLogradouro(logradouro);
            endereco.setNumero(numero);
            endereco.setCidade(cidade);
            endereco.setEstado(estado);
            return endereco;
        }
    }
    
    public static Builder builder() {
        return new Builder();
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(EstadosBrasileiros estado) {
        this.estado = estado.getEstado();
    }

    @Override
    public String toString() {
        return "Endereco [logradouro=" + logradouro + ", numero=" + numero + ", cidade=" + cidade + ", estado=" + estado
                + "]";
    }
}