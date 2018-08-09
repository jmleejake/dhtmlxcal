package global.sesoc.test;

import com.opencsv.bean.CsvBindByPosition;

public class RCsvTest {
	
	/**受注番号*/
	@CsvBindByPosition(position=0)
	private String order_no;
	
	/**受注ステータス*/
	@CsvBindByPosition(position=1)
	private String order_status;
	
	/**カード決済ステータス*/
	@CsvBindByPosition(position=2)
	private String card_pay_status;
	
	/**入金日*/
	@CsvBindByPosition(position=3)
	private String deposit_date;
	
	/**配送日*/
	@CsvBindByPosition(position=4)
	private String delivery_date;
	
	/**お届け時間帯*/
	@CsvBindByPosition(position=5)
	private String delivery_time;
	
	/**お届け日指定*/
	@CsvBindByPosition(position=6)
	private String delivery_date_sel;
	
	/**担当者*/
	@CsvBindByPosition(position=7)
	private String person_in_charge;
	
	/**ひとことメモ*/
	@CsvBindByPosition(position=8)
	private String note;
	
	/**メール差込文(お客様へのメッセージ)*/
	@CsvBindByPosition(position=9)
	private String note_to_customer;
	
	/**初期購入合計金額*/
	@CsvBindByPosition(position=10)
	private String init_purchase_amt;
	
	/**利用端末*/
	@CsvBindByPosition(position=11)
	private String terminal;
	
	/**メールキャリアコード*/
	@CsvBindByPosition(position=12)
	private String mail_carrier_code;
	
	/**ギフトチェック（0:なし/1:あり）*/
	@CsvBindByPosition(position=13)
	private String gift_check;
	
	/**コメント*/
	@CsvBindByPosition(position=14)
	private String order_comment;
	
	/**注文日時*/
	@CsvBindByPosition(position=15)
	private String order_datetime;
	
	/**複数送付先フラグ*/
	@CsvBindByPosition(position=16)
	private String multi_destination_flag;
	
	/**警告表示フラグ*/
	@CsvBindByPosition(position=17)
	private String warning_flag;
	
	/**楽天会員フラグ*/
	@CsvBindByPosition(position=18)
	private String rmember_flag;
	
	/**合計*/
	@CsvBindByPosition(position=19)
	private String total;
	
	/**消費税(-99999=無効値)*/
	@CsvBindByPosition(position=20)
	private String consume_tax;
	
	/**送料(-99999=無効値)*/
	@CsvBindByPosition(position=21)
	private String shipping_cost;
	
	/**代引料(-99999=無効値)*/
	@CsvBindByPosition(position=22)
	private String substitute_cost;
	
	/**請求金額(-99999=無効値)*/
	@CsvBindByPosition(position=23)
	private String billing_amt;
	
	/**合計金額(-99999=無効値)*/
	@CsvBindByPosition(position=24)
	private String total_amt;
	
	/**同梱ID*/
	@CsvBindByPosition(position=25)
	private String enclosed_id;
	
	/**同梱ステータス*/
	@CsvBindByPosition(position=26)
	private String enclosed_status;
	
	/**同梱商品合計金額*/
	@CsvBindByPosition(position=27)
	private String enclosed_goods_total_amt;
	
	/**同梱送料合計*/
	@CsvBindByPosition(position=28)
	private String enclosed_total_shipping;
	
	/**同梱代引料合計*/
	@CsvBindByPosition(position=29)
	private String enclosed_total_substitue;
	
	/**同梱消費税合計*/
	@CsvBindByPosition(position=30)
	private String enclosed_total_consume;
	
	/**同梱請求金額*/
	@CsvBindByPosition(position=31)
	private String enclosed_billing_amt;
	
	/**同梱合計金額*/
	@CsvBindByPosition(position=32)
	private String enclosed_total_amt;
	
	/**同梱楽天バンク決済振替手数料*/
	@CsvBindByPosition(position=33)
	private String enclosed_rbank_transfer_fee;
	
	/**同梱ポイント利用合計*/
	@CsvBindByPosition(position=34)
	private String enclosed_total_point_usage;
	
	/**メールフラグ*/
	@CsvBindByPosition(position=35)
	private String main_flag;
	
	/**注文日*/
	@CsvBindByPosition(position=36)
	private String order_date;
	
	/**注文時間*/
	@CsvBindByPosition(position=37)
	private String order_time;
	
	/**モバイルキャリア決済番号*/
	@CsvBindByPosition(position=38)
	private String mobile_carrier_payment_no;
	
	/**購入履歴修正可否タイプ*/
	@CsvBindByPosition(position=39)
	private String purchase_hist_mod_type;
	
	/**購入履歴修正アイコンフラグ*/
	@CsvBindByPosition(position=40)
	private String purchase_hist_mod_icon;
	
	/**購入履歴修正催促メールフラグ*/
	@CsvBindByPosition(position=41)
	private String purchase_hist_mod_prompt_mail;
	
	/**送付先一致フラグ*/
	@CsvBindByPosition(position=42)
	private String destination_match_flag;
	
	/**ポイント利用有無*/
	@CsvBindByPosition(position=43)
	private String point_usage;
	
	/**注文者郵便番号１*/
	@CsvBindByPosition(position=44)
	private String order_post_no1;
	
	/**注文者郵便番号２*/
	@CsvBindByPosition(position=45)
	private String order_post_no2;
	
	/**注文者住所：都道府県*/
	@CsvBindByPosition(position=46)
	private String order_address1;
	
	/**注文者住所：都市区*/
	@CsvBindByPosition(position=47)
	private String order_address2;
	
	/**注文者住所：町以降*/
	@CsvBindByPosition(position=48)
	private String order_address3;
	
	/**注文者名字*/
	@CsvBindByPosition(position=49)
	private String order_surname;
	
	/**注文者名前*/
	@CsvBindByPosition(position=50)
	private String order_name;
	
	/**注文者名字フリガナ*/
	@CsvBindByPosition(position=51)
	private String order_surname_kana;
	
	/**注文者名前フリガナ*/
	@CsvBindByPosition(position=52)
	private String order_name_kana;
	
	/**注文者電話番号１*/
	@CsvBindByPosition(position=53)
	private String order_tel1;
	
	/**注文者電話番号２*/
	@CsvBindByPosition(position=54)
	private String order_tel2;
	
	/**注文者電話番号３*/
	@CsvBindByPosition(position=55)
	private String order_tel3;
	
	/**メールアドレス*/
	@CsvBindByPosition(position=56)
	private String mail_address;
	
	/**注文者性別*/
	@CsvBindByPosition(position=57)
	private String order_sex;
	
	/**注文者誕生日*/
	@CsvBindByPosition(position=58)
	private String order_birth;
	
	/**決済方法*/
	@CsvBindByPosition(position=59)
	private String payment_method;
	
	/**クレジットカード種類*/
	@CsvBindByPosition(position=60)
	private String credit_type;
	
	/**クレジットカード番号*/
	@CsvBindByPosition(position=61)
	private String credit_no;
	
	/**クレジットカード名義人*/
	@CsvBindByPosition(position=62)
	private String credit_user;
	
	/**クレジットカード有効期限*/
	@CsvBindByPosition(position=63)
	private String credit_expire;
	
	/**クレジットカード分割選択*/
	@CsvBindByPosition(position=64)
	private String credit_installment;
	
	/**クレジットカード分割備考*/
	@CsvBindByPosition(position=65)
	private String credit_installment_note;
	
	/**配送方法*/
	@CsvBindByPosition(position=66)
	private String delivery_method;
	
	/**配送区分*/
	@CsvBindByPosition(position=67)
	private String delivery_type;
	
	/**ポイント利用額*/
	@CsvBindByPosition(position=68)
	private String point_usage_person;
	
	/**ポイント利用条件*/
	@CsvBindByPosition(position=69)
	private String point_usage_condition;
	
