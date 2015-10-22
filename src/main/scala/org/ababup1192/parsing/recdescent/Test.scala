package org.ababup1192.parsing.recdescent

import org.ababup1192.parsing.lexer.ListLexer

object Test {

  def main(args: Array[String]): Unit = {
    val listLexer = new ListLexer("[uni, kani, ikura]")
    new ListParser(listLexer).list()
    // Throw Error
    val listLexer2 = new ListLexer("[uni, kani, ]")
    new ListParser(listLexer2).list()
  }

}
