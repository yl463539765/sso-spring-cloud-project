package com.javashitang.autoconfigure.sso;

import com.javashitang.tool.OperStatus;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

/**
 * @author lilimin
 * @since 2020-05-30
 */
@Component
public class SsoServerClientFactory implements FallbackFactory<SsoServerClient> {

    @Override
    public SsoServerClient create(Throwable throwable) {
        return new SsoServerClient() {
            @Override
            public OperStatus login(String username, String password) {
                return OperStatus.newError("登陆失败");
            }

            @Override
            public OperStatus logout(String token) {
                return OperStatus.newError("登出失败");
            }

            @Override
            public OperStatus checkAuth(String token) {
                return OperStatus.newError("验证用户登陆信息失败");
            }
        };
    }
}
