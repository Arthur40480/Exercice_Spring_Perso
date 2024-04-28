package fr.ldnr;

import fr.ldnr.dao.HeroRepository;
import fr.ldnr.dao.ItemRepository;
import fr.ldnr.dao.RaceRepository;
import fr.ldnr.entities.Hero;
import fr.ldnr.entities.Item;
import fr.ldnr.entities.Race;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class SpringStockMvcSec1Application implements CommandLineRunner {
	@Autowired
	HeroRepository heroRepository;
	@Autowired
	RaceRepository raceRepository;
	@Autowired
	ItemRepository itemRepository;

	public static void main(String[] args) {SpringApplication.run(SpringStockMvcSec1Application.class, args);}

	public void run(String... args) throws Exception {
		generateDatas();
	}

	private void generateDatas() {
		List<Item> inventaire = new ArrayList<>();
		Race humain = new Race("Humain");
		Race nain = new Race("Nain");
		Race elfe = new Race("Elfe");
		Race gobelin = new Race("Gobelin");

		raceRepository.save(humain);
		raceRepository.save(nain);
		raceRepository.save(elfe);
		raceRepository.save(gobelin);

		Hero arthur = new Hero("Arthur", 120, 10, 20, inventaire, humain);
		Hero raphael = new Hero("Raphael", 200, 5, 30, inventaire, nain);
		Hero antoine = new Hero("Antoine", 100, 15, 10, inventaire, elfe);
		Hero patxi = new Hero("Patxi", 55, 8, 10, inventaire, gobelin);

		heroRepository.save(arthur);
		heroRepository.save(raphael);
		heroRepository.save(antoine);
		heroRepository.save(patxi);

		itemRepository.save(new Item("Arc en bois", 10, 0, "Commun", antoine));
		itemRepository.save(new Item("Epee en fer", 12, 0, "Commun", raphael));
		itemRepository.save(new Item("Lance", 14, 0, "Commun", antoine));
		itemRepository.save(new Item("Epee à deux mains", 20, 0, "Commun", patxi));
		itemRepository.save(new Item("Bouclier en bois", 0, 10, "Commun", raphael));
		itemRepository.save(new Item("Armure de novice", 0, 15, "Commun", antoine));
		itemRepository.save(new Item("Armure lourde", 0, 22, "Commun", raphael));

		itemRepository.save(new Item("Arc bénis par Elrond", 30, 0, "Rare", raphael));
		itemRepository.save(new Item("Hache en diamantine", 39, 0, "Rare", patxi));
		itemRepository.save(new Item("Arbalète du seigneur des voleurs", 45, 0, "Rare", patxi));
		itemRepository.save(new Item("Armure en écailles de dragon", 0, 55, "Rare", antoine));
		itemRepository.save(new Item("Targe en métal", 0, 29, "Rare", patxi));
		itemRepository.save(new Item("Casque de chevalier", 0, 19, "Rare", arthur));

		itemRepository.save(new Item("Dague magique", 65, 10, "Legendaire", arthur));
		itemRepository.save(new Item("Baguette de Merlin", 105, 0, "Legendaire", arthur));
		itemRepository.save(new Item("Cape d'invisibilité", 0, 100, "Legendaire", antoine));
	}
}
