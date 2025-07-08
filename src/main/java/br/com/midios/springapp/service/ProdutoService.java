package br.com.midios.springapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import br.com.midios.springapp.exceptions.RecursoNaoEncontradoException;
import br.com.midios.springapp.model.Produto;
import br.com.midios.springapp.repository.ProdutoRepository;

@Service
public class ProdutoService {

    private final ProdutoRepository produtoRepository;
    public ProdutoService(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    public List<Produto> listarProdutos() {
        return produtoRepository.findAll();
    }

    public Produto salvarProduto(Produto produto) {
        return produtoRepository.save(produto);
    }

    public Optional<Produto> buscarProdutoPorId(Long id) {
        return Optional.ofNullable(produtoRepository.findById(id)
                .orElseThrow(() -> new RecursoNaoEncontradoException("Produto não encontrado com o ID: " + id)));
    }
    
    public void excluirProduto(Long id) {

        if (!produtoRepository.existsById(id)) {
            throw new RecursoNaoEncontradoException("Produto não encontrado com o ID: " + id);
            
        }
        produtoRepository.deleteById(id);
    }

    public void deletarProduto(Long id) {
        
        throw new UnsupportedOperationException("Unimplemented method 'deletarProduto'");
    }
}
