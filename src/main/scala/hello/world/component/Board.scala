package hello.world.component

import slinky.core.Component
import slinky.core.annotations.react
import slinky.core.facade.ReactElement
import slinky.web.html._


@react class Board() extends Component {
  type Props = Unit

  case class State(squares: Seq[Option[String]])

  def initialState: State = State(Seq.fill(9)(None))

  def render(): ReactElement = {
    val status = "Next player: X"

    div()(
      div(className := "status")(status),
      div(className := "board-row")((0 to 2).map(renderSquare)),
      div(className := "board-row")((3 to 5).map(renderSquare)),
      div(className := "board-row")((6 to 8).map(renderSquare))
    )
  }


  private def handleClick(index: Int): Unit = {
    val updatedSquare: Seq[Option[String]] = state.squares.updated(index, Some("X"))
    this.setState(State(updatedSquare))
  }

  private def renderSquare(index: Int): ReactElement = {
    Square(state.squares(index), () => handleClick(index))
  }
}