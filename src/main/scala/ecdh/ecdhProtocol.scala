package ecdh

import ellipticCurves.EllipticCurve
import peer._

/*
 * ECDH protocol
 * two peer are created, public key exchanged and secret established
 */
case class ecdhProtocol(curve: EllipticCurve) {
  val alice:Peer = PeerImpl(curve)
  val bob:Peer = PeerImpl(curve)
  alice.otherPublicKey = bob.myPublicKey
  bob.otherPublicKey = alice.myPublicKey

  /*
   * Check if secret key is the same between the two peer
   */
  def checkSecret(): Boolean = alice.secretKey() equals bob.secretKey()
}
