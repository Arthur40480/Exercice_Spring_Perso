package fr.ldnr.business;

import fr.ldnr.dao.ItemRepository;
import fr.ldnr.entities.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class IBusinessImpl implements IBusiness {
    @Autowired
    ItemRepository itemRepository;

    @Override
    public Page<Item> findAllItemsByPage(int page, int pageSize) {
        return itemRepository.findAll(PageRequest.of(page, pageSize));
    }

    @Override
    public Page<Item> findItemsByHeroIdByPage(Long idHero, int page, int pageSize) {
        return itemRepository.findByHeroId(idHero, PageRequest.of(page, pageSize));
    }
}
