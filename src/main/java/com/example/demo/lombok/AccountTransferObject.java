package com.example.demo.lombok;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

/**
 * SVB ACH Transfer Object.
 *
 * See <a href="https://www.svb.com/developers/ach">SVB Documentation</a> for additional information.
 *
 * *** Property level comments are from SVB docs
 */
@Getter
@Setter
@Builder
public class AccountTransferObject {


    private int id;

    /**
     * SVB bank account number originating the ACH transfer.
     * Only accounts that have been explicitly enabled for API access may be passed here.
     */

    private String accountNumber;

    /**
     * Amount of money to transfer, specified in cents. Setting amount equal to zero will cause this to be a
     * pre-notification transaction.
     */

    private Integer amount;

    /**
     * A unique ID indicating the batch this transfer was sent with. Can be used to reconcile with your SVB bank
     * statements. Will be null until the transfer reaches processing status
     */
    private String batchId;

}



















