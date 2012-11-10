/*
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS HEADER.
 *
 * Copyright (c) 2012 Oracle and/or its affiliates. All rights reserved.
 *
 * The contents of this file are subject to the terms of either the GNU
 * General Public License Version 2 only ("GPL") or the Common Development
 * and Distribution License("CDDL") (collectively, the "License").  You
 * may not use this file except in compliance with the License.  You can
 * obtain a copy of the License at
 * http://glassfish.java.net/public/CDDL+GPL_1_1.html
 * or packager/legal/LICENSE.txt.  See the License for the specific
 * language governing permissions and limitations under the License.
 *
 * When distributing the software, include this License Header Notice in each
 * file and include the License file at packager/legal/LICENSE.txt.
 *
 * GPL Classpath Exception:
 * Oracle designates this particular file as subject to the "Classpath"
 * exception as provided by Oracle in the GPL Version 2 section of the License
 * file that accompanied this code.
 *
 * Modifications:
 * If applicable, add the following below the License Header, with the fields
 * enclosed by brackets [] replaced by your own identifying information:
 * "Portions Copyright [year] [name of copyright owner]"
 *
 * Contributor(s):
 * If you wish your version of this file to be governed by only the CDDL or
 * only the GPL Version 2, indicate your decision by adding "[Contributor]
 * elects to include this software in this distribution under the [CDDL or GPL
 * Version 2] license."  If you don't indicate a single choice of license, a
 * recipient has the option to distribute your version of this file under
 * either the CDDL, the GPL Version 2 or to extend the choice of license to
 * its licensees as provided above.  However, if you add GPL Version 2 code
 * and therefore, elected the GPL Version 2 license, then the option applies
 * only if the new code is made subject to such option by the copyright
 * holder.
 */
package javax.websocket;

/**
 * The Web Socket Endpoint represents an object that can handle a web socket conversations. When
 * deployed as a server endpoint, that is to say, the endpoint is registered to a URL, the server instantiates
 * a new endpoint instance for each client connection. If
 * deployed as a client, the endpoint will be instantiated once per single connection to the server.
 * If the endpoint is a server which will cater to multiple clients, each endpoint instance corresponding to each active client
 * is called by no more than one thread at a time. This means that when implementing/overriding the methods
 * of Endpoint, the developer is guaranteed that there will be at most one thread in each endpoint instance.
 *
 * @since DRAFT 001
 * @author dannycoward
 */
public abstract class Endpoint {
    
    /** Developers must provide an EndpointConfiguration so that
     * the container it is deployed in can configure it.
     * @return an EndpointConfiguration used to configure the Endpoint
     */
    public abstract EndpointConfiguration getEndpointConfiguration();
    /** Developers must implement this method to be notified when a new conversation has
     * just begun.
     * @param session
     */
    public abstract void onOpen(Session session);
    /** This method is called when the session with the client is terminated.
     * @param session
     */
    public void onClose(CloseReason closeReason) {}

    /** Developers may implement this method when the web socket session
     * creates some kind of error that is not modeled in the web socket protocol. This may for example
     * be a notification that an incoming message is too big to handle, or that the incoming message could not be encoded.<br><br>
     * There are a number of categories of exception that this method is (currently) defined to handle:-<br>
     * - connection problems, for example, a socket failure that occurs before the web socket connection can be formally closed.<br>
     * - errors thrown by developer create message handlers calls.<br>
     * - conversion errors encoding incoming messages before any message handler has been called.<br>
     * TBD We may come up with less of a 'catch-all' mechanism for handling exceptions, especially given the varying nature
     * of these categories of exception.
     */

    public void onError(Throwable thr) {}



}
