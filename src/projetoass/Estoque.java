
package projetoass;

import java.util.ArrayList;


public final class Estoque extends Produto {
        protected int qtde;
        
        ArrayList<Estoque> ListaProduto; //Lista de Produtos
        
        public void cadastrarProduto(Estoque P){
              ListaProduto.add(P);
        }
        public Estoque(){
            ListaProduto = new ArrayList();
        }
        public Estoque(int codBarras, String nome, double preco, int tamanho , String cor, int qtde){
            this.codBarras = codBarras;
            this.preco = preco;
            this.tamanho = tamanho;
            this.nome = nome;
            this.cor = cor;
            this.qtde = qtde;
            ListaProduto = new ArrayList();
        }
        
        public void cadastrarProduto(){
        
        }

    public int getQtde() {
        return qtde;
    }

    public void setQtde(int qtde) {
        this.qtde = qtde;
    }

    public int getCodBarras() {
        return codBarras;
    }

    public void setCodBarras(int codBarras) {
        this.codBarras = codBarras;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public int getTamanho() {
        return tamanho;
    }

    public void setTamanho(int tamanho) {
        this.tamanho = tamanho;
    }
   
}
