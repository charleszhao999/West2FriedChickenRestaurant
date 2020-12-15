public class OverdraftBalanceException extends RuntimeException {
    public OverdraftBalanceException(double money) {
        System.out.println("余额不足，还需" + money + "元才能完成进货");
    }
}
