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
        String sql;
        sql = "INSERT INTO produto (id, nome, quantidade, valor_unitario) VALUES (?, ?, ?, ?)";
        
        
        try (Connection conn = ConexaoBD.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setInt(1, produto.getId());
            stmt.setString(2, produto.getNome());
            stmt.setInt(3, produto.getQuantidade());
            stmt.setDouble(4, produto.getValorUnitario());
            
            stmt.executeUpdate();
            System.out.println("Step1");
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao salvar produto", e);
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
}