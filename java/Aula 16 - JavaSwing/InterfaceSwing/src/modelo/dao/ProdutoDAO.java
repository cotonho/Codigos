package modelo.dao;

import modelo.Produto;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProdutoDAO {

    public List<Produto> listarTodos() {
        String sql = "SELECT * FROM produto";
        List<Produto> produtos = new ArrayList<>();

        try (Connection conn = ConexaoBD.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Produto produto = new Produto(
                    rs.getInt("id"),
                    rs.getString("nome"),
                    rs.getInt("quantidade"),
                    rs.getDouble("valor_unitario")
                );
                produtos.add(produto);
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao listar produtos", e);
        }
        return produtos;
    }

    public void salvar(Produto produto) {
        // Se o ID for 0, faz INSERT; caso contrário, faz UPDATE
        if (produto.getId() == 0) {
            String sql = "INSERT INTO produto (nome, quantidade, valor_unitario) VALUES (?, ?, ?)";

            try (Connection conn = ConexaoBD.getConnection();
                 PreparedStatement stmt = conn.prepareStatement(sql)) {

                stmt.setString(1, produto.getNome());
                stmt.setInt(2, produto.getQuantidade());
                stmt.setDouble(3, produto.getValorUnitario());
                stmt.executeUpdate();

            } catch (SQLException e) {
                throw new RuntimeException("Erro ao cadastrar produto", e);
            }
        } else {
            String sql = "UPDATE produto SET nome = ?, quantidade = ?, valor_unitario = ? WHERE id = ?";

            try (Connection conn = ConexaoBD.getConnection();
                 PreparedStatement stmt = conn.prepareStatement(sql)) {

                stmt.setString(1, produto.getNome());
                stmt.setInt(2, produto.getQuantidade());
                stmt.setDouble(3, produto.getValorUnitario());
                stmt.setInt(4, produto.getId());
                stmt.executeUpdate();

            } catch (SQLException e) {
                throw new RuntimeException("Erro ao atualizar produto", e);
            }
        }
    }

    public void excluir(int id) {
        String sql = "DELETE FROM produto WHERE id = ?";

        try (Connection conn = ConexaoBD.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            stmt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao excluir produto", e);
        }
    }

    public List<Produto> buscarPorNome(String nome) {
        String sql = "SELECT * FROM produto WHERE nome LIKE ?";
        List<Produto> produtos = new ArrayList<>();

        try (Connection conn = ConexaoBD.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, "%" + nome + "%");
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Produto produto = new Produto(
                    rs.getInt("id"),
                    rs.getString("nome"),
                    rs.getInt("quantidade"),
                    rs.getDouble("valor_unitario")
                );
                produtos.add(produto);
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao buscar produtos por nome", e);
        }
        return produtos;
    }
}
