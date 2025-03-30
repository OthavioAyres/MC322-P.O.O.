package lab_testes;

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
        Produto produto = new Produto("Produto 1", 10.0);
        Carrinho carrinho = new Carrinho();
        CarrinhoService carrinhoService = new CarrinhoService(carrinho);

        // Adicionando o produto ao carrinho
        carrinhoService.adicionarProdutoNoCarrinho(produto);

        // Verificando se o produto foi adicionado corretamente
        assertEquals(1, carrinho.obterQuantidadeProdutos(), "O carrinho deve conter 1 produto.");
    }

}
