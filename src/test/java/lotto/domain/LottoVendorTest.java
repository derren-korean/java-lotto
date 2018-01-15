package lotto.domain;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LottoVendorTest {
    @Test
    public void 입력을_파싱한다() {
        assertEquals(16000 ,LottoVendor.getInstance().parseMoney("16000"));
    }

    @Test
    public void 파싱값을_로또의_단위로_연산_한다() {
        assertEquals(16 ,LottoVendor.getInstance().unitPerLotto(16000));
    }

    @Test
    public void 로또를_구매한다() {
        assertEquals(16 ,LottoVendor.getInstance().buy("16000").size());
    }

    @Test(expected = IllegalArgumentException.class)
    public void 지난주_로또_당첨_번호를_null() {
        LottoVendor.getInstance().setLastJackpotLotto("   \n");
    }

    @Test(expected = IllegalArgumentException.class)
    public void 지난주_로또_당첨_번호를_입력_기호_예외처리() {
        LottoVendor.getInstance().setLastJackpotLotto("r1,2,3,4,5,6d");
    }

    @Test(expected = IllegalArgumentException.class)
    public void 지난주_로또_당첨_번호를_입력_개수_부족() {
        LottoVendor.getInstance().setLastJackpotLotto("1,2");
    }

    @Test
    public void 지난주_로또_같은_번호를_입력() {
        LottoVendor.getInstance().setLastJackpotLotto("1,1,1,1,1,1");
    }

    @Test
    public void 지난주_로또_당첨_번호를_입력() {
        LottoVendor.getInstance().setLastJackpotLotto("1,2,3,4,5,6");
    }
}
