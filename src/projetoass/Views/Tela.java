/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetoass.Views;
import projetoass.Models.Funcionario;
import projetoass.Models.Fornecedores;
import projetoass.Models.Estoque;
import projetoass.Models.Cliente;
import projetoass.Models.Produto;
import projetoass.Models.Pedido;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author Hiago Notebook
 */
public class Tela extends javax.swing.JFrame {
    ArrayList<Funcionario> ListaFunc; //Cria uma Lista de Funcionarios
    ArrayList<Cliente> ListaCliente; //Cria uma Lista de Clientes
    ArrayList<Estoque> ListaProduto; //Cria uma Lista de Produtos
    ArrayList<Fornecedores> ListaFornecedor;
    ArrayList<Pedido> ListaPedidos;
    
    String modoFunc;//Variaveis para chamada da funnção "ManipularInterface"
    String modoCliente;
    String modoProdutos;
    String modoFornecedor;
    String modoPedido;
    
    //Tabela Funcionários
    public void loadTableFunc(){
        
        DefaultTableModel modelo = new DefaultTableModel(new Object[]{"Código","Nome","CPF","Usuario","Senha"},0);
        
        for(int i = 0; i<ListaFunc.size(); i++){
         Object linha[] = new Object[]{ListaFunc.get(i).getCodFuncionario(),
                                       ListaFunc.get(i).getNome(),
                                       ListaFunc.get(i).getCpf(),
                                       ListaFunc.get(i).getUsuario(),
                                       ListaFunc.get(i).getSenha()};
            modelo.addRow(linha);
        }
        
        
        tbl_funcionarios.setModel(modelo);
    }
    
    //Tabela Cliente
    public void loadTableCliente(){
        //Carrega a tabela cliente modelando as colunas da tabela
        DefaultTableModel modelo = new DefaultTableModel(new Object[]{"Código","Nome","CPF"},0);
        
        for(int i = 0; i<ListaCliente.size(); i++){
         Object linha[] = new Object[]{ListaCliente.get(i).getCodCliente(),
                                       ListaCliente.get(i).getNome(),
                                       ListaCliente.get(i).getCpf()};
                                       
            modelo.addRow(linha);
        }
        
        
        tbl_clientes.setModel(modelo);
    }
    
    public void loadTableProduto(){
        
        DefaultTableModel modelo = new DefaultTableModel(new Object[]{"Código de Barras","Nome","Preço","Tamanho","Cor","Quantidade"},0);
        
        for(int i = 0; i<ListaProduto.size(); i++){
         Object linha[] = new Object[]{ListaProduto.get(i).getCodBarras(),
                                       ListaProduto.get(i).getNome(),
                                       ListaProduto.get(i).getPreco(),
                                       ListaProduto.get(i).getTamanho(),
                                       ListaProduto.get(i).getCor(),
                                       ListaProduto.get(i).getQtde()};
   
            modelo.addRow(linha);
        }
        
        loadCbPedido();
        tbl_produto.setModel(modelo);
    }
    
    //Tabela Fornecedores
    public void loadTableFornecedores(){
        
        DefaultTableModel modelo = new DefaultTableModel(new Object[]{"Nome","Endereço","Telefone"},0);
        
        for(int i = 0; i<ListaFornecedor.size(); i++){
         Object linha[] = new Object[]{ListaFornecedor.get(i).getNome(),
                                       ListaFornecedor.get(i).getEndereco(),
                                       ListaFornecedor.get(i).getTelefone(),
                                       };
            modelo.addRow(linha);
        }
        
        loadCbProduto();
        tbl_fornecedor.setModel(modelo);
    }
    
    public void loadCbProduto(){
        
        cb_produto_fornecedor.removeAllItems();
        
        for(int i = 0; i<ListaFornecedor.size(); i++){
            cb_produto_fornecedor.addItem(ListaFornecedor.get(i).getNome());
            //addItem //espera uma string
        }
    }
    
    public void loadCbPedido(){
        
        cb_pedido_produto.removeAllItems();
        cb_pedido_produto2.removeAllItems();
        cb_pedido_produto2.removeAllItems();
        
        for(int i = 0; i<ListaProduto.size(); i++){
            cb_pedido_produto.addItem(ListaProduto.get(i).nome);
            //addItem //espera uma string
        }
        
        for(int i = 0; i<ListaProduto.size(); i++){
            cb_pedido_produto2.addItem(ListaProduto.get(i).cor);
            //addItem //espera uma string
        }
        
        for(int i = 0; i<ListaProduto.size(); i++){
            cb_pedido_produto3.addItem(ListaProduto.get(i).tamanho);
            //addItem //espera uma string
        }
    }
    
    
    public Tela() {
        initComponents();
        setLocationRelativeTo(null);
        ListaFunc = new ArrayList(); //Iniciar Lista Funcionario
        ListaCliente = new ArrayList(); //Iniciar Lista Cliente
        ListaProduto = new ArrayList(); //Iniciar Lista Produto
        ListaFornecedor = new ArrayList();
        modoFunc = "navegar";
        modoCliente = "navegar";
        modoProdutos = "navegar";
        modoFornecedor = "navegar";
        
        ManipulaInterfaceFunc();
        ManipulaInterfaceCliente();
        ManipulaInterfaceProduto();
        ManipulaInterfaceFornecedor();
    }
    //Bloqueia campos para evitar erros
    public void ManipulaInterfaceFunc(){
        switch(modoFunc){
            case "Navegar":
                btn_cad_func_adicionar.setEnabled(true);
                c_func_codigo.setEnabled(true);
                c_func_nome.setEnabled(true);
                c_func_cpf.setEnabled(true);
                c_func_usuario.setEnabled(true);
                c_func_senha.setEnabled(true);
                btn_func_novo.setEnabled(true);
                btn_func_editar.setEnabled(false);
                btn_func_excluir.setEnabled(false);
                break;
            case "Novo":
                btn_cad_func_adicionar.setEnabled(true);
                c_func_codigo.setEnabled(true);
                c_func_nome.setEnabled(true);
                c_func_cpf.setEnabled(true);
                c_func_usuario.setEnabled(true);
                c_func_senha.setEnabled(true);
                btn_func_novo.setEnabled(false);
                btn_func_editar.setEnabled(false);
                btn_func_excluir.setEnabled(false);
                break;
            case "Editar":
                btn_cad_func_adicionar.setEnabled(true);
                c_func_codigo.setEnabled(true);
                c_func_nome.setEnabled(true);
                c_func_cpf.setEnabled(true);
                c_func_usuario.setEnabled(true);
                c_func_senha.setEnabled(true);
                btn_func_novo.setEnabled(true);
                btn_func_editar.setEnabled(false);
                btn_func_excluir.setEnabled(false);
                break;
            case "Excluir":
                btn_cad_func_adicionar.setEnabled(false);
                c_func_codigo.setEnabled(true);
                c_func_nome.setEnabled(true);
                c_func_cpf.setEnabled(true);
                c_func_usuario.setEnabled(true);
                c_func_senha.setEnabled(true);
                btn_func_novo.setEnabled(true);
                btn_func_editar.setEnabled(false);
                btn_func_excluir.setEnabled(false);
                break;
            case "Selecao":
                btn_cad_func_adicionar.setEnabled(false);
                c_func_codigo.setEnabled(false);
                c_func_nome.setEnabled(false);
                c_func_cpf.setEnabled(false);
                c_func_usuario.setEnabled(false);
                c_func_senha.setEnabled(false);
                btn_func_novo.setEnabled(true);
                btn_func_editar.setEnabled(true);
                btn_func_excluir.setEnabled(true);
                break;
            default: System.out.println("Modo Invalido");
               
        }
    }
    
