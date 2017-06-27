package principal;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import modelo.Bandeira;
import modelo.Cartao;
import modelo.Cliente;
import modelo.Endereco;
import servico.BandeiraServico;
import servico.CartaoServico;
import servico.ClienteServico;

public class main {
    
    public static void main(String[] args) throws ParseException{
        BandeiraServico bServico = new BandeiraServico();
        Bandeira bandMan = bServico.retornaBandeira("VISA");
        
        System.out.println("Bandeira. Id retornada: " + bandMan.getId() + "  Bandeira: " + bandMan.getNome());

        SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy");  
        Date data = formatador.parse("01/09/2020");
        
        Cartao cartao = new Cartao(bandMan, "43454543", data);
        
        Endereco endereco = new Endereco("rua", "nota10", 10, "123456", "Recife", "PE");
        Cliente cliente = new Cliente("Saulinho", "111111", "1234567", endereco, cartao);
        
        ClienteServico carServico = new ClienteServico();
        carServico.salvar(cliente);
    }
    
}
