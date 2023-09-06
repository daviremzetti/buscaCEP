
package com.myproject.webservicebuscacep;

import org.json.JSONObject;

/**
 *
 * @author davi_
 */
public class Endereco {
    
    private String dadosBusca;
    private String cep;
    private String logradouro;
    private String numero;
    private String bairro;
    private String cidade;
    private String uf;
    
    public Endereco(String dadosBusca) throws Exception{
        if(dadosBusca.isEmpty()){
            throw new Exception ("Endereço não encontrado!");
        }else{
            JSONObject json = new JSONObject(dadosBusca);
            this.cep = json.getString("cep");
            this.logradouro = json.getString("logradouro");
            this.numero = json.getString("numero");
            this.bairro = json.getString("bairro");
            this.cidade = json.getString("localidade");
            this.uf = json.getString("uf");
        }
    }

    public String getCep() {
        return cep;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public String getNumero() {
        return numero;
    }

    public String getBairro() {
        return bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public String getUf() {
        return uf;
    }
    
    
}