	/**ポイントステータス*/
	@CsvBindByPosition(position=70)
	private String point_status;
	
	/**楽天バンク決済ステータス*/
	@CsvBindByPosition(position=71)
	private String rbank_payment_status;
	
	/**楽天バンク振替手数料負担区分*/
	@CsvBindByPosition(position=72)
	private String rbank_payment_transfer_fee;
	
	/**楽天バンク決済手数料*/
	@CsvBindByPosition(position=73)
	private String rbank_patment_fee;
	
	/**ラッピングタイトル(包装紙)*/
	@CsvBindByPosition(position=74)
	private String wrap_paper_title;
	
	/**ラッピング名(包装紙)*/
	@CsvBindByPosition(position=75)
	private String wrap_paper_name;
	
	/**ラッピング料金(包装紙)*/
	@CsvBindByPosition(position=76)
	private String wrap_paper_fee;
	
	/**税込別(包装紙)*/
	@CsvBindByPosition(position=77)
	private String wrap_paper_tax_include;
	
	/**ラッピングタイトル(リボン)*/
	@CsvBindByPosition(position=78)
	private String wrap_ribbon_title;
	
	/**ラッピング名(リボン)*/
	@CsvBindByPosition(position=79)
	private String wrap_ribbon_name;
	
	/**ラッピング料金(リボン)*/
	@CsvBindByPosition(position=80)
	private String wrap_ribbon_fee;
	
	/**税込別(リボン)*/
	@CsvBindByPosition(position=81)
	private String wrap_ribbon_tax_include;
	
	/**送付先送料*/
	@CsvBindByPosition(position=82)
	private String delivery_cost;
	
	/**送付先代引料*/
	@CsvBindByPosition(position=83)
	private String delivery_substitute_cost;
	
	/**送付先消費税*/
	@CsvBindByPosition(position=84)
	private String delivery_consume;
	
	/**お荷物伝票番号*/
	@CsvBindByPosition(position=85)
	private String baggage_claim_no;
	
	/**送付先商品合計金額*/
	@CsvBindByPosition(position=86)
	private String delivery_goods_total_amt;
	
	/**のし*/
	@CsvBindByPosition(position=87)
	private String indicates;
	
	/**送付先郵便番号１*/
	@CsvBindByPosition(position=88)
	private String delivery_post_no1;
	
	/**送付先郵便番号２*/
	@CsvBindByPosition(position=89)
	private String delivery_post_no2;
	
	/**送付先住所：都道府県*/
	@CsvBindByPosition(position=90)
	private String delivery_address1;
	
	/**送付先住所：都市区*/
	@CsvBindByPosition(position=91)
	private String delivery_address2;
	
	/**送付先住所：町以降*/
	@CsvBindByPosition(position=92)
	private String delivery_address3;
	
	/**送付先名字*/
	@CsvBindByPosition(position=93)
	private String delivery_surname;
	
	/**送付先名前*/
	@CsvBindByPosition(position=94)
	private String delivery_name;
	
	/**送付先名字フリガナ*/
	@CsvBindByPosition(position=95)
	private String delivery_surname_kana;
	
	/**送付先名前フリガナ*/
	@CsvBindByPosition(position=96)
	private String delivery_name_kana;
	
	/**送付先電話番号１*/
	@CsvBindByPosition(position=97)
	private String delivery_tel1;
	
	/**送付先電話番号２*/
	@CsvBindByPosition(position=98)
	private String delivery_tel2;
	
	/**送付先電話番号３*/
	@CsvBindByPosition(position=99)
	private String delivery_tel3;
	
	/**商品ID*/
	@CsvBindByPosition(position=100)
	private String product_id;
	
	/**商品名*/
	@CsvBindByPosition(position=101)
	private String product_name;
	
	/**商品番号*/
	@CsvBindByPosition(position=102)
	private String product_no;
	
	/**商品URL*/
	@CsvBindByPosition(position=103)
	private String product_url;
	
	/**単価*/
	@CsvBindByPosition(position=104)
	private String unit_price;
	
	/**個数*/
	@CsvBindByPosition(position=105)
	private String unit_no;
	
	/**送料込別*/
	@CsvBindByPosition(position=106)
	private String delivery_cost_include;
	
	/**税込別*/
	@CsvBindByPosition(position=107)
	private String tax_exclude;
	
	/**代引手数料込別*/
	@CsvBindByPosition(position=108)
	private String substitute_fee_include;
	
	/**項目・選択肢*/
	@CsvBindByPosition(position=109)
	private String product_option;
	
	/**ポイント倍率*/
	@CsvBindByPosition(position=110)
	private String point_percent;
	
	/**ポイントタイプ*/
	@CsvBindByPosition(position=111)
	private String point_type;
	
	/**レコードナンバー*/
	@CsvBindByPosition(position=112)
	private String record_no;
	
	/**納期情報*/
	@CsvBindByPosition(position=113)
	private String delivery_info;
	
	/**在庫タイプ*/
	@CsvBindByPosition(position=114)
	private String inventory_type;
	
	/**ラッピング種類(包装紙)*/
	@CsvBindByPosition(position=115)
	private String wrap_type_paper;
	
	/**ラッピング種類(リボン)*/
	@CsvBindByPosition(position=116)
	private String wrap_type_ribbon;
	
	/**あす楽希望*/
	@CsvBindByPosition(position=117)
	private String tomorrow_hope;
	
	/**クーポン利用額*/
	@CsvBindByPosition(position=118)
	private String coupon_usage;
	
	/**店舗発行クーポン利用額*/
	@CsvBindByPosition(position=119)
	private String store_coupon_usage;
	
	/**楽天発行クーポン利用額*/
	@CsvBindByPosition(position=120)
	private String rcoupon_usage;
	
	/**同梱注文クーポン利用額*/
	@CsvBindByPosition(position=121)
	private String enclose_coupon_usage;
	
	/**配送会社*/
	@CsvBindByPosition(position=122)
	private String delivery_company;
	
	/**薬事フラグ*/
	@CsvBindByPosition(position=123)
	private String pharm_flag;
	
	/**楽天スーパーDEAL*/
	@CsvBindByPosition(position=124)
	private String rakuten_super_deal;
	
	/**メンバーシッププログラム*/
	@CsvBindByPosition(position=125)
	private String membership_program;
	
	public RCsvTest() {}

