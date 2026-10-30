package securedeal;

/**
 * The three stages a SecureDeal transaction can be in.
 */
public enum TransactionStatus {
    PENDING,   // deal created, item not sent yet
    SHIPPED,   // seller has sent the item
    RECEIVED   // buyer has the item
}
