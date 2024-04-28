package fr.ldnr.business;

import fr.ldnr.entities.Item;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public interface IBusiness {
    public Page<Item> findAllItemsByPage(int page, int pageSize);
    public Page<Item> findItemsByHeroIdByPage(Long idHero, int page, int pageSize);
}
