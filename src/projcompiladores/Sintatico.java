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
public class Sintatico {
   private LinkedList<Tokens> tabela;
   private int indice;

   public Sintatico(LinkedList<Tokens> tabela) {
      this.tabela = tabela;
      this.indice = 0;
   }
   
   public boolean AnalisadorSint(){
      if(tabela.get(indice).getClassificacao().equals("substantivo") ||
         tabela.get(indice).getClassificacao().equals("artigo") ||
         tabela.get(indice).getClassificacao().equals("pronome")){
         Substantivos();
         if(indice < tabela.size() && tabela.get(indice).getClassificacao().equals("verbo")){
            Verbos();
            if(indice == tabela.size()){
               return true;
            }
            if(indice < tabela.size() && tabela.get(indice).getClassificacao().equals("preposicao")){
               Preposicao();
               if(indice == tabela.size()){
                  return true;
               }
            }
            if(indice < tabela.size() && tabela.get(indice).getClassificacao().equals("substantivo") ||
               indice < tabela.size() && tabela.get(indice).getClassificacao().equals("artigo")){
               Substantivos();
               if(indice == tabela.size()){
                  return true;
               }
               if(indice < tabela.size() && tabela.get(indice).getClassificacao().equals("preposicao")){
                  Preposicao();
                  if(indice == tabela.size()){
                     return true;
                  }
               }
            }
         }
      } else if(tabela.get(indice).getClassificacao().equals("verbo")){
         Verbos();
         if(indice == tabela.size()){
            return true;
         }
         if(indice < tabela.size() && tabela.get(indice).getClassificacao().equals("substantivo") ||
            indice < tabela.size() && tabela.get(indice).getClassificacao().equals("artigo")){
            System.out.println("oi");
            Substantivos();
            if(indice == tabela.size()){
               System.out.println("oi2");
               return true;
            }
         }
         if(indice < tabela.size() && tabela.get(indice).getClassificacao().equals("preposicao")){
            Preposicao();
            if(indice == tabela.size()){
               return true;
            }
         }
      }
      return false;
   }
   
   public void Substantivos(){
      if(indice < tabela.size() && tabela.get(indice).getClassificacao().equals("substantivo") ||
         indice < tabela.size() && tabela.get(indice).getClassificacao().equals("artigo") ||
         indice < tabela.size() && tabela.get(indice).getClassificacao().equals("pronome")){
         indice++;
         Substantivos();
      }
   }
   
   public void Verbos(){
      if(indice < tabela.size() && tabela.get(indice).getClassificacao().equals("verbo")){
         indice++;
         Verbos();
      }
   }
   
   public void Preposicao(){
      if(indice < tabela.size() && tabela.get(indice).getClassificacao().equals("preposicao")){
         indice++;
      }
   }
   
}
