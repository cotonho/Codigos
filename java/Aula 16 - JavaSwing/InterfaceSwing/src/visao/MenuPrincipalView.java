package visao;

import javax.swing.*;
import java.awt.*;

public class MenuPrincipalView extends JFrame {

    private static final long serialVersionUID = 1L;

    public MenuPrincipalView() {
        setTitle("Papelaria — Menu Principal");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // --- Título institucional ---
        JLabel lblTitulo = new JLabel("Sistema de Controle de Estoque", SwingConstants.CENTER);
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 18));
        lblTitulo.setBorder(BorderFactory.createEmptyBorder(30, 10, 10, 10));
        add(lblTitulo, BorderLayout.NORTH);

        JLabel lblSubtitulo = new JLabel("Papelaria", SwingConstants.CENTER);
        lblSubtitulo.setFont(new Font("Arial", Font.PLAIN, 13));
        lblSubtitulo.setForeground(Color.GRAY);
        lblSubtitulo.setBorder(BorderFactory.createEmptyBorder(0, 10, 20, 10));

        // --- Painel central com os botões ---
        JPanel painelBotoes = new JPanel(new GridLayout(3, 1, 10, 10));
        painelBotoes.setBorder(BorderFactory.createEmptyBorder(10, 60, 30, 60));

        painelBotoes.add(lblSubtitulo);

        JButton btnConsultarEstoque = new JButton("📦  Consultar Estoque");
        btnConsultarEstoque.setFont(new Font("Arial", Font.PLAIN, 14));
        btnConsultarEstoque.addActionListener(e -> {
            new ProdutoView().setVisible(true);
        });

        JButton btnNovoProduto = new JButton("➕  Novo Produto");
        btnNovoProduto.setFont(new Font("Arial", Font.PLAIN, 14));
        btnNovoProduto.addActionListener(e -> {
            new CadastrarProdutoView().setVisible(true);
        });

        painelBotoes.add(btnConsultarEstoque);
        painelBotoes.add(btnNovoProduto);

        add(painelBotoes, BorderLayout.CENTER);

        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new MenuPrincipalView().setVisible(true));
    }
}
