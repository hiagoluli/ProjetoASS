
package projetoass;
import java.util.ArrayList;

public final class Funcionario extends Pessoa {
        protected int codFuncionario;
        protected int senha;
        protected String usuario;
        
        ArrayList<Funcionario> ListaFunc;
        
        public void cadastrarFuncionario(Funcionario F){
              ListaFunc.add(F);
        }
        public Funcionario(){
            ListaFunc = new ArrayList();
        }
        public Funcionario(int codFuncionario, int senha, String usuario, String nome, String cpf){
            this.codFuncionario = codFuncionario;
            this.senha = senha;
            this.usuario = usuario;
            this.nome = nome;
            this.cpf = cpf;
            ListaFunc = new ArrayList();
        }

    public int getCodFuncionario() {
        return codFuncionario;
    }

    public void setCodFuncionario(int codFuncionario) {
        this.codFuncionario = codFuncionario;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public int getSenha() {
        return senha;
    }

    public void setSenha(int senha) {
        this.senha = senha;
    }

    public ArrayList<Funcionario> getListaFunc() {
        return ListaFunc;
    }

    public void setListaFunc(ArrayList<Funcionario> ListaFunc) {
        this.ListaFunc = ListaFunc;
    }
    
    
                   
}
