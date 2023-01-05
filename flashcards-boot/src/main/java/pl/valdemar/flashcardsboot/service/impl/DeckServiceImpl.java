package pl.valdemar.flashcardsboot.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.valdemar.flashcardsboot.dto.DeckDto;
import pl.valdemar.flashcardsboot.model.ApplicationUser;
import pl.valdemar.flashcardsboot.model.Deck;
import pl.valdemar.flashcardsboot.repository.DeckRepository;
import pl.valdemar.flashcardsboot.service.DeckService;

import java.util.Optional;

@Service
public class DeckServiceImpl implements DeckService {

    private DeckRepository deckRepository;

    @Autowired
    public DeckServiceImpl(DeckRepository deckRepository) {
        this.deckRepository = deckRepository;
    }

    @Override
    public Deck createDeck(DeckDto deckDto, Long userId) {
        Deck deck = new Deck();
        deck.setDeckName(deckDto.getDeckName());
        deck.setDescription(deckDto.getDescription());
        deck.setUserId(userId);
        deck.setCategory(deckDto.getCategory());
        return deckRepository.save(deck);
    }

    @Override
    public Optional<Deck> findDeckById(Long deckId) {
        return deckRepository.findById(deckId);
    }

    @Override
    public Optional<Deck> findDeckByDeckName(String deckName, Long userId) {
        return deckRepository.findByDeckNameAndUserId(deckName, userId);
    }

    @Override
    public Iterable<Deck> findDecksByUserId(Long userId) {
        return deckRepository.findDecksByUserId(userId);
    }

    public Iterable<Deck> findAllDecks() {
        return deckRepository.findAll();
    }

    @Override
    public Deck updateDeck(Deck deck) {
        return deckRepository.save(deck);
    }

    @Override
    public void deleteDeckById(Long deckId) {
        deckRepository.deleteById(deckId);
    }
}
