package observer;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class OuvinteEstacaoMeteorologica implements PropertyChangeListener {

    private String ultimaNotificacao;

    public String getUltimaNotificacao() {
        return this.ultimaNotificacao;
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if (evt.getPropertyName().equals("atualizacaoClima")) {
            String novaAtualizacaoClima = (String) evt.getNewValue();
            this.ultimaNotificacao = "Atualização do Clima: " + novaAtualizacaoClima;
        }
    }
}