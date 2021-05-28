package ellipticCurves

import scala.math.BigInt

/*
 * Not implemented!
 */
case class EdwardsCurve(override val p:BigInt,
                        override val gen:(BigInt,BigInt),
                        override val n:BigInt) extends EllipticCurve {

  override def checkPoint(x: BigInt, y: BigInt): Boolean = ???

  override def addition(xp: BigInt, yp: BigInt, xq: BigInt, yq: BigInt): (BigInt, BigInt) = ???

  override def doubleP(xp: BigInt, yp: BigInt): (BigInt, BigInt) = ???

  override def negPoint(xp: BigInt, yp: BigInt): (BigInt, BigInt) = ???

  override def multPoint(xp: BigInt, yp: BigInt, k: BigInt): (BigInt, BigInt) = ???

  override def genPrivateKey(): BigInt = ???
}
