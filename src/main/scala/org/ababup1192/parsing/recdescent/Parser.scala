package org.ababup1192.parsing.recdescent

import org.ababup1192.parsing.lexer.{Lexer, Token}

class Parser(val input: Lexer, val k: Int) {
  var p = 0

  val lookahead: Array[Token] = new Array[Token](k)
  for (i <- 0 until k) {
    consume()
  }

  def consume(): Token = {
    lookahead(p) = input.nextToken()
    val token = lookahead(p)
    p = (p + 1) % k
    token
  }

  def LT(i: Int): Token = lookahead((p + i - 1) % k)

  def LA(i: Int): Int = LT(i).tokenType

  def matchLex(tokenType: Int): Unit = {
    if (LA(1) == tokenType) consume()
    else throw new Error(s"expecting ${input.getTokenName(tokenType)}; found ${LT(1)}")
  }
}
