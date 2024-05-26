package dev.surganov.bladesapi.swagger

import com.github.swagger.pekko.SwaggerHttpService
import com.github.swagger.pekko.model.{Contact, Info, License}
import dev.surganov.bladesapi.playbooks.PlaybookService
import dev.surganov.bladesapi.util.config.ConfigProvider
import io.swagger.v3.oas.models.ExternalDocumentation

object SwaggerDocService extends SwaggerHttpService with ConfigProvider {
  override val apiClasses: Set[Class[_]] = Set(
    PlaybookService.getClass
  )
  override val host = s"${config.host}:${config.host}"
  override val info: Info = Info(
    description =
      "This project is an API for the game \"Blades in the Dark\". The API provides access to playbooks, abilities, crews, and other game-related data.",
    contact = Some(
      Contact(
        name = "Vlad Surganov",
        url = "https://www.linkedin.com/in/avsurganov/",
        email = "avsurganov@gmail.com"
      )
    ),
    license = Some(
      License(
        name = "Creative Commons Attribution 4.0 Unported License",
        url = "https://creativecommons.org/licenses/by/4.0/"
      )
    ),
    version = "0.1"
  )
  override val serverURLs: Seq[String] = Seq(config.url)

  override val externalDocs: Option[ExternalDocumentation] = Some(
    new ExternalDocumentation().description("GitHub").url("https://github.com/avsurganov/blade-portal-api")
  )
  //use io.swagger.v3.oas.models.security.SecurityScheme to document authn requirements for API
  //override val securitySchemeDefinitions = Map("basicAuth" -> new SecurityScheme())
  override val unwantedDefinitions: Seq[String] = Seq("Function1", "Function1RequestContextFutureRouteResult")
}
