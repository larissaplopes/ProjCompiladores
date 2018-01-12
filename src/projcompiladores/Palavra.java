/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projcompiladores;

import java.util.LinkedList;

/**
 *
 * @author Larissa
 */
public class Palavra {
   private String palavra;
   private LinkedList<String> sinonimo;

   public Palavra(String palavra, LinkedList<String> sinonimo) {
      this.palavra = palavra;
      this.sinonimo = sinonimo;
   }

   public String getPalavra() {
      return palavra;
   }

   public LinkedList<String> getSinonimo() {
      return sinonimo;
   }
}
