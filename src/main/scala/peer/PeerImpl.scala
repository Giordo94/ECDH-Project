package peer

import ellipticCurves.EllipticCurve
import utility.BigNumber._
import scala.math.BigInt

/*
 * Peer implementation
 */
case class PeerImpl(override val curve:EllipticCurve) extends Peer {
  //generate private key
  private val privateKey: BigInt = curve.genPrivateKey()
  //compute public key
  override val myPublicKey: (BigInt,BigInt) = curve.multGenerator(privateKey)
  //set other public key
  override var otherPublicKey: (BigInt, BigInt) = (zero,zero)
  //compute secret key
  override def secretKey(): (BigInt,BigInt) = {
    //no error if otherPublicKey is not set, but don't work
    curve.multPoint(otherPublicKey,privateKey)
  }
}
