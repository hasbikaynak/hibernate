package enum_types;

public class Test {
    public static void main(String[] args) {
benefitsOfEnumOverConstant();
    }

    private static void benefitsOfEnumOverConstant(){
         constantMethod(1);
         constantMethod(2);
         constantMethod(3);
         constantMethod(4);
         constantMethod(5);
//         constantMethod(6); // it will give run time error because it does not exist
        System.out.println("------------------------------------");
         enumMethod(TransactionType.DEPOSIT); // enum method gives compile time error, if we try to enter non-existing element into the method.
         enumMethod(TransactionType.WITHDRAW);
         enumMethod(TransactionType.OTHER);
         enumMethod(TransactionType.PAYMENT);
         enumMethod(TransactionType.TRANSFER);

        System.out.println("----------------------------");
        for (TransactionType tt: TransactionType.values()) { //we can get enum values by using foreach loop
            System.out.println("Enum value: " +tt.name());
        }

        System.out.println("---------------------");
        System.out.println("Position of PAYMENT: "+ TransactionType.PAYMENT.ordinal()); //ordinal() gives the position in the enum declaration


        System.out.println("-----------------------------");
        System.out.println("Transaction Code of the WITHDRAW "+ TransactionType.WITHDRAW.getTransactionCode());

        System.out.println("---------------------------------");

        for (TransactionType tt: TransactionType.values()
             ) {
            System.out.println(tt.getTransactionCode());
        }


    }

    private static void enumMethod(TransactionType tt){
        if (tt == TransactionType.DEPOSIT) {
            System.out.println("Money is depositing");
        } else if (tt == TransactionType.WITHDRAW) {
            System.out.println("Money is withdrawing");
        }else if (tt == TransactionType.OTHER) {
            System.out.println("Other Transaction");
        }else if (tt == TransactionType.TRANSFER) {
            System.out.println("Money is transferring");
        }else if (tt == TransactionType.PAYMENT) {
            System.out.println("Money is using for payment");
        }
    }

    private static void constantMethod(int i){
        if(i==TransactionTypeConstant.DEPOSIT){
            System.out.println("Money is depositing");
        }else if (i==TransactionTypeConstant.WITHDRAW){
            System.out.println("Money is withdrawing");
        }else if (i==TransactionTypeConstant.PAYMENT){
            System.out.println("Money is using for payment");
        }else if (i==TransactionTypeConstant.TRANSFER){
            System.out.println("Money is transferring");
        }else if (i==TransactionTypeConstant.OTHER){
            System.out.println("Other transaction");
        }
    }
}
