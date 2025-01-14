/*
 * Copyright 2017-2020 original authors
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.micronaut.security.token.jwt.endpoints;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.micronaut.core.annotation.Introspected;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

/**
 * Encapsulate the request to get a new access token.
 *
 * @author Sergio del Amo
 * @since 1.0
 */
@Introspected
public class TokenRefreshRequest {

    public static final String GRANT_TYPE_REFRESH_TOKEN = "refresh_token";

    @NotBlank
    @Pattern(regexp = GRANT_TYPE_REFRESH_TOKEN)
    @JsonProperty("grant_type")
    private String grantType;

    @NotBlank
    @JsonProperty(GRANT_TYPE_REFRESH_TOKEN)
    private String refreshToken;

    /**
     * Used for JSON serialization.
     */
    public TokenRefreshRequest() { }

    /**
     *
     * @param refreshToken Refresh token
     */
    public TokenRefreshRequest(String refreshToken) {
        this.grantType = GRANT_TYPE_REFRESH_TOKEN;
        this.refreshToken = refreshToken;
    }

    /**
     * grantType getter.
     * @return e.g refresh_token
     */
    public String getGrantType() {
        return grantType;
    }

    /**
     * refreshToken getter.
     * @return e.g. XXXXX
     */
    public String getRefreshToken() {
        return refreshToken;
    }

}
