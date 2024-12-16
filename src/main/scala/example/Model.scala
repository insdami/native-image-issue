package example

import io.circe.{Decoder, Encoder}
import io.circe.generic.semiauto.deriveDecoder
import io.circe.generic.semiauto.deriveEncoder

case class Model(name: String, lastName: String)

object Model {

  implicit val encoder: Encoder[Model] = deriveEncoder
  implicit val decoder: Decoder[Model] = deriveDecoder

}
