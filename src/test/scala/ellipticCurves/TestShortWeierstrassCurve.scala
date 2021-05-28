package ellipticCurves

import org.scalatest.matchers.should.Matchers
import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.funspec.AnyFunSpec

import java.math.BigInteger
import scala.math.BigInt

/*
Basic test for BigInt
 */
class TestShortWeierstrassCurve extends AnyFlatSpec with Matchers {
  import utility.BigNumber._
  "Two equal BigInt" must "be the same" in {
    assert(zero equals zero)
    assert(zero == zero)
  }
  "Two new BigInt with same value" should "be equal" in {
    val myZero:BigInt = new BigInt(new BigInteger("0"))
    assert(zero equals myZero)
    assert(zero == myZero)
  }
  "A pair of BigInt" should "equal if same values" in {
    val p:(BigInt,BigInt) = (zero,one)
    val q:(BigInt,BigInt) = (zero,one)
    assert(p == q)
    assert(p equals q)
  }
  it should "not equal if different values" in {
    val p:(BigInt,BigInt) = (zero,one)
    val q:(BigInt,BigInt) = (one,one)
    assert(p != q)
    assert(!p.equals(q))
  }
  "-4351 mod67" should "equal 4" in {
    val mod:BigInt = new BigInt(new BigInteger("67"))
    val a:BigInt = new BigInt(new BigInteger("-4351"))
    val r:BigInt = new BigInt(new BigInteger("4"))
    assert(a.mod(mod) == r)
  }
  "322^-1 mod 701" should "equal 455" in {
    import utility.UtilObj._
    val number:BigInt = new BigInt(new BigInteger("322"))
    val numberMod:BigInt = new BigInt(new BigInteger("701"))
    val result:BigInt = new BigInt(new BigInteger("-246"))
    val kj = multiplicativeInverse(number,numberMod)
    assert(kj == result)
  }
}

/*
Test for Weierstrass curve
 */
class TestShortWeierstrassCurveFun extends AnyFunSpec with Matchers {
  describe("SWCurve") {
    describe("using Zp=67 a=-1 b=1"){
      import utility.BigNumber._
      val zp:BigInt = new BigInt(new BigInteger("67"))
      val a:BigInt = new BigInt(new BigInteger("-1"))
      val b:BigInt = new BigInt(new BigInteger("1"))
      val px:BigInt = new BigInt(new BigInteger("17"))
      val py:BigInt = new BigInt(new BigInteger("41"))
      val qx:BigInt = new BigInt(new BigInteger("27"))
      val qy:BigInt = new BigInt(new BigInteger("48"))
      val p:(BigInt,BigInt) = (px,py)
      val q:(BigInt,BigInt) = (qx,qy)
      val rx:BigInt = new BigInt(new BigInteger("59"))
      val ry:BigInt = new BigInt(new BigInteger("10"))
      val r:(BigInt,BigInt) = (rx,ry)
      val p2x:BigInt = new BigInt(new BigInteger("48"))
      val p2y:BigInt = new BigInt(new BigInteger("14"))
      val p2:(BigInt,BigInt) = (p2x,p2y)
      val curve = ShortWeierstrassCurve(zp,a,b,p,zp)//gen and n not used
      it("P=(17,41) inside the curve") {
        assert(curve.checkPoint(p))
      }
      it("Q=(27,48) inside the curve") {
        assert(curve.checkPoint(q))
      }
      it("R=(59,10) inside the curve") {
        assert(curve.checkPoint(r))
      }
      it("2P=(48,14) inside the curve") {
        assert(curve.checkPoint(p2))
      }
      it("P=(17,41) Q=(27,48)") {
        assert(curve.addition(p,q) == r)
      }
      it("Q=(27,48) P=(17,41)") {
        assert(curve.addition(q,p) == r)
      }
      it("P=(17,41)") {
        assert(curve.doubleP(p) == p2)
      }
      it("2P+P == 3P") {
        val tmp = curve.multPoint(p,three)
        assert(tmp == curve.addition(p2,p))
        assert(curve.checkPoint(tmp))
      }
      it("2P+2P == 4P") {
        val four: BigInt = new BigInt(new BigInteger("4"))
        val p4 = curve.addition(p2,p2)
        assert(curve.multPoint(p,four) == p4)
      }
      it("2P+2P+2P == 6P") {
        val six: BigInt = new BigInt(new BigInteger("6"))
        val p4 = curve.addition(p2,p2)
        val p6 = curve.addition(p2,p4)
        assert(curve.multPoint(p,six) == p6)
        assert(curve.checkPoint(p6))
      }
      it("2P+2P+2P+P == 7P") {
        val p4 = curve.addition(p2,p2)
        val p5 = curve.addition(p,p4)
        val p7 = curve.addition(p2,p5)
        assert(curve.multPoint(p,seven) == p7)
        assert(curve.checkPoint(p7))
      }
    }
  }
}
