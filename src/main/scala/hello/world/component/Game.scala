package hello.world.component


import slinky.core.StatelessComponent
import slinky.core.annotations.react
import slinky.core.facade.ReactElement
import slinky.web.html._

@react class Game() extends StatelessComponent {
  type Props = Unit

  def render(): ReactElement = {
    div(className := "game")(
      div(className := "game-board")(Board()),
      info()
    )
  }

  private def info(): ReactElement = {
    div(className := "game-info")(
      div(),
      ol()
    )
  }

}
