package com.poo.brincandisedivertindis;

import com.poo.brincandisedivertindis.controladores.CadastroVeiculoPP;
import com.poo.brincandisedivertindis.util.ConsolePP;
import com.poo.brincandisedivertindis.view.MenuPrincipalPP;
import org.json.simple.JSONObject;
import java.io.FileWriter;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        ConsolePP console = new ConsolePP();
        CadastroVeiculoPP cadastroVeiculos = new CadastroVeiculoPP(console);

        MenuPrincipalPP menu = new MenuPrincipalPP(console, cadastroVeiculos);
        menu.run();
    }
}
