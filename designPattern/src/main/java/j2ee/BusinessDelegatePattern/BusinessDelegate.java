package j2ee.BusinessDelegatePattern;

public class BusinessDelegate {
    private BusinessLookUp businessLookUp = new BusinessLookUp();
    private BusinessService businessService;
    private String businessType;

    public void setBusinessType(String businessType) {
        this.businessType = businessType;
    }

    public void doTask() {
        businessService = businessLookUp.getBusinessService(businessType);
        businessService.doProcessing();
    }
}
