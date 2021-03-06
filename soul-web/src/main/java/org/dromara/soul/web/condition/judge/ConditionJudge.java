/*
 *   Licensed to the Apache Software Foundation (ASF) under one or more
 *   contributor license agreements.  See the NOTICE file distributed with
 *   this work for additional information regarding copyright ownership.
 *   The ASF licenses this file to You under the Apache License, Version 2.0
 *   (the "License"); you may not use this file except in compliance with
 *   the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *   Unless required by applicable law or agreed to in writing, software
 *   distributed under the License is distributed on an "AS IS" BASIS,
 *   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *   See the License for the specific language governing permissions and
 *   limitations under the License.
 *
 */

package org.dromara.soul.web.condition.judge;

import org.apache.commons.lang3.StringUtils;
import org.dromara.soul.common.dto.zk.ConditionZkDTO;
import org.dromara.soul.common.enums.OperatorEnum;

import java.util.Objects;

/**
 * ConditionJudge.
 * @author xiaoyu(Myth)
 */
public class ConditionJudge {

    /**
     * judge this conditionZkDTO has by pass.
     *
     * @param conditionZkDTO  condition data
     * @param realData          realData
     * @return is true pass   is false not pass
     */
    public static Boolean judge(final ConditionZkDTO conditionZkDTO, final String realData) {
        if (Objects.isNull(conditionZkDTO) || StringUtils.isBlank(realData)) {
            return false;
        }
        if (Objects.equals(conditionZkDTO.getOperator(), OperatorEnum.EQ.getAlias())) {
            return Objects.equals(realData, conditionZkDTO.getParamValue().trim());
        } else if (Objects.equals(conditionZkDTO.getOperator(), OperatorEnum.MATCH.getAlias())) {
            return realData.contains(conditionZkDTO.getParamValue().trim());
        } else if (Objects.equals(conditionZkDTO.getOperator(), OperatorEnum.LIKE.getAlias())) {
            return realData.contains(conditionZkDTO.getParamValue().trim());
        }
        return false;
    }
}
