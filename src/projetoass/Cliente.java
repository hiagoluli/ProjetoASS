
package projetoass;
import java.util.ArrayList;

public final class Cliente extends Pessoa {
    protected int codCliente; 
    
    ArrayList<Cliente> ListaCliente;
    
    public void cadastrarCliente(Cliente C){
        ListaCliente.add(C);
    }
    
    public Cliente(){
        ListaCliente = new ArrayList();
    }
    
    public Cliente(int codCliente, String nome, String cpf){
            this.codCliente = codCliente;
            this.nome = nome;
            this.cpf = cpf;
            ListaCliente = new ArrayList();
        }

    public int getCodCliente() {
        return codCliente;
    }

    public void setCodCliente(int codCliente) {
        this.codCliente = codCliente;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setListaCliente(ArrayList<Cliente> ListaCliente) {
        this.ListaCliente = ListaCliente;
    }
    
    
    
}
