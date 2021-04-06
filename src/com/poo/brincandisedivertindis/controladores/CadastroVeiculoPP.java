package com.poo.brincandisedivertindis.controladores;

import com.poo.brincandisedivertindis.entidades.VeiculoPP;
import com.poo.brincandisedivertindis.util.ConsolePP;
import org.json.simple.JSONObject;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class CadastroVeiculoPP {
    private ConsolePP console;
    private ArrayList<VeiculoPP> listaVeiculos;

    public CadastroVeiculoPP(ConsolePP console) {
        this.console = console;
        listaVeiculos = new ArrayList<VeiculoPP>();
    }

    public void cadastrarVeiculo() {
        console.escreve("Digite a placa do veículo:");
        String placa = console.leLinha();

        console.escreve("Digite a cor do veículo:");
        String cor = console.leLinha();

        console.escreve("Digite o modelo do veículo:");
        String modelo = console.leLinha();

        FileWriter writeFile = null;
        JSONObject objeto = new JSONObject();

        objeto.put("placa", placa);
        objeto.put("cor", cor);
        objeto.put("modelo", modelo);

        try {
            writeFile = new FileWriter("dadosteste2.json");
            writeFile.write(objeto.toJSONString());
            writeFile.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