	public RCsvTest(String order_no, String order_status, String card_pay_status, String deposit_date,
			String delivery_date, String delivery_time, String delivery_date_sel, String person_in_charge, String note,
			String note_to_customer, String init_purchase_amt, String terminal, String mail_carrier_code,
			String gift_check, String order_comment, String order_datetime, String multi_destination_flag,
			String warning_flag, String rmember_flag, String total, String consume_tax, String shipping_cost,
			String substitute_cost, String billing_amt, String total_amt, String enclosed_id, String enclosed_status,
			String enclosed_goods_total_amt, String enclosed_total_shipping, String enclosed_total_substitue,
			String enclosed_total_consume, String enclosed_billing_amt, String enclosed_total_amt,
			String enclosed_rbank_transfer_fee, String enclosed_total_point_usage, String main_flag, String order_date,
			String order_time, String mobile_carrier_payment_no, String purchase_hist_mod_type,
			String purchase_hist_mod_icon, String purchase_hist_mod_prompt_mail, String destination_match_flag,
			String point_usage, String order_post_no1, String order_post_no2, String order_address1,
			String order_address2, String order_address3, String order_surname, String order_name,
			String order_surname_kana, String order_name_kana, String order_tel1, String order_tel2, String order_tel3,
			String mail_address, String order_sex, String order_birth, String payment_method, String credit_type,
			String credit_no, String credit_user, String credit_expire, String credit_installment,
			String credit_installment_note, String delivery_method, String delivery_type, String point_usage_person,
			String point_usage_condition, String point_status, String rbank_payment_status,
			String rbank_payment_transfer_fee, String rbank_patment_fee, String wrap_paper_title,
			String wrap_paper_name, String wrap_paper_fee, String wrap_paper_tax_include, String wrap_ribbon_title,
			String wrap_ribbon_name, String wrap_ribbon_fee, String wrap_ribbon_tax_include, String delivery_cost,
			String delivery_substitute_cost, String delivery_consume, String baggage_claim_no,
			String delivery_goods_total_amt, String indicates, String delivery_post_no1, String delivery_post_no2,
			String delivery_address1, String delivery_address2, String delivery_address3, String delivery_surname,
			String delivery_name, String delivery_surname_kana, String delivery_name_kana, String delivery_tel1,
			String delivery_tel2, String delivery_tel3, String product_id, String product_name, String product_no,
			String product_url, String unit_price, String unit_no, String delivery_cost_include, String tax_exclude,
			String substitute_fee_include, String product_option, String point_percent, String point_type,
			String record_no, String delivery_info, String inventory_type, String wrap_type_paper,
			String wrap_type_ribbon, String tomorrow_hope, String coupon_usage, String store_coupon_usage,
			String rcoupon_usage, String enclose_coupon_usage, String delivery_company, String pharm_flag,
			String rakuten_super_deal, String membership_program) {
		super();
		this.order_no = order_no;
		this.order_status = order_status;
		this.card_pay_status = card_pay_status;
		this.deposit_date = deposit_date;
		this.delivery_date = delivery_date;
		this.delivery_time = delivery_time;
		this.delivery_date_sel = delivery_date_sel;
		this.person_in_charge = person_in_charge;
		this.note = note;
		this.note_to_customer = note_to_customer;
		this.init_purchase_amt = init_purchase_amt;
		this.terminal = terminal;
		this.mail_carrier_code = mail_carrier_code;
		this.gift_check = gift_check;
		this.order_comment = order_comment;
		this.order_datetime = order_datetime;
		this.multi_destination_flag = multi_destination_flag;
		this.warning_flag = warning_flag;
		this.rmember_flag = rmember_flag;
		this.total = total;
		this.consume_tax = consume_tax;
		this.shipping_cost = shipping_cost;
		this.substitute_cost = substitute_cost;
		this.billing_amt = billing_amt;
		this.total_amt = total_amt;
		this.enclosed_id = enclosed_id;
		this.enclosed_status = enclosed_status;
		this.enclosed_goods_total_amt = enclosed_goods_total_amt;
		this.enclosed_total_shipping = enclosed_total_shipping;
		this.enclosed_total_substitue = enclosed_total_substitue;
		this.enclosed_total_consume = enclosed_total_consume;
		this.enclosed_billing_amt = enclosed_billing_amt;
		this.enclosed_total_amt = enclosed_total_amt;
		this.enclosed_rbank_transfer_fee = enclosed_rbank_transfer_fee;
		this.enclosed_total_point_usage = enclosed_total_point_usage;
		this.main_flag = main_flag;
		this.order_date = order_date;
		this.order_time = order_time;
		this.mobile_carrier_payment_no = mobile_carrier_payment_no;
		this.purchase_hist_mod_type = purchase_hist_mod_type;
		this.purchase_hist_mod_icon = purchase_hist_mod_icon;
		this.purchase_hist_mod_prompt_mail = purchase_hist_mod_prompt_mail;
		this.destination_match_flag = destination_match_flag;
		this.point_usage = point_usage;
		this.order_post_no1 = order_post_no1;
		this.order_post_no2 = order_post_no2;
		this.order_address1 = order_address1;
		this.order_address2 = order_address2;
		this.order_address3 = order_address3;
		this.order_surname = order_surname;
		this.order_name = order_name;
		this.order_surname_kana = order_surname_kana;
		this.order_name_kana = order_name_kana;
		this.order_tel1 = order_tel1;
		this.order_tel2 = order_tel2;
		this.order_tel3 = order_tel3;
		this.mail_address = mail_address;
		this.order_sex = order_sex;
		this.order_birth = order_birth;
		this.payment_method = payment_method;
		this.credit_type = credit_type;
		this.credit_no = credit_no;
		this.credit_user = credit_user;
		this.credit_expire = credit_expire;
		this.credit_installment = credit_installment;
		this.credit_installment_note = credit_installment_note;
		this.delivery_method = delivery_method;
		this.delivery_type = delivery_type;
		this.point_usage_person = point_usage_person;
		this.point_usage_condition = point_usage_condition;
		this.point_status = point_status;
		this.rbank_payment_status = rbank_payment_status;
		this.rbank_payment_transfer_fee = rbank_payment_transfer_fee;
		this.rbank_patment_fee = rbank_patment_fee;
		this.wrap_paper_title = wrap_paper_title;
		this.wrap_paper_name = wrap_paper_name;
		this.wrap_paper_fee = wrap_paper_fee;
		this.wrap_paper_tax_include = wrap_paper_tax_include;
		this.wrap_ribbon_title = wrap_ribbon_title;
		this.wrap_ribbon_name = wrap_ribbon_name;
		this.wrap_ribbon_fee = wrap_ribbon_fee;
		this.wrap_ribbon_tax_include = wrap_ribbon_tax_include;
		this.delivery_cost = delivery_cost;
		this.delivery_substitute_cost = delivery_substitute_cost;
		this.delivery_consume = delivery_consume;
		this.baggage_claim_no = baggage_claim_no;
		this.delivery_goods_total_amt = delivery_goods_total_amt;
		this.indicates = indicates;
		this.delivery_post_no1 = delivery_post_no1;
		this.delivery_post_no2 = delivery_post_no2;
		this.delivery_address1 = delivery_address1;
		this.delivery_address2 = delivery_address2;
		this.delivery_address3 = delivery_address3;
		this.delivery_surname = delivery_surname;
		this.delivery_name = delivery_name;
		this.delivery_surname_kana = delivery_surname_kana;
		this.delivery_name_kana = delivery_name_kana;
		this.delivery_tel1 = delivery_tel1;
		this.delivery_tel2 = delivery_tel2;
		this.delivery_tel3 = delivery_tel3;
		this.product_id = product_id;
		this.product_name = product_name;
		this.product_no = product_no;
		this.product_url = product_url;
		this.unit_price = unit_price;
		this.unit_no = unit_no;
		this.delivery_cost_include = delivery_cost_include;
		this.tax_exclude = tax_exclude;
		this.substitute_fee_include = substitute_fee_include;
		this.product_option = product_option;
		this.point_percent = point_percent;
		this.point_type = point_type;
		this.record_no = record_no;
		this.delivery_info = delivery_info;
		this.inventory_type = inventory_type;
		this.wrap_type_paper = wrap_type_paper;
		this.wrap_type_ribbon = wrap_type_ribbon;
		this.tomorrow_hope = tomorrow_hope;
		this.coupon_usage = coupon_usage;
		this.store_coupon_usage = store_coupon_usage;
		this.rcoupon_usage = rcoupon_usage;
		this.enclose_coupon_usage = enclose_coupon_usage;
		this.delivery_company = delivery_company;
		this.pharm_flag = pharm_flag;
		this.rakuten_super_deal = rakuten_super_deal;
		this.membership_program = membership_program;
	}

	/**
	 * @return the order_no
	 */
	public String getOrder_no() {
		return order_no;
	}

	/**
	 * @param order_no the order_no to set
	 */
	public void setOrder_no(String order_no) {
		this.order_no = order_no;
	}

	/**
	 * @return the order_status
	 */
	public String getOrder_status() {
		return order_status;
	}

	/**
	 * @param order_status the order_status to set
	 */
	public void setOrder_status(String order_status) {
		this.order_status = order_status;
	}

