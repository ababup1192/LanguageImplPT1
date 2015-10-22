package org.ababup1192.parsing.recdescent

import org.ababup1192.parsing.lexer.Lexer

import scala.annotation.tailrec

class ListParser(input: Lexer) extends Parser(input) {

  import org.ababup1192.parsing.lexer.ListLexer._

  def list(): Unit = {
    matchLex(LBRACK); elements(); matchLex(RBRACK)
  }

  def elements(): Unit = {
    element()
    @tailrec
    def loop():Unit = {
      if(lookahead.tokenType == COMMA){
        matchLex(COMMA); element()
        loop()
      }
    }
    loop()
  }

  def element(): Unit = {
    if (lookahead.tokenType == NAME) matchLex(NAME)
    else if (lookahead.tokenType == LBRACK) list()
    else throw new Error("expecting name of list; found " + lookahead)
  }
}
