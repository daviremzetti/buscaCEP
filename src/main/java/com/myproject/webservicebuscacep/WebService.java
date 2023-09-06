
package com.myproject.webservicebuscacep;

import java.io.IOException;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

/**
 *
 * @author davi_
 */
public class WebService {
    String dados = null;
    String cep;
   
    public String buscaCep(String cep) throws IOException{
        this.cep = cep;
        String url = "https://viacep.com.br/ws/" + cep + "/json/";
        CloseableHttpClient cliente = HttpClients.createDefault();
        HttpGet requisicao = new HttpGet(url);
        CloseableHttpResponse resposta = cliente.execute(requisicao);
        HttpEntity entidade = resposta.getEntity();
        if(entidade != null){
            dados = EntityUtils.toString(entidade);
        }
        return dados;
    }
    
}