	/**
	 * @return the card_pay_status
	 */
	public String getCard_pay_status() {
		return card_pay_status;
	}

	/**
	 * @param card_pay_status the card_pay_status to set
	 */
	public void setCard_pay_status(String card_pay_status) {
		this.card_pay_status = card_pay_status;
	}

	/**
	 * @return the deposit_date
	 */
	public String getDeposit_date() {
		return deposit_date;
	}

	/**
	 * @param deposit_date the deposit_date to set
	 */
	public void setDeposit_date(String deposit_date) {
		this.deposit_date = deposit_date;
	}

	/**
	 * @return the delivery_date
	 */
	public String getDelivery_date() {
		return delivery_date;
	}

	/**
	 * @param delivery_date the delivery_date to set
	 */
	public void setDelivery_date(String delivery_date) {
		this.delivery_date = delivery_date;
	}

	/**
	 * @return the delivery_time
	 */
	public String getDelivery_time() {
		return delivery_time;
	}

	/**
	 * @param delivery_time the delivery_time to set
	 */
	public void setDelivery_time(String delivery_time) {
		this.delivery_time = delivery_time;
	}

	/**
	 * @return the delivery_date_sel
	 */
	public String getDelivery_date_sel() {
		return delivery_date_sel;
	}

	/**
	 * @param delivery_date_sel the delivery_date_sel to set
	 */
	public void setDelivery_date_sel(String delivery_date_sel) {
		if (delivery_date_sel.contains("-")) {
			delivery_date_sel = delivery_date_sel.replace("-", "/");
		}
		
		if (delivery_date_sel.length() == 8) {
			String year = delivery_date_sel.substring(0, 4);
			String month = delivery_date_sel.substring(4, 6);
			String day = delivery_date_sel.substring(6, 8);
			delivery_date_sel = String.format("%s/%s/%s", year, month, day);
		}
		this.delivery_date_sel = delivery_date_sel;
	}

	/**
	 * @return the person_in_charge
	 */
	public String getPerson_in_charge() {
		return person_in_charge;
	}

	/**
	 * @param person_in_charge the person_in_charge to set
	 */
	public void setPerson_in_charge(String person_in_charge) {
		this.person_in_charge = person_in_charge;
	}

	/**
	 * @return the note
	 */
	public String getNote() {
		return note;
	}

	/**
	 * @param note the note to set
	 */
	public void setNote(String note) {
		this.note = note;
	}

	/**
	 * @return the note_to_customer
	 */
	public String getNote_to_customer() {
		return note_to_customer;
	}

	/**
	 * @param note_to_customer the note_to_customer to set
	 */
	public void setNote_to_customer(String note_to_customer) {
		this.note_to_customer = note_to_customer;
	}

	/**
	 * @return the init_purchase_amt
	 */
	public String getInit_purchase_amt() {
		return init_purchase_amt;
	}

	/**
	 * @param init_purchase_amt the init_purchase_amt to set
	 */
	public void setInit_purchase_amt(String init_purchase_amt) {
		this.init_purchase_amt = init_purchase_amt;
	}

	/**
	 * @return the terminal
	 */
	public String getTerminal() {
		return terminal;
	}

	/**
	 * @param terminal the terminal to set
	 */
	public void setTerminal(String terminal) {
		this.terminal = terminal;
	}

	/**
	 * @return the mail_carrier_code
	 */
	public String getMail_carrier_code() {
		return mail_carrier_code;
	}

	/**
	 * @param mail_carrier_code the mail_carrier_code to set
	 */
	public void setMail_carrier_code(String mail_carrier_code) {
		this.mail_carrier_code = mail_carrier_code;
	}

	/**
	 * @return the gift_check
	 */
	public String getGift_check() {
		return gift_check;
	}

	/**
	 * @param gift_check the gift_check to set
	 */
	public void setGift_check(String gift_check) {
		this.gift_check = gift_check;
	}

	/**
	 * @return the order_comment
	 */
	public String getOrder_comment() {
		return order_comment;
	}

	/**
	 * @param order_comment the order_comment to set
	 */
	public void setOrder_comment(String order_comment) {
		this.order_comment = order_comment;
	}

	/**
	 * @return the order_datetime
	 */
	public String getOrder_datetime() {
		return order_datetime;
	}

	/**
	 * @param order_datetime the order_datetime to set
	 */
	public void setOrder_datetime(String order_datetime) {
		this.order_datetime = order_datetime;
	}

	/**
	 * @return the multi_destination_flag
	 */
	public String getMulti_destination_flag() {
		return multi_destination_flag;
	}

	/**
	 * @param multi_destination_flag the multi_destination_flag to set
	 */
	public void setMulti_destination_flag(String multi_destination_flag) {
		this.multi_destination_flag = multi_destination_flag;
	}

	/**
	 * @return the warning_flag
	 */
	public String getWarning_flag() {
		return warning_flag;
	}

	/**
	 * @param warning_flag the warning_flag to set
	 */
	public void setWarning_flag(String warning_flag) {
		this.warning_flag = warning_flag;
	}

	/**
	 * @return the rmember_flag
	 */
	public String getRmember_flag() {
		return rmember_flag;
	}

	/**
	 * @param rmember_flag the rmember_flag to set
	 */
	public void setRmember_flag(String rmember_flag) {
		this.rmember_flag = rmember_flag;
	}

	/**
	 * @return the total
	 */
	public String getTotal() {
		return total;
	}

	/**
	 * @param total the total to set
	 */
	public void setTotal(String total) {
		this.total = total;
	}

	/**
	 * @return the consume_tax
	 */
	public String getConsume_tax() {
		return consume_tax;
	}

	/**
	 * @param consume_tax the consume_tax to set
	 */
	public void setConsume_tax(String consume_tax) {
		this.consume_tax = consume_tax;
	}

	/**
	 * @return the shipping_cost
	 */
	public String getShipping_cost() {
		return shipping_cost;
	}

	/**
	 * @param shipping_cost the shipping_cost to set
	 */
	public void setShipping_cost(String shipping_cost) {
		this.shipping_cost = shipping_cost;
	}

	/**
	 * @return the substitute_cost
	 */
	public String getSubstitute_cost() {
		return substitute_cost;
	}

	/**
	 * @param substitute_cost the substitute_cost to set
	 */
	public void setSubstitute_cost(String substitute_cost) {
		this.substitute_cost = substitute_cost;
	}

	/**
	 * @return the billing_amt
	 */
	public String getBilling_amt() {
		return billing_amt;
	}

	/**
	 * @param billing_amt the billing_amt to set
	 */
	public void setBilling_amt(String billing_amt) {
		this.billing_amt = billing_amt;
	}

	/**
	 * @return the total_amt
	 */
	public String getTotal_amt() {
		return total_amt;
	}

	/**
	 * @param total_amt the total_amt to set
	 */
	public void setTotal_amt(String total_amt) {
		this.total_amt = total_amt;
	}

	/**
	 * @return the enclosed_id
	 */
	public String getEnclosed_id() {
		return enclosed_id;
	}

	/**
	 * @param enclosed_id the enclosed_id to set
	 */
	public void setEnclosed_id(String enclosed_id) {
		this.enclosed_id = enclosed_id;
	}

	/**
	 * @return the enclosed_status
	 */
	public String getEnclosed_status() {
		return enclosed_status;
	}

	/**
	 * @param enclosed_status the enclosed_status to set
	 */
	public void setEnclosed_status(String enclosed_status) {
		this.enclosed_status = enclosed_status;
	}

	/**
	 * @return the enclosed_goods_total_amt
	 */
	public String getEnclosed_goods_total_amt() {
		return enclosed_goods_total_amt;
	}

	/**
	 * @param enclosed_goods_total_amt the enclosed_goods_total_amt to set
	 */
	public void setEnclosed_goods_total_amt(String enclosed_goods_total_amt) {
		this.enclosed_goods_total_amt = enclosed_goods_total_amt;
	}

