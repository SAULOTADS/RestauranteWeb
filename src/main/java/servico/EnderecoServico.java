package servico;

import java.util.List;
import javax.persistence.NoResultException;
import modelo.Endereco;

public class EnderecoServico extends DAOGenericoJPA<Long, Endereco>{
    public EnderecoServico() {
        super();
    }
    
    public Endereco getById(long pk) {
        return super.getById(pk);
    }
    
    public boolean existeEndereco(Endereco end){
        String query = "select e from Endereco e";
        List<Endereco> enderecos = super.getEm().createQuery(query, Endereco.class).getResultList();
        try{
            for(Endereco endereco : enderecos){
                if(endereco.equals(end)) return true;
            }
            return false;
        }
        catch(NoResultException e){
            return false;
        }
    }
    
    @Override
    public void save(Endereco b) {
        super.getEm().getTransaction().begin();
        if(!existeEndereco(b)){
            super.getEm().persist(b);
        }
        else super.getEm().merge(b);
        super.getEm().getTransaction().commit();
    }
}
