package utility

import java.math.BigInteger
import scala.math.BigInt

/*
 * Contains BigInt number needed in other classes
 */
object BigNumber {
  val negOne:BigInt = new BigInt(new BigInteger("-1"))
  val zero:BigInt = new BigInt(new BigInteger("0"))
  val one:BigInt = new BigInt(new BigInteger("1"))
  val two:BigInt = new BigInt(new BigInteger("2"))
  val three:BigInt = new BigInt(new BigInteger("3"))
  val four:BigInt = new BigInt(new BigInteger("4"))
  val five:BigInt = new BigInt(new BigInteger("5"))
  val six:BigInt = new BigInt(new BigInteger("6"))
  val seven:BigInt = new BigInt(new BigInteger("7"))

  //Secp256k1 param values
  object Secp256k1Val {
    val genX:BigInt = new BigInt(new BigInteger(
      "55066263022277343669578718895168534326250603453777594175500187360389116729240"))
    val genY:BigInt = new BigInt(new BigInteger(
      "32670510020758816978083085130507043184471273380659243275938904335757337482424"))
    val eqA:BigInt = new BigInt(new BigInteger(
      "0"))
    val eqB:BigInt = new BigInt(new BigInteger(
      "7"))
    val field:BigInt = new BigInt(new BigInteger(
      "115792089237316195423570985008687907853269984665640564039457584007908834671663"))
    val genOrder:BigInt = new BigInt(new BigInteger(
      "115792089237316195423570985008687907852837564279074904382605163141518161494337"))
  }

  //Anomalous param values
  object AnomalousVal {
    val genX:BigInt = new BigInt(new BigInteger(
      "1619092589586542907492569170434842128165755668543894279235270"))
    val genY:BigInt = new BigInt(new BigInteger(
      "3436949547626524920645513316569700140535482973634182925459687"))
    val eqA:BigInt = new BigInt(new BigInteger(
      "15347898055371580590890576721314318823207531963035637503096292"))
    val eqB:BigInt = new BigInt(new BigInteger(
      "7444386449934505970367865204569124728350661870959593404279615"))
    val field:BigInt = new BigInt(new BigInteger(
      "17676318486848893030961583018778670610489016512983351739677143"))
    val genOrder:BigInt = new BigInt(new BigInteger(
      "17676318486848893030961583018778670610489016512983351739677143"))
  }

  //NistP384 param values
  object NistP384Val {
    val genX:BigInt = new BigInt(new BigInteger(
      "26247035095799689268623156744566981891852923491109213387815615900925518854738050089022388053975719786650872476732087"))
    val genY:BigInt = new BigInt(new BigInteger(
      "8325710961489029985546751289520108179287853048861315594709205902480503199884419224438643760392947333078086511627871"))
    val eqA:BigInt = new BigInt(new BigInteger(
      "-3"))
    val eqB:BigInt = new BigInt(new BigInteger(
      "27580193559959705877849011840389048093056905856361568521428707301988689241309860865136260764883745107765439761230575"))
    val field:BigInt = new BigInt(new BigInteger(
      "39402006196394479212279040100143613805079739270465446667948293404245721771496870329047266088258938001861606973112319"))
    val genOrder:BigInt = new BigInt(new BigInteger(
      "39402006196394479212279040100143613805079739270465446667946905279627659399113263569398956308152294913554433653942643"))
  }
}
