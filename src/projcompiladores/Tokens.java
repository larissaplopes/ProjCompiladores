/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projcompiladores;

/**
 *
 * @author Larissa
 */
public class Tokens {
   private String palavra;
   private String classificacao;
   
   public Tokens(String p, String c){
      this.palavra = p;
      this.classificacao = c;
   }

   public String getClassificacao() {
      return classificacao;
   }

   public String getPalavra() {
      return palavra;
   }
}
