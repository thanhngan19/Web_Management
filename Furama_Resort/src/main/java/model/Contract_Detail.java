package model;

public class Contract_Detail {
    private int idContractDetail;
    private int quantity;
    private int idContract;
    private String bonusService;

    public Contract_Detail(int idContractDetail, int quantity, int idContract, String bonusService) {
        this.idContractDetail = idContractDetail;
        this.quantity = quantity;
        this.idContract = idContract;
        this.bonusService = bonusService;
    }

    public Contract_Detail(int quantity, int idContract, String bonusService) {
        this.quantity = quantity;
        this.idContract = idContract;
        this.bonusService = bonusService;
    }

    public int getIdContractDetail() {
        return idContractDetail;
    }

    public void setIdContractDetail(int idContractDetail) {
        this.idContractDetail = idContractDetail;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getIdContract() {
        return idContract;
    }

    public void setIdContract(int idContract) {
        this.idContract = idContract;
    }

    public String getBonusService() {
        return bonusService;
    }

    public void setBonusService(String bonusService) {
        this.bonusService = bonusService;
    }

    public Contract_Detail() {
    }
}
