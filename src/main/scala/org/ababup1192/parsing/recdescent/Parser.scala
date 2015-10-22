package org.ababup1192.parsing.recdescent

import org.ababup1192.parsing.lexer.{Token, Lexer}

class Parser(val input: Lexer) {

  var lookahead: Token = input.nextToken()

  def matchLex(tokenType: Int){
    if(lookahead.tokenType == tokenType) lookahead = input.nextToken()
    else throw new Error(s"expecting ${input.getTokenName(tokenType)}; found $lookahead")
  }
}
