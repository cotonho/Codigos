package visao;

import controle.ProdutoController;
import modelo.Produto;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class ProdutoView extends JFrame {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final ProdutoController controller;
    private final JTable tabela;

    public ProdutoView() {
        controller = new ProdutoController();
        setTitle("Cadastro de Material Escolar");
        setSize(800, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Configuração da tabela
        String[] colunas = {"ID", "Nome", "Quantidade", "Valor Unitário", "Valor de Venda"};
        DefaultTableModel modeloTabela = new DefaultTableModel(colunas, 0);
        tabela = new JTable(modeloTabela);
        JScrollPane scrollPane = new JScrollPane(tabela);

        add(scrollPane, BorderLayout.CENTER);
        carregarDados();
        setLocationRelativeTo(null);
    }

    private void carregarDados() {
        List<Produto> produtos = controller.listarProdutos();
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

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new ProdutoView().setVisible(true));
    }
}