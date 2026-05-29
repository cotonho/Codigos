package visao;

import controle.ProdutoController;
import modelo.Produto;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class ProdutoView extends JFrame {

    private static final long serialVersionUID = 1L;

    private final ProdutoController controller;
    private final JTable tabela;
    private final JTextField txtPesquisa;

    public ProdutoView() {
        controller = new ProdutoController();
        setTitle("Consulta de Estoque");
        setSize(800, 450);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());

        // --- Painel de pesquisa (topo) ---
        JPanel painelPesquisa = new JPanel(new FlowLayout(FlowLayout.LEFT));
        txtPesquisa = new JTextField(20);
        JButton btnPesquisar = new JButton("Pesquisar");

        painelPesquisa.add(new JLabel("Nome do produto:"));
        painelPesquisa.add(txtPesquisa);
        painelPesquisa.add(btnPesquisar);

        btnPesquisar.addActionListener(e -> pesquisarProdutos());

        // Também pesquisa ao pressionar Enter no campo de texto
        txtPesquisa.addActionListener(e -> pesquisarProdutos());

        add(painelPesquisa, BorderLayout.NORTH);

        // --- Tabela central ---
        String[] colunas = {"ID", "Nome", "Quantidade", "Valor Unitário", "Valor de Venda"};
        DefaultTableModel modeloTabela = new DefaultTableModel(colunas, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; // impede edição direta na tabela
            }
        };
        tabela = new JTable(modeloTabela);
        tabela.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        JScrollPane scrollPane = new JScrollPane(tabela);
        add(scrollPane, BorderLayout.CENTER);

        // --- Painel de botões (rodapé) ---
        JPanel painelBotoes = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        JButton btnEditar = new JButton("Editar");
        JButton btnExcluir = new JButton("Excluir");
        JButton btnAtualizar = new JButton("Atualizar Lista");

        painelBotoes.add(btnAtualizar);
        painelBotoes.add(btnEditar);
        painelBotoes.add(btnExcluir);

        btnAtualizar.addActionListener(e -> carregarDados());
        btnEditar.addActionListener(e -> editarProduto());
        btnExcluir.addActionListener(e -> excluirProduto());

        add(painelBotoes, BorderLayout.SOUTH);

        carregarDados();
        setLocationRelativeTo(null);
    }

    private void carregarDados() {
        List<Produto> produtos = controller.listarProdutos();
        preencherTabela(produtos);
    }

    private void pesquisarProdutos() {
        String termo = txtPesquisa.getText().trim();
        List<Produto> produtos;

        if (termo.isEmpty()) {
            // Se o campo estiver vazio, mostra tudo
            produtos = controller.listarProdutos();
        } else {
            produtos = controller.buscarPorNome(termo);
        }
        preencherTabela(produtos);
    }

    private void preencherTabela(List<Produto> produtos) {
        DefaultTableModel model = (DefaultTableModel) tabela.getModel();
        model.setRowCount(0);

        if (produtos != null) {
            for (Produto produto : produtos) {
                Object[] row = {
                    produto.getId(),
                    produto.getNome(),
                    produto.getQuantidade(),
                    String.format("R$ %.2f", produto.getValorUnitario()),
                    String.format("R$ %.2f", produto.getValorVenda())
                };
                model.addRow(row);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Erro ao carregar produtos do banco de dados!");
        }
    }

    private void editarProduto() {
        int linhaSelecionada = tabela.getSelectedRow();

        if (linhaSelecionada == -1) {
            JOptionPane.showMessageDialog(this, "Selecione um produto na tabela para editar.",
                    "Nenhum produto selecionado", JOptionPane.WARNING_MESSAGE);
            return;
        }

        // Lê os dados da linha selecionada
        int id = (int) tabela.getValueAt(linhaSelecionada, 0);
        String nome = (String) tabela.getValueAt(linhaSelecionada, 1);
        int quantidade = (int) tabela.getValueAt(linhaSelecionada, 2);

        // Valor unitário está formatado como "R$ x.xx" — extrai o número
        String valorStr = tabela.getValueAt(linhaSelecionada, 3).toString()
                .replace("R$", "").replace(",", ".").trim();
        double valorUnitario = Double.parseDouble(valorStr);

        Produto produto = new Produto(id, nome, quantidade, valorUnitario);

        // Abre CadastrarProdutoView no modo edição
        CadastrarProdutoView telaEdicao = new CadastrarProdutoView(produto);
        telaEdicao.setVisible(true);

        // Ao fechar a tela de edição, recarrega a lista
        telaEdicao.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosed(java.awt.event.WindowEvent e) {
                carregarDados();
            }
        });
    }

    private void excluirProduto() {
        int linhaSelecionada = tabela.getSelectedRow();

        if (linhaSelecionada == -1) {
            JOptionPane.showMessageDialog(this, "Selecione um produto na tabela para excluir.",
                    "Nenhum produto selecionado", JOptionPane.WARNING_MESSAGE);
            return;
        }

        int id = (int) tabela.getValueAt(linhaSelecionada, 0);
        String nome = (String) tabela.getValueAt(linhaSelecionada, 1);

        int confirmacao = JOptionPane.showConfirmDialog(
                this,
                "Deseja realmente excluir o produto \"" + nome + "\" (ID: " + id + ")?",
                "Confirmar Exclusão",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.WARNING_MESSAGE
        );

        if (confirmacao == JOptionPane.YES_OPTION) {
            controller.excluirProduto(id);
            JOptionPane.showMessageDialog(this, "Produto excluído com sucesso!");
            carregarDados();
        }
    }
}
