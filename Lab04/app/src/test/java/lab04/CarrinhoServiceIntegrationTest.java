package lab04;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class CarrinhoServiceIntegrationTest {

    @Test
    public void testTotalCarrinhoVazio() {
        Carrinho carrinho = new Carrinho();
        CarrinhoService carrinhoService = new CarrinhoService(carrinho);

        // Verificando o total de um carrinho vazio
        assertEquals(0.0, carrinhoService.obterTotalCarrinho(), "O total do carrinho vazio deve ser 0.0.");
    }
    @Test
    public void testAdicionarProdutoNoCarrinho() {
        Carrinho carrinho = new Carrinho();
        CarrinhoService carrinhoService = new CarrinhoService(carrinho);
        Produto produto = new Produto("Produto 1", 10.0);

        // Adicionando um produto ao carrinho
        carrinhoService.adicionarProdutoNoCarrinho(produto);

        // Verificando o total do carrinho após adicionar o produto
        assertEquals(10.0, carrinhoService.obterTotalCarrinho(), "O total do carrinho deve ser 10.0 após adicionar o produto.");
    }
    // @Test
    // public void testAdicionarProdutoNoCarrinho() {
        
    // }
}
