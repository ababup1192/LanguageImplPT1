package org.ababup1192.parsing.lexer

import scala.annotation.tailrec

object Test {
  def main(args: Array[String]): Unit = {
    val listLexer = new ListLexer("[uni, kani, ikura]")

    import Lexer._
    @tailrec
    def loop(listLexer: ListLexer, tokenList: List[Token]): List[Token] = {
      val token = listLexer.nextToken
      if (token == Token(EOF_TYPE, EOF.toString)) tokenList
      else loop(listLexer, token :: tokenList)
    }
    val tokenList = loop(listLexer, List.empty[Token]).reverse
    tokenList.foreach(println)
  }
}
