package dao;

import models.Card;

public class CardService {

    private CardDao cardDao = new CardDao();

    public CardService(){

    }

    public Card findCard(int id){
        return cardDao.findById(id);
    }

    public void saveCard (Card card){
        cardDao.save(card);
    }

    public void updateCard (Card card){
        cardDao.update(card);
    }

    public void deleteCard (Card card){
        cardDao.delete(card);
    }
}
