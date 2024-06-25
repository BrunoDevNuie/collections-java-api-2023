package map.ordenacao;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class AgendaEventos {
    private Map<LocalDate, Evento> eventosMap;

    public AgendaEventos() {
        this.eventosMap = new HashMap<>();
    }

    public void adicionarEvento(LocalDate data, String nome, String atracao){
        Evento evento = new Evento(nome, atracao);
        eventosMap.put(data, evento);
    }

    public void exibirAgenda(){
        LocalDate dataAtual = LocalDate.now();
        Map<LocalDate, Evento> eventoTreeMap = new TreeMap<>(eventosMap);
        System.out.println(eventoTreeMap);
        for(Map.Entry<LocalDate, Evento> entry : eventosMap.entrySet()){
            if(entry.getKey().equals(dataAtual) || entry.getKey().isAfter(dataAtual)){
                System.out.println("O primo evento: " + entry.getValue() + " acontecará na data " + entry.getKey());
                break;
            }
        }
    }
}
