package org.ababup1192.parsing.lexer

case class Token(tokenType: Int, text: String) {
  override def toString: String = {
    val tName = ListLexer.tokenNames(tokenType)
    s"< '$text', $tName >"
  }
}


