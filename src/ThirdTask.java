import java.math.BigDecimal;

class Main{
    public static void main(String[] args) {
        BigDecimal amount = new BigDecimal("3495869234.23465");
        TaxType taxType = new ProgressiveTaxType();
        TaxService taxService = new TaxService();
        Bill bill = new Bill(amount, taxType, taxService);
        bill.payTaxes(taxType, bill.getAmount());
    }
}
class Bill{
    private BigDecimal amount;
    private TaxType taxType;
    private TaxService taxService;
    public Bill(BigDecimal amount, TaxType taxType, TaxService taxService){
        this.amount = amount;
        this.taxType = taxType;
        this.taxService = taxService;
    }
    public void payTaxes(TaxType taxType, BigDecimal totalMoney){
        BigDecimal taxAmount = taxType.calculateTaxFor(totalMoney);
        taxService.payOut(taxAmount);
    }
    public BigDecimal getAmount(){
        return amount;
    }
}
class TaxType{
    public BigDecimal calculateTaxFor(BigDecimal totalMoney){
        return new BigDecimal(0.0);
    }
}
class TaxService{
    public void payOut(BigDecimal amount){
        System.out.println("Уплачен налог в размере: " + amount);
    }
}
class IncomeTaxType extends TaxType{
    @Override
    public BigDecimal calculateTaxFor(BigDecimal amount){
        BigDecimal finalMoney;
        finalMoney = amount.multiply(new BigDecimal(13)).divide(new BigDecimal(100));
        return finalMoney;
    }
}
class VATaxType extends TaxType{
    @Override
    public BigDecimal calculateTaxFor(BigDecimal amount){
        BigDecimal finalMoney;
        finalMoney = amount.multiply(new BigDecimal(18)).divide(new BigDecimal(100));
        return finalMoney;
    }
}
class ProgressiveTaxType extends TaxType{
    @Override
    public BigDecimal calculateTaxFor(BigDecimal amount){
        BigDecimal finalMoney;
        if (amount.compareTo(new BigDecimal(100000)) < 0){
            finalMoney = amount.multiply(new BigDecimal(10)).divide(new BigDecimal(100));
            return finalMoney;
        }
        else{
            finalMoney = amount.multiply(new BigDecimal(15)).divide(new BigDecimal(100));
            return finalMoney;
        }
    }
}