	/**
	 * @return the enclosed_total_shipping
	 */
	public String getEnclosed_total_shipping() {
		return enclosed_total_shipping;
	}

	/**
	 * @param enclosed_total_shipping the enclosed_total_shipping to set
	 */
	public void setEnclosed_total_shipping(String enclosed_total_shipping) {
		this.enclosed_total_shipping = enclosed_total_shipping;
	}

	/**
	 * @return the enclosed_total_substitue
	 */
	public String getEnclosed_total_substitue() {
		return enclosed_total_substitue;
	}

	/**
	 * @param enclosed_total_substitue the enclosed_total_substitue to set
	 */
	public void setEnclosed_total_substitue(String enclosed_total_substitue) {
		this.enclosed_total_substitue = enclosed_total_substitue;
	}

	/**
	 * @return the enclosed_total_consume
	 */
	public String getEnclosed_total_consume() {
		return enclosed_total_consume;
	}

	/**
	 * @param enclosed_total_consume the enclosed_total_consume to set
	 */
	public void setEnclosed_total_consume(String enclosed_total_consume) {
		this.enclosed_total_consume = enclosed_total_consume;
	}

	/**
	 * @return the enclosed_billing_amt
	 */
	public String getEnclosed_billing_amt() {
		return enclosed_billing_amt;
	}

	/**
	 * @param enclosed_billing_amt the enclosed_billing_amt to set
	 */
	public void setEnclosed_billing_amt(String enclosed_billing_amt) {
		this.enclosed_billing_amt = enclosed_billing_amt;
	}

	/**
	 * @return the enclosed_total_amt
	 */
	public String getEnclosed_total_amt() {
		return enclosed_total_amt;
	}

	/**
	 * @param enclosed_total_amt the enclosed_total_amt to set
	 */
	public void setEnclosed_total_amt(String enclosed_total_amt) {
		this.enclosed_total_amt = enclosed_total_amt;
	}

	/**
	 * @return the enclosed_rbank_transfer_fee
	 */
	public String getEnclosed_rbank_transfer_fee() {
		return enclosed_rbank_transfer_fee;
	}

	/**
	 * @param enclosed_rbank_transfer_fee the enclosed_rbank_transfer_fee to set
	 */
	public void setEnclosed_rbank_transfer_fee(String enclosed_rbank_transfer_fee) {
		this.enclosed_rbank_transfer_fee = enclosed_rbank_transfer_fee;
	}

	/**
	 * @return the enclosed_total_point_usage
	 */
	public String getEnclosed_total_point_usage() {
		return enclosed_total_point_usage;
	}

	/**
	 * @param enclosed_total_point_usage the enclosed_total_point_usage to set
	 */
	public void setEnclosed_total_point_usage(String enclosed_total_point_usage) {
		this.enclosed_total_point_usage = enclosed_total_point_usage;
	}

	/**
	 * @return the main_flag
	 */
	public String getMain_flag() {
		return main_flag;
	}

	/**
	 * @param main_flag the main_flag to set
	 */
	public void setMain_flag(String main_flag) {
		this.main_flag = main_flag;
	}

	/**
	 * @return the order_date
	 */
	public String getOrder_date() {
		return order_date;
	}

	/**
	 * @param order_date the order_date to set
	 */
	public void setOrder_date(String order_date) {
		this.order_date = order_date;
	}

	/**
	 * @return the order_time
	 */
	public String getOrder_time() {
		return order_time;
	}

	/**
	 * @param order_time the order_time to set
	 */
	public void setOrder_time(String order_time) {
		this.order_time = order_time;
	}

	/**
	 * @return the mobile_carrier_payment_no
	 */
	public String getMobile_carrier_payment_no() {
		return mobile_carrier_payment_no;
	}

	/**
	 * @param mobile_carrier_payment_no the mobile_carrier_payment_no to set
	 */
	public void setMobile_carrier_payment_no(String mobile_carrier_payment_no) {
		this.mobile_carrier_payment_no = mobile_carrier_payment_no;
	}

	/**
	 * @return the purchase_hist_mod_type
	 */
	public String getPurchase_hist_mod_type() {
		return purchase_hist_mod_type;
	}

	/**
	 * @param purchase_hist_mod_type the purchase_hist_mod_type to set
	 */
	public void setPurchase_hist_mod_type(String purchase_hist_mod_type) {
		this.purchase_hist_mod_type = purchase_hist_mod_type;
	}

	/**
	 * @return the purchase_hist_mod_icon
	 */
	public String getPurchase_hist_mod_icon() {
		return purchase_hist_mod_icon;
	}

	/**
	 * @param purchase_hist_mod_icon the purchase_hist_mod_icon to set
	 */
	public void setPurchase_hist_mod_icon(String purchase_hist_mod_icon) {
		this.purchase_hist_mod_icon = purchase_hist_mod_icon;
	}

	/**
	 * @return the purchase_hist_mod_prompt_mail
	 */
	public String getPurchase_hist_mod_prompt_mail() {
		return purchase_hist_mod_prompt_mail;
	}

	/**
	 * @param purchase_hist_mod_prompt_mail the purchase_hist_mod_prompt_mail to set
	 */
	public void setPurchase_hist_mod_prompt_mail(String purchase_hist_mod_prompt_mail) {
		this.purchase_hist_mod_prompt_mail = purchase_hist_mod_prompt_mail;
	}

	/**
	 * @return the destination_match_flag
	 */
	public String getDestination_match_flag() {
		return destination_match_flag;
	}

	/**
	 * @param destination_match_flag the destination_match_flag to set
	 */
	public void setDestination_match_flag(String destination_match_flag) {
		this.destination_match_flag = destination_match_flag;
	}

	/**
	 * @return the point_usage
	 */
	public String getPoint_usage() {
		return point_usage;
	}

	/**
	 * @param point_usage the point_usage to set
	 */
	public void setPoint_usage(String point_usage) {
		this.point_usage = point_usage;
	}

	/**
	 * @return the order_post_no1
	 */
	public String getOrder_post_no1() {
		return order_post_no1;
	}

	/**
	 * @param order_post_no1 the order_post_no1 to set
	 */
	public void setOrder_post_no1(String order_post_no1) {
		this.order_post_no1 = order_post_no1;
	}

	/**
	 * @return the order_post_no2
	 */
	public String getOrder_post_no2() {
		return order_post_no2;
	}

	/**
	 * @param order_post_no2 the order_post_no2 to set
	 */
	public void setOrder_post_no2(String order_post_no2) {
		this.order_post_no2 = order_post_no2;
	}

	/**
	 * @return the order_address1
	 */
	public String getOrder_address1() {
		return order_address1;
	}

	/**
	 * @param order_address1 the order_address1 to set
	 */
	public void setOrder_address1(String order_address1) {
		this.order_address1 = order_address1;
	}

	/**
	 * @return the order_address2
	 */
	public String getOrder_address2() {
		return order_address2;
	}

	/**
	 * @param order_address2 the order_address2 to set
	 */
	public void setOrder_address2(String order_address2) {
		this.order_address2 = order_address2;
	}

	/**
	 * @return the order_address3
	 */
	public String getOrder_address3() {
		return order_address3;
	}

	/**
	 * @param order_address3 the order_address3 to set
	 */
	public void setOrder_address3(String order_address3) {
		this.order_address3 = order_address3;
	}

	/**
	 * @return the order_surname
	 */
	public String getOrder_surname() {
		return order_surname;
	}

	/**
	 * @param order_surname the order_surname to set
	 */
	public void setOrder_surname(String order_surname) {
		this.order_surname = order_surname;
	}

	/**
	 * @return the order_name
	 */
	public String getOrder_name() {
		return order_name;
	}

