package ecdh

import ellipticCurves.ShortWeierstrassCurve
import utility.BigNumber._

/*
 * Three Weierstrass curve used for ECDH
 */
object Secp256k1 extends App {
  import Secp256k1Val._
  val secp256k1:ShortWeierstrassCurve = ShortWeierstrassCurve(field,eqA,eqB,(genX,genY),genOrder)
  val ecdhSecp256k1 = ecdhProtocol(secp256k1)
  println(if(ecdhSecp256k1.checkSecret())"Secret key established" else "Something went wrong")
}

object Anomalous extends App {
  import AnomalousVal._
  val anomalous:ShortWeierstrassCurve = ShortWeierstrassCurve(field,eqA,eqB,(genX,genY),genOrder)
  val ecdhAnomalous = ecdhProtocol(anomalous)
  println(if(ecdhAnomalous.checkSecret())"Secret key established" else "Something went wrong")
}

object NistP384 extends App {
  import NistP384Val._
  val nistP384:ShortWeierstrassCurve = ShortWeierstrassCurve(field,eqA,eqB,(genX,genY),genOrder)
  val ecdhNistP384 = ecdhProtocol(nistP384)
  println(if(ecdhNistP384.checkSecret())"Secret key established" else "Something went wrong")
}