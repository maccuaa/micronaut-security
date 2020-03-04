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
package io.micronaut.docs.signandencrypt

import io.micronaut.context.annotation.Bean
import io.micronaut.context.annotation.Factory
import io.micronaut.context.annotation.Requires
import io.micronaut.context.env.Environment
import io.micronaut.security.token.jwt.signature.SignatureGeneratorConfiguration
import io.micronaut.security.token.jwt.signature.rsa.RSASignatureGenerator
import io.micronaut.security.token.jwt.signature.rsa.RSASignatureGeneratorConfiguration

import javax.inject.Named

@Requires(notEnv = Environment.TEST)
//tag::clazz[]
@Factory
class MySignatureGeneratorConfigurationFactory {
    @Bean
    @Named("generator") // <1>
    SignatureGeneratorConfiguration signatureGeneratorConfiguration(RSASignatureGeneratorConfiguration configuration) {// <2>
        return new RSASignatureGenerator(configuration)
    }
}
//end::clazz[]
