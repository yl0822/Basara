package algorithm.netease.basara.lottery;

/**
 * @author long.yl.
 */

public enum ChristmasSockType{

	/** 圣诞抽奖活动奖品类型 */

	NULL(-1, "NULL", 0),

	COUPON_99_9(1, "满99减9优惠券", 1),

	COUPON_199_16(2, "满199减16优惠券", 1),

	COUPON_399_27(3, "满399减27优惠券", 1),

	COUPON_499_36(4, "满499减36优惠券", 1),

	COUPON_99_90(5, "满99减90优惠券", 1001),

	COUPON_599_500(6, "满599减500优惠券", 1001),

	RED_1(7, "1元红包", 11),

	RED_2(8, "2元红包", 21),

	RED_3(9, "3元红包", 31),

	RED_5(10, "5元红包", 51),

	ELK(11, "麋鹿", 1001),

	SUITCASE(12, "旅行箱", 1001),

	/** 地推活动奖品类型 */

	LOCAL_COUPON_19_10(20, "满19减10优惠券", 0),

	LOCAL_COUPON_29_15(21, "满29减15优惠券", 0),

	LOCAL_COUPON_39_20(22, "满39减20优惠券", 0),

	LOCAL_COUPON_99_50(23, "满99减50优惠券", 0),

	LOCAL_COUPON_199_100(24, "满199减100优惠券", 0),

	LOCAL_COUPON_500(25, "500元无门槛券", 0);

	private final int value;

	private final String desc;

	private final int point;

	private ChristmasSockType(int value, String desc, int point) {
		this.value = value;
		this.desc = desc;
		this.point = point;
	}

	public static boolean isLimitSock(ChristmasSockType type) {
		int value = type.getIntValue();
		if (value == SUITCASE.getIntValue() || value == ELK.getIntValue() || value == COUPON_599_500.getIntValue()
				|| value == COUPON_99_90.getIntValue()) {
			return true;
		}
		return false;
	}

	public static boolean isRedSock(ChristmasSockType type) {
		int value = type.getIntValue();
		if (value == RED_1.getIntValue() || value == RED_2.getIntValue() || value == RED_3.getIntValue()
				|| value == RED_5.getIntValue()) {
			return true;
		}
		return false;
	}
	public int getIntValue() {
		return value;
	}

	public String getDesc() {
		return desc;
	}

	public int getPoint() {
		return point;
	}
	public ChristmasSockType genEnumByIntValue(int intValue) {
		for (ChristmasSockType item : ChristmasSockType.values()) {
			if (item.value == intValue)
				return item;
		}
		return NULL;
	}
}
