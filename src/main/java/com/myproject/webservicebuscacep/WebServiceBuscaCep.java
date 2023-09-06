package com.myproject.webservicebuscacep;

import java.io.IOException;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

/**
 *
 * @author davi_
 */
public class WebServiceBuscaCep {

    public static void main(String[] args) {
        String cep = "88070-650";
        String dados = null;
        try {
            String url = "https://viacep.com.br/ws/" + cep + "/json/";
            CloseableHttpClient cliente = HttpClients.createDefault();
            HttpGet requisicao = new HttpGet(url);
            CloseableHttpResponse resposta = cliente.execute(requisicao);
            HttpEntity entidade = resposta.getEntity();
            if (entidade != null) {
                dados = EntityUtils.toString(entidade);
            }
        } catch (IOException | IllegalArgumentException e) {
            System.out.println("Falha na busca do cep");
        }
        System.out.println(dados);
        JSONObject json = new JSONObject(dados);
        System.out.println("Logradouro: " + json.getString("logradouro"));
        String endereco = """
                          {
                              "cep": "01001-000",
                              "logradouro": "Pra\u00e7a da S\u00e9",
                              "complemento": "lado \u00edmpar",
                              "bairro": "S\u00e9",
                              "localidade": "S\u00e3o Paulo",
                              "uf": "SP",
                              "ibge": "3550308",
                              "gia": "1004",
                              "ddd": "11",
                              "siafi": "7107"
                          }""";
        
        
        System.out.println(endereco);
        JSONObject json1 = new JSONObject(endereco);
        System.out.println("Logradouro: " + json1.getString("logradouro"));
        
    }
}

