package step3.model;

import java.util.ArrayList;
import java.util.List;

import static step3.constant.Message.Error.UNDER_MIN_PRICE;
import static step3.utils.CommonUtils.commonCheckEmpty;
import static step3.utils.CommonUtils.commonStringToNumber;

public class LottoGenerator {
    public static final int EACH_LOTTO_PRICE = 1000;

    private int purchasePrice;
    private int purchaseCount;
    private int selfCount;
    private Lottos lottos;

    public Lottos getLottos() {
        return lottos;
    }

    public int getPurchasedCount() {
        return purchaseCount;
    }
    public int getSelfCount() { return selfCount; }

    public void setPurchasePriceAndSelfCount(String price, String selfCount) {
        this.purchasePrice = validatePrice(price);
        this.selfCount = validateSelfCount(selfCount);
    }

    public void generateLottos() {
        calculatePurchaseCount();
        addLottos();
    }

    public void addLottos() {
        List<Lotto> lottoList = new ArrayList<>();
        for (int i = 0; i < purchaseCount; i++) {
            lottoList.add(new Lotto());
        }
        lottos = new Lottos(lottoList);
    }


    private int validatePrice(String price) {
        commonCheckEmpty(price);
        int integerPrice = commonStringToNumber(price);
        checkPriceMinLimit(integerPrice);
        return integerPrice;
    }

    private int validateSelfCount(String selfCount) {
        commonCheckEmpty(selfCount);
        int integerCount = commonStringToNumber(selfCount);
        return integerCount;
    }

    public void calculatePurchaseCount() {
        purchaseCount = purchasePrice / EACH_LOTTO_PRICE;
    }

    private void checkPriceMinLimit(int price) {
        if (price < EACH_LOTTO_PRICE) {
            throw new IllegalArgumentException(UNDER_MIN_PRICE);
        }
    }
}
