package org.ababup1192.parsing.lexer

import scala.annotation.tailrec

class ListLexer(input: String) extends Lexer(input) {

  import ListLexer._

  def nextToken: Token = {
    // 空白処理
    p += ws(input.substring(p, input.length), 0)

    import Lexer._
    def getToken(p: Int, input: String): Token = {
      input(p) match {
        case ',' => Token(COMMA, ",")
        case '[' => Token(LBRACK, "[")
        case ']' => Token(RBRACK, "]")
        case c =>
          if (c.isLetter) Token(NAME, getName(input.substring(p, input.length)))
          else throw new Error("Invalid character: " + c)
      }
    }

    // 文字列の長さを超えていなければ、トークンを取得
    if (input.length > p) {
      val token = getToken(p, input)
      p += token.text.length
      token
    } else {
      // 文字列の長さ超えていたらEOF扱い
      Token(EOF_TYPE, EOF.toString)
    }
  }

  def getTokenName(tokenType: Int): String = {
    tokenNames(tokenType)
  }
}

object ListLexer {
  val NAME = 2
  val COMMA = 3
  val LBRACK = 4
  val RBRACK = 5

  val tokenNames = Seq("n/a", "<EOF>", "NAME", "COMMA", "LBRACK",
    "RBRACK")

  @tailrec
  def ws(input: String, n: Int): Int = {
    if (input.length <= n) {
      n
    } else {
      val c = input(0)
      if (c == ' ' || c == '\t' || c == '\n' || c == '\r') {
        ws(input.substring(n + 1, input.length), n + 1)
      } else {
        n
      }
    }
  }

  def getName(input: String): String = {
    input.takeWhile(_.isLetter)
  }



}
