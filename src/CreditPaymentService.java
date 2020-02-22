public class CreditPaymentService {
    public long calculate(int amount, double percent, int term) {
        // формула аннуитетного платежа P = S * ( i + i / ((1+i)^n - 1) )
        // где P - ежемесячный платеж
        // S - сумма кредита
        // i - ежемесячная процентная ставка (годовая ставка/100/12)
        // n - срок кредита в месяцах
        // будем считать по действиям
        double monthlyCreditPercentInBasisPoint = percent / 100 / 12; // ежемесячная процентная ставка в базисных пунктах
        double first = 1 + monthlyCreditPercentInBasisPoint; // высчитали 1+i
        double second = Math.pow(first, term); // возвели 1+i в степень n
        double third = second - 1; // посчитали (1+i)^n - 1
        double fourth = monthlyCreditPercentInBasisPoint / third; // высчитали i / ((1+i)^n -1))
        double fifth = monthlyCreditPercentInBasisPoint + fourth; // посчитали все что в скобках
        long monthlyPayment = (long) (amount * fifth); // вычисляем ежемесячный платеж
        return monthlyPayment;
    }
}
