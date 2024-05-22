package it.polimi.manguste;


public interface Observable {
    void setListener(Listener l);
    void removeListener(Listener l);
    void notifyListeners();
}
