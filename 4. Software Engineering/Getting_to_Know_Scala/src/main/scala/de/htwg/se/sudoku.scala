package de.htwg.se

import scala.io.StdIn.*

object sudoku {
  def main(args:Array[String]) ={
    println("Welcome to Sudoku\n")
    val greeting = "Hello " + signUp(args)
    println(greeting)
  }

  def signUp(playerNames:Array[String]): String = {
    if (playerNames.length > 0)
        playerNames.head
    else
      readLine("Please enter your name: \n")
  }
}