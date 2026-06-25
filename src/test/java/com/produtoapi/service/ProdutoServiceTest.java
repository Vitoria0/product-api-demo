package com.produtoapi.service;

import com.produtoapi.model.Produto;
import com.produtoapi.repository.ProdutoRepository;
import com.produtoapi.service.ProdutoService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ProdutoServiceTest {

    @Mock
    private ProdutoRepository produtoRepository;

    @InjectMocks
    private ProdutoService produtoService;

    @Test
    void deveListarTodosProdutos() {

        Produto p1 = new Produto();
        p1.setId(1L);
        p1.setNome("Notebook");

        Produto p2 = new Produto();
        p2.setId(2L);
        p2.setNome("Mouse");

        when(produtoRepository.findAll())
                .thenReturn(Arrays.asList(p1, p2));

        List<Produto> produtos = produtoService.listarTodos();

        assertEquals(2, produtos.size());
        assertEquals("Notebook", produtos.get(0).getNome());

        verify(produtoRepository).findAll();
    }

    @Test
    void deveSalvarProduto() {

        Produto produto = new Produto();
        produto.setNome("Teclado");

        when(produtoRepository.save(produto))
                .thenReturn(produto);

        Produto resultado = produtoService.salvar(produto);

        assertEquals("Teclado", resultado.getNome());

        verify(produtoRepository).save(produto);
    }

    @Test
    void deveBuscarProdutoPorId() {

        Produto produto = new Produto();
        produto.setId(1L);
        produto.setNome("Monitor");

        when(produtoRepository.findById(1L))
                .thenReturn(Optional.of(produto));

        Optional<Produto> resultado =
                produtoService.findById(1L);

        assertTrue(resultado.isPresent());
        assertEquals("Monitor", resultado.get().getNome());

        verify(produtoRepository).findById(1L);
    }

    @Test
    void deveDeletarProduto() {

        produtoService.deletar(1L);

        verify(produtoRepository).deleteById(1L);
    }

    @Test
    void deveAtualizarProduto() {

        Produto produto = new Produto();
        produto.setNome("Notebook Gamer");

        when(produtoRepository.existsById(1L))
                .thenReturn(true);

        when(produtoRepository.save(any(Produto.class)))
                .thenReturn(produto);

        Produto resultado =
                produtoService.atualizar(1L, produto);

        assertEquals("Notebook Gamer",
                resultado.getNome());

        verify(produtoRepository).existsById(1L);
        verify(produtoRepository).save(produto);
    }

    @Test
    void deveLancarExcecaoQuandoProdutoNaoExistir() {

        Produto produto = new Produto();

        when(produtoRepository.existsById(1L))
                .thenReturn(false);

        RuntimeException exception =
                assertThrows(
                        RuntimeException.class,
                        () -> produtoService.atualizar(1L, produto)
                );

        assertEquals(
                "Produto não encontrado",
                exception.getMessage()
        );
    }
}