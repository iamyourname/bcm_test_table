package bcm.app.model.agent02;


import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "B_OUTGOING",schema = "public")
public class Bout {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bout_id;
    private String bout_transactionid;
    private String bout_transactiondate;
    private Long codv_id;
    private Long bout_to_codv_id;
    private String bout_waybilldate;
    private String bout_waybillnumber;
    private String doc_status;

    public Long getBout_id() {
        return bout_id;
    }

    public void setBout_id(Long bout_id) {
        this.bout_id = bout_id;
    }

    public String getBout_transactionid() {
        return bout_transactionid;
    }

    public void setBout_transactionid(String bout_transactionid) {
        this.bout_transactionid = bout_transactionid;
    }

    public String getBout_transactiondate() {
        return bout_transactiondate;
    }

    public void setBout_transactiondate(String bout_transactiondate) {
        this.bout_transactiondate = bout_transactiondate;
    }

    public Long getCodv_id() {
        return codv_id;
    }

    public void setCodv_id(Long codv_id) {
        this.codv_id = codv_id;
    }

    public Long getBout_to_codv_id() {
        return bout_to_codv_id;
    }

    public void setBout_to_codv_id(Long bout_to_codv_id) {
        this.bout_to_codv_id = bout_to_codv_id;
    }

    public String getBout_waybilldate() {
        return bout_waybilldate;
    }

    public void setBout_waybilldate(String bout_waybilldate) {
        this.bout_waybilldate = bout_waybilldate;
    }

    public String getBout_waybillnumber() {
        return bout_waybillnumber;
    }

    public void setBout_waybillnumber(String bout_waybillnumber) {
        this.bout_waybillnumber = bout_waybillnumber;
    }

    public String getDoc_status() {
        return doc_status;
    }

    public void setDoc_status(String doc_status) {
        this.doc_status = doc_status;
    }
}
