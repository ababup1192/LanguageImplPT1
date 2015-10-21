package org.ababup1192.parsing.lexer

abstract class Lexer(val input: String) {

  // 入力文字列中の現在位置
  var p: Int = 0

  def nextToken: Token

  def getTokenName(tokenType: Int): String
}

object Lexer {
  val EOF = -1.asInstanceOf[Char]
  // EOFの字句型
  val EOF_TYPE = 1
}
