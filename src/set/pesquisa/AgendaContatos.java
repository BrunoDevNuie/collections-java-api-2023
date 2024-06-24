package set.pesquisa;

import java.util.HashSet;
import java.util.Set;

public class AgendaContatos {
    private Set<Contato> contatoSet;

    public AgendaContatos() {
        this.contatoSet = new HashSet<>();
    }

    public void adicionarContato(String nome, int numero){
        contatoSet.add(new Contato(nome, numero));
    }

    public void exibirContatos(){
        System.out.println(contatoSet);
    }

    public Set<Contato> pesquisarPorNome(String nome){
        Set<Contato> contatoPorNome = new HashSet<>();
        for (Contato c : contatoSet){
            if(c.getNome().startsWith(nome)){
                contatoPorNome.add(c);
            }
        }
        return contatoPorNome;
    }

    public Contato atualizarNumeroContato(String nome, int novoNumero){
        Contato contatoAtualizado = null;
        for(Contato c : contatoSet){
            if(c.getNome().equalsIgnoreCase(nome)){
                c.setNumero(novoNumero);
                contatoAtualizado = c;
                break;
            }
        }
        return contatoAtualizado;
    }

    public static void main(String[] args) {
        AgendaContatos agendaContatos = new AgendaContatos();

        agendaContatos.exibirContatos();

        agendaContatos.adicionarContato("Camila", 12345566);
        agendaContatos.adicionarContato("Camila", 0);
        agendaContatos.adicionarContato("Camila Cavalcante", 545435353);
        agendaContatos.adicionarContato("Camila DIO", 555566666);
        agendaContatos.adicionarContato("Maria Silva", 222223333);

        agendaContatos.exibirContatos();

        System.out.println(agendaContatos.pesquisarPorNome("Camila"));

        System.out.println("Contato atualizado: " + agendaContatos.atualizarNumeroContato("Maria Silva", 11111));
        agendaContatos.exibirContatos();
    }
}
