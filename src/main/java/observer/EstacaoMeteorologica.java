package observer;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

class EstacaoMeteorologica {
    private PropertyChangeSupport suporte;
    private String atualizacaoClima;

    public EstacaoMeteorologica() {
        suporte = new PropertyChangeSupport(this);
    }

    public void adicionarOuvinte(PropertyChangeListener ouvinte) {
        suporte.addPropertyChangeListener(ouvinte);
    }

    public void removerOuvinte(PropertyChangeListener ouvinte) {
        suporte.removePropertyChangeListener(ouvinte);
    }

    public void setAtualizacaoClima(String atualizacaoClima) {
        String antigaAtualizacaoClima = this.atualizacaoClima;
        this.atualizacaoClima = atualizacaoClima;
        suporte.firePropertyChange("atualizacaoClima", antigaAtualizacaoClima, atualizacaoClima);
    }
}