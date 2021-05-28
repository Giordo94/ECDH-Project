package ellipticCurves

import java.math.BigInteger
import java.security.SecureRandom
import scala.math.BigInt
import utility.BigNumber._
import utility.UtilObj._

/*
 * Short Weierstrass Curves
 * y^2 = x^3 + ax + b, where 4a^3+27b^2 is nonzero in Zp
 * p = field
 * a, b = curve params
 * gen = generator
 * n = generator order
 */
case class ShortWeierstrassCurve(override val p:BigInt,
                                 a:BigInt,
                                 b:BigInt,
                                 override val gen:(BigInt,BigInt),
                                 override val n:BigInt) extends EllipticCurve {

  // check if point is in the curve
  override def checkPoint(x:BigInt, y:BigInt):Boolean = {
    y.modPow(two,p) == (x.pow(3)+(a*x)+b).mod(p)
  }

  // check if is the point at infinity
  private def pointAtInfinity(xp:BigInt,yp:BigInt):Boolean = xp==negOne && yp==negOne

  /*
   * add two point
   * split fraction in top and bottom to make it easier to calculate module
   */
  override def addition(xp:BigInt,yp:BigInt,xq:BigInt,yq:BigInt):(BigInt,BigInt) = {
    if(xp==xq && yp == yq)
      return doubleP(xp,yp)
    if(pointAtInfinity(xp,yp))
      return (xq,yq)
    if(pointAtInfinity(xq,yq))
      return (xp,yp)
    if((xp,yp) == negPoint(xq,yq))
      return (negOne,negOne)
    var lambdaT:BigInt = yq-yp
    var lambdaB:BigInt = xq-xp
    if(lambdaB < zero) {
      lambdaB = lambdaB * negOne
      lambdaT = lambdaT * negOne
    }
    val rxb:BigInt = lambdaB.pow(2)
    val rxt = lambdaT.pow(2)-(xp*rxb)-(xq*rxb)
    val xr = fractionMod(rxt,rxb,p)
    val yrb = lambdaB
    val yrt = - (lambdaT * (xr - xp)) - (yp * lambdaB)
    val yr = fractionMod(yrt,yrb,p)
    (xr,yr)
  }

  /*
   * double a point
   * split fraction in top and bottom to make it easier to calculate module
   */
  override def doubleP(xp:BigInt,yp:BigInt):(BigInt,BigInt) = {
    if(pointAtInfinity(xp,yp))
      return (negOne,negOne)
    val lambdaT:BigInt = (three * xp.pow(2)) + a
    val lambdaB:BigInt = two * yp
    val xrb:BigInt = lambdaB.pow(2)
    val xrt:BigInt = lambdaT.pow(2) - ((two * xp) * xrb)
    val xr = fractionMod(xrt,xrb,p)
    val yrb = lambdaB
    val yrt = - (lambdaT * (xr - xp)) - (yp * lambdaB)
    val yr = fractionMod(yrt,yrb,p)
    (xr,yr)
  }

  /*
   * negate a point
   */
  override def negPoint(xp:BigInt,yp:BigInt):(BigInt,BigInt) = {
    (xp,(-yp).mod(p))
  }

  /*
   * Double and add method to multiply a point for an Int number
   * this is the recursive version
   */
  override def multPoint(xp:BigInt,yp:BigInt,k:BigInt):(BigInt,BigInt) = k match {
    case _ if k.equals(zero) => (negOne,negOne)
    case _ if k.equals(one) => (xp,yp)
    case km if km.mod(two).equals(one) => addition((xp,yp),multPoint(xp,yp,km-one))
    case _ => multPoint(doubleP(xp,yp),k/two)
  }

  /*
   * generate a private key that is a random value k | 1 < k < n
   */
  override def genPrivateKey():BigInt = {
    val sr = new SecureRandom()
    var privateKey:BigInt = new BigInt(new BigInteger(n.bitLength, sr)) + one
    while (privateKey>=n){
      privateKey = new BigInt(new BigInteger(n.bitLength, sr)) + one
    }
    privateKey
  }
}