	/**
	 * @param order_name the order_name to set
	 */
	public void setOrder_name(String order_name) {
		this.order_name = order_name;
	}

	/**
	 * @return the order_surname_kana
	 */
	public String getOrder_surname_kana() {
		return order_surname_kana;
	}

	/**
	 * @param order_surname_kana the order_surname_kana to set
	 */
	public void setOrder_surname_kana(String order_surname_kana) {
		this.order_surname_kana = order_surname_kana;
	}

	/**
	 * @return the order_name_kana
	 */
	public String getOrder_name_kana() {
		return order_name_kana;
	}

	/**
	 * @param order_name_kana the order_name_kana to set
	 */
	public void setOrder_name_kana(String order_name_kana) {
		this.order_name_kana = order_name_kana;
	}

	/**
	 * @return the order_tel1
	 */
	public String getOrder_tel1() {
		return order_tel1;
	}

	/**
	 * @param order_tel1 the order_tel1 to set
	 */
	public void setOrder_tel1(String order_tel1) {
		this.order_tel1 = order_tel1;
	}

	/**
	 * @return the order_tel2
	 */
	public String getOrder_tel2() {
		return order_tel2;
	}

	/**
	 * @param order_tel2 the order_tel2 to set
	 */
	public void setOrder_tel2(String order_tel2) {
		this.order_tel2 = order_tel2;
	}

	/**
	 * @return the order_tel3
	 */
	public String getOrder_tel3() {
		return order_tel3;
	}

	/**
	 * @param order_tel3 the order_tel3 to set
	 */
	public void setOrder_tel3(String order_tel3) {
		this.order_tel3 = order_tel3;
	}

	/**
	 * @return the mail_address
	 */
	public String getMail_address() {
		return mail_address;
	}

	/**
	 * @param mail_address the mail_address to set
	 */
	public void setMail_address(String mail_address) {
		this.mail_address = mail_address;
	}

	/**
	 * @return the order_sex
	 */
	public String getOrder_sex() {
		return order_sex;
	}

	/**
	 * @param order_sex the order_sex to set
	 */
	public void setOrder_sex(String order_sex) {
		this.order_sex = order_sex;
	}

	/**
	 * @return the order_birth
	 */
	public String getOrder_birth() {
		return order_birth;
	}

	/**
	 * @param order_birth the order_birth to set
	 */
	public void setOrder_birth(String order_birth) {
		this.order_birth = order_birth;
	}

	/**
	 * @return the payment_method
	 */
	public String getPayment_method() {
		return payment_method;
	}

	/**
	 * @param payment_method the payment_method to set
	 */
	public void setPayment_method(String payment_method) {
		this.payment_method = payment_method;
	}

	/**
	 * @return the credit_type
	 */
	public String getCredit_type() {
		return credit_type;
	}

	/**
	 * @param credit_type the credit_type to set
	 */
	public void setCredit_type(String credit_type) {
		this.credit_type = credit_type;
	}

	/**
	 * @return the credit_no
	 */
	public String getCredit_no() {
		return credit_no;
	}

	/**
	 * @param credit_no the credit_no to set
	 */
	public void setCredit_no(String credit_no) {
		this.credit_no = credit_no;
	}

	/**
	 * @return the credit_user
	 */
	public String getCredit_user() {
		return credit_user;
	}

	/**
	 * @param credit_user the credit_user to set
	 */
	public void setCredit_user(String credit_user) {
		this.credit_user = credit_user;
	}

	/**
	 * @return the credit_expire
	 */
	public String getCredit_expire() {
		return credit_expire;
	}

	/**
	 * @param credit_expire the credit_expire to set
	 */
	public void setCredit_expire(String credit_expire) {
		this.credit_expire = credit_expire;
	}

	/**
	 * @return the credit_installment
	 */
	public String getCredit_installment() {
		return credit_installment;
	}

	/**
	 * @param credit_installment the credit_installment to set
	 */
	public void setCredit_installment(String credit_installment) {
		this.credit_installment = credit_installment;
	}

	/**
	 * @return the credit_installment_note
	 */
	public String getCredit_installment_note() {
		return credit_installment_note;
	}

	/**
	 * @param credit_installment_note the credit_installment_note to set
	 */
	public void setCredit_installment_note(String credit_installment_note) {
		this.credit_installment_note = credit_installment_note;
	}

	/**
	 * @return the delivery_method
	 */
	public String getDelivery_method() {
		return delivery_method;
	}

	/**
	 * @param delivery_method the delivery_method to set
	 */
	public void setDelivery_method(String delivery_method) {
		this.delivery_method = delivery_method;
	}

	/**
	 * @return the delivery_type
	 */
	public String getDelivery_type() {
		return delivery_type;
	}

	/**
	 * @param delivery_type the delivery_type to set
	 */
	public void setDelivery_type(String delivery_type) {
		this.delivery_type = delivery_type;
	}

	/**
	 * @return the point_usage_person
	 */
	public String getPoint_usage_person() {
		return point_usage_person;
	}

	/**
	 * @param point_usage_person the point_usage_person to set
	 */
	public void setPoint_usage_person(String point_usage_person) {
		this.point_usage_person = point_usage_person;
	}

	/**
	 * @return the point_usage_condition
	 */
	public String getPoint_usage_condition() {
		return point_usage_condition;
	}

	/**
	 * @param point_usage_condition the point_usage_condition to set
	 */
	public void setPoint_usage_condition(String point_usage_condition) {
		this.point_usage_condition = point_usage_condition;
	}

	/**
	 * @return the point_status
	 */
	public String getPoint_status() {
		return point_status;
	}

	/**
	 * @param point_status the point_status to set
	 */
	public void setPoint_status(String point_status) {
		this.point_status = point_status;
	}

	/**
	 * @return the rbank_payment_status
	 */
	public String getRbank_payment_status() {
		return rbank_payment_status;
	}

	/**
	 * @param rbank_payment_status the rbank_payment_status to set
	 */
	public void setRbank_payment_status(String rbank_payment_status) {
		this.rbank_payment_status = rbank_payment_status;
	}

	/**
	 * @return the rbank_payment_transfer_fee
	 */
	public String getRbank_payment_transfer_fee() {
		return rbank_payment_transfer_fee;
	}

	/**
	 * @param rbank_payment_transfer_fee the rbank_payment_transfer_fee to set
	 */
	public void setRbank_payment_transfer_fee(String rbank_payment_transfer_fee) {
		this.rbank_payment_transfer_fee = rbank_payment_transfer_fee;
	}

	/**
	 * @return the rbank_patment_fee
	 */
	public String getRbank_patment_fee() {
		return rbank_patment_fee;
	}

	/**
	 * @param rbank_patment_fee the rbank_patment_fee to set
	 */
	public void setRbank_patment_fee(String rbank_patment_fee) {
		this.rbank_patment_fee = rbank_patment_fee;
	}

	/**
	 * @return the wrap_paper_title
	 */
	public String getWrap_paper_title() {
		return wrap_paper_title;
	}

	/**
	 * @param wrap_paper_title the wrap_paper_title to set
	 */
	public void setWrap_paper_title(String wrap_paper_title) {
		this.wrap_paper_title = wrap_paper_title;
	}

	/**
	 * @return the wrap_paper_name
	 */
	public String getWrap_paper_name() {
		return wrap_paper_name;
	}

	/**
	 * @param wrap_paper_name the wrap_paper_name to set
	 */
	public void setWrap_paper_name(String wrap_paper_name) {
		this.wrap_paper_name = wrap_paper_name;
	}

	/**
	 * @return the wrap_paper_fee
	 */
	public String getWrap_paper_fee() {
		return wrap_paper_fee;
	}

	/**
	 * @param wrap_paper_fee the wrap_paper_fee to set
	 */
	public void setWrap_paper_fee(String wrap_paper_fee) {
		this.wrap_paper_fee = wrap_paper_fee;
	}

