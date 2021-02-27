import java.util.List;

public class Generics {

    public long beforeGenerics(List accounts) {
        long sum = 0;

        for (Object account : accounts) {
            // have to do check to prevent ClassCastException in runtime
            if (account instanceof Account) {
                sum += ((Account) account).getAmount();
            }
        }

        return sum;
    }

    // with generics we can't pass wrong type - compile time error
    public long withGenerics(List<Account> accounts) {
        long sum = 0;

        for (Account account : accounts) {
            sum += account.getAmount();
        }

        return sum;
    }

    // for example
    private class Account {
        private long amount;

        public long getAmount() {
            return amount;
        }
    }

}
