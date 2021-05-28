package utility

import scala.math.BigInt
import utility.BigNumber._

/*
 * Utility class
 */
object UtilObj {

  /*
   * compute multiplicative inverse
   */
  private def multInv(dividend:BigInt,divisor:BigInt):(BigInt,BigInt,Boolean) = {
    val q = dividend / divisor
    val reminder = dividend % divisor
    if(reminder>one){
      val res = multInv(divisor,reminder)
      val k = res._1
      val j = res._2
      val b = res._3
      if(b) (k + j * (-q),j,!b) else (k,j + k * (-q),!b)
    } else {
      (reminder,-q,true)
    }
  }

  /*
   * pick the correct value
   */
  def multiplicativeInverse(number:BigInt,mod:BigInt):BigInt = {
    val res = multInv(number, mod)
    if(res._3) res._1 else res._2
  }

  /*
   * compute fraction module
   */
  def fractionMod(top:BigInt,bottom:BigInt,m:BigInt):BigInt = {
    ( top.mod(m) * multiplicativeInverse(bottom,m).mod(m) ).mod(m)
  }
}
