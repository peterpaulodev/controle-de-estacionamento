package com.poo.brincandisedivertindis;

import com.poo.brincandisedivertindis.controladores.CadastroEstacionamentoPP;
import com.poo.brincandisedivertindis.controladores.CadastroVagaPP;
import com.poo.brincandisedivertindis.controladores.CadastroVeiculoPP;
import com.poo.brincandisedivertindis.controladores.GeralPP;
import com.poo.brincandisedivertindis.factory.ConexaoPP;
import com.poo.brincandisedivertindis.util.ConsolePP;
import com.poo.brincandisedivertindis.view.MenuPrincipalPP;

import java.sql.Connection;

public class Main {

    public static void main(String[] args) throws Exception {
        ConsolePP console = new ConsolePP();

        CadastroVeiculoPP cadastroVeiculos = new CadastroVeiculoPP(console);
        CadastroVagaPP cadastroVagas = new CadastroVagaPP(console);
        CadastroEstacionamentoPP cadastroEstacionamento = new CadastroEstacionamentoPP(console);

        GeralPP geral = new GeralPP(console, cadastroVeiculos, cadastroVagas, cadastroEstacionamento);

        Connection con = ConexaoPP.ConectarBD();

        if (con!=null){
            System.out.println("Conectado!");
            con.close();
        }

        MenuPrincipalPP menu = new MenuPrincipalPP(console, cadastroVeiculos, cadastroVagas, cadastroEstacionamento, geral);
        menu.run();
    }
}
