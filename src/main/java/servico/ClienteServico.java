package servico;

import java.util.List;
import javax.persistence.NoResultException;
import modelo.Cliente;

public class ClienteServico extends UsuarioServico{

    public ClienteServico() {
        super();
    }
    
    @Override
    public Cliente getById(long pk) {
        return (Cliente) super.getById(pk);
    }
    
}
