package fr.ldnr.dao;

import fr.ldnr.entities.Item;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {
    public Page<Item> findAll(Pageable pageable);
    public Page<Item> findByHeroId(Long idHero, Pageable pageable);
}
