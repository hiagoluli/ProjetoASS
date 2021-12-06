
package projetoass.Models;

import java.util.ArrayList;


public class Fornecedores {
    protected String nome;
    protected String telefone;
    protected String endereco;
    
    ArrayList<Fornecedores> ListaFornecedores; //Lista de Produtos
        
        public void cadastrarFornecedor(Fornecedores Fn){
              ListaFornecedores.add(Fn);
        }
        public Fornecedores(){
            ListaFornecedores = new ArrayList();
        }
        public Fornecedores(String nome, String telefone, String endereco){
            this.nome = nome;
            this.telefone = telefone;
            this.endereco = endereco;
            ListaFornecedores = new ArrayList();
        }
    
    public void cadastrarFornecedor(){
        
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

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
    
    
}
