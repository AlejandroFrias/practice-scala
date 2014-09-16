package org.scalalabs.basic.lab03
import sys._
/**
 * This exercise introduces you to pattern matching in combination with recursion.
 *
 * Recursion is a key concept for the functional style programming.
 * In the exercises below you learn how to apply recursion in combination with Scala's pattern matching facilities.
 *
 * For this exercise exclusively use pattern matching constructs in order to make the corresponding unittest work.
 *
 * Reference material to solve these exercises can be found here:
 * Pattern matching in general: http://programming-scala.labs.oreilly.com/ch03.html#PatternMatching
 * Pattern matching and recursion: http://programming-scala.labs.oreilly.com/ch08.html#Recursion
 */

object RecursionPatternMatchingExercise {

  /**
   * ***********************************************************************
   * Recursive algorithms with pattern matching
   * For expected solution see unittest @RecursionPatternMatchingExerciseTest
   * ***********************************************************************
   */
  /**
   * Create a method that checks that each subsequent value is greater than
   * the previous one.
   * E.g.:
   * checkValuesIncrease(Seq(1,2,3)) == true
   * checkValuesIncrease(Seq(1,2,2)) == false
   */
  def checkValuesIncrease(seq: Seq[Int]): Boolean = seq match {
    case s if 1 >= s.length => true
    case s if s(0) >= s(1) => false
    case s if s(0) < s(1) => checkValuesIncrease(s.tail)
  }
  
  /**
   * Group Consecutive values
   * List(1,1,2,3,1,1) -> List(1,1), List(2), List(3), List(1,1)
   */
  def groupConsecutive[T](in: List[T]): List[List[T]] = getNextGroup(in, List()) match {
    case List() => List()
    case group => group +: groupConsecutive(in.slice(group.length, in.length))
  }
  def getNextGroup[T](l: List[T], acc: List[T]): List[T] = l match {
    case a :: rest if acc.isEmpty => getNextGroup(rest, List(a))
    case a :: rest if acc(0) == a => getNextGroup(rest, a +: acc)
    case _ => acc
  } 

  /**
   * Group Equal values
   * List(1,1,2,3,1,1) -> List(1,1,1,1), List(2), List(3)
   */
  def groupEquals[T](in: List[T]): List[List[T]] = in match {
    case List() => List()
    case l => l.filter(_ == l.head) +: groupEquals(l.filterNot(_ == l.head)) 
  }

  /**
   * Compress values
   * List(1,1,2,3,1,1) -> List(1,2,3)
   */
  def compress[T](in: List[T]): List[T] = in match {
    case List() => List()
    case l => l.head +: compress(l.filterNot(_ == l.head)) 
  }
  
  /**
   * Define the amount of all equal members
   * List(1,1,2,3,1,1) -> List((4,1),(1,2),(1,3))
   */
  def amountEqualMembers[T](in: List[T]): List[(Int, T)] = in match {
    case List() => List()
    case l => (l.count(_ == l.head), l.head) +: amountEqualMembers(l.filterNot(_ == l.head))
  }
  
  /**
   * Zip multiple lists
   * List(List(1,2,3), List('A, 'B, 'C), List('a, 'b, 'c)) -> List(List(1, 'A, 'a), List(2, 'B, 'b), List(3, 'C, 'c))
   */
  def zipMultiple(in: List[List[_]]): List[List[_]] = in match {
    case List() :: _ => List()
    case l => l.map(_.head) +: zipMultiple(l.map(_.tail)) 
  }

  /**
   * Zip multiple lists with different sizes
   * List(List(1), List('A, 'B, 'C), List('a, 'b)) -> List(List(1, 'A, 'a))
   */
  def zipMultipleWithDifferentSize(in: List[List[_]]): List[List[_]] = in match {
    case l if l.contains(List()) => List()
    case l => l.map(_.head) +: zipMultipleWithDifferentSize(l.map(_.tail)) 
  }
  


}
