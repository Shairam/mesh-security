/*
 * Copyright (c) 2018, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
 *
 * WSO2 Inc. licenses this file to you under the Apache License,
 * Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations
 * under the License.
 *
 */
package io.cellery.security.cell.sts.server.core.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import io.cellery.security.cell.sts.server.core.model.CellStsRequest;
import io.cellery.security.cell.sts.server.core.model.CellStsResponse;

/**
 * Intercepts Outbound calls from pods within the Cell.
 */
public class CelleryCellOutboundInterceptorService extends CelleryCellInterceptorService {

    private Logger log = LoggerFactory.getLogger(CelleryCellOutboundInterceptorService.class);

    public CelleryCellOutboundInterceptorService(CelleryCellStsService cellStsService) throws CelleryCellSTSException {
        super(cellStsService);
    }

    @Override
    protected void handleRequest(CellStsRequest cellStsRequest,
                                 CellStsResponse cellStsResponse) throws CelleryCellSTSException {

        log.debug("Intercepted Sidecar Outbound Request:\nSource:{}\nDestination:{}\n", cellStsRequest.getSource(),
                cellStsRequest.getDestination());
        cellStsService.handleOutboundRequest(cellStsRequest, cellStsResponse);
    }
}