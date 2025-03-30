package lab_testes;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class CarrinhoTest {

    @Test
    public void testAdicionarProduto() {
        // Criando um produto
        Produto produto = new Produto("Produto 1", 10.0);
        
        // Criando um carrinho
        Carrinho carrinho = new Carrinho();
        
        // Adicionando o produto ao carrinho
        carrinho.adicionarProduto(produto);
        
        // Verificando se o produto foi adicionado corretamente
        assertEquals(1, carrinho.obterQuantidadeProdutos(), "O carrinho deve conter 1 produto.");
    }

    @Test 
    public void testCalcularTotal() {
        // Criando produtos
        Produto produto1 = new Produto("Produto 1", 10.0);
        Produto produto2 = new Produto("Produto 2", 20.0);
        
        // Criando um carrinho
        Carrinho carrinho = new Carrinho();
        
        // Adicionando os produtos ao carrinho
        carrinho.adicionarProduto(produto1);
        carrinho.adicionarProduto(produto2);
        
        // Verificando o total do carrinho
        assertEquals(30.0, carrinho.calcularTotal(), "O total do carrinho deve ser 30.0.");
    }
}
