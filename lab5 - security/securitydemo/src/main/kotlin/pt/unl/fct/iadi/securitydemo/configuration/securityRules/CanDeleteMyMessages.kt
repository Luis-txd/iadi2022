package pt.unl.fct.iadi.securitydemo.configuration.securityRules

import org.intellij.lang.annotations.Language
import org.springframework.security.access.prepost.PreAuthorize

@PreAuthorize(CanDeleteMyMessages.condition)
annotation class CanDeleteMyMessages {
    companion object {
        @Language("SpEL") //Sprint Expression Language -> used in configuarion of authentication
        const val condition = "hasRole('ADMIN') OR @mySecurityService.myMessage(principal,#id)"

        //have package for authentication (and have a bunch of classes, each for an authorization, one for each resource (package), and one for each operation on that resource)
    }
}
