package visao;

import javax.swing.*;
import controle.ProdutoController;
import modelo.Produto;
import java.awt.*;
import modelo.PlaceholderTextField;

public class CadastrarProdutoView extends JFrame {

    private static final long serialVersionUID = 1L;

    // ALTERADO: Mudança do tipo de JTextField para PlaceholderTextField
    private PlaceholderTextField txtId;
    private PlaceholderTextField txtNome;
    private PlaceholderTextField txtQuantidade;
    private PlaceholderTextField txtValorUnitario;
    
    private JButton btnSalvar;
    private ProdutoController produtoController = new ProdutoController();
    
    // Construtor padrão — modo cadastro
    public CadastrarProdutoView() {
        initComponents();
        configurarLayout();
        setTitle("Cadastro de Produtos");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
    }

    // Construtor para modo edição — recebe produto já existente
    public CadastrarProdutoView(Produto produto) {
        initComponents();
        configurarLayout();
        setTitle("Editar Produto");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // Preenche os campos com os dados do produto
        txtId.setText(String.valueOf(produto.getId()));
        txtNome.setText(produto.getNome());
        txtQuantidade.setText(String.valueOf(produto.getQuantidade()));
        txtValorUnitario.setText(String.valueOf(produto.getValorUnitario()));

        // No modo edição, o ID não pode ser alterado
        txtId.setEnabled(false);
        
        // Troca o texto do botão
        btnSalvar.setText("Salvar Alterações");

        pack();
        setLocationRelativeTo(null);
    }

    private void initComponents() {
        txtId = new PlaceholderTextField(10, "Ex: 102 ou 0 para automatico");
        txtNome = new PlaceholderTextField(20, "Ex: Caneta");
        txtQuantidade = new PlaceholderTextField(10, "Ex: 50");
        txtValorUnitario = new PlaceholderTextField(10, "Ex: 2.50");
        
        btnSalvar = new JButton("Cadastrar");
        btnSalvar.addActionListener(e -> salvarProduto());
    }

    private void configurarLayout() {
        JPanel mainPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Linha 0 - ID
        gbc.gridy = 0; gbc.gridx = 0;
        mainPanel.add(new JLabel("ID:"), gbc);
        gbc.gridx = 1;
        mainPanel.add(txtId, gbc);

        // Linha 1 - Nome
        gbc.gridy = 1; gbc.gridx = 0;
        mainPanel.add(new JLabel("Nome:"), gbc);
        gbc.gridx = 1;
        mainPanel.add(txtNome, gbc);

        // Linha 2 - Quantidade
        gbc.gridy = 2; gbc.gridx = 0;
        mainPanel.add(new JLabel("Quantidade:"), gbc);
        gbc.gridx = 1;
        mainPanel.add(txtQuantidade, gbc);

        // Linha 3 - Valor Unitário
        gbc.gridy = 3; gbc.gridx = 0;
        mainPanel.add(new JLabel("Valor Unitário:"), gbc);
        gbc.gridx = 1;
        mainPanel.add(txtValorUnitario, gbc);

        // Linha 4 - Botão
        gbc.gridy = 4; gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.CENTER;
        mainPanel.add(btnSalvar, gbc);

        this.add(mainPanel);
    }

    private void salvarProduto() {
        try {
            // Se o ID estiver desabilitado (modo edição), usa o valor do campo;
            // se estiver habilitado mas vazio (modo cadastro), usa 0 para o DAO fazer INSERT
            int id = txtId.getText().trim().isEmpty() ? 0 : Integer.parseInt(txtId.getText().trim());
            String nome = txtNome.getText().trim();
            int quantidade = Integer.parseInt(txtQuantidade.getText().trim());
            double valorUnitario = Double.parseDouble(txtValorUnitario.getText().trim());

            if (nome.isEmpty()) {
                JOptionPane.showMessageDialog(this, "O nome do produto não pode ser vazio.",
                        "Campo obrigatório", JOptionPane.WARNING_MESSAGE);
                return;
            }

            Produto produto = new Produto(id, nome, quantidade, valorUnitario);
            produtoController.salvarProduto(produto);

            JOptionPane.showMessageDialog(this, "Produto salvo com sucesso!", "Sucesso",
                    JOptionPane.INFORMATION_MESSAGE);
            limparCampos();
            dispose(); // Fecha a tela após salvar

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this,
                    "Erro de formato nos campos numéricos!\n" +
                    "Quantidade deve ser inteiro e Valor Unitário deve ser decimal.",
                    "Erro de Formato", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void limparCampos() {
        txtId.setText("");
        txtNome.setText("");
        txtQuantidade.setText("");
        txtValorUnitario.setText("");
        txtId.requestFocus();
    }
}
