package lab04;

public class CarrinhoService {
    private Carrinho carrinho;

    public CarrinhoService(Carrinho carrinho) {
        this.carrinho = carrinho;
    }

    // Método para adicionar um produto ao carrinho
    public void adicionarProdutoNoCarrinho(Produto produto) {
        carrinho.adicionarProduto(produto);
    }

    // Método para obter o total do carrinho
    public double obterTotalCarrinho() {
        return carrinho.calcularTotal();
    }

    // Método para obter o número de produtos no carrinho
    public int obterQuantidadeProdutosCarrinho() {
        return carrinho.obterQuantidadeProdutos();
    }
}
