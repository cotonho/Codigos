package controle;

import modelo.Produto;
import modelo.dao.ProdutoDAO;
import java.util.List;

public class ProdutoController {
    private final ProdutoDAO produtoDAO = new ProdutoDAO();

    public List<Produto> listarProdutos() {
        return produtoDAO.listarTodos();
    }

    public void salvarProduto(Produto produto) {
        produtoDAO.salvar(produto);
    }

    public void excluirProduto(int id) {
        produtoDAO.excluir(id);
    }

    public List<Produto> buscarPorNome(String nome) {
        return produtoDAO.buscarPorNome(nome);
    }
}
