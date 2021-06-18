package j2ee.BusinessDelegatePattern;

public class BusinessLookUp {
    public BusinessService getBusinessService(String businessType) {
        if (businessType.equalsIgnoreCase("EJB")) {
            return new EJBService();
        } else {
            return new JMSService();
        }
    }
}
