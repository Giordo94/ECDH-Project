package ellipticCurves

import scala.math.BigInt

/*
 * Elliptic curve interface
 * methods accept both pair (point) or point coordinate
 */
trait EllipticCurve {

  //p must be prime, define curve field Zp
  val p:BigInt
  //generator point
  val gen:(BigInt,BigInt)
  //order of generator
  val n:BigInt

  def checkPoint(p:(BigInt,BigInt)):Boolean = checkPoint(p._1,p._2)
  def checkPoint(x:BigInt, y:BigInt):Boolean

  def addition(p:(BigInt,BigInt),q:(BigInt,BigInt)):(BigInt,BigInt) = addition(p._1,p._2,q._1,q._2)
  def addition(xp:BigInt,yp:BigInt,xq:BigInt,yq:BigInt):(BigInt,BigInt)

  def doubleP(p:(BigInt,BigInt)):(BigInt,BigInt) = doubleP(p._1,p._2)
  def doubleP(xp:BigInt,yp:BigInt):(BigInt,BigInt)

  def negPoint(p:(BigInt,BigInt)):(BigInt,BigInt) = negPoint(p._1,p._2)
  def negPoint(xp:BigInt,yp:BigInt):(BigInt,BigInt)

  def multPoint(p:(BigInt,BigInt),k:BigInt):(BigInt,BigInt) = multPoint(p._1,p._2,k)
  def multPoint(xp:BigInt,yp:BigInt,k:BigInt):(BigInt,BigInt)

  def genPrivateKey():BigInt
  //utils to multiply generator for an integer value
  def multGenerator(k:BigInt):(BigInt,BigInt) = multPoint(gen,k)
}


