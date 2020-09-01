package hello.world.component

import slinky.core.StatelessComponent
import slinky.core.annotations.react
import slinky.core.facade.ReactElement
import slinky.web.html._


@react class Board() extends StatelessComponent {
  type Props = Unit

  private def renderSquare(index: Int): ReactElement = {
    Square(index)
  }

  def render(): ReactElement = {
    val status = "Next player: X"

    div()(
      div(className := "status")(status),
      div(className := "board-row")((0 to 2).map(renderSquare)),
      div(className := "board-row")((3 to 5).map(renderSquare)),
      div(className := "board-row")((6 to 8).map(renderSquare))
    )
  }
}