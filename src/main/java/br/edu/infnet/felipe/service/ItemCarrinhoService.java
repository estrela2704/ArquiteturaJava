package br.edu.infnet.felipe.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.felipe.domain.venda.ItemCarrinho;
import br.edu.infnet.felipe.repository.ItemCarrinhoRepository;

@Service
public class ItemCarrinhoService {

    @Autowired
    private ItemCarrinhoRepository itemCarrinhoRepository;

    public ItemCarrinho salvar(ItemCarrinho itemCarrinho) {
        return itemCarrinhoRepository.save(itemCarrinho);
    }

    public void remover(ItemCarrinho itemCarrinho) {
        itemCarrinhoRepository.delete(itemCarrinho);
    }
}
