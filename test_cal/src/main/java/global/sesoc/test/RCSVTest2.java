package global.sesoc.test;

import com.opencsv.bean.CsvBindByPosition;

public class RCSVTest2 {
	/**受注番号*/
	@CsvBindByPosition(position=0)
	private String order_no;
	/**受注ステータス*/
	@CsvBindByPosition(position=1)
	private String order_status;
	/**お荷物伝票番号*/
	@CsvBindByPosition(position=3)
	private String baggage_claim_no;
	/**配送会社*/
	@CsvBindByPosition(position=4)
	private String delivery_company;
	/**処理番号*/
	@CsvBindByPosition(position=2)
	private String process_no;
	/**フリー項目01*/
	@CsvBindByPosition(position=5)
	private String free_space;
	
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
	 * @return the process_no
	 */
	public String getProcess_no() {
		return process_no;
	}
	/**
	 * @param process_no the process_no to set
	 */
	public void setProcess_no(String process_no) {
		this.process_no = process_no;
	}
	/**
	 * @return the free_space
	 */
	public String getFree_space() {
		return free_space;
	}
	/**
	 * @param free_space the free_space to set
	 */
	public void setFree_space(String free_space) {
		this.free_space = free_space;
	}
}
