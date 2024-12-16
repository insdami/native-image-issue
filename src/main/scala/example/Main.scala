package example

import cats.effect.{ExitCode, IO}
import io.circe.parser
import com.monovore.decline.Opts
import com.monovore.decline.effect.CommandIOApp

object Main extends CommandIOApp(name = "native-image-issue", header = "Issue executing binary") {

  private val modelStr: Opts[String] = Opts.option[String]("model", "Json model")

  override def main: Opts[IO[ExitCode]] =
    modelStr.map(Greeting.greet(_).as(ExitCode.Success))
}

object Greeting {

  def greet(str: String): IO[Unit] =
    for {
      json  <- IO.fromEither(parser.parse(str))
      model <- IO.fromEither(json.as[Model])
      _     <- IO.println(s"Hi ${model.name} ${model.lastName}")
    } yield ()
}