    public void ManipulaInterfaceCliente(){
        switch(modoCliente){
            case "Navegar":
                btn_cliente_adicionar.setEnabled(true);
                c_cliente_codigo.setEnabled(true);
                c_func_nome.setEnabled(true);
                c_func_cpf.setEnabled(true); 
                btn_cliente_novo.setEnabled(true);
                btn_cliente_editar.setEnabled(false);
                btn_cliente_excluir.setEnabled(false);
                break;
            case "Novo":
                btn_cliente_adicionar.setEnabled(true);
                c_cliente_codigo.setEnabled(true);
                c_cliente_nome.setEnabled(true);
                c_cliente_cpf.setEnabled(true);
                btn_cliente_novo.setEnabled(false);
                btn_cliente_editar.setEnabled(false);
                btn_cliente_excluir.setEnabled(false);
                break;
            case "Editar":
                btn_cliente_adicionar.setEnabled(true);
                c_cliente_codigo.setEnabled(true);
                c_cliente_nome.setEnabled(true);
                c_cliente_cpf.setEnabled(true);
                btn_cliente_novo.setEnabled(true);
                btn_cliente_editar.setEnabled(false);
                btn_cliente_excluir.setEnabled(false);
                break;
            case "Excluir":
                btn_cliente_adicionar.setEnabled(false);
                c_cliente_codigo.setEnabled(true);
                c_cliente_nome.setEnabled(true);
                c_cliente_cpf.setEnabled(true);
                btn_cliente_novo.setEnabled(true);
                btn_cliente_editar.setEnabled(false);
                btn_cliente_excluir.setEnabled(false);
                break;
            case "Selecao":
                btn_cliente_adicionar.setEnabled(false);
                c_cliente_codigo.setEnabled(false);
                c_cliente_nome.setEnabled(false);
                c_cliente_cpf.setEnabled(false);
                btn_cliente_novo.setEnabled(true);
                btn_cliente_editar.setEnabled(true);
                btn_cliente_excluir.setEnabled(true);
                break;
            default: System.out.println("Modo Invalido");
               
        }
    }
    
    public void ManipulaInterfaceProduto(){
        switch(modoProdutos){
            case "Navegar":
                btn_produto_adicionar.setEnabled(true);
                c_produto_codigo.setEnabled(true);
                c_produto_nome.setEnabled(true);
                c_produto_preco.setEnabled(true);
                c_produto_tamanho.setEnabled(true);
                c_produto_cor.setEnabled(true);
                c_produto_qtde.setEnabled(true);
                btn_produto_novo.setEnabled(true);
                btn_produto_editar.setEnabled(false);
                btn_produto_excluir.setEnabled(false);
                break;
            case "Novo":
                btn_produto_adicionar.setEnabled(true);
                c_produto_codigo.setEnabled(true);
                c_produto_nome.setEnabled(true);
                c_produto_preco.setEnabled(true);
                c_produto_tamanho.setEnabled(true);
                c_produto_cor.setEnabled(true);
                c_produto_qtde.setEnabled(true);
                btn_produto_novo.setEnabled(false);
                btn_produto_editar.setEnabled(false);
                btn_produto_excluir.setEnabled(false);
                break;
            case "Editar":
                btn_produto_adicionar.setEnabled(true);
                c_produto_codigo.setEnabled(true);
                c_produto_nome.setEnabled(true);
                c_produto_preco.setEnabled(true);
                c_produto_tamanho.setEnabled(true);
                c_produto_cor.setEnabled(true);
                c_produto_qtde.setEnabled(true);
                btn_produto_novo.setEnabled(true);
                btn_produto_editar.setEnabled(false);
                btn_produto_excluir.setEnabled(false);
                break;
            case "Excluir":
                btn_produto_adicionar.setEnabled(false);
                c_produto_codigo.setEnabled(true);
                c_produto_nome.setEnabled(true);
                c_produto_preco.setEnabled(true);
                c_produto_tamanho.setEnabled(true);
                c_produto_cor.setEnabled(true);
                c_produto_qtde.setEnabled(true);
                btn_produto_novo.setEnabled(true);
                btn_produto_editar.setEnabled(false);
                btn_produto_excluir.setEnabled(false);
                break;
            case "Selecao":
                btn_produto_adicionar.setEnabled(false);
                c_produto_codigo.setEnabled(false);
                c_produto_nome.setEnabled(false);
                c_produto_preco.setEnabled(false);
                c_produto_tamanho.setEnabled(false);
                c_produto_cor.setEnabled(false);
                c_produto_qtde.setEnabled(true);
                btn_produto_novo.setEnabled(true);
                btn_produto_editar.setEnabled(true);
                btn_produto_excluir.setEnabled(true);
                break;
            default: System.out.println("Modo Invalido");
               
        }
    }
    