	/**
	 * @return the wrap_paper_tax_include
	 */
	public String getWrap_paper_tax_include() {
		return wrap_paper_tax_include;
	}

	/**
	 * @param wrap_paper_tax_include the wrap_paper_tax_include to set
	 */
	public void setWrap_paper_tax_include(String wrap_paper_tax_include) {
		this.wrap_paper_tax_include = wrap_paper_tax_include;
	}

	/**
	 * @return the wrap_ribbon_title
	 */
	public String getWrap_ribbon_title() {
		return wrap_ribbon_title;
	}

	/**
	 * @param wrap_ribbon_title the wrap_ribbon_title to set
	 */
	public void setWrap_ribbon_title(String wrap_ribbon_title) {
		this.wrap_ribbon_title = wrap_ribbon_title;
	}

	/**
	 * @return the wrap_ribbon_name
	 */
	public String getWrap_ribbon_name() {
		return wrap_ribbon_name;
	}

	/**
	 * @param wrap_ribbon_name the wrap_ribbon_name to set
	 */
	public void setWrap_ribbon_name(String wrap_ribbon_name) {
		this.wrap_ribbon_name = wrap_ribbon_name;
	}

	/**
	 * @return the wrap_ribbon_fee
	 */
	public String getWrap_ribbon_fee() {
		return wrap_ribbon_fee;
	}

	/**
	 * @param wrap_ribbon_fee the wrap_ribbon_fee to set
	 */
	public void setWrap_ribbon_fee(String wrap_ribbon_fee) {
		this.wrap_ribbon_fee = wrap_ribbon_fee;
	}

	/**
	 * @return the wrap_ribbon_tax_include
	 */
	public String getWrap_ribbon_tax_include() {
		return wrap_ribbon_tax_include;
	}

	/**
	 * @param wrap_ribbon_tax_include the wrap_ribbon_tax_include to set
	 */
	public void setWrap_ribbon_tax_include(String wrap_ribbon_tax_include) {
		this.wrap_ribbon_tax_include = wrap_ribbon_tax_include;
	}

	/**
	 * @return the delivery_cost
	 */
	public String getDelivery_cost() {
		return delivery_cost;
	}

	/**
	 * @param delivery_cost the delivery_cost to set
	 */
	public void setDelivery_cost(String delivery_cost) {
		this.delivery_cost = delivery_cost;
	}

	/**
	 * @return the delivery_substitute_cost
	 */
	public String getDelivery_substitute_cost() {
		return delivery_substitute_cost;
	}

	/**
	 * @param delivery_substitute_cost the delivery_substitute_cost to set
	 */
	public void setDelivery_substitute_cost(String delivery_substitute_cost) {
		this.delivery_substitute_cost = delivery_substitute_cost;
	}

	/**
	 * @return the delivery_consume
	 */
	public String getDelivery_consume() {
		return delivery_consume;
	}

	/**
	 * @param delivery_consume the delivery_consume to set
	 */
	public void setDelivery_consume(String delivery_consume) {
		this.delivery_consume = delivery_consume;
	}

	/**
	 * @return the baggage_claim_no
	 */
	public String getBaggage_claim_no() {
		return baggage_claim_no;
	}

	/**
	 * @param baggage_claim_no the baggage_claim_no to set
	 */
	public void setBaggage_claim_no(String baggage_claim_no) {
		this.baggage_claim_no = baggage_claim_no;
	}

	/**
	 * @return the delivery_goods_total_amt
	 */
	public String getDelivery_goods_total_amt() {
		return delivery_goods_total_amt;
	}

	/**
	 * @param delivery_goods_total_amt the delivery_goods_total_amt to set
	 */
	public void setDelivery_goods_total_amt(String delivery_goods_total_amt) {
		this.delivery_goods_total_amt = delivery_goods_total_amt;
	}

	/**
	 * @return the indicates
	 */
	public String getIndicates() {
		return indicates;
	}

	/**
	 * @param indicates the indicates to set
	 */
	public void setIndicates(String indicates) {
		this.indicates = indicates;
	}

	/**
	 * @return the delivery_post_no1
	 */
	public String getDelivery_post_no1() {
		return delivery_post_no1;
	}

	/**
	 * @param delivery_post_no1 the delivery_post_no1 to set
	 */
	public void setDelivery_post_no1(String delivery_post_no1) {
		this.delivery_post_no1 = delivery_post_no1;
	}

	/**
	 * @return the delivery_post_no2
	 */
	public String getDelivery_post_no2() {
		return delivery_post_no2;
	}

	/**
	 * @param delivery_post_no2 the delivery_post_no2 to set
	 */
	public void setDelivery_post_no2(String delivery_post_no2) {
		this.delivery_post_no2 = delivery_post_no2;
	}

	/**
	 * @return the delivery_address1
	 */
	public String getDelivery_address1() {
		return delivery_address1;
	}

	/**
	 * @param delivery_address1 the delivery_address1 to set
	 */
	public void setDelivery_address1(String delivery_address1) {
		this.delivery_address1 = delivery_address1;
	}

	/**
	 * @return the delivery_address2
	 */
	public String getDelivery_address2() {
		return delivery_address2;
	}

	/**
	 * @param delivery_address2 the delivery_address2 to set
	 */
	public void setDelivery_address2(String delivery_address2) {
		this.delivery_address2 = delivery_address2;
	}

	/**
	 * @return the delivery_address3
	 */
	public String getDelivery_address3() {
		return delivery_address3;
	}

	/**
	 * @param delivery_address3 the delivery_address3 to set
	 */
	public void setDelivery_address3(String delivery_address3) {
		this.delivery_address3 = delivery_address3;
	}

	/**
	 * @return the delivery_surname
	 */
	public String getDelivery_surname() {
		return delivery_surname;
	}

	/**
	 * @param delivery_surname the delivery_surname to set
	 */
	public void setDelivery_surname(String delivery_surname) {
		this.delivery_surname = delivery_surname;
	}

	/**
	 * @return the delivery_name
	 */
	public String getDelivery_name() {
		return delivery_name;
	}

	/**
	 * @param delivery_name the delivery_name to set
	 */
	public void setDelivery_name(String delivery_name) {
		this.delivery_name = delivery_name;
	}

	/**
	 * @return the delivery_surname_kana
	 */
	public String getDelivery_surname_kana() {
		return delivery_surname_kana;
	}

	/**
	 * @param delivery_surname_kana the delivery_surname_kana to set
	 */
	public void setDelivery_surname_kana(String delivery_surname_kana) {
		this.delivery_surname_kana = delivery_surname_kana;
	}

	/**
	 * @return the delivery_name_kana
	 */
	public String getDelivery_name_kana() {
		return delivery_name_kana;
	}

	/**
	 * @param delivery_name_kana the delivery_name_kana to set
	 */
	public void setDelivery_name_kana(String delivery_name_kana) {
		this.delivery_name_kana = delivery_name_kana;
	}

	/**
	 * @return the delivery_tel1
	 */
	public String getDelivery_tel1() {
		return delivery_tel1;
	}

	/**
	 * @param delivery_tel1 the delivery_tel1 to set
	 */
	public void setDelivery_tel1(String delivery_tel1) {
		this.delivery_tel1 = delivery_tel1;
	}

	/**
	 * @return the delivery_tel2
	 */
	public String getDelivery_tel2() {
		return delivery_tel2;
	}

	/**
	 * @param delivery_tel2 the delivery_tel2 to set
	 */
	public void setDelivery_tel2(String delivery_tel2) {
		this.delivery_tel2 = delivery_tel2;
	}

	/**
	 * @return the delivery_tel3
	 */
	public String getDelivery_tel3() {
		return delivery_tel3;
	}

