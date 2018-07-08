package com.saas.admin.param;

/**
 * 
 * 
 * @项目 SpringMvc
 *
 * @日期: 2017年5月19日
 * 
 */
public interface Constants {

	// public static final String wx_fee = "1";
	// public static final String fee = "0.01";

	interface HttpPay {
		String USERID = "uid";
		String YID = "yid";
		String GIFTID = "gid";
		String TYPE = "type";
		String VID = "vid";
		String MONEY = "money";
		String NUM = "num";
	}

	interface CHANNELTYPES {
		// 发行渠道
		int RELEACHANNEL = 1;
		// 设备渠道
		int DEVICECHANNEL = 0;
	}

	// 验证码有效期2分钟
	interface yzmTime {
		int time = 120000;
	}

	interface unionTime {
		int time = 600000;
	}

	// 签到有效期24小时/-今天0点到当前经过的毫秒数
	interface signTime {
		long time = 120000;
	}

	interface LivingStatus {
		int PERSON = 2;// 个人直播
		int LIVING = 1;// 企业直播
		int CLICK = 0;// 点播
	}

	interface CommonStatus {
		int NORMAL = 1;
		int ERROR = 0;
	}

	interface GiftGroup {
		int Defult = 1;
	}

	interface UserStatus {
		int NORMAL = 1;// 正常状态
		int ERROR = 0;// 禁用状态
	}

	interface Path {
		// 直播房间关联图片存取路径
		String LIVE_PUT = "live_put";
		// 个人直播相关图片存取路径
		String PERSON_PUT = "person_put";
		// 礼物图片
		String GIFT_PUT = "gift_put";
		// 充值图片
		String CHARGE_PUT = "charge_put";
		// 充值图片
		String APK_PUT = "apk_put";
		// 用户头像
		String USER_PUT = "user_put";
		// 广告图位
		String AD_PUT = "ad_put";
		// 用户认证图位
		String AUTHER_PUT = "auther_put";
		// 游戏图位
		String GAME_PUT = "game_put";
		// 专栏分类图片
		String COLUMNTYPE_PUT = "columntype_put";
		// 专栏图片
		String COLUMN_PUT = "column_put";
		// 资讯
		String INFORMATION_PUT = "information_put";

		// 资讯
		String INFORMATION_PUT_FU = "information_put_fu";
		// 活动
		String ACTIVITY_PUT = "activity_put";
		// 游戏apk
		String GAMEAPK_PUT = "gameapk_put";
	}

	interface SmsStatus {
		int NORMAL = 1;// 正常状态
		int ERROR = 0;// 禁用状态
	}

	interface Sex {
		int MAN = 1;// 男
		int WOMEN = 0;// 女
	}

	//// 0表示禁用； 1表示允许推流；2表示断流
	// interface Living
	// {
	// int FORBID = 0;
	// int ALLOW = 1;
	// int STOP = 2;
	// }
	interface RedisKey {
		String DISCUSS = "userDiscuss";
		String IMGROUP = "group";
		String ACCOUNT = "money";
		String TOKEN = "token";
		String REGISTER_YZM = "register_yzm";
		String PASS_YZM = "pass_yzm";
		String ANDROID_SCALE = "android_scale";
		String IOS_SCALE = "ios_scale";
		String LIVEHISTORY = "livehistory";
		String VOLUME = "volume";// VOLUME 表示注册赠送代币卷
		String RECOMMEND_TOPIC = "recommend_topic";
		String UNIONPAY = "unionpay";
		String USER_ZOOM_OPEN_TIMES = "user_zoom_open";
		String USER_ZOOM_JOIN_TIMES = "user_zoom_join";
		String COLUMN_MSG = "column_msg";
		String COLUMN_LESSON_READ = "column_lesson_read";// 栏目的阅读量
		String ZOOM_PRICE = "zoom_price";
		String CHARGE_PRECENT = "charge_precent";
		String DEVICE_TOKEN = "device_token";
	}

	/**
	 * 认证状态参数
	 * 
	 * @负责人: Orchid
	 */
	interface AutherStatus {
		int WAIT = 0; // 待审
		int NORMAL = 1; // 通过
		int ERROR = 2; // 失败
	}

	interface CharSet {
		String utf8 = "UTF-8";
	}

	/**
	 * 数据格式
	 * 
	 * @author Orchid
	 * @date 2017年12月8日
	 * @version hyplatform 3.0
	 * @DateType
	 */
	interface DateType {
		String JSON = "json";
	}

	interface PayStatus {
		int SUCCESS = 1; // 支付成功
		int CREATE = 0; // 订单已创建
		// 用户取消支付操作
		int CANCEL = -1;
		// 微信支付失败
		int FAIL = -2;
	}

	interface AliPayStatus {
		String success = "TRADE_SUCCESS";// 交易支付成功
		String wait = "WAIT_BUYER_PAY";// 交易创建，等待买家付款
		String close = "TRADE_CLOSED";// 未付款交易超时关闭，或支付完成后全额退款
		String finished = "TRADE_FINISHED";// 交易结束，不可退款
	}

	interface WeiXinStatus {
		String SUCCESS = "SUCCESS";// 交易支付成功
		String NOTPAY = "NOTPAY";// —未支付

		String FAIL = "FAIL";// 支付失败(其他原因，如银行返回失败)

		String REFUND = "REFUND";// 转入退款
		String CLOSED = "CLOSED";// 已关闭
		String USERPAYING = "USERPAYING";// 用户支付中
	}

	interface PayChannel {
		int ZHIFUBAO = 1;// 支付宝
		int APPLE = 2;// 苹果内购
		int WEIXIN = 3;// 微信
		int QQ = 4;// qq
		int UNIONPAY = 5;// 银联
	}

	interface Stastics {
		int PAGE_COUNT = 2000;// 每次从网关记录读取多少条数据
	}
}
