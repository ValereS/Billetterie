/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exceptions;

import javax.ejb.ApplicationException;

/**
 *
 * @author cdi505
 */
@ApplicationException
public class CartError extends Exception {

    /**
     * Creates a new instance of <code>CartError</code> without detail message.
     */
    public CartError() {
    }

    /**
     * Constructs an instance of <code>CartError</code> with the specified
     * detail message.
     *
     * @param msg the detail message.
     */
    public CartError(String msg) {
        super(msg);
    }
}
