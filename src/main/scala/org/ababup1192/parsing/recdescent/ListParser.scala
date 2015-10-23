package org.ababup1192.parsing.recdescent

import org.ababup1192.parsing.lexer.Lexer

import scala.annotation.tailrec

class ListParser(input: Lexer) extends Parser(input, 2) {

  import org.ababup1192.parsing.lexer.ListLexer._

  def list(): Unit = {
    matchLex(LBRACK)
    elements()
    matchLex(RBRACK)
  }

  def elements(): Unit = {
    element()
    @tailrec
    def loop(): Unit = {
      if (LA(1) == COMMA) {
        matchLex(COMMA)
        element()
        loop()
      }
    }
    loop()
  }

  def element(): Unit = {
    if (LA(1) == NAME && LA(2) == EQUALS) {
      matchLex(NAME)
      matchLex(EQUALS)
      matchLex(NAME)
    }
    else if (LA(1) == NAME) matchLex(NAME)
    else if (LA(1) == LBRACK) list()
    else throw new Error("expecting name of list; found " + lookahead)
  }
}
