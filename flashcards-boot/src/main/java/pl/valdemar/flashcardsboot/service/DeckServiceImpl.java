package pl.valdemar.flashcardsboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.valdemar.flashcardsboot.model.Deck;
import pl.valdemar.flashcardsboot.repository.DeckRepository;

import java.util.Optional;

@Service
public class DeckServiceImpl implements DeckService {

    private DeckRepository deckRepository;

    @Autowired
    public DeckServiceImpl(DeckRepository deckRepository) {
        this.deckRepository = deckRepository;
    }

    @Override
    public Deck createDeck(Deck deck) {
        return deckRepository.save(deck);
    }

    @Override
    public Optional<Deck> findCourseById(Long deckId) {
        return deckRepository.findById(deckId);
    }

    @Override
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
