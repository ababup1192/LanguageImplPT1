package org.ababup1192.parsing.recdescent

import org.ababup1192.parsing.lexer.ListLexer

object Test {

  def main(args: Array[String]): Unit = {
    val listLexer = new ListLexer("[uni, kani, ikura]")
    new ListParser(listLexer).list()

    // NAME = NAME parse
    val listLexer2 = new ListLexer("[uni, kani, ikura = mozuku, maguro]")
    new ListParser(listLexer2).list()
  }

}
