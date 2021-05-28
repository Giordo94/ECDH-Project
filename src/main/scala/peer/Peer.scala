package peer

import ellipticCurves.EllipticCurve
import scala.math.BigInt

/*
 * Peer interface
 */
trait Peer {
  val curve:EllipticCurve
  val myPublicKey: (BigInt,BigInt)
  var otherPublicKey:(BigInt,BigInt)
  def secretKey(): (BigInt,BigInt)
}
