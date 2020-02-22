public class Main {
    public static void main(String[] args) {
        CreditPaymentService service = new CreditPaymentService();
        int amountOfCredit = 1_000_000; // сумма кредита
        double creditPercentInBasisPoint = 9.99; // годовая процентная ставка в базисных пунктах
        int creditTermInMonths = 36; // срок кредита в месяцах
        long monthlyPayment = service.calculate(amountOfCredit, creditPercentInBasisPoint, creditTermInMonths);
        System.out.println(monthlyPayment);
    }
}
