package com.usthe.sureness.processor.support;

import com.usthe.sureness.processor.BaseProcessor;
import com.usthe.sureness.processor.exception.SurenessAuthenticationException;
import com.usthe.sureness.processor.exception.SurenessAuthorizationException;
import com.usthe.sureness.processor.exception.UnauthorizedException;
import com.usthe.sureness.subject.SubjectAuToken;
import com.usthe.sureness.subject.support.NoneToken;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/** the processor support nonToken 处理非账户访问
 * @author tomsun28
 * @date 21:12 2019-05-26
 */
public class NoneProcessor extends BaseProcessor {

    /** 日志操作 **/
    private static final Logger logger = LoggerFactory.getLogger(NoneProcessor.class);

    @Override
    public boolean canSupportAuTokenClass(Class<?> var) {
        return var == NoneToken.class;
    }

    @Override
    public Class<?> getSupportAuTokenClass() {
        return NoneToken.class;
    }

    @Override
    public SubjectAuToken authenticated(SubjectAuToken var) throws SurenessAuthenticationException {
        return var;
    }

    @SuppressWarnings("unchecked")
    @Override
    public void authorized(SubjectAuToken var) throws SurenessAuthorizationException {
        List<String> supportRoles = (List<String>)var.getSupportRoles();
        if (supportRoles != null && !supportRoles.isEmpty()) {
            if (logger.isDebugEnabled()) {
                logger.debug("NoneProcessor authorized fail, due {} need role access", var.getTargetResource());
            }
            throw new UnauthorizedException("do not have the role access");
        }
    }
}
