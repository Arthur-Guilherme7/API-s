package com.example.AtividadeAPI.Model;


import jakarta.persistence.Column;           // Define colunas no banco de dados
import jakarta.persistence.Entity;           // Define esta classe como uma entidade JPA
import jakarta.persistence.GeneratedValue;   // Define geração automática de IDs
import jakarta.persistence.GenerationType;   // Define a estratégia de geração de IDs
import jakarta.persistence.Id;               // Define o identificador (Primary Key) da entidade
import jakarta.persistence.PrePersist;       // Executa lógica antes de salvar no banco de dados
import jakarta.persistence.Table;            // Define o nome da tabela no banco de dados
import lombok.Getter;                        // Lombok - Gera os métodos GET automaticamente
import lombok.NoArgsConstructor;             // Lombok - Gera um construtor sem argumentos
import lombok.Setter;

    @Entity
    public class UsuarioModel{


        /**
         * Anotação que define o campo 'id' como a chave primária (Primary Key) da tabela.
         * A estratégia de geração é IDENTITY, que significa que o valor é gerado pelo banco de dados.
         */
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)

        private Long id;


        /**
         * Define a coluna 'name' no banco de dados.
         * - `nullable = false`: Essa coluna não pode ser nula.
         */
        @Column (nullable = false)
        private String nome;

        /**
         * Define a coluna 'endereço' no banco de dados.
         * - `length = 15`: Limita o tamanho do campo para 15 caracteres.
         * - Não é obrigatório (não possui nullable = false), então pode ser nulo.
         */
        @Column(length = 150)
        private String endereco;

        /**
         * Define a coluna 'setor' no banco de dados.
         * - `length = 50`: Limita o tamanho do campo para 50 caracteres.
         * - Não é obrigatório (não possui nullable = false), então pode ser nulo.
         */
        @Column(length = 50)
        private String setor;

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getNome() {
            return nome;
        }

        public void setNome(String nome) {
            this.nome = nome;
        }

        public String getEndereco() {
            return endereco;
        }

        public void setEndereco(String endereco) {
            this.endereco = endereco;
        }

        public String getSetor() {
            return setor;
        }

        public void setSetor(String setor) {
            this.setor = setor;
        }
    }