	/**
	 * @param delivery_tel3 the delivery_tel3 to set
	 */
	public void setDelivery_tel3(String delivery_tel3) {
		this.delivery_tel3 = delivery_tel3;
	}

	/**
	 * @return the product_id
	 */
	public String getProduct_id() {
		return product_id;
	}

	/**
	 * @param product_id the product_id to set
	 */
	public void setProduct_id(String product_id) {
		this.product_id = product_id;
	}

	/**
	 * @return the product_name
	 */
	public String getProduct_name() {
		return product_name;
	}

	/**
	 * @param product_name the product_name to set
	 */
	public void setProduct_name(String product_name) {
		// 상품명 및 옵션에 대하여 trim추가
		this.product_name = product_name.trim();
	}

	/**
	 * @return the product_no
	 */
	public String getProduct_no() {
		return product_no;
	}

	/**
	 * @param product_no the product_no to set
	 */
	public void setProduct_no(String product_no) {
		this.product_no = product_no;
	}

	/**
	 * @return the product_url
	 */
	public String getProduct_url() {
		return product_url;
	}

	/**
	 * @param product_url the product_url to set
	 */
	public void setProduct_url(String product_url) {
		this.product_url = product_url;
	}

	/**
	 * @return the unit_price
	 */
	public String getUnit_price() {
		return unit_price;
	}

	/**
	 * @param unit_price the unit_price to set
	 */
	public void setUnit_price(String unit_price) {
		this.unit_price = unit_price;
	}

	/**
	 * @return the unit_no
	 */
	public String getUnit_no() {
		return unit_no;
	}

	/**
	 * @param unit_no the unit_no to set
	 */
	public void setUnit_no(String unit_no) {
		this.unit_no = unit_no;
	}

	/**
	 * @return the delivery_cost_include
	 */
	public String getDelivery_cost_include() {
		return delivery_cost_include;
	}

	/**
	 * @param delivery_cost_include the delivery_cost_include to set
	 */
	public void setDelivery_cost_include(String delivery_cost_include) {
		this.delivery_cost_include = delivery_cost_include;
	}

	/**
	 * @return the tax_exclude
	 */
	public String getTax_exclude() {
		return tax_exclude;
	}

	/**
	 * @param tax_exclude the tax_exclude to set
	 */
	public void setTax_exclude(String tax_exclude) {
		this.tax_exclude = tax_exclude;
	}

	/**
	 * @return the substitute_fee_include
	 */
	public String getSubstitute_fee_include() {
		return substitute_fee_include;
	}

	/**
	 * @param substitute_fee_include the substitute_fee_include to set
	 */
	public void setSubstitute_fee_include(String substitute_fee_include) {
		this.substitute_fee_include = substitute_fee_include;
	}

	/**
	 * @return the product_option
	 */
	public String getProduct_option() {
		return product_option;
	}

	/**
	 * @param product_option the product_option to set
	 */
	public void setProduct_option(String product_option) {
		// 상품명 및 옵션에 대하여 trim추가
		this.product_option = product_option.trim();
	}

	/**
	 * @return the point_percent
	 */
	public String getPoint_percent() {
		return point_percent;
	}

	/**
	 * @param point_percent the point_percent to set
	 */
	public void setPoint_percent(String point_percent) {
		this.point_percent = point_percent;
	}

	/**
	 * @return the point_type
	 */
	public String getPoint_type() {
		return point_type;
	}

	/**
	 * @param point_type the point_type to set
	 */
	public void setPoint_type(String point_type) {
		this.point_type = point_type;
	}

	/**
	 * @return the record_no
	 */
	public String getRecord_no() {
		return record_no;
	}

	/**
	 * @param record_no the record_no to set
	 */
	public void setRecord_no(String record_no) {
		this.record_no = record_no;
	}

	/**
	 * @return the delivery_info
	 */
	public String getDelivery_info() {
		return delivery_info;
	}

	/**
	 * @param delivery_info the delivery_info to set
	 */
	public void setDelivery_info(String delivery_info) {
		this.delivery_info = delivery_info;
	}

	/**
	 * @return the inventory_type
	 */
	public String getInventory_type() {
		return inventory_type;
	}

	/**
	 * @param inventory_type the inventory_type to set
	 */
	public void setInventory_type(String inventory_type) {
		this.inventory_type = inventory_type;
	}

	/**
	 * @return the wrap_type_paper
	 */
	public String getWrap_type_paper() {
		return wrap_type_paper;
	}

	/**
	 * @param wrap_type_paper the wrap_type_paper to set
	 */
	public void setWrap_type_paper(String wrap_type_paper) {
		this.wrap_type_paper = wrap_type_paper;
	}

	/**
	 * @return the wrap_type_ribbon
	 */
	public String getWrap_type_ribbon() {
		return wrap_type_ribbon;
	}

	/**
	 * @param wrap_type_ribbon the wrap_type_ribbon to set
	 */
	public void setWrap_type_ribbon(String wrap_type_ribbon) {
		this.wrap_type_ribbon = wrap_type_ribbon;
	}

	/**
	 * @return the tomorrow_hope
	 */
	public String getTomorrow_hope() {
		return tomorrow_hope;
	}

	/**
	 * @param tomorrow_hope the tomorrow_hope to set
	 */
	public void setTomorrow_hope(String tomorrow_hope) {
		this.tomorrow_hope = tomorrow_hope;
	}

	/**
	 * @return the coupon_usage
	 */
	public String getCoupon_usage() {
		return coupon_usage;
	}

	/**
	 * @param coupon_usage the coupon_usage to set
	 */
	public void setCoupon_usage(String coupon_usage) {
		this.coupon_usage = coupon_usage;
	}

	/**
	 * @return the store_coupon_usage
	 */
	public String getStore_coupon_usage() {
		return store_coupon_usage;
	}

	/**
	 * @param store_coupon_usage the store_coupon_usage to set
	 */
	public void setStore_coupon_usage(String store_coupon_usage) {
		this.store_coupon_usage = store_coupon_usage;
	}

	/**
	 * @return the rcoupon_usage
	 */
	public String getRcoupon_usage() {
		return rcoupon_usage;
	}

	/**
	 * @param rcoupon_usage the rcoupon_usage to set
	 */
	public void setRcoupon_usage(String rcoupon_usage) {
		this.rcoupon_usage = rcoupon_usage;
	}

	/**
	 * @return the enclose_coupon_usage
	 */
	public String getEnclose_coupon_usage() {
		return enclose_coupon_usage;
	}

	/**
	 * @param enclose_coupon_usage the enclose_coupon_usage to set
	 */
	public void setEnclose_coupon_usage(String enclose_coupon_usage) {
		this.enclose_coupon_usage = enclose_coupon_usage;
	}

	/**
	 * @return the delivery_company
	 */
	public String getDelivery_company() {
		return delivery_company;
	}

	/**
	 * @param delivery_company the delivery_company to set
	 */
	public void setDelivery_company(String delivery_company) {
		this.delivery_company = delivery_company;
	}

	/**
	 * @return the pharm_flag
	 */
	public String getPharm_flag() {
		return pharm_flag;
	}

	/**
	 * @param pharm_flag the pharm_flag to set
	 */
	public void setPharm_flag(String pharm_flag) {
		this.pharm_flag = pharm_flag;
	}

	/**
	 * @return the rakuten_super_deal
	 */
	public String getRakuten_super_deal() {
		return rakuten_super_deal;
	}

	/**
	 * @param rakuten_super_deal the rakuten_super_deal to set
	 */
	public void setRakuten_super_deal(String rakuten_super_deal) {
		this.rakuten_super_deal = rakuten_super_deal;
	}

	/**
	 * @return the membership_program
	 */
	public String getMembership_program() {
		return membership_program;
	}

	/**
	 * @param membership_program the membership_program to set
	 */
	public void setMembership_program(String membership_program) {
		this.membership_program = membership_program;
	}
	
}
