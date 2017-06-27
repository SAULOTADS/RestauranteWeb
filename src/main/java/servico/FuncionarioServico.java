package servico;

import modelo.Funcionario;
import javax.persistence.EntityManager;

public class FuncionarioServico extends DAOGenericoJPA<Long,Funcionario>{

    public FuncionarioServico() {
        super();
    }
    
    public Funcionario getById(long pk) {
        return super.getById(pk);
    }
}
