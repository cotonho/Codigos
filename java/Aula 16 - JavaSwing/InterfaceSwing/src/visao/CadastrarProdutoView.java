package visao;

import javax.swing.*;

import controle.ProdutoController;
import modelo.Produto;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CadastrarProdutoView extends JFrame {
    private JTextField txtId;
    private JTextField txtNome;
    private JTextField txtQuantidade;
    private JTextField txtValorUnitario;
    private JButton btnCadastrar;
    private ProdutoController produtoController = new ProdutoController();

    public CadastrarProdutoView() {
        initComponents();
        configurarLayout();
        setTitle("Cadastro de Produtos");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
    }

    private void initComponents() {
        txtId = new JTextField(10);
        txtNome = new JTextField(20);
        txtQuantidade = new JTextField(10);
        txtValorUnitario = new JTextField(10);
        btnCadastrar = new JButton("Cadastrar");

        // Configurar ação do botão
        btnCadastrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	int id = Integer.parseInt(txtId.getText());
                String nome = txtNome.getText();
                int quantidade = Integer.parseInt(txtQuantidade.getText());
                double valorUnitario = Double.parseDouble(txtValorUnitario.getText());
            	Produto produto = new Produto(id, nome, quantidade, valorUnitario);
                produtoController.salvarProduto(produto);
            }
        });
    }

    private void configurarLayout() {
        JPanel mainPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Linha 0 - ID
        gbc.gridy = 0;
        gbc.gridx = 0;
        mainPanel.add(new JLabel("ID:"), gbc);
        
        gbc.gridx = 1;
        mainPanel.add(txtId, gbc);

        // Linha 1 - Nome
        gbc.gridy = 1;
        gbc.gridx = 0;
        mainPanel.add(new JLabel("Nome:"), gbc);
        
        gbc.gridx = 1;
        mainPanel.add(txtNome, gbc);

        // Linha 2 - Quantidade
        gbc.gridy = 2;
        gbc.gridx = 0;
        mainPanel.add(new JLabel("Quantidade:"), gbc);
        
        gbc.gridx = 1;
        mainPanel.add(txtQuantidade, gbc);

        // Linha 3 - Valor Unitário
        gbc.gridy = 3;
        gbc.gridx = 0;
        mainPanel.add(new JLabel("Valor Unitário:"), gbc);
        
        gbc.gridx = 1;
        mainPanel.add(txtValorUnitario, gbc);

        // Linha 4 - Botão
        gbc.gridy = 4;
        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.CENTER;
        mainPanel.add(btnCadastrar, gbc);

        this.add(mainPanel);
    }

    private void cadastrarProduto() {
        try {
            int id = Integer.parseInt(txtId.getText());
            String nome = txtNome.getText();
            int quantidade = Integer.parseInt(txtQuantidade.getText());
            double valorUnitario = Double.parseDouble(txtValorUnitario.getText());

            // Aqui você faria a lógica de persistência
            JOptionPane.showMessageDialog(this, 
                "Produto cadastrado com sucesso!\n" +
                "ID: " + id + "\n" +
                "Nome: " + nome + "\n" +
                "Quantidade: " + quantidade + "\n" +
                "Valor Unitário: R$" + valorUnitario,
                "Sucesso",
                JOptionPane.INFORMATION_MESSAGE);
            
            limparCampos();
            
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this,
                "Erro de formato nos campos numéricos!\n" +
                "ID e Quantidade devem ser números inteiros\n" +
                "Valor Unitário deve ser um número decimal",
                "Erro de Formato",
                JOptionPane.ERROR_MESSAGE);
        }
    }

    private void limparCampos() {
        txtId.setText("");
        txtNome.setText("");
        txtQuantidade.setText("");
        txtValorUnitario.setText("");
        txtId.requestFocus();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new CadastrarProdutoView().setVisible(true);
            }
        });
    }
}