    //Bloqueia campos para evitar erros
    public void ManipulaInterfaceFornecedor(){
        switch(modoFornecedor){
            case "Navegar":
                btn_fornecedores_adicionar.setEnabled(true);
              
                c_fornecedor_nome.setEnabled(true);
                c_fornecedores_endereco.setEnabled(true);
                c_fornecedores_telefone.setEnabled(true);
               
                btn_fornecedor_novo.setEnabled(true);
                btn_fornecedor_editar.setEnabled(false);
                btn_fornecedor_excluir.setEnabled(false);
                break;
            case "Novo":
                btn_fornecedores_adicionar.setEnabled(true);
              
                c_fornecedor_nome.setEnabled(true);
                c_fornecedores_endereco.setEnabled(true);
                c_fornecedores_telefone.setEnabled(true);
                
                btn_fornecedor_novo.setEnabled(false);
                btn_fornecedor_editar.setEnabled(false);
                btn_fornecedor_excluir.setEnabled(false);
                break;
            case "Editar":
                btn_fornecedores_adicionar.setEnabled(true);
              
                c_fornecedor_nome.setEnabled(true);
                c_fornecedores_endereco.setEnabled(true);
                c_fornecedores_telefone.setEnabled(true);
                
                btn_fornecedor_novo.setEnabled(true);
                btn_fornecedor_editar.setEnabled(false);
                btn_fornecedor_excluir.setEnabled(false);
                break;
            case "Excluir":
                btn_fornecedores_adicionar.setEnabled(true);
              
                c_fornecedor_nome.setEnabled(true);
                c_fornecedores_endereco.setEnabled(true);
                c_fornecedores_telefone.setEnabled(true);
                
                btn_fornecedor_novo.setEnabled(true);
                btn_fornecedor_editar.setEnabled(false);
                btn_fornecedor_excluir.setEnabled(false);
                break;
            case "Selecao":
                btn_fornecedores_adicionar.setEnabled(true);
              
                c_fornecedor_nome.setEnabled(true);
                c_fornecedores_endereco.setEnabled(true);
                c_fornecedores_telefone.setEnabled(true);
                
                btn_fornecedor_novo.setEnabled(true);
                btn_fornecedor_editar.setEnabled(true);
                btn_fornecedor_excluir.setEnabled(true);
                break;
            default: System.out.println("Modo Invalido");
               
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tbl_cad_clientes = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        c_clientes_codigo = new javax.swing.JTextField();
        c_clientes_nome = new javax.swing.JTextField();
        c_cliente_cpf = new javax.swing.JTextField();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_funcionarios = new javax.swing.JTable();
        tbl_cad_funcionarios = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        c_func_codigo = new javax.swing.JTextField();
        c_func_nome = new javax.swing.JTextField();
        c_func_cpf = new javax.swing.JTextField();
        c_func_usuario = new javax.swing.JTextField();
        c_func_senha = new javax.swing.JTextField();
        btn_cad_func_adicionar = new javax.swing.JButton();
        btn_func_novo = new javax.swing.JButton();
        btn_func_editar = new javax.swing.JButton();
        btn_func_excluir = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_clientes = new javax.swing.JTable();
        btn_cliente_novo = new javax.swing.JButton();
        btn_cliente_editar = new javax.swing.JButton();
        btn_cliente_excluir = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        c_cliente_codigo = new javax.swing.JTextField();
        c_cliente_nome = new javax.swing.JTextField();
        c_cliente_cpf1 = new javax.swing.JTextField();
        btn_cliente_adicionar = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbl_produto = new javax.swing.JTable();
        jLabel12 = new javax.swing.JLabel();
        c_produto_codigo = new javax.swing.JTextField();
        c_produto_nome = new javax.swing.JTextField();
        btn_produto_novo = new javax.swing.JButton();
        c_produto_preco = new javax.swing.JTextField();
        btn_produto_editar = new javax.swing.JButton();
        btn_produto_excluir = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        c_produto_tamanho = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        c_produto_cor = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        c_produto_qtde = new javax.swing.JTextField();
        btn_produto_adicionar = new javax.swing.JButton();
        jLabel18 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        cb_produto_fornecedor = new javax.swing.JComboBox<>();
        jPanel4 = new javax.swing.JPanel();
        c_fornecedores_telefone = new javax.swing.JTextField();
        btn_fornecedor_editar = new javax.swing.JButton();
        btn_fornecedor_excluir = new javax.swing.JButton();
        jLabel19 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tbl_fornecedor = new javax.swing.JTable();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        c_fornecedores_endereco = new javax.swing.JTextField();
        c_fornecedor_nome = new javax.swing.JTextField();
        btn_fornecedor_novo = new javax.swing.JButton();
        jLabel22 = new javax.swing.JLabel();
        btn_fornecedores_adicionar = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        tbl_funcionarios1 = new javax.swing.JTable();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        cb_pedido_produto3 = new javax.swing.JComboBox<>();
        cb_pedido_produto = new javax.swing.JComboBox<>();
        cb_pedido_produto2 = new javax.swing.JComboBox<>();
        c_produto_qtde1 = new javax.swing.JTextField();
        btn_pedido_adicionar = new javax.swing.JButton();
        btn_clientes_novo = new javax.swing.JButton();

        jLabel6.setText("Codigo:");

        jLabel7.setText("Nome:");

        jLabel8.setText("C.P.F.:");

        javax.swing.GroupLayout tbl_cad_clientesLayout = new javax.swing.GroupLayout(tbl_cad_clientes);
        tbl_cad_clientes.setLayout(tbl_cad_clientesLayout);
        tbl_cad_clientesLayout.setHorizontalGroup(
            tbl_cad_clientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tbl_cad_clientesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(tbl_cad_clientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(tbl_cad_clientesLayout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(c_clientes_codigo, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(tbl_cad_clientesLayout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(c_cliente_cpf, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(tbl_cad_clientesLayout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(c_clientes_nome, javax.swing.GroupLayout.PREFERRED_SIZE, 313, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(25, Short.MAX_VALUE))
        );
        tbl_cad_clientesLayout.setVerticalGroup(
            tbl_cad_clientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tbl_cad_clientesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(tbl_cad_clientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(c_clientes_codigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(tbl_cad_clientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(c_clientes_nome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(tbl_cad_clientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(c_cliente_cpf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(32, Short.MAX_VALUE))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tbl_funcionarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo", "Nome", "C.P.F.", "Usuario", "Senha"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbl_funcionarios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_funcionariosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_funcionarios);
        if (tbl_funcionarios.getColumnModel().getColumnCount() > 0) {
            tbl_funcionarios.getColumnModel().getColumn(0).setPreferredWidth(250);
            tbl_funcionarios.getColumnModel().getColumn(1).setPreferredWidth(20);
            tbl_funcionarios.getColumnModel().getColumn(2).setPreferredWidth(20);
            tbl_funcionarios.getColumnModel().getColumn(3).setPreferredWidth(60);
            tbl_funcionarios.getColumnModel().getColumn(4).setPreferredWidth(40);
        }

        jLabel1.setText("Codigo:");

        jLabel2.setText("Nome:");

        jLabel3.setText("C.P.F.:");

        jLabel4.setText("Usuario:");

        jLabel5.setText("Senha:");

        c_func_usuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                c_func_usuarioActionPerformed(evt);
            }
        });

        btn_cad_func_adicionar.setText("Adicionar");
        btn_cad_func_adicionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cad_func_adicionarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout tbl_cad_funcionariosLayout = new javax.swing.GroupLayout(tbl_cad_funcionarios);
        tbl_cad_funcionarios.setLayout(tbl_cad_funcionariosLayout);
        tbl_cad_funcionariosLayout.setHorizontalGroup(
            tbl_cad_funcionariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tbl_cad_funcionariosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(tbl_cad_funcionariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(tbl_cad_funcionariosLayout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(c_func_codigo, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(tbl_cad_funcionariosLayout.createSequentialGroup()
                        .addGroup(tbl_cad_funcionariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(tbl_cad_funcionariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(c_func_cpf, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(c_func_usuario, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(tbl_cad_funcionariosLayout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(c_func_nome, javax.swing.GroupLayout.PREFERRED_SIZE, 313, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(tbl_cad_funcionariosLayout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(tbl_cad_funcionariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btn_cad_func_adicionar)
                            .addComponent(c_func_senha, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        tbl_cad_funcionariosLayout.setVerticalGroup(
            tbl_cad_funcionariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tbl_cad_funcionariosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(tbl_cad_funcionariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(c_func_codigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(tbl_cad_funcionariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2)
                    .addComponent(c_func_nome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(tbl_cad_funcionariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(c_func_cpf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(tbl_cad_funcionariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(c_func_usuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(tbl_cad_funcionariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(c_func_senha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btn_cad_func_adicionar)
                .addContainerGap(89, Short.MAX_VALUE))
        );

        btn_func_novo.setText("Novo");
        btn_func_novo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_func_novoActionPerformed(evt);
            }
        });

        btn_func_editar.setText("Editar");
        btn_func_editar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_func_editarActionPerformed(evt);
            }
        });

        btn_func_excluir.setText("Excluir");
        btn_func_excluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_func_excluirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tbl_cad_funcionarios, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btn_func_novo)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btn_func_editar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btn_func_excluir)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 576, Short.MAX_VALUE))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_func_novo)
                    .addComponent(btn_func_editar)
                    .addComponent(btn_func_excluir))
                .addGap(3, 3, 3)
                .addComponent(tbl_cad_funcionarios, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Funcionarios", jPanel1);

        tbl_clientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo", "Nome", "C.P.F."
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbl_clientes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_clientesMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tbl_clientes);
        if (tbl_clientes.getColumnModel().getColumnCount() > 0) {
            tbl_clientes.getColumnModel().getColumn(0).setPreferredWidth(75);
            tbl_clientes.getColumnModel().getColumn(1).setPreferredWidth(200);
            tbl_clientes.getColumnModel().getColumn(2).setPreferredWidth(100);
        }

        btn_cliente_novo.setText("Novo");
        btn_cliente_novo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cliente_novoActionPerformed(evt);
            }
        });

        btn_cliente_editar.setText("Editar");
        btn_cliente_editar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cliente_editarActionPerformed(evt);
            }
        });

        btn_cliente_excluir.setText("Excluir");
        btn_cliente_excluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cliente_excluirActionPerformed(evt);
            }
        });

        jLabel9.setText("Codigo:");

        jLabel10.setText("Nome:");

        jLabel11.setText("C.P.F.:");

        btn_cliente_adicionar.setText("Adicionar");
        btn_cliente_adicionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cliente_adicionarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 576, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addComponent(btn_cliente_novo)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(btn_cliente_editar)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(btn_cliente_excluir))
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addComponent(jLabel9)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(c_cliente_codigo, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel11)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(c_cliente_cpf1, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel10)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(c_cliente_nome, javax.swing.GroupLayout.PREFERRED_SIZE, 313, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(btn_cliente_adicionar))))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_cliente_novo)
                    .addComponent(btn_cliente_editar)
                    .addComponent(btn_cliente_excluir))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(c_cliente_codigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(c_cliente_nome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(c_cliente_cpf1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btn_cliente_adicionar)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Clientes", jPanel2);

        tbl_produto.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo", "Nome", "Tamanho", "Cor", "Preço", "Quantidade"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.Double.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbl_produto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_produtoMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tbl_produto);
        if (tbl_produto.getColumnModel().getColumnCount() > 0) {
            tbl_produto.getColumnModel().getColumn(0).setPreferredWidth(75);
            tbl_produto.getColumnModel().getColumn(1).setPreferredWidth(200);
            tbl_produto.getColumnModel().getColumn(2).setPreferredWidth(100);
        }

        jLabel12.setText("Tamanho:");

        btn_produto_novo.setText("Novo");
        btn_produto_novo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_produto_novoActionPerformed(evt);
            }
        });

        btn_produto_editar.setText("Editar");
        btn_produto_editar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_produto_editarActionPerformed(evt);
            }
        });

        btn_produto_excluir.setText("Excluir");
        btn_produto_excluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_produto_excluirActionPerformed(evt);
            }
        });

        jLabel13.setText("Codigo:");

        jLabel14.setText("Nome:");

        jLabel15.setText("Preço:");

        jLabel16.setText("Cor:");

        jLabel17.setText("Quantidade:");

        btn_produto_adicionar.setText("Adicionar");
        btn_produto_adicionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_produto_adicionarActionPerformed(evt);
            }
        });

        jLabel18.setText("*Usar ponto para separar centavos");

        jLabel23.setText("Fornecedor:");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 576, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(btn_produto_novo)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btn_produto_editar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btn_produto_excluir))
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(jPanel3Layout.createSequentialGroup()
                                    .addComponent(jLabel18)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 136, Short.MAX_VALUE)
                                    .addComponent(btn_produto_adicionar))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                                    .addComponent(jLabel13)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(c_produto_codigo, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(26, 26, 26)
                                    .addComponent(jLabel23)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(cb_produto_fornecedor, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                                    .addComponent(jLabel14)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(c_produto_nome, javax.swing.GroupLayout.PREFERRED_SIZE, 313, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(jPanel3Layout.createSequentialGroup()
                                            .addComponent(jLabel12)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(c_produto_tamanho, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanel3Layout.createSequentialGroup()
                                            .addComponent(jLabel15)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(c_produto_preco)))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel3Layout.createSequentialGroup()
                                            .addComponent(jLabel16)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(c_produto_cor, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanel3Layout.createSequentialGroup()
                                            .addComponent(jLabel17)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(c_produto_qtde, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_produto_novo)
                    .addComponent(btn_produto_editar)
                    .addComponent(btn_produto_excluir))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(c_produto_codigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel23)
                    .addComponent(cb_produto_fornecedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(c_produto_nome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(c_produto_tamanho, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16)
                    .addComponent(c_produto_cor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(c_produto_qtde, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15)
                    .addComponent(c_produto_preco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_produto_adicionar)
                    .addComponent(jLabel18))
                .addContainerGap(144, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Produto", jPanel3);

        btn_fornecedor_editar.setText("Editar");
        btn_fornecedor_editar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_fornecedor_editarActionPerformed(evt);
            }
        });

        btn_fornecedor_excluir.setText("Excluir");
        btn_fornecedor_excluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_fornecedor_excluirActionPerformed(evt);
            }
        });

        jLabel19.setText("Nome:");

        tbl_fornecedor.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nome", "Endereço", "Telefone"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbl_fornecedor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_fornecedorMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(tbl_fornecedor);
        if (tbl_fornecedor.getColumnModel().getColumnCount() > 0) {
            tbl_fornecedor.getColumnModel().getColumn(0).setPreferredWidth(75);
            tbl_fornecedor.getColumnModel().getColumn(1).setPreferredWidth(200);
            tbl_fornecedor.getColumnModel().getColumn(2).setPreferredWidth(100);
        }

        jLabel20.setText("Telefone:");

        jLabel21.setText("Endereço:");

        btn_fornecedor_novo.setText("Novo");
        btn_fornecedor_novo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_fornecedor_novoActionPerformed(evt);
            }
        });

        jLabel22.setText("Telefone:");

        btn_fornecedores_adicionar.setText("Adicionar");
        btn_fornecedores_adicionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_fornecedores_adicionarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(jLabel19)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(c_fornecedor_nome, javax.swing.GroupLayout.PREFERRED_SIZE, 313, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 576, Short.MAX_VALUE)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addComponent(btn_fornecedor_novo)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(btn_fornecedor_editar)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(btn_fornecedor_excluir))
                                    .addComponent(jLabel20)
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addGap(6, 6, 6)
                                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel4Layout.createSequentialGroup()
                                                .addComponent(jLabel21)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(c_fornecedores_endereco, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(jPanel4Layout.createSequentialGroup()
                                                .addComponent(jLabel22)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(btn_fornecedores_adicionar)
                                                    .addComponent(c_fornecedores_telefone, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btn_fornecedor_novo)
                            .addComponent(btn_fornecedor_editar)
                            .addComponent(btn_fornecedor_excluir)))
                    .addComponent(jLabel20))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(c_fornecedor_nome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel19))
                .addGap(12, 12, 12)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel21)
                    .addComponent(c_fornecedores_endereco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel22)
                    .addComponent(c_fornecedores_telefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addComponent(btn_fornecedores_adicionar)
                .addContainerGap(132, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Fornecedores", jPanel4);

        tbl_funcionarios1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Produto", "Qtde.", "Tamanho", "Cor", "Total"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Double.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbl_funcionarios1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_funcionarios1MouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(tbl_funcionarios1);
        if (tbl_funcionarios1.getColumnModel().getColumnCount() > 0) {
            tbl_funcionarios1.getColumnModel().getColumn(0).setPreferredWidth(250);
            tbl_funcionarios1.getColumnModel().getColumn(1).setPreferredWidth(20);
            tbl_funcionarios1.getColumnModel().getColumn(2).setPreferredWidth(20);
            tbl_funcionarios1.getColumnModel().getColumn(3).setPreferredWidth(60);
            tbl_funcionarios1.getColumnModel().getColumn(4).setPreferredWidth(40);
        }

        jLabel24.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel24.setText("Produto:");

        jLabel25.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel25.setText("Quantidade:");

        jLabel26.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel26.setText("Tamanho:");

        jLabel27.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel27.setText("Cor:");

        cb_pedido_produto3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_pedido_produto3ActionPerformed(evt);
            }
        });

        cb_pedido_produto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_pedido_produtoActionPerformed(evt);
            }
        });

        cb_pedido_produto2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_pedido_produto2ActionPerformed(evt);
            }
        });

        btn_pedido_adicionar.setText("Adicionar");
        btn_pedido_adicionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_pedido_adicionarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 576, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel27)
                    .addComponent(jLabel26)
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel25)
                        .addComponent(jLabel24, javax.swing.GroupLayout.Alignment.TRAILING)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(btn_pedido_adicionar)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(cb_pedido_produto, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addComponent(cb_pedido_produto2, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(312, 312, 312))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(c_produto_qtde1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cb_pedido_produto3, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel24)
                    .addComponent(cb_pedido_produto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel25)
                    .addComponent(c_produto_qtde1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel26)
                    .addComponent(cb_pedido_produto3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel27)
                    .addComponent(cb_pedido_produto2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btn_pedido_adicionar)
                .addContainerGap(150, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Pedidos", jPanel5);

        btn_clientes_novo.setText("Novo");
        btn_clientes_novo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_clientes_novoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jTabbedPane1)
                .addGap(19, 19, 19))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(17, 17, 17)
                    .addComponent(btn_clientes_novo)
                    .addContainerGap(566, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1)
                .addContainerGap())
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(145, 145, 145)
                    .addComponent(btn_clientes_novo)
                    .addGap(185, 185, 185)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void c_func_usuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_c_func_usuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_c_func_usuarioActionPerformed

    private void btn_func_novoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_func_novoActionPerformed
        //botão "Novo" da tabela "Cliente"
        c_func_codigo.setText("");
        c_func_nome.setText("");
        c_func_cpf.setText("");
        c_func_usuario.setText("");
        c_func_senha.setText("");
        
        btn_cad_func_adicionar.setEnabled(true);
        c_func_codigo.setEnabled(true);
        c_func_nome.setEnabled(true);
        c_func_cpf.setEnabled(true);
        c_func_usuario.setEnabled(true);
        c_func_senha.setEnabled(true);
        
        modoFunc = "Novo";
        ManipulaInterfaceFunc();
        
    }//GEN-LAST:event_btn_func_novoActionPerformed

    private void btn_cad_func_adicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cad_func_adicionarActionPerformed
        int cod = Integer.parseInt(c_func_codigo.getText());
        int sen = Integer.parseInt(c_func_senha.getText());
            
        if(modoFunc.equals("Novo")){
            
            Funcionario F = new Funcionario(cod, sen, c_func_usuario.getText(),c_func_nome.getText(),c_func_cpf.getText());
            ListaFunc.add(F);
        }else if(modoFunc.equals("Editar")){
            int index = tbl_funcionarios.getSelectedRow();
            ListaFunc.get(index).setCodFuncionario(cod);
            ListaFunc.get(index).setSenha(sen);
            ListaFunc.get(index).setUsuario(c_func_usuario.getText());
            ListaFunc.get(index).setNome(c_func_nome.getText());
            ListaFunc.get(index).setCpf(c_func_cpf.getText());
        }
        
        
        loadTableFunc();
        modoFunc = "Navegar";
        ManipulaInterfaceFunc();
        c_func_codigo.setText("");
        c_func_nome.setText("");
        c_func_cpf.setText("");
        c_func_usuario.setText("");
        c_func_senha.setText("");
    }//GEN-LAST:event_btn_cad_func_adicionarActionPerformed

    private void tbl_funcionariosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_funcionariosMouseClicked
        //Seleciona a linha da tabela selecionada
        int index = tbl_funcionarios.getSelectedRow();
        
        if(index>=0 && index<ListaFunc.size()){
            Funcionario F = ListaFunc.get(index);
            c_func_codigo.setText(String.valueOf(F.getCodFuncionario()));
            c_func_nome.setText(F.getNome());
            c_func_cpf.setText(F.getCpf());
            c_func_usuario.setText(F.getUsuario());
            c_func_senha.setText(String.valueOf(F.getSenha()));
            modoFunc = "Selecao";
            ManipulaInterfaceFunc();
        }
        
    }//GEN-LAST:event_tbl_funcionariosMouseClicked

    private void btn_func_editarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_func_editarActionPerformed
        modoFunc = "Editar";
        ManipulaInterfaceFunc();
    }//GEN-LAST:event_btn_func_editarActionPerformed

    private void btn_func_excluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_func_excluirActionPerformed
        int index = tbl_funcionarios.getSelectedRow();
        
        if(index>=0 && index<ListaFunc.size()){
            ListaFunc.remove(index);
        }
        loadTableFunc();
        modoFunc = "Navegar";
        ManipulaInterfaceFunc();
    }//GEN-LAST:event_btn_func_excluirActionPerformed

    private void tbl_clientesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_clientesMouseClicked
        int index = tbl_clientes.getSelectedRow();
        
        if(index>=0 && index<ListaCliente.size()){
            Cliente C = ListaCliente.get(index);
            c_cliente_codigo.setText(String.valueOf(C.getCodCliente()));
            c_cliente_nome.setText(C.getNome());
            c_cliente_cpf.setText(C.getCpf());
            
            modoCliente = "Selecao";
            ManipulaInterfaceCliente();
        }
    }//GEN-LAST:event_tbl_clientesMouseClicked

    private void btn_clientes_novoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_clientes_novoActionPerformed
        //Verificar se Existe
    }//GEN-LAST:event_btn_clientes_novoActionPerformed

    private void btn_cliente_novoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cliente_novoActionPerformed
        c_cliente_codigo.setText("");
        c_cliente_nome.setText("");
        c_cliente_cpf.setText("");
   
        btn_cliente_adicionar.setEnabled(true);
        c_cliente_codigo.setEnabled(true);
        c_cliente_nome.setEnabled(true);
        c_cliente_cpf.setEnabled(true);
        
        modoCliente = "Novo";
        ManipulaInterfaceCliente();
    }//GEN-LAST:event_btn_cliente_novoActionPerformed

    private void btn_cliente_editarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cliente_editarActionPerformed
        modoCliente = "Editar";
        ManipulaInterfaceCliente();
    }//GEN-LAST:event_btn_cliente_editarActionPerformed

    private void btn_cliente_excluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cliente_excluirActionPerformed
        int index = tbl_clientes.getSelectedRow();
        
        if(index>=0 && index<ListaCliente.size()){
            ListaCliente.remove(index);
        }
        loadTableCliente();
        modoCliente = "Navegar";
        ManipulaInterfaceCliente();
    }//GEN-LAST:event_btn_cliente_excluirActionPerformed

    private void tbl_produtoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_produtoMouseClicked
        int index = tbl_produto.getSelectedRow();
        
        if(index>=0 && index<ListaProduto.size()){
            Estoque P = ListaProduto.get(index);
            c_produto_codigo.setText(String.valueOf(P.getCodBarras()));
            c_produto_tamanho.setText(String.valueOf(P.getTamanho()));
            c_produto_preco.setText(String.valueOf(P.getPreco()));
            c_produto_qtde.setText(String.valueOf(P.getQtde()));
            c_produto_nome.setText(P.getNome());
            c_produto_cor.setText(P.getCor());
            
            modoProdutos = "Selecao";
            ManipulaInterfaceProduto();
        }
    }//GEN-LAST:event_tbl_produtoMouseClicked

    private void btn_produto_novoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_produto_novoActionPerformed
        //botão "Novo" da tabela "Produto"
        c_produto_codigo.setText("");
        c_produto_nome.setText("");
        c_produto_preco.setText("");
        c_produto_tamanho.setText("");
        c_produto_cor.setText("");
        c_produto_qtde.setText("");
        
        btn_produto_adicionar.setEnabled(true);
        c_produto_codigo.setEnabled(true);
        c_produto_nome.setEnabled(true);
        c_produto_preco.setEnabled(true);
        c_produto_tamanho.setEnabled(true);
        c_produto_cor.setEnabled(true);
        c_produto_qtde.setEnabled(true);
        modoProdutos = "Novo";
        ManipulaInterfaceProduto();
    }//GEN-LAST:event_btn_produto_novoActionPerformed

    private void btn_produto_editarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_produto_editarActionPerformed
        modoProdutos = "Editar";
        ManipulaInterfaceProduto();
    }//GEN-LAST:event_btn_produto_editarActionPerformed

    private void btn_produto_excluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_produto_excluirActionPerformed
        int index = tbl_produto.getSelectedRow();
        
        if(index>=0 && index<ListaProduto.size()){
            ListaProduto.remove(index);
        }
        loadTableProduto();
        modoProdutos = "Navegar";
        ManipulaInterfaceProduto();
    }//GEN-LAST:event_btn_produto_excluirActionPerformed

    private void btn_cliente_adicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cliente_adicionarActionPerformed
        int codCliente = Integer.parseInt(c_cliente_codigo.getText()); //Integer.parseInt // Converte o texto recebido para int
        
        if(modoCliente.equals("Novo")){
            
            Cliente C = new Cliente(codCliente, c_cliente_nome.getText(),c_cliente_cpf.getText());
            ListaCliente.add(C);
        }else if(modoCliente.equals("Editar")){
            int index = tbl_clientes.getSelectedRow();
            ListaCliente.get(index).setCodCliente(codCliente);
            ListaCliente.get(index).setNome(c_cliente_nome.getText());
            ListaCliente.get(index).setCpf(c_cliente_cpf.getText());
        }
        
        
        loadTableCliente();
        modoCliente = "Navegar";
        ManipulaInterfaceCliente();
        c_cliente_codigo.setText(""); //Carrega a tabela com os campos zerados
        c_cliente_nome.setText(""); //Carrega a tabela com os campos zerados
        c_cliente_cpf.setText(""); //Carrega a tabela com os campos zerados

    }//GEN-LAST:event_btn_cliente_adicionarActionPerformed

    private void btn_produto_adicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_produto_adicionarActionPerformed
        int codBarras = Integer.parseInt(c_produto_codigo.getText()); //Integer.parseInt // Converte o texto recebido para int
        String tamanho = c_produto_tamanho.getText();
        double preco = Double.parseDouble(c_produto_preco.getText()); //Double.parseDouble // Converte o texto recebido para double
        int qtde = Integer.parseInt(c_produto_qtde.getText());
        if(modoProdutos.equals("Novo")){
            
            Estoque P = new Estoque(codBarras, c_produto_nome.getText(),preco, tamanho, c_produto_cor.getText(), qtde);
            ListaProduto.add(P);
        }else if(modoProdutos.equals("Editar")){
            int index = tbl_produto.getSelectedRow();
            ListaProduto.get(index).setCodBarras(codBarras);
            ListaProduto.get(index).setNome(c_produto_nome.getText());
            ListaProduto.get(index).setTamanho(tamanho);
            ListaProduto.get(index).setPreco(preco);
            ListaProduto.get(index).setQtde(qtde);
            ListaProduto.get(index).setCor(c_produto_cor.getText());
        }
        
        
        loadTableProduto();
        modoProdutos = "Navegar";
        ManipulaInterfaceProduto();
        c_produto_codigo.setText(""); //Carrega a tabela com os campos zerados
        c_produto_nome.setText(""); //Carrega a tabela com os campos zerados
        c_produto_tamanho.setText(""); //Carrega a tabela com os campos zerados
        c_produto_preco.setText("");
        c_produto_cor.setText("");
        c_produto_qtde.setText("");
    }//GEN-LAST:event_btn_produto_adicionarActionPerformed

    
    private void btn_fornecedores_adicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_fornecedores_adicionarActionPerformed

        if(modoFornecedor.equals("Novo")){

            Fornecedores Fn = new Fornecedores(c_fornecedor_nome.getText(),
                c_fornecedores_endereco.getText(),
                c_fornecedores_telefone.getText());
            ListaFornecedor.add(Fn);
        }else if(modoFornecedor.equals("Editar")){
            int index = tbl_fornecedor.getSelectedRow();
            ListaFornecedor.get(index).setNome(c_fornecedor_nome.getText());
            ListaFornecedor.get(index).setEndereco(c_fornecedores_endereco.getText());
            ListaFornecedor.get(index).setTelefone(c_fornecedores_telefone.getText());
        }

        loadTableFornecedores();
        modoFornecedor = "Navegar";
        ManipulaInterfaceCliente();
        c_fornecedor_nome.setText(""); //Carrega a tabela com os campos zerados
        c_fornecedores_endereco.setText(""); //Carrega a tabela com os campos zerados
        c_fornecedores_telefone.setText(""); //Carrega a tabela com os campos zerados
    }//GEN-LAST:event_btn_fornecedores_adicionarActionPerformed

    private void btn_fornecedor_novoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_fornecedor_novoActionPerformed
        //botão "Novo" da tabela "Fornecedor"
        c_fornecedor_nome.setText("");
        c_fornecedores_endereco.setText("");
        c_fornecedores_telefone.setText("");

        btn_fornecedores_adicionar.setEnabled(true);
        c_fornecedores_endereco.setEnabled(true);
        c_fornecedores_telefone.setEnabled(true);

        modoFornecedor = "Novo";
        ManipulaInterfaceFornecedor();
    }//GEN-LAST:event_btn_fornecedor_novoActionPerformed

    private void tbl_fornecedorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_fornecedorMouseClicked
        int index = tbl_fornecedor.getSelectedRow();

        if(index>=0 && index<ListaFornecedor.size()){
            Fornecedores Fn = ListaFornecedor.get(index);
            c_fornecedor_nome.setText(Fn.getNome());
            c_fornecedores_endereco.setText(Fn.getEndereco());
            c_fornecedores_telefone.setText(Fn.getTelefone());

            modoFornecedor = "Selecao";
            ManipulaInterfaceFornecedor();
        }
    }//GEN-LAST:event_tbl_fornecedorMouseClicked

    private void btn_fornecedor_excluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_fornecedor_excluirActionPerformed
        int index = tbl_fornecedor.getSelectedRow();

        if(index>=0 && index<ListaFornecedor.size()){
            ListaFornecedor.remove(index);
        }
        loadTableFornecedores();
        modoFornecedor = "Navegar";
        ManipulaInterfaceFornecedor();
    }//GEN-LAST:event_btn_fornecedor_excluirActionPerformed

    private void btn_fornecedor_editarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_fornecedor_editarActionPerformed
        modoFornecedor = "Editar";
        ManipulaInterfaceFornecedor();
    }//GEN-LAST:event_btn_fornecedor_editarActionPerformed

    private void tbl_funcionarios1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_funcionarios1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tbl_funcionarios1MouseClicked

    private void cb_pedido_produto3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_pedido_produto3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cb_pedido_produto3ActionPerformed

    private void cb_pedido_produtoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_pedido_produtoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cb_pedido_produtoActionPerformed

    private void cb_pedido_produto2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_pedido_produto2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cb_pedido_produto2ActionPerformed

    private void btn_pedido_adicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_pedido_adicionarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_pedido_adicionarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Tela.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Tela.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Tela.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Tela.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Tela().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_cad_func_adicionar;
    private javax.swing.JButton btn_cliente_adicionar;
    private javax.swing.JButton btn_cliente_editar;
    private javax.swing.JButton btn_cliente_excluir;
    private javax.swing.JButton btn_cliente_novo;
    private javax.swing.JButton btn_clientes_novo;
    private javax.swing.JButton btn_fornecedor_editar;
    private javax.swing.JButton btn_fornecedor_excluir;
    private javax.swing.JButton btn_fornecedor_novo;
    private javax.swing.JButton btn_fornecedores_adicionar;
    private javax.swing.JButton btn_func_editar;
    private javax.swing.JButton btn_func_excluir;
    private javax.swing.JButton btn_func_novo;
    private javax.swing.JButton btn_pedido_adicionar;
    private javax.swing.JButton btn_produto_adicionar;
    private javax.swing.JButton btn_produto_editar;
    private javax.swing.JButton btn_produto_excluir;
    private javax.swing.JButton btn_produto_novo;
    private javax.swing.JTextField c_cliente_codigo;
    private javax.swing.JTextField c_cliente_cpf;
    private javax.swing.JTextField c_cliente_cpf1;
    private javax.swing.JTextField c_cliente_nome;
    private javax.swing.JTextField c_clientes_codigo;
    private javax.swing.JTextField c_clientes_nome;
    private javax.swing.JTextField c_fornecedor_nome;
    private javax.swing.JTextField c_fornecedores_endereco;
    private javax.swing.JTextField c_fornecedores_telefone;
    private javax.swing.JTextField c_func_codigo;
    private javax.swing.JTextField c_func_cpf;
    private javax.swing.JTextField c_func_nome;
    private javax.swing.JTextField c_func_senha;
    private javax.swing.JTextField c_func_usuario;
    private javax.swing.JTextField c_produto_codigo;
    private javax.swing.JTextField c_produto_cor;
    private javax.swing.JTextField c_produto_nome;
    private javax.swing.JTextField c_produto_preco;
    private javax.swing.JTextField c_produto_qtde;
    private javax.swing.JTextField c_produto_qtde1;
    private javax.swing.JTextField c_produto_tamanho;
    private javax.swing.JComboBox<String> cb_pedido_produto;
    private javax.swing.JComboBox<String> cb_pedido_produto2;
    private javax.swing.JComboBox<String> cb_pedido_produto3;
    private javax.swing.JComboBox<String> cb_produto_fornecedor;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JPanel tbl_cad_clientes;
    private javax.swing.JPanel tbl_cad_funcionarios;
    private javax.swing.JTable tbl_clientes;
    private javax.swing.JTable tbl_fornecedor;
    private javax.swing.JTable tbl_funcionarios;
    private javax.swing.JTable tbl_funcionarios1;
    private javax.swing.JTable tbl_produto;
    // End of variables declaration//GEN-END:variables
}
